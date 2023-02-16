package io.github.changebooks.code.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Jdbc关闭资源
 *
 * @author changebooks@qq.com
 */
public final class JdbcCloser {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcCloser.class);

    private JdbcCloser() {
    }

    /**
     * Close ResultSet
     *
     * @param rs the {@link ResultSet} instance
     * @return rs not null and closed ? true : false
     */
    public static boolean closeResultSet(ResultSet rs) {
        if (rs == null) {
            LOGGER.error("closeResultSet failed, rs has been null");
            return false;
        }

        try {
            rs.close();
            return true;
        } catch (SQLException ex) {
            LOGGER.error("closeResultSet failed, throwable: ", ex);
            return false;
        }
    }

    /**
     * Close PreparedStatement
     *
     * @param stat the {@link PreparedStatement} instance
     * @return stat not null and closed ? true : false
     */
    public static boolean closePreparedStatement(PreparedStatement stat) {
        if (stat == null) {
            LOGGER.error("closePreparedStatement failed, stat has been null");
            return false;
        }

        try {
            stat.close();
            return true;
        } catch (SQLException ex) {
            LOGGER.error("closePreparedStatement failed, throwable: ", ex);
            return false;
        }
    }

    /**
     * Close Connection
     *
     * @param conn the {@link Connection} instance
     * @return conn not null and closed ? true : false
     */
    public static boolean closeConnection(Connection conn) {
        if (conn == null) {
            LOGGER.error("closeConnection failed, conn has been null");
            return false;
        }

        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            LOGGER.error("closeConnection failed, throwable: ", ex);
            return false;
        }
    }

}
