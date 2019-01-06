import random
import rulesets


class Card(object):
    valid_suits = ['s', 'h', 'c', 'd']
    values = {'2': 2,
              '3': 3,
              '4': 4,
              '5': 5,
              '6': 6,
              '7': 7,
              '8': 8,
              '9': 9,
              '10': 10,
              'j': 10,
              'q': 10,
              'k': 10,
              'a': [1, 11]}

    def __init__(self, index, suit, facedown=False):
        if suit not in self.valid_suits:
            raise CardSuitError(suit)
        elif index not in self.values.keys():
            raise CardIndexError(index)
        self.suit = suit
        self.index = index
        self.value = self.values[index]
        self.is_facedown = facedown

    def __eq__(self, other):
        if isinstance(other, Card):
            return self.index == other.index
        else:
            return False

class Deck(object):

    def __init__(self, cards=None):
        self.cards = cards
        self.shuffle_deck()

    def shuffle_deck(self):
        random.shuffle(self.cards)

    def deal(self, hand, plays_facedown=False):
        dealt_card = self.cards.pop()
        if plays_facedown:
            dealt_card.is_facedown = True
        hand.cards.append(dealt_card)


class StandardDeck(Deck):

    def __init__(self):
        cards = []
        for suit in ['s', 'h', 'c', 'd']:
            for index in ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'j', 'q', 'k', 'a']:
                cards.append(Card(index, suit))
        super().__init__(cards)


class MultiDeck(Deck):

    def __init__(self, decks):
        cards = []
        for deck in decks:
            cards.append(deck.cards)
        super().__init__(cards)


class Chip(object):

    def __init__(self, value):
        self.value = value


class Wallet(object):

    def __init__(self, chips):
        self.chips = chips
        self.total = self.sum_chips()

    def sum_chips(self):
        total = 0
        for chip in self.chips:
            total += chip.value
        return total

    def add_amount(self, amount):
        # figure out how to determine chip values
        pass

    def subtract_amount(self, amount):
        self.add_amount(-1 * amount)


class Person(object):

    def __init__(self, name, wallet):
        self.name = name
        self.wallet = wallet

    def pay(self, person, amount):
        if self.wallet.sum_chips() < amount:
            raise UnableToPayError
        self.wallet.subtract(amount)
        person.wallet.add(amount)


class Player(Person):
    # may not be necessary
    pass


class Dealer(Person):
    # may not be necessary
    pass


class Hand(object):

    cards = []

    def __init__(self, player):
        self.player = player

    def owner(self):
        return self.player

    def add_card(self, card):
        self.cards.append(card)


class Table(object):

    def __init__(self, dealer, players, ruleset=DealerStayAll17, max_hands=7):
        self.dealer = dealer
        self.players = players
        self.ruleset = ruleset
        self.max_hands = max_hands


class CardSuitError(Exception):

    def __init__(self, invalid_suit):
        if type(invalid_suit) is not str:
            print('Card suit must be a string. Got type ' + str(type(invalid_suit)))
        else:
            print("Suit '" + invalid_suit + "' not recognized. Suits must be one of 's', 'h', 'c', 'd'.")


class CardIndexError(Exception):

    def __init__(self, invalid_index):
        if type(invalid_index) is not str:
            print('Card index must be a string. Got type ' + str(type(invalid_index)))
        else:
            print("Suit '" + invalid_index + "' not recognized. Suits must be one of '1-10', 'j', 'q', 'k', 'a'.")


class UnableToPayError(Exception):

    def __init__(self, payer, payee, amount):
        print(payer + " cannot pay " + payee + " amount $" + amount + ". " + payer + " only has $" + payer.wallet.sum_chips())