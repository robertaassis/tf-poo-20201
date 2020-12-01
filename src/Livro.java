public class Livro extends Item {
    private String isbn;
    private String autor;
    private String editora;

    @Override
    public boolean editar() {
        return false;
    }
}
