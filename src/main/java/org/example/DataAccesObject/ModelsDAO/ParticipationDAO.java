package org.example.DataAccesObject.ModelsDAO;

import org.example.DataAccesObject.JdbcTemplate.JdbcTemplate;
import org.example.DataAccesObject.ModelsRowMapper.CompetitionRowMapper;
import org.example.DataAccesObject.ModelsRowMapper.ParticipationRowMapper;
import org.example.Models.Competition;
import org.example.Models.Equipe;
import org.example.Models.Participation;

import java.sql.SQLException;
import java.util.List;

public class ParticipationDAO extends DataAccesObject<Participation> {
    public ParticipationDAO(JdbcTemplate<Participation> jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Participation> getAll() throws SQLException {
        return null;
    }

    public List<Participation> getAllParticipationForEquipe(Object id) throws SQLException {
        String sql =  "select * from participation where id_equipe = ?;";

        return jdbcTemplate.queryForList(sql, new ParticipationRowMapper(), new Object[] { id } );
    }

    @Override
    public Participation getOne(Object id) throws SQLException {
        return null;
    }

    @Override
    public int save(Participation participation) throws SQLException {
        String sql =  "insert into participation(id_equipe,id_compt,classement) values(?,?,?);";

        return jdbcTemplate.nonQuery(sql, new Object[] { participation.getCode_equipe(), participation.getId_compt(), participation.getClassement() });
    }

    @Override
    public int update(Participation participation) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Participation participation) throws SQLException {
        return 0;
    }
}
