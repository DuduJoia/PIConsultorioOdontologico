/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorioodontologico.Dao;

import consultorioodontologico.Model.Procedimentos;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    public void adicionar(Procedimentos procedimento){
        String sql = "INSERT INTO procedimento (nome_procedimento,descricao,valor) values ("
                +" '" + procedimento.getNome()          + "' ,"
                +" '" + procedimento.getDescricao()     + "' ,"
                +"  " + procedimento.getValor()         + " );";
        
        ModuloConexao.executar(sql);
        
        JOptionPane.showMessageDialog(null, "Procedimento cadastrado com sucesso");
    }
    
    public void excluir(int idProcedimento){
        String sql = "DELETE FROM procedimento where idProcedimento = " + idProcedimento;
        ModuloConexao.executar(sql);
        
        JOptionPane.showMessageDialog(null, "Procedimento Excluído com sucesso");
    }
    
    public void editar(Procedimentos procedimento){
        String sql = "UPDATE procedimento SET "
                + "nome_procedimento = '"      + procedimento.getNome()   + "', "
                + "descricao = '" + procedimento.getDescricao()   + "', "
                + "valor = "      + procedimento.getValor()   + "  "
                + "Where idProcedimento = " + procedimento.getId();
        ModuloConexao.executar(sql);
        
        JOptionPane.showMessageDialog(null, "Procedimento atualizado com sucesso");
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
