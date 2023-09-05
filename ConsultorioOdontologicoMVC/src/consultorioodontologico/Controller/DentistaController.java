package consultorioodontologico.Controller;

import consultorioodontologico.Model.Dentista;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DentistaController {

    ArrayList<Dentista> listaDentista = new ArrayList<>();
    Dentista dentista = new Dentista();

    public void cadastrar(String nome, String cpf, String celular, String email, String endereco, double salario, String cro) {
        try {
            if (cpf.length() == 14 && celular.length() < 15 && cro.length() <= 10
                    && !email.equals("") && email.length() < 45 && !endereco.equals("") && endereco.length() < 60
                    && !nome.equals("") && !cpf.equals("") && !celular.equals("") && !email.equals("") && !endereco.equals("") && !cro.equals("")) {

                Dentista dentista = new Dentista(nome, cpf, celular, email, endereco, salario, cro);
                dentista.cadastrar(dentista);
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro, preencha os campos corretamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editar(String nome, String cpf, String celular, String email, String endereco, double salario, String cro, int idDentista) {
        try {
            if (cpf.length() == 14 && celular.length() <= 15 && cro.length() <= 10
                    && !email.equals("") && email.length() < 45 && !endereco.equals("") && endereco.length() < 60
                    && !nome.equals("") && !cpf.equals("") && !celular.equals("") && !email.equals("") && !endereco.equals("") && !cro.equals("")) {
                listaDentista = null;
                listaDentista = dentista.getDentistas();

                for (Dentista d : listaDentista) {
                    if (d.getIdDentista() == idDentista) {
                        
                        d.setNome(nome);
                        d.setCpf(cpf);
                        d.setCelular(celular);
                        d.setEmail(email);
                        d.setEndereco(endereco);
                        d.setCro(cro);
                        d.setSalario(salario);
                        
                        d.editar(d);
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro, preencha os campos corretamente");
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
    
    public ArrayList<Dentista> pesquisar(String pesquisa){
        if(!pesquisa.equals("")){
           return dentista.pesquisar(pesquisa);
        }
        else{
            JOptionPane.showMessageDialog(null, "Você deve preencher o campo de pesquisa.");
            return null;
        }
    }
}
