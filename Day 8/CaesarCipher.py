from art import logo
characters = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '9', '8', '7', '6', '5', '4', '3', '2', '1', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '[', ']', '{', '}', ';', ':', ',', '.', '/', '?']

def caesar(direction, text, shift):
  new_text = []
  if direction == 'decode':
    shift *= -1
  for letter in text:
    if letter not in characters:
      new_text.append(str(letter))
    else:
      new_text.append(characters[(characters.index(letter) + shift) % len(characters)])
  print(f'The {direction}d message is {"".join(new_text)}\n')

print(logo)
while True:
  
    direction = input("Type 'encode' to encrypt, type 'decode' to decrypt:\n").lower()
    if direction in ["encode", "decode"]:
        break  # Exit the loop if the input is valid
    else:
        print("Invalid input. Please type 'encode' or 'decode'.")

text = input("Type your message:\n").lower()

while True:
    try:
        shift = int(input("Type the shift number:\n"))
        break  # Exit the loop if input is valid
    except ValueError:
        print("Invalid input. Please enter an integer.")

caesar(direction=direction, text=text, shift=shift)
restart = input("Type 'yes' if you want to use the tool again. Otherwise type 'no'.\n")
if restart == 'no':
    quit
