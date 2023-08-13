package model;

import java.util.ArrayList;
/** Classe responsavel pela instancia do objeto grupo
 * 
 * @author Weslei Silva Santos
 *
 */
public class Grupo {
	
	private int id; //Id do grupo
	private String letraGrupo; // Nome/Letra do grupo, ex:A,B...
	private  ArrayList<Integer>selecoes = new ArrayList<>(); //Lista contendo o id das selecoes
	
	
	
	public Grupo(int id, String letraGrupo, ArrayList<Integer> selecoes) {
		super();
		this.id = id;
		this.letraGrupo = letraGrupo;
		this.selecoes = selecoes;
	}
	
	
	public ArrayList<Integer> getSelecoes() {
		return selecoes;
	}
	public void setSelecoes(ArrayList<Integer> selecoes) {
		this.selecoes = selecoes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLetraGrupo() {
		return letraGrupo;
	}
	public void setLetraGrupo(String letraGrupo) {
		this.letraGrupo = letraGrupo;
	}



}
