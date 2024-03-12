CREATE TABLE IF NOT EXISTS games (
    id SERIAL PRIMARY KEY,
    image_url VARCHAR(255) NOT NULL,
    big_image_url VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    link VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS game_rules (
    id SERIAL PRIMARY KEY,
    game_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS game_items (
    id SERIAL PRIMARY KEY,
    game_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS game_character (
    id SERIAL PRIMARY KEY,
    game_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    source TEXT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS game_equipment (
    id SERIAL PRIMARY KEY,
    game_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    source TEXT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id)
);

CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS favorites (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    rule_id BIGINT,
    item_id BIGINT,
    equipment_id BIGINT,
    character_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (rule_id) REFERENCES game_rules(id),
    FOREIGN KEY (item_id) REFERENCES game_items(id),
    FOREIGN KEY (equipment_id) REFERENCES game_equipment(id),
    FOREIGN KEY (character_id) REFERENCES game_character(id)
);

CREATE TABLE IF NOT EXISTS authorities (
    username VARCHAR(255) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    PRIMARY KEY (username, authority),
    FOREIGN KEY (username) REFERENCES users(username)
);

