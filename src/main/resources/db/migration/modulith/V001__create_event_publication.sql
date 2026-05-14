CREATE TABLE event_publication (
    id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY,
    listener_id NVARCHAR(512) NOT NULL,
    event_type NVARCHAR(512) NOT NULL,
    serialized_event NVARCHAR(MAX) NOT NULL,
    publication_date DATETIME2 NOT NULL,
    completion_date DATETIME2 NULL
);

CREATE INDEX idx_event_publication_completion_date
ON event_publication(completion_date);

CREATE INDEX idx_event_publication_publication_date
ON event_publication(publication_date);