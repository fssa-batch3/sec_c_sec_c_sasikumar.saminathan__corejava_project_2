# sec_c_sec_c_sasikumar.saminathan__corejava_project_2

## Products

| Column Name      | Data Type         | Constraints           |
|------------------|-------------------|-----------------------|
| product_id       | INT               | NOT NULL, AUTO_INCREMENT |
| product_name     | VARCHAR(100)      | NOT NULL, UNIQUE     |
| product_price    | VARCHAR(100)      | NOT NULL             |
| product_ram      | INT               | NOT NULL             |
| product_storage  | INT               | NOT NULL             |
| product_highlights | VARCHAR(400)     | NOT NULL             |
| product_quantity | INT               | NOT NULL             |
| product_brand    | VARCHAR(100)      | NOT NULL             |
| PRIMARY KEY     | (product_id)      |                       |

## Image_urls

| Column Name | Data Type | Constraints                       |
|-------------|-----------|-----------------------------------|
| id          | INT       | NOT NULL, AUTO_INCREMENT, PRIMARY KEY |
| product_id  | INT       | NOT NULL, FOREIGN KEY (product_id) REFERENCES products(product_id) |
| image_url   | TEXT      | NOT NULL                          |






