package ru.starashchuk.email.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Данные чека для отправки покупателю по email.
 *
 * <p>Передаётся в {@link EmailService#sendReceipt(ReceiptEmailDTO)}.</p>
 *
 * <p>Пример:</p>
 * <pre>{@code
 * ReceiptEmailDTO receipt = new ReceiptEmailDTO();
 * receipt.setToEmail("buyer@gmail.com");
 * receipt.setReceiptId(42);
 * receipt.setSaleDate(LocalDateTime.now());
 * receipt.setItems(items);
 * receipt.setTotal(new BigDecimal("700.00"));
 * }</pre>
 */
public class ReceiptEmailDTO {

    /**
     * Email адрес покупателя.
     */
    private String toEmail;

    /**
     * Уникальный номер чека.
     */
    private int receiptId;

    /**
     * Дата и время покупки.
     */
    private LocalDateTime saleDate;

    /**
     * Список товаров в чеке.
     */
    private List<ItemDTO> items;

    /**
     * Итоговая сумма покупки.
     */
    private BigDecimal total;

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}