package Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


import Dao.JogadorDao;
import Dao.JogadorDaoImpl;
import model.Jogador;

/** Classe responsavel pelos testes do gerenciamento de jogadores
 * 
 * @author Weslei Silva Santos
 *
 */
class TestJogadorDaoImpl {
	@Test
	/** Testando se o metodo de adicionar o jogador na lista, 
	 * aumenta o tamanho da lista
	 *
	*/
	public void testCrete() {
		JogadorDao jogadorDao = new JogadorDaoImpl();
		// Testando antes de adicionar o objeto 
		int TamanhoEsperado = 0;
		int TamanhoObtido =jogadorDao.ListarJog().size();
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Jogador j1= new Jogador(1, "Neymar", "Meia", 0, 0, 0, 0);
		jogadorDao.Create(j1);
		
		// Testando depois de adicionar o objeto 
		int TamanhoEsperado2 = 1;
		int TamanhoObtido2 =jogadorDao.ListarJog().size();
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
		
	}

	@Test
	/** Testando se o metodo de atualizar o jogador na lista, 
	 * modifica os dados na lista
	 *
	*/
	public void testUpdate() {
		JogadorDao jogadorDao = new JogadorDaoImpl();
		Jogador j1= new Jogador(1, "Neymar", "Atacante", 0, 0, 0, 0);
		//Cria um jogador
		jogadorDao.Create(j1);

		// E edita o jogador criado 
		Jogador j2= new Jogador(1, "Casemiro", "Meia", 0, 0, 0, 0);
		int id = 1;
		jogadorDao.UpdateJog(j2, id);
		//Compara nomes
		String nomeObtido = jogadorDao.ListarJog().get(0).getNome();
		String nomeEsperado= "Casemiro";
		assertEquals(nomeEsperado,nomeObtido);
		//Compara posicoes
		String PosicaoObtida = jogadorDao.ListarJog().get(0).getPosicao();
		String PosicaoEsperada= "Meia";
		assertEquals(PosicaoEsperada,PosicaoObtida);
	
	}
	
	
	

	@Test
	/** Testando o metodo de atualizar o jogador na lista, 
	 * com um id de jogador que nao esta na lista
	 *
	*/
	public void testUpdate2() {
		JogadorDao jogadorDao = new JogadorDaoImpl();
		Jogador j1= new Jogador(1, "Neymar", "Atacante", 0, 0, 0, 0);
		//Cria um jogador
		jogadorDao.Create(j1);
				
	
		// E tenta editar o jogador criado 
		Jogador j2= new Jogador(1, "Casemiro", "Meia", 0, 0, 0, 0);
		int id = 3;
		jogadorDao.UpdateJog(j2, id);
		// ou seja, os dados do jogador nao serao atualizados,
		// pois o id 3 nao esta na lista
		//Compara nomes
		String nomeObtido = jogadorDao.ListarJog().get(0).getNome();
		String nomeEsperado= "Neymar";
		assertEquals(nomeEsperado,nomeObtido);
		//Compara posicoes
		String PosicaoObtida = jogadorDao.ListarJog().get(0).getPosicao();
		String PosicaoEsperada= "Atacante";
		assertEquals(PosicaoEsperada,PosicaoObtida);}
	
	
	
	
	
	@Test
	/** Testando se o metodo de remover o jogador da lista, 
	 * reduz o tamanho da lista
	 *
	*/
	public void testDelete() {
		JogadorDao jogadorDao = new JogadorDaoImpl();
		Jogador j1= new Jogador(1, "Neymar", "Atacante", 0, 0, 0, 0);
		Jogador j2= new Jogador(2, "Casemiro", "Meia", 0, 0, 0, 0);
		//Cria dois jogadores
		jogadorDao.Create(j1);
		jogadorDao.Create(j2);
		//E depois remove um
		jogadorDao.DeleteJog(2);
		int TamanhoObtido = jogadorDao.ListarJog().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}
	
	
	
	
	@Test
	/** Testando o metodo de remover o jogador da lista, 
	 * com um id de jogador que nao existe
	*/
	public void testDelete2() {
		JogadorDao jogadorDao = new JogadorDaoImpl();
		Jogador j1= new Jogador(1, "Neymar", "Atacante", 0, 0, 0, 0);
		//Cria um jogador
		jogadorDao.Create(j1);
		//E depois tenta remover
		jogadorDao.DeleteJog(7);
		// Mas o tamanho nao e alterado
		int TamanhoObtido = jogadorDao.ListarJog().size();
		int TamanhoEsperado = 1;
		assertEquals(TamanhoEsperado,TamanhoObtido);
	}

	@Test
	/** Testando se o metodo de listar os jogadores da lista, 
	 * retorna uma lista com o tamanho correto, antes e depois de uma 
	 * criacao de jogador
	*/
	public void testList() {
		JogadorDao jogadorDao = new JogadorDaoImpl();
		int TamanhoObtido =jogadorDao.ListarJog().size();
		int TamanhoEsperado = 0;
		assertEquals(TamanhoEsperado,TamanhoObtido);
		Jogador j1= new Jogador(1, "Neymar", "Atacante", 0, 0, 0, 0);
		jogadorDao.Create(j1);
		int TamanhoObtido2 = jogadorDao.ListarJog().size();
		int TamanhoEsperado2 = 1;
		assertEquals(TamanhoEsperado2,TamanhoObtido2);
	}

	
	
	
	@Test
	/** Testando se o metodo de pesquisar os jogadores na lista, 
	 * retorna uma lista com os ids corretos.
	*/
	public void testSearch() {
		JogadorDao jogadorDao = new JogadorDaoImpl();
		Jogador j1= new Jogador(1, "JOÃO GOMES", "Atacante", 0, 0, 0, 0);
		Jogador j2= new Jogador(2, "JOÃO HENRIQUE", "Atacante", 0, 0, 0, 0);
		jogadorDao.Create(j1);
		jogadorDao.Create(j2);
		List<Integer> listaObtida = jogadorDao.SearchJog("JOÃO");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		listaEsperada.add(1);
		listaEsperada.add(2);
		assertEquals(listaEsperada,listaObtida);
	}
	
	
	
	@Test
	/** Testando se o metodo de pesquisar os jogadores na lista, 
	 * retorna uma lista vazia.
	*/
	public void testSearch2() {
		JogadorDao jogadorDao = new JogadorDaoImpl();
		Jogador j1= new Jogador(1, "JOÃO GOMES", "Atacante", 0, 0, 0, 0);
		Jogador j2= new Jogador(2, "JOÃO HENRIQUE", "Atacante", 0, 0, 0, 0);
		jogadorDao.Create(j1);
		jogadorDao.Create(j2);
		List<Integer> listaObtida = jogadorDao.SearchJog("JONAS");
		List<Integer> listaEsperada = new ArrayList<Integer>();
		assertEquals(listaEsperada,listaObtida);
	}
	
}
