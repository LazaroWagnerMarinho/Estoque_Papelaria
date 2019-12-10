package Estoque.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EstoqueTest {
	
	private Estoque estoque;

	@Before
	public void setUp() throws Exception {
		estoque = new Estoque();
	}

	@Test
	public void testEstoqueLongStringStringStringIntString() {
		final long id = 001;
		final String codBarra = "cod.001";
		final String nomeProduto="Lapis";
		final String descricao = "Lapis de escrever";
		final int quantidade = 10;
		final String categoria = "Lapis escolar";
		
		final Estoque myEstoque = new Estoque(id,codBarra, nomeProduto, descricao, quantidade, categoria);
		
		assertEquals(001, myEstoque.getId());
		assertEquals("cod.001", myEstoque.getCodBarra());
		assertEquals("Lapis", myEstoque.getNomeProduto());
		assertEquals("Lapis de escrever", myEstoque.getDescricao());
		assertEquals(10, myEstoque.getQuantidade());
		assertEquals("Lapis escolar", myEstoque.getCategoria());
	}

}
