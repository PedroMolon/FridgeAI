CREATE TABLE tb_food_items (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    category VARCHAR(255),
    expiration_date DATE
)