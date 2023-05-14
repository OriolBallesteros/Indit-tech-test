INSERT INTO BRAND (ID, BRAND) VALUES (1, 'ZARA');

INSERT INTO CURRENCY (ID, CURR) VALUES (1, 'EUR');

INSERT INTO PRODUCT (ID, ITEM) VALUES (35455, 'TROUSERS');

INSERT INTO PRICES (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
  VALUES (1, (SELECT ID FROM BRAND WHERE BRAND.BRAND = 'ZARA'), '2020-06-14 00.00.00', '2020-12-31 23.59.59', 1, (SELECT ID FROM PRODUCT), 0, 35.50, (SELECT CURR FROM CURRENCY WHERE CURRENCY.id = 1));
INSERT INTO PRICES (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
  VALUES (2, (SELECT ID FROM BRAND WHERE BRAND.BRAND = 'ZARA'), '2020-06-14 15.00.00', '2020-06-14 18.30.00', 2, (SELECT ID FROM PRODUCT), 1, 35.50, (SELECT CURR FROM CURRENCY WHERE CURRENCY.id = 1));
INSERT INTO PRICES (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
  VALUES (3, (SELECT ID FROM BRAND WHERE BRAND.BRAND = 'ZARA'), '2020-06-15 00.00.00', '2020-06-15 11.00.00', 3, (SELECT ID FROM PRODUCT), 1, 35.50, (SELECT CURR FROM CURRENCY WHERE CURRENCY.id = 1));
INSERT INTO PRICES (ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR)
  VALUES (4, (SELECT ID FROM BRAND WHERE BRAND.BRAND = 'ZARA'), '2020-06-15 16.00.00', '2020-12-31 23.59.59', 4, (SELECT ID FROM PRODUCT), 1, 35.50, (SELECT CURR FROM CURRENCY WHERE CURRENCY.id = 1));










