package Dao;

import java.util.ArrayList;   
import java.util.List;
import model.Arbitro;

/** Classe responsavel pelo gerenciamento de arbitros
 * 
 * @author Weslei Silva Santos
 *
 */
public class ArbitroDaoImpl implements ArbitroDao {
	
	/*
	 Lista de arbitros
	 */
	private ArrayList<Arbitro>arbitros = new ArrayList<Arbitro>(); 

	@Override
	/** Adiciona um arbitro na lista de arbitros
	 * 
	 * @param a1 Objeto do tipo arbitro a ser adicionado
	 */
	public void Create(Arbitro a1) {
		arbitros.add(a1);
		
	}

	@Override

	/** Atualiza um arbitro na lista, a partir do id e do objeto passado por parametro.
	 * 
	 * @param a1   Novos dados que irao substituir os do arbitro.
	 * @param id   Id do arbitro a ser atualizado
	 */
	public void UpdateArb(Arbitro a1, int id) {
		int idArbitro;
		for (int i = 0; i <arbitros.size(); i++) {
			idArbitro = arbitros.get(i).getId();
			if (idArbitro == id) {
				arbitros.get(i).setNome(a1.getNome());
				}}}
    
	
	@Override
	/** Deleta um arbitro da lista, a partir do id passado por parametro.
	 * Se o id passado não estiver na lista, nada acontece.
	 * 
	 * @param id  Id do arbitro a ser deletado
	 */
	public void DeleteArb(int id) {
		for (int i = 0; i < arbitros.size(); i++) {
			// Se achar o id na lista
			if(id == arbitros.get(i).getId()) {
				arbitros.remove(i);
				}}
		
	}

	@Override
	 /** Devolve a lista de arbitros, para listagem e carregamento de dados
     * 
     * @return A lista de arbitros
     */
	public List<Arbitro> ListArb() {
		return arbitros;
	}


	@Override
	/** Metodo responsavel pela pesquisa de arbitros,
	 * a partir do nome passado por parametro
	 * 
	 * @param nome nome do arbitro
	 * @return a lista com os ids dos arbitros pesquisados (caso existam)
	 */
	public List<Integer> SearchArb(String nome) {
		//Lista com os ids dos arbitros
		ArrayList<Integer>Ids = new ArrayList<>(); 
		for (Arbitro arb : arbitros) {
			String nameArb= arb.getNome();
			if(nome.length()<=nameArb.length()) {
				//Transforma "nameArb" para o mesmo tamanho do nome passado por parametro
				String compara= (String) nameArb.subSequence(0, nome.length());
				// Comparando os dois nomes
				if(compara.equals(nome)) {
					Ids.add(arb.getId());	
				}}}
		return Ids;
		}
	





















}
			
		
		
	


