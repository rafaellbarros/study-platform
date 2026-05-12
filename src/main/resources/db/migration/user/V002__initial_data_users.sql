-- =====================================================
-- ROLES
-- =====================================================

INSERT INTO app_db.user_roles (
    id,
    name
)
VALUES
(
    UUID_TO_BIN('87228f95-ddcc-4790-9af9-f941b4fe8cfe'),
    'ADMIN'
),
(
    UUID_TO_BIN('79eb2de0-3844-4ff8-b80b-9753171aef45'),
    'MANAGER'
),
(
    UUID_TO_BIN('fab6b8c9-9a66-42a3-8008-1d4e372c6335'),
    'USER'
),
(
    UUID_TO_BIN('353a3814-8f08-4f92-b81d-c746021843f9'),
    'SYSTEM'
);

-- =====================================================
-- USERS
-- =====================================================

INSERT INTO app_db.user_users (
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
    UUID_TO_BIN('797690e8-d003-42f6-9f3e-ea0b3fd43599'),
    NULL,
    'LOCAL',
    'admin@system.local',
    'System Administrator',
    'ACTIVE',
    NOW(),
    NOW()
),
(
    UUID_TO_BIN('6474cd41-99ba-492e-a286-f32363b7464f'),
    NULL,
    'LOCAL',
    'manager@system.local',
    'Operations Manager',
    'ACTIVE',
    NOW(),
    NOW()
),
(
    UUID_TO_BIN('5abd8bd9-38f8-4970-8b39-bcd803beda65'),
    NULL,
    'LOCAL',
    'user@system.local',
    'Default User',
    'ACTIVE',
    NOW(),
    NOW()
),
(
    UUID_TO_BIN('a8de3ed0-e042-40c5-aee9-aa2902a6527e'),
    NULL,
    'SYSTEM',
    'system@internal.local',
    'Internal System',
    'ACTIVE',
    NOW(),
    NOW()
);

-- =====================================================
-- USER ROLES
-- =====================================================

INSERT INTO app_db.user_user_roles (
    user_id,
    role_id
)
VALUES
(
    UUID_TO_BIN('797690e8-d003-42f6-9f3e-ea0b3fd43599'),
    UUID_TO_BIN('87228f95-ddcc-4790-9af9-f941b4fe8cfe')
),
(
    UUID_TO_BIN('6474cd41-99ba-492e-a286-f32363b7464f'),
    UUID_TO_BIN('79eb2de0-3844-4ff8-b80b-9753171aef45')
),
(
    UUID_TO_BIN('5abd8bd9-38f8-4970-8b39-bcd803beda65'),
    UUID_TO_BIN('fab6b8c9-9a66-42a3-8008-1d4e372c6335')
),
(
    UUID_TO_BIN('a8de3ed0-e042-40c5-aee9-aa2902a6527e'),
    UUID_TO_BIN('353a3814-8f08-4f92-b81d-c746021843f9')
);