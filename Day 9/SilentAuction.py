import os
import platform

BID_DICTIONARY = {}


def print_winner(bids):
    # Returns the winner's name and bid amount
    return f'{bids[max(bids.keys())]} won the bid with a bid of: {max(bids.keys())}'

def accept_bids(bid_book):
    # Collect the bidder's name
    while True:
        name = str(input("Enter your name: ").title())
        if len(name) <= 0:
            print("Please enter a name.")
        else: 
            break

    # Validate that the bid amount is a proper full number dollar amount
    while True:
        try:
            bid = int(input("Enter your bid: "))
            if bid in bid_book:
                print(f'Bid of {bid} already exists. Please enter a new bid.')
                continue
            break
        except ValueError:
            print("Invalid Input. Please enter a proper dollar amount.")
    
    # Add the bidder's ID and bid amount to a dictionary
    bid_book.update({bid: name})

def ask_for_more_bidders():
    while True:
        end_auction = input("Are there any other bidders? (Yes or No) ").lower()
        if end_auction not in ['yes', 'no']:
            print("Invalid response. Please confirm if there are any additional bidders.")
        elif end_auction == 'yes':
            # Clear screen
            if platform.system() == "Windows":
                os.system('cls')
            else:
                os.system('clear')
            return True
        elif end_auction == 'no':
            # Clear screen
            if platform.system() == "Windows":
                os.system('cls')
            else:
                os.system('clear')
            return False

def main():
    print("Welcome to the Silent Auction")
    bidding = True
    while bidding:
        accept_bids(BID_DICTIONARY)
        bidding = ask_for_more_bidders()
    
    # Check if there are any bids before announcing the winner
    if BID_DICTIONARY:
        print(print_winner(BID_DICTIONARY))
    else:
        print("No bids were placed. The auction has ended without a winner.")

# Call the main function when the script is executed
if __name__ == "__main__":
    main()
