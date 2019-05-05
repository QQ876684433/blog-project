drop table if exists t_article;
drop table if exists t_tag;

create table t_article
(
    id       int(12)      not null primary key auto_increment,
    title    varchar(255) not null,
    date     date         not null,
    tag_id   int(12)      not null,
    abstract varchar(255) not null
);

create table t_tag
(
    id          int(12)      not null primary key auto_increment,
    name        varchar(32)  not null,
    article_num int(12)      not null,
    articles    varchar(255) not null
);
