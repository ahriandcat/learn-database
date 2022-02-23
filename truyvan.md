# Truy Vấn

## Bài 1 :

- ### `Lấy ra các quyển sách được xuất trước năm 1900 :`

```sql
SELECT id,title,year_of_publication
from book
WHERE year_of_publication < 1900
```

- ### `Lấy ra các quyển sách có số lượng trang dưới 100 :`

```sql
SELECT id,title,page_number
from book
WHERE page_number < 100
```

- ### `Liệt kê các quyển sách có id_publisher = 1 và sắp xếp theo thứ tự tăng dần của số trang :`

```sql
SELECT id,title,id_publisher,page_number
from book
WHERE id_publisher = 1
ORDER BY page_number
```

## Bài 2 :

- ### `Tính trung bình cộng rental_rate của các bộ phim có rating là R : `

```sql
SELECT AVG(rental_rate) AS trung_binh
from film
WHERE rating = 'R'
```

- ### `Đếm các bộ phim có special_features là Deleted Scenes :`

```sql
SELECT COUNT(film_id) AS so_phim
from film 
WHERE special_features = 'Deleted Scenes'
```

- ### `Tìm các bộ phim theo tên có chứa ‘ACADEMY’ :`

```sql
SELECT film_id ,title 
FROM film
WHERE title LIKE '%ACADEMY%'
```
