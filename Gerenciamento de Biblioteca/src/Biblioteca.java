import java.util.*;
import java.text.SimpleDateFormat;

class Biblioteca implements Operacoes {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void emprestarLivro(String titulo, String cpf, Date data) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && livro.isDisponivel()) {
                for (Usuario usuario : usuarios) {
                    if (usuario.getCpf().equals(cpf)) {
                        livro.emprestar();
                        emprestimos.add(new Emprestimo(livro, usuario, data));
                        return;
                    }
                }
            }
        }
    }

    public void devolverLivro(String titulo, Date dataDevolucao) {
        Iterator<Emprestimo> iterator = emprestimos.iterator();
        while (iterator.hasNext()) {
            Emprestimo e = iterator.next();
            if (e.getLivro().getTitulo().equalsIgnoreCase(titulo)) {
                e.getLivro().devolver();

                long dias = (dataDevolucao.getTime() - e.getData().getTime()) / (1000 * 60 * 60 * 24);
                if (dias > 14) {
                    double multa = (dias - 14) * 0.5;
                    System.out.println("Multa de R$ " + multa + " por atraso de " + (dias - 14) + " dias.");
                } else {
                    System.out.println("Livro devolvido no prazo, sem multa.");
                }

                iterator.remove();
                return;
            }
        }
        System.out.println("Livro não encontrado nos empréstimos.");
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println("Nome: " + u.getNome() + " | CPF: " + u.getCpf());
        }
    }

    public void listarLivrosDisponiveis() {
        for (Livro l : livros) {
            if (l.isDisponivel()) {
                System.out.println("Título: " + l.getTitulo() + " | Autor: " + l.getAutor());
            }
        }
    }

    public void verificarMultas() {
        Date hoje = new Date();
        for (Emprestimo e : emprestimos) {
            long dias = (hoje.getTime() - e.getData().getTime()) / (1000 * 60 * 60 * 24);
            if (dias > 14) {
                double multa = (dias - 14) * 0.5;
                System.out.println("Usuário: " + e.getUsuario().getNome() + " | Livro: " + e.getLivro().getTitulo() +
                        " | Dias de atraso: " + (dias - 14) + " | Multa: R$ " + multa);
            }
        }
    }
}
