# 📧 email-sender

Java библиотека для отправки HTML писем с чеком покупки.


---

## 🚀 Быстрый старт

### Подключение

```xml
<dependency>
    <groupId>ru.starashchuk</groupId>
    <artifactId>email-sender</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Настройка `application.properties`

```properties
mail.host=smtp.gmail.com
mail.port=587
mail.username=your@gmail.com
mail.password=xxxx xxxx xxxx xxxx
```

### Пример использования

```java
EmailConfig config = new EmailConfig(
    "smtp.gmail.com", 587,
    "your@gmail.com", "xxxx xxxx xxxx xxxx"
);

EmailService emailService = new EmailService(config);

ItemDTO item = new ItemDTO();
item.setProductName("Кофе");
item.setQuantity(2);
item.setPriceEach(new BigDecimal("350.00"));
item.setItemTotal(new BigDecimal("700.00"));

ReceiptEmailDTO receipt = new ReceiptEmailDTO();
receipt.setToEmail("buyer@gmail.com");
receipt.setReceiptId(42);
receipt.setSaleDate(LocalDateTime.now());
receipt.setItems(List.of(item));
receipt.setTotal(new BigDecimal("700.00"));

emailService.sendReceipt(receipt);
```

---

## 📦 Структура проекта

```
email-sender/
├── src/main/java/ru/starashchuk/email/
│   ├── EmailService.java        — отправка письма
│   ├── EmailConfig.java         — SMTP настройки
│   ├── ReceiptTemplate.java     — HTML шаблон чека
│   └── dto/
│       ├── ReceiptEmailDTO.java — данные чека
│       └── ItemDTO.java         — позиция в чеке
└── pom.xml
```

---

## ⚙️ Требования

- Java 17+
- Maven
- Gmail аккаунт с паролем приложения

---

## 🔑 Gmail пароль приложения

Обычный пароль Gmail не подходит. Нужен пароль приложения:

1. Перейди в [Google аккаунт](https://myaccount.google.com)
2. Безопасность → Двухэтапная аутентификация → включи
3. Безопасность → Пароли приложений
4. Создай пароль для "Почта" → скопируй 16-значный код

---

## 📚 Документация

Полная документация: [GitHub Pages](https://devstarash.github.io/email-sender)

---

## 👤 Автор

**Nikita Starashchuk** — [GitHub](https://github.com/devstarash)