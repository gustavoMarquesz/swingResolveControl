package model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.swing.*;

@Getter
@Setter
@NoArgsConstructor
public class Post extends  Pessoa{
    static String empresaDados= "| nosso CNPJ: 14.162.031/0001-53 |";
    private int diaCadastro;
    private int mesCadastro;
    private int anoCadastro;
    private String textoPost;
    private String empresaNome;
    private String empresaCnpj;
    private String razaoFisicaNome;
    private String razaoFisicaCPF;
    public Post(String nome, String email, String numeroCelular, String empresaNome, String empresaCnpj, String razaoFisicaNome, String razaoFisicaCPF, int diaCadastro, int mesCadastro, int anoCadastro, String textoPost) {
        super(nome, email, numeroCelular);
        this.empresaNome = empresaNome;
        this.empresaCnpj = empresaCnpj;
        this.textoPost = textoPost;
        this.diaCadastro = diaCadastro;
        this.mesCadastro = mesCadastro;
        this.anoCadastro = anoCadastro;
        this.razaoFisicaNome = razaoFisicaNome;
        this.razaoFisicaCPF = razaoFisicaCPF;
    }
    public String toString(){
        return  "A empresa, de procuração jurídica " + this.getEmpresaNome() +" de CNPJ: " + this.getEmpresaCnpj()+ " e procuração física "+
                this.getRazaoFisicaNome()+ " de CPF: "+ this.getRazaoFisicaCPF() +" foi feito por: "+ this.getNome()+"." +
                "\n"+ "dia: "+ this.getDiaCadastro()+" |" + " mês: " + this.getMesCadastro()+" |"+ " ano: "+ this.getAnoCadastro()+" |"
                +"Vencimento do certificado dia: " +(this.getDiaCadastro()+ " mês: "+ this.getMesCadastro() + " ano: "+ (this.getAnoCadastro()+1));
    }

}