package org.example.DataAccesObject.ModelsDAO;

import org.example.DataAccesObject.JdbcTemplate.JdbcTemplate;
import org.example.DataAccesObject.ModelsRowMapper.CompetitionRowMapper;
import org.example.DataAccesObject.ModelsRowMapper.EquipeRowMapper;
import org.example.Models.Competition;

import java.sql.SQLException;
import java.util.List;

public class CompetitionDAO extends DataAccesObject<Competition> {
    public CompetitionDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Competition> getAll() throws SQLException {
        String sql = "select * from competition;";

        return jdbcTemplate.queryForList(sql, new CompetitionRowMapper());
    }

    @Override
    public Competition getOne(Object id) throws SQLException {
        String sql = "select * from competition where id_comp = ?;";

        return (Competition) jdbcTemplate.queryForObject(sql, new CompetitionRowMapper(), new Object[] { id });
    }

    @Override
    public int save(Competition competition) throws SQLException {
        return 0;
    }

    @Override
    public int update(Competition competition) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Competition competition) throws SQLException {
        return 0;
    }
}
