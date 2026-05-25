package org.example;

public class TarefaEstadoBacklog implements TarefaEstado {

    private TarefaEstadoBacklog() {}
    private static TarefaEstadoBacklog instance = new TarefaEstadoBacklog();

    public static TarefaEstadoBacklog getInstance() {
        return instance;
    }

    @Override
    public String getNomeEstado() {
        return "Backlog (Aguardando)";
    }
}
