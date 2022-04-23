package com.psc.j215.core;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.jdbc.JDBCAppender;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CustomJDBCAppender extends JDBCAppender{

    @Override
    protected Connection getConnection() throws SQLException {
        if(connection == null) {
            DriverManagerDataSource dataSource = (DriverManagerDataSource) BeanFactoryHandler.getBean("dataSource");
            connection = dataSource.getConnection();
//            DataSourceTransactionManager dstm = (DataSourceTransactionManager) BeanFactoryHandler.getBean("txManager");
//           connection = DataSourceUtils.getConnection(dstm.getDataSource());
            return connection;
        } else{
            return connection;
        }
    }

}
