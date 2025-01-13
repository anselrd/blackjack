from enum import Enum, auto


class CardIndex(Enum):
    ACE = auto()
    JACK = auto()
    QUEEN = auto()
    KING = auto()

class CardSuit(Enum):
    SPADES = auto()
    HEARTS = auto()
    CLUBS = auto()
    DIAMONDS = auto()