package Tests;

import static org.junit.Assert.assertEquals;   

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import Dao.SelecaoDao;
import Dao.SelecaoDaoImpl;
import model.Selecao;


/** Classe responsavel pelos testes do gerenciamento de selecoes
 * 
 * @author Weslei Silva Santos
 *
 */
class TestSelecaoDaoImpl {

	@Test
	/** Testando se o metodo de adicionar a selecao na lista, 
	 * aumenta o tamanho da lista
	 *
	*/
	public void testCreate() {
		SelecaoDao selecaoDao = new SelecaoDaoImpl();
		selecaoDao.ListSelecao().clear();
		// Testando antes de adicionar o objeto 
		int TamanhoEsperado = 0;
		int TamanhoObtido = selecaoDao.ListSelecao().size();
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Selecao s1= new Selecao(1, "Brasil", null,null, 0,0, TamanhoObtido);
		selecaoDao.CreateSelecao(s1);
		// Testando depois de adicionar o objeto 
		int TamanhoEsperado2 = 1;
		int TamanhoObtido2 = selecaoDao.ListSelecao().size();
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
		
	}

	@Test
	/** Testando se o metodo de atualizar a selecao na lista, 
	 * modifica os dados na lista
	 *
	*/
	public void testUpdate() {
		SelecaoDao selecaoDao = new SelecaoDaoImpl();
		selecaoDao.ListSelecao().clear();
		Selecao s1= new Selecao(1, "Brasil", new ArrayList<>(),new ArrayList<>(), 1,0, 0);
		//Cria uma selecao
		selecaoDao.CreateSelecao(s1);
		// E edita a selecao criada 
		Selecao s2= new Selecao(1, "Argentina", new ArrayList<>(),new ArrayList<>(), 2,0, 0);
		int id = 1;
		selecaoDao.UpdateSelecao(s2, id);
		//Compara nome da selecao
		String nomeObtido = selecaoDao.ListSelecao().get(0).getNome();
		String nomeEsperado= "Argentina";
		assertEquals(nomeObtido,nomeEsperado);
		//Compara id do grupo
		int idObtido = selecaoDao.ListSelecao().get(0).getIdGrupo();
		int idEsperado= 2;
		assertEquals(idObtido, idEsperado);
		
	
	}
	
	
	

	@Test
	/** Testando o metodo de atualizar a selecao na lista, 
	 * com um id de selecao que nao esta na lista
	 *
	*/
	public void testUpdate2() {
		SelecaoDao selecaoDao = new SelecaoDaoImpl();
		selecaoDao.ListSelecao().clear();
		Selecao s1= new Selecao(1, "Brasil", new ArrayList<>(),new ArrayList<>(), 1,0, 0);
		//Cria uma selecao
		selecaoDao.CreateSelecao(s1);
	
		// E tenta editar a selecao criada 
		Selecao s2= new Selecao(1, "Argentina", new ArrayList<>(),new ArrayList<>(), 2,0, 0);
		int id = 4;
		selecaoDao.UpdateSelecao(s2, id);
		// ou seja, os dados da selecao nao serao atualizados,
		// pois o id 4 nao esta na lista
		//Compara nome da selecao
		String nomeObtido = selecaoDao.ListSelecao().get(0).getNome();
		String nomeEsperado=  "Brasil";
		assertEquals(nomeObtido,nomeEsperado);
		//Compara id do grupo
		int idObtido = selecaoDao.ListSelecao().get(0).getIdGrupo();
		int idEsperado= 1;
		assertEquals(idObtido, idEsperado);
		}
	
	
	
	
	
	@Test
	/** Testando se o metodo de remover a selecao da lista, 
	 * reduz o tamanho da lista
	 *
	*/
	public void testDelete() {
		SelecaoDao selecaoDao = new SelecaoDaoImpl();
		selecaoDao.ListSelecao().clear();
		Selecao s1= new Selecao(1, "Brasil", new ArrayList<>(),new ArrayList<>(), 1,0, 0);
		Selecao s2= new Selecao(2, "Argentina", new ArrayList<>(),new ArrayList<>(), 2,0, 0);
		//Cria duas selecaos
		selecaoDao.CreateSelecao(s1);
		selecaoDao.CreateSelecao(s2);
		//E depois remove uma
		selecaoDao.DeleteSelecao(1);
		int TamanhoObtido = selecaoDao.ListSelecao().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}
	
	
	
	
	@Test
	/** Testando o metodo de remover a selecao da lista, 
	 * com um id de selecao que nao existe
	*/
	public void testDelete2() {
		SelecaoDao selecaoDao = new SelecaoDaoImpl();
		selecaoDao.ListSelecao().clear();
		Selecao s1= new Selecao(1, "Brasil", new ArrayList<>(),new ArrayList<>(), 1,0, 0);
		//Cria uma selecao
		selecaoDao.CreateSelecao(s1);
		//E depois tenta remover
		selecaoDao.DeleteSelecao(6);
		// Mas o tamanho nao e alterado
		int TamanhoObtido =  selecaoDao.ListSelecao().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}

	@Test
	/** Testando se o metodo de listar as selecoes na lista, 
	 * retorna uma lista com o tamanho correto, antes e depois de uma 
	 * criacao de selecao
	*/
	public void testList() {
		SelecaoDao selecaoDao = new SelecaoDaoImpl();
		int TamanhoObtido = selecaoDao.ListSelecao().size();
		int TamanhoEsperado = 0;
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Selecao s1= new Selecao(1, "Brasil", new ArrayList<>(),new ArrayList<>(), 1,0, TamanhoEsperado);
		selecaoDao.CreateSelecao(s1);
		int TamanhoObtido2 = selecaoDao.ListSelecao().size();
		int TamanhoEsperado2 = 1;
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
	}
	
	
	
	
	@Test
	/** Testando se o metodo de pesquisar as selecaos na lista, 
	 * retorna uma lista com os ids corretos.
	*/
	public void testSearch() {
		SelecaoDao selecaoDao = new SelecaoDaoImpl();
		selecaoDao.ListSelecao().clear();
		Selecao s1= new Selecao(1, "COREIA DO NORTE", new ArrayList<>(),new ArrayList<>(), 1,0, 0);
		Selecao s2= new Selecao(2, "COREIA DO SUL", new ArrayList<>(),new ArrayList<>(), 2,0, 0);
		selecaoDao.CreateSelecao(s1);
		selecaoDao.CreateSelecao(s2);
		List<Integer> listaObtida = selecaoDao.SearchSelec("COREIA");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		listaEsperada.add(1);
		listaEsperada.add(2);
		assertEquals(listaEsperada,listaObtida);
	}
	
	
	
	@Test
	/** Testando se o metodo de pesquisar as selecoes na lista, 
	 * retorna uma lista vazia.
	*/
	public void testSearch2() {
		SelecaoDao selecaoDao = new SelecaoDaoImpl();
		Selecao s1= new Selecao(1, "COREIA DO NORTE", new ArrayList<>(),new ArrayList<>(), 1,0, 0);
		Selecao s2= new Selecao(2, "COREIA DO SUL", new ArrayList<>(),new ArrayList<>(), 2,0, 0);
		selecaoDao.CreateSelecao(s1);
		selecaoDao.CreateSelecao(s2);
		List<Integer> listaObtida = selecaoDao.SearchSelec("JAPÃO");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		assertEquals(listaEsperada,listaObtida);
	}

}
