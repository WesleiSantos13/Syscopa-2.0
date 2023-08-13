/* Autor: Weslei Silva Santos   
  Componente Curricular: EXA863 - MI Programação
  Concluido em: 05/11/2022
  Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
  trecho de código de outro colega ou de outro autor, tais como provindos de livros e
  apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
  de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
  do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.*/



package Main;
  

import java.util.Scanner;    
import controller.Control;

/** Classe responsavel pela chamada dos metodos operacionais do Controller
 * 
 * @author Weslei Silva Santos
 *
 */
public class Principal {
    /**
     * Variaveis responsaveis pelo id
     */
	static int contSelecao = 1; 
	static int contTecnico = 1;
	static int contJogador = 1;
	static int contArbitro = 1;
	static int contGrupo = 1;
	static int contPartida = 1;
	static int contClassificados=1;
		
	//Programa Principal
	public static void main(String[] args) {
		Scanner ler= new Scanner(System.in);
		Control control = new Control();
		int resp = 0;
		
		resp = control.MenuPrincipal(ler);
		while(resp != 0){		
			
			//Acesso as selecoes
			if(resp==1) {
				int pergunta =  control.opcaoMenu(ler,"Seleção", "[0]  Inserir(Selecao/Jogador/Tecnico)");
				// Criar selecao
				if(pergunta==0) {
					contJogador=control.InsercaoSelecao(contTecnico,contSelecao, contJogador);
					contSelecao++;
					contTecnico++;}
				
				//Editar selecao
				if(pergunta==1) {
					control.EditarSelecao(ler);}
			
				//Listar selecoes
				if(pergunta==2) {					
					 control.ListarSelecao();}
				
				//Deletar selecao
				if(pergunta==3) {
					control.RemocaoSelecao(ler);}									
			resp = control.MenuPrincipal(ler);}
			
				
			
			// Acessos aos jogadores
			if(resp==2) {
				int pergunta = control.opcaoMenu(ler, "Jogador", "");
				// Editar Jogador
				if(pergunta==1) {
				control.EditarJogador(ler);}
								
				//Listar Jogadores
				if(pergunta==2) {
					control.ListarJogador();}				
				
				//Deletar Jogador
				if(pergunta==3) {	
					control.RemoverJogador(ler);}
				resp = control.MenuPrincipal(ler);}
			
			
			//Acesso aos tecnicos
			if(resp==3) {		
				int pergunta = control.opcaoMenu(ler, "Técnico", "");
				
				//Editar Tecnico
				if(pergunta==1) {
					control.EditarTecnico(ler);}
							
				//Listar Tecnico
				if(pergunta==2) {		
					control.ListarTecnico();}			
				
				//Deletar Tecnico
				if(pergunta==3){		
					control.RemoverTecnico(ler);}				
				resp = control.MenuPrincipal(ler);	}
			
			
			//Acesso aos arbitros
			if(resp==4) {
				int pergunta = control.opcaoMenu(ler, "Arbitro", "");
				
				//Editar Arbitro
				if(pergunta==1) {
					 control.EditarArbitro(ler);}		
				
				//Listar Arbitros
				if(pergunta==2) {
					control.ListarArbitros();}
		
				//Deletar Arbitro
				if(pergunta==3) {
					control.RemoverArbitro(ler);
				}
				resp = control.MenuPrincipal(ler);}
			
			
			//Fase de Grupos
			if(resp==5) {
				int pergunta=control.opcaoMenu2("grupo");
				
				//Criar Grupo
				if(pergunta==1) {
					contGrupo= control.CriarGrupo(ler,contGrupo);}								
				
				//Editar Grupo
				if(pergunta==2) {
					control.EditarGrupo(ler);}
	
				//Deletar grupo
				if(pergunta==3) {
					control.RemoverGrupo(ler);}				
				
				//Listar Grupos
				if(pergunta==4) { 
					control.ListarGrupos();}
				resp = control.MenuPrincipal(ler);
			}
			
			//Acesso a partidas
			if(resp==6) {
					int pergunta=control.opcaoMenu2("partida");
					
					//Criar partidas
					if(pergunta==1) {
						contPartida= control.CriarPartidas(ler, contPartida);}					
										
					//Editar/registrar dados da partida
					if(pergunta==2) {
						contArbitro=control.EditarPartida(ler,contArbitro);}
					
					//Excluir partida
					if(pergunta==3) { 
						control.RemoverPartida(ler);}
							
					//Listar partidas
					if(pergunta==4) {
						control.ListarPartidas();}
				
				resp = control.MenuPrincipal(ler);
			}
			
			
			//Pesquisa
			if(resp==7) {	
				int pergunta=control.opcaoMenu3();
				control.Pesquisa(pergunta);
				resp = control.MenuPrincipal(ler);
			}
			

			//Listar Todos os dados da selecao
			if(resp==8) {		
				control.ListagemTimes(ler);
				resp = control.MenuPrincipal(ler);}
			
			if(resp==9) {		
				control.FazerClassificacao(ler, contClassificados);
				resp = control.MenuPrincipal(ler);}
			
			if(resp==10) {		
				control.ListarSelecoesClassificadas();
				resp = control.MenuPrincipal(ler);}
			
			// Adicionar todos dados da copa
			if(resp==11) {		
				control.construir();
				resp = control.MenuPrincipal(ler);}
			
			//Encerrar Programa
			if(resp==0) {
				ler.close();}}}}
				
			