# Database thư viện

## `Tạo table publisher`

- ### code tạo bảng

```sql
id int primary key AUTO_INCREMENT,
name text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154945955-7fc817f8-05e9-4de0-bb69-b4e70834da9f.png)

## `Tạo table authors`

- ### code tạo bảng

```sql
CREATE TABLE authors(
id int primary key AUTO_INCREMENT,
name text
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154946276-bd7b1d03-9384-4696-a9e6-24448cabce41.png)

## `Tạo table category`

- ### code tạo bảng

```sql
CREATE TABLE category(
id int primary key AUTO_INCREMENT,
category text
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154946502-90a95958-79c6-4ed1-910a-898bb9f2dc56.png)

## `Tạo table authors`

- ### code tạo bảng

```sql
CREATE TABLE authors(
id int primary key AUTO_INCREMENT,
name text
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154946276-bd7b1d03-9384-4696-a9e6-24448cabce41.png)

## `Tạo table employees`

- ### code tạo bảng

```sql
CREATE TABLE employees(
id int primary key AUTO_INCREMENT,
full_name text not null,
dob date not null,
address text not null,
phone_num text not null,
email text not null,
bank_account text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154946741-8c65d255-b3f3-4097-a213-ebb57da34377.png)

## `Tạo table readers`

- ### code tạo bảng

```sql
CREATE TABLE readers(
id int primary key AUTO_INCREMENT,
full_name text not null,
phone_num text not null,
email text not null,
address text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154946967-977f6a6b-060d-4d87-934f-686d3d7bbf66.png)

## `Tạo table orders`

- ### code tạo bảng

```sql
CREATE TABLE orders (
id int primary key AUTO_INCREMENT,
id_employee int,
id_reader int,
foreign key (id_employee) references employees (id),
foreign key (id_reader) references readers (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154947119-522391e7-38b1-4617-b462-602bbe17bb54.png)

## `Tạo table isReturned`

- ### code tạo bảng

```sql
CREATE TABLE isReturned(
id int primary key AUTO_INCREMENT,
id_order int,
foreign key (id_order) references orders (id),
status enum ('Chưa trả sách','Đã trả sách')
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154947295-b3d7f633-6d52-4223-ac7c-b4a59cfd8810.png)

## `Tạo table books`

- ### code tạo bảng

```sql
CREATE TABLE books(
id int primary key AUTO_INCREMENT,
name text not null,
public_year int,
id_publisher int,
foreign key (id_publisher) references publishers (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154947393-32481fb2-173c-404a-8485-78418420170a.png)

## `Tạo table book_category`

- ### code tạo bảng

```sql
CREATE TABLE book_category(
id int primary key AUTO_INCREMENT,
id_book int,
id_category int,
foreign key (id_book) references books (id),
foreign key (id_category) references category (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154947489-81037b9c-f7c5-4c7a-ae28-a99c1118906e.png)

## `Tạo table book_author`

- ### code tạo bảng

```sql
CREATE TABLE book_author(
id int primary key AUTO_INCREMENT,
id_book int,
id_author int,
foreign key (id_book) references books (id),
foreign key (id_author) references authors (id)
)

```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154947620-ad0fd46e-c947-404e-b835-76505f9f2293.png)

## `Tạo table order_book`

- ### code tạo bảng

```sql
CREATE TABLE order_book(
id int primary key AUTO_INCREMENT,
id_book int,
id_order int,
foreign key (id_book) references books (id),
foreign key (id_order) references orders (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154948089-e6545198-feab-40cc-a4fa-570d27273236.png)

## `Sơ đồ : `

![image](https://user-images.githubusercontent.com/95160129/154948335-dfe76681-9676-486d-bbce-c68285ce40b1.png)
