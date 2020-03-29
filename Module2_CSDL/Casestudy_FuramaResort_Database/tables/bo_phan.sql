use furama_resort;

INSERT INTO bo_phan (ten_bo_phan) VALUE ('Services');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Legal');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Research and Development');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Training');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Business Development');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Sales');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Marketing');
INSERT INTO bo_phan (ten_bo_phan) VALUE ('Support');

select * from bo_phan
order by id_bo_phan;
