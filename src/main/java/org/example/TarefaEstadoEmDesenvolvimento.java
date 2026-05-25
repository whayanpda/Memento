package org.example;

public class TarefaEstadoEmDesenvolvimento implements TarefaEstado {

    private TarefaEstadoEmDesenvolvimento() {}
    private static TarefaEstadoEmDesenvolvimento instance = new TarefaEstadoEmDesenvolvimento();

    public static TarefaEstadoEmDesenvolvimento getInstance() {
        return instance;
    }

    @Override
    public String getNomeEstado() {
        return "Em Desenvolvimento";
    }
}