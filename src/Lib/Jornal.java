package Lib;

public class Jornal extends Item {
    private java.util.Calendar data;
    private int numero;
    private String diretor;

    public Jornal(String n, int i, Status d) {
        setNome(n);
        setId(i);
        setDisponibilidade(d);
        setTipo("Jornal");
    }

    @Override
    public boolean editar() {
        return false;
    }
}
