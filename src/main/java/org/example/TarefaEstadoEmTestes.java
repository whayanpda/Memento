package org.example;

public class TarefaEstadoEmTestes implements TarefaEstado {

    private TarefaEstadoEmTestes() {}
    private static TarefaEstadoEmTestes instance = new TarefaEstadoEmTestes();

    public static TarefaEstadoEmTestes getInstance() {
        return instance;
    }

    @Override
    public String getNomeEstado() {
        return "Em Testes (Code Review/QA)";
    }
}