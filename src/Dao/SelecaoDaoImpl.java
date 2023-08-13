package Dao;
import java.util.ArrayList;     
import java.util.List; 
import model.Selecao;
/** Classe responsavel pelo gerenciamento de selecoes
 * 
 * @author Weslei Silva Santos
 *
 */
public class SelecaoDaoImpl implements SelecaoDao {
	/**
	 * Lista de selecoes
	 */
	private static ArrayList<Selecao> selecoes = new ArrayList<>();
		
	
	
	@Override
	/** Adiciona uma selecao na lista de selecoes
	 * 
	 * @param s1 Objeto do tipo selecao a ser adicionado
	 */
	public void CreateSelecao(Selecao s1)  {		
			selecoes.add(s1);
		
	}

	@Override
	/** Atualiza uma selecao na lista, a partir do id e do objeto passado como parametro.
	 * 
	 * @param s1 Novos dados que irao substituir os da selecao.
	 * @param id Id da selecao a ser atualizada
	 */
	public void UpdateSelecao(Selecao s1, int id) {
		int idSelecao;
		for (int i = 0; i <selecoes.size(); i++) {
			 idSelecao = selecoes.get(i).getId();
			if (idSelecao == id) {
				selecoes.get(i).setNome(s1.getNome());
				selecoes.get(i).setTime(s1.getTime());
				selecoes.get(i).setTecnico(s1.getTecnico());
				selecoes.get(i).setIdGrupo(s1.getIdGrupo());
				selecoes.get(i).setPontuacao(s1.getPontuacao());
				selecoes.get(i).setSaldoGols(s1.getSaldoGols());}}}

	
		
	@Override
	/** Deleta uma selecao da lista, a partir do id passado como parametro.
	 * Se o id passado nao estiver na lista, nada acontece. 
	 * 
	 * @param id Id da selecao a ser deletada
	 */
	public void DeleteSelecao(int id) {
		for (int i = 0; i < selecoes.size(); i++) {
			// Se achar o id na lista
			if(id == selecoes.get(i).getId()) {
				selecoes.remove(i);
				}}}
		
	

	@Override
	/** Devolve a lista de selecoes, para listagem e carregamento de dados
	 * 
	 *@return A lista de selecoes 
	 */
	public List<Selecao> ListSelecao() {
		return selecoes;
	}

	
	
	@Override
	/** Metodo responsavel pela pesquisa de selecoes,
	 * a partir do nome passado por parametro
	 * 
	 * @param nome nome a ser pesquisado dentro da lista
	 * @return a lista com os ids das selecoes pesquisadas (caso existam)
	 */
	public List<Integer> SearchSelec(String nome) {
		//Lista com os ids das selecoes
		ArrayList<Integer>Ids = new ArrayList<>(); 
		for (Selecao selec : selecoes) {
			String nameSelec= selec.getNome();
			if(nome.length()<=nameSelec.length()) {
				//Transforma "nameSelec" para o mesmo tamanho do nome passado por parametro
				String compara= (String) nameSelec.subSequence(0, nome.length());
				//Comparando os dois nomes
				if(compara.equals(nome)) {
					Ids.add(selec.getId());
					}}}
		return Ids;
		}

}
