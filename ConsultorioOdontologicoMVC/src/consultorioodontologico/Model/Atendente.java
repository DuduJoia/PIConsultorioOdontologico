package consultorioodontologico.Model;

import consultorioodontologico.Dao.AtendenteDao;
import java.util.ArrayList;

public class Atendente extends Pessoa {

    private String login, senha;
    private double salario;
    private int idAtendente;

    public Atendente(String nome, String cpf, String celular, String email, String endereco, double salario, String login, String senha) {
        super(nome, cpf, celular, email, endereco);
        this.senha = senha;
        this.salario = salario;
        this.login = login;
    }
    
    public Atendente(){
        super("", "", "", "", "");
    }

    public void setIdAtendente(int idAtendente) {
        this.idAtendente = idAtendente;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIdAtendente() {
        return idAtendente;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public void dados() {
        super.dados();
        System.out.println("Salario: " + this.getSalario());
        System.out.println("Senha: " + this.getSenha());
    }

    public void cadastrar(Atendente atendente) {
        new AtendenteDao().cadastrar(atendente);

    }

    public void excluir(int idAtendente) {
        new AtendenteDao().excluir(idAtendente);
    }

    public void editar(Atendente atendente) {
        new AtendenteDao().editar(atendente);
    }

    public ArrayList<Atendente> getAtendentes() {
        AtendenteDao atendenteDao = new AtendenteDao();
        return atendenteDao.getAtendentes();
    }
    
    public ArrayList<Atendente> pesquisar(String pesquisa){
        AtendenteDao atendenteDao = new AtendenteDao();
        return atendenteDao.Pesquisar(pesquisa);
    }
    
    public boolean logar(String user, String senha){
        AtendenteDao atendenteDao = new AtendenteDao();
        boolean verificador = false;
        if(atendenteDao.logar(user, senha)){
            verificador = true;
        }
        return verificador;
    }
}
