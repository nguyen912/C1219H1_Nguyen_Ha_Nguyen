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




