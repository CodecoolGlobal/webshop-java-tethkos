CREATE TABLE artist(
    name text,
    description text,
    PRIMARY KEY (name)
);

CREATE TABLE product_category(
    name text,
    department text,
    PRIMARY KEY (name)
);

CREATE TABLE product(
    id integer,
    name text,
    default_price integer,
    currency_string text,
    description text,
    product_category text,
    artist text,
    PRIMARY KEY (id),
    FOREIGN KEY (product_category) REFERENCES product_category (name),
    FOREIGN KEY (artist) REFERENCES artist (name)
);

INSERT INTO artist (name, description) VALUES ('All Artists','All');
INSERT INTO artist (name, description) VALUES ('Pony Wave', 'When it comes to realistic tattoos, this artist is on a whole other level.');
INSERT INTO artist (name, description) VALUES ('Bang Bang','Bang Bang is a popular tattoo artist based in Terézcity');
INSERT INTO artist (name, description) VALUES ('Little Johnny','The Terezcity-based artist specializes in highly intricate black-and-white tattoos with a lot of contrast.');
INSERT INTO artist (name, description) VALUES ('Rit Kit Tattoo','She achieves her “live leaf tattoos” by using ink to first stamp the outline');

INSERT INTO product_category (name, department) VALUES ('All category', 'All');
INSERT INTO product_category (name, department) VALUES ('Famous People', 'Tattoo');
INSERT INTO product_category (name, department) VALUES ('Makeup', 'Tattoo');
INSERT INTO product_category (name, department) VALUES ('Calligraphic', 'Tattoo');
INSERT INTO product_category (name, department) VALUES ('Realistic', 'Tattoo');
INSERT INTO product_category (name, department) VALUES ('For Trve Lovers', 'Tattoo');

INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (1, 'Mr. Jackson', 5990, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (2, 'Jordan', 2990, 'HUF', 'I you likes basketball get one', 'Makeup', 'Bang Bang');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (3, 'Regret', 1990, 'HUF', 'YOLO', 'Calligraphic', 'Little Johnny');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (4, 'Love', 3990, 'HUF', 'For troubled personalities', 'Calligraphic', 'Rit Kit Tattoo');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (5, 'Megan', 4990, 'HUF', 'For after breakup', 'Calligraphic', 'Rit Kit Tattoo');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (6, 'Onion', 1990, 'HUF', 'For layered ones', 'Calligraphic', 'Bang Bang');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (7, 'Mc Donald', 1990, 'HUF', 'For that one meal to remember', 'Calligraphic', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (8, 'Live Youre life', 1990, 'HUF', 'YOLO 2', 'Calligraphic', 'Rit Kit Tattoo');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (9, 'Its is your life', 1990, 'HUF', 'Get the famous song on your belly', 'Calligraphic', 'Rit Kit Tattoo');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (10, 'Marilyn', 8990, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (11, 'Toilet', 3990, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (12, 'Twilight', 9990, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (13, 'Family Potrait', 19990, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (14, 'Drake', 3490, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (15, 'Spiderman', 5430, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (16, 'Ninja Turtle', 6600, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (17, 'Great Heart', 10000, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (18, 'WallMarkt', 6690, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (19, 'South Park', 15440, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (20, 'Monster', 3450, 'HUF', 'Get the King of Pop on youre body', 'Famous People', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (21, 'Smile', 6660, 'HUF', 'You can never be pretty enough', 'Makeup', 'Rit Kit Tattoo');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (22, 'Russian Standard', 6660, 'HUF', 'You can catch Igor with your look', 'Makeup', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (24, 'Disco Queen', 9990, 'HUF', 'For the real gold diggers #partyneverstops', 'Makeup', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (25, 'Natural Look', 3490, 'HUF', 'For animal lovers', 'Makeup', 'Pony Wave');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (26, 'EKIN', 3490, 'HUF', 'Just do it!', 'Makeup', 'Bang Bang');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (23, 'Babyboi', 5690, 'HUF', 'Welcome to the family', 'Makeup', 'Bang Bang');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (27, 'Twins', 5690, 'HUF', 'One is never enough', 'Makeup', 'Bang Bang');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (28, 'Babygurl', 5690, 'HUF', 'Little princess', 'Makeup', 'Little Johnny');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (29, 'Pink Foyld', 5690, 'HUF', 'Dark side of the art', 'Makeup', 'Little Johnny');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (30, 'Mrs. Jolie', 5690, 'HUF', 'Tomb Raider on your skin', 'Makeup', 'Rit Kit Tattoo');
INSERT INTO product (id, name, default_price, currency_string, description, product_category, artist) VALUES (31, 'Hell of a Spite', 5690, 'HUF', 'F**k Coke', 'Makeup', 'Rit Kit Tattoo');
