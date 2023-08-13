package model;

/** Classe responsavel pela instancia do objeto arbitro
 * 
 * @author Weslei Silva Santos
 *
 */
public class Arbitro {

	private int Id; // Id do arbitro
	private String nome; // Nome do arbitro
	private int IdPartida;//Id da partida 

	public Arbitro(int id, String nome, int idPartida) {
		super();
		Id = id;
		this.nome = nome;
		IdPartida = idPartida;
	}
	
	
	
	public int getIdPartida() {
		return IdPartida;
	}

	public void setIdPartida(int idPartida) {
		IdPartida = idPartida;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
