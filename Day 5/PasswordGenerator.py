import random

letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
           'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
numbers = ['0', '9', '8', '7', '6', '5', '4', '3', '2', '1']
symbols = ['!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[', ']', '{', '}', ';', ':', ',', '.', '/', '?']

print("Welcome to the PyPassword Generator!")
nr_letters= int(input("How many letters would you like in your password?\n")) 
nr_symbols = int(input(f"How many symbols would you like?\n"))
nr_numbers = int(input(f"How many numbers would you like?\n"))

pw_charList = []

for n in range(nr_letters):
    pw_charList.append(random.choice(letters))

for n in range(nr_symbols):
    pw_charList.append(random.choice(symbols))

for n in range(nr_numbers):
    pw_charList.append(random.choice(numbers))

random.shuffle(pw_charList)
print("".join(pw_charList))
