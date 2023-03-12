package model;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    private String nome;
    private String email;
    private String numeroCelular;

    public Funcionario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}