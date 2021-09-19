create table if not exists installment_saving(
	id int auto_increment,
	tenor int not null,
	first_deposit_amount numeric(28,10) not null, 
	monthly_deposit_amount numeric(28,10) not null, 
	purpose varchar(200),
	status varchar(50) not null,
	creation_date datetime not null,
	primary key(id)
);
