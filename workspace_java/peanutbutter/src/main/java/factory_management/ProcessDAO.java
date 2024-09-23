package factory_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProcessDAO {

    private String jdbcURL = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
    private String jdbcUsername = "scott2_9";
    private String jdbcPassword = "tiger";
    private Connection jdbcConnection;

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public void saveProcess(Process process) throws SQLException {
        String sql = "INSERT INTO process (process_code, process_name, process_category, is_used, cycle_time, product_code) VALUES (?, ?, ?, ?, ?, ?)";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, process.getProcessCode());
        statement.setString(2, process.getProcessName());
        statement.setString(3, process.getProcessCategory());
        statement.setString(4, process.getIsUsed());
        statement.setString(5, process.getCycleTime());
        statement.setString(6, process.getProductCode());

        statement.executeUpdate();

        statement.close();
        disconnect();
    }
}