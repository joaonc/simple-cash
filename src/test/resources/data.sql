--
-- Script to populate DB with test data.
-- Note: Some syntax is mysql specific.
--

-- Bank
insert ignore into bank (code, name) values ('BNK1', 'Bank 1 Name');
insert ignore into bank (code, name) values ('BNK2', 'Bank 2 Name');

-- Contact Info Type
-- Check enum ContactInfoType.Type for values.
insert ignore into contactinfotype (id, id_type, name, description) values
    (1, 1, 'Email', 'Email description here'),
    (2, 2, 'Telephone', 'Telephone description here'),
    (3, 3, 'Url', 'Url description here'),
    (4, 4, 'Note', 'Note description here');

-- Contact
-- Spans the tables contact, contactinfo, contact_contactinfo, address, contact_address
-- Requires table contactinfotype to be populated
insert into contact (name) values ('Jonathan Donahue');
set @id_contact = last_insert_id();

-- Contact Info
insert into contactinfo (id_contactInfoType, type, value) values
	(1, 'Work', 'jon.doe@jondoeresearch.com');
insert into contact_contactinfo (id_contact, id_contactInfo) values
    (@id_contact, last_insert_id());
insert into contactinfo (id_contactInfoType, type, value) values
	(1, 'Personal', 'jon_doe21@personal_email.com');
insert into contact_contactinfo (id_contact, id_contactInfo) values
    (@id_contact, last_insert_id());
insert into contactinfo (id_contactInfoType, type, value) values
	(2, 'Work - Direct', '555 3215');
insert into contact_contactinfo (id_contact, id_contactInfo) values
    (@id_contact, last_insert_id());
insert into contactinfo (id_contactInfoType, type, value) values
	(2, 'Work - General', '555 3200');
insert into contact_contactinfo (id_contact, id_contactInfo) values
    (@id_contact, last_insert_id());
insert into contactinfo (id_contactInfoType, type, value) values
	(2, 'Cel', '555 1234');
insert into contact_contactinfo (id_contact, id_contactInfo) values
    (@id_contact, last_insert_id());
insert into contactinfo (id_contactInfoType, type, value) values
	(3, 'Work', 'www.jondoeresearch.com');
insert into contact_contactinfo (id_contact, id_contactInfo) values
    (@id_contact, last_insert_id());

-- Address
insert into address (name, address1, address2, country, county, postalCode, region, state, notes) values
	('name test', '123 Main St', null, null, null, '98318', null, 'VA', 'Used to live here.');
insert into contact_address (id_contact, id_address ) values
	(@id_contact, last_insert_id());
