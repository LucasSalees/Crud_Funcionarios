package modelo;
public class Funcionarios 
{
    private int Id_Funcionario;
    private String Nome_Funcionario;
    private String Data_Admissao;
    private String Data_Demissao;
    private int Id_Empresa;

    public int getId_Funcionario() {
        return Id_Funcionario;
    }

    public void setId_Funcionario(int Id_Funcionario) {
        this.Id_Funcionario = Id_Funcionario;
    }

    public String getNome_Funcionario() {
        return Nome_Funcionario;
    }

    public void setNome_Funcionario(String Nome_Funcionario) {
        this.Nome_Funcionario = Nome_Funcionario;
    }

    public String getData_Admissao() {
        return Data_Admissao;
    }

    public void setData_Admissao(String Data_Admissao) {
        this.Data_Admissao = Data_Admissao;
    }

    public String getData_Demissao() {
        return Data_Demissao;
    }

    public void setData_Demissao(String Data_Demissao) {
        this.Data_Demissao = Data_Demissao;
    }

    public int getId_Empresa() {
        return Id_Empresa;
    }

    public void setId_Empresa(int Id_Empresa) {
        this.Id_Empresa = Id_Empresa;
    }

}
