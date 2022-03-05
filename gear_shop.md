# Database gear_shop

## `Tạo table roles`

- ### code tạo bảng

```sql
CREATE TABLE roles(
id int primary key auto_increment,
name text not null,
description text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156804559-e8cd4d63-70f4-4aa8-9508-98aa5a95ae43.png)

---

## `Tạo table employee`

- ### code tạo bảng

```sql
CREATE TABLE employee(
id int primary key auto_increment,
email text not null,
password text not null,
name text  not null,
phone_num text not null,
photo text,
role_id int,
foreign key (role_id) references roles (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156804781-3d4be235-08ed-4c17-b246-30986ca4e906.png)

---

## `Tạo table customer`

- ### code tạo bảng

```sql
CREATE TABLE customer(
id int primary key auto_increment,
email text not null,
password text not null,
name text not null,
phone_num text not null,
address text not null,
created_time date not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156805130-77d6b488-358c-442c-8394-c1fabd0f1e20.png)

---

## `Tạo table category`

- ### code tạo bảng

```sql
CREATE TABLE category(
id int primary key auto_increment,
name text not null,
id_parent int,
foreign key (id_parent) references category (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156805330-ca97c10a-c55b-46f9-ae97-0bc16bdca6bd.png)

---

## `Tạo table brand`

- ### code tạo bảng

```sql
CREATE TABLE brand(
id int primary key auto_increment,
name text not null,
logo text
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156805330-ca97c10a-c55b-46f9-ae97-0bc16bdca6bd.png)

---

## `Tạo table product`

- ### code tạo bảng

```sql
CREATE TABLE product(
id int primary key auto_increment,
name text not null,
main_image text not null,
description text not null,
enabled bit not null,
in_stock bit not null,
price int not null,
discount_percent float not null,
length float,
width float,
height float,
weight float,
category_id int,
foreign key (category_id) references category (id),
brand_id int,
foreign key (brand_id) references brand (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156805806-57e0abc9-a9ad-4ca4-8f40-1d1a0417ec7c.png)
  ![image](https://user-images.githubusercontent.com/95160129/156805948-0967ce07-d2ab-4c10-9473-50afcf09a0e1.png)
  ![image](https://user-images.githubusercontent.com/95160129/156806078-5a38fc92-cfd0-4517-bf3d-8eca0dc0f383.png)

---

## `Tạo table product_image`

- ### code tạo bảng

```sql
CREATE TABLE product_image(
id int primary key auto_increment,
id_product int,
foreign key (id_product) references product (id),
image text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156806306-0b05c48e-565d-4655-9526-fc25176f1ce4.png)

---

## `Tạo table product_spec`

- ### code tạo bảng

```sql
CREATE TABLE product_spec(
id int primary key auto_increment,
id_product int,
foreign key (id_product) references product (id),
spec text not null,
value text not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156806545-48ae412e-0c4d-4624-9ea1-f87f7ff501c8.png)

---

## `Tạo table cart_item`

- ### code tạo bảng

```sql
CREATE TABLE cart_item(
id int primary key auto_increment,
quantity int not null,
customer_id int,
foreign key (customer_id) references customer (id),
product_id int,
foreign key (product_id) references product (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156806694-f3604427-d79f-497e-b9e2-22c07b95315e.png)

---

## `Tạo table orders`

- ### code tạo bảng

```sql
CREATE TABLE orders(
id int primary key auto_increment,
name text not null,
city text not null,
phone_num text not null,
postal_code text not null,
deliver_time timestamp not null,
payment_method enum('Bank','momo','Thanh toán trực tiếp'),
subtotal int not null,
shipping_fee int not null,
status enum ('Chưa thanh toán','Đã thanh toán','Đã hòan trả hàng','Đã hủy'),
customer_id int,
foreign key (customer_id) references customer (id)
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156806868-7aac326c-229f-4c3e-99e2-16b8e987ea5b.png)

---

## `Tạo table order_item`

- ### code tạo bảng

```sql
CREATE TABLE order_item(
id int primary key auto_increment,
product_id int,
order_id int,
foreign key (product_id) references product (id),
foreign key (order_id) references orders (id),
quantity int not null,
unit_price int not null,
shipping_fee int not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156807102-f5758957-9ae9-4e3d-af9c-33987125e89d.png)

---

## `Tạo table order_track`

- ### code tạo bảng

```sql
CREATE TABLE order_track(
id int primary key auto_increment,
id_order int,
foreign key (id_order) references orders (id),
id_employee int,
foreign key (id_employee) references employee (id),
note text,
status enum ('Đang vận chuyển','Đang lưu kho','Đã giao hàng','Giao hàng thất bại','Hoàn trả hàng cho người bán'),
updated_time timestamp not null
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/156807329-0e7318b5-5f69-4f6b-b8f8-0a55bb45ca30.png)

---

## `Sơ đồ : `

![image](https://user-images.githubusercontent.com/95160129/156872240-1aa3b8ea-bd93-43a1-8815-0ca1ca3273ec.png)
