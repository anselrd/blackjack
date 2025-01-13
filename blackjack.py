import argparse
import random
import time
from enum import Enum, auto


class Suit(Enum):
    HEARTS = auto()
    DIAMONDS = auto()
    CLUBS = auto()
    SPADES = auto()


class Rank(Enum):
    ACE = auto()
    TWO = auto()
    THREE = auto()
    FOUR = auto()
    FIVE = auto()
    SIX = auto()
    SEVEN = auto()
    EIGHT = auto()
    NINE = auto()
    TEN = auto()
    JACK = auto()
    QUEEN = auto()
    KING = auto()


class Card:
    HIGH = [Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING, Rank.ACE]
    LOW = [Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX]
    SYMBOLS = {
        Suit.CLUBS: '\u2663',
        Suit.HEARTS: '\u2665',
        Suit.SPADES: '\u2660',
        Suit.DIAMONDS: '\u2666'
    }
    SHORTHANDS = {
        Rank.ACE: 'A',
        Rank.TWO: '2',
        Rank.THREE: '3',
        Rank.FOUR: '4',
        Rank.FIVE: '5',
        Rank.SIX: '6',
        Rank.SEVEN: '7',
        Rank.EIGHT: '8',
        Rank.NINE: '9',
        Rank.TEN: '10',
        Rank.JACK: 'J',
        Rank.QUEEN: 'Q',
        Rank.KING: 'K'
    }

    def __init__(self, rank: Rank, suit: Suit):
        self.rank = rank
        self.suit = suit

    def __repr__(self):
        return f'{self.SHORTHANDS[self.rank]}{self.SYMBOLS[self.suit]}'

    @property
    def value(self):
        if self.rank == Rank.ACE:
            return 0
        elif self.rank in [Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING]:
            return 10
        elif self.rank == Rank.TWO:
            return 2
        elif self.rank == Rank.THREE:
            return 3
        elif self.rank == Rank.FOUR:
            return 4
        elif self.rank == Rank.FIVE:
            return 5
        elif self.rank == Rank.SIX:
            return 6
        elif self.rank == Rank.SEVEN:
            return 7
        elif self.rank == Rank.EIGHT:
            return 8
        elif self.rank == Rank.NINE:
            return 9

    @property
    def count(self):
        if self.rank in self.HIGH:
            return -1
        elif self.rank in self.LOW:
            return 1
        return 0

    @classmethod
    def random(cls):
        r = random.choice(list(Rank))
        s = random.choice(list(Suit))
        return cls(r, s)

    @classmethod
    def random_by_value(cls):
        r = random.choice([rr for rr in list(Rank) if rr not in [Rank.JACK, Rank.QUEEN, Rank.KING]])
        if r == Rank.TEN:
            r = random.choice([Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING])
        s = random.choice(list(Suit))
        return cls(r, s)


class Deck:
    def __init__(self):
        self.cards = [Card(r, s) for s in Suit for r in Rank]


class Shoe:
    def __init__(self, n, shuffled=True):
        self.cards = [c for d in [Deck() for _ in range(n)] for c in d.cards]
        if shuffled:
            self.shuffle()

    def __len__(self):
        return len(self.cards)

    def shuffle(self):
        random.shuffle(self.cards)

    def deal(self):
        return self.cards.pop()

    @property
    def count(self):
        return -1*sum(c.count for c in self.cards)


def train_counting(num_decks, cards_per_deal):
    finished = False
    while not finished:
        shoe = Shoe(num_decks)
        while shoe.cards:
            for _ in range(min(cards_per_deal, len(shoe))):
                print(shoe.deal())
            answer = input('Show count? (y/n) [n]: ')
            if answer.lower().startswith('y'):
                color = '\033[1m' if shoe.count == 0 else ('\033[92m' if shoe.count > 0 else '\033[91m')
                print('-------> ', color, '+' if shoe.count > 0 else '', shoe.count, '\033[0m', ' <--------', sep='')
        finished = not input('Play again? (y/n) [n]: ').lower().startswith('y')


def train_strategy(das=True, categories='hsp'):

    hard_strategy = {
        (17, Rank.TWO): 's',
        (17, Rank.THREE): 's',
        (17, Rank.FOUR): 's',
        (17, Rank.FIVE): 's',
        (17, Rank.SIX): 's',
        (17, Rank.SEVEN): 's',
        (17, Rank.EIGHT): 's',
        (17, Rank.NINE): 's',
        (17, Rank.TEN): 's',
        (17, Rank.JACK): 's',
        (17, Rank.QUEEN): 's',
        (17, Rank.KING): 's',
        (17, Rank.ACE): 's',
        (16, Rank.TWO): 's',
        (16, Rank.THREE): 's',
        (16, Rank.FOUR): 's',
        (16, Rank.FIVE): 's',
        (16, Rank.SIX): 's',
        (16, Rank.SEVEN): 'h',
        (16, Rank.EIGHT): 'h',
        (16, Rank.NINE): 'h',
        (16, Rank.TEN): 'h',
        (16, Rank.JACK): 'h',
        (16, Rank.QUEEN): 'h',
        (16, Rank.KING): 'h',
        (16, Rank.ACE): 'h',
        (15, Rank.TWO): 's',
        (15, Rank.THREE): 's',
        (15, Rank.FOUR): 's',
        (15, Rank.FIVE): 's',
        (15, Rank.SIX): 's',
        (15, Rank.SEVEN): 'h',
        (15, Rank.EIGHT): 'h',
        (15, Rank.NINE): 'h',
        (15, Rank.TEN): 'h',
        (15, Rank.JACK): 'h',
        (15, Rank.QUEEN): 'h',
        (15, Rank.KING): 'h',
        (15, Rank.ACE): 'h',
        (14, Rank.TWO): 's',
        (14, Rank.THREE): 's',
        (14, Rank.FOUR): 's',
        (14, Rank.FIVE): 's',
        (14, Rank.SIX): 's',
        (14, Rank.SEVEN): 'h',
        (14, Rank.EIGHT): 'h',
        (14, Rank.NINE): 'h',
        (14, Rank.TEN): 'h',
        (14, Rank.JACK): 'h',
        (14, Rank.QUEEN): 'h',
        (14, Rank.KING): 'h',
        (14, Rank.ACE): 'h',
        (13, Rank.TWO): 's',
        (13, Rank.THREE): 's',
        (13, Rank.FOUR): 's',
        (13, Rank.FIVE): 's',
        (13, Rank.SIX): 's',
        (13, Rank.SEVEN): 'h',
        (13, Rank.EIGHT): 'h',
        (13, Rank.NINE): 'h',
        (13, Rank.TEN): 'h',
        (13, Rank.JACK): 'h',
        (13, Rank.QUEEN): 'h',
        (13, Rank.KING): 'h',
        (13, Rank.ACE): 'h',
        (12, Rank.TWO): 'h',
        (12, Rank.THREE): 'h',
        (12, Rank.FOUR): 's',
        (12, Rank.FIVE): 's',
        (12, Rank.SIX): 's',
        (12, Rank.SEVEN): 'h',
        (12, Rank.EIGHT): 'h',
        (12, Rank.NINE): 'h',
        (12, Rank.TEN): 'h',
        (12, Rank.JACK): 'h',
        (12, Rank.QUEEN): 'h',
        (12, Rank.KING): 'h',
        (12, Rank.ACE): 'h',
        (11, Rank.TWO): 'd',
        (11, Rank.THREE): 'd',
        (11, Rank.FOUR): 'd',
        (11, Rank.FIVE): 'd',
        (11, Rank.SIX): 'd',
        (11, Rank.SEVEN): 'd',
        (11, Rank.EIGHT): 'd',
        (11, Rank.NINE): 'd',
        (11, Rank.TEN): 'd',
        (11, Rank.JACK): 'd',
        (11, Rank.QUEEN): 'd',
        (11, Rank.KING): 'd',
        (11, Rank.ACE): 'd',
        (10, Rank.TWO): 'd',
        (10, Rank.THREE): 'd',
        (10, Rank.FOUR): 'd',
        (10, Rank.FIVE): 'd',
        (10, Rank.SIX): 'd',
        (10, Rank.SEVEN): 'd',
        (10, Rank.EIGHT): 'd',
        (10, Rank.NINE): 'd',
        (10, Rank.TEN): 'h',
        (10, Rank.JACK): 'h',
        (10, Rank.QUEEN): 'h',
        (10, Rank.KING): 'h',
        (10, Rank.ACE): 'h',
        (9, Rank.TWO): 'h',
        (9, Rank.THREE): 'd',
        (9, Rank.FOUR): 'd',
        (9, Rank.FIVE): 'd',
        (9, Rank.SIX): 'd',
        (9, Rank.SEVEN): 'h',
        (9, Rank.EIGHT): 'h',
        (9, Rank.NINE): 'h',
        (9, Rank.TEN): 'h',
        (9, Rank.JACK): 'h',
        (9, Rank.QUEEN): 'h',
        (9, Rank.KING): 'h',
        (9, Rank.ACE): 'h',
        (8, Rank.TWO): 'h',
        (8, Rank.THREE): 'h',
        (8, Rank.FOUR): 'h',
        (8, Rank.FIVE): 'h',
        (8, Rank.SIX): 'h',
        (8, Rank.SEVEN): 'h',
        (8, Rank.EIGHT): 'h',
        (8, Rank.NINE): 'h',
        (8, Rank.TEN): 'h',
        (8, Rank.JACK): 'h',
        (8, Rank.QUEEN): 'h',
        (8, Rank.KING): 'h',
        (8, Rank.ACE): 'h'
    }
    split_strategy = {
        Rank.ACE: {r: True for r in Rank},
        Rank.KING: {r: False for r in Rank},
        Rank.QUEEN: {r: False for r in Rank},
        Rank.JACK: {r: False for r in Rank},
        Rank.TEN: {r: False for r in Rank},
        Rank.NINE: {
            Rank.TWO: True,
            Rank.THREE: True,
            Rank.FOUR: True,
            Rank.FIVE: True,
            Rank.SIX: True,
            Rank.SEVEN: False,
            Rank.EIGHT: True,
            Rank.NINE: True,
            Rank.TEN: False,
            Rank.JACK: False,
            Rank.QUEEN: False,
            Rank.KING: False,
            Rank.ACE: False
        },
        Rank.EIGHT: {r: True for r in Rank},
        Rank.SEVEN: {
            Rank.TWO: True,
            Rank.THREE: True,
            Rank.FOUR: True,
            Rank.FIVE: True,
            Rank.SIX: True,
            Rank.SEVEN: True,
            Rank.EIGHT: False,
            Rank.NINE: False,
            Rank.TEN: False,
            Rank.JACK: False,
            Rank.QUEEN: False,
            Rank.KING: False,
            Rank.ACE: False
        },
        Rank.SIX: {
            Rank.TWO: das,
            Rank.THREE: True,
            Rank.FOUR: True,
            Rank.FIVE: True,
            Rank.SIX: True,
            Rank.SEVEN: False,
            Rank.EIGHT: False,
            Rank.NINE: False,
            Rank.TEN: False,
            Rank.JACK: False,
            Rank.QUEEN: False,
            Rank.KING: False,
            Rank.ACE: False
        },
        Rank.FIVE: {r: False for r in Rank},
        Rank.FOUR: {r: (das if r in [Rank.FIVE, Rank.SIX] else False) for r in Rank},
        Rank.THREE: {
            Rank.TWO: das,
            Rank.THREE: das,
            Rank.FOUR: True,
            Rank.FIVE: True,
            Rank.SIX: True,
            Rank.SEVEN: True,
            Rank.EIGHT: False,
            Rank.NINE: False,
            Rank.TEN: False,
            Rank.JACK: False,
            Rank.QUEEN: False,
            Rank.KING: False,
            Rank.ACE: False
        },
        Rank.TWO: {
            Rank.TWO: das,
            Rank.THREE: das,
            Rank.FOUR: True,
            Rank.FIVE: True,
            Rank.SIX: True,
            Rank.SEVEN: True,
            Rank.EIGHT: False,
            Rank.NINE: False,
            Rank.TEN: False,
            Rank.JACK: False,
            Rank.QUEEN: False,
            Rank.KING: False,
            Rank.ACE: False
        },
    }
    soft_strategy = {
        Rank.NINE: {r: 's' for r in Rank},
        Rank.EIGHT: {r: 'd' if r == Rank.SIX else 's' for r in Rank},
        Rank.SEVEN: {
            Rank.TWO: 'd',
            Rank.THREE: 'd',
            Rank.FOUR: 'd',
            Rank.FIVE: 'd',
            Rank.SIX: 'd',
            Rank.SEVEN: 's',
            Rank.EIGHT: 's',
            Rank.NINE: 'h',
            Rank.TEN: 'h',
            Rank.JACK: 'h',
            Rank.QUEEN: 'h',
            Rank.KING: 'h',
            Rank.ACE: 'h'
        },
        Rank.SIX: {
            Rank.TWO: 'h',
            Rank.THREE: 'd',
            Rank.FOUR: 'd',
            Rank.FIVE: 'd',
            Rank.SIX: 'd',
            Rank.SEVEN: 'h',
            Rank.EIGHT: 'h',
            Rank.NINE: 'h',
            Rank.TEN: 'h',
            Rank.JACK: 'h',
            Rank.QUEEN: 'h',
            Rank.KING: 'h',
            Rank.ACE: 'h'
        },
        Rank.FIVE: {
            Rank.TWO: 'h',
            Rank.THREE: 'h',
            Rank.FOUR: 'd',
            Rank.FIVE: 'd',
            Rank.SIX: 'd',
            Rank.SEVEN: 'h',
            Rank.EIGHT: 'h',
            Rank.NINE: 'h',
            Rank.TEN: 'h',
            Rank.JACK: 'h',
            Rank.QUEEN: 'h',
            Rank.KING: 'h',
            Rank.ACE: 'h'
        },
        Rank.FOUR: {
            Rank.TWO: 'h',
            Rank.THREE: 'h',
            Rank.FOUR: 'd',
            Rank.FIVE: 'd',
            Rank.SIX: 'd',
            Rank.SEVEN: 'h',
            Rank.EIGHT: 'h',
            Rank.NINE: 'h',
            Rank.TEN: 'h',
            Rank.JACK: 'h',
            Rank.QUEEN: 'h',
            Rank.KING: 'h',
            Rank.ACE: 'h'
        },
        Rank.THREE: {
            Rank.TWO: 'h',
            Rank.THREE: 'h',
            Rank.FOUR: 'h',
            Rank.FIVE: 'd',
            Rank.SIX: 'd',
            Rank.SEVEN: 'h',
            Rank.EIGHT: 'h',
            Rank.NINE: 'h',
            Rank.TEN: 'h',
            Rank.JACK: 'h',
            Rank.QUEEN: 'h',
            Rank.KING: 'h',
            Rank.ACE: 'h'
        },
        Rank.TWO: {
            Rank.TWO: 'h',
            Rank.THREE: 'h',
            Rank.FOUR: 'h',
            Rank.FIVE: 'd',
            Rank.SIX: 'd',
            Rank.SEVEN: 'h',
            Rank.EIGHT: 'h',
            Rank.NINE: 'h',
            Rank.TEN: 'h',
            Rank.JACK: 'h',
            Rank.QUEEN: 'h',
            Rank.KING: 'h',
            Rank.ACE: 'h'
        }
    }

    finished = False
    prev_values = (-1, -1)
    input_times = []
    streak = 0
    max_streak = 0
    num_correct = 0
    while not finished:
        hand = (Card.random_by_value(), Card.random_by_value())
        splittable = hand[0].rank == hand[1].rank
        soft = hand[0].rank == Rank.ACE or hand[1].rank == Rank.ACE
        hard = not soft and not splittable
        total = hand[0].value + hand[1].value
        dealer = Card.random_by_value()

        if soft and total == 10:
            continue
        elif hard and total > 16 or total < 9:
            continue
        elif splittable and 'p' not in categories:
            continue
        elif soft and 's' not in categories:
            continue
        elif hard and 'h' not in categories:
            continue
        elif (total, dealer.value) == prev_values:
            continue


        print(dealer, 'vs', hand, sep='\n')

        prev_values = (total, dealer.value)
        while True:
            start = time.time()
            move = input('[S]tand, [H]it, [D]ouble, S[P]lit, [Q]uit: ').lower().strip()
            if move == 'q':
                finished = True
                break
            if move not in ['s', 'h', 'd', 'p']:
                print('Invalid selection. Enter one of "S", "H", "D", or "P".')
                continue
            input_times.append(time.time() - start)
            break

        if move == 'q':
            break
        if hard:
            if total < 8:
                correct_move = 'h'
            elif total > 17:
                correct_move = 's'
            else:
                correct_move = hard_strategy[(total, dealer.rank)]
        elif splittable:
            split = split_strategy[hand[0].rank][dealer.rank]
            correct_move = 'p' if split else hard_strategy[(total, dealer.rank)]
        else:
            non_ace = hand[0] if hand[1].rank == Rank.ACE else hand[1]
            correct_move = soft_strategy[non_ace.rank][dealer.rank]
        correct = move == correct_move
        correct_str = dict(s='stand', h='hit', p='split', d='double').get(correct_move)
        if correct:
            streak += 1
            max_streak = max((max_streak, streak))
            num_correct += 1
            msg = 'Correct!'
            colored_msg = f'\033[92m{msg}\033[0m'
        else:
            streak = 0
            msg = f'Incorrect. The correct strategy was to {correct_str}.'
            colored_msg = f'\033[91m{msg}\033[0m'
        print(colored_msg)

    if len(input_times) == 0:
        return
    print(f'Streak: {max_streak} correct responses')
    print(f'Score: {num_correct}/{len(input_times)} ({100*num_correct/len(input_times):.1f}%)')
    print(f'Average response time: {sum(input_times)/len(input_times):.02f}s')
    if len(input_times) > 1:
        print(f'Average without worst: {(sum(input_times) - max(input_times))/(len(input_times) - 1):.02f}s')
    print(f'Best response time: {min(input_times):.02f}s')
    print(f'Worst response time: {max(input_times):.02f}s')


def parse_args():
    parser = argparse.ArgumentParser()
    command = parser.add_subparsers(dest='command')
    count = command.add_parser('count')
    count.add_argument('-d', '--num-decks', type=int, default=2)
    count.add_argument('-c', '--num-cards', type=int, default=2)
    strategy = command.add_parser('strategy')
    strategy.add_argument('-d', '--double-after-split', action='store_true')
    strategy.add_argument('-c', '--categories', default='hsp')
    return parser.parse_args()


def main():
    args = parse_args()
    if args.command == 'count':
        train_counting(args.num_decks, args.num_cards)
    elif args.command == 'strategy':
        train_strategy(args.double_after_split, args.categories.lower())

if __name__ == '__main__':
    main()
