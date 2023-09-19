/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorioodontologico.Controller;

import consultorioodontologico.Model.Atendimento;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 182210134
 */
public class AtendimentoController {

    public AtendimentoController() {

    }

    public void cadastraAtendimento(String horario, String data, int idPaciente, int idDentista, int idAtendente, int idProcedimento) {
        if (!horario.equals("Selecione") && !data.equals("")
                && idPaciente != 0 && idDentista != 0 && idAtendente != 0 && idProcedimento != 0) {
            Atendimento atendimento = new Atendimento(horario, data, idPaciente, idDentista, idAtendente, idProcedimento);
            atendimento.cadastrar(atendimento);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
        }
    }

    public void editarAtendimento(String horario, String data, int idPaciente, int idDentista, int idAtendente, int idProcedimento) {
        if (!horario.equals("Selecione") && !data.equals("Selecione")
                && idPaciente != 0 && idDentista != 0 && idAtendente != 0 && idProcedimento != 0) {
            Atendimento atendimento = new Atendimento(horario, data, idPaciente, idDentista, idAtendente, idProcedimento);
            atendimento.editarAtendimento(atendimento);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário preencher todos os campos");
        }
    }

    public void excluirAtendimento(int idAtendimento) {
        new Atendimento().ExcluirAtendimento(idAtendimento);
    }

    public ArrayList getAtendimentos() {
        return new Atendimento().getAtendimentos();

    }
}
