use furama_resort;

INSERT INTO trinh_do (trinh_do) VALUE ('Master');
INSERT INTO trinh_do (trinh_do) VALUE ('Bachelor');
INSERT INTO trinh_do (trinh_do) VALUE ('Associate');
INSERT INTO trinh_do (trinh_do) VALUE ('Undergraduate');

select * from trinh_do
order by id_trinh_do;
