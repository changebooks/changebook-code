package io.github.changebooks.code.jdbc;

import io.github.changebooks.code.util.AssertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Jdbc执行操作
 *
 * @author changebooks@qq.com
 */
public final class JdbcExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcExecutor.class);

    /**
     * 设置参数
     */
    public interface ParameterCallback {
        /**
         * PreparedStatement.setString
         * PreparedStatement.setInt
         * PreparedStatement.setLong
         * ...
         *
         * @param stat the PreparedStatement
         * @throws SQLException if an error occurs set the statement
         */
        void doInPreparedStatement(PreparedStatement stat) throws SQLException;
    }

    /**
     * 读取结果
     */
    public interface ResultCallback<T> {
        /**
         * ResultSet.getString
         * ResultSet.getInt
         * ResultSet.getLong
         *
         * @param rs the ResultSet
         * @return Persistent Object
         * @throws SQLException if an error occurs reading the result
         */
        T doInResultSet(ResultSet rs) throws SQLException;
    }

    /**
     * Jdbc Connection Driver
     */
    private final JdbcDriver driver;

    public JdbcExecutor(JdbcDriver driver) {
        AssertUtils.nonNull(driver, "driver");

        this.driver = driver;
    }

    /**
     * 增删改
     * 自动 Open Connection 和 Close Connection
     *
     * @param command           an SQL statement contain '?'
     * @param parameterCallback stat.setString, stat.setInt, ...
     * @return affected rows
     */
    public int executeUpdate(String command, ParameterCallback parameterCallback) {
        Connection conn = driver.getConnection();

        try {
            return executeUpdate(conn, command, parameterCallback);
        } finally {
            JdbcCloser.closeConnection(conn);
        }
    }

    /**
     * 查询
     * 自动 Open Connection 和 Close Connection
     *
     * @param command           an SQL statement contain '?'
     * @param parameterCallback stat.setString, stat.setInt, ...
     * @param resultCallback    rs.next; rs.getString, rs.getInt, ...
     * @param <T>               the type of the desired result
     * @return result object or null
     */
    public <T> T executeQuery(String command, ParameterCallback parameterCallback, ResultCallback<T> resultCallback) {
        Connection conn = driver.getConnection();

        try {
            return executeQuery(conn, command, parameterCallback, resultCallback);
        } finally {
            JdbcCloser.closeConnection(conn);
        }
    }

    public JdbcDriver getDriver() {
        return driver;
    }

    /**
     * 增删改
     *
     * @param conn              the database connection
     * @param command           an SQL statement contain '?'
     * @param parameterCallback stat.setString, stat.setInt, ...
     * @return affected rows
     */
    public static int executeUpdate(Connection conn, String command, ParameterCallback parameterCallback) {
        PreparedStatement stat = prepareStatement(conn, command);
        if (stat == null) {
            LOGGER.error("executeUpdate failed, stat can't be null, command: {}", command);
            return 0;
        }

        try {
            if (parameterCallback != null) {
                parameterCallback.doInPreparedStatement(stat);
            }

            return stat.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("executeUpdate failed, command: {}, throwable: ", command, ex);
        } finally {
            JdbcCloser.closePreparedStatement(stat);
        }

        return 0;
    }

    /**
     * 查询
     *
     * @param conn              the database connection
     * @param command           an SQL statement contain '?'
     * @param parameterCallback stat.setString, stat.setInt, ...
     * @param resultCallback    rs.next; rs.getString, rs.getInt, ...
     * @param <T>               the type of the desired result
     * @return result object or null
     */
    public static <T> T executeQuery(Connection conn, String command, ParameterCallback parameterCallback, ResultCallback<T> resultCallback) {
        AssertUtils.nonNull(resultCallback, "resultCallback");

        PreparedStatement stat = prepareStatement(conn, command);
        if (stat == null) {
            LOGGER.error("executeQuery failed, stat can't be null, command: {}", command);
            return null;
        }

        ResultSet rs = null;
        try {
            if (parameterCallback != null) {
                parameterCallback.doInPreparedStatement(stat);
            }

            rs = stat.executeQuery();
            if (rs == null) {
                LOGGER.error("executeQuery failed, rs can't be null, command: {}", command);
                return null;
            }

            return resultCallback.doInResultSet(rs);
        } catch (SQLException ex) {
            LOGGER.error("executeQuery failed, command: {}, throwable: ", command, ex);
        } finally {
            JdbcCloser.closeResultSet(rs);
            JdbcCloser.closePreparedStatement(stat);
        }

        return null;
    }

    /**
     * Prepare Statement
     *
     * @param conn    the database connection
     * @param command an SQL statement contain '?'
     * @return PreparedStatement or null
     */
    public static PreparedStatement prepareStatement(Connection conn, String command) {
        AssertUtils.nonNull(conn, "conn");
        AssertUtils.nonEmpty(command, "command");

        try {
            return conn.prepareStatement(command);
        } catch (SQLException ex) {
            LOGGER.error("prepareStatement failed, command: {}, throwable: ", command, ex);
            return null;
        }
    }

}
