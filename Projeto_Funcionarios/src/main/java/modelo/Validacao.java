package modelo;

import java.util.List;

public class Validacao 
{
    public String mensagem = "";
    public int Id_Empresa;
    public int Id_Funcionario;
    
    public void validarId_Funcionario(String identificacao)
    {
        this.mensagem = "";
        try
        {
            this.Id_Funcionario = Integer.parseInt(identificacao);
        } 
        catch (Exception e)
        {
            this.mensagem = "ID inválido";
        }
    }

    public void validarFuncionarios(List<String> listaDadosFuncionarios)
    {
        this.mensagem = "";
       validarId_Funcionario(listaDadosFuncionarios.get(0));
       if(listaDadosFuncionarios.get(1).length() == 0)
           this.mensagem += "Nome Obrigatório";
       if(listaDadosFuncionarios.get(2).length() == 0)
           this.mensagem += "Data Admissão Obrigatório";
       if(listaDadosFuncionarios.get(3).length() == 0)
           this.mensagem += "Data Demissão Obrigatório";

        try 
        {
            this.Id_Empresa = Integer.parseInt(listaDadosFuncionarios.get(4));
        } 
        catch (Exception e) 
        {
            this.mensagem = "Erro com o ID da Empresa";
        }
    }
    public void excluirPessoa(List<String> listaDadosFuncionario)
    {
       this.mensagem = "";
       
       if(listaDadosFuncionario.get(0).length() == 0)
           this.mensagem += "Nome obrigatorio\n";
    }
}
