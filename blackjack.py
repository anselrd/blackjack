import random


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

    def __init__(self, index, suit):
        if suit not in self.valid_suits:
            raise CardSuitError(suit)
        elif index not in self.values.keys():
            raise CardIndexError(index)
        self.suit = suit
        self.index = index
        self.value = self.values[index]


class Deck(object):

    def __init__(self, cards=None):
        self.cards = cards
        self.shuffle_deck()

    def shuffle_deck(self):
        random.shuffle(self.cards)


class StandardDeck(Deck):
    cards = []
    for suit in ['s', 'h', 'c', 'd']:
        for index in ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'j', 'q', 'k', 'a']:
            cards.append(Card(index, suit))

    def __init__(self):
        super().__init__(self.cards)


class MultiDeck(Deck):

    def __init__(self, decks):
        self.cards = []
        for deck in decks:
            self.cards.append(deck.cards)
        self.shuffle_deck()


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
