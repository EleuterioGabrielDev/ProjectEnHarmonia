CREATE TABLE client (
    id BIGSERIAL PRIMARY KEY,
    couples_Name VARCHAR(150) NOT NULL,
    phone VARCHAR(11) NOT NULL ,
    date_Event DATE NOT NULL,
    time_Event TIME NOT NULL,
    local_Event VARCHAR(200),
    create_In TIMESTAMP NOT NULL DEFAULT now()
);

CREATE INDEX idx_client_event_date ON client(date_Event);