package Dao;

import java.util.ArrayList; 
import java.util.List;
import model.Partida;

/** Classe responsavel pelo gerenciamento de partidas
 * 
 * @author Weslei Silva Santos
 *
 */
public class PartidaDaoImpl implements PartidaDao {
	/**Lista de partidas
	 */
	private static ArrayList<Partida>partidas = new ArrayList<Partida>();
	
	
	  

	/** Adiciona uma partida na lista de partidas
	 * 
	 * @param partida Objeto do tipo partida a ser adicionado
	 */
	@Override
	public void CreatePart(Partida partida) {
		partidas.add(partida);
		
	}
	
	

	@Override
	/** Atualiza uma partida na lista, a partir do id e do objeto passado como parametro.
	 * 
	 * @param partida   Novos dados que irao substituir os da partida.
	 * @param id   Id da partida a ser atualizada
	 */
	public void UpdatePart(Partida partida, int id) {
		int idPartida;
		for (int i = 0; i <partidas.size(); i++) {
			idPartida = partidas.get(i).getId();
			if (idPartida == id) {
				partidas.get(i).setData(partida.getData());
				partidas.get(i).setHorario(partida.getHorario());
				partidas.get(i).setLocal(partida.getLocal());
				partidas.get(i).setNomeSelecao1(partida.getNomeSelecao1());
				partidas.get(i).setNomeSelecao2(partida.getNomeSelecao2());
				partidas.get(i).setSelecao1(partida.getSelecao1());
				partidas.get(i).setSelecao2(partida.getSelecao2());
				partidas.get(i).setArbitro(partida.getArbitro());
				partidas.get(i).setGolsSelecao1(partida.getGolsSelecao1());
				partidas.get(i).setGolsSelecao2(partida.getGolsSelecao2());
				partidas.get(i).setNomeArb(partida.getNomeArb());
				partidas.get(i).setCartaoVe(partida.getCartaoVe());
				partidas.get(i).setCartaoA(partida.getCartaoA());
				partidas.get(i).setCartaoVe2(partida.getCartaoVe2());
				partidas.get(i).setCartaoA2(partida.getCartaoA2());
				
			}}
		
	}

	@Override
	/** Deleta uma partida da lista, a partir do id passado como parametro.
	 * Se o id passado nao estiver na lista, nada acontece.
	 * 
	 * @param id  Id da partida a ser deletada
	 */
	public void DeletePart(int id) {
		for (int i = 0; i < partidas.size(); i++) {
			// Se achar o id na lista
			if(id == partidas.get(i).getId()) {
				partidas.remove(i);
				
			}
		}
		
	}

	@Override
	/** Devolve a lista de partidas, para listagem e carregamento de dados
	 * 
	 * @return  A lista de partidas
	 */
	public List<Partida> ListPart() {
		return partidas;
	}



	@Override
	/** Metodo responsavel pela pesquisa de partidas,
	 * a partir da data passada por parametro
	 * 
	 * @param data Data a ser pesquisada dentro da lista
	 * @return a lista com os ids das partidas pesquisadas (caso existam)
	 */
	public List<Integer> SearchPart(String data) {
		//Lista com os ids das partidas
		ArrayList<Integer>Ids = new ArrayList<>(); 
		for (Partida partida : partidas) {
			String DataPartida= partida.getData();
			if(data.length()<=DataPartida.length()) {
				//Transforma "DataPartida" para o mesmo tamanho da data passada por parametro
				String compara= (String) DataPartida.subSequence(0, data.length());
				//Comparando as duas datas
				if(compara.equals(data)) {
					Ids.add(partida.getId());
				}}}
		return Ids;}


}
