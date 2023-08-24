package consultorioodontologico.Controller;

import consultorioodontologico.Model.Procedimentos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProcedimentosController {

    public void cadastrar(String nome, String descricao, double valor) {
        try {
            if (!nome.equals("") && nome.length() < 21 && !descricao.equals("") && descricao.length() < 51
                    && valor != 0) {
                Procedimentos procedimento = new Procedimentos(nome, descricao, valor);
                procedimento.adicionar(procedimento);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editar(String nome, String descricao, double valor) {

        try {
            if (!nome.equals("") && nome.length() < 21 && !descricao.equals("") && descricao.length() < 51
                    && valor != 0) {
                Procedimentos procedimento = new Procedimentos(nome, descricao, valor);
                procedimento.editar(procedimento);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluir(int idProcedimento) {
        try {
            Procedimentos procedimento = new Procedimentos();
            procedimento.excluir(idProcedimento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ArrayList<Procedimentos> getProcedimentos(){
        Procedimentos procedimento = new Procedimentos();
        return procedimento.getProcedimentos();
    }
}
