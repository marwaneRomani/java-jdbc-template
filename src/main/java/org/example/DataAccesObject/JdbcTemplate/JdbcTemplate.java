package org.example.DataAccesObject.JdbcTemplate;

import org.example.DataAccesObject.ModelsRowMapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate<T> {
    private Connection connection;

    public JdbcTemplate(Connection connection) {
        this.connection = connection;
    }

    public List<T> queryForList(String sql, RowMapper rowMapper) {
        ResultSet rs = beforeQuery(sql,null);
        List<T> result = afterQueryList(rs,rowMapper);

        return result;
    }
    public List<T> queryForList(String sql, RowMapper rowMapper, Object[] params) {
        ResultSet rs = beforeQuery(sql,params);
        List<T> result = afterQueryList(rs,rowMapper);

        return result;
    }

    public T queryForObject(String sql, RowMapper rowMapper, Object[] params) {
        ResultSet rs = beforeQuery(sql, params);
        T result = afterQueryObject(rs,rowMapper);

        return result;
    }

    public int nonQuery(String sql, Object[] params) {
        int result = executeNonQuery(sql,params);
        return result;
    }

    private ResultSet beforeQuery(String query, Object[] params) {
        try {
            if (params == null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                return resultSet;
            }
            else {
                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                fillPreparedStatement(ps,params);

                ResultSet resultSet = ps.executeQuery();
                return  resultSet;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<T> afterQueryList(ResultSet resultSet, RowMapper rowMapper) {
        List<T> resultList = new ArrayList<>();
            try {
                while (resultSet.next())
                    resultList.add(rowMapper.mapRows(resultSet));
                return resultList;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    private T afterQueryObject(ResultSet resultSet, RowMapper rowMapper) {
        T result = null;
        try {
            while (resultSet.next())
                result = rowMapper.mapRows(resultSet);
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int executeNonQuery(String query, Object[] params) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (params != null)
                fillPreparedStatement(ps,params);
            int result = ps.executeUpdate();

            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillPreparedStatement(PreparedStatement ps, Object[] arguments) throws SQLException {
        for (int i = 0; i < arguments.length; i++) {
            switch (String.valueOf(arguments[i].getClass())) {
                case "class java.lang.Integer" :
                    ps.setInt(i + 1, Integer.parseInt(arguments[i].toString()));
                    break;
                case "class java.lang.Date" :
                    ps.setDate(i + 1, Date.valueOf(arguments[i].toString()));
                    break;
                default :
                    ps.setString(i + 1, arguments[i].toString());
            }
        }
    }

}
