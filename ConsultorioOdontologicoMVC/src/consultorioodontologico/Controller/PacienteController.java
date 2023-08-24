package consultorioodontologico.Controller;

import consultorioodontologico.Model.Paciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PacienteController {

    ArrayList<Paciente> listaPacientes = new ArrayList<>();
    Paciente paciente = new Paciente();

    public void cadastrarPaciente(String nome, String cpf, String celular, String email, String endereco, String anamnese) {
        try {
            //if (cpf.length() == 14 && celular.length() < 15 && email.length() < 45 && endereco.length() > 60 &&
            //   !nome.equals("") && !cpf.equals("") && !celular.equals("") && !email.equals("") && !endereco.equals("")) {

                Paciente pac = new Paciente(nome, cpf, celular, email, endereco, anamnese);
                pac.cadastrar(pac);
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editarPaciente(String nome, String cpf, String celular, String email, String endereco, String anamnese) {
        try {
            //if (cpf.length() == 14 && celular.length() < 26 && email.length() 
            //    < 45 && endereco.length() > 60 && !nome.equals("") && !cpf.equals("") 
            //    && !celular.equals("") && !email.equals("") && !endereco.equals("")) {

                Paciente pac = new Paciente(nome, cpf, celular, email, endereco, anamnese);
                pac.editar(pac);
                JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluirPaciente(int idPaciente) {
        listaPacientes = null;
        listaPacientes = paciente.getPacientes();

        try {
            for (Paciente pac : listaPacientes) {
                if (pac.getIdPaciente() == idPaciente) {
                    pac.excluir(idPaciente);
                    
                    JOptionPane.showMessageDialog(null, "Cadastro excluid com sucesso");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Paciente> getPacientes() {
        Paciente pac = new Paciente();
        return pac.getPacientes();
    }
}