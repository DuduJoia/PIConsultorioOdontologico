package consultorioodontologico.Model;

import consultorioodontologico.Dao.ModuloConexao;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Atendimento {

    private String horario, data;
    private int idAtendimento, codPaciente, codDentista, codAtendente, codProcedimento;

    public Atendimento(String horario, String data, int codigoPaciente, int codigoDentista, int codigoAtendente, int codigoProcedimento) {
        this.horario = horario;
        this.data = data;
        this.codPaciente = codigoPaciente;
        this.codDentista = codigoDentista;
        this.codAtendente = codigoAtendente;
        this.codProcedimento = codigoProcedimento;
    }

    public Atendimento() {
        
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public void setCodPaciente(int codigoPaciente) {
        this.codPaciente = codigoPaciente;
    }

    public void setCodDentista(int codigoDentista) {
        this.codDentista = codigoDentista;
    }

    public void setCodAtendente(int codigoAtendente) {
        this.codAtendente = codigoAtendente;
    }

    public void setCodProcedimento(int codigoProcedimento) {
        this.codProcedimento = codigoProcedimento;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdAtendimento() {
        return this.idAtendimento;
    }

    public int getCodPaciente() {
        return codPaciente;
    }

    public int getCodDentista() {
        return codDentista;
    }

    public int getCodAtendente() {
        return codAtendente;
    }

    public int getCodProcedimento() {
        return codProcedimento;
    }

    public String getHorario() {
        return horario;
    }

    public String getData() {
        return data;
    }

    public void marcarAtendimento() {
        try {
            String sql = "INSERT INTO atendimento(horario,data,cod_paciente,cod_dentista,cod_atendente,cod_procedimento) "
                    + "VALUES( '" + this.getHorario() + "', "
                    + " '" + this.getData() + "', "
                    + "  " + this.getCodPaciente() + " , "
                    + "  " + this.getCodDentista() + " , "
                    + "  " + this.getCodAtendente() + " , "
                    + "  " + this.getCodProcedimento() + " ; ";

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editarAtendimento() {
        try {
            String sql = "UPDATE atendimento SET "
                    + "horario = '" + this.getHorario() + "', "
                    + "data = '" + this.getData() + "', "
                    + "cod_paciente = '" + this.getCodPaciente() + "', "
                    + "cod_dentista = '" + this.getCodDentista() + "', "
                    + "cod_Atendente = '" + this.getCodAtendente() + "', "
                    + "cod_Procedimento = '" + this.getCodProcedimento() + "); ";

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ExcluirAtendimento(int idAtendimento) {
        try {
            String sql = "DELETE FROM atendimento WHERE idAtendimento = " + this.getIdAtendimento();

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static ArrayList<Atendimento> getAtendimentos() {
        ArrayList<Atendimento> lista = new ArrayList<>();
        String sql = "SELECT * FROM atendimento ORDER BY idAtendimento ASC";
        ResultSet rs = ModuloConexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    String data = rs.getString("data");
                    String horario = rs.getString("horario");
                    int codigoPaciente = rs.getInt("cod_paciente");
                    int codigoDentista = rs.getInt("cod_dentista");
                    int codigoAtendente = rs.getInt("cod_atendente");
                    int codigoProcedimento = rs.getInt("cod_Procedimento");

                    Atendimento aten = new Atendimento(horario, data, codigoPaciente, codigoDentista, codigoAtendente, codigoProcedimento);
                    aten.setIdAtendimento(rs.getInt("idAtendente"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return lista;
    }
}
