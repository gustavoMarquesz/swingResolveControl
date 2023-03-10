package service;

import javax.swing.*;
import static service.PostsServices.CriarPost;
import static service.PostsServices.ListarPosts;
public class Operacoes {
    public static void TelaInicial() {
        int operacao = 0;
        // adicionado um bloco de try/catch caso o user digite uma string ou valor vazio
        try {
            operacao = Integer.parseInt(JOptionPane.showInputDialog("1. Cadastro de empresa \n 2. Listar empresas \n 3. Sair"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido. Por favor, digite um número válido.");
            TelaInicial();
        }

        switch (operacao) {
            case 1:
                CriarPost();
                break;
            case 2:
                ListarPosts();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "até mais!");
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
                System.out.println("Opção inválida.");
                TelaInicial();
                break;
        }

    }
}