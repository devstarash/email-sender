package ru.starashchuk.email;

import ru.starashchuk.email.dto.ItemDTO;
import ru.starashchuk.email.dto.ReceiptEmailDTO;

public class ReceiptTemplate {

    public static String build(ReceiptEmailDTO receipt) {
        StringBuilder sb = new StringBuilder();

        sb.append("""
                        <!DOCTYPE html>
                        <html lang="ru">
                        <head>
                          <meta charset="UTF-8">
                          <style>
                            body { margin: 0; padding: 0; background-color: #f4f4f4; font-family: 'Segoe UI', Arial, sans-serif; }
                            .wrapper { max-width: 600px; margin: 40px auto; background: #ffffff; border-radius: 12px; overflow: hidden; box-shadow: 0 4px 20px rgba(0,0,0,0.1); }
                            .header { background: linear-gradient(135deg, #1a1a2e, #16213e); padding: 40px 32px; text-align: center; }
                            .header h1 { margin: 0; color: #ffffff; font-size: 26px; letter-spacing: 2px; text-transform: uppercase; }
                            .header p { margin: 8px 0 0; color: #a0aec0; font-size: 14px; }
                            .badge { display: inline-block; margin-top: 16px; background: #e2b96f; color: #1a1a2e; padding: 6px 20px; border-radius: 20px; font-weight: 700; font-size: 13px; letter-spacing: 1px; }
                            .body { padding: 32px; }
                            .info-row { display: flex; justify-content: space-between; margin-bottom: 24px; }
                            .info-block { font-size: 13px; color: #718096; }
                            .info-block span { display: block; font-size: 15px; color: #2d3748; font-weight: 600; margin-top: 4px; }
                            table { width: 100%; border-collapse: collapse; margin-top: 8px; }
                            thead tr { background: #1a1a2e; }
                            thead th { color: #e2b96f; font-size: 12px; text-transform: uppercase; letter-spacing: 1px; padding: 12px 16px; text-align: left; }
                            tbody tr { border-bottom: 1px solid #edf2f7; }
                            tbody tr:last-child { border-bottom: none; }
                            tbody td { padding: 14px 16px; font-size: 14px; color: #4a5568; }
                            tbody tr:hover { background: #f7fafc; }
                            .total-row { background: #f7fafc; }
                            .total-row td { padding: 16px; font-size: 16px; font-weight: 700; color: #1a1a2e; }
                            .total-amount { color: #e2b96f; font-size: 20px; }
                            .footer { background: #f7fafc; padding: 24px 32px; text-align: center; border-top: 1px solid #edf2f7; }
                            .footer p { margin: 0; font-size: 13px; color: #a0aec0; }
                            .footer strong { color: #4a5568; }
                          </style>
                        </head>
                        <body>
                          <div class="wrapper">
                            <div class="header">
                              <h1>🛍 Спасибо за покупку!</h1>
                              <p>Ваш заказ успешно оформлен</p>
                              <div class="badge">ЧЕК ПОДТВЕРЖДЁН</div>
                            </div>
                            <div class="body">
                              <div class="info-row">
                                <div class="info-block">
                                  Номер чека
                                  <span>#""")
                .append(receipt.getReceiptId())
                .append("""
                          </span>
                        </div>
                        <div class="info-block" style="text-align:right;">
                          Дата покупки
                          <span>""")
                .append(receipt.getSaleDate().toLocalDate())
                .append("""
                                  </span>
                                </div>
                              </div>
                              <table>
                                <thead>
                                  <tr>
                                    <th>Товар</th>
                                    <th style="text-align:center;">Кол-во</th>
                                    <th style="text-align:right;">Цена</th>
                                    <th style="text-align:right;">Сумма</th>
                                  </tr>
                                </thead>
                                <tbody>
                        """);

        for (ItemDTO item : receipt.getItems()) {
            sb.append("          <tr>")
                    .append("<td>").append(item.getProductName()).append("</td>")
                    .append("<td style='text-align:center;'>").append(item.getQuantity()).append("</td>")
                    .append("<td style='text-align:right;'>").append(item.getPriceEach()).append(" ₽</td>")
                    .append("<td style='text-align:right; font-weight:600;'>").append(item.getItemTotal()).append(" ₽</td>")
                    .append("</tr>\n");
        }

        sb.append("""
                        <tr class="total-row">
                          <td colspan="3">Итого</td>
                          <td style="text-align:right;" class="total-amount">""")
                .append(receipt.getTotal())
                .append("""
                                 ₽</td>
                              </tr>
                            </tbody>
                          </table>
                        </div>
                        <div class="footer">
                          <p>Письмо отправлено на <strong>""")
                .append(receipt.getToEmail())
                .append("""
                              </strong></p>
                              <p style="margin-top:8px;">Если у вас есть вопросы — свяжитесь с нами</p>
                            </div>
                          </div>
                        </body>
                        </html>
                        """);

        return sb.toString();
    }
}