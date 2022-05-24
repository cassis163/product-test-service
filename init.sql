CREATE TABLE product(
    id INT PRIMARY KEY NOT NULL,
    name TEXT NOT NULL
);

CREATE TABLE product_option(
    id INT PRIMARY KEY NOT NULL,
    product_id INT NOT NULL,
    name TEXT NOT NULL,
    CONSTRAINT fk_product FOREIGN KEY(product_id) REFERENCES product(id)
);
