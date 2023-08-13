package model;

import java.util.ArrayList;
/** Classe responsavel pela instancia do objeto selecao
 * 
 * @author Weslei Silva Santos
 *
 */
public class Selecao {


	private int id; // Id da selecao
	private String nome; // Nome da selecao
	private ArrayList<Integer>time = new ArrayList<>(); // Lista de jogadores: somente id
	private ArrayList<Integer>tecnico= new ArrayList<>(); // Lista contendo o tecnico: somente id
	private int IdGrupo; // Id do grupo
	private int pontuacao; //Pontuacao da selecao da fase de grupos
	private int SaldoGols; // Saldo de gols
	
	
	
	public Selecao(int id, String nome, ArrayList<Integer> time, ArrayList<Integer> tecnico, int idGrupo, int pontuacao,
			int saldoGols) {
		super();
		this.id = id;
		this.nome = nome;
		this.time = time;
		this.tecnico = tecnico;
		IdGrupo = idGrupo;
		this.pontuacao = pontuacao;
		SaldoGols = saldoGols;
	}

	public int getSaldoGols() {
		return SaldoGols;
	}

	public void setSaldoGols(int saldoGols) {
		SaldoGols = saldoGols;
	}

	public int getIdGrupo() {
		return IdGrupo;
	}
	
	public void setIdGrupo(int idGrupo) {
		IdGrupo = idGrupo;
	}
	
	

	public ArrayList<Integer> getTime() {
		return time;
	}
	
	public void setTime(ArrayList<Integer> time) {
		this.time = time;
	}
	
	public ArrayList<Integer> getTecnico() {
		return tecnico;
	}
	
	public void setTecnico(ArrayList<Integer> tecnico) {
		this.tecnico = tecnico;
	}
	
	public int getId() {
		return id;
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

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	
}
