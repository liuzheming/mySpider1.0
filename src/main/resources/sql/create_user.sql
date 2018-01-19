CREATE DATABASE spider CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'spider' IDENTIFIED BY 'spider';
GRANT ALL ON spider.* TO 'spider'@'%' IDENTIFIED BY 'spider';
GRANT ALL ON spider.* TO 'spider'@'localhost' IDENTIFIED BY 'spider';
FLUSH PRIVILEGES;



