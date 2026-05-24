package ru.starashchuk.email.dto;

import java.math.BigDecimal;

/**
 * Одна позиция в чеке покупки.
 *
 * <p>Используется внутри {@link ReceiptEmailDTO}.</p>
 *
 * <p>Пример:</p>
 * <pre>{@code
 * ItemDTO item = new ItemDTO();
 * item.setProductName("Кофе");
 * item.setQuantity(2);
 * item.setPriceEach(new BigDecimal("350.00"));
 * item.setItemTotal(new BigDecimal("700.00"));
 * }</pre>
 */
public class ItemDTO {

    /**
     * Название товара.
     */
    private String productName;

    /**
     * Количество единиц товара.
     */
    private int quantity;

    /**
     * Цена за единицу товара.
     */
    private BigDecimal priceEach;

    /**
     * Итоговая сумма по позиции: {@code priceEach * quantity}.
     */
    private BigDecimal itemTotal;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public BigDecimal getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(BigDecimal itemTotal) {
        this.itemTotal = itemTotal;
    }
}