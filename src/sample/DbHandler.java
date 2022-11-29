package sample;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DbHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void regUser(String dad, String email, String family, String name,
                        String password, String phone) {
        try {
            String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FATHER +
                    "," + Const.USER_EMAIL + "," + Const.USER_FAMILY + "," + Const.USER_NAME +
                    "," + Const.USER_PASSWORD + "," + Const.USER_PHONE + ")" + "VALUES(?,?,?,?,?,?)";
            dbConnection = getDbConnection();
            PreparedStatement prst = dbConnection.prepareStatement(insert);
            prst.setString(1, dad);
            prst.setString(2, email);
            prst.setString(3, family);
            prst.setString(4, name);
            prst.setString(5, password);
            prst.setString(6, phone);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet user(){
        ResultSet resultSet = null;
        String select = "SELECT * FROM продукция";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void buyCanon(String SNPH_canon) {
        try {
            dbConnection = getDbConnection();
            String read = "SELECT Колличество_на_складе FROM продукция WHERE Номер_товара = 1";
            PreparedStatement prst1 = dbConnection.prepareStatement(read);
            ResultSet resultSet = prst1.executeQuery();
            int sum = 0;
            if (resultSet.next()){
                sum = resultSet.getInt(1) - 1;
            }
            String update = "UPDATE продукция SET Колличество_на_складе = " + sum;
            PreparedStatement prst = dbConnection.prepareStatement(update);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void buyEpson(String SNPH_epson) {
        try {
            String insert = "INSERT INTO " + Const.ORDER_TABLE + "(" + Const.ORDER_NAME + ")" + "VALUES(?)";
            dbConnection = getDbConnection();
            PreparedStatement prst = dbConnection.prepareStatement(insert);
            prst.setString(1, SNPH_epson);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void buyCartridgeCanon(String cartridgeCanon) {
        try {
            String insert = "INSERT INTO " + Const.ORDER_TABLE + "(" + Const.ORDER_NAME + ")" + "VALUES(?)";
            dbConnection = getDbConnection();
            PreparedStatement prst = dbConnection.prepareStatement(insert);
            prst.setString(1, cartridgeCanon);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void buyCartridgeEpson(String cartridgeEpson) {
        try {
            String insert = "INSERT INTO " + Const.ORDER_TABLE + "(" + Const.ORDER_NAME + ")" + "VALUES(?)";
            dbConnection = getDbConnection();
            PreparedStatement prst = dbConnection.prepareStatement(insert);
            prst.setString(1, cartridgeEpson);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void buyInkCanon(String inkCanon) {
        try {
            String insert = "INSERT INTO " + Const.ORDER_TABLE + "(" + Const.ORDER_NAME + ")" + "VALUES(?)";
            dbConnection = getDbConnection();
            PreparedStatement prst = dbConnection.prepareStatement(insert);
            prst.setString(1, inkCanon);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
