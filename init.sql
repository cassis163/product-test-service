CREATE TABLE product(
    id INT PRIMARY KEY NOT NULL,
    name TEXT NOT NULL
);

CREATE TABLE color(
    id INT PRIMARY KEY NOT NULL,
    name TEXT NOT NULL
);

CREATE TABLE product_option(
    id INT PRIMARY KEY NOT NULL,
    product_id INT NOT NULL,
    CONSTRAINT fk_product FOREIGN KEY(product_id) REFERENCES product(id),
    color_id INT NOT NULL,
    CONSTRAINT fk_color FOREIGN KEY(color_id) REFERENCES color(id)
);

INSERT INTO
    color
VALUES
    (1, 'Red'),
    (2, 'Blue'),
    (3, 'Yellow'),
    (4, 'Green'),
    (5, 'White');
