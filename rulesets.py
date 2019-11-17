
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


class SingleDeck(RuleSet):
    pass
