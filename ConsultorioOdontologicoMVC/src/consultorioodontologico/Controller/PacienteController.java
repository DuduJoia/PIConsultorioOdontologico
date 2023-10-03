package consultorioodontologico.Controller;

import consultorioodontologico.Model.Paciente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PacienteController {

    ArrayList<Paciente> listaPacientes = new ArrayList<>();
    Paciente paciente = new Paciente();

    public boolean cadastrarPaciente(String nome, String cpf, String celular, String email, String endereco, String anamnese) {
        if (nome.length() <= 40 && cpf.length() == 14 && celular.length() < 15 && email.length() < 45 && endereco.length() < 60
                && !nome.equals("") && !cpf.equals("") && !celular.equals("")
                && !email.equals("") && !endereco.equals("")) {

            Paciente pac = new Paciente(nome, cpf, celular, email, endereco, anamnese);
            pac.cadastrar(pac);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro, preencha os campos corretamente");
            return false;
        }

    }

    public void editarPaciente(String nome, String cpf, String celular, String email, String endereco, String anamnese, int idPaciente) {
        try {
            if (nome.length() <= 40 && cpf.length() == 14 && celular.length() < 26 && email.length()
                    < 45 && endereco.length() < 60 && !nome.equals("") && !cpf.equals("")
                    && !celular.equals("") && !email.equals("") && !endereco.equals("")) {
                System.out.println("cheguei");

                listaPacientes = null;
                listaPacientes = paciente.getPacientes();

                for (Paciente pac : listaPacientes) {
                    if (pac.getIdPaciente() == idPaciente) {
                        pac.setNome(nome);
                        pac.setCpf(cpf);
                        pac.setCelular(celular);
                        pac.setEmail(email);
                        pac.setEndereco(endereco);
                        pac.setAnamnese(anamnese);
                        pac.editar(pac);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro, preencha os campos corretamente");
            }
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

    public ArrayList<Paciente> pesquisar(String pesquisa) {
        if (!pesquisa.equals("")) {
            return paciente.pesquisar(pesquisa);
        } else {
            JOptionPane.showMessageDialog(null, "Você deve preencher o campo de pesquisa.");
            return null;
        }
    }
}
