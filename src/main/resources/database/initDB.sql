DROP TABLE IF EXISTS products, discount_cards;

CREATE TABLE products
(
    product_id    BIGSERIAL PRIMARY KEY ,
    description VARCHAR NOT NULL ,
    price DOUBLE PRECISION  NOT NULL ,
    is_promotion BOOLEAN  NOT NULL
    );

CREATE TABLE discount_cards
(
    card_id    BIGSERIAL PRIMARY KEY ,
    gradation VARCHAR NOT NULL ,
    card_holder VARCHAR NOT NULL ,
    discount_value DOUBLE PRECISION NOT NULL
)