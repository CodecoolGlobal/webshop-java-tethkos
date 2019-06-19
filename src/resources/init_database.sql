CREATE TABLE supplier(
    name text,
    description text
    PRIMARY KEY (name)
);

CREATE TABLE product_category(
    name text,
    department text
    PRIMARY KEY (name)
);

CREATE TABLE product(
    id integer,
    name text,
    default_price integer,
    currency_string text,
    description text,
    product_category text,
    supplier text
    PRIMARY KEY (id),
    FOREIGN KEY (product_category) REFERENCES product_category (name),
    FOREIGN KEY (supplier) REFERENCES supplier (name)
);
