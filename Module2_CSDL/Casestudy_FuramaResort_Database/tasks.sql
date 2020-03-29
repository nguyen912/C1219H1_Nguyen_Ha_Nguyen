use furama_resort;

/*========================================================================================
2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là 
một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.*/

select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and length(ho_ten) <=15;

/*========================================================================================
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

select count(id_khach_hang), month(ngay_lam_hop_dong)
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
inner join hop_dong
on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
group by id_hop_dong;

/*========================================================================================
11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/

select khach_hang.id_khach_hang, id_loai_khach, dia_chi, dich_vu_di_kem.id_dich_vu_di_kem, ten_dich_vu_di_kem
from hop_dong_chi_tiet
inner join hop_dong
on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
inner join dich_vu_di_kem
on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
inner join khach_hang
on hop_dong.id_khach_hang = khach_hang.id_khach_hang
where id_loai_khach = 1 and (dia_chi like '%Vinh' or dia_chi like '%Quang Ngai')
group by khach_hang.id_khach_hang;

/*========================================================================================
12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ 
đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt 
vào 6 tháng đầu năm 2019.*/

select hop_dong.id_hop_dong, nhan_vien.ho_ten as TenNhanVien, khach_hang.ho_ten as TenKhachHang, 
khach_hang.sdt, dich_vu.id_dich_vu, ten_dich_vu,
sum(so_luong) as SoLuongDichVuDikem,
max(ngay_lam_hop_dong) as ngay_lam_hop_dong_gan_nhat, ngay_lam_hop_dong
from hop_dong
inner join hop_dong_chi_tiet
on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
inner join dich_vu
on  hop_dong.id_dich_vu = dich_vu.id_dich_vu
inner join nhan_vien
on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
inner join khach_hang
on hop_dong.id_khach_hang = khach_hang.id_khach_hang
group by hop_dong.id_dich_vu
having ngay_lam_hop_dong_gan_nhat between '2019-10-01' and '2019-12-31'
and ngay_lam_hop_dong not between '2019-01-01' and '2019-06-30';


/*========================================================================================
13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/

select dich_vu_di_kem.id_dich_vu_di_kem, ten_dich_vu_di_kem, max(so_luot_su_dung) as luot_su_dung_nhieu_nhat
from (
	select id_dich_vu_di_kem , 
		count(id_hop_dong_chi_tiet) as so_luot_su_dung
    from hop_dong_chi_tiet
	group by id_dich_vu_di_kem) luot_su_dung
inner join dich_vu_di_kem
on luot_su_dung.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem;

/*========================================================================================
14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/

select hop_dong_chi_tiet.id_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(id_hop_dong_chi_tiet) as SoLanSuDung
from hop_dong_chi_tiet
inner join dich_vu_di_kem
on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
inner join hop_dong
on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
inner join dich_vu
on hop_dong.id_dich_vu = dich_vu.id_dich_vu
inner join loai_dich_vu
on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
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
update khach_hang
set id_loai_khach = 1
where id_loai_khach = 2 and id_khach_hang in(
	select (chi_phi_thue + so_luong * gia) as tong_tien
    from hop_dong
    inner join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
    inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
    inner join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    group by id_khach_hang
    having sum(tong_tien) > 10000000
);

select * from khach_hang
where id_loai_khach = 3;

select khach_hang.id_khach_hang, khach_hang.id_loai_khach, (chi_phi_thue + so_luong * gia) as tong_tien
    from hop_dong
    inner join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
    inner join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
    inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
    inner join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    group by id_khach_hang
    having sum(tong_tien) > 10000000;

/*========================================================================================
18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).*/

delete from khach_hang
where (
	select id_khach_hang
	from hop_dong 
    group by id_khach_hang
    having year(max(ngay_lam_hop_dong)) < 2016
);

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






select * from loai_khach;
select * from khach_hang;
select * from hop_dong;
select * from dich_vu;
select * from hop_dong_chi_tiet;