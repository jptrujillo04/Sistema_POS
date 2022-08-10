CREATE TABLE IF NOT EXISTS sispos.companies (
  id_company serial PRIMARY KEY NOT NULL,
  company_name varchar(200) NOT NULL,
  status varchar(3) NOT NULL,
  nit varchar(16) NOT NULL,
  verification_digit varchar(2) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS sispos.permissions (
  id_permission serial PRIMARY KEY NOT NULL,
  id_company int NOT NULL,
  permissions_name varchar(45) NOT NULL,
  status varchar(3) DEFAULT NULL,
  CONSTRAINT "fk_Permissions_Companies" FOREIGN KEY ("id_company") REFERENCES sispos.companies ("id_company") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS sispos.roles (
  id_role serial PRIMARY KEY NOT NULL,
  id_company int NOT NULL,
  role_name varchar(45) NOT NULL,
  status varchar(3) NOT NULL,
  register_user varchar(30) NOT NULL,
  register_date TIMESTAMP DEFAULT NULL,
  CONSTRAINT "fk_Roles_Companies" FOREIGN KEY ("id_company") REFERENCES sispos.companies ("id_company")
);

CREATE TABLE IF NOT EXISTS sispos.roles_permissions (
  id_role_permission serial	PRIMARY KEY NOT NULL,
  id_role int NOT NULL,
  id_permission int NOT NULL,
  register_user varchar(30) NOT NULL,
  register_date TIMESTAMP DEFAULT NULL,
  CONSTRAINT "fk_Roles_has_Permissions_Permissions" FOREIGN KEY ("id_permission") REFERENCES sispos.permissions ("id_permission") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Roles_has_Permissions_Roles" FOREIGN KEY ("id_role") REFERENCES sispos.roles ("id_role") ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS sispos.users (
  id_user serial PRIMARY KEY NOT NULL,
  id_company int NOT NULL,
  name_user varchar(100) NOT NULL,
  account varchar(70) NOT NULL,
  password_user varchar(45) NOT NULL,
  status varchar(3) NOT NULL,
  register_user varchar(30) NOT NULL,
  register_date TIMESTAMP DEFAULT NULL,
  CONSTRAINT "fk_Users_Companies" FOREIGN KEY ("id_company") REFERENCES sispos.companies ("id_company")
);

CREATE TABLE IF NOT EXISTS sispos.users_roles (
  id_user_role serial PRIMARY KEY NOT NULL,
  id_role int NOT NULL,
  id_user int NOT NULL,
  register_user varchar(30) NOT NULL,
  register_date TIMESTAMP DEFAULT NULL,
  CONSTRAINT "fk_Roles_Users_Roles" FOREIGN KEY ("id_role") REFERENCES sispos.roles ("id_role") ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT "fk_Roles_Users_Users" FOREIGN KEY ("id_user") REFERENCES sispos.users ("id_user") ON DELETE NO ACTION ON UPDATE NO ACTION
);
