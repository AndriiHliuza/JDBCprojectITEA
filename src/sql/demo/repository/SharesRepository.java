package sql.demo.repository;

import java.sql.SQLException;

public class SharesRepository extends BaseTable implements TableOperations {

    public SharesRepository() throws SQLException {
        super("shares");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSglStatement("CREATE TABLE IF NOT EXISTS shares(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "changeProbability INTEGER NOT NULL," +
                "startPrice DECIMAL(15,2) NOT NULL," +
                "delta INTEGER NOT NULL)",
                "Створена таблиця " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
