package Tests;

import static org.junit.Assert.assertEquals; 

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


import Dao.GrupoDao;
import Dao.GrupoDaoImpl;
import model.Grupo;

/** Classe responsavel pelos testes do gerenciamento de grupos
 * 
 * @author Weslei Silva Santos
 *
 */
class TestGrupoDaoImpl {
	@Test
	/** Testando se o metodo de adicionar o grupo na lista, 
	 * aumenta o tamanho da lista
	 *
	*/
	public void testCrete() {
		GrupoDao grupoDao = new GrupoDaoImpl();
		// Testando antes de adicionar o objeto 
		int TamanhoEsperado = 0;
		int TamanhoObtido =grupoDao.ListGrup().size();
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Grupo g1 = new Grupo(1, "A", null);
		grupoDao.CreateGrup(g1);
		
		// Testando depois de adicionar o objeto 
		int TamanhoEsperado2 = 1;
		int TamanhoObtido2 =grupoDao.ListGrup().size();
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
		
	}

	@Test
	/** Testando se o metodo de atualizar o grupo na lista, 
	 * modifica os dados na lista
	 *
	*/
	public void testUpdate() {
		GrupoDao grupoDao = new GrupoDaoImpl();
		Grupo g1 = new Grupo(1, "A", null);
		//Cria um grupo
		grupoDao.CreateGrup(g1);
				
		// Lista com os ids das selecoes do grupo
		ArrayList<Integer>selecoes = new ArrayList<>();
		selecoes.add(1); selecoes.add(2); selecoes.add(3);selecoes.add(4);	
	
		// E edita o grupo criado 
		Grupo g2 = new Grupo(1, "C", selecoes);
		int id = g2.getId();
		grupoDao.UpdateGrup(g2, id);
		//Compara nomes
		String nomeObtido = grupoDao.ListGrup().get(0).getLetraGrupo();
		String nomeEsperado= "C";
		assertEquals(nomeEsperado,nomeObtido);
		//Compara a lista contendo os ids das selecoes 
		assertEquals(selecoes,grupoDao.ListGrup().get(0).getSelecoes());
	}
	
	
	

	@Test
	/** Testando o metodo de atualizar o grupo na lista, 
	 * com um id de grupo que nao esta na lista
	 *
	*/
	public void testUpdate2() {
		GrupoDao grupoDao = new GrupoDaoImpl();
		Grupo g1 = new Grupo(1, "A", new ArrayList<>());
		//Cria um grupo
		grupoDao.CreateGrup(g1);
				
	
		// E tenta editar o grupo criado 
		Grupo g2 = new Grupo(1, "C", new ArrayList<>());
		int id = 9;
		grupoDao.UpdateGrup(g2, id);
		// ou seja, os dados do grupo nao serao atualizados,
		// pois o id 9 nao esta na lista
		//Compara nomes
		String nomeObtido = grupoDao.ListGrup().get(0).getLetraGrupo();
		String nomeEsperado= "A";
		assertEquals(nomeEsperado,nomeObtido);
		//Compara a lista contendo os ids das selecoes 
		assertEquals(new ArrayList<>(),grupoDao.ListGrup().get(0).getSelecoes());}
	
	
	
	
	
	@Test
	/** Testando se o metodo de remover o grupo da lista, 
	 * reduz o tamanho da lista
	 *
	*/
	public void testDelete() {
		GrupoDao grupoDao = new GrupoDaoImpl();
		Grupo g1 = new Grupo(1, "A", new ArrayList<>());
		Grupo g2 = new Grupo(2, "B", new ArrayList<>());
		//Cria dois grupos
		grupoDao.CreateGrup(g1);
		grupoDao.CreateGrup(g2);
		//E depois remove um
		grupoDao.DeleteGrup(1);
		int TamanhoObtido = grupoDao.ListGrup().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}
	
	
	
	
	@Test
	/** Testando o metodo de remover o grupo da lista, 
	 * com um id de grupo que nao existe
	*/
	public void testDelete2() {
		GrupoDao grupoDao = new GrupoDaoImpl();
		Grupo g1 = new Grupo(1, "A", new ArrayList<>());
		//Cria um grupo
		grupoDao.CreateGrup(g1);
		//E depois tenta remover
		grupoDao.DeleteGrup(2);
		// Mas o tamanho nao e alterado
		int TamanhoObtido = grupoDao.ListGrup().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}

	@Test
	/** Testando se o metodo de listar os grupos na lista, 
	 * retorna uma lista com o tamanho correto, antes e depois de uma 
	 * criacao de grupo
	*/
	public void testList() {
		GrupoDao grupoDao = new GrupoDaoImpl();
		int TamanhoObtido = grupoDao.ListGrup().size();
		int TamanhoEsperado = 0;
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Grupo g1 = new Grupo(1, "A", new ArrayList<>());
		grupoDao.CreateGrup(g1);
		int TamanhoObtido2 = grupoDao.ListGrup().size();
		int TamanhoEsperado2 = 1;
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
	}
	
	
}
