package entity;

public class Colaborador {
    public int idColaborador;
    public String nomeColaborador;
    
    public Colaborador() {
    }

    public Colaborador( String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    @Override
    public String toString() {
        return  "Colaborador: "
                + idColaborador
                +" | "
                + nomeColaborador
                + "\n";
    }
}
