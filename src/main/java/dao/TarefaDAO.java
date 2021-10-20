package dao;

import infra.ConexaoMysql;
import entity.Tarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class TarefaDAO {
    private ConexaoMysql conexao;
    private String query = " ";

    public TarefaDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoMysql();
    }

    public boolean incluirTarefa(Tarefa tarefa) throws SQLException {
        query = "insert into tarefa(idTarefa, idColaborador, descrTarefa, dataHoraInicio, dataHoraFim, statusTarefa, prioridadeTarefa) values(null,?,?,?,?,?,?);";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("GMT-3"));

            stmt.setInt(1,tarefa.getIdColaborador());
            stmt.setString(2, tarefa.getDescrTarefa());
            stmt.setTimestamp(3, tarefa.getDataHoraInicio(),tzCal);
            stmt.setTimestamp(4, tarefa.getDataHoraFim(), tzCal);
            stmt.setString(5, tarefa.getStatusTarefa());
            stmt.setString(6, tarefa.getPrioridadeTarefa());

            stmt.execute();
            this.conexao.commit();
            return true;
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    public void alterarTarefa(int idTarefa, String descTarefa, Timestamp dataHoraFinal, String statusTarefa, String prioridadeTarefa) throws SQLException {
        query = "update tarefa set descrTarefa = ?, dataHoraFim = ?, statusTarefa = ?, prioridadeTarefa = ? where idTarefa = ?;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            Calendar tzCal = Calendar.getInstance(TimeZone.getTimeZone("GMT-3"));

            stmt.setString(1,descTarefa);
            stmt.setTimestamp(2,dataHoraFinal,tzCal);
            stmt.setInt(5,idTarefa);
            stmt.setString(3,statusTarefa);
            stmt.setString(4, prioridadeTarefa);

            stmt.execute();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    public void atualizarStatus(int idTarefa, String statusTarefa) throws SQLException {
        query = "update tarefa set statusTarefa = ? where idTarefa = ?;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, statusTarefa);
            stmt.setInt(2, idTarefa);

            stmt.execute();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    public void atualizarPrioridade(int idTarefa, String prioridadeTarefa) throws SQLException {
        query = "update tarefa set prioridadeTarefa = ? where idTarefa = ?;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, prioridadeTarefa);
            stmt.setInt(2, idTarefa);

            stmt.execute();
            this.conexao.commit();
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    public void excluirTarefa(int idTarefa) throws SQLException {
        query = "delete from tarefa where idTarefa = ?;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1,idTarefa);
            stmt.execute();
            this.conexao.commit();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Tarefa> consultarTarefas() throws SQLException {
        query = "select idTarefa, idColaborador, descrTarefa, dataHoraInicio, dataHoraFim, statusTarefa, prioridadeTarefa from tarefa;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            List<Tarefa> listaTarefa = new ArrayList<>();

            while (resultSet.next()){
                Tarefa tarefa = new Tarefa(resultSet.getInt("idColaborador"),resultSet.getString("descrTarefa"),resultSet.getTimestamp("dataHoraFim"));
                tarefa.setIdTarefa(resultSet.getInt("idTarefa"));
                tarefa.setStatusTarefa(resultSet.getString("statusTarefa"));
                tarefa.setPrioridadeTarefa(resultSet.getString("prioridadeTarefa"));

                listaTarefa.add(tarefa);
            }

            return listaTarefa;

        } catch (SQLException e) {
            throw e;
        }
    }

    public Tarefa consultarTarefa(int idTarefa) throws SQLException {
        query = "select idTarefa, idColaborador, descrTarefa, dataHoraInicio, dataHoraFim, statusTarefa, prioridadeTarefa from tarefa where idTarefa = ?;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1,idTarefa);
            ResultSet resultSet = stmt.executeQuery();
            Tarefa tarefa = null;

            if(resultSet.next()){
                tarefa = new Tarefa(resultSet.getInt("idColaborador"),resultSet.getString("descrTarefa"),resultSet.getTimestamp("dataHoraFim"));
                tarefa.setPrioridadeTarefa(resultSet.getString("prioridadeTarefa"));
                tarefa.setStatusTarefa(resultSet.getString("statusTarefa"));
                tarefa.setIdTarefa(resultSet.getInt("idTarefa"));
            }

            return tarefa;
        } catch (SQLException e) {
            throw e;
        }
    }
}
