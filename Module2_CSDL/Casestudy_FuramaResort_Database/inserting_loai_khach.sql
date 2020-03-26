use furama_resort;

insert into loai_khach(ten_loai_khach) value('Diamond');
insert into loai_khach(ten_loai_khach) value('Platinium');
insert into loai_khach(ten_loai_khach) value('Gold');
insert into loai_khach(ten_loai_khach) value('Silver');
insert into loai_khach(ten_loai_khach) value('Member');

select * from loai_khach
order by id_loai_khach;