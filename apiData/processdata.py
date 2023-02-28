import json

files = range(1,49)
new_json = []

for file in files:
    
    file_object = open(f'page{file}pro.json', 'r')
    file_json = json.load(file_object)
    products = file_json.get('products')
    
    for product in products:
        if 'nutriments' in product:
            new_product = {
                'carbs': product['nutriments'].get('carbohydrates_100g', 0),
                'sugars': product['nutriments'].get('sugars_100g', 0),
                'protein': product['nutriments'].get('proteins_100g', 0),
                'fat': product['nutriments'].get('fat_100g', 0),
                'calories': product['nutriments'].get('energy-kcal_100g', 0),
                'barcode': product['_id'],
                'name': product.get("product_name", 0)
            }
            
            new_json.append(new_product)

with open('all-products.json', 'w', encoding='utf-8') as new_file:
    json.dump(new_json, new_file, ensure_ascii=False, indent=4)