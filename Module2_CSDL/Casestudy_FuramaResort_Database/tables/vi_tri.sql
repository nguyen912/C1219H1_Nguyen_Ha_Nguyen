use furama_resort;

INSERT INTO vi_tri (ten_vi_tri) VALUE ('Director');
INSERT INTO vi_tri (ten_vi_tri) VALUE ('Manager');
INSERT INTO vi_tri (ten_vi_tri) VALUE ('Leader');
INSERT INTO vi_tri (ten_vi_tri) VALUE ('Employee');
INSERT INTO vi_tri (ten_vi_tri) VALUE ('Trainee');

select * from vi_tri
order by id_vi_tri;

SET SQL_SAFE_UPDATES = 0;
delete from vi_tri;

