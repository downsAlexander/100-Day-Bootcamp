# Tip calculator - Day 2

#function to calculate the tip
def calcTip(totalBill, serviceLevel, groupSize):
    if serviceLevel == "poor":
      tipPercent = .1
    elif serviceLevel == "standard":
       tipPercent = .2
    elif serviceLevel == "exceptional":
       tipPercent = .25
    else:
        tipPercent = .15 

    return (totalBill*tipPercent) / groupSize



print("==============================")
print("Welcome to the tip calculator!")
print("==============================")

#gathering user input
totalBill = float(input("What was the total bill amount?\n"))
serviceLevel = input("How would you rate the level of service? (poor, standard, exceptional)\n").lower()
groupSize = int(input("How many people were in your party?\n"))

#printing out the tip amount
print(f'Your share of the tip is: ${round(calcTip(totalBill, serviceLevel, groupSize),2)}')
