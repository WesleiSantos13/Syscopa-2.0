package Tests;

import static org.junit.Assert.assertEquals; 

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import Dao.TecnicoDao;
import Dao.TecnicoDaoImpl;
import model.Tecnico;

/** Classe responsavel pelos testes do gerenciamento de tecnicos
 * 
 * @author Weslei Silva Santos
 *
 */
class TestTecnicoDaoImpl {

	@Test
	/** Testando se o metodo de adicionar o Tecnico na lista, 
	 * aumenta o tamanho da lista
	 *
	*/
	public void testCreate() {
		TecnicoDao tecnicoDao = new TecnicoDaoImpl();
		// Testando antes de adicionar o objeto 
		int TamanhoEsperado = 0;
		int TamanhoObtido = tecnicoDao.ListTec().size();
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Tecnico t1 = new Tecnico(1, "Tite", 0);
		 tecnicoDao.CreateTec(t1);
		// Testando depois de adicionar o objeto 
		int TamanhoEsperado2 = 1;
		int TamanhoObtido2 = tecnicoDao.ListTec().size();
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
		
	}

	@Test
	/** Testando se o metodo de atualizar o tecnico na lista, 
	 * modifica os dados na lista
	 *
	*/
	public void testUpdate() {
		TecnicoDao tecnicoDao = new TecnicoDaoImpl();
		Tecnico t1 = new Tecnico(1, "Tite", 0);
		//Cria um tecnico
		tecnicoDao.CreateTec(t1);

		// E edita o tecnico criado 
		Tecnico t2 = new Tecnico(1, "Xavi", 0);
		int id = 1;
		tecnicoDao.UpdateTec(t2, id);
		//Compara nomes
		String nomeObtido = tecnicoDao.ListTec().get(0).getNome();
		String nomeEsperado= "Xavi";
		assertEquals(nomeEsperado,nomeObtido);
		
	
	}
	
	
	

	@Test
	/** Testando o metodo de atualizar o tecnico na lista, 
	 * com um id de tecnico que nao esta na lista
	 *
	*/
	public void testUpdate2() {
		TecnicoDao tecnicoDao = new TecnicoDaoImpl();
		Tecnico t1 = new Tecnico(1, "Tite", 0);
		//Cria um tecnico
		tecnicoDao.CreateTec(t1);
				
	
		// E tenta editar o tecnico criado 
		Tecnico t2 = new Tecnico(1, "Xavi", 0);
		int id = 4;
		tecnicoDao.UpdateTec(t2, id);
		// ou seja, os dados do tecnico nao serao atualizados,
		// pois o id 4 nao esta na lista
		//Compara nomes
		String nomeObtido = tecnicoDao.ListTec().get(0).getNome();
		String nomeEsperado= "Tite";
		assertEquals(nomeEsperado,nomeObtido);
		}
	
	
	
	
	
	@Test
	/** Testando se o metodo de remover o tecnico da lista, 
	 * reduz o tamanho da lista
	 *
	*/
	public void testDelete() {
		TecnicoDao tecnicoDao = new TecnicoDaoImpl();
		Tecnico t1 = new Tecnico(1, "Tite", 0);
		Tecnico t2 = new Tecnico(2, "Xavi", 0);
		//Cria dois tecnicos
		tecnicoDao.CreateTec(t1);
		tecnicoDao.CreateTec(t2);
		//E depois remove um
		tecnicoDao.DeleteTec(2);
		int TamanhoObtido = tecnicoDao.ListTec().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}
	
	
	
	
	@Test
	/** Testando o metodo de remover o tecnico da lista, 
	 * com um id de tecnico que nao existe
	*/
	public void testDelete2() {
		TecnicoDao tecnicoDao = new TecnicoDaoImpl();
		Tecnico t1 = new Tecnico(1, "Tite", 0);
		//Cria um tecnico
		tecnicoDao.CreateTec(t1);
		//E depois tenta remover
		tecnicoDao.DeleteTec(3);
		// Mas o tamanho nao e alterado
		int TamanhoObtido = tecnicoDao.ListTec().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}

	@Test
	/** Testando se o metodo de listar os tecnicos da lista, 
	 * retorna uma lista com o tamanho correto, antes e depois de uma 
	 * criacao de tecnico
	*/
	public void testList() {
		TecnicoDao tecnicoDao = new TecnicoDaoImpl();
		int TamanhoObtido =tecnicoDao.ListTec().size();
		int TamanhoEsperado = 0;
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Tecnico t1 = new Tecnico(1, "Tite", 0);
		tecnicoDao.CreateTec(t1);
		int TamanhoObtido2 = tecnicoDao.ListTec().size();
		int TamanhoEsperado2 = 1;
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
	}

	
	
	@Test
	/** Testando se o metodo de pesquisar os tecnicos na lista, 
	 * retorna uma lista com os ids corretos.
	*/
	public void testSearch() {
		TecnicoDao tecnicoDao = new TecnicoDaoImpl();
		Tecnico t1 = new Tecnico(1, "GABRIEL SARAIVA", 0);
		Tecnico t2 = new Tecnico(2, "GABRIEL FERNANDES", 0);
		tecnicoDao.CreateTec(t1);
		tecnicoDao.CreateTec(t2);
		List<Integer> listaObtida = tecnicoDao.SearchTec("GABRIEL");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		listaEsperada.add(1);
		listaEsperada.add(2);
		assertEquals(listaEsperada,listaObtida);
	}
	
	
	
	@Test
	/** Testando se o metodo de pesquisar os tecnicos na lista, 
	 * retorna uma lista vazia.
	*/
	public void testSearch2() {
		TecnicoDao tecnicoDao = new TecnicoDaoImpl();
		Tecnico t1 = new Tecnico(1, "GABRIEL SARAIVA", 0);
		Tecnico t2 = new Tecnico(2, "GABRIEL FERNANDES", 0);
		tecnicoDao.CreateTec(t1);
		tecnicoDao.CreateTec(t2);
		List<Integer> listaObtida = tecnicoDao.SearchTec("VICTOR");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		assertEquals(listaEsperada,listaObtida);
	}

}
