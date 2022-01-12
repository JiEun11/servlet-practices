
show databases;

-- db생성 
CREATE DATABASE webdb;

-- user 생성
CREATE USER 'webdb'@'localhost' identified by 'webdb';

-- 권한 부여
grant all privileges on webdb.* to 'webdb'@'localhost';