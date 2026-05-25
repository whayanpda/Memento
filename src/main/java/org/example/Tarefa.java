package org.example;

import java.util.ArrayList;
import java.util.List;

public class Tarefa {

    private String titulo;
    private TarefaEstado estado;
    private List<TarefaEstado> memento = new ArrayList<TarefaEstado>();

    public Tarefa(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public TarefaEstado getEstado() {
        return this.estado;
    }

    public void setEstado(TarefaEstado estado) {
        this.estado = estado;
        this.memento.add(this.estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > this.memento.size() - 1) {
            throw new IllegalArgumentException("Índice de histórico inválido");
        }
        this.estado = this.memento.get(indice);
    }

    public List<TarefaEstado> getEstados() {
        return this.memento;
    }
}
