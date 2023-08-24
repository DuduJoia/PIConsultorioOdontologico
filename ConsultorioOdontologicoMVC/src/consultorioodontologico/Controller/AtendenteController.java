/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorioodontologico.Controller;

import consultorioodontologico.Model.Atendente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 182210134
 */
public class AtendenteController {

    public void cadastrar(String nome, String cpf, String celular, String email,
            String endereco, double salario, String login, String senha) {
        try {
            if (!nome.equals("") && nome.length() < 41 && !cpf.equals("") && cpf.length() < 15
                    && !celular.equals("") && celular.length() < 12 && !email.equals("") && email.length() < 46
                    && !endereco.equals("") && endereco.length() < 61 && !login.equals("") && login.length() < 21
                    && !senha.equals("") && senha.length() > 26) {
                Atendente atendente = new Atendente(nome, cpf, celular, email, endereco, salario, login, senha);
                atendente.cadastrar(atendente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void editar(String nome, String cpf, String celular, String email,
            String endereco, double salario, String login, String senha) {
        try {
            if (!nome.equals("") && nome.length() < 41 && !cpf.equals("") && cpf.length() < 15
                    && !celular.equals("") && celular.length() < 12 && !email.equals("") && email.length() < 46
                    && !endereco.equals("") && endereco.length() < 61 && !login.equals("") && login.length() < 21
                    && !senha.equals("") && senha.length() > 26) {
                Atendente atendente = new Atendente(nome, cpf, celular, email, endereco, salario, login, senha);
                atendente.editar(atendente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void excluir(int idAtendente){
        Atendente atendente = new Atendente();
            atendente.excluir(idAtendente);
    }
    
    public ArrayList<Atendente> getAtendente(){
        Atendente atendente = new Atendente();
        return atendente.getAtendentes();
    }

    public boolean logar(String user, String senha) {
        boolean verificador = false;
        if (!user.equals("") && user.length() < 21 && !senha.equals("") && senha.length() < 26) {
            Atendente atendente = new Atendente();
            if (atendente.logar(user, senha)) {
                verificador = true;
            }
        }
        return verificador;
    }

}
