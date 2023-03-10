package service;
import model.Post;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import static service.Operacoes.TelaInicial;
public class PostsServices {
    static ArrayList<Post> addPost = new ArrayList<Post>();
    public static void CriarPost() {
        Post posts = new Post();

        posts.setNome(JOptionPane.showInputDialog("Seu nome: "));
        posts.setEmail(JOptionPane.showInputDialog("Seu email: "));
        posts.setNumeroCelular(JOptionPane.showInputDialog("Seu celular: "));
        posts.setEmpresaNome(JOptionPane.showInputDialog("Nome da empresa: "));
        posts.setEmpresaCnpj(JOptionPane.showInputDialog("CNPJ: "));
        posts.setRazaoFisicaNome(JOptionPane.showInputDialog("Procuração física - nome: "));
        posts.setRazaoFisicaCPF(JOptionPane.showInputDialog("Procuração física - CPF: "));
        try {
            posts.setDiaCadastro(Integer.parseInt(JOptionPane.showInputDialog("Feito no dia: ")));
            posts.setMesCadastro(Integer.parseInt(JOptionPane.showInputDialog("Feito no mês: ")));
            posts.setAnoCadastro(Integer.parseInt(JOptionPane.showInputDialog("Feito no ano: ")));
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Você digitou um texto ou valor vazio.");
            posts.setDiaCadastro(Integer.parseInt(JOptionPane.showInputDialog("Feito no dia: ")));
            posts.setMesCadastro(Integer.parseInt(JOptionPane.showInputDialog("Feito no mês: ")));
            posts.setAnoCadastro(Integer.parseInt(JOptionPane.showInputDialog("Feito no ano: ")));
        }
        addPost.add(posts);
        JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
        TelaInicial();
    }
    public static void ListarPosts() {
        if (addPost.size() > 0) {
            //cria a tela
            JFrame frame = new JFrame("Lista de Posts");
            JPanel panel = new JPanel();

            String[] colunas = {"Nome", "Email", "Celular", "Empresa", "CNPJ", "Pro.Fisica-Nome", "Proc.Fisica-CPF", "Dia do cadastro", "Mês do cadastro", "Ano do cadastro"};
            DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

            //fiz um loop no array para percorrer os itens - loop for each
            for (Post posts : addPost) {
                modelo.addRow(new Object[]{
                        posts.getNome(), posts.getEmail(), posts.getNumeroCelular(),
                        posts.getEmpresaNome(), posts.getEmpresaCnpj(),
                        posts.getRazaoFisicaNome(), posts.getRazaoFisicaCPF(),
                        posts.getDiaCadastro(), posts.getMesCadastro(), posts.getAnoCadastro()
                });
            }
            // Cria a tabela com os dados
            JTable tabela = new JTable(modelo);
            JScrollPane scrollPane = new JScrollPane(tabela);

            panel.add(scrollPane);
            scrollPane.setPreferredSize(new Dimension(1400, 1500));

            frame.add(panel);
            frame.setSize(1800, 1000);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Não existem empresas cadastradas no momento.");
        }
        TelaInicial();
    }
}