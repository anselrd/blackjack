class Card(object):
    
    valid_suits = ['s','h','c','d']
    values = {'2':  2,
              '3':  3,
              '4':  4,
              '5':  5,
              '6':  6,
              '7':  7,
              '8':  8,
              '9':  9,
              '10': 10,
              'j':  10,
              'q':  10,
              'k':  10,
              'a':  [1,11]}
    
    def __init__(self, index, suit):
        if suit not in valid_suits:
            raise SuitErrorException()
        elif index not in values.keys():
            raise IndexErrorException()
        self.suit = suit
        self.index = index
        self.value = values[index]


class Deck(object):
    
    def __init__(self, cards=None):
        # some code here i guess i mean w/e
