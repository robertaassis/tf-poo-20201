public abstract class Item {
    private String nome;
    private int id;
    private Status disponibilidade;

    public abstract boolean editar();

    public Status consultarDisponibilidade() {
        return null;
    }

}