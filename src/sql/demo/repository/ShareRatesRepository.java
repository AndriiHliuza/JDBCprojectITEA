package sql.demo.repository;

import java.sql.SQLException;

public class ShareRatesRepository extends BaseTable implements TableOperations {
    public ShareRatesRepository() throws SQLException {
        super("share_rates");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSglStatement("CREATE TABLE IF NOT EXISTS share_rates(" +
                        "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        "operDate DATETIME NOT NULL," +
                        "share BIGINT NOT NULL," +
                        "rate DECIMAL(15,2) NOT NULL)",
                "Створена таблиця " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSglStatement("ALTER TABLE share_rates ADD FOREIGN KEY(share) REFERENCES shares(id)",
                "Створено внутрішній ключ " + getTableName() + ".share -> shares.id");
    }
}
