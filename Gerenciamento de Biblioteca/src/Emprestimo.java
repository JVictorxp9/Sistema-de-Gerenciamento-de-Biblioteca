import java.util.Date;

class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private Date data;

    public Emprestimo(Livro livro, Usuario usuario, Date data) {
        this.livro = livro;
        this.usuario = usuario;
        this.data = data;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getData() {
        return data;
    }
}
