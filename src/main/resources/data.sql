CREATE TABLE account
(
    id             BIGINT PRIMARY KEY,
    first_name     VARCHAR(255) NOT NULL,
    last_name      VARCHAR(255) NOT NULL,
    email_address  VARCHAR(255) NOT NULL,
    password       VARCHAR(64)  NOT NULL,
    street         VARCHAR(255) NOT NULL,
    city           VARCHAR(255) NOT NULL,
    province_state VARCHAR(255) NOT NULL,
    postal_code    VARCHAR(10)  NOT NULL,
    country        VARCHAR(255) NOT NULL
);

INSERT INTO account (id, first_name, last_name, email_address, password, street, city, province_state, postal_code,
                     country)
VALUES (1, 'John', 'Doe', 'john.doe@example.com', 'password1', '123 Main St', 'Anytown', 'ON', 'A1A 1A1', 'Canada'),
       (2, 'Jane', 'Smith', 'jane.smith@example.com', 'password2', '456 Oak Ave', 'Anycity', 'CA', '90210', 'USA'),
       (3, 'Bob', 'Johnson', 'bob.johnson@example.com', 'password3', '789 Elm St', 'Anyville', 'NY', '10001', 'USA');
