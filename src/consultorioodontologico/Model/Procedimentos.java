package consultorioodontologico.Model;

import consultorioodontologico.Dao.ModuloConexao;
import consultorioodontologico.Dao.ProcedimentosDao;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Procedimentos {

    private String nome, descricao;
    private double valor;
    private int id;
    
    public Procedimentos(String nome, String descricao, double valor){
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Procedimentos() {
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public double getValor(){
        return valor;
    }
    
    public double getId(){
        return id;
    }
    
    public void dados(){
        System.out.println("Nome: "+ this.getNome());
        System.out.println("Descricao: "+ this.getDescricao());
        System.out.println("Valor: "+ this.getValor());
    }
    
    public void adicionar(Procedimentos procedimento){
        new ProcedimentosDao().adicionar(procedimento);
    }
    
    public void excluir(int idProcedimento){
        new ProcedimentosDao().excluir(idProcedimento);
    }
    
    public void editar(Procedimentos procedimento){
        new ProcedimentosDao().editar(procedimento);
    }
    
    public static ArrayList<Procedimentos> getProcedimentos(){
        ProcedimentosDao procedimentosDao = new ProcedimentosDao();
        return procedimentosDao.getProcedimentos();
    }
    
    
}
