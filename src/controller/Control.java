package controller;
import view.Exibicao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dao.ArbitroDao;
import Dao.ArbitroDaoImpl;
import Dao.ClassificadosGrupoDao;
import Dao.ClassificadosGrupoDaoImpl;
import Dao.GrupoDao;
import Dao.GrupoDaoImpl;
import Dao.JogadorDao;
import Dao.JogadorDaoImpl;
import Dao.PartidaDao;
import Dao.PartidaDaoImpl;
import Dao.SelecaoDao;
import Dao.SelecaoDaoImpl;
import Dao.TecnicoDao;
import Dao.TecnicoDaoImpl;
import model.Arbitro;
import model.ClassificadosGrupo;
import model.Grupo;
import model.Jogador;
import model.Selecao;
import model.Tecnico;
import model.Partida;
import model.Funcoes;

/** Classe responsavel por administrar a exibicao de dados, modelo e gerenciamento Dao.
 * 
 * @author Weslei Silva Santos
 *
 */
public class Control {
	SelecaoDao selecaoDao = new SelecaoDaoImpl();
	JogadorDao jogadorDao = new JogadorDaoImpl();
	TecnicoDao tecnicoDao = new TecnicoDaoImpl();
	ArbitroDao arbitroDao = new ArbitroDaoImpl();
	GrupoDao grupoDao = new GrupoDaoImpl();
	PartidaDao partidaDao = new PartidaDaoImpl();   
	ClassificadosGrupoDao classificadosGrupoDao = new ClassificadosGrupoDaoImpl();
	//Lista que carrega os dados da selecaoDao
	List<Selecao> carregarSelecao = selecaoDao.ListSelecao();		
	
	
	/** Metodo que chama um menu opcoes adaptavel para cada objeto.
	 * Os objetos sao:(Selecao, arbitro, jogador e tecnico).
	 * 
	 * @param ler Scanner do teclado
	 * @param nome nome do objeto
	 * @param mudanca mudanca de String
	 * @return a opcao escolhida
	 */
	public int opcaoMenu(Scanner ler, String nome, String mudanca) {
		int opcao =Exibicao.subMenu2(ler, nome, mudanca);
		return opcao;
	}
	
	
	/** Metodo que chama o menu de pesquisas.
	 * 
	 * @return a opcao escolhida
	 */
	public int opcaoMenu3() {
		int opcao = Exibicao.MenuPesquisas();
		return opcao;
	}
	
	
	
	/** Metodo que chama o menu principal de acesso aos objetos
	 * 
	 * @param ler Scanner do teclado
	 * @return a opcao escolhida
	 */
	public int MenuPrincipal(Scanner ler) {
		int opcao = Exibicao.Menu(ler);
		return opcao;
	}
	
	
	/** Metodo que chama o menu de opcoes de partidas e grupos
	 * 
	 * @param mudanca mudanca de nome de objeto
	 * @return a opcao escolhida
	 */
	public int opcaoMenu2(String mudanca) {
		int opcao =Exibicao.menuGruposPartidas(mudanca);
		return opcao;}
		
	
	
	
	/** Metodo responsavel por registrar a selecao junto com o tecnico e seus jogadores
	 * 
	 * @param contTecnico Id do tecnico
	 * @param contSelecao Id da selecao
	 * @param contJogador Id do jogador
	 * @return o id do jogador
	 */
	public int InsercaoSelecao(int contTecnico, int contSelecao, int contJogador) {
		//Cadastrar selecao, tecnicos e arbitros, [CADASTRANDO TODOS AO MESMO TEMPO].
		//limitando o tamanho da selecao
		if(selecaoDao.ListSelecao().size()<32) {
			String nomeSel =  Exibicao.PerguntaStrings("o nome da selecao:  " );	
			String nomeTec =  Exibicao.PerguntaStrings("o nome do tecnico:  " );
					
			//Lista para armazenar o Id do Tecnico
			ArrayList<Integer>tecnico = new ArrayList<>();
					
			Tecnico t1 = new Tecnico(contTecnico, nomeTec, contSelecao);
			tecnico.add(contTecnico);
			
			//Lista de jogadores
			ArrayList<Integer>time = new ArrayList<>();
			for(int i= 0; i<11; i++) {
				Exibicao.jogMain(i+1);
				Jogador jog= Exibicao.CadastroJogador(contJogador, contSelecao);
				jogadorDao.Create(jog);
				
				//Adicionando id do jogador na lista
				time.add(contJogador);
				contJogador++;
				}		
			Selecao s1= new Selecao(contSelecao, nomeSel, time , tecnico,0,0,0);
			
			//Registrando seleçao e tecnico no DAO.
			selecaoDao.CreateSelecao(s1);
			tecnicoDao.CreateTec(t1);		
			Exibicao.MensagemSucesso("Selecao criada");}
		else {
			 Exibicao.MensagemErro2("selecoes");}
	return contJogador;}
	
	
	
	
	/** Metodo responsavel por editar a selecao
	 * 
	 * @param ler Scanner de teclado
	 */
	public  void EditarSelecao(Scanner ler) {
		Exibicao.listarSelecao(selecaoDao.ListSelecao());
		int id = Exibicao.PerguntaIds(ler, "da selecao", "editar");		
		//verificar se a selecao existe
		Boolean verificar= Funcoes.verificarSelecao(id,selecaoDao.ListSelecao());
		if(verificar) {
			//verificar se a selecao nao tem partidas registradas
			Boolean verificarPartida= Funcoes.verificarSelecaoPartida(id,partidaDao.ListPart());
			if(!verificarPartida) {
				String nome =  Exibicao.PerguntaStrings("o nome da seleção:  " );	
				int indiceSelecao=Funcoes.BuscaPosicao(selecaoDao.ListSelecao(), id);	
				Selecao selecao= new Selecao(id, nome, carregarSelecao.get(indiceSelecao).getTime() , carregarSelecao.get(indiceSelecao).getTecnico(), carregarSelecao.get(indiceSelecao).getIdGrupo(),carregarSelecao.get(indiceSelecao).getPontuacao(),carregarSelecao.get(indiceSelecao).getSaldoGols());
				selecaoDao.UpdateSelecao(selecao,id);
				Exibicao.MensagemSucesso("Selecao atualizada");}
			else{Exibicao.MensagemErro3("A seleção","editada","partida registrada");}
				
			}
		else {
			Exibicao.MensagemErro("A selecao");}
	}
	
		
	
	

	/** Metodo responsavel por remover a selecao junto com seus integrantes (tecnico e jogadores)
	 * 
	 * @param ler Scanner de teclado
	 */
	public void RemocaoSelecao(Scanner ler) {
			Exibicao.listarSelecao(selecaoDao.ListSelecao());
			int id = Exibicao.PerguntaIds(ler, "da selecao", "deletar");
			//verificar se a selecao existe
			Boolean verificar= Funcoes.verificarSelecao(id,selecaoDao.ListSelecao());
			if(verificar) {
				//verificar se a selecao nao tem partidas registradas
				Boolean verificarPartida= Funcoes.verificarSelecaoPartida(id,partidaDao.ListPart());
				if(!verificarPartida) {
					//Indice da selecao na lista
					int indexSelecao= Funcoes.BuscaPosicao(selecaoDao.ListSelecao(), id);	
					Selecao selecao = selecaoDao.ListSelecao().get(indexSelecao);				
					//Se a selecao estiver sem grupo..
					if(selecao.getIdGrupo()==0) {
						//Remove jogadores do Dao que estão na selecao
						for(int i=0;i<selecao.getTime().size();i++) {
							jogadorDao.DeleteJog(selecao.getTime().get(i));}
							
						//Remove tecnico do Dao que esta na selecao
						tecnicoDao.DeleteTec(id);
						//Remove a selecao da lista
						selecaoDao.DeleteSelecao(id);					
						Exibicao.MensagemSucesso("Selecao deletada");}
					else {Exibicao.MensagemErro3("A seleção","deletada","grupo definido");}}
					
				else{
					Exibicao.MensagemErro3("A seleção","deletada","partida registrada");}
				}
			
			else {
				Exibicao.MensagemErro("A selecao");}								
		}

	
	
	/** Metodo que chama a listagem de selecoes
	 * 
	 */
	public void ListarSelecao() {
		Exibicao.listarSelecao(selecaoDao.ListSelecao());
	}

	
	
	
	/** Metodo responsavel por editar os dados do jogador
	 * 
	 * @param ler Scanner de teclado
	 */
	public void EditarJogador(Scanner ler) {
			Exibicao.listarJogadores(jogadorDao.ListarJog());
			int id = Exibicao.PerguntaIds(ler, "do jogador", "editar");
			// Verificar se o jogador existe
			Boolean verificar= Funcoes.verificarJogador(id,jogadorDao.ListarJog());
			if(verificar) {
				//Indice da jogador na lista
				int indiceJogador=Funcoes.BuscaPosicaoJog(jogadorDao.ListarJog(), id);
				//Id da selecao que o jogador esta
				int idSelecao=jogadorDao.ListarJog().get(indiceJogador).getIdSelecao();
				
				Jogador jogador=Exibicao.CadastroJogador(id, idSelecao);
				// Se por algum acaso depois da remocao de alguma partida, 
				// o usuario quiser alterar os cartoes e gols do jogador manualmente...
				String opcao = Exibicao.PerguntaStrings("[S] se deseja alterar gols e cartões do jogador");
				if(opcao.equals("S")) {
					jogador =Exibicao.AtualizarDadosJogador(jogador, ler);
				}
				//Atualiza o jogador no Dao
				jogadorDao.UpdateJog(jogador,id);
				Exibicao.MensagemSucesso("Jogador atualizado");}
			else {
				Exibicao.MensagemErro("O jogador");
			}}
	
	
	
	/** Metodo que chama a listagem de jogadores
	 * 
	 */
	public void ListarJogador(){
		Exibicao.listarJogadores(jogadorDao.ListarJog());	
	}

	
	
	/** Metodo responsavel por remover o jogador da lista 
	 * 
	 * @param ler Scanner de teclado
	 */
	public  void RemoverJogador(Scanner ler) {
		Exibicao.listarJogadores(jogadorDao.ListarJog());
		int id = Exibicao.PerguntaIds(ler, "do jogador", "deletar");
		// Verificar se o jogador existe
		Boolean verificar= Funcoes.verificarJogador(id,jogadorDao.ListarJog());
		if(verificar) {
			//Deletando o id do jogador dentro da Selecao
			for (Selecao selecao : selecaoDao.ListSelecao()) {
				for(int i=0;i<selecao.getTime().size();i++) {
					if(selecao.getTime().get(i)==id) {
						selecao.getTime().remove(i);											
						}}}				
			// Deleta o jogador do Dao
			jogadorDao.DeleteJog(id);
			Exibicao.MensagemSucesso("Jogador deletado");}
		
		else {
			Exibicao.MensagemErro("O jogador");}
	}

	
	
	/** Metodo responsavel por editar os dados do tecnico
	 * 
	 * @param ler Scanner teclado
	 */
	public  void EditarTecnico(Scanner ler) {
		Exibicao.listarTecnicos(tecnicoDao.ListTec());				
		int id = Exibicao.PerguntaIds(ler, "do tecnico", "editar");
		// Verificar se o tecnico existe
		Boolean verificar= Funcoes.verificarTecnico(id,tecnicoDao.ListTec());
		if(verificar) {
			String nomeTecnico =  Exibicao.PerguntaStrings("o nome do tecnico:  " );
			//Indice do tecnico na lista
			int indiceTecnico = Funcoes.BuscaPosicaoTec(tecnicoDao.ListTec(), id);
			//Pegando o id da selecao dentro do tecnico
			int idSelecao= tecnicoDao.ListTec().get(indiceTecnico).getIdSelecao();
			Tecnico t1= new Tecnico(id, nomeTecnico, idSelecao);
			//Atualiza no Dao
			tecnicoDao.UpdateTec(t1,id);	
			Exibicao.MensagemSucesso("Tecnico atualizado");}
		
		else {
			Exibicao.MensagemErro("O tecnico");}
	}


	/** Metodo que chama a listagem de tecnicos
	 * 
	 */
	public void ListarTecnico(){
		Exibicao.listarTecnicos(tecnicoDao.ListTec());
	}
	
	
	/** Metodo responsavel por remover o tecnico da lista 
	 * 
	 * @param ler Scanner de teclado
	 */
	public  void RemoverTecnico(Scanner ler) {
		Exibicao.listarTecnicos(tecnicoDao.ListTec());
	    int id = Exibicao.PerguntaIds(ler, "do tecnico", "deletar");
	    // Verificar se o tecnico existe
	    Boolean verificar= Funcoes.verificarTecnico(id,tecnicoDao.ListTec());
		if(verificar) {
		    //Deletando do Dao
			tecnicoDao.DeleteTec(id);		
			//Deletando dentro da Selecao
			for (Selecao selecao : selecaoDao.ListSelecao()) {
				for(int i=0;i<selecao.getTecnico().size();i++) {
					if(selecao.getTecnico().get(i)==id) {
						selecao.getTecnico().remove(i);											
						}}}			
			Exibicao.MensagemSucesso("Tecnico deletado");}
		else {Exibicao.MensagemErro("O tecnico");}
	}


	
	/** Metodo responsavel por editar os dados do arbitro
	 * 
	 * @param ler Scanner de teclado
	 */
	public  void EditarArbitro(Scanner ler) {
		Exibicao.listarArbitros(arbitroDao.ListArb());
		int id = Exibicao.PerguntaIds(ler, "do arbitro", "editar");
		// Verificar se o arbitro existe
		Boolean verificar= Funcoes.verificarArbitro(id,arbitroDao.ListArb());
		if(verificar) {
			String nomeArbitro= Exibicao.PerguntaStrings("o nome do arbitro:  " );	
			Arbitro arbitro = new Arbitro(id, nomeArbitro,partidaDao.ListPart().get(Funcoes.BuscaPosicaoArb( arbitroDao.ListArb(), id)).getId());
			// Atualiza no Dao
			arbitroDao.UpdateArb(arbitro, id);
			//Atualiza na partida
			for(Partida partida: partidaDao.ListPart()) {
				if(partida.getArbitro()==id) {
					partida.setNomeArb(nomeArbitro);
				}
			}
			Exibicao.MensagemSucesso("Arbitro atualizado");}
		
		else {
			Exibicao.MensagemErro("O arbitro");}
	}
	
	
	/** Metodo que chama a listagem de arbitros
	 * 
	 */
	public void ListarArbitros(){
		Exibicao.listarArbitros(arbitroDao.ListArb());
	}
	
	
	/** Mettodo responsavel por remover o arbitro da lista
	 * 
	 * @param ler Scanner de teclado
	 */
	public  void RemoverArbitro(Scanner ler) {
		Exibicao.listarArbitros(arbitroDao.ListArb());
		int id = Exibicao.PerguntaIds(ler, "do arbitro", "deletar");
		// Verificar se o arbitro existe
		Boolean verificar= Funcoes.verificarArbitro(id,arbitroDao.ListArb());
		if(verificar) {
			// Deleta do Dao
			arbitroDao.DeleteArb(id);
			// Tira da partida
			for(Partida partida: partidaDao.ListPart()) {
				if(partida.getArbitro()==id) {
					partida.setNomeArb("não definido");
					partida.setArbitro(0);
				}}
			Exibicao.MensagemSucesso("Arbitro deletado");
			}
		else {
			Exibicao.MensagemErro("O arbitro");}
	}
	
	
	
	
	/** Metodo responsavel por criar um grupo de selecoes
	 * 
	 * @param ler Scanner de teclado
	 * @param contGrupo Id do grupo
	 * @return O id do grupo
	 */
	public  int CriarGrupo(Scanner ler, int contGrupo) {
		// O cadastro so pode ser realizado se existir 32 selecoes na lista
		if(selecaoDao.ListSelecao().size()==32) {
			// E se nao existir 8 grupos formados
			if(grupoDao.ListGrup().size()!=8) {
				// Lista de ids de selecoes
				ArrayList<Integer>selecoes = new ArrayList<>();
				String LetraGrupo = Exibicao.PerguntaStrings("o nome/letra do grupo que deseja criar");
				// Cadastra 4 selecoes
				for(int i=0;i<4;i++) {
					Exibicao.listarSelecaoSemGrupo(selecaoDao.ListSelecao());
					int id = Exibicao.PerguntaIds(ler, "da seleção", "colocar no grupo "+ LetraGrupo);
					// Verificar se a selecao existe
					Boolean verificar= Funcoes.verificarSelecao(id,selecaoDao.ListSelecao());
					if(verificar) {
						// Adiciona o id da selecao na lista
						selecoes.add(id);
						}
					else{Exibicao.MensagemErro("A seleção");}}
				
				// Se as selecoes forem cadastradas...
				if(selecoes.size()==4) {								
					Grupo grupo = new Grupo(contGrupo, LetraGrupo,selecoes);
					grupoDao.CreateGrup(grupo);	
					//Depois de criar o grupo, atualiza o id do grupo dentro da selecao
					for(int i=0; i<selecoes.size();i++) {
						int id = selecoes.get(i);
						int indiceSelecao=Funcoes.BuscaPosicao(selecaoDao.ListSelecao(), id);
						Selecao selecao = new Selecao(id, carregarSelecao.get(indiceSelecao).getNome(),carregarSelecao.get(indiceSelecao).getTime(),
								carregarSelecao.get(indiceSelecao).getTecnico(),contGrupo,carregarSelecao.get(indiceSelecao).getPontuacao(),carregarSelecao.get(indiceSelecao).getSaldoGols());
						selecaoDao.UpdateSelecao(selecao, id);}
						
					Exibicao.MensagemSucesso("Grupo "+LetraGrupo+" criado");
					contGrupo++;				
				}
				else{Exibicao.MensagemErro4();}}
			else {Exibicao.MensagemErro2("grupos");}}		
		else {Exibicao.MensagemErro6("32 seleções","a fase grupos");}
		return contGrupo;
	}
	
	
	
	
	/** Metodo responsavel por editar os dados do grupo
	 * 
	 * @param ler Scanner de teclado
	 */
	public  void EditarGrupo(Scanner ler) {
		// Na edicao do grupo só é possivel editar o nome/letra
		Exibicao.listarGrupos(grupoDao.ListGrup(),selecaoDao.ListSelecao());
		int id = Exibicao.PerguntaIds(ler, "do grupo", "editar");
		// Verificar se o grupo existe
		Boolean verificar= Funcoes.verificarGrupo(id,grupoDao.ListGrup());
		if(verificar) {
			String LetraGrupo = Exibicao.PerguntaStrings("o nome/letra do grupo");
			int index=Funcoes.BuscaPosicaoGrp(grupoDao.ListGrup(), id);
			Grupo grupo = new Grupo(id,LetraGrupo,grupoDao.ListGrup().get(index).getSelecoes());
			//Atualiza no Dao
			grupoDao.UpdateGrup(grupo, id);
			Exibicao.MensagemSucesso("Grupo "+LetraGrupo+" Atualizado");
		}
		else{
			Exibicao.MensagemErro("O grupo");}
	}
	
	
	
	/** Metodo responsavel por remover o grupo da lista
	 * 
	 * @param ler Sacnner de teclado
	 */
	public  void RemoverGrupo(Scanner ler) {
		Exibicao.listarGrupos(grupoDao.ListGrup(),selecaoDao.ListSelecao());
		 int id = Exibicao.PerguntaIds(ler,"do grupo", "deletar");
		 //Verificar se o grupo existe
		 Boolean verificar= Funcoes.verificarGrupo(id,grupoDao.ListGrup());
		 if(verificar){
			 //Verificar se o grupo nao tem partidas marcadas
			 Boolean verificarPartida= Funcoes.verificarGrupoPartida(id, partidaDao.ListPart());
			 if(!verificarPartida){
				 for(int i =0; i<grupoDao.ListGrup().size();i++) {
					 Grupo grupo = grupoDao.ListGrup().get(i);
					if(grupo.getId()==id) {
						//Busca todos os ids de selecoes dentro dos grupos
						  for(int j =0; j<grupo.getSelecoes().size();j++) {
							 int idSelecao=grupo.getSelecoes().get(j);
							 // Busca as selecoes para comparar
							 for (int k =0; k<selecaoDao.ListSelecao().size();k++) {
								 Selecao selecao = selecaoDao.ListSelecao().get(k);						
								 if(idSelecao ==selecao.getId()) {
									 //Zera o id do grupo dentro da selecao e a pontuacao
									 Selecao novaSelecao = new Selecao(idSelecao, selecao.getNome(), selecao.getTime(), selecao.getTecnico(), 0,0, selecao.getSaldoGols());
									 // Atualiza no Dao
									 selecaoDao.UpdateSelecao(novaSelecao, idSelecao);
								 } } }}	}
				 //Deleta o grupo 
				 grupoDao.DeleteGrup(id);
				 Exibicao.MensagemSucesso("Grupo Deletado");}
			 else {Exibicao.MensagemErro3("O grupo","deletado","partida registrada");
				}}
		 
		 else{Exibicao.MensagemErro("O grupo"); 
		 }}
	
	
	
	/** Metodo que chama a listagem de grupos
	 * 
	 */
	public  void ListarGrupos() {
		Exibicao.listarGrupos(grupoDao.ListGrup(),selecaoDao.ListSelecao());
	}
	
	
	
	/** Metodo responsavel por criar as partidas
	 * 
	 * @param ler Scanner de teclado
	 * @param contPartida Id da partida
	 * @return O id da partida
	 */
	public  int CriarPartidas(Scanner ler, int contPartida) {
		// Se os 8 grupos estiverem formados 
		if(grupoDao.ListGrup().size()==8) {
			// So sera possivel criar as partidas automaticas, se a lista de partidas estiver vazia
			if(partidaDao.ListPart().size()==0) {
				//Buscando todos os grupos
				for (Grupo grupo : grupoDao.ListGrup()) {
					//Buscando o id da primeira selecao dentro do grupo
					for(int k=0; k<grupo.getSelecoes().size();k++) {
						//id da selecao1
						int idSelecao1=grupo.getSelecoes().get(k);
						//Buscando o id da segunda selecao dentro do grupo
						for(int p=k+1; p<grupo.getSelecoes().size();p++) {
							//id da selecao2
							int idSelecao2=grupo.getSelecoes().get(p);
							//Cria a partida com dados vazios, somente com os dados dados da selecao
							Partida partida = new Partida(contPartida, "não definido", "não definido", "não definido ",carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao1)).getNome(),carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao2)).getNome(),carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao1)).getId(), carregarSelecao.get(Funcoes.BuscaPosicao(selecaoDao.ListSelecao(),idSelecao2)).getId(), 0,0, 0, "não definido",0,0,0,0, grupo.getId());
							contPartida++;
							partidaDao.CreatePart(partida);
								}
							}}
				Exibicao.MensagemSucesso("Partidas Criadas");}
			else if(partidaDao.ListPart().size()!=0 && partidaDao.ListPart().size()!=48) {
				Exibicao.MensagemErro6("a lista de partidas vazia","novas partidas automaticas, portanto, remova todas as partidas atuais");
			}
			else{Exibicao.MensagemErro2(" partidas");}}
		else{
			Exibicao.MensagemErro6("8 grupos","as partidas");}
		return contPartida;
		}
	
	
	/** Metodo responsavel por editar os dados da partida
	 * 
	 * @param ler Scanner de teclado
	 * @param contArbitro id do arbitro
	 * @return O id do arbitro
	 */
	public int EditarPartida(Scanner ler, int contArbitro) {
		Exibicao.listarPartidas(partidaDao.ListPart());
		int idPartida = Exibicao.PerguntaIds(ler,"da partida", "editar");
		//Verificar se a partida existe
		Boolean verificar=Funcoes.verificarPartida(idPartida, partidaDao.ListPart());
		if(verificar){
			//Indice da partida na lista
			int index=Funcoes.BuscaPosicaoPart(partidaDao.ListPart(),idPartida);
			//Coletando os dados..
			Partida partida = partidaDao.ListPart().get(index);
			String data =Exibicao.PerguntaStrings("a data da partida");
			String horario =Exibicao.PerguntaStrings("o horario da partida");
			String local = Exibicao.PerguntaStrings("o local da partida");
			
			int golsSelecao1= Exibicao.PerguntaDados(ler,partida.getNomeSelecao1(), "gols");
			int CartoesA= Exibicao.PerguntaDados(ler,partida.getNomeSelecao1(),  "Cartões Amarelos");
			int CartoesVe= Exibicao.PerguntaDados(ler,partida.getNomeSelecao1(),  "Cartões Vermelhos");
			
			int golsSelecao2= Exibicao.PerguntaDados(ler,partida.getNomeSelecao2(),  "gols");
			int CartoesA2= Exibicao.PerguntaDados(ler,partida.getNomeSelecao2(),  "Cartões Amarelos");
			int CartoesVe2= Exibicao.PerguntaDados(ler,partida.getNomeSelecao2(),  "Cartões Vermelhos");
			
			//Adicionando pontuacao
			if(golsSelecao1>golsSelecao2) {
				int idSelecao=partida.getSelecao1();
				int indexSelecao = Funcoes.BuscaPosicao(carregarSelecao, idSelecao);
				Selecao selecao =carregarSelecao.get(indexSelecao);
				Selecao Novaselecao = new Selecao(idSelecao,selecao.getNome() ,selecao.getTime(),selecao.getTecnico(),
						selecao.getIdGrupo(), selecao.getPontuacao()+3, selecao.getSaldoGols());
				selecaoDao.UpdateSelecao(Novaselecao, idSelecao);}
			
			//Adicionando pontuacao
			if(golsSelecao2>golsSelecao1) {
				int idSelecao=partida.getSelecao2();
				int indexSelecao = Funcoes.BuscaPosicao(carregarSelecao, idSelecao);
				Selecao selecao =carregarSelecao.get(indexSelecao);
				Selecao Novaselecao = new Selecao(idSelecao,selecao.getNome() ,selecao.getTime(),selecao.getTecnico(),
						selecao.getIdGrupo(), selecao.getPontuacao()+3, selecao.getSaldoGols());
				selecaoDao.UpdateSelecao(Novaselecao, idSelecao);}
			
			//Adicionando pontuacao
			if(golsSelecao2==golsSelecao1) {
				int idSelecao=partida.getSelecao1();
				int indexSelecao = Funcoes.BuscaPosicao(carregarSelecao, idSelecao);
				Selecao selecao =carregarSelecao.get(indexSelecao);
				Selecao Novaselecao = new Selecao(idSelecao,selecao.getNome() ,selecao.getTime(),selecao.getTecnico(),
						selecao.getIdGrupo(), selecao.getPontuacao()+1, selecao.getSaldoGols());
				selecaoDao.UpdateSelecao(Novaselecao, idSelecao);
				
				int idSelecao2=partida.getSelecao2();
				int indexSelecao2 = Funcoes.BuscaPosicao(carregarSelecao, idSelecao2);
				Selecao selecao2 =carregarSelecao.get(indexSelecao2);
				Selecao Novaselecao2 = new Selecao(idSelecao2,selecao2.getNome() ,selecao2.getTime(),selecao2.getTecnico(),
						selecao2.getIdGrupo(), selecao2.getPontuacao()+1, selecao2.getSaldoGols());
				selecaoDao.UpdateSelecao(Novaselecao2, idSelecao2);}
			
			//Adicionando gols nas selecao1
			int idSelecao=partida.getSelecao1();
			int indexSelecao = Funcoes.BuscaPosicao(carregarSelecao, idSelecao);
			Selecao selecao =carregarSelecao.get(indexSelecao);
			Selecao novaSelecao = new Selecao(idSelecao,selecao.getNome() ,selecao.getTime(),selecao.getTecnico(),
					selecao.getIdGrupo(), selecao.getPontuacao(), selecao.getSaldoGols()+golsSelecao1);
			selecaoDao.UpdateSelecao(novaSelecao, idSelecao);
			
			//Adicionando Gols na selecao2
			int idSelecao2=partida.getSelecao2();
			int indexSelecao2 = Funcoes.BuscaPosicao(carregarSelecao, idSelecao2);
			Selecao selecao2 =carregarSelecao.get(indexSelecao2);
			Selecao novaSelecao2 = new Selecao(idSelecao2,selecao2.getNome() ,selecao2.getTime(),selecao2.getTecnico(),
					selecao2.getIdGrupo(), selecao2.getPontuacao(), selecao2.getSaldoGols()+golsSelecao2);
			selecaoDao.UpdateSelecao(novaSelecao2, idSelecao2);
			
			
			
			
			
			
			String nomeArbitro=  Exibicao.PerguntaStrings("o nome do arbitro:  " );
			Arbitro Arbitro = new Arbitro(contArbitro, nomeArbitro, idPartida);
			// Cria o arbitro no Dao
			arbitroDao.Create(Arbitro);
			
			Partida NovaPartida = new Partida(idPartida, data, horario, local,partida.getNomeSelecao1(), partida.getNomeSelecao2(), partida.getSelecao1(), 
			partida.getSelecao2(),contArbitro, golsSelecao1, golsSelecao2,nomeArbitro, CartoesVe, CartoesA, CartoesVe2, CartoesA2, partida.getIdGrupo());
			contArbitro++;
			// Atualiza partida no Dao
			partidaDao.UpdatePart(NovaPartida, idPartida);
			
			// Atualiza os cartoes e gols nos jogadores da selecao1
			if(golsSelecao1>0){Exibicao.GolsCartoes("adicionar o gol ",partida.getSelecao1(),  ler,selecaoDao.ListSelecao(),jogadorDao.ListarJog(), golsSelecao1,  1,0,0,partidaDao.ListPart().get(index).getNomeSelecao1());}
			if(CartoesA>0){Exibicao.GolsCartoes("adicionar o cartão amarelo ",partida.getSelecao1(),  ler,  selecaoDao.ListSelecao(),  jogadorDao.ListarJog(),CartoesA ,  0,1,0,partidaDao.ListPart().get(index).getNomeSelecao1());}
			if(CartoesVe>0){Exibicao.GolsCartoes("adicionar o cartão vermelho ",partida.getSelecao1(),ler,  selecaoDao.ListSelecao(),  jogadorDao.ListarJog(), CartoesVe,  0,0,1,partidaDao.ListPart().get(index).getNomeSelecao1());}
			
			// Atualiza os cartoes e gols nos jogadores da selecao2
			if(golsSelecao2>0) {Exibicao.GolsCartoes("adicionar o gol ",partida.getSelecao2(),  ler,  selecaoDao.ListSelecao(),  jogadorDao.ListarJog(), golsSelecao2,  1,0,0,partidaDao.ListPart().get(index).getNomeSelecao2());}
			if(CartoesA2>0) {Exibicao.GolsCartoes("adicionar o cartão amarelo ",partida.getSelecao2(),  ler,  selecaoDao.ListSelecao(),  jogadorDao.ListarJog(), CartoesA2,  0,1,0,partidaDao.ListPart().get(index).getNomeSelecao2());}		
			if(CartoesVe2>0) {Exibicao.GolsCartoes("adicionar o cartão vermelho ",partida.getSelecao2(),  ler,  selecaoDao.ListSelecao(),  jogadorDao.ListarJog(), CartoesVe2,  0,0,1,partidaDao.ListPart().get(index).getNomeSelecao2());}
			
			Exibicao.MensagemSucesso("Partida Atualizada");
		
		}
		else{Exibicao.MensagemErro("A partida");}
		return contArbitro;
	}
	
	
	
	
	/** Metodo responsavel por remover partidas da lista
	 * 
	 * @param ler Scanner de teclado
	 */
	public void RemoverPartida(Scanner ler) {
		int pergunta = Exibicao.opcaoRemocao(ler);
		//Remover todas as partidas
		if(pergunta==1) {
			partidaDao.ListPart().clear();
			arbitroDao.ListArb().clear();
			Exibicao.MensagemSucesso("Todas as partidas foram deletadas");}
		//Remover uma partida
		if(pergunta==2) {
			Exibicao.listarPartidas(partidaDao.ListPart());
			int id = Exibicao.PerguntaIds(ler,"da partida", "deletar");
			// Verificar se a partida existe
			Boolean verificar= Funcoes.verificarPartida(id,partidaDao.ListPart());
			if(verificar){
				// Posicao da partida na lista
				int indexPartida= Funcoes.BuscaPosicaoPart(partidaDao.ListPart(),id);
				//Id do arbitro dentro da partida
				int idArbitro = partidaDao.ListPart().get(indexPartida).getArbitro();
				arbitroDao.DeleteArb(idArbitro);
				partidaDao.DeletePart(id);

				Exibicao.MensagemSucesso("Partida deletada");}
			else {Exibicao.MensagemErro("A partida");}
			}
			
		}
	
	
	/** Metodo que chama a listagem de partidas
	 * 
	 */
	public void ListarPartidas() {
		Exibicao.listarPartidas(partidaDao.ListPart());
	}
	
	
	/** Metodo responsavel por pesquisar objetos
	 * 
	 * @param pergunta opcao de pesquisa
	 */
	public void Pesquisa(int pergunta) {
		// Pesquisar Selecao
		if(pergunta==1) {
			String nome= Exibicao.PerguntaStrings("o nome da selecao a ser pesquisada");
			List<Integer> IdsSelecoes =selecaoDao.SearchSelec(nome);
			for(int i=0; i<IdsSelecoes.size();i++) {
				for(int k=0; k<selecaoDao.ListSelecao().size();k++) {
					Selecao selecao = selecaoDao.ListSelecao().get(k);
					if(IdsSelecoes.get(i)==selecao.getId()) {
						Exibicao.ExibirSelecao(selecao);
		}}}}
		
		// Pesquisar Jogador
		if(pergunta==2) {
			String nome= Exibicao.PerguntaStrings("o nome do jogador a ser pesquisado");
			List<Integer> IdsJogadores=jogadorDao.SearchJog(nome);
			for(int i=0; i<IdsJogadores.size();i++) {
				for(int k=0; k<jogadorDao.ListarJog().size();k++) {
					Jogador jog = jogadorDao.ListarJog().get(k);
					if(IdsJogadores.get(i)==jog.getCodJog()) {
						Exibicao.ExibirJogador(jog);
		}}}}
		
		// Pesquisar Tecnico
		if(pergunta==3) {
			String nome= Exibicao.PerguntaStrings("o nome do tecnico a ser pesquisado");
			List<Integer> IdsTecnicos=tecnicoDao.SearchTec(nome);
			for(int i=0; i<IdsTecnicos.size();i++) {
				for(int k=0; k<tecnicoDao.ListTec().size();k++) {
					Tecnico tec =tecnicoDao.ListTec().get(k);
					if(IdsTecnicos.get(i)==tec.getId()) {
						Exibicao.Exibirtecnico(tec);
		}}}}
		
		// Pesquisar Arbitro
		if(pergunta==4) { 
			String nome= Exibicao.PerguntaStrings("o nome do arbitro a ser pesquisado");
			List<Integer> IdsArbitros=arbitroDao.SearchArb(nome);
			for(int i=0; i<IdsArbitros.size();i++) {
				for(int k=0; k<arbitroDao.ListArb().size();k++) {
					Arbitro arb = arbitroDao.ListArb().get(k);
					if(IdsArbitros.get(i)==arb.getId()) {
						Exibicao.ExibirArbitro(arb);
		}}}}
		
		// Pesquisar Partida
		if(pergunta==5) {
			String data= Exibicao.PerguntaStrings("a data da partida a ser pesquisada");
			List<Integer> IdsPartidas=partidaDao.SearchPart(data);
			for(int i=0; i<IdsPartidas.size();i++) {
				for(int k=0; k<partidaDao.ListPart().size();k++) {
					Partida partida = partidaDao.ListPart().get(k);
					if(IdsPartidas.get(i)==partida.getId()) {
					Exibicao.ExibirPartida(partida);}}}}}
	
	
	
	
	
	
	//CriarOitavasDeFinal
	public int FazerClassificacao(Scanner ler, int contClassificacao) {		
		// Buscando em todos os grupos
		for(int i=0; i<grupoDao.ListGrup().size();i++) {
	
			ArrayList<Integer> selecoes = new ArrayList<Integer>();
			for(int j=0; j<4;j++) {
				selecoes.add(grupoDao.ListGrup().get(i).getSelecoes().get(j));}
			
			for (int z = 0; z < selecoes.size(); z++) {
				System.out.println(selecoes.get(z));
			}
			
			int idClassificado1 =Exibicao.buscarSelClassGrupos(grupoDao.ListGrup(),i, selecaoDao.ListSelecao(),ler, selecoes);	
			//System.out.println(idClassificado1);
			//Removendo o id da primeira selecao classificada da lista
			for (int z = 0; z < selecoes.size(); z++) {
				// Se achar o id na lista
				if(idClassificado1 == selecoes.get(z)) {
					selecoes.remove(z);}}
			
			for (int z = 0; z < selecoes.size(); z++) {
				System.out.println(selecoes.get(z));
			}
		
			int idClassificado2 =Exibicao.buscarSelClassGrupos(grupoDao.ListGrup(),i, selecaoDao.ListSelecao(),ler, selecoes);	
			ClassificadosGrupo ranking = new ClassificadosGrupo(contClassificacao, idClassificado1, idClassificado2);
			classificadosGrupoDao.CreateClassGrupo(ranking);
			System.out.println("Ids coletados");}
		return contClassificacao;}
				
		
	
	public void ListarSelecoesClassificadas() {
		Exibicao.ExibirSelecoesClassficadas(classificadosGrupoDao.ListClassGrupo(), carregarSelecao);
	}
	
	
	
	
	
	/** Metodo responsavel por chamar a listagem das selecoes com tecnico e jogadores
	 * 
	 * @param ler Scanner de teclado
	 */
	public  void ListagemTimes(Scanner ler) {
		Exibicao.ListarTudoSelecao(selecaoDao.ListSelecao(), tecnicoDao.ListTec(),jogadorDao.ListarJog());
	}

	
	public void construir() {
		//Adicionando os ids de jogadores 
		ArrayList<Integer>jogadores1 = new ArrayList<>();
		for(int i=1; i<12; i++) {
			jogadores1.add(i);}
		
		
		ArrayList<Integer>jogadores2 = new ArrayList<>();
		for(int i=12; i<23; i++) {
			jogadores2.add(i);}
		
		
		ArrayList<Integer>jogadores3 = new ArrayList<>();
		for(int i=23; i<34; i++) {
			jogadores3.add(i);}
		
		ArrayList<Integer>jogadores4 = new ArrayList<>();
		for(int i=34; i<45; i++) {
			jogadores4.add(i);}
		
		ArrayList<Integer>jogadores5 = new ArrayList<>();
		for(int i=45; i<56; i++) {
			jogadores5.add(i);}
		
		ArrayList<Integer>jogadores6 = new ArrayList<>();
		for(int i=56; i<67; i++) {
			jogadores6.add(i);}
		
		ArrayList<Integer>jogadores7 = new ArrayList<>();
		for(int i=67; i<78; i++) {
			jogadores7.add(i);}
		
		ArrayList<Integer>jogadores8 = new ArrayList<>();
		for(int i=78; i<89; i++) {
			jogadores8.add(i);}

		ArrayList<Integer>jogadores9 = new ArrayList<>();
		for(int i=89; i<100; i++) {
			jogadores9.add(i);}
		
		ArrayList<Integer>jogadores10 = new ArrayList<>();
		for(int i=100; i<111; i++) {
			jogadores10.add(i);}
		
		
		
		
		ArrayList<Integer>jogadores11 = new ArrayList<>();
		for(int i=111; i<122; i++) {
			jogadores11.add(i);}
		
		
		ArrayList<Integer>jogadores12 = new ArrayList<>();
		for(int i=122; i<133; i++) {
			jogadores12.add(i);}
		
		
		ArrayList<Integer>jogadores13 = new ArrayList<>();
		for(int i=133; i<144; i++) {
			jogadores13.add(i);}
		
		ArrayList<Integer>jogadores14 = new ArrayList<>();
		for(int i=144; i<155; i++) {
			jogadores14.add(i);}
		
		ArrayList<Integer>jogadores15 = new ArrayList<>();
		for(int i=155; i<166; i++) {
			jogadores15.add(i);}
		
		ArrayList<Integer>jogadores16 = new ArrayList<>();
		for(int i=166; i<177; i++) {
			jogadores16.add(i);}
		
		ArrayList<Integer>jogadores17 = new ArrayList<>();
		for(int i=177; i<188; i++) {
			jogadores17.add(i);}
		
		ArrayList<Integer>jogadores18 = new ArrayList<>();
		for(int i=188; i<199; i++) {
			jogadores18.add(i);}

		ArrayList<Integer>jogadores19 = new ArrayList<>();
		for(int i=199; i<210; i++) {
			jogadores19.add(i);}
		
		ArrayList<Integer>jogadores20 = new ArrayList<>();
		for(int i=210; i<221; i++) {
			jogadores20.add(i);}
		
		
		
		

		ArrayList<Integer>jogadores21 = new ArrayList<>();
		for(int i=221; i<232; i++) {
			jogadores21.add(i);}
		
		
		ArrayList<Integer>jogadores22 = new ArrayList<>();
		for(int i=232; i<243; i++) {
			jogadores22.add(i);}
		
		
		ArrayList<Integer>jogadores23 = new ArrayList<>();
		for(int i=243; i<254; i++) {
			jogadores23.add(i);}
		
		ArrayList<Integer>jogadores24 = new ArrayList<>();
		for(int i=254; i<265; i++) {
			jogadores24.add(i);}
		
		ArrayList<Integer>jogadores25 = new ArrayList<>();
		for(int i=265; i<276; i++) {
			jogadores25.add(i);}
		
		ArrayList<Integer>jogadores26 = new ArrayList<>();
		for(int i=276; i<287; i++) {
			jogadores26.add(i);}
		
		ArrayList<Integer>jogadores27 = new ArrayList<>();
		for(int i=287; i<298; i++) {
			jogadores27.add(i);}
		
		ArrayList<Integer>jogadores28 = new ArrayList<>();
		for(int i=298; i<309; i++) {
			jogadores28.add(i);}

		ArrayList<Integer>jogadores29 = new ArrayList<>();
		for(int i=309; i<320; i++) {
			jogadores29.add(i);}
		
		ArrayList<Integer>jogadores30 = new ArrayList<>();
		for(int i=320; i<331; i++) {
			jogadores30.add(i);}
		
		

		ArrayList<Integer>jogadores31 = new ArrayList<>();
		for(int i=331; i<342; i++) {
			jogadores31.add(i);}
		
		ArrayList<Integer>jogadores32 = new ArrayList<>();
		for(int i=342; i<353; i++) {
			jogadores32.add(i);}
		
		
		
		
	
		
		
		
		
		
		
		ArrayList<Integer>tecnico1 = new ArrayList<>();
		tecnico1.add(1);
		ArrayList<Integer>tecnico2 = new ArrayList<>();
		tecnico2.add(2);
		ArrayList<Integer>tecnico3 = new ArrayList<>();
		tecnico3.add(3);
		ArrayList<Integer>tecnico4 = new ArrayList<>();
		tecnico4.add(4);
		ArrayList<Integer>tecnico5 = new ArrayList<>();
		tecnico5.add(5);
		ArrayList<Integer>tecnico6 = new ArrayList<>();
		tecnico6.add(6);
		ArrayList<Integer>tecnico7 = new ArrayList<>();
		tecnico7.add(7);
		ArrayList<Integer>tecnico8 = new ArrayList<>();
		tecnico8.add(8);
		ArrayList<Integer>tecnico9 = new ArrayList<>();
		tecnico9.add(9);
		ArrayList<Integer>tecnico10 = new ArrayList<>();
		tecnico10.add(10);
		ArrayList<Integer>tecnico11 = new ArrayList<>();
		tecnico11.add(11);
		ArrayList<Integer>tecnico12 = new ArrayList<>();
		tecnico12.add(12);
		ArrayList<Integer>tecnico13 = new ArrayList<>();
		tecnico13.add(13);
		ArrayList<Integer>tecnico14 = new ArrayList<>();
		tecnico14.add(14);
		ArrayList<Integer>tecnico15 = new ArrayList<>();
		tecnico15.add(15);
		ArrayList<Integer>tecnico16 = new ArrayList<>();
		tecnico16.add(16);
		ArrayList<Integer>tecnico17 = new ArrayList<>();
		tecnico17.add(17);
		ArrayList<Integer>tecnico18 = new ArrayList<>();
		tecnico18.add(18);
		ArrayList<Integer>tecnico19 = new ArrayList<>();
		tecnico19.add(19);
		ArrayList<Integer>tecnico20 = new ArrayList<>();
		tecnico20.add(20);
		ArrayList<Integer>tecnico21 = new ArrayList<>();
		tecnico21.add(21);
		ArrayList<Integer>tecnico22 = new ArrayList<>();
		tecnico22.add(22);
		ArrayList<Integer>tecnico23 = new ArrayList<>();
		tecnico23.add(23);
		ArrayList<Integer>tecnico24 = new ArrayList<>();
		tecnico24.add(24);
		ArrayList<Integer>tecnico25 = new ArrayList<>();
		tecnico25.add(25);
		ArrayList<Integer>tecnico26 = new ArrayList<>();
		tecnico26.add(26);
		ArrayList<Integer>tecnico27 = new ArrayList<>();
		tecnico27.add(27);
		ArrayList<Integer>tecnico28 = new ArrayList<>();
		tecnico28.add(28);
		ArrayList<Integer>tecnico29 = new ArrayList<>();
		tecnico29.add(29);
		ArrayList<Integer>tecnico30 = new ArrayList<>();
		tecnico30.add(30);
		
		ArrayList<Integer>tecnico31 = new ArrayList<>();
		tecnico30.add(31);
		ArrayList<Integer>tecnico32 = new ArrayList<>();
		tecnico30.add(32);
		
		Selecao selecao1= new Selecao(1, "HOLANDA", jogadores1, tecnico1, 1, 0, 0);
		selecaoDao.CreateSelecao(selecao1);
		Selecao selecao2= new Selecao(2, "EQUADOR", jogadores2, tecnico2, 1, 0, 0);
		selecaoDao.CreateSelecao(selecao2);
		Selecao selecao3= new Selecao(3, "SENEGAL",jogadores3, tecnico3,1, 0, 0);
		selecaoDao.CreateSelecao(selecao3);
		Selecao selecao4= new Selecao(4, "CATAR", jogadores4, tecnico4, 1, 0, 0);
		selecaoDao.CreateSelecao(selecao4);
		
		Selecao selecao5= new Selecao(5, "INGLATERRA", jogadores5,tecnico5, 2, 0, 0);
		selecaoDao.CreateSelecao(selecao5);
		Selecao selecao6= new Selecao(6, "IRA", jogadores6,tecnico6, 2, 0, 0);
		selecaoDao.CreateSelecao(selecao6);
		Selecao selecao7= new Selecao(7, "ESTADOS UNIDOS", jogadores7, tecnico7, 2, 0, 0);
		selecaoDao.CreateSelecao(selecao7);
		Selecao selecao8= new Selecao(8, "GALES", jogadores8, tecnico8,  2, 0, 0);
		selecaoDao.CreateSelecao(selecao8);
		
		Selecao selecao9= new Selecao(9, "POLONIA", jogadores9, tecnico9,  3, 0, 0);
		selecaoDao.CreateSelecao(selecao9);
		Selecao selecao10= new Selecao(10, "ARGENTINA", jogadores10, tecnico10,  3, 0, 0);
		selecaoDao.CreateSelecao(selecao10);
		Selecao selecao11= new Selecao(11, "ARABIA SAUDITA", jogadores11, tecnico11, 3, 0, 0);
		selecaoDao.CreateSelecao(selecao11);
		Selecao selecao12= new Selecao(12, "MEXICO", jogadores12, tecnico12, 3, 0, 0);
		selecaoDao.CreateSelecao(selecao12);
		
		Selecao selecao13= new Selecao(13, "FRANÇA", jogadores13,tecnico13, 4, 0, 0);
		selecaoDao.CreateSelecao(selecao13);
		Selecao selecao14= new Selecao(14, "DINAMARCA",jogadores14,tecnico14, 4, 0, 0);
		selecaoDao.CreateSelecao(selecao14);
		Selecao selecao15= new Selecao(15, "TUNISIA", jogadores15, tecnico15,  4, 0, 0);
		selecaoDao.CreateSelecao(selecao15);
		Selecao selecao16= new Selecao(16, "AUSTRALIA",jogadores16, tecnico16, 4, 0, 0);
		selecaoDao.CreateSelecao(selecao16);
		
		Selecao selecao17= new Selecao(17, "ESPANHA", jogadores17, tecnico17,  5, 0, 0);
		selecaoDao.CreateSelecao(selecao17);
		Selecao selecao18= new Selecao(18, "JAPÃO", jogadores18, tecnico18, 5, 0, 0);
		selecaoDao.CreateSelecao(selecao18);
		Selecao selecao19= new Selecao(19, "COSTA RICA", jogadores19, tecnico19, 5, 0, 0);
		selecaoDao.CreateSelecao(selecao19);
		Selecao selecao20= new Selecao(20, "ALEMANHA", jogadores20, tecnico20, 5, 0, 0);
		selecaoDao.CreateSelecao(selecao20);
		
		Selecao selecao21= new Selecao(21, "CROACIA", jogadores21, tecnico21,  6, 0, 0);
		selecaoDao.CreateSelecao(selecao21);
		Selecao selecao22= new Selecao(22, "MARROCOS",jogadores22, tecnico22, 6, 0, 0);
		selecaoDao.CreateSelecao(selecao22);
		Selecao selecao23= new Selecao(23, "BELGICA", jogadores23, tecnico23,  6, 0, 0);
		selecaoDao.CreateSelecao(selecao23);
		Selecao selecao24= new Selecao(24, "CANADA", jogadores24, tecnico24, 6, 0, 0);
		selecaoDao.CreateSelecao(selecao24);
		
		Selecao selecao25= new Selecao(25, "BRASIL", jogadores25,tecnico25,  7, 0, 0);
		selecaoDao.CreateSelecao(selecao25);
		Selecao selecao26= new Selecao(26, "SUIÇA", jogadores26, tecnico26,  7, 0, 0);
		selecaoDao.CreateSelecao(selecao26);
		Selecao selecao27= new Selecao(27, "CAMARÕES", jogadores27, tecnico27, 7, 0, 0);
		selecaoDao.CreateSelecao(selecao27);
		Selecao selecao28= new Selecao(28, "SÉRVIA", jogadores28, tecnico28,  7, 0, 0);
		selecaoDao.CreateSelecao(selecao28);
		
		Selecao selecao29= new Selecao(29, "URUGUAI", jogadores29,tecnico29,  8, 0, 0);
		selecaoDao.CreateSelecao(selecao29);
		Selecao selecao30= new Selecao(30, "PORTUGAL", jogadores30, tecnico30,  8, 0, 0);
		selecaoDao.CreateSelecao(selecao30);
		Selecao selecao31= new Selecao(31, "COREIA DO SUL", jogadores31, tecnico31,8, 0, 0);
		selecaoDao.CreateSelecao(selecao31);
		Selecao selecao32= new Selecao(32, "GANA", jogadores32, tecnico32, 8, 0, 0);
		selecaoDao.CreateSelecao(selecao32);
		
		
		// Guardando ids da selecoes pra criar os grupos
		ArrayList<Integer>selecoes1 = new ArrayList<>();
		ArrayList<Integer>selecoes2 = new ArrayList<>(); 
		ArrayList<Integer>selecoes3 = new ArrayList<>(); 
		ArrayList<Integer>selecoes4 = new ArrayList<>(); 
		ArrayList<Integer>selecoes5 = new ArrayList<>(); 
		ArrayList<Integer>selecoes6 = new ArrayList<>(); 
		ArrayList<Integer>selecoes7 = new ArrayList<>(); 
		ArrayList<Integer>selecoes8 = new ArrayList<>(); 
		
		for(int i=1;i<5;i++) {
			selecoes1.add(i);}
		
		for(int i=5;i<9;i++) {
			selecoes2.add(i);}
		
		for(int i=9;i<13;i++) {
			selecoes3.add(i);}
		
		
		for(int i=13;i<17;i++) {
			selecoes4.add(i);}
		
		for(int i=17;i<21;i++) {
			selecoes5.add(i);}
		
		for(int i=21;i<25;i++) {
			selecoes6.add(i);}
		
		for(int i=25;i<29;i++) {
			selecoes7.add(i);}
		
		for(int i=29;i<33;i++) {
			selecoes8.add(i);}
		
		int z = 0;
		int a= 1;
		for(int i =1; i<353;i++) {
			if(z==11) {	
				a++;
				z=0;}
			Jogador jogador = new Jogador(i, "TESTE", "Atacante", 0, 0, 0, a);
			jogadorDao.Create(jogador);
			z++;}
		
		for(int i=1; i<33; i++){
			Tecnico Tecnico = new Tecnico(i, "TEC", i);
			tecnicoDao.CreateTec(Tecnico);}
		
		
		Grupo grupoA = new Grupo(1, "A", selecoes1);
		grupoDao.CreateGrup(grupoA);
		
		Grupo grupoB = new Grupo(2, "B", selecoes2);
		grupoDao.CreateGrup(grupoB);
		
		Grupo grupoC = new Grupo(3, "C", selecoes3);
		grupoDao.CreateGrup(grupoC);
		
		Grupo grupoD = new Grupo(4, "D", selecoes4);
		grupoDao.CreateGrup(grupoD);
		
		Grupo grupoE = new Grupo(5, "E", selecoes5);
		grupoDao.CreateGrup(grupoE);
		
		Grupo grupoF = new Grupo(6, "F", selecoes6);
		grupoDao.CreateGrup(grupoF);
		
		Grupo grupoG = new Grupo(7, "G", selecoes7);
		grupoDao.CreateGrup(grupoG);
		
		Grupo grupoH = new Grupo(8, "H", selecoes8);
		grupoDao.CreateGrup(grupoH);
		
		Scanner ler = new Scanner(System.in);
		CriarPartidas(ler, 1);
		
		
		
	}
	

	
	
	
	
}
