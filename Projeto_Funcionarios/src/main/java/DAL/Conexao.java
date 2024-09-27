package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao 
{
    public Connection con;
    public String mensagem;
    private String stringConexao = "jdbc:sqlserver://localhost\\LUCAS\\SQLEXPRESS:1433;databaseName=Projeto_Edson_Final;encrypt=false";
    
    public Connection conectar()
    {
        this.mensagem = "";
        try 
        {
            if(con == null || con.isClosed())
            {
                con = DriverManager.getConnection(stringConexao, "sa","0421");
            }
        } 
        catch (SQLException e) 
        {
            this.mensagem = "Erro ao conectar";
        }
        return con;
    }
    public void desconectar()
    {
        try 
        {
            if(!con.isClosed())
                con.close();
        } 
        catch (SQLException e) 
        {
            this.mensagem = " Erro ao desconectar";
        }
    }
}
