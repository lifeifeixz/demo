from ch1213.People import People


class User(People):
    def __init__(self, name, age, ads):
        self.name = name
        self.age = age
        self.address = ads

    def show(self):
        print(self.name)
        print(self.age)
        print(self.address)

    def setColor(self, c):
        self.color = c

    def say(self):
        print("my color is:", self.color)
