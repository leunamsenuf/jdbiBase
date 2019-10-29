CREATE TABLE IF NOT EXISTS tb_contact (
    id BIGINT (30) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone BIGINT (30) NOT NULL
);

CREATE INDEX idx_contact_name ON tb_contact (name);
CREATE INDEX idx_contact_email ON tb_contact (email);
CREATE INDEX idx_contact_phone ON tb_contact (phone);
