package Dao;

import java.util.ArrayList; 
import java.util.List;
import model.Jogador;

/**  Classe responsavel pelo gerenciamento de Jogadores
 * 
 * @author Weslei Silva Santos
 *
 */
public class JogadorDaoImpl implements JogadorDao {
	/**Lista de jogadores
	 */
	private ArrayList<Jogador>jogadores = new ArrayList<Jogador>();
	
	
	  
	
	

	@Override
	/** Adiciona um jogador na lista de jogadores
	 * 
	 * @param j1 Objeto do tipo jogador a ser adicionado
	 */
	public void Create(Jogador j1) {
		jogadores.add(j1);
		
	}
	
	

	@Override
	/** Atualiza um jogador na lista, a partir do id e do objeto passado como parametro.
	 * 
	 * @param j1   Novos dados que irao substituir os do jogador.
	 * @param id   Id do jogador a ser atualizado
	 */
	public void UpdateJog(Jogador j1, int id) {
		int idJogador;
		for (int i = 0; i <jogadores.size(); i++) {
			idJogador = jogadores.get(i).getCodJog();
			if (idJogador == id) {
				jogadores.get(i).setNome(j1.getNome());
				jogadores.get(i).setPosicao(j1.getPosicao());
				jogadores.get(i).setCartVe(j1.getCartVe());
				jogadores.get(i).setCartA(j1.getCartA());
				jogadores.get(i).setGols(j1.getGols());}}
		
	}

	@Override
	/** Deleta um jogador da lista, a partir do id passado como parametro.
	 * Se o id passado nao estiver na lista, nada acontece.
	 * 
	 * @param id  Id do jogador a ser deletado
	 */
	public void DeleteJog(int id) {
		for (int i = 0; i < jogadores.size(); i++) {
			// Se achar o id na lista
			if(id == jogadores.get(i).getCodJog()) {
				jogadores.remove(i);
				
			}
		}
		
	}

	@Override
	/** Devolve a lista de jogadores, para listagem e carregamento de dados
	 * 
	 * @return  A lista de jogadores
	 */
	public List<Jogador> ListarJog() {
		return jogadores;
	}



	@Override
	/** Metodo responsavel pela pesquisa de jogadores,
	 * a partir do nome passado por parametro,
	 * 
	 * @param nome Nome do jogador
	 * @return a lista com os ids dos jogadores pesquisados (caso existam)
	 * 
	 */
	public List<Integer> SearchJog(String nome) {
		//Lista com os ids dos jogadores
		ArrayList<Integer>Ids = new ArrayList<>(); 
		for (Jogador jog : jogadores) {
			String nameJog= jog.getNome();
			if(nome.length()<=nameJog.length()) {
				//Transforma "nameJog" para o mesmo tamanho do nome passado por parametro
				String compara= (String) nameJog.subSequence(0, nome.length());
				// Comparando os dois nomes
				if(compara.equals(nome)) {
					Ids.add(jog.getCodJog());
					}}}
		return Ids;}
	

}
