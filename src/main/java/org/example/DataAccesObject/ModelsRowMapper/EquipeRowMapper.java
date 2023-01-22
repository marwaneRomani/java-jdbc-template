package org.example.DataAccesObject.ModelsRowMapper;

import org.example.Models.Equipe;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipeRowMapper implements RowMapper {
    @Override
    public Equipe mapRows(ResultSet resultSet) throws SQLException {
        Equipe equipe = new Equipe();
        equipe.setCode(resultSet.getInt("code_equipe"));
        equipe.setNom(resultSet.getString("nom"));
        equipe.setPays(resultSet.getString("pays"));

        return equipe;
    }
}
