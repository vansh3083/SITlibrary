### How to run the program?

* #1 Install mariadb on port 3306 and give username as 'root'

* #2 give password for 'root' user as 'root'

* #3 create a database with name 'bookdb' using following command.
    create database bookdb;

* #4 select bookdb database.
    use bookdb;

* #5 Create the following tables 


            create table book
        (
            book_isbn varchar(20) primary key,
            book_title varchar(50),
            category varchar(20),
            no_of_books int
        );

        create table author
        (
            author_name varchar(30),
            author_mail_id varchar(50),
            book_isbn varchar(20),
            foreign key(book_isbn) references book(book_isbn)
        );

        create table student
        (
            usn varchar(20) primary key,
            name varchar(30) not null
        );

        create table book_issue
        (
            issue_id int primary key auto_increment,
            usn varchar(20) not null,
            issue_date date,
            return_date date,
            book_isbn varchar(20),
            foreign key(usn) references student(usn),
            foreign key(book_isbn) references book(book_isbn)
        );

        create table admin
        (
            admin_id varchar(20) primary key,
            password varchar(20)
        );


* #6 run the follwing code and use the name and password as given in the code to log into the program
    insert into admin values('nitin','abcd0987');

* #7 Now go to dist folder in the main directory and click on LibraryMangement.jar file to run the Java Program.
