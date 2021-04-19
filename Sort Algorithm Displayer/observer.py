class Observer(object):
    def notify(self, *args, **kwargs):
        print(args,kwargs)
        # UPDATE function to change view


class Target(object):
    def __init__(self, *observers):
        self.observes = observers

    # this notify for every access to the function
    def event(self, data):
        for obs in self.observes:
            obs.notify('event', data)
        print("notified of", data)
