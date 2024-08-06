CREATE TABLE IF NOT EXISTS posts (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    base64 TEXT,
    created_date TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);