package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TarefaTest {

    @Test
    void deveCriarTarefaComTitulo() {
        Tarefa tarefa = new Tarefa("Implementar padrao Memento");

        assertEquals("Implementar padrao Memento", tarefa.getTitulo());
    }

    @Test
    void deveGuardarEstadosNoHistoricoAoAlterarEstado() {
        Tarefa tarefa = new Tarefa("Criar testes");

        tarefa.setEstado(TarefaEstadoBacklog.getInstance());
        tarefa.setEstado(TarefaEstadoEmDesenvolvimento.getInstance());
        tarefa.setEstado(TarefaEstadoEmTestes.getInstance());
        tarefa.setEstado(TarefaEstadoConcluida.getInstance());

        assertEquals(4, tarefa.getEstados().size());
        assertSame(TarefaEstadoBacklog.getInstance(), tarefa.getEstados().get(0));
        assertSame(TarefaEstadoEmDesenvolvimento.getInstance(), tarefa.getEstados().get(1));
        assertSame(TarefaEstadoEmTestes.getInstance(), tarefa.getEstados().get(2));
        assertSame(TarefaEstadoConcluida.getInstance(), tarefa.getEstados().get(3));
    }

    @Test
    void deveRestaurarEstadoAnteriorPeloIndiceDoHistorico() {
        Tarefa tarefa = new Tarefa("Testar restauracao");

        tarefa.setEstado(TarefaEstadoBacklog.getInstance());
        tarefa.setEstado(TarefaEstadoEmDesenvolvimento.getInstance());
        tarefa.setEstado(TarefaEstadoEmTestes.getInstance());

        tarefa.restauraEstado(0);

        assertSame(TarefaEstadoBacklog.getInstance(), tarefa.getEstado());
        assertEquals("Backlog (Aguardando)", tarefa.getEstado().getNomeEstado());
    }

    @Test
    void deveRestaurarEstadoIntermediarioPeloIndiceDoHistorico() {
        Tarefa tarefa = new Tarefa("Testar estado intermediario");

        tarefa.setEstado(TarefaEstadoBacklog.getInstance());
        tarefa.setEstado(TarefaEstadoEmDesenvolvimento.getInstance());
        tarefa.setEstado(TarefaEstadoEmTestes.getInstance());
        tarefa.setEstado(TarefaEstadoConcluida.getInstance());

        tarefa.restauraEstado(1);

        assertSame(TarefaEstadoEmDesenvolvimento.getInstance(), tarefa.getEstado());
        assertEquals("Em Desenvolvimento", tarefa.getEstado().getNomeEstado());
    }

    @Test
    void deveLancarExcecaoAoRestaurarIndiceNegativo() {
        Tarefa tarefa = new Tarefa("Testar indice negativo");
        tarefa.setEstado(TarefaEstadoBacklog.getInstance());

        assertThrows(IllegalArgumentException.class, () -> tarefa.restauraEstado(-1));
    }

    @Test
    void deveLancarExcecaoAoRestaurarIndiceMaiorQueHistorico() {
        Tarefa tarefa = new Tarefa("Testar indice maior");
        tarefa.setEstado(TarefaEstadoBacklog.getInstance());

        assertThrows(IllegalArgumentException.class, () -> tarefa.restauraEstado(1));
    }
}
