CREATE TABLE IF NOT EXISTS products
(
    id    BIGSERIAL PRIMARY KEY ,
    deprication VARCHAR NOT NULL ,
    price DOUBLE PRECISION  NOT NULL ,
    isPromotion BOOLEAN  NOT NULL
    );

CREATE TABLE IF NOT EXISTS cards
(

)