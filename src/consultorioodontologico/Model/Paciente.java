package consultorioodontologico.Model;

import consultorioodontologico.Dao.PacienteDao;
import java.util.ArrayList;

public class Paciente extends Pessoa {

    private String anamnese;
    private int idPaciente;

    public Paciente(String nome, String cpf, String celular, String email, String endereco, String anamnese) {
        super(nome, cpf, celular, email, endereco);
        this.anamnese = anamnese;
    }

    public Paciente() {
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
        new PacienteDao().cadastrar(paciente);
    }

    public void excluir(int idPaciente) {
        new PacienteDao().excluir(idPaciente);
        

    }

    public void editar(Paciente paciente) {
        new PacienteDao().editar(paciente);
    }

    public ArrayList<Paciente> getPacientes() {
        PacienteDao PacienteDao = new PacienteDao();
        
        return PacienteDao.getPacientes();
    }
}
