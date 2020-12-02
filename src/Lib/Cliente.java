package Lib;

public class Cliente {
    private String nome;
    private int id;
    private int livrosEmprestados;
    private int livrosReservados;

    public Cliente(String nome, int id, int livrosEmprestados, int livrosReservados) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = livrosEmprestados;
        this.livrosReservados = livrosReservados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(int livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public int getLivrosReservados() {
        return livrosReservados;
    }

    public void setLivrosReservados(int livrosReservados) {
        this.livrosReservados = livrosReservados;
    }
}
