package org.example.DataAccesObject.ModelsRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
    <T> T mapRows(ResultSet resultSet) throws SQLException;
}
// 
//
//
//
//