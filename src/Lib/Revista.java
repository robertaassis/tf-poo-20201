package Lib;

public class Revista extends Item {
    private java.util.Calendar data;
    private int edicao;
    private String editora;

    public Revista(String n, int i, Status d) {
        setNome(n);
        setId(i);
        setDisponibilidade(d);
        setTipo("Revista");
    }

    @Override
    public boolean editar() {
        return false;
    }
}
