package Dao;

import java.util.List;

import model.ClassificadosGrupo;


public interface ClassificadosGrupoDao {
	public void CreateClassGrupo(ClassificadosGrupo ranking);
	public void DeleteClassGrupo(int id);
	public List<ClassificadosGrupo> ListClassGrupo();
}
