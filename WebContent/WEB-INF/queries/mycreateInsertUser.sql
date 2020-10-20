CREATE USER 'arif'@'localhost' IDENTIFIED BY 'arif';
GRANT ALL PRIVILEGES ON * . * TO 'arif'@'localhost';

USE `chat_application`;
select * from user;
ALTER TABLE new_table
RENAME TO user;
SELECT IF( EXISTS(
             SELECT *
             FROM user
             WHERE username ='arif' AND password ='#Plotter2' ), 1, 0);
select if(exists(select * from user where username = 'arif' and password = '#Plotter2'),1,0);
insert into user 
VALUES (2,'arif2','#Plotter2', 'arifkhan10234@gmail.com', 'India');
INSERT INTO user
VALUES (3,'arif3','#Plotter2', 'arifkhan73210@gmail.com', 'India');

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;