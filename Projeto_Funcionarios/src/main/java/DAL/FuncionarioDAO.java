package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Funcionarios;

public class FuncionarioDAO 
{
    public String mensagem;
    Conexao conexao = new Conexao();
    

    public void cadastrarFuncionario(Funcionarios funcionario) 
    {
        this.mensagem = "";
        try 
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "insert into Funcionarios (Nome_Funcionario, Data_Admissao, Data_Demissao, Id_Empresa) values(?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(instrucaoSql);
            stmt.setString(1, funcionario.getNome_Funcionario());
            stmt.setString(2, funcionario.getData_Admissao());
            stmt.setString(3, funcionario.getData_Demissao());
            stmt.setInt(4, funcionario.getId_Empresa());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Funcionario cadastrado";
        } 
        catch (SQLException e) 
        {
            this.mensagem = "Erro ao cadastrar";
        }
    }
    
    public Funcionarios PesquisarId(Funcionarios funcionarios)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "select * from Funcionarios where Id_Funcionario = ?";
            PreparedStatement stmt = con.prepareStatement(instrucaoSql);
            stmt.setInt(1, funcionarios.getId_Funcionario());
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next())
            {
                funcionarios.setNome_Funcionario(resultSet.getString("Nome_Funcionario"));
                funcionarios.setData_Admissao(resultSet.getString("Data_Admissao"));
                funcionarios.setData_Demissao(resultSet.getString("Data_Demissao"));
                funcionarios.setId_Empresa(resultSet.getInt("Id_Empresa"));
            }
            else
            {
                this.mensagem = "Pessoa não encontrada";
            }
            conexao.desconectar();
        }
        catch (Exception e)
        {
            this.mensagem = "Erro ao pesquisar: " + e.getMessage(); // Mostra a mensagem de erro específica
            e.printStackTrace(); // Imprime a pilha de erro para ajudar a diagnosticar
        }
        return funcionarios;
    }
    public void editarPessoa(Funcionarios funcionario)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "upadate Funcionarios set Nome_Funcionario = ?, set Data_Admissao = ?, set Data_Demissao = ? where Id_Funcionario = ?";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            stmt.setString(1, funcionario.getNome_Funcionario());
            stmt.setString(2, funcionario.getData_Admissao());
            stmt.setString(3, funcionario.getData_Demissao());
            stmt.setInt(4, funcionario.getId_Funcionario());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Pessoa Editada !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no editar";
        }
        
    }
    
    public void excluirPessoa(Funcionarios funcionarios)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "delete from Funcionarios where Id_Funcionarios = ?";
            PreparedStatement stmt = con.prepareStatement(instrucaoSql);
            stmt.setInt(1, funcionarios.getId_Funcionario());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Pessoa excluida !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro na exclusão";
        }
    }
}
