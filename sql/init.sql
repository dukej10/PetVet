-- =========================
-- CLIENTES
-- =========================
INSERT INTO public.clients (address, created_at, email, last_name, "name", phone, updated_at)
VALUES
('Cra 45 #12-34', NOW(), 'juan.perez@email.com', 'Pérez', 'Juan', '3001234567', NOW()),
('Calle 80 #25-19', NOW(), 'maria.gomez@email.com', 'Gómez', 'María', '3019876543', NOW()),
('Av. Siempre Viva 123', NOW(), 'carlos.lopez@email.com', 'López', 'Carlos', '3024567890', NOW()),
('Calle 10 #7-20', NOW(), 'laura.torres@email.com', 'Torres', 'Laura', '3101122334', NOW());

-- =========================
-- MASCOTAS
-- =========================
INSERT INTO public.pets (born_date, breed, created_at, gender, "name", specie, updated_at, pet_photo, client_id)
VALUES
('2020-05-15', 'Labrador', NOW(), 'Macho', 'Rocky', 'Perro', NOW(), 'rocky.jpg', 1),
('2019-08-22', 'Siames', NOW(), 'Hembra', 'Misha', 'Gato', NOW(), 'misha.jpg', 2),
('2021-01-05', 'Bulldog Francés', NOW(), 'Macho', 'Toby', 'Perro', NOW(), 'toby.jpg', 3),
('2022-03-17', 'Golden Retriever', NOW(), 'Hembra', 'Luna', 'Perro', NOW(), 'luna.jpg', 1),
('2018-11-09', 'Persa', NOW(), 'Macho', 'Nube', 'Gato', NOW(), 'nube.jpg', 4);

-- =========================
-- CITAS (APPOINTMENTS)
-- =========================
INSERT INTO public.appointments (created_at, date_time, reason, state, updated_at, pet_id)
VALUES
(NOW(), '2025-11-13 09:00:00', 'Vacunación anual', 'Completada', NOW(), 1),
(NOW(), '2025-11-14 14:30:00', 'Control de peso', 'Pendiente', NOW(), 2),
(NOW(), '2025-11-15 10:00:00', 'Consulta general', 'Completada', NOW(), 3),
(NOW(), '2025-11-16 08:30:00', 'Desparasitación', 'Pendiente', NOW(), 4),
(NOW(), '2025-11-17 11:00:00', 'Cirugía menor', 'Cancelada', NOW(), 1),
(NOW(), '2025-11-18 15:00:00', 'Revisión dental', 'Completada', NOW(), 5);
