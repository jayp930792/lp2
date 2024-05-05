import random

# Dictionary containing the bot's responses to user inputs
responses = {
    "hi": ["Hello! Welcome to our store.", "Hi there! How can I assist you today?", "Hey, how can I help you?"],
    "product inquiry": ["Which product are you interested in?", "Sure, which item would you like to know more about?", "Which product would you like to learn more about?"],
    "product availability": ["Let me check if that product is currently in stock.", "I'm not sure, would you like me to check if it's in stock?", "Give me a moment, I'll check if we have that product in stock."],
    "purchase": ["Great! Would you like to make a purchase now?", "Sure, would you like to buy that product now?", "Excellent choice! Would you like to make the purchase now?"],
    "thanks": ["You're welcome! Have a great day.", "No problem! Let me know if you need any further assistance.", "Anytime! Thank you for shopping with us."],
    "default": ["I'm sorry, I didn't understand what you meant. Can you please rephrase your question?", "I'm not sure what you're asking. Can you please clarify?", "I'm still learning and may not be able to answer that question. Sorry!"]
}

# Function to generate bot responses
def respond(user_input):
    if "hi" in user_input.lower():
        return random.choice(responses["hi"])
    elif "product" in user_input.lower() and "inquiry" in user_input.lower():
        return random.choice(responses["product inquiry"])
    elif "product" in user_input.lower() and "availability" in user_input.lower():
        return random.choice(responses["product availability"])
    elif "purchase" in user_input.lower():
        return random.choice(responses["purchase"])
    elif "thanks" in user_input.lower() or "thank you" in user_input.lower():
        return random.choice(responses["thanks"])
    else:
        return random.choice(responses["default"])

# Welcome message for the user
print("Hello! Welcome to our store. How can I assist you today?")

# Loop to continue the conversation with the user
while True:
    user_input = input("> ")
    if user_input.lower() == "exit":
        print("Goodbye! Thank you for visiting our store.")
        break
    else:
        bot_response = respond(user_input)
        print(bot_response)



