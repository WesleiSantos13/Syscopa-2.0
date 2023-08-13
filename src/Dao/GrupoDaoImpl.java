package Dao;


import java.util.ArrayList; 
import java.util.List;
import model.Grupo;
/** Classe responsavel pelo gerenciamento de grupos
 * 
 * @author Weslei Silva Santos
 *
 */
public class GrupoDaoImpl implements GrupoDao{
	/**Lista de grupos
	 */
	private ArrayList<Grupo>grupos = new ArrayList<Grupo>();
	
	
	
	
	/** Adiciona um grupo na lista
	 * 
	 * @param grupo Objeto do tipo grupo a ser adicionado
	 */
	@Override
	public void CreateGrup(Grupo grupo) {
		grupos.add(grupo);
		
	}

	
	/** Atualiza um grupo na lista, a partir do id e do objeto passado como parametro.
	 * 
	 * @param grupo   Novos dados que irao substituir os do grupo.
	 * @param id   Id do grupo a ser atualizado
	 */
	@Override
	public void UpdateGrup(Grupo grupo, int id) {
		int idGrupo;
		for (int i = 0; i <grupos.size(); i++) {
			idGrupo = grupos.get(i).getId();
			if (idGrupo == id) {
				grupos.get(i).setSelecoes(grupo.getSelecoes());
				grupos.get(i).setLetraGrupo(grupo.getLetraGrupo());
				}}

		
	}

	@Override
	/** Deleta  grupo da lista, a partir do id passado como parametro.
	 * Se o id passado nao estiver na lista, nada acontece.
	 * 
	 * @param id  Id do grupo a ser deletado
	 */
	public void DeleteGrup(int id) {
		for (int i = 0; i < grupos.size(); i++) {
			// Se achar o id na lista
			if(id == grupos.get(i).getId()) {
				grupos.remove(i);
			}}}
	

	/** Devolve a lista de grupos, para listagem e carregamento de dados
	 * 
	 * @return  A lista de grupos
	 */
	@Override
	public List<Grupo> ListGrup() {
		return grupos;
	}





}
