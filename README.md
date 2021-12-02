# BooksAndFeedback

Test task 01/12/2021

Системные требования:
PostgreSQL (db = postgres, user = postgres, password = 123)
openjdk version "1.8.0_292"
npm 8.1.4
Apache Maven 3.6.3

Для запуска приложения:
sudo bash start.sh

Ссылки:
http://localhost:3000/ - формы REST
http://localhost:5006/books - findAll из book
http://localhost:5006/feedbacks - findAll из feedback

Отслеживание изменений:
sudo -u postgres psql
SELECT * FROM book_aud;
SELECT * FROM feedback_aud;

Для добавления ссылок между сущностями:
- для того, чтобы в book добавить feedback'и: расскоментировать @OneToMany в Book
- для того, чтобы в в feedback добавить book: расскоментировать @ManyToOne в Feedback
- в mainController расскоментировать @PostMapping
