package Dao;

import java.util.List;

import model.Selecao; 
/** Interface responsavel pelo CRUD da selecao
 * 
 * @author Weslei Silva Santos
 *
 */
public interface SelecaoDao {
	
	public void CreateSelecao(Selecao s1);
	public void UpdateSelecao(Selecao s1, int id);
	public void DeleteSelecao(int id);
	public List<Selecao> ListSelecao();
	public  List<Integer> SearchSelec(String nome);
}
