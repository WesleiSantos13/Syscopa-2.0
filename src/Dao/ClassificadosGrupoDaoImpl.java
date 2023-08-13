package Dao;

import java.util.ArrayList;
import java.util.List;

import model.ClassificadosGrupo;


public class ClassificadosGrupoDaoImpl implements  ClassificadosGrupoDao{
	private ArrayList<ClassificadosGrupo> rankings = new ArrayList<ClassificadosGrupo>();
	
	@Override
	public void CreateClassGrupo(ClassificadosGrupo ranking) {
		rankings.add(ranking);
		
	}

	@Override
	public void DeleteClassGrupo(int id) {
		for (int i = 0; i < rankings.size(); i++) {
			// Se achar o id na lista
			if(id == rankings.get(i).getId()) {
				rankings.remove(i);
			}}
		
	}

	@Override
	public List<ClassificadosGrupo> ListClassGrupo() {
		return rankings;
	}

}
