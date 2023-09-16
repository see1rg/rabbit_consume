# rabbitConsume
Пример простой системы публикации сообщений в 3-х очередях с использованием fanout типа обмена и записью в 3-х разных БД PostgreSQL 
Для запуска файла docker-compose.yml и создания контейнеров создайте новый проект например в IntelliJ IDEA.

Добавьте существующие модули:

a. В верхнем меню выберите "File" (Файл) -> "New" (Новый) -> "Module from Existing Sources" (Модуль из существующих источников).

b. Выберите каталог с RabbitMQ Consumer и импортируйте его как первый модуль.

c. Повторите шаги a и b для RabbitMQ Producer, импортируя его как второй модуль.

Должна получиться приблизительно такая структура файлов:

my_project/
  ├── rabbitProduce/
  │   ├── src/
  │   │   ├── main/
  │   │   │   ├── java/
  │   │   │   │   ├── com/
  │   │   │   │   │   ├── see1rg/
  │   │   │   │   │   │   ├── producer/
  │   │   │   │   │   │   │   ├── ProducerMain.java
  │   │   ├── resources/
  │   │   ├── ...
  │   ├── Dockerfile  # Dockerfile для приложения Producer
  ├── rabbitConsume/
  │   ├── src/
  │   │   ├── main/
  │   │   │   ├── java/
  │   │   │   │   ├── com/
  │   │   │   │   │   ├── see1rg/
  │   │   │   │   │   │   ├── consumer/
  │   │   │   │   │   │   │   ├── ConsumerMain.java
  │   │   ├── resources/
  │   │   ├── ...
  │   ├── Dockerfile  # Dockerfile для приложения Consumer
  ├── docker-compose.yml

  Для запуска контейнеров Docker, описанных в файле docker-compose.yml, выполните следующие шаги:

Убедитесь, что Docker установлен и запущен на вашем компьютере.

Откройте командную строку или терминал и перейдите в директорию, где находится ваш файл docker-compose.yml. Используйте команду cd для перехода в соответствующую директорию.

Запустите контейнеры с помощью команды docker-compose up:

```bash
docker-compose up
```
