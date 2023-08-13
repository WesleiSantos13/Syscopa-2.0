package Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import Dao.PartidaDao;
import Dao.PartidaDaoImpl;
import model.Partida;

/** Classe responsavel pelos testes do gerenciamento de partidas
 * 
 * @author Weslei Silva Santos
 *
 */
class TestPartidaDaoImpl {


	@Test
	/** Testando se o metodo de adicionar a partida na lista, 
	 * aumenta o tamanho da lista
	 *
	*/
	public void testCreate() {
		PartidaDao partidaDao = new PartidaDaoImpl();
		// Testando antes de adicionar o objeto 
		int TamanhoEsperado = 0;
		int TamanhoObtido = partidaDao.ListPart().size();
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, 0);
		partidaDao.CreatePart(p1);
		// Testando depois de adicionar o objeto 
		int TamanhoEsperado2 = 1;
		int TamanhoObtido2 = partidaDao.ListPart().size();
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
		
	}

	@Test
	/** Testando se o metodo de atualizar a partida na lista, 
	 * modifica os dados na lista
	 *
	*/
	public void testUpdate() {
		PartidaDao partidaDao = new PartidaDaoImpl();
		Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, 0);
		//Cria uma partida
		partidaDao.CreatePart(p1);

		// E edita a partida criada 
		Partida p2 = new Partida(1, null, null, null, "Argentina", "França", 0, 1, 2, 3, 1, "Sergio", 0, 0, 0, 0, 0);
		int id = 1;
		partidaDao.UpdatePart(p2, id);
		//Compara nomes das selecoes
		String selecao1obtida = partidaDao.ListPart().get(0).getNomeSelecao1();
		String selecao1Esperada= "Argentina";
		assertEquals(selecao1Esperada,selecao1obtida);
		String selecao2obtida = partidaDao.ListPart().get(0).getNomeSelecao2();
		String selecao2Esperada= "França";
		assertEquals(selecao2Esperada,selecao2obtida);
		//Compara nome do arbitro
		String ArbitroObtido = partidaDao.ListPart().get(0).getNomeArb();
		String ArbitroEsperado= "Sergio";
		assertEquals(ArbitroEsperado, ArbitroObtido);
		
	
	}
	
	
	

	@Test
	/** Testando o metodo de atualizar a partida na lista, 
	 * com um id de partida que nao esta na lista
	 *
	*/
	public void testUpdate2() {
		PartidaDao partidaDao = new PartidaDaoImpl();
		Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, 0);
		//Cria um partida
		partidaDao.CreatePart(p1);
	
		// E tenta editar a partida criada 
		Partida p2 = new Partida(1, null, null, null, "Argentina", "França", 0, 1, 2, 3, 1, "Sergio", 0, 0, 0, 0, 0);
		int id = 4;
		partidaDao.UpdatePart(p2, id);
		// ou seja, os dados da partida nao serao atualizados,
		// pois o id 4 nao esta na lista
		//Compara nomes das selecoes
		String selecao1obtida = partidaDao.ListPart().get(0).getNomeSelecao1();
		String selecao1Esperada= "Brasil";
		assertEquals(selecao1Esperada,selecao1obtida);
		String selecao2obtida = partidaDao.ListPart().get(0).getNomeSelecao2();
		String selecao2Esperada= "Portugal";
		assertEquals(selecao2Esperada,selecao2obtida);
		//Compara nome do arbitro
		String ArbitroObtido = partidaDao.ListPart().get(0).getNomeArb();
		String ArbitroEsperado= "Mário";
		assertEquals(ArbitroEsperado, ArbitroObtido);
		}
	
	
	
	
	
	@Test
	/** Testando se o metodo de remover a partida da lista, 
	 * reduz o tamanho da lista
	 *
	*/
	public void testDelete() {
		PartidaDao partidaDao = new PartidaDaoImpl();
		Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, 0);
		Partida p2 = new Partida(3, null, null, null, "Argentina", "França", 0, 3, 4, 2, 2, "Sergio", 0, 0, 0, 0, 0);
		//Cria duas partidas
		partidaDao.CreatePart(p1);
		partidaDao.CreatePart(p2);
		//E depois remove uma
		partidaDao.DeletePart(3);
		int TamanhoObtido = partidaDao.ListPart().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}
	
	
	
	
	@Test
	/** Testando o metodo de remover a partida da lista, 
	 * com um id de partida que nao existe
	*/
	public void testDelete2() {
		PartidaDao partidaDao = new PartidaDaoImpl();
		Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, 0);
		//Cria uma partida
		partidaDao.CreatePart(p1);
		//E depois tenta remover
		partidaDao.DeletePart(3);
		// Mas o tamanho nao e alterado
		int TamanhoObtido = partidaDao.ListPart().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}

	@Test
	/** Testando se o metodo de listar as partidas da lista, 
	 * retorna uma lista com o tamanho correto, antes e depois de uma 
	 * criacao de partida
	*/
	public void testList() {
		PartidaDao partidaDao = new PartidaDaoImpl();
		int TamanhoObtido = partidaDao.ListPart().size();
		int TamanhoEsperado = 0;
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, 0);
		partidaDao.CreatePart(p1);
		int TamanhoObtido2 = partidaDao.ListPart().size();
		int TamanhoEsperado2 = 1;
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
	}

	
	
	@Test
	/** Testando se o metodo de pesquisar os partidas na lista, 
	 * retorna uma lista com os ids corretos.
	*/
	public void testSearch() {
		PartidaDao partidaDao = new PartidaDaoImpl();
		Partida p1 = new Partida(1,"24/12/2022", null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, 0);
		Partida p2 = new Partida(3,"24/11/2022", null, null, "Argentina", "França", 0, 3, 4, 2, 2, "Sergio", 0, 0, 0, 0, 0);
		partidaDao.CreatePart(p1);
		partidaDao.CreatePart(p2);
		List<Integer> listaObtida = partidaDao.SearchPart("24");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		listaEsperada.add(1);
		listaEsperada.add(3);
		assertEquals(listaEsperada,listaObtida);
	}
	
	
	
	@Test
	/** Testando se o metodo de pesquisar os partidas na lista, 
	 * retorna uma lista vazia.
	*/
	public void testSearch2() {
		PartidaDao partidaDao = new PartidaDaoImpl();
		Partida p1 = new Partida(1,"24/12/2022", null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, 0);
		Partida p2 = new Partida(3,"24/11/2022", null, null, "Argentina", "França", 0, 3, 4, 2, 2, "Sergio", 0, 0, 0, 0, 0);
		partidaDao.CreatePart(p1);
		partidaDao.CreatePart(p2);
		List<Integer> listaObtida = partidaDao.SearchPart("25");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		assertEquals(listaEsperada,listaObtida);
	}
	
}
