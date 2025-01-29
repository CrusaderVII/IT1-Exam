create table if not exists agreement (
    agreement_id uuid primary key default gen_random_uuid(),
    create_date date,
    name varchar
);

create table if not exists document (
	document_id uuid primary key default gen_random_uuid(),
	sign_date date,
	create_date date,
	number integer,
	name varchar,
	agreement_id uuid references agreement (agreement_id) on delete cascade on update cascade
);