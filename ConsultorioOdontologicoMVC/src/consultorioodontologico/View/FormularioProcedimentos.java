/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package consultorioodontologico.View;

import consultorioodontologico.Controller.ProcedimentosController;
import consultorioodontologico.Dao.ModuloConexao;
import consultorioodontologico.Model.Procedimentos;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class FormularioProcedimentos extends javax.swing.JFrame {
    
    ArrayList<Procedimentos> listaProcedimentos;
    Connection conexao = null;
    boolean modoExcluir, modoEditar = true, modoCadastrar;
    ProcedimentosController procedimento = new ProcedimentosController();
    int idProcedimento = 0;
    
    public FormularioProcedimentos() {
        initComponents();
        conexao = ModuloConexao.conector();
        limpaTexto();
        
        listaProcedimentos = procedimento.getProcedimentos();
        
    }
    
    public void buscaIdProcedimentos() {
        listaProcedimentos = null;
        listaProcedimentos = procedimento.getProcedimentos();
        try {
            for (Procedimentos pro : listaProcedimentos) {
                if (pro.getId() == Integer.parseInt(txtCodigoProcedimento.getText())) {
                    txtNome.setText(pro.getNome());
                    txtValor.setText(String.valueOf(pro.getValor()));
                    txtAreaDescricao.setText(pro.getDescricao());
                    
                    if (modoEditar) {
                        txtNome.setEnabled(true);
                        txtValor.setEnabled(true);
                        txtAreaDescricao.setEnabled(true);
                        
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void transicaoExcluir() {
        lblTitulo.setText("Excluir Procedimento");
        btnAtualizar.setText("Excluir");
        lblCodigoProcedimento.setVisible(true);
        txtCodigoProcedimento.setVisible(true);
        btnBuscar.setVisible(true);
        
        txtNome.setEnabled(false);
        txtValor.setEnabled(false);
        txtAreaDescricao.setEnabled(false);
        
        limpaTexto();
        
        modoExcluir = true;
        modoEditar = false;
        modoCadastrar = false;
        
    }
    
    public void transicaoEditar() {
        lblTitulo.setText("Atualizar Procedimento");
        btnAtualizar.setText("Atualizar");
        lblCodigoProcedimento.setVisible(true);
        txtCodigoProcedimento.setVisible(true);
        btnBuscar.setVisible(true);
        
        limpaTexto();
        
        txtNome.setEnabled(false);
        txtValor.setEnabled(false);
        txtAreaDescricao.setEnabled(false);
        
        modoEditar = true;
        modoExcluir = false;
        modoCadastrar = false;
    }
    
    public void transicaoCadastrar() {
        lblTitulo.setText("Cadastrar Procedimento");
        btnAtualizar.setText("Cadastrar");
        
        modoEditar = false;
        modoExcluir = false;
        modoCadastrar = true;
        
        lblCodigoProcedimento.setVisible(false);
        txtCodigoProcedimento.setVisible(false);
        btnBuscar.setVisible(false);
        
        limpaTexto();
        
        txtNome.setEnabled(true);
        txtValor.setEnabled(true);
        txtAreaDescricao.setEnabled(true);
    }
    
    public void limpaTexto() {
        txtCodigoProcedimento.setText("");
        txtNome.setText("");
        txtValor.setText("");
        txtAreaDescricao.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblCodigoProcedimento = new javax.swing.JLabel();
        txtCodigoProcedimento = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaDescricao = new javax.swing.JTextArea();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Atualizar Cadastro");

        lblCodigoProcedimento.setText("Código do Procedimento");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome");

        txtNome.setEnabled(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDescricao.setText("Descrição");

        txtValor.setEnabled(false);

        lblValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValor.setText("Valor");

        txtAreaDescricao.setColumns(20);
        txtAreaDescricao.setRows(5);
        txtAreaDescricao.setEnabled(false);
        jScrollPane2.setViewportView(txtAreaDescricao);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblCodigoProcedimento)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigoProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAtualizar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(lblTitulo)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoProcedimento)
                    .addComponent(txtCodigoProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnLimpar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscaIdProcedimentos();
        idProcedimento = Integer.parseInt(txtCodigoProcedimento.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaTexto();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (modoEditar == true) {
            procedimento.editar(txtNome.getText(), txtAreaDescricao.getText(), Double.parseDouble(txtValor.getText()), idProcedimento);
            
        } else if (modoExcluir == true) {
            procedimento.excluir(idProcedimento);
            
        } else if (modoCadastrar == true) {
            procedimento.cadastrar(txtNome.getText(), txtAreaDescricao.getText(), Double.parseDouble(txtValor.getText()));
            limpaTexto();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    /**
         * @param args the command line arguments
         */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioProcedimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioProcedimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioProcedimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioProcedimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioProcedimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigoProcedimento;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTextArea txtAreaDescricao;
    private javax.swing.JTextField txtCodigoProcedimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
