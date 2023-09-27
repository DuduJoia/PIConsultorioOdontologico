/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorioodontologico.Dao;

import consultorioodontologico.Model.Atendimento;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 182210134
 */
public class AtendimentoDao {

    public AtendimentoDao() {

    }

    public void cadastrar(Atendimento atendimento) {
        try {
            String sql = "INSERT INTO atendimento (horario ,data , cod_paciente, cod_dentista, cod_atendente, cod_procedimento) "
                    +    "VALUES ('" + atendimento.getHorario()         + "',"
                    +    "        '" + atendimento.getData()            + "',"
                    +    "         " + atendimento.getCodPaciente()     + ","
                    +    "         " + atendimento.getCodDentista()     + ","
                    +    "         " + atendimento.getCodAtendente()    + ","
                    +    "         " + atendimento.getCodProcedimento() + ");";

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editarAtendimento(Atendimento atendimento) {
        try {
            String sql = "UPDATE atendimento SET "
                    + "horario = '" + atendimento.getHorario() + "', "
                    + "data = '" + atendimento.getData() + "', "
                    + "cod_paciente = '" + atendimento.getCodPaciente() + "', "
                    + "cod_dentista = '" + atendimento.getCodDentista() + "', "
                    + "cod_Atendente = '" + atendimento.getCodAtendente() + "', "
                    + "cod_Procedimento = '" + atendimento.getCodProcedimento() + "); ";

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ExcluirAtendimento(int idAtendimento) {
        try {
            String sql = "DELETE FROM atendimento WHERE idAtendimento = " + idAtendimento;

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Atendimento> getAtendimentos() {
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
                    aten.setIdAtendimento(rs.getInt("idAtendimento"));
                    lista.add(aten);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return lista;
    }
}
