package org.example.DataAccesObject.ModelsRowMapper;

import org.example.Models.Participation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParticipationRowMapper implements RowMapper {
    @Override
    public Participation mapRows(ResultSet resultSet) throws SQLException {
        Participation participation = new Participation();
        participation.setId(resultSet.getInt("id"));
        participation.setCode_equipe(resultSet.getInt("id_equipe"));
        participation.setId_compt(resultSet.getInt("id_compt"));
        participation.setClassement(resultSet.getInt("classement"));

        return participation;
    }
}
