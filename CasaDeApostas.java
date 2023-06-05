import java.sql.Connection;
import java.util.Scanner;

public class CasaDeApostas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FuncoesADM ADM = new FuncoesADM();
		FuncoesApostadores APO = new FuncoesApostadores();
		Connection con = ADM.conexao();
		//t.CadastrandoApostadores(con);
		//t.CadastrandoApostadores(con, 3, "Alan", "07256489756", "alanbruno.s@gmail.com", "988105240");
		//t.CadastrandoJogos(con, 3, "São Paulo", "Flamengo", "Flamengo");
		//t.CadastrandoModalidades(con, 4, "Futebol", "Campeonato de Futebol Masculino", 10);
		//t.FazendoAposta(con, 4, "R$ 500", "10/12/20", 3 , 3, 3);
		
		//t.read_data(con);
		/*System.out.println("Qual é o seu nome?");
		String nome_apostador = sc.nextLine();
		t.pesquisa(con, nome_apostador);*/
		//t.read_data(con,"aposta","dt_aposta", "apostador", "nome_apostador", "cod_apostador");
		//dt_aposta, tabela_1, nome_apostador, tabela_2, tabela_2, tabela_1, id1, tabela_2, id2);
		//t.createTable(con,"employee");
		//t.insert_row(con, "employee", "Luiza", "Gabriella");
		/*t.insert_row(con, "employee", "Luiza", "Gabriella");
		t.insert_row(con, "employee", "Apollo", "Lessa");
		t.insert_row(con, "employee", "Elicarla", "Silva");
		t.insert_row(con, "employee", "Alan", "Bruno");
		t.insert_row(con, "employee", "Silvia", "Lessa");
		t.insert_row(con, "employee", "Jorge", "Reis");*/
		/*t.search_by_name(con,"employee", "Manu");
		t.update_name(con,"employee","Luiza","Manu");
        t.delete_row_by_name(con,"employee","Jorge");
		t.read_data(con,"employee");

        t.delete_row_by_id(con,"employee",4);*/
		
		/*System.out.println("MENU");
		System.out.println("1 - ADMINISTRADOR");
		System.out.println("2 - APOSTADOR");
		System.out.println("ESCOLHA SUA OPÇÃO");
		int opcaoInicial = sc.nextInt();
		
		if (opcaoInicial == 1) {
			System.out.println("1 - CADASTRAR MODALIDADES");
			System.out.println("2 - CADASTRAR JOGOS");
			System.out.println("3 - CADASTRAR RESULTADOS");
			System.out.println("ESCOLHA SUA OPÇÃO");
		    int opcaoADM = sc.nextInt();
		    
		    if (opcaoADM > 3 || opcaoADM < 0 ) {
				System.out.println("OPCAO INVALIDA");
			}else if (opcaoADM == 1) {
				ADM.CadastrandoModalidades(con);
			}else if (opcaoADM == 2) {
				ADM.CadastrandoJogos(con);
			}else if (opcaoADM == 3) {
				ADM.CadastrandoResultados(con);
			}
		}else if (opcaoInicial == 2) {
			System.out.println("1 - SE CADASTRAR");
			System.out.println("2 - FAZER APOSTA");
			System.out.println("3 - VER RESULTADOS");
			System.out.println("4 - LISTAR MODALIDADES");
			System.out.println("5 - LISTAR JOGOS");
			System.out.println("ESCOLHA SUA OPÇÃO");
			int opcaoApostadores = sc.nextInt();
			
			if (opcaoApostadores == 1) {
				APO.CadastrandoApostadores(con);
			//}else if (opcaoApostadores == 2 ) {
				//APO.FazendoAposta(con);
			//}else if (opcaoApostadores == 4) {
				
			}
			}else if (opcaoApostadores == 3) {
				
			}else if (opcaoApostadores == 4) {
				
			}else if (opcaoApostadores == 5) {
				
			}*/
			ADM.search_by_name(con, "Luiza");
			}
			
			//sc.close();
		
		
		 
	}




/* 
 * 
 * ADMINISTRADOR
 * APOSTADOR
 * 
 * PARA APOSTADORES
 * JÁ TEM CADASTRO EM NOSSA PLATAFORMA?
 * NÃO
 * SIM
 * 
 * NÃO
 * REALIZAR CADASTRO
 * MOSTRAR MENU
 * 
 * SIM
 * MOSTRAR MENU
 * 
 * --------------
 * MENU
 * 1 - CONSULTAR JOGOS DISPONIVEIS
 * 2 - FAZER APOSTA
 * 3 - VER RESULTADOS
 * 
 * 3 - VER RESULTADOS
 * 3.1 - POR JOGO
 * 3.2 - APOSTAS GANHAS
 * 3.3 - APOSTAS PERDIDAS
 * 
 * --------------------------------------
 * PARA ADMINISTRADORES
 * 
 * 1 - CADASTRAR NOVOS JOGOS
 * 2 - CADASTRAR NOVAS MODALIDADES
 * */
