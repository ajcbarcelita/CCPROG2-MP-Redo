import json

input_file = r"C:\Users\ajcba\Documents\CCPROG2-MP-Redo\Sample Data\sample.txt" # Replace with your file path
output_file = r"C:\Users\ajcba\Documents\CCPROG2-MP-Redo\Sample Data\sample.json"  # Replace with your desired output file path

objects = []
current_object = {}

with open(input_file, 'r') as file:
    for line in file:
        line = line.strip()
        if not line:
            continue
        if line.startswith("Object:"):
            # Save the previous object if it exists
            if current_object:
                objects.append(current_object)
            # Start a new object
            current_object = {"Object": line.split(":", 1)[1].strip()}
        else:
            key, value = line.split(":", 1)
            current_object[key.strip()] = value.strip()

    # Save the last object if it exists
    if current_object:
        objects.append(current_object)

with open(output_file, 'w') as json_file:
    json.dump(objects, json_file, indent=4)

print(f"Data has been successfully converted to {output_file}")
