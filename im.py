rules=[
    {
     "color":"red", "shape":"circle","Label": "apple"},
    { "color":"green", "shape": "oval", "label": "pear"} ,
    {"color":"yellow","shape": "oblong","label":"banana"}     
]
features = ()
print("Welcome to fruit identification system.Please answer the following questions to help us identify the fruit.")
color = input("What is the color of the fruit?") features["color"] = color
shape = input("What is the shape of the fruit?") features["shape"] = shape
return features
for rule in rules:
    if all(feature == rule[feature_type] for feature_type, feature_in
    features.items()):
        return rule["label"] return "Unknown"
    if name =="main":
        features = ask_features() label = identify(features)
        print("Based on the features you provided, the fruit is {label}.")
    