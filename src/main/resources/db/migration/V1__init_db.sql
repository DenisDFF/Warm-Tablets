CREATE TABLE IF NOT EXISTS games (
    id SERIAL PRIMARY KEY,
    image_url VARCHAR(255) NOT NULL,
    big_image_url VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    link VARCHAR(255) NOT NULL,
    categories TEXT[] NOT NULL
);