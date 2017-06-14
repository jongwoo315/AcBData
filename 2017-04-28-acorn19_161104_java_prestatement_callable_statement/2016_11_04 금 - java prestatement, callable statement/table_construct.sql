  create table manage_std(
  std_number number(10),
  std_name varchar2(10),
  std_address varchar2(40),
  std_phone varchar2(15),
  std_major varchar2(20),
  constraint manage_std_number_pk primary key(std_number),
  constraint manage_std_std_name_fk foreign key(std_name) references manage_class(class_std)
);

create table manage_score(
  score_std_name varchar2(10),
  score_kor number(3),
  score_eng number(3),
  score_math number(3),
  constraint manage_score_name_pk primary key(score_std_name)
);

create table manage_prof(
  prof_name varchar2(10),
  prof_number number(10),
  prof_department varchar2(20),
  prof_class varchar2(10),
  constraint manage_prof_number_pk primary key(prof_number)
);

create table manage_class(
  class_prof varchar2(10),
  class_std varchar2(10),
  class_lecture_name varchar2(10),
  class_lecture_code number(5),
  class_material varchar2(15),
  constraint manage_class_lecture_code_pk primary key(class_lecture_code)
);
