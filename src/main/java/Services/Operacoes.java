package Services;

import Models.Post;

import javax.swing.*;
import java.util.Scanner;

import static Services.PostsServices.CriarPost;
import static Services.PostsServices.ListarPosts;


public class Operacoes {
    public static void TelaInicial(){

        int operacao = Integer.parseInt(JOptionPane.showInputDialog("1. Cadastro de empresa \n 2. Listar empresas \n 3. Sair"));
        switch (operacao){
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