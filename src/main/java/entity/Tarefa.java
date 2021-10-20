package entity;

import java.sql.Timestamp;

public class Tarefa {
    public int idTarefa;
    public int idColaborador;
    public String descrTarefa;
    public Timestamp dataHoraInicio;
    public Timestamp dataHoraFim;
    public String statusTarefa;
    public String prioridadeTarefa;

    Long datetime = System.currentTimeMillis();
    Timestamp timestamp = new Timestamp(datetime);

    public Tarefa( int idColaborador, String descrTarefa, Timestamp dataHoraFim) {
        this.idColaborador = idColaborador;
        this.descrTarefa = descrTarefa;
        this.dataHoraFim = dataHoraFim;
        this.dataHoraInicio = timestamp;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    // Iniciada, Cancelada, Executada
    public void setStatusTarefa(String statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    // Baixa, Média, Alta, Urgente
    public void setPrioridadeTarefa(String prioridadeTarefa) {
        this.prioridadeTarefa = prioridadeTarefa;
    }

    public int getIdTarefa() {
        return idTarefa;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public String getDescrTarefa() {
        return descrTarefa;
    }

    public Timestamp getDataHoraInicio() {
        return dataHoraInicio;
    }

    public Timestamp getDataHoraFim() {
        return dataHoraFim;
    }

    public String getStatusTarefa() {
        return statusTarefa;
    }

    public String getPrioridadeTarefa() {
        return prioridadeTarefa;
    }

    @Override
    public String toString() {
        return "Id tarefa: "
                + idTarefa
                + " | Id colaborador: "
                + idColaborador
                + " | Descrição: "
                + descrTarefa
                + " | Data inicio: "
                + dataHoraInicio
                + " | Data fim: "
                + dataHoraFim
                + " | Status: "
                + statusTarefa
                + " | Prioridade: "
                + prioridadeTarefa
                + "\n";
    }
}
