CREATE TABLE IF NOT EXISTS products
( id INTEGER NOT NULL AUTO_INCREMENT,
  img VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  price DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders
( id INTEGER NOT NULL AUTO_INCREMENT,
  email VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  order_text VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO
 products (img, name, type, price)
VALUES
 ('1.png', 'tomato', 'vegetable', 9.99),
 ('2.png', 'cabbage', 'vegetable', 5.99),
 ('3.png', 'cherry', 'fruit', 19.99),
 ('4.png', 'celery', 'vegetable', 3.99),
 ('5.png', 'pineapple', 'fruit', 29.99),
 ('6.png', 'onion', 'vegetable', 4.99),
 ('7.png', 'mushroom', 'vegetable', 34.99),
 ('8.png', 'pepper', 'vegetable', 14.99);

 -- Все продукты
 SELECT * FROM products;

  -- Все заказы
  SELECT * FROM orders;

 -- Удаление по id
 DELETE FROM products WHERE id = :id;

  -- Удаление по id
  DELETE FROM orders WHERE id = :id;