package Lib;

public class Livro extends Item {
    private String isbn;
    private String autor;
    private String editora;

    public Livro(String n, int i, Status d) {
        setNome(n);
        setId(i);
        setDisponibilidade(d);
        setTipo("Livro");
    }

    @Override
    public boolean editar() {
        return false;
    }
}
