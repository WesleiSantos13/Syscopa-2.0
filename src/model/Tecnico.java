package model;
/** Classe responsavel pela instancia do objeto Tecnico
 * 
 * @author Weslei Silva Santos
 *
 */
public class Tecnico {
	
	private int id; // Id do tecnico
	private String nome; // Nome do tecnico
	private int idSelecao; // Id da selecao que o tecnico esta
	
	
	public Tecnico(int id, String nome, int idSelecao) {
		super();
		this.id = id;
		this.nome = nome;
		this.idSelecao = idSelecao;
	}
	public int getId() {
		return id;
	}
	
	public int getIdSelecao() {
		return idSelecao;
	}
	public void setIdSelecao(int idSelecao) {
		this.idSelecao = idSelecao;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
