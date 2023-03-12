package service;
import model.Post;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import static service.Operacoes.TelaInicial;
public class PostsServices {
    static ArrayList<Post> addPost = new ArrayList<>();
    public static void CriarPost() {

        Post posts = new Post();
        posts.setNome(JOptionPane.showInputDialog("Seu nome: "));
        if(posts.getNome().isEmpty()){
            posts.setNome(JOptionPane.showInputDialog("Não aceitamos valor nulo neste campo \n insira seu nome novamente "));
        }
        posts.setEmail(JOptionPane.showInputDialog("Seu email "));
        if(posts.getEmail().isEmpty()){
            posts.setNome(JOptionPane.showInputDialog("Não aceitamos valor nulo neste campo \n insira seu email novamente "));
        }
        posts.setNumeroCelular(JOptionPane.showInputDialog("Seu celular: "));
        posts.setEmpresaNome(JOptionPane.showInputDialog("Nome da empresa: "));
        posts.setEmpresaCnpj(JOptionPane.showInputDialog("CNPJ: "));
        posts.setRazaoFisicaNome(JOptionPane.showInputDialog("Procuração física - nome: "));
        posts.setRazaoFisicaCPF(JOptionPane.showInputDialog("Procuração física - CPF: "));

        posts.setDiaCadastro(Integer.parseInt(JOptionPane.showInputDialog("Feito no dia: ")));
        if(posts.getDiaCadastro() <=0){
            posts.setDiaCadastro(Integer.parseInt(JOptionPane.showInputDialog("O dia precisa ser maior que 0. \n Insira novamente ")));
        }

        posts.setMesCadastro(Integer.parseInt(JOptionPane.showInputDialog("Feito no mês: ")));
        if(posts.getMesCadastro() <=0 || posts.getMesCadastro() >12){
            posts.setMesCadastro(Integer.parseInt(JOptionPane.showInputDialog("Só existem mês de 1 à 12. \n Insira novamente ")));
        }

        posts.setAnoCadastro(Integer.parseInt(JOptionPane.showInputDialog("Feito no ano: ")));
        if(posts.getAnoCadastro() <= 2000){
            posts.setAnoCadastro(Integer.parseInt(JOptionPane.showInputDialog("O ano precisa ser superior a 2000. \n Insira novamente ")));
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
            scrollPane.setPreferredSize(new Dimension(1400, 600));
            frame.add(panel);
            frame.setSize(1500, 650);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Não existem empresas cadastradas no momento.");
        }
        TelaInicial();
    }
}