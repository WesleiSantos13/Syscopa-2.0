package model;

public class ClassificadosGrupo {

	int id;
	int idClassificado1;
	int idClassificado2;
	
	public ClassificadosGrupo(int id, int idClassificado1, int idClassificado2) {
		super();
		this.id = id;
		this.idClassificado1 = idClassificado1;
		this.idClassificado2 = idClassificado2;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdClassificado1() {
		return idClassificado1;
	}
	public void setIdClassificado1(int idClassificado1) {
		this.idClassificado1 = idClassificado1;
	}
	public int getIdClassificado2() {
		return idClassificado2;
	}
	public void setIdClassificado2(int idClassificado2) {
		this.idClassificado2 = idClassificado2;
	}
	
	
	
	
}
