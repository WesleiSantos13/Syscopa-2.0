package view;
      
import java.util.List;     
import java.util.Scanner;
import java.util.Random;


import model.Arbitro;
import model.ClassificadosGrupo;
import model.Grupo;
import model.Jogador;
import model.Selecao;
import model.Tecnico;
import model.Partida;
import model.Funcoes;



/** Classe responsavel pelas funcoes de entrada e exibicao de dados;
 *  Algumas das funcoes sao operadoras de dados
 * 
 * @author Weslei Silva Santos
 *
 */
public class Exibicao {

	
	

	/** Metodo para exibir o menu de opcoes
	 * 
	 * @param Teclado Scanner para usar o teclado
	 * @return A opcao de menu
	 */
	public static int Menu(Scanner Teclado) {
		System.out.println("   ");
		System.out.println("-----------SysCopa-------------");
		System.out.println("|[1]  Acesso as Seleções      			  |");
		System.out.println("|[2]  Acesso aos Jogadores    			  |");
		System.out.println("|[3]  Acesso aos Técnicos     			  |");
		System.out.println("|[4]  Acesso aos Arbitros     			  |");
		System.out.println("|[5]  Acesso a Fase de Grupos   		  |");
		System.out.println("|[6]  Acesso as Partidas      			  |");
		System.out.println("|[7]  Pesquisar              			  |");
		System.out.println("|[8]  Listar Times completos              |");
		System.out.println("|[9]  Fazer a classificação das seleções  |");
		System.out.println("|[9]  Listar a classificação das seleções  |");
		System.out.println("|[11] Contruir copa Total                |");
		System.out.println("|[0]  Sair                    			  |");
		System.out.println("-------------------------------");
		int resposta = Teclado.nextInt();		
		return resposta;}
		
	
	 
	/** Metodo de cadastro do jogador
	 * 
	 * @param contJogador Id do jogador
	 * @param idSelecao Id da selecao
	 * @return O jogador
	 */
	@SuppressWarnings("resource")
	public static Jogador CadastroJogador(int contJogador, int idSelecao) 	{
		Scanner teclado = new Scanner(System.in);
		String nomeJogador =PerguntaStrings("o nome do jogador:  " );
		System.out.println("*******************************");
		System.out.println("| Digite a posição do jogador |");
		System.out.println("|[1]Goleiro");
		System.out.println("|[2]Zagueiro");
		System.out.println("|[3]Meio-Campo");
		System.out.println("|[4]Atacante");
		System.out.println("  ");
		System.out.println("*******************************");
		int opcao = teclado.nextInt();	
		String posicao = " ";  
		if(opcao==1) {posicao = "Goleiro";}
		if(opcao==2) {posicao = "Zagueiro";} 
		if(opcao==3) {posicao = "Meio-Campo";} 
		if(opcao==4) {posicao = "Atacante";} 
		Jogador jogador= new Jogador(contJogador, nomeJogador, posicao, 0, 0, 0, idSelecao);
		return jogador;
	}
	
	
	
	/** Metodo reponsavel por editar os cartoes e gols do jogador manualmente  
	 * 
	 * @param jogador Jogador a ser atualizado 
	 * @param ler Scanner de teclado
	 * @return o jogador
	 */
	public static Jogador AtualizarDadosJogador(Jogador jogador, Scanner ler) {
		System.out.println("Digite o saldo de gols do jogador");
		jogador.setGols(ler.nextInt());
		System.out.println("Digite a quantidade de cartões amarelos do jogador");
		jogador.setCartA(ler.nextInt());
		System.out.println("Digite a quantidade de cartões vermelhos do jogador");
		jogador.setCartVe(ler.nextInt());
		return jogador;
	}
	
	
	
	
	/** Metodo que lista todos os dados da selecao (incluido os Jogadores e Tecnico). 
	 * 
	 * @param selecoes Lista de selecoes
	 * @param tecnicos Lista de tecnicos
	 * @param jogadores Lista de jogadores
	 */
	public static void ListarTudoSelecao(List<Selecao>selecoes, List<Tecnico>tecnicos, List<Jogador>jogadores) {
		System.out.println("***********************");
		for (int j=0;j<selecoes.size();j++) {
			//Os dados da Selecao 
			Selecao selecao = selecoes.get(j);
			ExibirSelecao(selecao);
						
			//Nome do tecnico
			for(int i=0;i<tecnicos.size();i++) {
				Tecnico tecnico =tecnicos.get(i);
				if(tecnico.getIdSelecao()==selecao.getId()) {
					Exibirtecnico(tecnico);}}
			//Seus jogadores e seus dados
			for(int k=0;k<jogadores.size();k++) {
				Jogador jogador = jogadores.get(k);
				if(jogador.getIdSelecao()==selecao.getId()) {
					ExibirJogador(jogador);}}
				System.out.println("--------------------------");
		}}
		
	
	
	/** Metodo para listar jogador
	 * 
	 * @param jogadores Lista de jogadores
	 */
	public static void listarJogadores(List<Jogador>jogadores) {
		for(int k=0;k<jogadores.size();k++) {
			Jogador jog = jogadores.get(k);
			ExibirJogador(jog);}
		 }
	
	
	/** Metodo para listar arbitros
	 * 
	 * @param  Lista de arbitros
	 */
	public static void listarArbitros(List<Arbitro>arbitros) {
		for(int k=0;k<arbitros.size();k++) {
			Arbitro arb = arbitros.get(k);
			ExibirArbitro(arb);}
		 }
	
	
	/** Metodo para listar partidas
	 * 
	 * @param partidas Lista de partidas
	 */
	public static void listarPartidas(List<Partida>partidas) {
		for(int k=0;k<partidas.size();k++) {
			Partida partida = partidas.get(k);
			ExibirPartida(partida);
			}}
		
	
	
	
	/** Metodo para listar grupos e suas selecoes
	 * 
	 * @param grupos Lista de grupos
	 * @param selecoes Lista de selecoes
	 */
	public static void listarGrupos(List<Grupo>grupos, List<Selecao>selecoes) {
		for (int i=0;i<grupos.size();i++) {
			//Os dados da Seleção 
			System.out.println(" ");
			Grupo grupo= grupos.get(i);
			System.out.println("GRUPO: [ID: " + grupo.getId() + ", Grupo : " + grupo.getLetraGrupo()+"]");
			for(int j=0;j<selecoes.size();j++) {
				Selecao selecao = selecoes.get(j);
				if(selecao.getIdGrupo()==grupo.getId()) {
					System.out.println("SELEÇÃO: [ID : " + selecao.getId() + ", Nome : " + selecao.getNome() + ", Pontuacão : "+ selecao.getPontuacao()+", Saldo de gols : "+selecao.getSaldoGols()+" ]");
				}}}}
	
		 
	
	/** Metodo para listar tecnico
	 * 
	 * @param tecnicos Lista de tecnicos
	 */
	public static void listarTecnicos(List<Tecnico>tecnicos) {
		for(int i=0;i<tecnicos.size();i++) {
			Tecnico tecnico =tecnicos.get(i);
			Exibirtecnico(tecnico);
			 }}
	
	
	
	/** Metodo para listar selecoes
	 * 
	 * @param selecoes Lista de selecoes
	 */
	public static void listarSelecao(List<Selecao>selecoes) {
		for (Selecao sl : selecoes) {
			ExibirSelecao(sl);
		}}
	
	
	
	/** Metodo para listar selecoes sem grupo
	 * 
	 * @param selecoes Lista de selecoes
	 */
	public static void listarSelecaoSemGrupo(List<Selecao>selecoes) {
		for (Selecao sl : selecoes) {
			if(sl.getIdGrupo()==0) {
				ExibirSelecao(sl);}
		}}
	
	

	

	/** Metodo resposavel por perguntar os ids dos objetos
	 * 
	 * @param ler Scanner para usar o teclado
	 * @param mudanca1 mudanca de palavra
	 * @param mudanca2 mudanca de palavra
	 * @return o id do objeto
	 */
	public static int PerguntaIds(Scanner ler, String mudanca1, String mudanca2) {
		System.out.println("  ");
		System.out.println("Digite o id "+mudanca1 +" que deseja "+mudanca2);
		int id = ler.nextInt();
		return id;
	}
	
	/** Metodo resposavel por perguntar strings 
	 *  
	 * @param mudanca mudanca de palavra
	 * @return A string digitada
	 */
	@SuppressWarnings("resource")
	public static String PerguntaStrings(String mudanca) {
			Scanner dados = new Scanner(System.in);
		    System.out.println("  ");
			System.out.println("Digite " +mudanca);	
			String nome = dados.nextLine().toUpperCase();
			return nome;
		}
	
	
	/** Metodo simples, de exibicao de mensagem de sucesso
	 * 
	 * @param mudanca mudanca de palavra
	 */
	public static void MensagemSucesso(String mudanca) {
		System.out.println("  ");
		System.out.println(mudanca+" com Sucesso! ");
		
		
	}

	/** Metodo simples, de exibicao de mensagem de erro
	 * 
	 * @param mudanca mudanca de palavra
	 */
	public static void MensagemErro(String mudanca) {
		System.out.println("  ");
		System.out.println(mudanca+" nao existe na base de dados!");
		System.out.println("  ");
		
		
	}
	
	
	


	
	/** Metodo responsavel pelo menu de pesquisa
	 * 
	 * @return a opcao escolhida
	 */
	@SuppressWarnings("resource")
	public static int MenuPesquisas() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("O que deseja pesquisar?");
		System.out.println("[1] Selecoes ");
		System.out.println("[2] Jogadores");
		System.out.println("[3] Tecnicos");
		System.out.println("[4] Arbitros");
		System.out.println("[5] Partidas");
		int resp=teclado.nextInt();
		return resp;}
		
	
	
	/**  Metodo simples, de exibicao de mensagem de erro
	 * 
	 * @param mudanca Mudanca a ser feita na frase
	 */
	public static void MensagemErro2(String mudanca) {
		System.out.println("Limite de "+mudanca +" alcançado");}
	
	
	
	/** Metodo responsavel pelo menu de partidas e grupos
	 * 
	 * @param mudanca mudanca de nome de objeto
	 * @return a opcao escolhida
	 */
	@SuppressWarnings("resource")
	public static int menuGruposPartidas(String mudanca) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("  ");
		String mudanca2 =mudanca.toUpperCase();
		System.out.println(mudanca2+"S");
		System.out.println("[1] Criar "+mudanca+"s");
		System.out.println("[2] Editar "+mudanca+"s");
		System.out.println("[3] Excluir "+mudanca+"s");
		System.out.println("[4] Listar "+mudanca+"s");
		int resp=teclado.nextInt();
		return resp;
	}

	
	
	/** Metodo adaptavel responsavel por perguntar a quantidade de cartoes e de gols
	 * 
	 * @param ler Scanner do teclado
	 * @param selecao Nome da selecao
	 * @param mudanca Mudanca de nome
	 * @return A quantidade informada
	 */
	public static int PerguntaDados(Scanner ler, String selecao, String mudanca) {
		System.out.println(" ");
		System.out.println("Digite a quantidade de "+mudanca+" da seleção "+selecao);
		int resp=ler.nextInt();
		System.out.println(" ");
		return resp;}

	
	/** Metodo responsavel por registrar os gols e cartoes dos jogadores
	 * 
	 * @param mudanca Mudanca de frase
	 * @param idSelecao Id da selecao
	 * @param ler Scanner de teclado
	 * @param selecoes Lista de selecoes
	 * @param jogadores Lista de Jogadores
	 * @param dados Quantidade de gols ou cartoes
	 * @param Gol Gol a ser incrementado
	 * @param CartA Cartao amarelo a ser incrementado
	 * @param CartVe Cartao vermelho a ser incrementado
	 * @param nomeSelecao nome da selecao
	 */
	public static void GolsCartoes(String mudanca, int idSelecao,Scanner ler, List<Selecao> selecoes, List<Jogador> jogadores, int dados, int Gol, int CartA, int CartVe,String nomeSelecao) {
		for(int i=1;i<dados+1;i++) {
			int indexSelecao= Funcoes.BuscaPosicao(selecoes, idSelecao);
			Selecao selecao = selecoes.get(indexSelecao);
			//Listar jogadores que estao na selecao passada por parametro 
			for(int j=0;j<selecao.getTime().size();j++) {
				for(Jogador jog:jogadores) {
					if(selecao.getTime().get(j)==jog.getCodJog()) {
						System.out.println("JOGADOR: [ID : " + jog.getCodJog() + ", Nome : " + jog.getNome() + ", Posicao : " + jog.getPosicao()
						+ ", Gols : " + jog.getGols()+", Cartoes Amarelos : " + jog.getCartA()+", Cartoes Vermelhos : " + jog.getCartVe()+" ]");}
			}}
			int idJog = PerguntaIds(ler,"do jogador do "+nomeSelecao," " +mudanca+" "+i);	
			// Verificar se o jogador existe na selecao passado por parametro
			Boolean verificarJog=Funcoes.verificaJogadorSelecao(idJog, selecao);
			if(verificarJog){
				int indexJog=Funcoes.BuscaPosicaoJog(jogadores,idJog);
				Jogador Jogador = jogadores.get(indexJog);
				//Incrementa os dados
				Jogador NovoJogador = new Jogador(idJog,Jogador.getNome(),Jogador.getPosicao(),Jogador.getCartVe()+CartVe,
						Jogador.getCartA()+CartA, Jogador.getGols()+Gol,Jogador.getIdSelecao());
				jogadores.set(indexJog, NovoJogador);}
				
			else{MensagemErro("O jogador");}
			}}

	
	
	
	/** Metodo adaptavel responsavel pelo menu de operacoes dos objetos
	 * 
	 * @param ler Scanner do teclado
	 * @param mudanca1 mudanca de nome de objeto
	 * @param mudanca2 mudanca de palavra
	 * @return a opcao escolhida
	 */
	public static int subMenu2(Scanner ler, String mudanca1, String mudanca2) {
		System.out.println(mudanca2);
		System.out.println("[1]  Editar  "+mudanca1);
		System.out.println("[2]  Listar  "+mudanca1);
		System.out.println("[3]  Deletar "+mudanca1);
		int resp=ler.nextInt();
		return resp;	
	}
	
	
	/** Metodo responsavel pelo tipo de remocao de partidas
	 * 
	 * @param ler Scanner de teclado
	 * @return a opcao escolhida
	 */
	public static int opcaoRemocao(Scanner ler) {
		System.out.println("[1] Remover todas as partidas");
		System.out.println("[2] Remover uma partida");
		int resp=ler.nextInt();
		return resp;}	
		
	
	/** Metodo simples, de exibicao 
	 * @param i numero do jogador
	 */
	public static void jogMain(int i) {
		System.out.println("   Jogador "+i);
		System.out.println("-----------------------");
	} 
	
	
	/** Metodo simples de mensagem de erro
	 * 
	 * @param mudanca1 Mudanca de palavra
	 * @param mudanca2 Mudanca de palavra
	 * @param mudanca3 Mudanca de palavra
	 */
	public static void MensagemErro3(String mudanca1, String mudanca2, String mudanca3) {
		System.out.println(mudanca1+" não pode ser "+  mudanca2+", pois possui "+mudanca3);
	}
	
	
    /** Metodo simples de mensagem de erro do grupo
     */
	public static void MensagemErro4() {
		System.out.println("Grupo não cadastrado");
	}
	
	
	
	
	/** Metodo simples de mensagem de erro
	 * 
	 * @param mudanca1 Mudanca de palavra
	 * @param mudanca2 Mudanca de palavra
	 */
	public static void MensagemErro6(String mudanca1, String mudanca2) {
		System.out.println("É necessario ter "+ mudanca1+" para fazer "+mudanca2);
	}
	
	
	/** Metodo para exibir a selecao
	 * 
	 * @param selecao Selecao a ser exibida
	 */
	public static void ExibirSelecao(Selecao selecao) {
		System.out.println("SELEÇÃO: [ID : " + selecao.getId() + ", Nome : " + selecao.getNome() +" ]");
	}
	
	
	/** Metodo para exibir a partida 
	 * 
	 * @param partida Partida a ser exibida
	 */
	public static void ExibirPartida(Partida partida) {
		System.out.println("PARTIDA: [ID: " + partida.getId() +" "+ partida.getNomeSelecao1()+
				 " "+partida.getGolsSelecao1()+" X "+partida.getGolsSelecao2()+" "+ partida.getNomeSelecao2() +
				 ", Data da partida: "+partida.getData()+", Horario: "+partida.getHorario()+", Local: "+partida.getLocal()+", Arbitro: "+
				  partida.getNomeArb()+ ", Cartões Amarelos: "+ (partida.getCartaoA()+partida.getCartaoA2())+", Cartões Vermelhos: "+(partida.getCartaoVe()+partida.getCartaoVe2())+ " ]");
	
	}
	
	
	/**  Metodo para exibir o jogador
	 * 
	 * @param jog Jogador a ser exibido
	 */
	public static void ExibirJogador(Jogador jog) {
		System.out.println("JOGADOR: [ID : " + jog.getCodJog() + ", Nome : " + jog.getNome() + ", Posicao : " + jog.getPosicao()
		+ ", Gols : " + jog.getGols()+", Cartoes Amarelos : " + jog.getCartA()+", Cartoes Vermelhos : " + jog.getCartVe()+" ]");
	}
	
	
	/** Metodo para exibir o tecnico
	 * 
	 * @param tec Tecnico a ser exibido
	 */
	public static void Exibirtecnico(Tecnico tec) {
		System.out.println("TÉCNICO: [ID : " +tec.getId() + ", Nome : " + tec.getNome() +" ]");
	}
	
	
	
	/** Metodo para exibir o arbitro
	 * 
	 * @param arb Arbitro a ser exibido
	 */
	public static void ExibirArbitro(Arbitro arb) {
		System.out.println("ARBITRO: [ID : " + arb.getId() + ", Nome : " + arb.getNome() +" ]");}
	
	
	
	/** Metodo para buscar uma selecao classificada da fase de grupos
	 * 
	 */
	public static int buscarSelClassGrupos (List<Grupo> grupos, int i, List<Selecao> selecoes, Scanner ler, List<Integer> idSelecoes) {
		Random random = new Random();
		int primeiroId = idSelecoes.get(0);
		int indexPrimeiroId = Funcoes.BuscaPosicao(selecoes,primeiroId);
		Selecao selecaoClassificada = selecoes.get(indexPrimeiroId);
		int idSel = idSelecoes.get(0);
		int indexsel = Funcoes.BuscaPosicao(selecoes, idSel);
		int maior1 = selecoes.get(indexsel).getPontuacao();
	
	
		//Buscando em todas as selecoes nos grupos
		for(int x=0; x<idSelecoes.size();x++) {
			int idSelecao = idSelecoes.get(x);
			int index = Funcoes.BuscaPosicao(selecoes, idSelecao);
			Selecao selecao = selecoes.get(index);
			
		
			// Armazena a selecao com a maior pontuacao
			if(maior1<=selecao.getPontuacao()) {
				selecaoClassificada = selecoes.get(index);
				maior1= selecao.getPontuacao();
			}}
			
			// Verifica se a selecao atualmente classificada tem pontuacao igual a outra selecao da lista
			for(int k1=0; k1<idSelecoes.size();k1++) {
				int idSelecao1 = idSelecoes.get(k1);
				int index1 = Funcoes.BuscaPosicao(selecoes, idSelecao1);
				Selecao selecao1 = selecoes.get(index1);
				
				// Se existir selecoes com pontuacao igual a selecao "classificada", o criterio de desempate sera pelo saldo de gols
				if(selecaoClassificada.getPontuacao()==selecao1.getPontuacao()) {
					//Se o saldo de gols da selecao a ser comparada for maior que a atual
					if(selecaoClassificada.getSaldoGols()<selecao1.getSaldoGols()) {
						// A selecao classificada passa ser a que tem saldo de gols maior
						selecaoClassificada=selecao1;}
					// Se o saldo de gols for igual, haverá um sorteio
					if(selecaoClassificada.getSaldoGols()==selecao1.getSaldoGols()) {
						int numero = random.nextInt(1);
						if (numero==0) {
							return selecao1.getId();}
						if (numero==1) {
							return selecaoClassificada.getId();}
					}}}
			return selecaoClassificada.getId();}
	
	
	public static void ExibirSelecoesClassficadas(List<ClassificadosGrupo> rankings, List<Selecao> selecoes) {
		String letra[]= {"A","B","C","D","E","F","G","H"};
		for(int k=0;k<rankings.size();k++) {
			ClassificadosGrupo ranking = rankings.get(k);
			int idSelecao1 = ranking.getIdClassificado1();
			int idSelecao2 = ranking.getIdClassificado2();
			int index1 = Funcoes.BuscaPosicao(selecoes, idSelecao1);
			int index2 = Funcoes.BuscaPosicao(selecoes, idSelecao2);
			System.out.println("Grupo "+letra[k]);
			ExibirSelecao(selecoes.get(index1));
			ExibirSelecao(selecoes.get(index2));
		}
	}
	
	
}
