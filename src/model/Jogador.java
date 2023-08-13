package model;
/** Classe responsavel pela instancia do objeto jogador
 * 
 * @author Weslei Silva Santos
 *
 */
public class Jogador {

	private int codJog; //Id (Codigo) do Jogador
	private String nome; // Nome do Jogador
	private String posicao; // Posicao do jogador
	private int cartVe; // Quantidade de cartões Vermelhos
	private int cartA; // Quantidade de cartoes Amarelos
	private int gols; // Quantidade de gols marcados
	private int IdSelecao; // Id da selecao que o jogador esta
		

	
	public Jogador(int codJog, String nome, String posicao, int cartVe, int cartA, int gols, int idSelecao) {
		super();
		this.codJog = codJog;
		this.nome = nome;
		this.posicao = posicao;
		this.cartVe = cartVe;
		this.cartA = cartA;
		this.gols = gols;
		IdSelecao = idSelecao;
	}
	
	public int getIdSelecao() {
		return IdSelecao;
	}
	public void setIdSelecao(int idSelecao) {
		IdSelecao = idSelecao;
	}
	public int getCodJog() {
		return codJog;
	}
	public void setCodJog(int codJog) {
		this.codJog = codJog;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public int getCartVe() {
		return cartVe;
	}
	public void setCartVe(int cartVe) {
		this.cartVe = cartVe;
	}
	public int getCartA() {
		return cartA;
	}
	public void setCartA(int cartA) {
		this.cartA = cartA;
	}
	public int getGols() {
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}
	
	

}
