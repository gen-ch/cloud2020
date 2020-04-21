
create table `payment` (
`id` bigint(20) not null auto_increment comment "ID",
`serial` varchar(200) default '',
primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;