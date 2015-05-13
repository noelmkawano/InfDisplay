# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact (
  id                        bigint not null,
  first_name                varchar(255),
  constraint pk_contact primary key (id))
;

create table diet_type (
  id                        bigint not null,
  diet_type                 varchar(255),
  constraint pk_diet_type primary key (id))
;


create table contact_diet_type (
  contact_id                     bigint not null,
  diet_type_id                   bigint not null,
  constraint pk_contact_diet_type primary key (contact_id, diet_type_id))
;
create sequence contact_seq;

create sequence diet_type_seq;




alter table contact_diet_type add constraint fk_contact_diet_type_contact_01 foreign key (contact_id) references contact (id);

alter table contact_diet_type add constraint fk_contact_diet_type_diet_typ_02 foreign key (diet_type_id) references diet_type (id);

# --- !Downs

drop table if exists contact cascade;

drop table if exists contact_diet_type cascade;

drop table if exists diet_type cascade;

drop sequence if exists contact_seq;

drop sequence if exists diet_type_seq;

