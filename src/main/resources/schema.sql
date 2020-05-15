CREATE TABLE IF NOT EXISTS users (
    userId INT NOT NULL,
    username VARCHAR(250) NOT NULL,
    token VARCHAR(250) NOT NULL,
    date_session TIMESTAMP NOT NULL
    );
