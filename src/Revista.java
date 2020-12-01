public class Revista extends Item {
    private java.util.Calendar data;
    private int edicao;
    private String editora;

    @Override
    public boolean editar() {
        return false;
    }
}
