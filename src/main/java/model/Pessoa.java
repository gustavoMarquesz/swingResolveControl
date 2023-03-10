package model;
import javax.swing.*;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import static service.PostsServices.CriarPost;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
    private String nome;
    private String email;
    private String numeroCelular;

    public void setEmail(String email){
        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, ("Email não pode ser nulo ou vazio, insira novamente os dados."));
            CriarPost();
        }
        this.email = email;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()){
            JOptionPane.showMessageDialog(null, ("Email não pode ser nulo ou vazio, insira novamente os dados."));
            CriarPost();
        }
        this.nome = nome;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
}