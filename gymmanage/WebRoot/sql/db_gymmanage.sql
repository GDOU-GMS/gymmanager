/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/12/3 8:34:19                            */
/*==============================================================*/


drop table if exists tb_admin;

drop table if exists tb_equipment;

drop table if exists tb_equipmentLeasing;

drop table if exists tb_equipmentType;

drop table if exists tb_events;

drop table if exists tb_notice;

drop table if exists tb_site;

drop table if exists tb_siteOrder;

drop table if exists tb_siteType;

drop table if exists tb_siteUsage;

drop table if exists tb_user;

/*==============================================================*/
/* Table: tb_admin                                              */
/*==============================================================*/
create table tb_admin
(
   id                   int not null auto_increment,
   account              char(20),
   password             varchar(20),
   permission           char(20),
   name                 varchar(20),
   telephone            char(20),
   birthday             date,
   email                varchar(40),
   address              varchar(50),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_equipment                                          */
/*==============================================================*/
create table tb_equipment
(
   id                   int not null auto_increment,
   name                 varchar(20),
   description          text,
   loanable             int,
   totalNum             int,
   typeId               int,
   feeScale             float,
   underRepair          int,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_equipmentLeasing                                   */
/*==============================================================*/
create table tb_equipmentLeasing
(
   id                   int not null auto_increment,
   equipmentId          int,
   userId               int,
   startDate            date,
   endDate              date,
   price                float,
   num                  int,
   statue               char(10),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_equipmentType                                      */
/*==============================================================*/
create table tb_equipmentType
(
   id                   int not null auto_increment,
   type                 varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_events                                             */
/*==============================================================*/
create table tb_events
(
   id                   int not null auto_increment,
   siteId               int,
   startTime            datetime,
   endTime              datetime,
   statue               varchar(10),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_notice                                             */
/*==============================================================*/
create table tb_notice
(
   id                   int not null auto_increment,
   title                varchar(40),
   content              text,
   time                 date,
   image                varchar(40),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_site                                               */
/*==============================================================*/
create table tb_site
(
   id                   int not null auto_increment,
   typeId               int,
   name                 varchar(20),
   statue               char(20),
   feeScale             float,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_siteOrder                                          */
/*==============================================================*/
create table tb_siteOrder
(
   id                   int not null auto_increment,
   stratTime            datetime,
   endTime              datetime,
   userId               int,
   siteId               int,
   statue               varchar(10),
   orderTime            datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_siteType                                           */
/*==============================================================*/
create table tb_siteType
(
   id                   int not null auto_increment,
   type                 varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_siteUsage                                          */
/*==============================================================*/
create table tb_siteUsage
(
   id                   int not null auto_increment,
   stratTime            time,
   endTime              time,
   price                float,
   userId               int,
   siteId               int,
   statue               varchar(10),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   id                   int not null auto_increment,
   studentNo            char(20),
   password             varchar(20),
   name                 char(20),
   academy              varchar(40),
   major                varchar(40),
   className            varchar(40),
   gender               char(20),
   telephone            char(20),
   primary key (id)
);

alter table tb_equipment add constraint FK_Relationship_2 foreign key (typeId)
      references tb_equipmentType (id) on delete restrict on update restrict;

alter table tb_equipmentLeasing add constraint FK_Relationship_11 foreign key (equipmentId)
      references tb_equipment (id) on delete restrict on update restrict;

alter table tb_equipmentLeasing add constraint FK_Relationship_12 foreign key (userId)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_events add constraint FK_Relationship_9 foreign key (siteId)
      references tb_site (id) on delete restrict on update restrict;

alter table tb_site add constraint FK_Relationship_10 foreign key (typeId)
      references tb_siteType (id) on delete restrict on update restrict;

alter table tb_siteOrder add constraint FK_Relationship_7 foreign key (userId)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_siteOrder add constraint FK_Relationship_8 foreign key (siteId)
      references tb_site (id) on delete restrict on update restrict;

alter table tb_siteUsage add constraint FK_Relationship_5 foreign key (userId)
      references tb_user (id) on delete restrict on update restrict;

alter table tb_siteUsage add constraint FK_Relationship_6 foreign key (siteId)
      references tb_site (id) on delete restrict on update restrict;

