package model;

import java.util.List;
/** Classe responsavel pela instancia das partidas das oitavas de
 * 
 * @author Weslei Silva Santos
 *
 */
public class OitavasDeFinal {

	private int id; //id da partida
	private String data; // data da partida
	private String horario;// horario da partida
	private String local; // local da partida
	private String nomeSelecao1; // nome da selecao1
	private String nomeSelecao2;  // nome da selecao2
	private int selecao1;// selecao 1: somente id
	private int selecao2;// selecao 2: somente id
	private int arbitro;//arbitro: somente id
	private int golsSelecao1;// gols da selecao 1;
	private int golsSelecao2;// gols da selecao 2;
	private String nomeArb;// Nome do arbitro
	private int cartaoVe; //quantidade de cartoes vermelhos da selecao 1
	private int cartaoA; //quantidade de cartoes amarelos da selecao 1
	private int cartaoVe2; //quantidade de cartoes vermelhos da selecao 2
	private int cartaoA2; //quantidade de cartoes amarelos da selecao 2
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getNomeSelecao1() {
		return nomeSelecao1;
	}
	public void setNomeSelecao1(String nomeSelecao1) {
		this.nomeSelecao1 = nomeSelecao1;
	}
	public String getNomeSelecao2() {
		return nomeSelecao2;
	}
	public void setNomeSelecao2(String nomeSelecao2) {
		this.nomeSelecao2 = nomeSelecao2;
	}
	public int getSelecao1() {
		return selecao1;
	}
	public void setSelecao1(int selecao1) {
		this.selecao1 = selecao1;
	}
	public int getSelecao2() {
		return selecao2;
	}
	public void setSelecao2(int selecao2) {
		this.selecao2 = selecao2;
	}
	public int getArbitro() {
		return arbitro;
	}
	public void setArbitro(int arbitro) {
		this.arbitro = arbitro;
	}
	public int getGolsSelecao1() {
		return golsSelecao1;
	}
	public void setGolsSelecao1(int golsSelecao1) {
		this.golsSelecao1 = golsSelecao1;
	}
	public int getGolsSelecao2() {
		return golsSelecao2;
	}
	public void setGolsSelecao2(int golsSelecao2) {
		this.golsSelecao2 = golsSelecao2;
	}
	public String getNomeArb() {
		return nomeArb;
	}
	public void setNomeArb(String nomeArb) {
		this.nomeArb = nomeArb;
	}
	public int getCartaoVe() {
		return cartaoVe;
	}
	public void setCartaoVe(int cartaoVe) {
		this.cartaoVe = cartaoVe;
	}
	public int getCartaoA() {
		return cartaoA;
	}
	public void setCartaoA(int cartaoA) {
		this.cartaoA = cartaoA;
	}
	public int getCartaoVe2() {
		return cartaoVe2;
	}
	public void setCartaoVe2(int cartaoVe2) {
		this.cartaoVe2 = cartaoVe2;
	}
	public int getCartaoA2() {
		return cartaoA2;
	}
	public void setCartaoA2(int cartaoA2) {
		this.cartaoA2 = cartaoA2;
	}
	
	
	
	
	public OitavasDeFinal(int id, String data, String horario, String local, String nomeSelecao1, String nomeSelecao2,
			int selecao1, int selecao2, int arbitro, int golsSelecao1, int golsSelecao2, String nomeArb, int cartaoVe,
			int cartaoA, int cartaoVe2, int cartaoA2) {
		super();
		this.id = id;
		this.data = data;
		this.horario = horario;
		this.local = local;
		this.nomeSelecao1 = nomeSelecao1;
		this.nomeSelecao2 = nomeSelecao2;
		this.selecao1 = selecao1;
		this.selecao2 = selecao2;
		this.arbitro = arbitro;
		this.golsSelecao1 = golsSelecao1;
		this.golsSelecao2 = golsSelecao2;
		this.nomeArb = nomeArb;
		this.cartaoVe = cartaoVe;
		this.cartaoA = cartaoA;
		this.cartaoVe2 = cartaoVe2;
		this.cartaoA2 = cartaoA2;
	}
	
	
	

}
