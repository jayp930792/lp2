
# Define a set of rules
rules = [
    {"color": "red", "shape": "circle", "label": "apple"},
    {"color": "green", "shape": "oval", "label": "pear"},
    {"color": "yellow", "shape": "oblong", "label": "banana"}
]

# Define a function to ask the user for features
def ask_features():
    features = {}
    print("Welcome to the fruit identification system. Please answer the following questions to help us identify the fruit.")
    color = input("What color is the fruit? ")
    features["color"] = color
    shape = input("What shape is the fruit? ")
    features["shape"] = shape
    return features

# Define a function to identify the fruit based on features
def identify(features):
    for rule in rules:
        if all(feature == rule[feature_type] for feature_type, feature in features.items()):
            return rule["label"]
    return "Unknown"

# Main program
if __name__ == "__main__":
    features = ask_features()
    label = identify(features)
    print(f"Based on the features you provided, the fruit is a {label}.")


