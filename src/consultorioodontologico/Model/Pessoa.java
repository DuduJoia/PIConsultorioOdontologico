package consultorioodontologico.Model;

import consultorioodontologico.Dao.ModuloConexao;
import java.sql.*;
import javax.swing.JOptionPane;

public class Pessoa {

    private String nome, cpf, celular, email, endereco;
    private int idPessoa;

    public Pessoa(String nome, String cpf, String celular, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void cadastrarPessoa() {
        try {
            String sql = "INSERT INTO pessoa (nome,cpf,celular,email,endereco) VALUES ("
                    + " '" + this.getNome() + "' ,"
                    + " '" + this.getCpf() + "' ,"
                    + " '" + this.getCelular() + "' ,"
                    + " '" + this.getEmail() + "' ,"
                    + " '" + this.getEndereco() + "');";

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void editarPessoa() {
        try {
            String sql = "UPDATE pessoa SET"
                    + " nome = '" + this.getNome() + "', "
                    + " cpf = '" + this.getCpf() + "', "
                    + " celular = '" + this.getCelular() + "', "
                    + " email = '" + this.getEmail() + "', "
                    + " endereco = '" + this.getEndereco() + "'  "
                    + " where idPessoa = " + this.getIdPessoa() + ";  ";

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void pegaUltimoIdPessoa() {
        String sql = "SELECT idPessoa FROM pessoa order by idPessoa ASC";
        ResultSet rs = ModuloConexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    this.setIdPessoa(rs.getInt("idPessoa"));
                }
            } catch (Exception e) {

            }
        }
    }

    public void pegaIdPessoaEspecífico(int idPessoa) {
        String sql = "SELECT idPessoa FROM pessoa where idPessoa = " + idPessoa;
        ResultSet rs = ModuloConexao.consultar(sql);
        if (rs != null) {
            try {
                this.setIdPessoa(rs.getInt("idPessoa"));
            } catch (Exception e) {

            }
        }
    }

    public void excluirPessoa(int idPessoa) {
        try {
            String sql = "DELETE FROM pessoa WHERE idPessoa = " + this.getIdPessoa();
            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void dados() {

        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Celular: " + this.getCelular());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Endereoço: " + this.getEndereco());

    }

}
