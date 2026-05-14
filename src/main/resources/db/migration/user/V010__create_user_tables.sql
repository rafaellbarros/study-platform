CREATE TABLE user_schema.users (
    id                  UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    external_auth_id    VARCHAR(255),
    auth_provider       VARCHAR(50),
    email               VARCHAR(255) UNIQUE,
    full_name           VARCHAR(255),
    status              VARCHAR(50),
    created_at          DATETIME2 DEFAULT GETDATE(),
    updated_at          DATETIME2 DEFAULT GETDATE()
);

CREATE TABLE user_schema.roles (
    id              UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
    name            VARCHAR(100) UNIQUE
);

CREATE TABLE user_schema.user_roles (
    user_id         UNIQUEIDENTIFIER,
    role_id         UNIQUEIDENTIFIER,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT FK_User FOREIGN KEY (user_id) REFERENCES user_schema.users(id),
    CONSTRAINT FK_Role FOREIGN KEY (role_id) REFERENCES user_schema.roles(id)
);;