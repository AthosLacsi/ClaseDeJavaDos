CREATE TABLE IF NOT EXISTS dulce (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    sabor VARCHAR(255),
    precio DECIMAL(10, 2)
);

INSERT INTO dulce (nombre, sabor, precio) VALUES ('Dulce de leche', 'caramelo', 1.50);
INSERT INTO dulce (nombre, sabor, precio) VALUES ('Chocotorta', 'chocolate', 2.00);
INSERT INTO dulce (nombre, sabor, precio) VALUES ('Alfajor', 'vainilla', 0.75);
