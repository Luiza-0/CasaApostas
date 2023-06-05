import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FuncoesADM {
	private String url="jdbc:postgresql://localhost:5432/casaapostas";
	private String usuario="postgres";
	private String senha="1234";

	Connection con = null;

	//Conexão com o banco de dados PostgreSQL
	public Connection conexao(){	

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão realizada com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	/*Criar Tabelas 
	public void CriarTabela(Connection conn, String table_name){
        Statement statement;
        try{
            String query="create table "+table_name+"(empid SERIAL,name varchar(200),address varchar(200),primary key(empid));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }*/

	//Função para cadastrar jogos
	public void CadastrandoJogos(Connection con){
		Scanner sc = new Scanner (System.in);
		Integer cod_jogo;
		String time_01, time_02,time_vencedor;
		System.out.println("CADASTRO DE JOGOS");

		System.out.printf("CODIGO:");
		cod_jogo = sc.nextInt();
		System.out.println();
		System.out.printf("TIME 1: ");
		time_01 = sc.next();
		System.out.println();
		System.out.printf("TIME 2:");
		time_02 = sc.next();
		System.out.println();
		System.out.printf("TIME VENCEDOR:");
		time_vencedor = sc.next();
		System.out.println();
		Statement statement;
		try {
			String query=String.format("insert into %s(cod_jogo,time_01,time_02,time_vencedor) values('%s','%s','%s','%s');", "JOGO",cod_jogo,time_01,time_02,time_vencedor);
			statement=con.createStatement();
			statement.executeUpdate(query);
			System.out.println("Jogo Cadastrado com Sucesso!");
		}catch (Exception e){
			System.out.println(e);
		}
		sc.close();
	}

	//Função para cadastrar modalidades
	public void CadastrandoModalidades(Connection con){

		Scanner sc = new Scanner (System.in);
		Integer cod_modalidade, qtd_jogos;
		String nome_modalidade, desc_modalidade;
		Statement statement;

		System.out.println("CADASTRO DE MODALIDADES");

		System.out.printf("CODIGO:");
		cod_modalidade = sc.nextInt();
		System.out.println();
		System.out.printf("QUANTIDADE DE JOGOS: ");
		qtd_jogos = sc.nextInt();
		System.out.println();
		System.out.printf("MODALIDADE:");
		nome_modalidade = sc.next();
		System.out.println();
		System.out.printf("DESCRICAO MODALIDADE:");
		desc_modalidade = sc.next();
		System.out.println();
		try {
			String query=String.format("insert into %s(cod_modalidade, nome_modalidade,desc_modalidade,qtd_jogos) values('%s', '%s', '%s','%s');", "MODALIDADE", cod_modalidade, nome_modalidade,desc_modalidade,qtd_jogos);
			statement=con.createStatement();
			statement.executeUpdate(query);
			System.out.println("Modalidade Cadastrada com Sucesso!");
		}catch (Exception e){
			System.out.println(e);
		}

		sc.close();
	}

	//Função para cadastrar resultados
	
	public void CadastrandoResultados(Connection con){

		Scanner sc = new Scanner (System.in);
		Float valor_pago_p_jogador, valor_aposta;
		Integer cod_resultado,cod_modalidade, cod_jogo,cod_aposta, cod_apostador, qtd_apostadores ;
		String  dt_aposta, time_vencedor;
		Statement statement;

		System.out.println("CADASTRO DE RESULTADOS");

		System.out.printf("RESULTADO Nº:");
		cod_resultado = sc.nextInt();
		System.out.println();
		System.out.printf("MODALIDADE Nº: ");
		cod_modalidade = sc.nextInt();
		System.out.println();
		System.out.printf("JOGO Nº:");
		cod_jogo = sc.nextInt();
		System.out.println();
		System.out.printf("APOSTA Nº:");
		cod_aposta = sc.nextInt();
		System.out.println();
		System.out.printf("APOSTADOR Nº:");
		cod_apostador = sc.nextInt();
		System.out.println();
		System.out.printf("QUANTIDADE DE APOSTADORES Nº:");
		qtd_apostadores = sc.nextInt();
		System.out.println();
		System.out.printf("VALOR PAGO PARA O JOGADOR:");
		valor_pago_p_jogador = sc.nextFloat();
		System.out.println();
		System.out.printf("VALOR APOSTA:");
		valor_aposta = sc.nextFloat();
		System.out.println();
		System.out.printf("DATA APOSTA:");
		dt_aposta = sc.nextLine();
		System.out.println();
		System.out.printf("TIME VENCEDOR:");
		time_vencedor = sc.nextLine();
		
		try {
			String query=String.format("insert into %s(cod_resultado,cod_modalidade, cod_jogo,cod_aposta, cod_apostador, qtd_apostadores,valor_pago_p_jogador, valor_aposta, dt_aposta, time_vencedor) values('%s', '%s', '%s','%s', '%s', '%s', '%s', '%s','%s', '%s',);", "MODALIDADE", cod_resultado,cod_modalidade, cod_jogo,cod_aposta, cod_apostador, qtd_apostadores,valor_pago_p_jogador, valor_aposta, dt_aposta, time_vencedor);
			statement=con.createStatement();
			statement.executeUpdate(query);
			System.out.println("Resultado Cadastrado com Sucesso!");
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

	/*"select %s.%s, %s.%s from %s inner join %s on %s.%s = %s.%s"
	 * /*SELECT
    aposta.dt_aposta,
    apostador.nome_apostador
FROM
    apostador
INNER JOIN
    aposta ON apostador.cod_apostador = aposta.cod_apostador
WHERE
    apostador.nome_apostador = 'Luiza';*/
	public void search_by_name(Connection conn,String nome){
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
