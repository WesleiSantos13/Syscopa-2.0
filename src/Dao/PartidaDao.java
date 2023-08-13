package Dao;

import java.util.List;

import model.Partida;
/** Interface responsavel pelo CRUD da partida
 * 
 * @author Weslei Silva Santos
 *
 */
public interface PartidaDao {
	public void CreatePart(Partida partida);
	public void UpdatePart(Partida partida, int id);
	public void DeletePart(int id);
	public List<Partida> ListPart();
	public List<Integer> SearchPart(String nome);
}
