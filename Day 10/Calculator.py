def add(n1, n2):
    return n1 + n2

def subtract(n1, n2):
    return n1 - n2

def multiply(n1, n2):
    return n1 * n2

def divide(n1, n2):
    return n1 / n2

def get_number(prompt):
    while True:
        try:
            return int(input(prompt))
        except ValueError:
            print("Invalid input. Please enter an integer.")

def get_operation():
    while True:
        print("""Pick an operation:
            +
            -
            *
            /""")
        ops = input("").strip()
        if ops in ['+', '-', '*', '/']:
            return ops
        else:
            print("Invalid operation. Please choose one of the following: +, -, *, /")

def calc_result(n1, n2, ops):
    if ops == "+":
        return add(n1, n2)
    elif ops == "-":
        return subtract(n1, n2)
    elif ops == "*":
        return multiply(n1, n2)
    elif ops == "/":
        if n2 == 0:
            print("Error: Division by zero is not allowed.")
            return None
        return divide(n1, n2)
    
n1 = get_number("What's the first number? ")
while True:
    
    n2 = get_number("What's the second number? ")
    ops = get_operation()

    n3 = calc_result(n1, n2, ops)
    if n3 is not None:
        print(n1, ops, n2, "=", n3)

    cont = input('Type "y" to continue calculating, or type "n" to exit: ').lower().strip()
    n1 = n3
    if cont != 'y':
        break