package Estoque.db;

import Estoque.core.Estoque;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstoqueMapper implements ResultSetMapper<Estoque> {

    public Estoque map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Estoque(
                resultSet.getLong("id"),
                resultSet.getString("codBarra"),
                resultSet.getString("nomeProduto"),
                resultSet.getString("descricao"),
                resultSet.getInt("quantidade"),
                resultSet.getString("categoria")
        );
    }
}
