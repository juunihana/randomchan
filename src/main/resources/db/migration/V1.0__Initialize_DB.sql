create table threads (
    id          bigserial,

    primary key(id)
);

create table posts (
    id              bigserial,
    thread_id       bigint,
    title           text,
    content         text,
    thread_starter  boolean,
    time_posted     timestamp,

    primary key(id),
    foreign key(thread_id) references threads(id)
);