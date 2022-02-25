# Database blog

## `Tạo table users`

- ### code tạo bảng

```sql
CREATE TABLE users(
id int primary key auto_increment,
name text not null,
email text not null,
phone_num text,
address text,
avatar text,
written_blog int,
role enum ('Teacher','Student','Other')
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/155695485-4d3123f4-7d76-4d39-9814-53e713848974.png)

---

## `Tạo table categories`

- ### code tạo bảng

```sql
CREATE TABLE categories(
id int primary key auto_increment,
category text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/155695714-41519eb6-7008-4647-90a4-1baa03a79fa6.png)

---

## `Tạo table post`

- ### code tạo bảng

```sql
CREATE TABLE post(
id int primary key auto_increment,
id_category int,
id_user int,
foreign key (id_category) references categories (id),
foreign key (id_user) references users (id),
header text not null,
script text not null,
blog_date date
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/155695927-bca30a9c-7535-43f5-9486-9ab21d2e72cc.png)

---

## `Tạo table discuss`

- ### code tạo bảng

```sql
CREATE TABLE discuss(
id int primary key auto_increment,
user_id int,
post_id int,
foreign key (user_id) references users(id),
foreign key (post_id) references post (id),
comment text,
comment_date date
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/155696087-f23c3bd7-85b9-41b9-bc1b-d0a8f5acd9f9.png)

---

## `Tạo table tag`

- ### code tạo bảng

```sql
CREATE TABLE tag(
id int primary key auto_increment,
tag_name text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/155696214-73e011bc-3066-49ab-a7e4-50be2af92bc3.png)

---

## `Tạo table post_tag`

- ### code tạo bảng

```sql
CREATE TABLE post_tag(
id int primary key auto_increment,
id_post int,
id_tag int,
foreign key (id_post) references post (id),
foreign key (id_tag) references tag (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/155696300-8c0b26c3-a3c9-4fb1-936e-1fc947c18400.png)

---

## `Sơ đồ : `

![image](https://user-images.githubusercontent.com/95160129/155696520-d2287ae8-603b-499d-8ddd-d2133031808b.png)

## `code : `

```sql
SELECT p.id ,p.header,p.blog_date ,JSON_ARRAYAGG(JSON_OBJECT('avatar',u.avatar,'name',u.name,'blog_count',u.written_blog)) AS writter_info
, JSON_ARRAYAGG(JSON_OBJECT('id',d.id,'name',u2.name ,'comment_date',d.comment_date ,'comment',d.comment)) AS comment
from post p
INNER JOIN users u
ON p.id_user = u.id
INNER JOIN discuss d
ON p.id = d.post_id
INNER JOIN users u2
ON u2.id = d.user_id
GROUP BY p.id
```
