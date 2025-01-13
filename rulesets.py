
class RuleSet(object):

    valid_cards = {'2': 2,
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

    def get_ace_rule(self, card, dealer_upcard):
        pass

    def get_double_rule(self, card, dealer_upcard):
        pass

    def get_rule(self, cards):
        if len(cards) == 2:

            if cards[0] == cards[1]:
                self.get_double_rule(cards[0])
            elif cards[0] == 'a' or cards[1] == 'a'


class SingleDeck(RuleSet):
    pass
