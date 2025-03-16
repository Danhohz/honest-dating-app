create table if not exists "user"
(
    id uuid primary key,
    name varchar(255) not null,
    login varchar(255) not null,
    email varchar(255),
    age smallint,
    phone varchar(255),
    password varchar(255),
    description varchar(255)
);