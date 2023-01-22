package org.example.DataAccesObject.ModelsDAO;

import org.example.DataAccesObject.JdbcTemplate.JdbcTemplate;
import java.sql.SQLException;
import java.util.List;

public abstract class DataAccesObject<T> {
    protected final JdbcTemplate jdbcTemplate;

    protected DataAccesObject(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract List<T> getAll() throws SQLException;
    public abstract T getOne(Object id) throws SQLException;
    public abstract int save(T t) throws SQLException;
    public abstract int update(T t) throws SQLException;
    public abstract int delete(T t) throws SQLException;
}
