package Dao;

import java.util.List;

import model.Tecnico;
/** Interface responsavel pelo CRUD do tecnico
 * 
 * @author Weslei Silva Santos
 *
 */
public interface TecnicoDao {
	
	public void CreateTec(Tecnico t1);
	public void UpdateTec(Tecnico t1, int id);
	public void DeleteTec(int id);
	public List<Tecnico> ListTec();
	public List<Integer> SearchTec(String nome);
}
