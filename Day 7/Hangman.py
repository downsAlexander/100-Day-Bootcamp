import random

def select_random_word(words):
    chosen_word = random.choice(words)
    return chosen_word

def get_user_guess(letters_guessed):
    while True:
        guess = input("Guess a letter: ").lower()
        if guess not in letters_guessed:
            return guess
        else:
            print(f'*****Already tried that {guess}. Pick another letter.*****\n')

def update_display(chosen_word, correct_letters):
    new_display = ""
    for letter in chosen_word:
        if letter in correct_letters:  # Check if letter is in correct letters
            new_display += letter
        else:
            new_display += "_"
    return new_display



words = ["aardvark", "camel", "hedgehog"]
stages = [''' 
  +---+
  |   |
  O   |
 /|\  |
 / \  |
      |
=======
''', '''
  +---+
  |   |
  O   |
 /|\  |
 /    |
      |
=======
''', '''
  +---+
  |   |
  O   |
 /|\  |
      |
      |
=======
''', '''
  +---+
  |   |
  O   |
 /|   |
      |
      |
=======
''', '''
  +---+
  |   |
  O   |
  |   |
      |
      |
=======
''', '''
  +---+
  |   |
  O   |
      |
      |
      |
=======
''', '''
  +---+
  |   |
      |
      |
      |
      |
=======
''']
gameOver = False
correct_letters = []
letters_guessed = []
lives = 6
chosen_word = select_random_word(words)
display = "_" * len(chosen_word)


print("Welcome to Hangman!")

while not gameOver:
    print(f'*********************You have {lives}/6 lives left*********************')
    print(letters_guessed)
    print(stages[lives])
    print(display)
    guess = get_user_guess(letters_guessed)
    if guess in letters_guessed:
        print(f'You already guessed: {guess}')
        continue
    letters_guessed.append(guess)


    if guess in chosen_word:
        correct_letters.append(guess)
        display = update_display(chosen_word, correct_letters)
    else:
        lives -= 1
        if lives == 0:
            print(stages[0])
            print("You lose! The word was:", chosen_word)
            gameOver = True

    
    if "_" not in display:
        print(f'The word was {chosen_word}, good job.')
        print("**************************You win**************************")
        gameOver = True
