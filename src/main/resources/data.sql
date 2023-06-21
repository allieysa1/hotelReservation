INSERT INTO room (room_name, price, room_type, room_desc, photo_url)
VALUES ('Standard Room', 15000, 'single', 'baik', 'https://images.unsplash.com/photo-1631049307264-da0ec9d70304?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80');

INSERT INTO guest(email, f_name, l_name, phone_no, card_no)
VALUES('malisa@gmail.com', 'Nur', 'Malisa', '017-4563498', '9876543456789');

INSERT INTO guest(email, f_name, l_name, phone_no, card_no)
VALUES('nouman@gmail.com', 'M.', 'Nouman', '015-9871265', '56474774838348');

insert into reservation (check_in, check_out)
values('2023-06-21 08:06:00', '	2023-06-22 08:06:00');

insert into reservation (check_in, check_out)
values('2023-05-21 08:06:00', '	2023-07-22 08:06:00');


update reservation set guest_id = 1
where reservation_id =1;

update reservation set guest_id = 2
where reservation_id =2;

update reservation set guest_id = 3
where reservation_id =3;