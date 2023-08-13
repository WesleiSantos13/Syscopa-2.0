package model;
import java.util.List;

/** Classe responsavel pelas funcoes de verificacao e de buscar posicoes
 * 
 * @author Weslei Silva Santos
 *
 */
public class Funcoes {

	/* Metodo responsavel por verificar se a selecao esta na lista
	 * 
	 * @param id id da selecao a ser verificada
	 * @param selecoes lista de selecoes
	 * @return true ou false
	 */
	public static Boolean verificarSelecao(int id, List<Selecao> selecoes) {
		Boolean resposta= false;
		for (Selecao selecao : selecoes) {
			if(id == selecao.getId()) {
				resposta= true;
				return resposta;}
			}
		return resposta;}
	
	
	
	/** Metodo responsavel por verificar se o jogador esta na selecao passada por parametro
	 * 
	 * @param id Id do jogador
	 * @param selecao Selecao 
	 * @return True ou false
	 */
	public static Boolean verificaJogadorSelecao(int id, Selecao selecao) {
		Boolean resposta= false;
		for(int k=0;k<selecao.getTime().size();k++) {
			if(id == selecao.getTime().get(k)) {
				resposta= true;
				return resposta;}	
		}
		return resposta;}

	
	
	/** Metodo responsavel por verificar se o jogador esta na lista
	 * 
	 * @param id  id do jogador a ser verificado
	 * @param jogadores Lista de jogadores
	 * @return true ou false
	 */
	public static Boolean verificarJogador(int id, List<Jogador> jogadores) {
		Boolean resposta= false;
		for (Jogador jogador : jogadores) {
			if(id == jogador.getCodJog()) {
				resposta= true;
				return resposta;}
			}
		return resposta;}

	
	
	
	
	/** Metodo responsavel por verificar se o tecnico esta na lista
	 * 
	 * @param id id do tecnico a ser verificado
	 * @param tecnicos Lista de tecnicos
	 * @return true ou false
	 */
	public static Boolean verificarTecnico(int id, List<Tecnico> tecnicos) {
		Boolean resposta= false;
		for (Tecnico tecnico : tecnicos) {
			if(id == tecnico.getId()) {
				resposta= true;
				return resposta;}
			}
		return resposta;}
	
	
	
	/** Metodo responsavel por verificar se o arbitro esta na lista
	 * 
	 * @param id id do arbitro a ser verificado
	 * @param arbitros Lista de arbitros
	 * @return true ou false
	 */
	public static Boolean verificarArbitro(int id, List<Arbitro> arbitros) {
		Boolean resposta= false;
		for (Arbitro arbitro : arbitros) {
			if(id == arbitro.getId()) {
				resposta= true;
				return resposta;}
			}
		return resposta;}
	
	
	
	/** Metodo responsavel por verificar se o grupo esta na lista
	 * 
	 * @param id id do grupo a ser verifficado
	 * @param grupos Lista de grupos
	 * @return true ou false
	 */
	public static Boolean verificarGrupo(int id, List<Grupo> grupos) {
		Boolean resposta= false;
		for (Grupo grupo : grupos) {
			if(id == grupo.getId()) {
				resposta= true;
				return resposta;}
			}
		return resposta;}
	
	
	
	/** Metodo responsavel por verificar se a partida esta na lista
	 * 
	 * @param id id da partida a ser verificada
	 * @param partidas Lista de partidas
	 * @return true ou false
	 */
	public static Boolean verificarPartida(int id, List<Partida> partidas) {
		Boolean resposta= false;
		for (Partida partida: partidas) {
			if(id == partida.getId()) {
				resposta= true;
				return resposta;}
			}
		return resposta;}

	
	
	/** Metodo para veriicar se a selecao esta em partidas
	 * 
	 * @param id id da selecao a ser veriicada
	 * @param partidas lista de partidas
	 * @return true ou false
	 */
	public static Boolean verificarSelecaoPartida(int id, List<Partida> partidas) {
		Boolean resposta= false;
		for (Partida partida : partidas) {
			if(id == partida.getSelecao1() || id == partida.getSelecao2()) {
				resposta= true;
				return resposta;}
			}
		return resposta;}

	
	
	/** Metodo para veriicar se a grupo tem partidas marcadas
	 * 
	 * @param id id do grupo a ser verificado
	 * @param partidas Lista de partidas
	 * @return true ou false
	 */
	public static Boolean verificarGrupoPartida(int id, List<Partida> partidas) {
		Boolean resposta= false;
		for (Partida partida: partidas) {
			if(id == partida.getIdGrupo()) {
				resposta= true;
				return resposta;}
			}
		return resposta;}
	
	
	
	
	
	
	
	/** Metodo para encontrar a posicao da seleçao na lista de selecoes, a partir do id passado por parametro
	 * 
	 * @param selecoes Lista de selecoes
	 * @param id Id da seleção a ser buscada
	 * @return O index da selecao na lista de selecoes ou -1
	 */
	public static int BuscaPosicao(List<Selecao> selecoes, int id) {
		int idSelecao, i;
		for (i=0; i <selecoes.size(); i++) {
			 idSelecao = selecoes.get(i).getId();
			if (idSelecao == id) {
				return i;}}
		return -1;}
	
	
	
	
	/** Metodo para encontrar a posicao do jogador na lista de jogadores, a partir do id passado por parametro
	 * 
	 * @param jogadores Lista de jogadores 
	 * @param id Id do jogador a ser buscado
	 * @return O index do jogador na lista de jogadores ou -1
	 */
	public static int BuscaPosicaoJog(List<Jogador> jogadores, int id) {
		int idJog, i;
		for ( i = 0; i <jogadores.size(); i++) {
			idJog = jogadores.get(i).getCodJog();
			if (idJog == id) {
				return i;}}
		return -1;}
	
	
	
	
	/**  Metodo para encontrar a posicao do tecnico na lista de tecnicos, a partir do id passado por parametro
	 * 
	 * @param tecnicos Lista de tecnicos
	 * @param id Id do tecnico a ser buscado
	 * @return O index do tecnico na lista de tecnicos ou -1
	 */
	public static int BuscaPosicaoTec(List<Tecnico> tecnicos, int id) {
		int idTec, i;
		for ( i = 0; i <tecnicos.size(); i++) {
			idTec = tecnicos.get(i).getId();
			if (idTec == id) {
				return i;}}
		return -1;}
	
	
	/**	 Metodo para encontrar a posicao do grupo na lista de grupos, a partir do id passado por parametro
	 * 
	 * @param grupos Lista de grupos
	 * @param id do grupo a ser buscado
	 * @return O index do grupo na lista de grupos ou -1
	 */
	public static int BuscaPosicaoGrp(List<Grupo> grupos, int id) {
		int idGrp, i;
		for ( i = 0; i <grupos.size(); i++) {
			idGrp = grupos.get(i).getId();
			if (idGrp == id) {
				return i;}}
		return -1;}
	
	
	
	/**  Metodo para encontrar a posicao da partida na lista de partidas, a partir do id passado por parametro
	 * 
	 * @param  Lista de partidas
	 * @param id da partida a ser buscada
	 * @return  O index da partida na lista de partidas ou -1
	 */
	public static int BuscaPosicaoPart(List<Partida> partidas, int id) {
		int idPart, i;
		for ( i = 0; i <partidas.size(); i++) {
			idPart = partidas.get(i).getId();
			if (idPart == id) {
				return i;}}
		return -1;}
	
	
	
	/** Metodo para encontrar a posicao do arbitro na lista de arbitros, a partir do id passado por parametro
	 * 
	 * @param arbitros Lista de arbitros
	 * @param id id do arbitro a ser buscado
	 * @return  O index do arbitro na lista de arbitros ou -1
	 */
	public static int BuscaPosicaoArb(List<Arbitro> arbitros, int id) {
		int idArb, i;
		for ( i = 0; i <arbitros.size(); i++) {
			idArb = arbitros.get(i).getId();
			if (idArb == id) {
				return i;}}
		return -1;}
	
	
}	
