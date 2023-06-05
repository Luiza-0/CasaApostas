import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FuncoesApostadores {

	FuncoesADM func = new FuncoesADM();
	Connection con = null;

	//Função de cadastro
	public void CadastrandoApostadores(Connection con){
		Scanner sc = new Scanner(System.in);
		Statement statement;
		Integer cod_apostador;
		String nome_apostador, cpf_apostador, email_apostador, tel_apostador;

		System.out.println("CADASTRO DE APOSTADORES");

		System.out.printf("CODIGO:");
		cod_apostador = sc.nextInt();
		System.out.println();
		System.out.printf("NOME: ");
		nome_apostador = sc.nextLine();
		System.out.println();
		System.out.printf("CPF:");
		cpf_apostador = sc.nextLine();
		System.out.println();
		System.out.printf("EMAIL:");
		email_apostador = sc.nextLine();
		System.out.println();
		System.out.printf("TELEFONE:");
		tel_apostador = sc.nextLine();


		try {
			String query=String.format("insert into %s(cod_apostador, nome_apostador,cpf_apostador, email_apostador, tel_apostador) values('%s','%s','%s','%s', '%s')", "apostador",cod_apostador,nome_apostador,cpf_apostador,email_apostador,tel_apostador);
			statement=con.createStatement();
			statement.executeUpdate(query);
			System.out.println("Apostador Cadastrado com Sucesso!");
		}catch (Exception e){
			System.out.println(e);
		}
		sc.close();
	}
	
	//Função para fazer aposta
	public void FazendoAposta(Connection con){
		Scanner sc = new Scanner(System.in);
		Float valor_aposta;
		Integer cod_aposta, cod_apostador, cod_modalidade, cod_jogo; 
		String  dt_aposta;
		Statement statement;
		
		System.out.printf("APOSTA Nº:");
		cod_aposta = sc.nextInt();
		System.out.println();
		System.out.printf("APOSTADOR Nº: ");
		cod_apostador = sc.nextInt();
		System.out.println();
		System.out.printf("MODALIDADE Nº:");
		cod_modalidade = sc.nextInt();
		System.out.println();
		System.out.printf("JOGO Nº:");
		cod_jogo = sc.nextInt();
		System.out.println();
		System.out.printf("VALOR DA APOSTA:");
		valor_aposta = sc.nextFloat();
		System.out.println();
		System.out.printf("DATA DA APOSTA:");
		dt_aposta = sc.nextLine();
		
		try {
			String query=String.format("insert into %s(cod_aposta,valor_aposta,dt_aposta,cod_apostador, cod_modalidade, cod_jogo) values('%s','%s','%s','%s','%s','%s');", "APOSTA",cod_aposta,valor_aposta,dt_aposta,cod_apostador,cod_modalidade,cod_jogo);
			statement=con.createStatement();
			statement.executeUpdate(query);
			System.out.println("Aposta Realizada com Sucesso!");
		}catch (Exception e){
			System.out.println(e);
		}
		sc.close();
	}


	public void read_data(Connection conn){
		String  dt_aposta="dt_aposta", aposta="aposta", nome_apostador="nome_apostador", apostador="apostador", cod_apostador="cod_apostador";
		Statement statement;
		ResultSet rs=null;
		try {
			String query=String.format("select %s.%s, %s.%s from %s inner join %s on %s.%s = %s.%s", aposta, dt_aposta, apostador, nome_apostador, apostador, aposta, apostador, cod_apostador, apostador, cod_apostador);
			statement=conn.createStatement();
			rs=statement.executeQuery(query);

			while(rs.next()){
				System.out.print(rs.getString("dt_aposta")+" ");
				System.out.print("(" + rs.getString("nome_apostador")+") ");
				System.out.println();
			}

		}
		catch (Exception e){
			System.out.println(e);
		}
	}

	public void update_name(Connection conn,String table_name, String old_name,String new_name){
		Statement statement;
		try {
			String query=String.format("update %s set name='%s' where name='%s'",table_name,new_name,old_name);
			statement=conn.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data Updated");
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public void VerResultadosPorData(Connection conn,String nome){
		Statement statement;
		String aposta = "aposta", dt_aposta="dt_aposta",nome_apostador="nome_apostador", apostador="apostador", cod_apostador="cod_apostador" ;
		ResultSet rs=null;
		try {
			String query=String.format("select %s.%s, %s.%s from %s inner join %s on %s.%s = %s.%s where %s.%s = '%s'",aposta,dt_aposta,apostador,nome_apostador,apostador,aposta,apostador,cod_apostador,aposta,cod_apostador,apostador,nome);
			statement=conn.createStatement();
			rs=statement.executeQuery(query);
			while (rs.next()){
				System.out.print(rs.getString("dt_aposta")+" ");

			}
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public void VerResultadosPorNome(Connection conn,String nome){
		Statement statement;
		String aposta = "aposta", dt_aposta="dt_aposta",nome_apostador="nome_apostador", apostador="apostador", cod_apostador="cod_apostador" ;
		ResultSet rs=null;
		try {
			String query=String.format("select %s.%s, %s.%s from %s inner join %s on %s.%s = %s.%s where %s.%s = '%s'",aposta,dt_aposta,apostador,nome_apostador,apostador,aposta,apostador,cod_apostador,aposta,cod_apostador,apostador,nome);
			statement=conn.createStatement();
			rs=statement.executeQuery(query);
			while (rs.next()){
				System.out.print(rs.getString("dt_aposta")+" ");

			}
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public void pesquisa(Connection conn, String nome) {
		Statement statement;
		ResultSet rs = null;
		try {
			String query = String.format("SELECT aposta.dt_aposta, apostador.nome_apostador FROM apostador INNER JOIN aposta ON apostador.cod_apostador = aposta.cod_apostador WHERE apostador.nome_apostador = '%s'", nome);
			statement = conn.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getString("dt_aposta") + " ");
				System.out.println(rs.getString("nome_apostador") + " ");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}







	public void search_by_id(Connection conn, String table_name,int id){
		Statement statement;
		ResultSet rs=null;
		try {
			String query=String.format("select * from %s where empid= %s",table_name,id);
			statement=conn.createStatement();
			rs=statement.executeQuery(query);
			while (rs.next()){
				System.out.print(rs.getString("empid")+" ");
				System.out.print(rs.getString("name")+" ");
				System.out.println(rs.getString("address"));

			}
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public void delete_row_by_name(Connection conn,String table_name, String name){
		Statement statement;
		try{
			String query=String.format("delete from %s where name='%s'",table_name,name);
			statement=conn.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data Deleted");
		}catch (Exception e){
			System.out.println(e);
		}
	}
	public void delete_row_by_id(Connection conn,String table_name, int id){
		Statement statement;
		try{
			String query=String.format("delete from %s where empid= %s",table_name,id);
			statement=conn.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data Deleted");
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public void delete_table(Connection conn, String table_name){
		Statement statement;
		try {
			String query= String.format("drop table %s",table_name);
			statement=conn.createStatement();
			statement.executeUpdate(query);
			System.out.println("Table Deleted");
		}catch (Exception e){
			System.out.println(e);
		}
	}

}
