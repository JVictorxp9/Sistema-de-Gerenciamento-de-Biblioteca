import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            String[] opcoes = {
                    "Cadastrar Livro", "Cadastrar Usuario", "Emprestar Livro", "Devolver Livro",
                    "Listar Usuarios", "Listar Livros Disponíveis", "Verificar Multas", "Sair"
            };

            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Biblioteca",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == 0) {
                String titulo = JOptionPane.showInputDialog("Título do livro:");
                String autor = JOptionPane.showInputDialog("Autor do livro:");
                biblioteca.cadastrarLivro(new Livro(titulo, autor));
            } else if (escolha == 1) {
                String nome = JOptionPane.showInputDialog("Nome do usuário:");
                String cpf = JOptionPane.showInputDialog("CPF do usuário:");
                biblioteca.cadastrarUsuario(new Usuario(nome, cpf));
            } else if (escolha == 2) {
                String titulo = JOptionPane.showInputDialog("Título do livro:");
                String cpf = JOptionPane.showInputDialog("CPF do usuário:");
                String dataStr = JOptionPane.showInputDialog("Data do empréstimo (dd/MM/yyyy):");
                try {
                    Date data = sdf.parse(dataStr);
                    biblioteca.emprestarLivro(titulo, cpf, data);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data inválida.");
                }
            } else if (escolha == 3) {
                String titulo = JOptionPane.showInputDialog("Título do livro:");
                String dataStr = JOptionPane.showInputDialog("Data da devolução (dd/MM/yyyy):");
                try {
                    Date dataDevolucao = sdf.parse(dataStr);
                    biblioteca.devolverLivro(titulo, dataDevolucao);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data inválida.");
                }
            } else if (escolha == 4) {
                biblioteca.listarUsuarios();
            } else if (escolha == 5) {
                biblioteca.listarLivrosDisponiveis();
            } else if (escolha == 6) {
                biblioteca.verificarMultas();
            } else {
                break;
            }
        }
    }
}
