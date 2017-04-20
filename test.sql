CREATE TABLE BOOKS
(
	ISBN numeric(13) UNIQUE,
	BOOK_NAME varchar(100),
	PUBLISHER_NAME varchar(50),
	NUM_OF_PAGES integer,
	STOCK integer
);

