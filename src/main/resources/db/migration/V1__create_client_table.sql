CREATE TABLE client (
    id BIGSERIAL PRIMARY KEY,
    couplesName VARCHAR(150) NOT NULL,
    phone VARCHAR(11) NOT NULL ,
    dateEvent DATE NOT NULL,
    timeEvent TIME NOT NULL,
    localEvent VARCHAR(200),
    createIn TIMESTAMP NOT NULL DEFAULT now()
);

CREATE INDEX idx_client_event_date ON client(dateEvent);