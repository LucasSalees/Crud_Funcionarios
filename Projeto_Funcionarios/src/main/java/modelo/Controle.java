package modelo;

import DAL.FuncionarioDAO;
import java.util.List;

public class Controle 
{
    public String mensagem;
    public void cadastrarFuncionario(List<String> listaDadosFuncionario)
            
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarFuncionarios(listaDadosFuncionario);
        this.mensagem = validacao.mensagem;
        if (this.mensagem.equals(""))
        {
            Funcionarios funcionario = new Funcionarios();
            funcionario.setNome_Funcionario(listaDadosFuncionario.get(1));
            funcionario.setData_Admissao(listaDadosFuncionario.get(2));
            funcionario.setData_Demissao(listaDadosFuncionario.get(3));
            funcionario.setId_Empresa(validacao.Id_Empresa);
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.cadastrarFuncionario(funcionario);
            this.mensagem = funcionarioDAO.mensagem;
        }
    }
    
    public Funcionarios pesquisarId(List<String> listaDadosFuncionario)
    {
        this.mensagem = "";
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionarios funcionarios = new Funcionarios();
        Validacao validacao = new Validacao();
        validacao.validarId_Funcionario(listaDadosFuncionario.get(0));
        this.mensagem = validacao.mensagem;
        if(this.mensagem.equals(""))
        {
            funcionarios.setId_Funcionario(validacao.Id_Funcionario);
            funcionarios = funcionarioDAO.PesquisarId(funcionarios);
            this.mensagem = funcionarioDAO.mensagem;
        }
        return funcionarios;
    }
    
    public void excluirPessoa(List<String> listaDadosFuncionario)
     {
         Validacao validacao = new Validacao();
         validacao.excluirPessoa(listaDadosFuncionario);
         if (validacao.mensagem.equals(""))
         {
             Funcionarios funcionarios = new Funcionarios();
             try {
                    int idFuncionario = Integer.parseInt(listaDadosFuncionario.get(0));
                    funcionarios.setId_Funcionario(idFuncionario);
                 } 
             catch (NumberFormatException e) 
                 {
                    this.mensagem = "ID do funcionário inválido";
                    return; 
        }
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.excluirPessoa(funcionarios);
        this.mensagem = "Pessoa excluída com sucesso";
         }
         else
         {
             this.mensagem = "Funcionário não encontrado";
         }
     }
}
