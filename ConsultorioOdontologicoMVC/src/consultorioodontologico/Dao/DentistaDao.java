/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorioodontologico.Dao;

import consultorioodontologico.Model.Dentista;
import consultorioodontologico.Model.Pessoa;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class DentistaDao extends Pessoa{
    
     private double salario;
    private String cro;
    private int idDentista;

    public DentistaDao(String nome, String cpf, String celular, String email, String endereco, double salario, String cro) {
        super(nome, cpf, celular, email, endereco);
        this.salario = salario;
        this.cro = cro;
    }
    
    public DentistaDao(){
        super("", "", "", "", "");
    }

    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public double getSalario() {
        return salario;
    }

    public String getCro() {
        return cro;
    }
    
    public void cadastrar(Dentista dentista) {
        try {
            dentista.cadastrarPessoa();
            dentista.pegaUltimoIdPessoa();

            String sql = "insert into dentista (salario,cro,cod_Pessoa) values ("
                    + "  " + dentista.getSalario() + ", "
                    + " '" + dentista.getCro() + "',  "
                    + "  " + dentista.getIdPessoa() + "); ";
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

            System.out.println(sql);

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void excluir(int idDentista) {
        try {
            String sql = "DELETE FROM dentista WHERE idDentista = " + idDentista;
            ModuloConexao.executar(sql);
            
            this.excluirPessoa(this.getIdPessoa());
            
            JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void editar(Dentista dentista) {
        try {
        dentista.editarPessoa();
        
            String sql = "UPDATE dentista SET "
                    + " salario = " + dentista.getSalario() + " , "
                    + " cro = '" + dentista.getCro() + "'  "
                    + " where Dentista = " + dentista.getIdDentista() + ";  ";
            
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");

            ModuloConexao.executar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ArrayList<Dentista> getDentistas() {
        ArrayList<Dentista> lista = new ArrayList<>();
        String sql = "SELECT p.nome,cpf,email,celular,endereco,d.idDentista,salario,cro,cod_pessoa FROM Pessoa AS p INNER JOIN dentista AS d ON (p.idPessoa = d.cod_pessoa) ORDER BY nome";
        ResultSet rs = ModuloConexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String celular = rs.getString("celular");
                    String email = rs.getString("email");
                    String endereco = rs.getString("endereco");
                    double salario = rs.getDouble("salario");
                    String cro = rs.getString("cro");
                    int idDentista = rs.getInt("idDentista");

                    Dentista Dent = new Dentista(nome, cpf, celular, email, endereco, salario, cro);
                    Dent.setIdDentista(idDentista);
                    Dent.setIdPessoa(rs.getInt("cod_pessoa"));
                    lista.add(Dent);
                }
            } catch (Exception e) {

            }
        }
        return lista;
    }

    public ArrayList<Dentista> pesquisar(String pesquisa) {
        ArrayList<Dentista> lista = new ArrayList<>();
        String sql = "SELECT d.idDentista, d.cod_pessoa, d.salario, d.cro, "
                + "p.nome, p.cpf, p.celular, p.email, p.endereco "
                + "FROM Dentista d JOIN Pessoa p ON d.cod_pessoa = p.idPessoa WHERE nome LIKE '"+pesquisa+"%'";
        ResultSet rs = ModuloConexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email");
                    String celular = rs.getString("celular");
                    String endereco = rs.getString("endereco");
                    double salario = rs.getDouble("salario");
                    String cro = rs.getString("cro");
                    int idDentista = rs.getInt("idDentista");

                    Dentista Dent = new Dentista(nome, cpf, celular, email, endereco, salario, cro);
                    Dent.setIdDentista(idDentista);
                    Dent.setIdPessoa(rs.getInt("cod_pessoa"));
                    lista.add(Dent);
                }
            } catch (Exception e) {

            }
        }
        return lista;
    }
}
