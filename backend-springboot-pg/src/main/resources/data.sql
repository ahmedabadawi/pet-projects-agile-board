INSERT INTO public.app_user (id, email, first_name, last_name, last_login, status)
VALUES 	(1, 'admin@corp.com', 'John', 'Doe', NULL, 'ACTIVE'),
				(2, 'elit.pretium@sit.ca', 'Jack', 'Kibo', NULL, 'ACTIVE'),
        (3, 'pharetra@dignissimpharetraNam.org', 'Zoe', 'Wylie', NULL,'ACTIVE'),
        (4, 'orci@augueeu.net', 'Yardley', 'Micah', NULL,'ACTIVE'),
        (5, 'id@interdumlibero.co.uk', 'Hedwig', 'Tate', NULL, 'ACTIVE'),
        (6, 'vitae.sodales@liberonecligula.ca', 'Samuel', 'Kuame', NULL, 'ACTIVE');

INSERT INTO public.auth_user (user_id, email, roles, password)
VALUES	(1, 'admin@corp.com', 'ADMIN,USER', '$2a$10$9xAeS/XvnurtmEKdUHdcwO628yTuF6vOQsx5JZpbyZ3F9HY9c/b.6'),
				(2, 'elit.pretium@sit.ca', 'USER', '$2a$10$9xAeS/XvnurtmEKdUHdcwO628yTuF6vOQsx5JZpbyZ3F9HY9c/b.6'),
        (4, 'orci@augueeu.net', 'USER', '$2a$10$9xAeS/XvnurtmEKdUHdcwO628yTuF6vOQsx5JZpbyZ3F9HY9c/b.6'),
        (5, 'id@interdumlibero.co.uk', 'USER', '$2a$10$9xAeS/XvnurtmEKdUHdcwO628yTuF6vOQsx5JZpbyZ3F9HY9c/b.6'),
        (6, 'vitae.sodales@liberonecligula.ca', 'USER', '$2a$10$9xAeS/XvnurtmEKdUHdcwO628yTuF6vOQsx5JZpbyZ3F9HY9c/b.6');

INSERT INTO public.user_profile (user_id, email, first_name, last_name, bio, photo)
VALUES 	(1, 'admin@corp.com', 'John', 'Doe', 'https://placeimg.com/200/200/people', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
				(2, 'elit.pretium@sit.ca', 'Jack', 'Kibo', 'https://placeimg.com/200/200/people', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
        (3, 'pharetra@dignissimpharetraNam.org', 'Zoe', 'Wylie', 'https://placeimg.com/200/200/people','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
        (4, 'orci@augueeu.net', 'Yardley', 'Micah', 'https://placeimg.com/200/200/people','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
        (5, 'id@interdumlibero.co.uk', 'Hedwig', 'Tate', 'https://placeimg.com/200/200/people', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
        (6, 'vitae.sodales@liberonecligula.ca', 'Samuel', 'Kuame', 'https://placeimg.com/200/200/people', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.');
        
INSERT INTO public.project (id, admin_id, code, title, description, start_date, end_date)
VALUES	(1, 1, 'XYZ', 'Project XYZ', 'Lorem Ipsum XYZ', '2018-01-01T00:00:00.00Z', '2022-01-01T00:00:00.00Z'),
      	(2, 1, 'ABC', 'Project ABC', 'Lorem Ipsum ABC', '2018-01-01T00:00:00.00Z', '2022-01-01T00:00:00.00Z');
