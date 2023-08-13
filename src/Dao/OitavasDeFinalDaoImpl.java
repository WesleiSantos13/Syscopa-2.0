package Dao;

import java.util.ArrayList;
import java.util.List;
import model.OitavasDeFinal;

/** Classe responsavel pelo gerenciamento de partidas das oitavas de final
 * 
 * @author Weslei Silva Santos
 *
 */
public class OitavasDeFinalDaoImpl implements  OitavasDeFinalDao {
	/**Lista de partidas das oitavas de final
	 */
	private ArrayList<OitavasDeFinal> partidasOitavas = new ArrayList<OitavasDeFinal>();
	
	
	@Override
	/** Adiciona uma partida na lista de partidas
	 * 
	 * @param partida Objeto do tipo partida a ser adicionado
	 */
	public void CreateOitavFinal(OitavasDeFinal partida) {
		partidasOitavas.add(partida);
		
	}

	
	@Override
	/** Atualiza uma partida na lista, a partir do id e do objeto passado como parametro.
	 * 
	 * @param partida   Novos dados que irao substituir os da partida.
	 * @param id   Id da partida a ser atualizada
	 */
	public void UpdateOitavFinal(OitavasDeFinal partida, int id) {
		int idPartida;
		for (int i = 0; i <partidasOitavas.size(); i++) {
			idPartida = partidasOitavas.get(i).getId();
			if (idPartida == id) {
				partidasOitavas.get(i).setData(partida.getData());
				partidasOitavas.get(i).setHorario(partida.getHorario());
				partidasOitavas.get(i).setLocal(partida.getLocal());
				partidasOitavas.get(i).setNomeSelecao1(partida.getNomeSelecao1());
				partidasOitavas.get(i).setNomeSelecao2(partida.getNomeSelecao2());
				partidasOitavas.get(i).setSelecao1(partida.getSelecao1());
				partidasOitavas.get(i).setSelecao2(partida.getSelecao2());
				partidasOitavas.get(i).setArbitro(partida.getArbitro());
				partidasOitavas.get(i).setGolsSelecao1(partida.getGolsSelecao1());
				partidasOitavas.get(i).setGolsSelecao2(partida.getGolsSelecao2());
				partidasOitavas.get(i).setNomeArb(partida.getNomeArb());
				partidasOitavas.get(i).setCartaoVe(partida.getCartaoVe());
				partidasOitavas.get(i).setCartaoA(partida.getCartaoA());
				partidasOitavas.get(i).setCartaoVe2(partida.getCartaoVe2());
				partidasOitavas.get(i).setCartaoA2(partida.getCartaoA2());}}
		
	}

	@Override
	/** Deleta uma partida da lista, a partir do id passado como parametro.
	 * Se o id passado nao estiver na lista, nada acontece.
	 * 
	 * @param id  Id da partida a ser deletada
	 */
	public void DeleteOitavFinal(int id) {
		for (int i = 0; i < partidasOitavas.size(); i++) {
			// Se achar o id na lista
			if(id == partidasOitavas.get(i).getId()) {
				partidasOitavas.remove(i);
				
			}
		}
		
	}

	@Override
	/** Devolve a lista de partidas, para listagem e carregamento de dados
	 * 
	 * @return  A lista de partidas
	 */
	public List<OitavasDeFinal> ListOitavFinal() {
		return partidasOitavas;
	}

	
	@Override
	/** Metodo responsavel pela pesquisa de partidas,
	 * a partir da data passada por parametro
	 * 
	 * @param data Data a ser pesquisada dentro da lista
	 * @return a lista com os ids das partidas pesquisadas (caso existam)
	 */
	public List<Integer> SearchOitavFinal(String data) {
		//Lista com os ids das partidas das oitavas
				ArrayList<Integer>Ids = new ArrayList<>(); 
				for (OitavasDeFinal partida : partidasOitavas) {
					String DataPartida= partida.getData();
					if(data.length()<=DataPartida.length()) {
						//Transforma "DataPartida" para o mesmo tamanho da data passada por parametro
						String compara= (String) DataPartida.subSequence(0, data.length());
						//Comparando as duas datas
						if(compara.equals(data)) {
							Ids.add(partida.getId());
						}}}
				return Ids;
	}

}
