package Tests;


import model.Jogador; 
import model.Partida;
import model.Selecao;
import model.Tecnico;
import model.Arbitro;
import model.Funcoes;
import model.Grupo;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/** Classe responsavel pelos testes das funcoes de verificacao e de buscar posicao
 * 
 * @author Weslei Silva Santos
 *
 */
class TestFunctions {

	@Test
	/** Testando a funcao de encontrar a posicao da selecao na lista, 
	 * com um retorno de index que esta na lista
	*/
	public void testIndexSelecao1() {
		List<Selecao> selecoes = new ArrayList<Selecao>();
		Selecao s1= new Selecao(1, "Brasil", new ArrayList<>(),new ArrayList<>(), 0,0, 0);
		selecoes.add(s1);
		int indexObtido =Funcoes.BuscaPosicao(selecoes, 1);
		int IndexEsperado =  0;
		assertEquals(IndexEsperado,indexObtido);
	}

	@Test
	/** Testando a funcao de encontrar a posicao da selecao na lista, 
	 * com um retorno de index que nao esta na lista
	 *
	 */
	public void testIndexSelecao2() {
		List<Selecao> selecoes = new ArrayList<Selecao>();
		Selecao s1= new Selecao(1, "Brasil", new ArrayList<>(),new ArrayList<>(), 0,0, 0);
		Selecao s2= new Selecao(2, "Argentina", new ArrayList<>(),new ArrayList<>(), 0,0, 0);
		selecoes.add(s1);
		selecoes.add(s2);
		int indexObtido =Funcoes.BuscaPosicao(selecoes, 3);
		int IndexEsperado =  -1;
		assertEquals(IndexEsperado,indexObtido);
	}
	
	@Test
	/** Testando a funcao de encontrar a posicao da selecao na lista, 
	 * com a lista vazia
	 *
	 */
	public void testSelecaoVazia() {
		List<Selecao> selecoes = new ArrayList<Selecao>();
		int indexObtido =Funcoes.BuscaPosicao(selecoes, 1);
		int IndexEsperado = -1;
		assertEquals(IndexEsperado,indexObtido);
	
}
	
	
	
	
	
	@Test
	/** Testando a funcao de encontrar a posicao do jogador na lista, 
	 * com um retorno de index que esta na lista
	*/
	public void testIndexJogador1() {
		List<Jogador> jogadores = new ArrayList<Jogador>();
		Jogador j1= new Jogador(1, "Neymar", "Meia", 0, 0, 0, 0);
		Jogador j2= new Jogador(2, "Messi",  "Meia", 0, 0, 0, 0);
		jogadores.add(j1);
		jogadores.add(j2);
		int indexObtido =Funcoes.BuscaPosicaoJog(jogadores, 2);
		int IndexEsperado =  1;
		assertEquals(IndexEsperado,indexObtido);
	}

	@Test
	/** Testando a funcao de encontrar a posicao do jogador na lista, 
	 * com um retorno de index que nao esta na lista
	 *
	 */
	public void testIndexJogador2() {
		List<Jogador> jogadores = new ArrayList<Jogador>();
		Jogador j1= new Jogador(1, "Neymar", "Meia", 0, 0, 0, 0);
		Jogador j2= new Jogador(2, "Messi",  "Meia", 0, 0, 0, 0);
		jogadores.add(j1);
		jogadores.add(j2);
		int indexObtido =Funcoes.BuscaPosicaoJog(jogadores, 3);
		int IndexEsperado =  -1;
		assertEquals(IndexEsperado,indexObtido);
	}
	
	@Test
	/** Testando a funcao de encontrar a posicao do jogador na lista, 
	 * com a lista vazia
	 *
	 */
	public void testJogadorVazio() {
		List<Jogador> jogadores = new ArrayList<Jogador>();
		int indexObtido =Funcoes.BuscaPosicaoJog(jogadores, 1);
		int IndexEsperado = -1;
		assertEquals(IndexEsperado,indexObtido);
	
}

	
	@Test
	/** Testando a funcao de encontrar a posicao do tecnico na lista, 
	 * com um retorno de index que esta na lista
	*/
	public void testIndexTecnico1() {
		List<Tecnico> tecnicos = new ArrayList<Tecnico>();
		Tecnico t1 = new Tecnico(1, "Tite", 0);
		Tecnico t2= new Tecnico(2, "Scaloni", 0);
		tecnicos.add(t1);
		tecnicos.add(t2);
		int indexObtido =Funcoes.BuscaPosicaoTec(tecnicos, 2);
		int IndexEsperado =  1;
		assertEquals(IndexEsperado,indexObtido);
	}

	@Test
	/** Testando a funcao de encontrar a posicao do tecnico na lista, 
	 * com um retorno de index que nao esta na lista
	 *
	 */
	public void testIndexTecnico2() {
		List<Tecnico> tecnicos = new ArrayList<Tecnico>();
		Tecnico t1 = new Tecnico(1, "Tite", 0);
		Tecnico t2= new Tecnico(2, "Scaloni", 0);
		tecnicos.add(t1);
		tecnicos.add(t2);
		int indexObtido =Funcoes.BuscaPosicaoTec(tecnicos, 3);
		int IndexEsperado =  -1;
		assertEquals(IndexEsperado,indexObtido);
	}
	
	@Test
	/** Testando a funcao de encontrar a posicao do tecnico na lista, 
	 * com a lista vazia
	 *
	 */
	public void testTecnicoVazio() {
		List<Tecnico> tecnicos = new ArrayList<Tecnico>();
		int indexObtido =Funcoes.BuscaPosicaoTec(tecnicos, 1);
		int IndexEsperado = -1;
		assertEquals(IndexEsperado,indexObtido);
	
}
	
	
	
	
	
	@Test
	/** Testando a funcao de encontrar a posicao do tecnico na lista, 
	 * com um retorno de index que esta na lista
	*/
	public void testIndexArbitro1() {
		List<Arbitro> arbitros = new ArrayList<Arbitro>();
		Arbitro a1 = new Arbitro(5, "Wilton Pereira", 0);
		Arbitro a2= new Arbitro(8, "Andersom Daronco", 0);
		arbitros.add(a1);
		arbitros.add(a2);
		int indexObtido =Funcoes.BuscaPosicaoArb(arbitros, 5);
		int IndexEsperado =  0;
		assertEquals(IndexEsperado,indexObtido);
	}

	@Test
	/** Testando a funcao de encontrar a posicao do arbitro na lista, 
	 * com um retorno de index que nao esta na lista
	 *
	 */
	public void testIndexArbitro2() {
		List<Arbitro> arbitros = new ArrayList<Arbitro>();
		Arbitro a1 = new Arbitro(5, "Wilton Pereira", 0);
		Arbitro a2= new Arbitro(8, "Andersom Daronco", 0);
		arbitros.add(a1);
		arbitros.add(a2);
		int indexObtido =Funcoes.BuscaPosicaoArb(arbitros, 9);
		int IndexEsperado =  -1;
		assertEquals(IndexEsperado,indexObtido);
	}
	
	@Test
	/** Testando a funcao de encontrar a posicao do arbitro na lista, 
	 * com a lista vazia
	 *
	 */
	public void testArbitroVazio() {
		List<Arbitro> arbitros = new ArrayList<Arbitro>();
		int indexObtido =Funcoes.BuscaPosicaoArb(arbitros, 1);
		int IndexEsperado = -1;
		assertEquals(IndexEsperado,indexObtido);}
		
		
		
		
		
		
		
		
		@Test
		/** Testando a funcao de encontrar a posicao da partida na lista, 
		 * com um retorno de index que esta na lista
		*/
		public void testIndexPartida1() {
			List<Partida> partidas = new ArrayList<Partida>();
			Partida p1 = new Partida(1, null, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0,0);
			Partida p2=  new Partida(3, null, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0,0);
			partidas.add(p1);
			partidas.add(p2);
			int indexObtido =Funcoes.BuscaPosicaoPart(partidas, 1);
			int IndexEsperado =  0;
			assertEquals(IndexEsperado,indexObtido);
		}

		@Test
		/** Testando a funcao de encontrar a posicao da partida na lista, 
		 * com um retorno de index que nao esta na lista
		 *
		 */
		public void testIndexPartida2() {
			List<Partida> partidas = new ArrayList<Partida>();
			Partida p1 = new Partida(1, null, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0,0);
			Partida p2=  new Partida(3, null, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0,0);
			partidas.add(p1);
			partidas.add(p2);
			int indexObtido =Funcoes.BuscaPosicaoPart(partidas, 4);
			int IndexEsperado =  -1;
			assertEquals(IndexEsperado,indexObtido);
		}
		
		@Test
		/** Testando a funcao de encontrar a posicao da partida na lista, 
		 * com a lista vazia
		 *
		 */
		public void testPartidaVazio() {
			List<Partida> partidas = new ArrayList<Partida>();
			int indexObtido =Funcoes.BuscaPosicaoPart(partidas, 4);
			int IndexEsperado = -1;
			assertEquals(IndexEsperado,indexObtido);
		
	
}
		
		
		
		
		@Test
		/** Testando a funcao de encontrar a posicao do grupo na lista, 
		 * com um retorno de index que esta na lista
		*/
		public void testIndexGrupo1() {
			List<Grupo>grupos = new ArrayList<Grupo>();
			Grupo g1 = new Grupo(1, "A", null);
			Grupo g2 = new Grupo(2, "B", null);
			grupos.add(g1);
			grupos.add(g2);
			int indexObtido =Funcoes.BuscaPosicaoGrp(grupos, 1);
			int IndexEsperado =  0;
			assertEquals(IndexEsperado,indexObtido);
		}

		@Test
		/** Testando a funcao de encontrar a posicao do grupo na lista, 
		 * com um retorno de index que nao esta na lista
		 *
		 */
		public void testIndexGrupo2() {
			List<Grupo>grupos = new ArrayList<Grupo>();
			Grupo g1 = new Grupo(1, "A", null);
			Grupo g2 = new Grupo(2, "B", null);
			grupos.add(g1);
			grupos.add(g2);
			int indexObtido =Funcoes.BuscaPosicaoGrp(grupos, 5);
			int IndexEsperado =  -1;
			assertEquals(IndexEsperado,indexObtido);
		}
		
		@Test
		/** Testando a funcao de encontrar a posicao do grupo na lista, 
		 * com a lista vazia
		 *
		 */
		public void testGrupoVazio() {
			List<Grupo>grupos = new ArrayList<Grupo>();
			int indexObtido =Funcoes.BuscaPosicaoGrp(grupos, 1);
			int IndexEsperado = -1;
			assertEquals(IndexEsperado,indexObtido);}
		
	

		
		
		
		
		
		
		
		
		
		
		

		@Test
		/** Testando a funcao de verificar se a selecao esta na lista, 
		 * com uma selecao que esta na lista
		 *
		 */
		public void testVerificarSelecao() {
			List<Selecao> selecoes = new ArrayList<Selecao>();
			Selecao s1= new Selecao(1, "Brasil", new ArrayList<>(),new ArrayList<>(), 0,0, 0);
			selecoes.add(s1);
			Boolean respostaObtida =Funcoes.verificarSelecao(1, selecoes);
			Boolean respostaEsperada = true;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se a selecao esta na lista, 
		 * com uma selecao que nao esta na lista
		 *
		 */
		public void testVerificarSelecao2() {
			List<Selecao> selecoes = new ArrayList<Selecao>();
			Selecao s1= new Selecao(1, "Brasil", new ArrayList<>(),new ArrayList<>(), 0,0, 0);
			selecoes.add(s1);
			Boolean respostaObtida =Funcoes.verificarSelecao(2, selecoes);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se a selecao esta na lista, 
		 * com a lista vazia
		 *
		 */
		public void testVerificarSelecaoVazia() {
			List<Selecao> selecoes = new ArrayList<Selecao>();
			Boolean respostaObtida =Funcoes.verificarSelecao(1, selecoes);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
	
	
		
		
		
		

		@Test
		/** Testando a funcao de verificar se o jogador esta na lista, 
		 * com um jogador que esta na lista
		 *
		 */
		public void testVerificarJogador() {
			List<Jogador> jogadores = new ArrayList<Jogador>();
			Jogador j1= new Jogador(1, "Neymar", "Meia", 0, 0, 0, 0);
			Jogador j2= new Jogador(2, "Messi",  "Meia", 0, 0, 0, 0);
			jogadores.add(j1);
			jogadores.add(j2);
			Boolean respostaObtida =Funcoes.verificarJogador(2, jogadores);
			Boolean respostaEsperada = true;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se o jogador esta na lista, 
		 * com um jogador que nao esta na lista
		 *
		 */
		public void testVerificarJogador2() {
			List<Jogador> jogadores = new ArrayList<Jogador>();
			Jogador j1= new Jogador(1, "Neymar", "Meia", 0, 0, 0, 0);
			Jogador j2= new Jogador(2, "Messi",  "Meia", 0, 0, 0, 0);
			jogadores.add(j1);
			jogadores.add(j2);
			Boolean respostaObtida =Funcoes.verificarJogador(3, jogadores);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se o jogador esta na lista, 
		 * com a lista vazia
		 *
		 */
		public void testVerificarJogadorVazio() {
			List<Jogador> jogadores = new ArrayList<Jogador>();
			Boolean respostaObtida =Funcoes.verificarJogador(1, jogadores);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
	
	
		
		
		
		
		
		
		
		
		@Test
		/** Testando a funcao de verificar se o tecnico esta na lista, 
		 * com uma selecao que esta na lista
		 *
		 */
		public void testVerificarTecnico() {
			List<Tecnico> tecnicos = new ArrayList<Tecnico>();
			Tecnico t1 = new Tecnico(1, "Tite", 0);
			Tecnico t2= new Tecnico(2, "Scaloni", 0);
			tecnicos.add(t1);
			tecnicos.add(t2);
			Boolean respostaObtida =Funcoes.verificarTecnico(2, tecnicos);
			Boolean respostaEsperada = true;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se o tecnico esta na lista, 
		 * com um tecnico que nao esta na lista
		 *
		 */
		public void testVerificarTecnico2() {
			List<Tecnico> tecnicos = new ArrayList<Tecnico>();
			Tecnico t1 = new Tecnico(1, "Tite", 0);
			Tecnico t2= new Tecnico(2, "Scaloni", 0);
			tecnicos.add(t1);
			tecnicos.add(t2);
			Boolean respostaObtida =Funcoes.verificarTecnico(3, tecnicos);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se o tecnico esta na lista, 
		 * com a lista vazia
		 *
		 */
		public void testVerificarTecnicoVazio() {
			List<Tecnico> tecnicos = new ArrayList<Tecnico>();
			Boolean respostaObtida =Funcoes.verificarTecnico(2, tecnicos);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
	
	
		
		
		
		
		
		
		@Test
		/** Testando a funcao de verificar se o tecnico esta na lista, 
		 * com uma selecao que esta na lista
		 *
		 */
		public void testVerificarArbitro() {
			List<Arbitro> arbitros = new ArrayList<Arbitro>();
			Arbitro a1 = new Arbitro(5, "Wilton Pereira", 0);
			Arbitro a2= new Arbitro(8, "Andersom Daronco", 0);
			arbitros.add(a1);
			arbitros.add(a2);
			Boolean respostaObtida =Funcoes.verificarArbitro(5, arbitros);
			Boolean respostaEsperada = true;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se o arbitro esta na lista, 
		 * com um arbitro que nao esta na lista
		 *
		 */
		public void testVerificarArbitro2() {
			List<Arbitro> arbitros = new ArrayList<Arbitro>();
			Arbitro a1 = new Arbitro(5, "Wilton Pereira", 0);
			Arbitro a2= new Arbitro(8, "Andersom Daronco", 0);
			arbitros.add(a1);
			arbitros.add(a2);
			Boolean respostaObtida =Funcoes.verificarArbitro(1, arbitros);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se o arbitro esta na lista, 
		 * com a lista vazia
		 *
		 */
		public void testVerificarArbitroVazio() {
			List<Arbitro> arbitros = new ArrayList<Arbitro>();
			Boolean respostaObtida =Funcoes.verificarArbitro(1, arbitros);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
	
		
		
		
		
	
		
		
		
		@Test
		/** Testando a funcao de verificar se o grupo esta na lista, 
		 * com um grupo que esta na lista
		 *
		 */
		public void testVerificarGrupo() {
			List<Grupo>grupos = new ArrayList<Grupo>();
			Grupo g1 = new Grupo(1, "A", null);
			Grupo g2 = new Grupo(2, "B", null);
			grupos.add(g1);
			grupos.add(g2);
			Boolean respostaObtida =Funcoes.verificarGrupo(2, grupos);
			Boolean respostaEsperada = true;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se o grupo esta na lista, 
		 * com um grupo que nao esta na lista
		 *
		 */
		public void testVerificarGrupo2() {
			List<Grupo>grupos = new ArrayList<Grupo>();
			Grupo g1 = new Grupo(1, "A", null);
			Grupo g2 = new Grupo(2, "B", null);
			grupos.add(g1);
			grupos.add(g2);
			Boolean respostaObtida =Funcoes.verificarGrupo(5, grupos);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se o grupo esta na lista, 
		 * com a lista vazia
		 *
		 */
		public void testVerificarGrupoVazio() {
			List<Grupo>grupos = new ArrayList<Grupo>();
			Boolean respostaObtida =Funcoes.verificarGrupo(1, grupos);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
	
		
		
		
		
		
		
		
		
		
		
		@Test
		/** Testando a funcao de verificar se a partida esta na lista, 
		 * com uma partida que esta na lista
		 *
		 */
		public void testVerificarPartida() {
			List<Partida> partidas = new ArrayList<Partida>();
			Partida p1 = new Partida(1, null, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0);
			Partida p2=  new Partida(3, null, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0);
			partidas.add(p1);
			partidas.add(p2);
			Boolean respostaObtida =Funcoes.verificarPartida(1, partidas);
			Boolean respostaEsperada = true;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se a partida esta na lista, 
		 * com uma partida que nao esta na lista
		 *
		 */
		public void testVerificarPartida2() {
			List<Partida> partidas = new ArrayList<Partida>();
			Partida p1 = new Partida(1, null, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0,0);
			Partida p2=  new Partida(3, null, null, null, null, null, 0, 0, 0, 0, 0, null, 0, 0, 0, 0,0);
			partidas.add(p1);
			partidas.add(p2);
			Boolean respostaObtida =Funcoes.verificarPartida(7, partidas);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		@Test
		/** Testando a funcao de verificar se a partida esta na lista, 
		 * com a lista vazia
		 *
		 */
		public void testVerificarPartidaVazio() {
			List<Partida> partidas = new ArrayList<Partida>();
			Boolean respostaObtida =Funcoes.verificarPartida(1, partidas);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
	
	
		
		
		
		
		
		
		
		
		@Test
		/** Testando a funcao de verificar se a selecao tem partidas registradas, 
		 * com um id de selecao que esta relacionado a partidas
		 *
		 */
		public void testVerificarPartidaSelecao() {
			List<Partida> partidas = new ArrayList<Partida>();
			Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, 0);
			partidas.add(p1);
			Boolean respostaObtida =Funcoes.verificarSelecaoPartida(1, partidas);
			Boolean respostaEsperada = true;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		
		@Test
		/** Testando a funcao de verificar se a selecao tem partidas registradas, 
		 * com um id de selecao que nao esta relacionado a partidas
		 *
		 */
		public void testVerificarPartidaSelecao2() {
			List<Partida> partidas = new ArrayList<Partida>();
			Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 1, 2, 0, 3, 1, "Mário", 0, 0, 0, 0,0);
			partidas.add(p1);
			Boolean respostaObtida =Funcoes.verificarSelecaoPartida(3, partidas);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		
		@Test
		/** Testando a funcao de verificar se a selecao tem partidas registradas, 
		 * com a lista de partidas vazia
		 *
		 */
		public void testVerificarPartidaSelecaoVazia() {
			List<Partida> partidas = new ArrayList<Partida>();
			Boolean respostaObtida =Funcoes.verificarSelecaoPartida(3, partidas);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		
			
		
		@Test
		/** Testando a funcao de verificar se o jogador esta na selecao, 
		 * com um id de jogador que esta na selecao
		 *
		 */
		public void testVerificarJogadorSelecao() {
			List<Selecao> selecoes = new ArrayList<Selecao>();
			 ArrayList<Integer> jogadores = new ArrayList<>();
			Jogador j1= new Jogador(1, "NeymarJr", "Atacante", 0, 0, 0, 0);
			Jogador j2= new Jogador(2, "Raphinha", "Atacante", 0, 0, 0, 0);
			Jogador j3= new Jogador(3, "ViniJr",  "Meia", 0, 0, 0, 0);
			jogadores.add(j1.getCodJog());
			jogadores.add(j2.getCodJog());
			jogadores.add(j3.getCodJog());
			
			Selecao s1= new Selecao(1, "Brasil", jogadores,new ArrayList<>(), 0,0, 0);
			selecoes.add(s1);
			Boolean respostaObtida =Funcoes.verificaJogadorSelecao(1, s1);
			Boolean respostaEsperada = true;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		
		
		
		@Test
		/** Testando a funcao de verificar se o jogador esta na selecao, 
		 * com um id de jogador que nao esta na selecao
		 *
		 */
		public void testVerificarJogadorSelecao2() {
			List<Selecao> selecoes = new ArrayList<Selecao>();
			 ArrayList<Integer> jogadores = new ArrayList<>();
			Jogador j1= new Jogador(1, "NeymarJr", "Atacante", 0, 0, 0, 0);
			Jogador j2= new Jogador(2, "Raphinha", "Atacante", 0, 0, 0, 0);
			Jogador j3= new Jogador(3, "ViniJr",  "Meia", 0, 0, 0, 0);
			jogadores.add(j1.getCodJog());
			jogadores.add(j2.getCodJog());
			jogadores.add(j3.getCodJog());
			
			Selecao s1= new Selecao(1, "Brasil", jogadores,new ArrayList<>(), 0,0, 0);
			selecoes.add(s1);
			Boolean respostaObtida =Funcoes.verificaJogadorSelecao(5, s1);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		
		
		
		@Test
		/** Testando a funcao de verificar se o jogador esta na selecao, 
		 * com a lista de ids de jogadores vazia
		 *
		 */
		public void testVerificarJogadorSelecaoVazio() {
			List<Selecao> selecoes = new ArrayList<Selecao>();
			ArrayList<Integer> jogadores = new ArrayList<>();
			Selecao s1= new Selecao(1, "Brasil", jogadores,new ArrayList<>(), 0,0, 0);
			selecoes.add(s1);
			Boolean respostaObtida =Funcoes.verificaJogadorSelecao(1, s1);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		
		
		@Test
		/** Testando a funcao de verificar se o grupo tem partidas registradas, 
		 * com um id de grupo que esta relacionado a partidas
		 *
		 */
		public void testVerificarGrupoPartida() {
			List<Partida> partidas = new ArrayList<Partida>();
			Grupo grupo = new Grupo(8, "A", null);
			Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, grupo.getId());
			partidas.add(p1);
			Boolean respostaObtida =Funcoes.verificarGrupoPartida(8, partidas);
			Boolean respostaEsperada = true;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		
		@Test
		/** Testando a funcao de verificar se o grupo tem partidas registradas, 
		 * com um id de grupo que nao esta relacionado a partidas
		 *
		 */
		public void testVerificarGrupoPartida2() {
			List<Partida> partidas = new ArrayList<Partida>();
			Grupo grupo = new Grupo(8, "A", null);
			Partida p1 = new Partida(1, null, null, null, "Brasil", "Portugal", 0, 1, 2, 3, 1, "Mário", 0, 0, 0, 0, grupo.getId());
			partidas.add(p1);
			Boolean respostaObtida =Funcoes.verificarGrupoPartida(5, partidas);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		
		
		
		@Test
		/** Testando a funcao de verificar se o grupo tem partidas registradas, 
		 * com a lista de partidas vazia
		 *
		 */
		public void testVerificarGrupoPartidaVazio() {
			List<Partida> partidas = new ArrayList<Partida>();
			Boolean respostaObtida =Funcoes.verificarGrupoPartida(5, partidas);
			Boolean respostaEsperada = false;
			assertEquals(respostaEsperada,respostaObtida);}
		
		
		

	
		
		
		
		
}