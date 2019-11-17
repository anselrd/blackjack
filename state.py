class State(object):
    """A State holds a current game state.py and all of its attributes"""

    def __init__(self):
        """Create a new gamestate"""
        self.gs = {}

    def get_state(self, key=None):
        if key:
            return self.gs[key]
        return self.gs

    def update_state(self, key, val):
        self.gs[key] = val
