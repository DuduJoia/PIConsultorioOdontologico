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

    ArrayList<Atendente> listaAtendentes = new ArrayList<>();
    Atendente atendente = new Atendente();

    public boolean cadastrar(String nome, String cpf, String celular, String email,
            String endereco, double salario, String login, String senha) {
            if (!nome.equals("") && nome.length() < 41 && !cpf.equals("") && cpf.length() < 15
                    && !celular.equals("") && celular.length() < 12 && !email.equals("") && email.length() < 46
                    && !endereco.equals("") && endereco.length() < 61 && !login.equals("") && login.length() < 21
                    && !login.equals("admin") && !senha.equals("") && senha.length() < 26) {
                Atendente atendente = new Atendente(nome, cpf, celular, email, endereco, salario, login, senha);
                atendente.cadastrar(atendente);
                
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
                return false;
            }
    }

    public void editar(String nome, String cpf, String celular, String email,
            String endereco, double salario, String login, String senha, int idAtendente) {
        try {
            if (!nome.equals("") && nome.length() < 41 && !cpf.equals("") && cpf.length() < 15
                    && !celular.equals("") && celular.length() < 12 && !email.equals("") && email.length() < 46
                    && !endereco.equals("") && endereco.length() < 61 && !login.equals("") && login.length() < 21
                    && !login.equals("admin") && !senha.equals("") && senha.length() < 26) {
                listaAtendentes = null;
                listaAtendentes = atendente.getAtendentes();

                for (Atendente a : listaAtendentes) {
                    if (a.getIdAtendente() == idAtendente) {
                        a.setNome(nome);
                        a.setCpf(cpf);
                        a.setCelular(celular);
                        a.setEmail(email);
                        a.setEndereco(endereco);
                        a.setSalario(salario);
                        a.setLogin(login);
                        a.setSenha(senha);

                        a.editar(a);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluir(int idAtendente) {
        Atendente atendente = new Atendente();
        atendente.excluir(idAtendente);
    }

    public ArrayList<Atendente> getAtendentes() {
        Atendente atendente = new Atendente();
        return atendente.getAtendentes();
    }

    public ArrayList<Atendente> Pesquisar(String pesquisa) {
        if (!pesquisa.equals("")) {
            Atendente atendente = new Atendente();
            return atendente.pesquisar(pesquisa);
        } else {
            JOptionPane.showMessageDialog(null, "Você deve preencher o campo de pesquisa");
            return null;
        }
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
