
insert into users(id, auth_id, first_name, last_name, username, email, phone, address) 
values(1, 'google-oauth2|114815908914126674021', 'Stevan', 'Kosijer', 'Skos', 'stkosijer@gmail.com', '0631701710', 'Maksima Gorkog 2/C');

insert into users(id, auth_id, first_name, last_name, username, email, phone, address) 
values(2, 'a', 'Dragutin', 'Nikolic', 'Drni', 'ggg@gmail.com', '065421421', 'Maksima Gorkog 32/B');

insert into users(id, auth_id, first_name, last_name, username, email, phone, address) 
values(3, 'c', 'Stefan', 'Polic', 'Pol', 'ggg@gmail.com', '0631701710', 'Maksima Gorkog 2/C');

insert into users(id, auth_id, first_name, last_name, username, email, phone, address) 
values(4, 'd', 'Milomir', 'Mikic', 'Mimi', 'ggg@gmail.com', '0631701710', 'Maksima Gorkog 2/C');

insert into users(id, auth_id, first_name, last_name, username, email, phone, address) 
values(5, 'e', 'Dejan', 'Miric', 'Demi', 'ggg@gmail.com', '0631701710', 'Maksima Gorkog 2/C');

insert into users(id, auth_id, first_name, last_name, username, email, phone, address) 
values(6, 'f', 'Vuk', 'Kostic', 'Vukko', 'ggg@gmail.com', '0631701710', 'Maksima Gorkog 2/C');

insert into users(id, auth_id, first_name, last_name, username, email, phone, address) 
values(7, 'g', 'Filip', 'Dusic', 'Fidu', 'ggg@gmail.com', '0631701710', 'Maksima Gorkog 2/C');

insert into users(id, auth_id, first_name, last_name, username, email, phone, address) 
values(8, 'h', 'Mirko', 'Smiljic', 'Mism', 'ggg@gmail.com', '0631701710', 'Maksima Gorkog 2/C');

insert into users(id, auth_id, first_name, last_name, username, email, phone, address) 
values(9, 'z', 'Milan', 'Nikolic', 'Mnikolic', 'ggg@gmail.com', '0631701710', 'Maksima Gorkog 2/C');

-------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------

--------------------------------------- O R D E R S ----------------------------------------------------------

INSERT INTO orders (ID, USER_ID, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE) 
VALUES (111, '1',  'Fruskogorska 16', 'nik@gmail.com', 'Milan Nikolic', '065224290', TO_TIMESTAMP('2017-06-10 13:47:15.375000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO orders (ID, USER_ID, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE) 
VALUES (222, 1, 'Maksima Gorkog 32/B', 'ggg@gmail.com', 'Dragutin Nikolic', '065421421', TO_TIMESTAMP('2017-06-01 13:47:15.375000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO orders (ID, USER_ID, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE) 
VALUES (333, 1, 'Maksima Gorkog 2/C', 'zzz@gmail.com', 'Stefan Polic', '066262622', TO_TIMESTAMP('2017-06-01 13:47:15.375000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO orders (ID, USER_ID, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE) 
VALUES (444, 1, 'Danila Kisa 29', 'sss@gmail.com', 'Milomir Mikic', '063030300', TO_TIMESTAMP('2017-06-06 13:47:15.375000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO orders (ID, USER_ID, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE) 
VALUES (555, 1, 'Trifkovicev Trg 10', 'ddd@gmail.com', 'Dejan Miric', '065254290', TO_TIMESTAMP('2017-06-08 13:47:15.375000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO orders (ID, USER_ID, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE) 
VALUES (666, 2, 'Mite Ruzica 19', 'gsgaga@gmail.com', 'Vuk Kostic', '061234290', TO_TIMESTAMP('2017-06-08 13:47:15.375000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO orders (ID, USER_ID, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE) 
VALUES (777, 3, 'Safarikova 10', 'aaas@gmail.com', 'Filip Dusic', '065444290', TO_TIMESTAMP('2017-06-09 13:47:15.375000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO orders (ID, USER_ID, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE) 
VALUES (888, 4, 'Petra Drapsina 6', 'aa41sx@gmail.com', 'Mirko Smiljic', '06111190', TO_TIMESTAMP('2017-06-10 13:47:15.375000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

INSERT INTO orders (ID, USER_ID, CUSTOMER_ADDRESS, CUSTOMER_EMAIL, CUSTOMER_NAME, CUSTOMER_PHONE, ORDER_DATE) 
VALUES (999, 5, 'Petra Drapsina 6', 'aa41sx@gmail.com', 'Mirko Smiljic', '06111190', TO_TIMESTAMP('2017-06-10 13:47:15.375000000', 'YYYY-MM-DD HH24:MI:SS.FF'));

---------------------------- PRICELIST -----------------------------------

insert into pricelist(id, start_date, end_date)
values(1110, '01-JUN-17', '29-JUN-17');
--values(1110, null, null);

--insert into pricelist(id, start_date, end_date)
--values(2220, '30-JUN-17', '16-07-17');
--values(2220, '01-JUN-17', '29-06-17');
---------------------------------------------------------------------------



---------------------------- PRICE -----------------------------------
insert into price(id, discount, price_value, pricelist_id)
values(1010, 0, 2600, 1110);

insert into price(id, discount, price_value, pricelist_id)
values(2020, 0, 3000, 1110);

insert into price(id, discount, price_value, pricelist_id)
values(3030, 0, 3500, 1110);

---------------------------------------------------------------------------


-------------------------- C A T E G O R I E S -----------------------------

--insert into category(id, name, description, product_id)
--values (1, 'Category1', 'Lude majice', 1);

------------------------------------------------------------------------

insert into category(id, name, description)
values (1000, 'Urban', 'Be urban!');

insert into category(id, name, description)
values (2000, 'Vintage', 'Vintage always good.');

insert into category(id, name, description)
values (3000, 'Classic', 'Really nice looking classic.');

insert into category(id, name, description)
values (4000, 'Programmer', 'Programmers stuff.');





-------------------------- P R O D U C T S -----------------------------

--insert into product(id, name, description, price, create_date, image, category)
--values (1, 'TShirt1', 'Mnogo dobra majica', 2700, CURRENT_TIMESTAMP, 'slika');

------------------------------------------------------------------------

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (1111, 'Batman', 'Always interesting batman', 0, CURRENT_TIMESTAMP, '/pictures/summer_black.jpg', 1000, 2020, 220);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (2222, 'Superman', 'Klark Kent', 0, CURRENT_TIMESTAMP, '/pictures/men_fire_cherokee_olive.jpg', 1000, 2020, 319);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (3333, 'Exit', 'Best Serbian festival', 0, CURRENT_TIMESTAMP, '/pictures/men_fire_cherokee_olive_ripped.jpg', 1000, 3030, 416);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (4444, 'Manchester', 'Forever yours', 0, CURRENT_TIMESTAMP, 'slika', 1000, 1010, 529);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (5555, 'Liverpool', 'We love football', 0, CURRENT_TIMESTAMP, 'slika', 2000, 2020, 200);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (55551, 'The Best A', 'Angular 2 special tshirt, only for the biggest fans.', 0, CURRENT_TIMESTAMP, 'slika', 4000, 2020, 200);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (55552, 'J for J', 'Java is the language we speak!', 0, CURRENT_TIMESTAMP, 'slika', 4000, 2020, 200);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (55553, 'Phy', 'Phyton lovers', 0, CURRENT_TIMESTAMP, 'slika', 4000, 2020, 200);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (55554, 'Rails', 'Rubi is always on rails!', 0, CURRENT_TIMESTAMP, 'slika', 4000, 2020, 200);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (55555, 'Arsenal', 'Welcome to the family. Only for football lovers.', 0, CURRENT_TIMESTAMP, 'slika', 3000, 2020, 200);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (55556, 'Programmer', 'We adore code!', 0, CURRENT_TIMESTAMP, 'slika', 4000, 2020, 200);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (6666, 'England', 'Special tshirt', 0, CURRENT_TIMESTAMP, 'slika', 2000, 1010, 500);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (7777, 'Canada', 'Ice skates, forever special.', 0, CURRENT_TIMESTAMP, 'slika', 2000, 2020, 430);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (7778, 'Zimbabwe', 'Africa is for you.', 0, CURRENT_TIMESTAMP, 'slika', 2000, 3030, 480);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (7779, 'Greece', 'Proud country', 0, CURRENT_TIMESTAMP, 'slika', 3000, 3030, 490);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (7780, 'Macedonia', 'Why not?', 0, CURRENT_TIMESTAMP, 'slika', 3000, 1010, 1200);

insert into product(id, name, description, price_discount, create_date, image, category, price_id, lagger)
values (7781, 'Hawaii', 'Always interesting!', 0, CURRENT_TIMESTAMP, 'slika', 3000, 2020, 350);

----------------------------------------------------------------------------------------------

------------------------------- O R D E R   D E T A I L S --------------------------------------

INSERT INTO order_detail (ID, PRICE, PRODUCT_SIZE, QUANTITY, ORDER_ID, PRODUCT_ID) 
VALUES (991, '2600', 'M', '1', 111, '1111');

INSERT INTO order_detail (ID, PRICE, PRODUCT_SIZE, QUANTITY, ORDER_ID, PRODUCT_ID) 
VALUES (992, '5200', 'S', '2', 111, '2222');


INSERT INTO order_detail (ID, PRICE, PRODUCT_SIZE, QUANTITY, ORDER_ID, PRODUCT_ID) 
VALUES (993, '2600', 'XL', '1', 222, '3333');

INSERT INTO order_detail (ID, PRICE, PRODUCT_SIZE, QUANTITY, ORDER_ID, PRODUCT_ID) 
VALUES (994, '6000', 'L', '2', 333, '4444');


INSERT INTO order_detail (ID, PRICE, PRODUCT_SIZE, QUANTITY, ORDER_ID, PRODUCT_ID) 
VALUES (995, '2600', 'M', '1', 444, '3333');

INSERT INTO order_detail (ID, PRICE, PRODUCT_SIZE, QUANTITY, ORDER_ID, PRODUCT_ID) 
VALUES (996, '5200', 'S', '2', 555, '3333');

