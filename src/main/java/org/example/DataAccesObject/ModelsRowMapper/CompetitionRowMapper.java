package org.example.DataAccesObject.ModelsRowMapper;

import org.example.Models.Competition;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompetitionRowMapper implements RowMapper {
    @Override
    public Competition mapRows(ResultSet resultSet) throws SQLException {
        Competition competition = new Competition();
        competition.setId(resultSet.getInt("id_comp"));
        competition.setNom(resultSet.getString("nom"));
        competition.setAnnee(resultSet.getString("annee"));
        competition.setPays(resultSet.getString("pays"));
        return competition;
    }
}