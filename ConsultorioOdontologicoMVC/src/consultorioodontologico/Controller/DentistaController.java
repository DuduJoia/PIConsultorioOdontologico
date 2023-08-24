package consultorioodontologico.Controller;

import consultorioodontologico.Model.Dentista;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DentistaController {

    ArrayList<Dentista> listaDentista = new ArrayList<>();
    Dentista dentista = new Dentista();

    public void cadastrar(String nome, String cpf, String celular, String email, String endereco, double salario, String cro) {
        try {
            if (cpf.length() == 14 && celular.length() < 15 && cro.length() == 14
                    && email != null && email.length() < 45 && endereco != null && endereco.length() > 60
                    && !nome.equals("") && !cpf.equals("") && !celular.equals("") && !email.equals("") && !endereco.equals("") && !cro.equals("")) {

                Dentista dentista = new Dentista(nome, cpf, celular, email, endereco, salario, cro);
                dentista.cadastrar(dentista);

                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editar(String nome, String cpf, String celular, String email, String endereco, double salario, String cro) {
        try {
            if (cpf.length() == 14 && celular.length() < 15 && cro.length() == 14
                    && email != null && email.length() < 45 && endereco != null && endereco.length() > 60
                    && !nome.equals("") && !cpf.equals("") && !celular.equals("") && !email.equals("") && !endereco.equals("") && !cro.equals("")) {

                Dentista dentista = new Dentista(nome, cpf, celular, email, endereco, salario, cro);
                dentista.editar(dentista);

                JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluir(int idDentista) {
        listaDentista = null;
        listaDentista = dentista.getDentistas();

        try {
            for (Dentista dent : listaDentista) {
                if (dent.getIdDentista() == idDentista) {
                    dent.excluir(idDentista);

                    JOptionPane.showMessageDialog(null, "Cadastro excluid com sucesso");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Dentista> getDentistas() {

        Dentista dentista = new Dentista();
        return dentista.getDentistas();
    }
}
