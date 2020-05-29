select * from tb_member;

ALTER TABLE tb_notice DROP COLUMN original_filepath;

ALTER TABLE tb_notice DROP COLUM


--파일테이블
CREATE TABLE TB_FILE ( 
F_IDX NUMBER, 
NOTICENO NUMBER NOT NULL, 
originFileName VARCHAR2(260 BYTE), 
renameFileName VARCHAR2(260 BYTE), 
savePath varchar2(260 byte),
PRIMARY KEY (F_IDX));

select * from tb_notice;

select * from tb_file;


--파일인덱스시퀀스
CREATE SEQUENCE 
S_TB_FILE_IDX 
START WITH 100000 
INCREMENT BY 1 
NOMAXVALUE;
