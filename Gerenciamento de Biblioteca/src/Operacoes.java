import java.util.Date;

interface Operacoes {
    void cadastrarLivro(Livro livro);
    void cadastrarUsuario(Usuario usuario);
    void emprestarLivro(String titulo, String cpf, Date data);
    void devolverLivro(String titulo, Date dataDevolucao);
    void listarUsuarios();
    void listarLivrosDisponiveis();
    void verificarMultas();
}
