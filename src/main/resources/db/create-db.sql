create database if not exists chattyLee;
create user if not exists  'chatMan'@'localhost' identified by 'deployChatApp';

grant all privileges on chattyLee.* to 'chatMan'@'localhost';
flush privileges;