package ru.starashchuk.email;

/**
 * Настройки подключения к SMTP серверу.
 *
 * <p>Передаётся в {@link EmailService} при создании.
 * Настройки рекомендуется хранить в {@code application.properties}.</p>
 *
 * <p>Пример:</p>
 * <pre>{@code
 * EmailConfig config = new EmailConfig(
 *     "smtp.gmail.com",
 *     587,
 *     "your@gmail.com",
 *     "xxxx xxxx xxxx xxxx"
 * );
 * }</pre>
 */
public class EmailConfig {

    /**
     * Адрес SMTP сервера. Для Gmail: {@code smtp.gmail.com}
     */
    private String host;

    /**
     * Порт SMTP сервера. Для Gmail с TLS: {@code 587}
     */
    private int port;

    /**
     * Email адрес отправителя.
     */
    private String username;

    /**
     * Пароль приложения Gmail.
     */
    private String password;

    /**
     * Создаёт конфигурацию SMTP подключения.
     *
     * @param host     адрес SMTP сервера
     * @param port     порт SMTP сервера
     * @param username email отправителя
     * @param password пароль приложения
     */
    public EmailConfig(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
