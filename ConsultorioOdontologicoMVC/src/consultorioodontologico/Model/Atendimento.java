package consultorioodontologico.Model;

import consultorioodontologico.Dao.AtendimentoDao;
import consultorioodontologico.Dao.ModuloConexao;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Atendimento {
    
    private String horario, data;
    private int idAtendimento, codPaciente, codDentista, codAtendente, codProcedimento;
    
    public Atendimento(String horario, String data, int codigoPaciente, int codigoDentista, int codigoAtendente, int codigoProcedimento) {
        this.horario = horario;
        this.data = data;
        this.codPaciente = codigoPaciente;
        this.codDentista = codigoDentista;
        this.codAtendente = codigoAtendente;
        this.codProcedimento = codigoProcedimento;
    }
    
    public Atendimento() {
        
    }
    
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }
    
    public void setCodPaciente(int codigoPaciente) {
        this.codPaciente = codigoPaciente;
    }
    
    public void setCodDentista(int codigoDentista) {
        this.codDentista = codigoDentista;
    }
    
    public void setCodAtendente(int codigoAtendente) {
        this.codAtendente = codigoAtendente;
    }
    
    public void setCodProcedimento(int codigoProcedimento) {
        this.codProcedimento = codigoProcedimento;
    }
    
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public int getIdAtendimento() {
        return this.idAtendimento;
    }
    
    public int getCodPaciente() {
        return codPaciente;
    }
    
    public int getCodDentista() {
        return codDentista;
    }
    
    public int getCodAtendente() {
        return codAtendente;
    }
    
    public int getCodProcedimento() {
        return codProcedimento;
    }
    
    public String getHorario() {
        return horario;
    }
    
    public String getData() {
        return data;
    }
    
    public void cadastrar(Atendimento atendimento) {
        new AtendimentoDao().cadastrar(atendimento);
    }
    
    public void editarAtendimento(Atendimento atendimento) {
        new AtendimentoDao().editarAtendimento(atendimento);
    }
    
    public void ExcluirAtendimento(int idAtendimento) {
        new AtendimentoDao().ExcluirAtendimento(idAtendimento);
    }
    
    public ArrayList<Atendimento> getAtendimentos() {
        AtendimentoDao a = new AtendimentoDao();
        return a.getAtendimentos();
    }
}
