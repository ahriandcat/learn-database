# Database question

## `Tạo table question`

- ### code tạo bảng

```sql
CREATE TABLE question(
id int primary key AUTO_INCREMENT,
question text,
question_type enum ('single choice','multi choice')
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/155835081-dd6888f2-25cd-4a78-ba5c-7756297154f2.png)

---

## `Tạo table answer`

- ### code tạo bảng

```sql
CREATE TABLE answer(
id int primary key AUTO_INCREMENT,
id_question int,
foreign key (id_question) references question (id),
answer text,
answer_check enum ('true','false')
)
```

- ### Dữ liệu bảng
  ![image](https://user-images.githubusercontent.com/95160129/155835145-6848fde8-1c23-4d16-a7fd-13be2830e635.png)

---
