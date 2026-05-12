CREATE TABLE app_db.user_users (
    id                  BINARY(16) PRIMARY KEY,
    external_auth_id    VARCHAR(255),
    auth_provider       VARCHAR(50),
    email               VARCHAR(255) UNIQUE,
    full_name           VARCHAR(255),
    status              VARCHAR(50),
    created_at          TIMESTAMP,
    updated_at          TIMESTAMP
);

CREATE TABLE app_db.user_roles (
    id              BINARY(16) PRIMARY KEY,
    name            VARCHAR(100) UNIQUE
);


CREATE TABLE app_db.user_user_roles (
    user_id         BINARY(16),
    role_id         BINARY(16),
    PRIMARY KEY (user_id, role_id)
);