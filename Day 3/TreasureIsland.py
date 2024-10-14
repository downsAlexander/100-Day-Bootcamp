
print("=============================================================\n")
print("Welcome to treasure island, a choose your own adventure game!\n")
print("=============================================================\n")
print("Your mission is to find the treasure.\n\n")

fork = input("You start at a fork in the road, left or right?\n").lower()

if fork == "left":
    print("Spike pit. Of course pirates boobytrap their treasure.")
    print("Game over.")
else:
    print("You keep moving forward and reach a river spanned by an old bridge. 50/50 chance it collapses from your estimation.")
    bridge = input("Do you risk the bridge or try to swim across? (bridge or swim)\n").lower()
    if bridge == "swim":
        print("There were alligators in the water. There's always gators in the water.")
        print("Game over.")
    else:
        print("You decide to go for the bridge. Who knows what lurks below the surface of the water.")
        print("The bridge holds up. You make it across.")
        print("After a while, you come up to an odd sight.")
        print("There are three doors embedded into the face of a rock wall. The doors are numbered: 4, 7, and 42.")
        door = int(input("Which do you choose?\n"))
        if door == 42:
            print("You found the treasure! You win!")
        else:
            print("More boobytraps. Use your imagination.")
            print("Game over.")

