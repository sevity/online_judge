-- 데이터베이스 접속
\c online_judge;

DROP TABLE IF EXISTS problems;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS submissions;
DROP TABLE IF roles;
DROP TABLE IF user_roles;

-- 문제 테이블 생성
CREATE TABLE problems (
  id SERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  description TEXT NOT NULL,
  example_input TEXT NOT NULL,
  example_output TEXT NOT NULL
);

-- 사용자 테이블 생성
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(100) NOT NULL,
  name VARCHAR(50) NOT NULL
);

-- 제출 테이블 생성
CREATE TABLE submissions (
  id SERIAL PRIMARY KEY,
  problem_id INT NOT NULL,
  user_id INT NOT NULL,
  code TEXT NOT NULL,
  result TEXT NOT NULL,
  FOREIGN KEY (problem_id) REFERENCES problems (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);

-- 역할 테이블 생성
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- 사용자와 역할의 관계 테이블 생성
CREATE TABLE user_roles (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);

