import random

pieces = ["rock", "paper", "scissors"]

print("Rock, Paper, Scissors Game")
print("==========================")

userInput = input("Rock, paper, scissors...shoot! (make your choice) ")
computerInput = random.choice(pieces)

if userInput.lower() == computerInput:
    print(f'You chose {userInput}')
    print(f'The computer chose {computerInput}')
    print("It is a tie!")
elif userInput.lower() == "rock":
    if computerInput == "paper":
        print(f'You chose {userInput}')
        print(f'The computer chose {computerInput}')
        print("You lose!")
    else:
        print(f'You chose {userInput}')
        print(f'The computer chose {computerInput}')
        print("You win!")
elif userInput.lower() == "paper":
    if computerInput == "scissors":
        print(f'You chose {userInput}')
        print(f'The computer chose {computerInput}')
        print("You lose!")
    else:
        print(f'You chose {userInput}')
        print(f'The computer chose {computerInput}')
        print("You win!")
elif userInput.lower() == "scissors":
    if computerInput == "rock":
        print(f'You chose {userInput}')
        print(f'The computer chose {computerInput}')
        print("You lose!")
    else:
        print(f'You chose {userInput}')
        print(f'The computer chose {computerInput}')
        print("You win!")