-- =====================================================
-- ROLES
-- =====================================================

INSERT INTO user_schema.roles (id, name)
VALUES
    ('87228f95-ddcc-4790-9af9-f941b4fe8cfe', 'ADMIN'),
    ('79eb2de0-3844-4ff8-b80b-9753171aef45', 'MANAGER'),
    ('fab6b8c9-9a66-42a3-8008-1d4e372c6335', 'USER'),
    ('353a3814-8f08-4f92-b81d-c746021843f9', 'SYSTEM');

-- =====================================================
-- USERS
-- =====================================================

INSERT INTO user_schema.users (
    id,
    external_auth_id,
    auth_provider,
    email,
    full_name,
    status,
    created_at,
    updated_at
)
VALUES
(
    '797690e8-d003-42f6-9f3e-ea0b3fd43599',
    NULL,
    'LOCAL',
    'admin@system.local',
    'System Administrator',
    'ACTIVE',
    GETDATE(),
    GETDATE()
),
(
    '6474cd41-99ba-492e-a286-f32363b7464f',
    NULL,
    'LOCAL',
    'manager@system.local',
    'Operations Manager',
    'ACTIVE',
    GETDATE(),
    GETDATE()
),
(
    '5abd8bd9-38f8-4970-8b39-bcd803beda65',
    NULL,
    'LOCAL',
    'user@system.local',
    'Default User',
    'ACTIVE',
    GETDATE(),
    GETDATE()
),
(
    'a8de3ed0-e042-40c5-aee9-aa2902a6527e',
    NULL,
    'SYSTEM',
    'system@internal.local',
    'Internal System',
    'ACTIVE',
    GETDATE(),
    GETDATE()
);

-- =====================================================
-- USER ROLES
-- =====================================================

INSERT INTO user_schema.user_roles (user_id, role_id)
VALUES
    ('797690e8-d003-42f6-9f3e-ea0b3fd43599', '87228f95-ddcc-4790-9af9-f941b4fe8cfe'),
    ('6474cd41-99ba-492e-a286-f32363b7464f', '79eb2de0-3844-4ff8-b80b-9753171aef45'),
    ('5abd8bd9-38f8-4970-8b39-bcd803beda65', 'fab6b8c9-9a66-42a3-8008-1d4e372c6335'),
    ('a8de3ed0-e042-40c5-aee9-aa2902a6527e', '353a3814-8f08-4f92-b81d-c746021843f9');