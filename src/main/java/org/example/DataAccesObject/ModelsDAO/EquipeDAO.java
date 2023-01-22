package org.example.DataAccesObject.ModelsDAO;

import org.example.DataAccesObject.ModelsRowMapper.EquipeRowMapper;
import org.example.DataAccesObject.JdbcTemplate.JdbcTemplate;
import org.example.Models.Equipe;

import java.sql.SQLException;
import java.util.List;

public class EquipeDAO extends DataAccesObject<Equipe> {

    public EquipeDAO(JdbcTemplate<Equipe> jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Equipe> getAll() throws SQLException {
        String sql = "select * from equipe ;";

        return jdbcTemplate.queryForList(sql, new EquipeRowMapper());
    }

    @Override
    public Equipe getOne(Object id) throws SQLException {
        String sql = "select * from equipe where code_equipe = ?;";

        return (Equipe) jdbcTemplate.queryForObject(sql,new EquipeRowMapper(), new Object[] { id });
    }

    @Override
    public int save(Equipe equipe) throws SQLException {
        String sql =  "INSERT INTO equipe(code_equipe, nom, pays) VALUES(?,?,?);";

        return jdbcTemplate.nonQuery(sql, new Object[] { equipe.getCode() ,equipe.getNom(), equipe.getPays() });
    }

    @Override
    public int update(Equipe equipe) throws SQLException {
        String sql =  "update equipe Set nom = ?, pays = ? where code_equipe = ?;";

        return jdbcTemplate.nonQuery(sql, new Object[] { equipe.getNom(), equipe.getPays(), equipe.getCode() });
    }

    @Override
    public int delete(Equipe equipe) throws SQLException {
        String sql = "delete from equipe where code_equipe = ?";

        return jdbcTemplate.nonQuery(sql, new Object[] { equipe.getCode() });
    }
}
