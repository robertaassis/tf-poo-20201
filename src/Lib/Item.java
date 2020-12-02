package Lib;

public abstract class Item {
    private String nome;
    private int id;
    private String tipo;

    public String getTipo() { return tipo; }

    protected void setTipo(String tipo) { this.tipo = tipo; }

    private Status disponibilidade;

    public void setNome(String nome) { this.nome = nome; }

    public void setId(int id) { this.id = id; }

    public void setDisponibilidade(Status disponibilidade) { this.disponibilidade = disponibilidade; }

    public String getNome() { return nome; }

    public int getId() { return id; }

    public Status getDisponibilidade() { return disponibilidade; }

    public abstract boolean editar();

    public Status consultarDisponibilidade() {
        return null;
    }

}