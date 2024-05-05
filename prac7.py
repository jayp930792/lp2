# Declare a string
string = "Hello World"

# Iterate through each character in the string
for char in string:
    # XOR each character with 127
    xor_result = ord(char) ^ 127
    # AND each character with 127
    and_result = ord(char) & 127
    # Print the results
    print("XOR result for", char, "is", xor_result)
    print("AND result for", char, "is", and_result)
