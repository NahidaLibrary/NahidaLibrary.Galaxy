-- 建表

create table n_album
(
    id         bigserial
        primary key,
    name       varchar(64)  not null,
    cover_link varchar(128) not null,
    create_at  timestamp    not null,
    update_at  timestamp,
    is_deleted integer default 0     not null
);

create table n_music
(
    id           bigserial
        primary key,
    name         varchar(64)           not null,
    link         varchar(128)          not null,
    trainer      varchar(64),
    trainer_link varchar(128),
    create_at    timestamp             not null,
    update_at    timestamp,
    is_deleted integer default 0     not null
);

create table n_music_album
(
    id         bigserial
        primary key,
    music_id   bigint            not null,
    album_id   bigint            not null,
    create_at  timestamp         not null,
    update_at  timestamp,
    is_deleted integer default 0 not null
);

create table n_account
(
    id         bigserial
        primary key,
    username   varchar(64)           not null,
    password   varchar(64)           not null,
    nickname   varchar(64)           not null,
    email      varchar(64),
    secret     varchar(64)           not null,
    create_at  timestamp             not null,
    update_at  timestamp,
    is_deleted integer default 0     not null
);

create table n_third_account
(
    id         bigserial
        primary key,
    account_id integer               not null,
    third_id   varchar(128),
    type       varchar(64),
    create_at  timestamp             not null,
    update_at  timestamp,
    is_deleted integer default 0     not null
);



-- 索引
-- 「唯一键」与「逻辑删除」冲突解决方案备忘: 逻辑删除字段改为Int类型，删除时将其所有删除的明细的删除标记+1即非0都是代表被删除

create unique index n_music_name_uindex
    on n_music (name, is_deleted);

create unique index n_album_name_uindex
    on n_album (name, is_deleted);

create unique index n_music_album_id_uindex
    on n_music_album (music_id, album_id);
