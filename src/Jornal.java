public class Jornal extends Item {
    private java.util.Calendar data;
    private int numero;
    private String diretor;

    @Override
    public boolean editar() {
        return false;
    }
}
