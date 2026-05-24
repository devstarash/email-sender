# API Reference

## EmailConfig

Настройки SMTP подключения.

### Конструктор

```java
EmailConfig(String host, int port, String username, String password)
```

| Параметр | Тип | Описание |
|---|---|---|
| `host` | String | Адрес SMTP сервера |
| `port` | int | Порт SMTP сервера |
| `username` | String | Email отправителя |
| `password` | String | Пароль приложения |

---

## EmailService

Основной класс для отправки писем.

### Конструктор

```java
EmailService(EmailConfig config)
```

### Методы

#### sendReceipt

```java
public void sendReceipt(ReceiptEmailDTO receipt) throws MessagingException
```

Отправляет HTML письмо с чеком покупателю.

| Параметр | Тип | Описание |
|---|---|---|
| `receipt` | ReceiptEmailDTO | Данные чека |

---

## ReceiptEmailDTO

| Поле | Тип | Описание |
|---|---|---|
| `toEmail` | String | Email покупателя |
| `receiptId` | int | Номер чека |
| `saleDate` | LocalDateTime | Дата покупки |
| `items` | List\<ItemDTO\> | Список товаров |
| `total` | BigDecimal | Итоговая сумма |

---

## ItemDTO

| Поле | Тип | Описание |
|---|---|---|
| `productName` | String | Название товара |
| `quantity` | int | Количество |
| `priceEach` | BigDecimal | Цена за единицу |
| `itemTotal` | BigDecimal | Сумма по позиции |