package org.example;

public class TarefaEstadoConcluida implements TarefaEstado {

    private TarefaEstadoConcluida() {}
    private static TarefaEstadoConcluida instance = new TarefaEstadoConcluida();

    public static TarefaEstadoConcluida getInstance() {
        return instance;
    }

    @Override
    public String getNomeEstado() {
        return "Concluída (Done)";
    }
}
