CREATE TABLE service_orders (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    technician_id UUID,
    creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    visit_date TIMESTAMP WITHOUT TIME ZONE,
    status VARCHAR(255) NOT NULL,
    service_description VARCHAR(500),
    quote_price DOUBLE PRECISION,
    is_quote_accepted BOOLEAN,
    payment_amount DOUBLE PRECISION,
    technician_rating INTEGER
);
