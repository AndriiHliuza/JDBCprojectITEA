package sql.demo;

import sql.demo.repository.ShareRatesRepository;
import sql.demo.repository.SharesRepository;
import sql.demo.repository.TraiderShareActionsRepository;
import sql.demo.repository.TraidersRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StockExchangeDB {

    public static final String DB_URL = "jdbc:h2:./db/stockExchange";
    public static final String DB_DRIVER = "org.h2.Driver";

    private TraidersRepository traidersRepository;
    private ShareRatesRepository shareRatesRepository;
    private SharesRepository sharesRepository;
    private TraiderShareActionsRepository traiderShareActionsRepository;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private StockExchangeDB() throws SQLException, ClassNotFoundException {
        Class.forName(DB_DRIVER);

        traidersRepository = new TraidersRepository();
        sharesRepository = new SharesRepository();
        shareRatesRepository = new ShareRatesRepository();
        traiderShareActionsRepository = new TraiderShareActionsRepository();
    }

    private void createTablesAndForeignKeys() throws SQLException {
        sharesRepository.createTable();
        shareRatesRepository.createTable();
        traidersRepository.createTable();
        traiderShareActionsRepository.createTable();

        shareRatesRepository.createForeignKeys();
        traiderShareActionsRepository.createForeignKeys();
    }

    public static void main(String[] args) {
        try {
            StockExchangeDB stockExchangeDB = new StockExchangeDB();
            stockExchangeDB.createTablesAndForeignKeys();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Помилка SQL!");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC драйвер для СУБД не знайдено!");
        }
    }
}