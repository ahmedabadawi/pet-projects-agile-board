CREATE TABLE IF NOT EXISTS public.auth_user (
	email	varchar(255) NOT NULL,
	password	varchar(255) NOT NULL,
	roles			varchar(255) NOT NULL,
	user_id		integer NOT NULL,
	last_login	timestamp ,
	status			varchar(10) NOT NULL,
	PRIMARY KEY (email)
);

CREATE TABLE IF NOT EXISTS public.app_user (
	id			integer NOT NULL,	
	email				varchar(255) NOT NULL,
	first_name	varchar(255) NOT NULL,
	last_name		varchar(255) NOT NULL,
	bio					varchar(255),
	photo				varchar(255),
	
	PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.project_id_seq;

CREATE TABLE IF NOT EXISTS public.project (
	id		integer NOT NULL	DEFAULT nextval('public.project_id_seq'),
	admin_id	integer NOT NULL,
	code	varchar(20) NOT NULL,
	title		varchar(255) NOT NULL,
	description	varchar(255) NOT NULL,
	start_date	timestamp,
	end_date	timestamp ,
	PRIMARY KEY (id),
	CONSTRAINT project_admin_user_fk FOREIGN KEY (admin_id)
		REFERENCES public.app_user (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER SEQUENCE public.project_id_seq
	OWNED BY public.project.id;

CREATE OR REPLACE VIEW public.project_details AS
	SELECT 
		p.id AS project_id, 
		p.code, 
		p.title, 
		p.description, 
		p.start_date, 
		p.end_date, 
		p.admin_id, 
		u.email AS admin_email, 
		u.first_name AS admin_first_name, 
		u.last_name AS admin_last_name
	FROM public.project p 
	INNER JOIN public.app_user u on u.id = p.admin_id;
	
CREATE SEQUENCE IF NOT EXISTS public.project_member_id_seq;

CREATE TABLE IF NOT EXISTS public.project_member (
	id		integer NOT NULL	DEFAULT nextval('public.project_member_id_seq'),
	user_id	integer NOT NULL,
	email	varchar(255) NOT NULL,
	first_name	varchar(255) NOT NULL,
	last_name		varchar(255) NOT NULL,
	project_id	integer NOT NULL,
	project_code	varchar(20) NOT NULL,
	start_date	timestamp,
	PRIMARY KEY (id),
	CONSTRAINT project_member_project_fk FOREIGN KEY (project_id)
		REFERENCES public.project (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT project_member_user_fk FOREIGN KEY (user_id)
		REFERENCES public.app_user (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER SEQUENCE public.project_member_id_seq
	OWNED BY public.project_member.id;
	
	
CREATE SEQUENCE IF NOT EXISTS public.work_item_id_seq;

CREATE TABLE IF NOT EXISTS public.work_item (
	id		integer NOT NULL	DEFAULT nextval('public.work_item_id_seq'),
	project_id	integer NOT NULL,
	project_code	varchar(20) NOT NULL,
	title	varchar(255) NOT NULL,
	description	varchar(255) NOT NULL,
	stereotype	varchar(10) NOT NULL,
	status			varchar(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT work_item_project_fk FOREIGN KEY (project_id)
		REFERENCES public.project (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER SEQUENCE public.work_item_id_seq
	OWNED BY public.work_item.id;

