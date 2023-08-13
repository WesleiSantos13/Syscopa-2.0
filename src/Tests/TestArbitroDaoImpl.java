package Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import Dao.ArbitroDao;
import Dao.ArbitroDaoImpl;
import model.Arbitro;

/** Classe responsavel pelos testes do gerenciamento de arbitros
 * 
 * @author Weslei Silva Santos
 *
 */
class TestArbitroDaoImpl {

	@Test
	/** Testando se o metodo de adicionar o arbitro na lista, 
	 * aumenta o tamanho da lista
	 *
	*/
	 public void testCreate() {
		ArbitroDao arbitroDao = new ArbitroDaoImpl();
		// Testando antes de adicionar o objeto 
		int TamanhoEsperado = 0;
		int TamanhoObtido =arbitroDao.ListArb().size();
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Arbitro a1 = new Arbitro(5, "Wilton Pereira", 0);
		arbitroDao.Create(a1);
		// Testando depois de adicionar o objeto 
		int TamanhoEsperado2 = 1;
		int TamanhoObtido2 =arbitroDao.ListArb().size();
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
		
	}

	

	@Test
	/** Testando se o metodo de atualizar o arbitro na lista, 
	 * modifica os dados (Nome) na lista
	 *
	*/
	public void testUpdate() {
		ArbitroDao arbitroDao = new ArbitroDaoImpl();
		Arbitro a1 = new Arbitro(5, "Wilton Pereira", 0);
		//Cria um arbitro
		arbitroDao.Create(a1);
		// E edita o arbitro criado 
		Arbitro a2 = new Arbitro(5, "Marcos Maia", 0);
		int id = a2.getId();
		arbitroDao.UpdateArb(a2, id);
		String nomeObtido = arbitroDao.ListArb().get(0).getNome();
		String nomeEsperado= "Marcos Maia";
		assertEquals(nomeEsperado,nomeObtido);
		
	}

	@Test
	/** Testando o metodo de atualizar o arbitro na lista, 
	 * com um id de arbitro que nao esta na lista
	 *
	*/
	public void testUpdate2() {
		ArbitroDao arbitroDao = new ArbitroDaoImpl();
		Arbitro a1 = new Arbitro(5, "Wilton Pereira", 0);
		//Cria um arbitro
		arbitroDao.Create(a1);
		// E tenta editar o arbitro criado 
		Arbitro a2 = new Arbitro(5, "Marcos Maia", 0);
		int id = 1;
		arbitroDao.UpdateArb(a2, id);
		// ou seja, o nome do arbitro nao sera atualizado,
		// pois o id nao esta na lista
		String nomeObtido = arbitroDao.ListArb().get(0).getNome();
		String nomeEsperado= "Wilton Pereira";
		assertEquals(nomeEsperado,nomeObtido);
		
	}



	@Test
	/** Testando se o metodo de remover o arbitro na lista, 
	 * diminui o tamanho da lista
	 *
	*/
	public void testDelete() {
		ArbitroDao arbitroDao = new ArbitroDaoImpl();
		Arbitro a1 = new Arbitro(5, "Wilton Pereira", 0);
		Arbitro a2 = new Arbitro(7, "Arnaldo Silva", 0);
		//Cria dois arbitros
		arbitroDao.Create(a1);
		arbitroDao.Create(a2);
		//E depois remove um
		arbitroDao.DeleteArb(5);
		int TamanhoObtido = arbitroDao.ListArb().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}

	@Test
	/** Testando o metodo de remover o arbitro na lista, 
	 * com um id de arbitro que nao existe
	*/
	public void testDelete2() {
		ArbitroDao arbitroDao = new ArbitroDaoImpl();
		Arbitro a2 = new Arbitro(7, "Arnaldo Silva", 0);
		//Cria um arbitro
		arbitroDao.Create(a2);
		//E depois tenta remover
		arbitroDao.DeleteArb(1);
		// Mas o tamanho nao e alterado
		int TamanhoObtido = arbitroDao.ListArb().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}


	@Test
	/** Testando se o metodo de listar os arbitros na lista, 
	 * retorna uma lista com o tamanho correto, antes e depois de uma 
	 * criacao de arbitro 
	*/
	public void testList() {
		ArbitroDao arbitroDao = new ArbitroDaoImpl();
		int TamanhoObtido = arbitroDao.ListArb().size();
		int TamanhoEsperado = 0;
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Arbitro a2 = new Arbitro(7, "Arnaldo Silva", 0);
		arbitroDao.Create(a2);
		int TamanhoObtido2 = arbitroDao.ListArb().size();
		int TamanhoEsperado2 = 1;
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
	}

	@Test
	/** Testando se o metodo de pesquisar os arbitros na lista, 
	 * retorna uma lista com os ids corretos.
	*/
	public void testSearch() {
		ArbitroDao arbitroDao = new ArbitroDaoImpl();
		Arbitro a1 = new Arbitro(7, "ARMANDO SILVA", 0);
		Arbitro a2 = new Arbitro(8, "ARMANDO CESAR", 0);
		arbitroDao.Create(a1);
		arbitroDao.Create(a2);
		List<Integer> listaObtida = arbitroDao.SearchArb("ARMANDO");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		listaEsperada.add(7);
		listaEsperada.add(8);
		assertEquals(listaEsperada,listaObtida);
	}
	
	
	
	@Test
	/** Testando se o metodo de pesquisar os arbitros na lista, 
	 * retorna uma lista vazia.
	*/
	public void testSearch2() {
		ArbitroDao arbitroDao = new ArbitroDaoImpl();
		Arbitro a1 = new Arbitro(7, "ARMANDO SILVA", 0);
		Arbitro a2 = new Arbitro(8, "ARMANDO CESAR", 0);
		arbitroDao.Create(a1);
		arbitroDao.Create(a2);
		List<Integer> listaObtida = arbitroDao.SearchArb("MARIO");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		assertEquals(listaEsperada,listaObtida);
	}
	
	
	
}
