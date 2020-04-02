create database furama_resort;
use furama_resort;
drop database furama_resort;

/*==============================================================================================
TẠO BẢNG
================================================================================================*/
create table vi_tri (
	id_vi_tri int auto_increment primary key,
    ten_vi_tri varchar(45) unique not null
);

create table trinh_do (
	id_trinh_do int auto_increment primary key,
    trinh_do varchar(45) unique not null 
);

create table bo_phan (
	id_bo_phan int auto_increment primary key,
    ten_bo_phan varchar(45) unique not null
);

create table nhan_vien (
	id_nhan_vien int auto_increment primary key,
    ho_ten varchar(45) not null,
    id_vi_tri int default 1,
    id_trinh_do int default 1,
    id_bo_phan int default 1,
    ngay_sinh date,
    so_cmtnd varchar(45) unique,
    luong varchar(45),
    sdt varchar(45) not null,
    email varchar(45),
    dia_chi varchar(45) not null,
    constraint fk_id_vi_tri foreign key(id_vi_tri) references vi_tri(id_vi_tri),
    constraint fk_id_trinh_do foreign key(id_trinh_do) references trinh_do(id_trinh_do),
    constraint fk_id_bo_phan foreign key(id_bo_phan) references bo_phan(id_bo_phan)
);

create table loai_khach (
	id_loai_khach int auto_increment primary key,
    ten_loai_khach varchar(45) not null unique
);

create table khach_hang (
	id_khach_hang int auto_increment primary key,
    id_loai_khach int default 5,
    ho_ten varchar(45) not null,
    ngay_sinh date,
    so_cmtnd varchar(45),
    sdt varchar(45) not null,
    email varchar(45),
    dia_chi varchar(45),
    constraint fk_id_loai_khach foreign key(id_loai_khach) references loai_khach(id_loai_khach)
);

create table kieu_thue (
	id_kieu_thue int auto_increment primary key,
    ten_kieu_thue varchar(45) not null unique,
    gia int not null
);

create table loai_dich_vu (
	id_loai_dich_vu int auto_increment primary key,
    ten_loai_dich_vu varchar(45) not null unique
);

create table dich_vu (
	id_dich_vu int auto_increment primary key,
    ten_dich_vu varchar(45) not null,
    dien_tich int,
    so_tang int,
    so_nguoi_toi_da int,
    chi_phi_thue int,
    id_kieu_thue int,
    id_loai_dich_vu int,
    trang_thai varchar(45),
    constraint fk_id_kieu_thue foreign key(id_kieu_thue) references kieu_thue(id_kieu_thue),
    constraint fk_id_loai_dich_vu foreign key(id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table hop_dong (
	id_hop_dong int auto_increment primary key,
    id_nhan_vien int,
    id_khach_hang int,
    id_dich_vu int,
    ngay_lam_hop_dong date,
    ngay_ket_thuc date,
    tien_dat_coc int,
    tong_tien int,
    constraint fk_id_nhan_vien foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien),
    constraint fk_id_khach_hang foreign key(id_khach_hang) references khach_hang(id_khach_hang),
    constraint fk_id_dich_vu foreign key(id_dich_vu) references dich_vu(id_dich_vu)
);

-- alter table hop_dong
-- 	modify tong_tien = dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia;

create table dich_vu_di_kem (
	id_dich_vu_di_kem int auto_increment primary key,
    ten_dich_vu_di_kem varchar(45) not null unique,
    gia int,
    don_vi varchar(45), 
    trang_thai_kha_dung varchar(45)
);

create table hop_dong_chi_tiet (
	id_hop_dong_chi_tiet int auto_increment primary key,
    id_hop_dong int,
    id_dich_vu_di_kem int,
    so_luong int not null,
    constraint fk_id_hop_dong foreign key(id_hop_dong) references hop_dong(id_hop_dong),
    constraint fk_id_dich_vu_di_kem foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);


/*INSERT DATA*/

INSERT INTO vi_tri (ten_vi_tri) VALUE ('Director');
INSERT INTO vi_tri (ten_vi_tri) VALUE ('Manager');
INSERT INTO vi_tri (ten_vi_tri) VALUE ('Leader');
INSERT INTO vi_tri (ten_vi_tri) VALUE ('Employee');
INSERT INTO vi_tri (ten_vi_tri) VALUE ('Trainee');

INSERT INTO trinh_do (trinh_do) VALUE ('Master');
INSERT INTO trinh_do (trinh_do) VALUE ('Bachelor');
INSERT INTO trinh_do (trinh_do) VALUE ('Associate');
INSERT INTO trinh_do (trinh_do) VALUE ('Undergraduate');

INSERT INTO bo_phan (ten_bo_phan) VALUE ('Services');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Legal');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Research and Development');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Training');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Business Development');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Sales');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Marketing');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Support');

insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Noelyn Vicar', 3, 3, 6, '1971-08-20', 554320019, 10000000, '585 719 5624', 'nvicar0@surveymonkey.com', '46 International Parkway Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Salim Dear', 3, 2, 7, '1979-09-05', 181690537, 15000000, '323 251 5917', 'sdear1@pinterest.com', '518 Roth Place Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Auroora Mc Caughan', 2, 3, 7, '1980-06-19', 899882924, 22000000, '764 436 0772', 'amc2@arstechnica.com', '187 Hoepker Park Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Winni Girardez', 1, 3, 1, '1960-11-02', 647576659, 30000000, '769 278 0806', 'wgirardez3@state.tx.us', '4 Oneill Parkway Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Salvatore Albany', 2, 3, 6, '1976-02-28', 932068157, 16000000, '499 698 3354', 'salbany4@sina.com.cn', '06108 Randy Junction Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Lenna Paxeford', 4, 4, 7, '1959-05-17', 733704644, 5000000, '355 289 0203', 'lpaxeford5@bizjournals.com', '4 Crest Line Plaza Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Jameson Revely', 4, 4, 4, '1953-06-16', 360812732, 4000000, '135 682 6804', 'jrevely6@networksolutions.com', '2 Knutson Parkway Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Morse Chamberlin', 1, 3, 7, '1987-05-23', 860235449, 44000000, '249 147 6910', 'mchamberlin7@ftc.gov', '6116 Carioca Circle Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Araldo Novotna', 5, 3, 2, '1975-12-20', 127125078, 2000000, '375 621 9532', 'anovotna8@cmu.edu', '68 Logan Way Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Filia Mustchin', 3, 1, 4, '1987-07-10', 720723222, 12000000, '832 908 8203', 'fmustchin9@amazon.co.uk', '5197 Nelson Hill Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Chaunce Orchart', 2, 4, 6, '1995-09-30', 695488714, 21000000, '999 831 8799', 'corcharta@cdc.gov', '72233 Ruskin Parkway Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Raddy Brekonridge', 3, 2, 6, '1976-08-26', 698485662, 15000000, '779 851 3872', 'rbrekonridgeb@barnesandnoble.com', '602 Sheridan Junction Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Anatol Boumphrey', 5, 1, 5, '1951-10-08', 824661623, 2000000, '690 577 8639', 'aboumphreyc@telegraph.co.uk', '4683 Carberry Way Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Michel Mollnar', 5, 2, 6, '1996-01-02', 961557443, 2000000, '459 885 1357', 'mmollnard@dot.gov', '7814 Packers Place Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Drusie Townend', 3, 4, 4, '1987-05-09', 511615407, 14000000, '147 911 6096', 'dtownende@e-recht24.de', '113 Harbort Drive Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Byrann Beardshall', 3, 1, 5, '1954-07-20', 648788439, 10000000, '819 472 6797', 'bbeardshallf@macromedia.com', '1403 Arapahoe Park Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Beulah Sergent', 5, 4, 6, '1950-06-27', 851424027, 2000000, '171 168 0198', 'bsergentg@bloglines.com', '9098 Sage Center Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Averil Zumbusch', 2, 1, 3, '1968-04-09', 978955810, 16000000, '858 158 6178', 'azumbuschh@accuweather.com', '822 Sugar Road Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Heath McPeake', 3, 3, 2, '1973-08-03', 740418828, 14000000, '170 542 0983', 'hmcpeakei@squarespace.com', '99 Sauthoff Parkway Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Helsa Maghull', 1, 3, 8, '1964-02-22', 101288147, 34000000, '460 284 1990', 'hmaghullj@gizmodo.com', '91 Sloan Crossing Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Merv Oppie', 2, 2, 7, '1993-04-23', 460140027, 15000000, '495 565 8774', 'moppiek@home.pl', '8 Erie Crossing Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Mallorie Cannings', 1, 1, 7, '1991-01-30', 291082266, 35000000, '929 745 8372', 'mcanningsl@fastcompany.com', '6 Monument Point Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Alejandrina MacLoughlin', 1, 3, 8, '1950-09-01', 358886458, 34000000, '503 838 4146', 'amacloughlinm@plala.or.jp', '0308 Autumn Leaf Circle Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Patrick Surgener', 4, 2, 5, '1960-10-04', 482635288, 6000000, '198 911 9680', 'psurgenern@about.me', '24 Fair Oaks Alley Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Gladys Plumtree', 4, 1, 6, '1988-06-07', 347915576, 10000000, '804 506 2283', 'gplumtreeo@plala.or.jp', '040 Meadow Vale Hill Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Chick Howen', 5, 4, 8, '1992-04-18', 786810969, 2000000, '670 521 5433', 'chowenp@deliciousdays.com', '181 Messerschmidt Drive Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Gelya Tritton', 4, 4, 8, '1988-06-02', 594239490, 4000000, '801 202 4781', 'gtrittonq@techcrunch.com', '49 Sherman Street Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Humbert Yakushkin', 5, 4, 4, '1973-02-23', 258635456, 2000000, '122 847 4632', 'hyakushkinr@addthis.com', '8 Miller Park Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Debbi Empringham', 2, 2, 8, '1982-09-15', 537185481, 22000000, '572 390 6895', 'dempringhams@networksolutions.com', '99611 Memorial Court Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Pepito Darby', 2, 3, 8, '1985-02-05', 318902627, 20000000, '729 475 6960', 'pdarbyt@statcounter.com', '18 Maryland Junction Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Cissy Raynham', 2, 1, 5, '1968-11-21', 617920463, 25000000, '467 454 8034', 'craynhamu@cbsnews.com', '0698 Drewry Way Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Paulina Mussilli', 2, 4, 5, '1954-11-08', 839704138, 24000000, '599 969 0327', 'pmussilliv@gov.uk', '6 Merchant Trail Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Ailene Itzcak', 2, 2, 5, '1978-10-08', 119615185, 25000000, '582 323 5864', 'aitzcakw@mlb.com', '6656 Warbler Crossing Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Vinnie Notton', 4, 4, 7, '1956-02-23', 762706852, 7000000, '557 866 1126', 'vnottonx@slideshare.net', '60300 Monica Court Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Royce Kienl', 4, 3, 3, '1952-08-03', 540212064, 8000000, '333 119 9858', 'rkienly@posterous.com', '59794 Tennessee Crossing Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Burk Tarver', 2, 1, 3, '1976-09-24', 634653713, 22000000, '337 856 2678', 'btarverz@youtube.com', '3 Fieldstone Avenue Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Ethelin Treher', 2, 4, 2, '1974-10-11', 960647936, 23000000, '489 734 4313', 'etreher10@newsvine.com', '2378 Buell Court Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Bonnee Pye', 1, 2, 8, '1988-01-02', 737303896, 40000000, '521 211 8361', 'bpye11@europa.eu', '1 Comanche Drive Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Gregg Graben', 1, 1, 1, '1952-09-22', 988436721, 31000000, '577 413 8498', 'ggraben12@bigcartel.com', '5 Judy Plaza Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Giulia Barhems', 2, 2, 2, '1993-10-13', 540988663, 16000000, '337 477 2135', 'gbarhems13@youku.com', '5 Little Fleur Road Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Darbie Marco', 4, 1, 3, '1952-03-13', 402212054, 10000000, '454 708 6471', 'dmarco14@globo.com', '63963 Jana Place Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Colly Spataro', 3, 4, 1, '1982-03-17', 349653539, 11000000, '869 815 7195', 'cspataro15@wikispaces.com', '3 Pankratz Point Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Hollis Edmons', 1, 4, 5, '1994-03-14', 538908844, 32000000, '639 719 2413', 'hedmons16@jigsy.com', '0216 Hazelcrest Lane Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Magdalena Cogin', 4, 3, 3, '1954-08-18', 112304470, 4000000, '970 854 1514', 'mcogin17@sun.com', '59250 Wayridge Junction Da Nang');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Dannie Orknay', 5, 4, 3, '1962-03-10', 120132014, 2000000, '649 446 8289', 'dorknay18@purevolume.com', '29194 Garrison Pass Quang Tri');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Harwilll Lace', 1, 1, 1, '1959-06-23', 350669040, 47000000, '222 891 9455', 'hlace19@narod.ru', '36 Pond Point Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Colver Grogono', 5, 2, 4, '1981-09-16', 788157084, 2000000, '314 766 6938', 'cgrogono1a@amazon.com', '541 Arizona Park Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Natalina Kikke', 3, 1, 1, '1956-04-20', 682185022, 12000000, '547 555 4085', 'nkikke1b@arizona.edu', '04271 Paget Way Quang Ngai');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Ahmed Hadcroft', 4, 1, 4, '1969-05-16', 330264950, 4000000, '708 150 5512', 'ahadcroft1c@plala.or.jp', '87093 Golf Course Trail Vinh');
insert into nhan_vien (ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, luong, sdt, email, dia_chi) values ('Fred Shawcroft', 5, 1, 4, '1988-02-08', 214460091, 2000000, '504 143 7711', 'fshawcroft1d@blogtalkradio.com', '6746 Gerald Plaza Quang Tri');

insert into loai_khach(ten_loai_khach) value('Diamond');
insert into loai_khach(ten_loai_khach) value('Platinium');
insert into loai_khach(ten_loai_khach) value('Gold');
insert into loai_khach(ten_loai_khach) value('Silver');
insert into loai_khach(ten_loai_khach) value('Member');

insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Edmund Robottham', '1993-01-31', 223564108, '186 992 8524', 'erobottham0@mozilla.org', '68867 Lunder Junction Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Arlie Ostler', '1968-12-15', 305100625, '230 231 0768', 'aostler1@constantcontact.com', '28222 Village Place Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Charlena Garz', '1962-12-06', 780654869, '111 109 8680', 'cgarz2@google.co.uk', '995 Bay Center Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Matty Avrahamoff', '1984-08-14', 747408747, '948 317 2572', 'mavrahamoff3@1und1.de', '17 Shelley Street Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Brook McTaggart', '1974-03-11', 370327535, '271 754 8123', 'bmctaggart4@si.edu', '15608 Kim Trail Da Nang');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Coreen Baptista', '1966-01-19', 465749045, '144 305 1234', 'cbaptista5@thetimes.co.uk', '088 Scofield Plaza Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Mathilda McMennum', '1989-11-25', 252896320, '737 664 7317', 'mmcmennum6@sitemeter.com', '67 Muir Circle Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Aharon Firle', '1992-06-24', 835084157, '445 390 5475', 'afirle7@oakley.com', '37175 Carpenter Plaza Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (4, 'Caril Prudham', '1975-12-06', 334076593, '262 391 0229', 'cprudham8@accuweather.com', '28 Pond Way Da Nang');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (4, 'Clive Gowthorpe', '1999-11-08', 988241680, '801 330 4380', 'cgowthorpe9@harvard.edu', '2 Fieldstone Point Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Nollie McEwan', '1967-12-06', 902147384, '708 229 4355', 'nmcewana@sogou.com', '132 Sommers Drive Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Arabella Ross', '1971-03-28', 324257281, '270 342 9588', 'arossb@histats.com', '421 Rowland Crossing Da Nang');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Rafaello Leedes', '1993-04-30', 142881300, '570 483 1159', 'rleedesc@telegraph.co.uk', '31388 Dovetail Crossing Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (4, 'Natalya Yanne', '1971-03-22', 775129196, '244 885 2296', 'nyanned@bing.com', '7 Sherman Road Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Elias Rivers', '1981-09-28', 441748455, '424 649 6463', 'eriverse@mapquest.com', '311 Glacier Hill Pass Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (4, 'Brian Labrum', '1999-11-15', 984669163, '205 793 6342', 'blabrumf@facebook.com', '818 Menomonie Way Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Cesar Maulkin', '1989-02-11', 894207036, '616 939 1954', 'cmaulking@narod.ru', '5023 High Crossing Circle Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'L;urette Geffinger', '1973-04-30', 139342336, '213 898 6725', 'lgeffingerh@eventbrite.com', '1 Sheridan Street Da Nang');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Towney Maffin', '1981-09-16', 668733833, '484 652 9994', 'tmaffini@soundcloud.com', '4580 Luster Circle Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (4, 'Tobye Faley', '1989-05-04', 884653653, '820 963 2274', 'tfaleyj@unc.edu', '3 Forest Run Street Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Ernest Hymer', '1977-04-19', 113351718, '986 515 6196', 'ehymerk@wired.com', '07 Straubel Street Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Tiffy Juppe', '1994-03-07', 704745851, '619 861 1988', 'tjuppel@shop-pro.jp', '005 Rusk Place Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Bill Padgett', '2003-03-22', 686030287, '684 383 2435', 'bpadgettm@cyberchimps.com', '374 Loomis Court Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Faun Kubicki', '2001-01-03', 886825858, '528 982 9565', 'fkubickin@edublogs.org', '377 Red Cloud Street Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Oralee Pilling', '1962-10-23', 853965911, '882 242 4432', 'opillingo@instagram.com', '760 Buell Terrace Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Wiley Tilney', '1987-11-19', 386196017, '977 511 3184', 'wtilneyp@oaic.gov.au', '38650 Becker Pass Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Dollie Hatliff', '1986-02-20', 952848033, '481 765 5966', 'dhatliffq@netvibes.com', '7 Melody Center Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Gannie Creebo', '1999-12-06', 910359667, '472 461 7101', 'gcreebor@smh.com.au', '73513 Bonner Road Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Hadlee Brittan', '2001-12-15', 725319014, '524 367 3222', 'hbrittans@joomla.org', '5721 Havey Drive Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Filia Sambell', '2001-01-08', 598380636, '460 793 2060', 'fsambellt@topsy.com', '248 Melvin Junction Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Allin Gregson', '1975-09-03', 586824678, '153 348 0901', 'agregsonu@bluehost.com', '35 Lillian Parkway Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Erminia Elster', '1970-08-14', 904571593, '355 136 8310', 'eelsterv@unicef.org', '5646 Quincy Point Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (4, 'Vina Jeenes', '1982-11-19', 973886518, '542 617 0202', 'vjeenesw@is.gd', '52 Welch Alley Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Caron Rennicks', '2000-07-04', 705805782, '975 449 3066', 'crennicksx@psu.edu', '13715 Ramsey Court Da Nang');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Skippy Cassidy', '1976-09-03', 438031983, '276 294 1742', 'scassidyy@wisc.edu', '3876 Helena Road Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Robinson Dolling', '2001-06-24', 719921053, '541 792 7606', 'rdollingz@mapy.cz', '5 Elmside Lane Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Lesly Purrington', '1997-02-06', 430752071, '663 312 5371', 'lpurrington10@wisc.edu', '67 Glendale Drive Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Drake Duffan', '1991-11-16', 809462176, '661 353 6845', 'dduffan11@goodreads.com', '7 Charing Cross Trail Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Brendis Pavolini', '1992-02-17', 132849083, '928 446 3715', 'bpavolini12@acquirethisname.com', '49 Gateway Plaza Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Dennet Kenner', '1994-12-02', 510663862, '798 854 4608', 'dkenner13@ovh.net', '016 Holmberg Park Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Adelaide Mullinger', '1983-11-14', 939639996, '535 710 3540', 'amullinger14@virginia.edu', '9 Beilfuss Junction Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Terri Laviste', '1976-09-28', 162938897, '884 823 6726', 'tlaviste15@usgs.gov', '906 Sachtjen Court Quang Ngai');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Zsazsa Harkess', '1964-03-26', 663289932, '362 407 3094', 'zharkess16@army.mil', '9 Lakewood Gardens Court Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (5, 'Lula Rowsell', '1989-03-10', 731710339, '783 317 6203', 'lrowsell17@jalbum.net', '77718 Eastwood Point Da Nang');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Arleen Boddymead', '1985-03-22', 556063597, '483 914 1605', 'aboddymead18@state.tx.us', '23352 Esch Court Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Bartholomeo Mycock', '2003-02-26', 470186040, '941 771 7190', 'bmycock19@cloudflare.com', '15883 Dovetail Trail Quang Tri');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (1, 'Linea Althrope', '1976-12-27', 606644698, '869 947 1934', 'lalthrope1a@amazon.de', '5 Duke Pass Vinh');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (2, 'Judi Edgeson', '1983-12-01', 370755144, '166 214 7684', 'jedgeson1b@disqus.com', '0 Veith Crossing Da Nang');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Nataline Sofe', '1995-05-13', 752607689, '118 907 5403', 'nsofe1c@imgur.com', '820 Kings Pass Da Nang');
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) values (3, 'Katharine Pierrepoint', '1991-05-28', 570894324, '211 507 7621', 'kpierrepoint1d@businessweek.com', '74505 Lakeland Drive Quang Tri');

insert into kieu_thue (ten_kieu_thue, gia) values ('Year', 6600);
insert into kieu_thue (ten_kieu_thue, gia) values ('Month', 560);
insert into kieu_thue (ten_kieu_thue, gia) values ('Day', 20);
insert into kieu_thue (ten_kieu_thue, gia) values ('Hour', 1);

insert into loai_dich_vu (ten_loai_dich_vu) value ('Villa');
insert into loai_dich_vu (ten_loai_dich_vu) value ('House');
insert into loai_dich_vu (ten_loai_dich_vu) value ('Room');

insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 4, 'Vahlen', 290, 1, 3, 2900000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 2, 'Burrows', 70, 1, 2, 700000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 2, 'Parkside', 1400, 5, 20, 14000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 1, 'International', 1500, 4, 15, 15000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 2, 'Meadow Vale', 170, 1, 1, 1700000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 3, 'Bluejay', 80, 1, 4, 800000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 2, 'Farwell', 190, 1, 4, 1900000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 3, 'Fallview', 250, 1, 4, 2500000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 3, 'Blackbird', 1800, 4, 15, 18000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 4, 'Artisan', 2000, 5, 10, 20000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 2, 'Hanover', 100, 1, 3, 1000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 2, 'Armistice', 1700, 4, 10, 17000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 2, 'Warner', 1100, 5, 20, 11000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 2, 'Barnett', 140, 1, 2, 1400000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 3, 'Kinsman', 1900, 3, 15, 19000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 1, 'High Crossing', 1000, 5, 10, 10000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 1, 'Canary', 700, 1, 5, 7000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 4, 'Orin', 2000, 4, 20, 20000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 4, 'Bartillon', 1900, 4, 15, 19000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 4, 'Bonner', 1500, 5, 20, 15000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 2, 'Walton', 160, 1, 3, 1600000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 2, 'Clyde Gallagher', 70, 1, 1, 700000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 3, 'Cardinal', 120, 1, 2, 1200000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 2, 'North', 1000, 2, 5, 10000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 3, 'Butterfield', 300, 1, 2, 3000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 4, 'Moland', 800, 1, 5, 8000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 3, 'Talmadge', 1300, 3, 20, 13000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 2, 'Commercial', 1000, 2, 10, 10000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 3, 'Merchant', 1700, 4, 10, 17000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 3, 'Utah', 800, 1, 5, 8000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 4, 'Lakewood Gardens', 1000, 4, 20, 10000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 4, '6th', 60, 1, 2, 600000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 3, 'Grover', 600, 1, 10, 6000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 1, '3rd', 800, 2, 5, 8000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 1, 'Corben', 1000, 1, 10, 10000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 2, 'Duke', 120, 1, 3, 1200000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 3, 'Jenifer', 300, 1, 1, 3000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 2, 'Talmadge', 220, 1, 1, 2200000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 3, 'Eliot', 80, 1, 2, 800000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 1, 'Troy', 800, 1, 10, 8000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 4, 'Fulton', 500, 1, 10, 5000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 2, 'Loeprich', 600, 2, 5, 6000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 3, 'Vahlen', 180, 1, 3, 1800000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 3, 'Bay', 270, 1, 1, 2700000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 3, 'Park Meadow', 70, 1, 1, 700000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 4, 'Algoma', 1800, 3, 10, 18000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 1, 'Caliangt', 100, 1, 2, 1000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (3, 4, 'Anhalt', 260, 1, 2, 2600000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (2, 4, 'Menomonie', 800, 1, 5, 8000000);
insert into dich_vu (id_loai_dich_vu, id_kieu_thue, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue) values (1, 2, 'Hanover', 1700, 4, 15, 17000000);

insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (34, 33, 46, '2016-12-02', '2017-12-09', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (36, 30, 11, '2018-08-15', '2019-08-27', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (4, 10, 44, '2020-03-14', '2015-08-10', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (30, 20, 5, '2018-01-16', '2015-08-23', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (26, 39, 31, '2019-01-27', '2017-08-22', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (34, 15, 17, '2015-12-21', '2019-08-21', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (16, 23, 7, '2018-09-30', '2017-07-17', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (6, 10, 19, '2019-07-17', '2017-11-19', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (11, 22, 34, '2017-06-01', '2018-12-09', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (27, 24, 18, '2017-05-28', '2015-10-05', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (37, 37, 22, '2015-08-03', '2015-10-16', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (7, 33, 7, '2016-07-24', '2016-08-10', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (2, 11, 8, '2016-03-12', '2017-08-08', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (21, 40, 43, '2016-09-11', '2015-12-14', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (45, 38, 32, '2019-07-05', '2016-04-20', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (13, 13, 13, '2019-09-11', '2019-01-27', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (26, 17, 29, '2018-06-12', '2019-07-27', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (50, 22, 4, '2016-09-04', '2017-12-04', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (25, 9, 15, '2018-10-25', '2018-07-24', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (1, 21, 40, '2016-02-22', '2019-12-18', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (47, 15, 29, '2017-01-09', '2019-08-15', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (47, 50, 16, '2016-04-08', '2019-06-28', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (16, 8, 7, '2019-09-06', '2018-06-21', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (5, 15, 28, '2019-06-05', '2020-02-01', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (28, 12, 46, '2016-10-14', '2017-05-18', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (31, 33, 24, '2016-01-19', '2020-01-16', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (49, 12, 46, '2018-02-12', '2019-05-02', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (21, 43, 22, '2019-12-23', '2016-12-11', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (38, 21, 43, '2019-01-14', '2019-01-24', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (4, 44, 19, '2018-06-28', '2015-08-31', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (43, 19, 13, '2019-12-12', '2017-06-06', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (26, 44, 11, '2018-04-14', '2019-08-18', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (50, 8, 36, '2018-03-11', '2017-04-17', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (32, 13, 29, '2018-10-06', '2020-03-14', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (20, 37, 35, '2020-03-01', '2018-03-13', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (12, 29, 7, '2016-04-05', '2018-02-20', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (13, 23, 22, '2018-04-03', '2019-10-27', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (21, 11, 48, '2017-05-12', '2019-11-10', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (37, 36, 46, '2018-01-26', '2018-03-22', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (49, 33, 13, '2020-01-02', '2016-02-14', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (36, 3, 27, '2018-12-02', '2018-06-27', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (24, 4, 14, '2017-12-07', '2018-12-05', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (32, 29, 6, '2019-02-26', '2019-12-17', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (43, 23, 23, '2020-03-12', '2015-04-10', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (13, 44, 33, '2017-11-22', '2015-04-20', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (20, 15, 33, '2017-12-27', '2017-03-26', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (16, 12, 30, '2016-09-19', '2016-07-30', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (47, 27, 45, '2018-11-14', '2015-04-13', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (47, 28, 1, '2019-07-27', '2018-03-07', 500000);
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc) values (4, 25, 31, '2018-05-02', '2016-11-01', 500000);

SET SQL_SAFE_UPDATES = 0;
update hop_dong
set ngay_ket_thuc = ngay_lam_hop_dong
where ngay_ket_thuc < ngay_lam_hop_dong;

insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi) 
values ('Massage', 200000, 'lan');
insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi) 
values ('Karaoke', 100000, 'gio');
insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi) 
values ('Food', 150000, 'suat');
insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi) 
values ('Drink', 50000, 'phan');
insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi) 
values ('Car', 120000, 'chuyen');

insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (14, 2, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (41, 5, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (2, 3, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (44, 3, 2);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (5, 4, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (47, 4, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (16, 5, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (29, 1, 2);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (27, 3, 2);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (4, 1, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (46, 2, 2);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (48, 2, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (41, 2, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (25, 5, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (29, 2, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (31, 5, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (7, 4, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (10, 4, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (19, 5, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (2, 2, 2);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (17, 3, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (7, 3, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (27, 3, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (48, 4, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (49, 2, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (44, 4, 2);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (24, 4, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (10, 5, 2);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (15, 5, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (41, 4, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (50, 1, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (14, 3, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (18, 3, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (29, 3, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (28, 2, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (12, 1, 4);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (1, 3, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (42, 2, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (30, 5, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (42, 2, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (42, 2, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (46, 1, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (14, 4, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (40, 5, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (27, 4, 2);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (4, 4, 1);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (44, 5, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (9, 4, 2);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (11, 4, 3);
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong) values (4, 5, 2);


/*=============================================================================================
CÁC CÂU TRUY VẤN
===============================================================================================*/

/*=============================================================================================
2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là 
một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.*/

select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and length(ho_ten) <=15;

/*=============================================================================================
3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ 
ở “Đà Nẵng” hoặc “Quảng Trị”.*/

select * from khach_hang
where (year(now()) - year(ngay_sinh) between 18 and 50) 
and (dia_chi like '%Da Nang' or dia_chi like '%Quang Tri');

/*========================================================================================
4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/

select hop_dong.id_khach_hang, ho_ten, id_loai_khach, count(hop_dong.id_khach_hang) from hop_dong
inner join khach_hang
on hop_dong.id_khach_hang = khach_hang.id_khach_hang
where id_loai_khach = 1
group by hop_dong.id_khach_hang
order by count(hop_dong.id_khach_hang);

/*========================================================================================
5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc,
 TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong 
 và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phòng. 
 (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
 
select distinct khach_hang.id_khach_hang, ho_ten, ten_loai_khach, hop_dong.id_hop_dong, ten_dich_vu, 
ngay_lam_hop_dong, ngay_ket_thuc, sum(chi_phi_thue + so_luong * gia) as tong_tien
from  khach_hang 
left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
inner join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
left join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
left join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by khach_hang.id_khach_hang;

/*========================================================================================
6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ 
chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/

select dich_vu.id_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu, 
max(ngay_lam_hop_dong) as ngay_dat_gan_nhat
from dich_vu
inner join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
inner join hop_dong on dich_vu.id_dich_vu = hop_dong.id_dich_vu
group by id_dich_vu
having ngay_dat_gan_nhat < '2019-01-01';

/*========================================================================================
7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được 
Khách hàng đặt phòng  trong năm 2019.*/

select dich_vu.id_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu,
year(ngay_lam_hop_dong), max(ngay_lam_hop_dong)
from dich_vu
inner join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
inner join hop_dong on dich_vu.id_dich_vu = hop_dong.id_dich_vu
where year(ngay_lam_hop_dong) = '2018'
group by dich_vu.id_dich_vu
having year(max(ngay_lam_hop_dong)) < 2019;

/*========================================================================================
8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không 
trùng nhau.Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên*/

select ho_ten
from khach_hang
group by ho_ten;

select distinct ho_ten
from khach_hang;

/*========================================================================================
9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 
thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/

select month(ngay_lam_hop_dong), count(id_khach_hang)
from hop_dong
where year(ngay_lam_hop_dong) = '2019'
group by month(ngay_lam_hop_dong);

/*========================================================================================
10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm.
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
(được tính dựa trên việc count các IDHopDongChiTiet).*/

select hop_dong.id_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong, 
count(id_hop_dong_chi_tiet) 
from hop_dong_chi_tiet
inner join hop_dong on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
group by id_hop_dong;

/*========================================================================================
11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/

select khach_hang.id_khach_hang, id_loai_khach, dia_chi, dich_vu_di_kem.id_dich_vu_di_kem, ten_dich_vu_di_kem
from hop_dong_chi_tiet
inner join hop_dong on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
inner join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
where id_loai_khach = 1 and (dia_chi like '%Vinh' or dia_chi like '%Quang Ngai');

/*========================================================================================
12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ 
đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt 
vào 6 tháng đầu năm 2019.*/

select hop_dong.id_hop_dong, nhan_vien.ho_ten as TenNhanVien, khach_hang.ho_ten as TenKhachHang, 
khach_hang.sdt as SoDienThoaiKhachHang, hop_dong.id_dich_vu, ten_dich_vu, 
count(id_hop_dong_chi_tiet) as SoLuongDichVuDikem, tien_dat_coc
from hop_dong
inner join nhan_vien using (id_nhan_vien)
inner join khach_hang using(id_khach_hang)
inner join dich_vu using(id_dich_vu)
inner join hop_dong_chi_tiet using(id_hop_dong)
where (ngay_lam_hop_dong between '2019-10-01' and '2019-12-31')
and hop_dong.id_dich_vu not in 
(select hop_dong.id_dich_vu from hop_dong where ngay_lam_hop_dong between '2019-01-01' and '2019-06-30')
group by hop_dong.id_hop_dong
;

/*========================================================================================
13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/

create temporary table temp
select ten_dich_vu_di_kem, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_lan_su_dung
from hop_dong_chi_tiet
inner join dich_vu_di_kem using(id_dich_vu_di_kem)
group by ten_dich_vu_di_kem;
select * from temp;

create temporary table temp1
select max(so_lan_su_dung) as max_so_lan_su_dung
from temp;
select * from temp1;

select ten_dich_vu_di_kem, temp.so_lan_su_dung
from temp
inner join temp1 on temp.so_lan_su_dung = temp1.max_so_lan_su_dung;

drop table temp1;
drop table temp;


/*========================================================================================
14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/

select hop_dong_chi_tiet.id_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(id_hop_dong_chi_tiet) as SoLanSuDung
from hop_dong_chi_tiet
inner join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
inner join hop_dong on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
inner join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
inner join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
group by hop_dong_chi_tiet.id_dich_vu_di_kem
having SoLanSuDung = 1;

/*========================================================================================
15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, 
SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/

select nhan_vien.id_nhan_vien, ho_ten, trinh_do, ten_bo_phan, sdt, dia_chi, count(id_hop_dong)
from nhan_vien
inner join hop_dong
on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
inner join trinh_do
on nhan_vien.id_trinh_do = trinh_do.id_trinh_do
inner join bo_phan
on nhan_vien.id_bo_phan = bo_phan.id_bo_phan
where year(ngay_lam_hop_dong) between '2018' and '2019' 
group by id_nhan_vien
having count(id_hop_dong) <= 3;

/*========================================================================================
16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.*/

SET SQL_SAFE_UPDATES = 0;
delete from nhan_vien where id_nhan_vien not in
(
	select id_nhan_vien
	from hop_dong
	where year(ngay_lam_hop_dong) between 2017 and 2019
	group by id_nhan_vien
) ;

/*========================================================================================
17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 
là lớn hơn 10.000.000 VNĐ.*/

SET SQL_SAFE_UPDATES = 0;
update khach_hang,
(select hop_dong.id_khach_hang as id, sum(hop_dong.tong_tien) as tong_tien
from hop_dong
where year(ngay_lam_hop_dong) = 2019
group by hop_dong.id_khach_hang
having tong_tien > 10000000) as temp
set khach_hang.id_loai_khach = (select loai_khach.id_loai_khach from loai_khach where ten_loai_khach = 'Diamond')
where khach_hang.id_loai_khach = (select loai_khach.id_loai_khach from loai_khach where ten_loai_khach = 'Platinium')
and temp.id = khach_hang.id_khach_hang;

/*========================================================================================
18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).*/

delete khach_hang, hop_dong, hop_dong_chi_tiet
from khach_hang
inner join hop_dong using(id_khach_hang)
inner join hop_dong_chi_tiet using(id_hop_dong)
where not exists(select hop_dong.id_hop_dong where year(ngay_lam_hop_dong) > 2016 and khach_hang.id_khach_hang = hop_dong.id_khach_hang);

/*========================================================================================
19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.*/

update dich_vu_di_kem
set gia = gia * 2
where (
	select id_dich_vu_di_kem
    from hop_dong_chi_tiet
    having count(id_hop_dong_chi_tiet) > 10
);

/*========================================================================================
20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, 
NgaySinh, DiaChi.*/

select id_nhan_vien as id, nhan_vien.ho_ten, nhan_vien.email, nhan_vien.sdt, nhan_vien.ngay_sinh, nhan_vien.dia_chi
from nhan_vien
union
select id_khach_hang, khach_hang.ho_ten, khach_hang.email, khach_hang.sdt, khach_hang.ngay_sinh, khach_hang.dia_chi
from khach_hang;

/*==============================================================================================

================================================================================================*/
