package sql.demo.repository;

import java.sql.SQLException;

public class TraidersRepository extends BaseTable implements TableOperations {

    public TraidersRepository() throws SQLException {
        super("traiders");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSglStatement("CREATE TABLE IF NOT EXISTS traiders(" +
                        "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        "name VARCHAR(255) NOT NULL," +
                        "fregTick INTEGER NOT NULL," +
                        "cash DECIMAL(15,2) NOT NULL DEFAULT 1000, " +
                        "traidingMethod INTEGER NOT NULL," +
                        "changeProbability INTEGER NOT NULL DEFAULT 50," +
                        "about VARCHAR(255) NULL," +
                        "CONSTRAINT check_traiders_traidingMethod CHECK(traidingMethod IN (1,2,3))," +
                        "CONSTRAINT check_traiders_changeProbability CHECK(changeProbability <=100 AND changeProbability > 0))",
                "Створена таблиця " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
