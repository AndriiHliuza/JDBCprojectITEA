package sql.demo.repository;

import sql.demo.model.TraiderShareActions;

import java.sql.SQLException;

public class TraiderShareActionsRepository extends BaseTable implements TableOperations {

    public TraiderShareActionsRepository() throws SQLException {
        super("traider_share_actions");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSglStatement("CREATE TABLE IF NOT EXISTS traider_share_actions(" +
                        "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                        "operation INT NOT NULL," +
                        "traider BIGINT NOT NULL," +
                        "shareRate BIGINT NOT NULL," +
                        "amount BIGINT NOT NULL)",
                "Створена таблиця " + getTableName());
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSglStatement("ALTER TABLE traider_share_actions ADD FOREIGN KEY(traider) REFERENCES traiders(id)",
                "Створено внутрішній ключ " + getTableName() + ".traider -> traiders.id");
        super.executeSglStatement("ALTER TABLE traider_share_actions ADD FOREIGN KEY(shareRate) REFERENCES share_rates(id)",
                        "Створено внутрішній ключ " + getTableName() + ".shareRate -> share_rate.id");
    }
}
