package consultorioodontologico.Dao;

import consultorioodontologico.Model.Paciente;
import consultorioodontologico.Model.Pessoa;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PacienteDao extends Pessoa {
    
    private String anamnese;
    private int idPaciente;
    
    public PacienteDao(String nome, String cpf, String celular, String email, String endereco, String anamnese) {
        super(nome, cpf, celular, email, endereco);
        this.anamnese = anamnese;
    }
    
    public PacienteDao() {
        super("", "", "", "", "");
    }
    
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }
    
    public String getAnamnese() {
        return anamnese;
    }
    
    public int getIdPaciente() {
        return idPaciente;
    }
    
    @Override
    public void dados() {
        super.dados();
        System.out.println("Anamnese: " + this.getAnamnese());
    }
    
    public void cadastrar(Paciente paciente) {
        try {
            paciente.cadastrarPessoa();
            paciente.pegaUltimoIdPessoa();
            
            String sql = "INSERT INTO paciente (anamnese,cod_Pessoa) VALUES ("
                    + " '" + paciente.getAnamnese() + "', "
                    + "  " + paciente.getIdPessoa() + "); ";
            ModuloConexao.executar(sql);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void excluir(int idPaciente) {
        try {
            String sql = "delete from paciente where idPaciente = " + idPaciente;
            ModuloConexao.executar(sql);
            
            this.excluirPessoa(this.getIdPessoa());
            
            JOptionPane.showMessageDialog(null, "Cadastro excluid com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void editar(Paciente paciente) {
        try {
            paciente.editarPessoa();
            
            String sql = " UPDATE paciente SET "
                    + " anamnese = '" + paciente.getAnamnese() + "'  "
                    + " where idPaciente = " + paciente.getIdPessoa() + ";  ";
            ModuloConexao.executar(sql);
            
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ArrayList<Paciente> getPacientes() {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "SELECT pes.nome,cpf,email,celular,endereco,pac.idPaciente,anamnese,cod_Pessoa FROM Pessoa AS pes INNER JOIN paciente AS pac ON (pes.idPessoa = pac.cod_pessoa)";
        ResultSet rs = ModuloConexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email");
                    String endereco = rs.getString("endereco");
                    String celular = rs.getString("celular");
                    String anamnese = rs.getString("anamnese");
                    
                    Paciente Pac = new Paciente(nome, cpf, celular, email, endereco, anamnese);
                    Pac.setIdPaciente(rs.getInt("idPaciente"));
                    Pac.setIdPessoa(rs.getInt("cod_Pessoa"));
                    lista.add(Pac);
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
}
