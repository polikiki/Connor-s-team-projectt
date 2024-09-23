package factory_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProcessDAO3 {

    private String jdbcURL = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
    private String jdbcUsername = "scott2_17";
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

    public void saveProcess(Process2 process2) throws SQLException {
    
    	
      
        try { 
        	String sqle = "INSERT INTO process2 (underprocess, processname2, image, productcontent, process_code) VALUES (?, ?, ?, ?, ?)";
        	connect();
        	PreparedStatement statement = jdbcConnection.prepareStatement(sqle);
                statement.setString(1, process2.getUnderprocess());
                statement.setString(2, process2.getProcessname2());
                statement.setString(3, process2.getImage());
                statement.setString(4, process2.getProductcontent());
                statement.setString(5, process2.getProcessCode());
                statement.addBatch();
                statement.executeBatch();
        } finally {
            disconnect();
        }
    }
}