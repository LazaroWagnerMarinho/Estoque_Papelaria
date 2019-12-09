package Estoque.resources;


import Estoque.core.Estoque;
import Estoque.db.EstoqueDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("/estoque")
public class EstoqueResource {

    private EstoqueDao estoqueDao;

    public EstoqueResource(EstoqueDao estoqueDao){
        this.estoqueDao = estoqueDao;
    }

    @GET
    @Path("listarProdutos")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Estoque> getEstoques(){
        return estoqueDao.getEstoqueList();
    }

    @POST
    @Path("cadastrar")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void addProduto(Estoque newEstoque){

        estoqueDao.addProduto(newEstoque);
    }

    @Path("alterar/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void updateEsotque(@PathParam("id") int id, Estoque newestoque){
        estoqueDao.updateProduto(id, newestoque);
//        getEstoques();
    }

    @Path("buscar/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Estoque> getProduto(@PathParam("id") int id){
        return estoqueDao.buscarProduto(id);
    }

    @Path("deletar/{id}")
    @DELETE
    public void delete(@PathParam("id") int id){
        estoqueDao.deleteEstoque(id);
    }
}
