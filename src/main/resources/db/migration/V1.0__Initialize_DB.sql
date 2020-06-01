create table boards (
    id          bigserial not null,
    board_name        varchar(3) not null,
    description       varchar(100),
    time_created      timestamp,

    primary key(id)
);

create table tags (
    id          bigserial not null,
    tag_name    varchar(20) not null,
    description text,
    board_id    bigint not null,

    primary key(id),
    foreign key(board_id) references boards(id)
);

create table threads (
    id          bigserial not null,
    board_id    bigint not null,
    tag_id      bigint not null,

    primary key(id),
    foreign key(board_id) references boards(id),
    foreign key(tag_id) references tags(id)
);

create table posts (
    id              bigserial not null,
    thread_id       bigint not null,
    title           text,
    content         text not null,
    thread_starter  boolean not null,
    time_posted     timestamp not null,

    primary key(id),
    foreign key(thread_id) references threads(id)
);

create table images (
    id              bigserial not null,
    path            varchar(100) unique not null,
    is_nsfw         boolean not null,
    post_id         bigint not null,

    primary key(id),
    foreign key(post_id) references posts(id)
);