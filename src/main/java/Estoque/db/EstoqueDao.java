package Estoque.db;

import Estoque.core.Estoque;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

public interface EstoqueDao {

    @SqlQuery("SELECT * FROM estoque")
    @Mapper(EstoqueMapper.class)
    public List<Estoque> getEstoqueList();

    @SqlUpdate("insert into estoque (codBarra, nomeProduto, descricao, quantidade, categoria) values " +
            "( :estoque.codBarra, :estoque.nomeProduto, :estoque.descricao, :estoque.quantidade, :estoque.categoria)")
    void addProduto(@BindBean("estoque") Estoque estoque);



    @SqlUpdate("update estoque set codBarra = :estoque.codBarra, nomeProduto = :estoque.nomeProduto," +
                " descricao = :estoque.descricao, quantidade = :estoque.quantidade, categoria = :estoque.categoria where id = :id")
    void updateProduto(@Bind("id") int id, @BindBean("estoque") Estoque estoque);


    @SqlQuery("SELECT * FROM estoque WHERE id = :id")
    @Mapper(EstoqueMapper.class)
    public List<Estoque> buscarProduto(@Bind ("id") int id);

    @SqlUpdate("DELETE FROM estoque WHERE id = :id")
    void deleteEstoque(@Bind("id") int id);


}
