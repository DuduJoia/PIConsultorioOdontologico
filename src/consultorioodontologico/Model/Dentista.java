package consultorioodontologico.Model;

import consultorioodontologico.Dao.DentistaDao;
import java.util.ArrayList;

public class Dentista extends Pessoa {

    private double salario;
    private String cro;
    private int idDentista;

    public Dentista(String nome, String cpf, String celular, String email, String endereco, double salario, String cro) {
        super(nome, cpf, celular, email, endereco);
        this.salario = salario;
        this.cro = cro;
    }
    
    public Dentista(){
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
        new DentistaDao().cadastrar(dentista);
    }

    public void excluir(int idDentista) {
        new DentistaDao().excluir(idDentista);
    }

    public void editar(Dentista dentista) {
        new DentistaDao().editar(dentista);
        }
    

    public ArrayList<Dentista> getDentistas() {
        DentistaDao DentistaDao = new DentistaDao();
        return DentistaDao.getDentistas();
    }
}
