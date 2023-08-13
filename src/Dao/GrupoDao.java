package Dao;

import java.util.List;

import model.Grupo;

/** Interface responsavel pelo CRUD da fase de grupos
 * 
 * @author Weslei Silva Santos
 *
 */
public interface GrupoDao {

		public void CreateGrup(Grupo grupo);
		public void UpdateGrup(Grupo grupo, int id);
		public void DeleteGrup(int id);
		public List<Grupo> ListGrup();
		
}
