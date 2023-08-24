/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorioodontologico.Dao;

import consultorioodontologico.Model.Procedimentos;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 182210134
 */
public class ProcedimentosDao {
    
    private String nome, descricao;
    private double valor;
    private int id;
    
    public ProcedimentosDao(String nome, String descricao, double valor){
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }
    
    public ProcedimentosDao(){
        
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
        String sql = "INSERT INTO procedimentos (nome_procedimento,descricao,valor) values ("
                +" '" + procedimento.getNome()          + "' ,"
                +" '" + procedimento.getDescricao()     + "' ,"
                +"  " + procedimento.getValor()         + " );";
        
        ModuloConexao.executar(sql);
    }
    
    public void excluir(int idProcedimento){
        String sql = "DELETE FROM procedimento where idProcedimento = " + idProcedimento;
        ModuloConexao.executar(sql);
    }
    
    public void editar(Procedimentos procedimento){
        String sql = "UPDATE procedimento SET "
                + "nome_procedimento = '"      + procedimento.getNome()   + "' "
                + "descricao = '" + procedimento.getDescricao()   + "' "
                + "valor = "      + procedimento.getValor()   + "  ";
        ModuloConexao.executar(sql);
    }
    
    public ArrayList<Procedimentos> getProcedimentos(){
        ArrayList<Procedimentos> lista = new ArrayList<>();
        String sql = "SELECT idProcedimento, nome_procedimento,descricao,valor FROM procedimento";
        ResultSet rs = ModuloConexao.consultar(sql);
        if(rs !=null){
            try{
                while(rs.next()){
                    String nome = rs.getString("nome_procedimento");
                    String descricao = rs.getString("descricao");
                    double valor = rs.getDouble("valor");
                    
                    Procedimentos Proc = new Procedimentos(nome,descricao,valor);
                    Proc.setId(rs.getInt("idProcedimento"));
                    lista.add(Proc);
                }
            }catch(Exception e){
                
            }
        }
        return lista;
    }
}
