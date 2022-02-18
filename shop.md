# Database shop bán giày

## `Tạo table brand`

- ### code tạo bảng

```sql
CREATE Table brand(
id int primary key AUTO_INCREMENT,
name text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154644858-9ba773f2-eb1c-41ac-b3f7-d2eeac292a81.png)

## `Tạo table gender`

- ### code tạo bảng

```sql
CREATE Table gender(
id int primary key AUTO_INCREMENT,
gender text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154645081-fa8694eb-f3ef-486f-9c2b-994ab5081ca3.png)

## `Tạo table category`

- ### code tạo bảng

```sql
CREATE Table category(
id int primary key AUTO_INCREMENT,
id_gender int,
foreign key (id_gender) References gender (id),
name text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154646853-82d38fd0-4854-425e-b78b-eb01e6abca91.png)

## `Tạo table size`

- ### code tạo bảng

```sql
CREATE Table size(
id int primary key AUTO_INCREMENT,
size int not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154646947-c3da8f8d-b8ad-4543-b97d-cc827cc21610.png)

## `Tạo table color`

- ### code tạo bảng

```sql
CREATE Table color(
id int primary key AUTO_INCREMENT,
color text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154647045-681a0642-0341-4aee-84d6-b46437f29f02.png)

## `Tạo table products`

- ### code tạo bảng

```sql
CREATE Table products(
id int primary key AUTO_INCREMENT,
name text not null,
description text not null,
image blob,
id_category int,
id_brand int,
id_gender int,
foreign key (id_category) References category(id),
foreign key (id_brand) References brand(id),
foreign key (id_gender) References gender(id),
quantity int not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154647128-1933bb32-123d-4181-8e49-7527b673e6f3.png)

## `Tạo table price`

- ### code tạo bảng

```sql
CREATE Table price(
id int primary key AUTO_INCREMENT,
id_product int,
foreign key (id_product) References products (id),
price double not null,
date date not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154647206-0397451f-f4f9-4ea7-a8c8-6a17a69d17e0.png)

## `Tạo table product_color`

- ### code tạo bảng

```sql
CREATE Table product_color(
id_product int,
id_color int,
foreign key (id_product) References products (id),
foreign key (id_color) References color (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154647307-a5eaedfb-add3-45b9-98ce-111a6789c702.png)

## `Tạo table product_size`

- ### code tạo bảng

```sql
CREATE Table product_size(
id_product int,
id_size int,
foreign key (id_product) References products (id),
foreign key (id_size) References size (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/154647373-6d6099d5-ca68-4a69-9724-c59a388883a0.png)

## `Sơ đồ : `

![image](https://user-images.githubusercontent.com/95160129/154634056-90f6e9c3-d569-4c35-9d9f-b86b11abd166.png)
