create table member(
  mem_id varchar2(20) not null primary key,
  mem_name varchar2(15) not null,
  mem_passwd varchar2(15) not null,
  mem_cell varchar2(15) not null,
  mem_email varchar2(50) not null,
  mem_address varchar2(100) not null,
  SAMPLE3_POSTCODE number,
  mem_regdate date not null,
  mrt_status number(1) default(0) not null,
  mem_level number(1) default(0) not null
);
--mem_penalty 삭제. 대신 penalty 테이블 추가함

create table speech( 
  speech_num number not null primary key,
  speech_title varchar2(100) not null,
  speech_content clob not null,
  speech_regdate date not null,
  speech_people number(3) not null,
  speech_hit number(4) default(0),
  speech_date date not null,
  speech_location varchar2(100) not null,
  speech_location2 varchar2(100),
  speech_price number(5) default(0),
  speech_status number(1) default(0) not null,
  mem_id varchar2(20) not null,
  constraint speech_fk1 foreign key (mem_id) references member (mem_id)
);
create sequence speech_num;

create table speech_reservation(
  speech_reserve_num number not null primary key,
  speech_num number not null,
  mem_id varchar2(20) not null,
  speech_reserve_status number(1) default 0 not null,
  speech_reserve_date date not null,
  constraint speech_reservation_member_fk1 foreign key(mem_id) references member(mem_id),
  constraint speech_reservation_speech_fk2 foreign key(speech_num) references speech(speech_num)
);
create sequence speech_reservation_seq;

create table booklist(
  list_num number not null primary key,
  list_code varchar2(13) not null,
  list_title varchar2(100) not null,
  list_writer varchar2(50) not null,
  list_publish varchar2(50) not null,
  list_page number(5) not null,
  list_filename varchar2(100),
  list_regdate date not null,
  list_grade number(1),
  list_status number(1) default 0 not null,
  mem_id varchar2(20) not null,
  constraint booklist_member_fk1 foreign key(mem_id) references member(mem_id)  
);
create sequence booklist_seq;

create table bookrent(
  rent_num number not null primary key,
  list_num number not null,
  mem_id varchar2(20) not null,
  rent_regdate date not null,
  rent_returndate date,
  rent_status number(1) default 0 not null,
  constraint bookrent_member_fk1 foreign key(mem_id) references member(mem_id),
  constraint bookrent_booklist_fk2 foreign key(list_num) references booklist(list_num)
);
create sequence bookrent_seq;

create table wishlist(
  wish_num number not null primary key,
  wish_title varchar2(100) not null,
  wish_writer varchar2(50) not null,
  wish_publish varchar2(50) not null,
  wish_regdate date not null,
  wish_status number(1) default 0 not null,
  mem_id varchar2(20) not null,
  constraint wishlist_member_fk1 foreign key(mem_id) references member(mem_id)
);
create sequence wishlist_seq;

create table notice(
  notice_num number not null primary key,
  mem_id varchar2(20) not null,
  notice_title varchar2(40) not null,
  notice_content clob not null,
  notice_regdate date not null,
  notice_hit number(4) default 0 not null,
  constraint notice_member_fk1 foreign key(mem_id) references member(mem_id)
);
create sequence notice_seq;

create table review(
  review_num number not null primary key,
  mem_id varchar2(20) not null,
  review_title varchar2(40) not null,
  review_content clob not null,
  review_regdate date not null,
  review_hit number(4) default 0 not null,
  review_like number(4) default 0 not null,
  review_dislike number(4) default 0 not null,
  review_file varchar2(100),
  constraint review_member_fk1 foreign key(mem_id) references member(mem_id)
);
create sequence review_num;

create table review_reply(
  review_re_num number not null primary key,
  review_num number not null,
  mem_id varchar2(20) not null,
  review_re_content varchar2(600) not null,
  review_re_regdate date not null,
  constraint review_re_member_fk1 foreign key(mem_id) references member(mem_id),
  constraint review_re_review_fk2 foreign key(review_num) references review(review_num)
);
create sequence review_re_num;

create table grade(
  grade_num number not null primary key,
  mem_id varchar2(20) not null,
  list_num number(10) not null,
  grade_star number(2) not null,
  grade_regdate date not null,
  grade_content varchar2(600) not null,
  constraint grade_member_fk1 foreign key(mem_id) references member(mem_id),
  constraint grade_booklist_fk2 foreign key(list_num) references booklist(list_num)
);
create sequence grade_seq;

create table event(
  event_num number not null primary key,
  mem_id varchar2(20) not null,
  event_title varchar2(40) not null,
  event_content clob not null,
  event_regdate date not null,
  event_hit number(3) default 0 not null,
  event_startdate date not null,
  event_enddate date not null,
  event_filename varchar2(100),
  constraint event_member_fk1 foreign key(mem_id) references member(mem_id)
);
create sequence event_seq;

create table qna(
  qna_num number not null primary key,
  mem_id varchar2(20) not null,
  qna_passwd varchar2(15) not null,
  qna_title varchar2(40) not null,
  qna_content clob not null,
  qna_regdate date not null,
  qna_hit number(4) default 0 not null,
  constraint qna_member_fk1 foreign key(mem_id) references member(mem_id)
);
create sequence qna_num;

create table qna_reply(
  qna_re_num number not null primary key,
  qna_num number not null,
  mem_id varchar2(20) not null,
  qna_re_content varchar2(600) not null,
  qna_re_regdate date not null,
  constraint qna_re_member_fk1 foreign key(mem_id) references member(mem_id),
  constraint qna_re_qna_fk1 foreign key(qna_num) references qna(qna_num)
);
create sequence qna_re_num;

create table chat(
  chat_num number not null primary key,
  chat_name varchar2(100) not null,
  chat_content clob not null,
  mem_id varchar2(20) not null,
  constraint chat_member_fk1 foreign key(mem_id) references member(mem_id)
);
create sequence chat_seq;

create table marathon(
    marathon_num number not null primary key,
    mem_id varchar2(20) not null,
    marathon_page number not null,
    marathon_regdate date not null,
    marathon_status number(1) default(0) not null,
    constraint marathon_fk1 foreign key (mem_id) references member (mem_id)
);
create sequence marathon_seq;

create table penalty( 
  penalty_num number not null primary key,
  penalty_regdate date not null,
  penalty_blockCancelDate date not null,
  penalty_reason varchar2(300) not null, 
  mem_id varchar2(20) not null,
  constraint penalty_fk1 foreign key (mem_id) references member (mem_id)
);
create sequence penalty_num;

create table basket(
  basket_num number not null primary key,
  basket_price varchar2(20),
  basket_amount number default(1) not null,
  mem_id varchar2(20) not null,
  list_num number not null,
  basket_rentDate varchar2(20),
  basket_returnDate varchar2(20),
  constraint basket_fk1 foreign key (mem_id) references member (mem_id),
  constraint basket_fk2 foreign key(list_num) references booklist(list_num)
);
create sequence basket_seq;

create table delivery(
  delivery_num number not null primary key,
  mem_id varchar2(20) not null,
  delivery_name varchar2(40),
  delivery_email varchar2(40),
  delivery_cell varchar2(40),
  sample3_postcode varchar2(40),
  delivery_address varchar2(300),
  constraint delivery_fk1 foreign key (mem_id) references member (mem_id)
);
create sequence delivery_seq;

create table review_like(
	review_like_num number not null primary key,
	mem_id varchar2(20) not null,
	review_num number not null,
	review_like_status number(1) not null,
	constraint review_like_fk1 foreign key (mem_id) references member (mem_id),
	constraint review_like_fk2 foreign key (review_num) references review (review_num)
);
create sequence review_like_seq;