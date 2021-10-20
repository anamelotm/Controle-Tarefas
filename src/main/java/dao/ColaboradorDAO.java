package dao;

import infra.ConexaoMysql;
import entity.Colaborador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {
    private ConexaoMysql conexao;
    private String query = " ";

    public ColaboradorDAO() throws SQLException, ClassNotFoundException {
        this.conexao = new ConexaoMysql();
    }

    public boolean incluirColaborador(Colaborador colaborador) throws SQLException {
        query = "insert into colaborador(idColaborador, nomeColaborador) values(null,?);";
        try{
        	
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);

            stmt.setString(1,colaborador.getNomeColaborador());

            stmt.execute();
            this.conexao.commit();
            return true;
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

    public void alterarColaborador(int idColaborador, String novoNome) throws SQLException {
        query = "update colaborador set nomeColaborador = ? where idColaborador = ?;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setString(1, novoNome);
            stmt.setInt(2, idColaborador);

            stmt.execute();
            this.conexao.commit();

        } catch (SQLException e) {
           throw e;
        }

    }

    public void excluirColaborador(int idColaborador) throws SQLException {
        query = "delete from colaborador where idColaborador = ?;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1, idColaborador);
            stmt.execute();
            this.conexao.commit();
        } catch (SQLException e){
            throw e;
        }
    }

    public List<Colaborador> consultarColaboradores() throws SQLException {
        query = "select idColaborador, nomeColaborador from colaborador;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            List<Colaborador> listaColaborador = new ArrayList<>();

            while (resultSet.next()){
                Colaborador colaborador = new Colaborador(resultSet.getString("nomeColaborador"));
                colaborador.setIdColaborador(resultSet.getInt("idColaborador"));

                listaColaborador.add(colaborador);
            }

            return listaColaborador;

        } catch (SQLException e) {
            throw e;
        }
    }

    public Colaborador consultarColaborador(int idColaborador) throws SQLException {
        query = "select idColaborador, nomeColaborador from colaborador where idColaborador = ?;";
        try{
            PreparedStatement stmt = this.conexao.getConnection().prepareStatement(query);
            stmt.setInt(1,idColaborador);
            ResultSet resultSet = stmt.executeQuery();

            Colaborador colaborador = null;

            if(resultSet.next()){
                colaborador = new Colaborador(resultSet.getString("nomeColaborador"));
                colaborador.setIdColaborador(resultSet.getInt("idColaborador"));
            }

            return colaborador;
        } catch (SQLException e) {
            this.conexao.rollback();
            throw e;
        }
    }

}
