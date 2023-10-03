/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package consultorioodontologico.View;

import consultorioodontologico.Controller.PacienteController;
import consultorioodontologico.Dao.ModuloConexao;
import consultorioodontologico.Model.Paciente;
import java.sql.*;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo
 */
public class FormularioPaciente extends javax.swing.JFrame {

    ArrayList<Paciente> listaPacientes;
    Connection conexao = null;
    boolean modoExcluir, modoEditar = true, modoCadastrar;
    PacienteController paciente = new PacienteController();
    int idPaciente = 0;

    public FormularioPaciente() {
        initComponents();
        conexao = ModuloConexao.conector();
        limpaTexto();

        listaPacientes = paciente.getPacientes();

    }

    public void buscaIdPacientes() {
        listaPacientes = null;
        listaPacientes = paciente.getPacientes();
        try {
            for (Paciente pac : listaPacientes) {
                if (pac.getIdPaciente() == Integer.parseInt(txtCodigoPaciente.getText())) {
                    txtNome.setText(pac.getNome());
                    txtCpf.setText(pac.getCpf());
                    txtCelular.setText(pac.getCelular());
                    txtEmail.setText(pac.getEmail());
                    txtEndereco.setText(pac.getEndereco());
                    txtAreaAnamnese.setText(pac.getAnamnese());

                    if (modoEditar) {
                        txtNome.setEnabled(true);
                        txtCpf.setEnabled(true);
                        txtCelular.setEnabled(true);
                        txtEmail.setEnabled(true);
                        txtEndereco.setEnabled(true);
                        txtAreaAnamnese.setEnabled(true);

                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void transicaoExcluir() {
        lblTitulo.setText("Excluir Paciente");
        btnAtualizar.setText("Excluir");
        lblCodigoPaciente.setVisible(true);
        txtCodigoPaciente.setVisible(true);
        btnBuscar.setVisible(true);

        txtNome.setEnabled(false);
        txtCpf.setEnabled(false);
        txtCelular.setEnabled(false);
        txtEmail.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtAreaAnamnese.setEnabled(false);

        limpaTexto();

        modoExcluir = true;
        modoEditar = false;
        modoCadastrar = false;

    }

    public void transicaoEditar() {
        lblTitulo.setText("Atualizar Paciente");
        btnAtualizar.setText("Atualizar");
        lblCodigoPaciente.setVisible(true);
        txtCodigoPaciente.setVisible(true);
        btnBuscar.setVisible(true);

        limpaTexto();

        txtNome.setEnabled(false);
        txtCpf.setEnabled(false);
        txtCelular.setEnabled(false);
        txtEmail.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtAreaAnamnese.setEnabled(false);

        modoEditar = true;
        modoExcluir = false;
        modoCadastrar = false;
    }

    public void transicaoCadastrar() {
        lblTitulo.setText("Cadastrar Paciente");
        btnAtualizar.setText("Cadastrar");

        modoEditar = false;
        modoExcluir = false;
        modoCadastrar = true;

        lblCodigoPaciente.setVisible(false);
        txtCodigoPaciente.setVisible(false);
        btnBuscar.setVisible(false);

        limpaTexto();

        txtNome.setEnabled(true);
        txtCpf.setEnabled(true);
        txtCelular.setEnabled(true);
        txtEmail.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtAreaAnamnese.setEnabled(true);
    }

    public void limpaTexto() {
        txtCodigoPaciente.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        txtEndereco.setText("");
        txtAreaAnamnese.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBordaVermelha = new javax.swing.JTextField();
        txtBordaPreta = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblCodigoPaciente = new javax.swing.JLabel();
        txtCodigoPaciente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblAnamnese = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaAnamnese = new javax.swing.JTextArea();
        btnAtualizar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        txtBordaVermelha.setText("jTextField1");

        txtBordaPreta.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setText("Atualizar Cadastro");

        lblCodigoPaciente.setText("Código do Paciente");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome");

        txtNome.setEnabled(false);
        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeKeyTyped(evt);
            }
        });

        lblCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCpf.setText("CPF");

        txtCpf.setEnabled(false);

        lblCelular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCelular.setText("Celular");

        txtCelular.setEnabled(false);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmail.setText("Email");

        txtEmail.setEnabled(false);
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setText("Endereço");

        txtEndereco.setEnabled(false);
        txtEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEnderecoKeyTyped(evt);
            }
        });

        lblAnamnese.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAnamnese.setText("Anamnese");

        txtAreaAnamnese.setColumns(20);
        txtAreaAnamnese.setRows(5);
        txtAreaAnamnese.setEnabled(false);
        txtAreaAnamnese.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaAnamneseKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtAreaAnamnese);

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
                        .addComponent(lblCodigoPaciente)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAtualizar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblAnamnese, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane2))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(lblTitulo)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoPaciente)
                    .addComponent(txtCodigoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCelular)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAnamnese)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnLimpar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscaIdPacientes();
        idPaciente = Integer.parseInt(txtCodigoPaciente.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaTexto();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (modoEditar == true) {
            paciente.editarPaciente(txtNome.getText(), txtCpf.getText(),
                    txtCelular.getText(), txtEmail.getText(), txtEndereco.getText(),
                    txtAreaAnamnese.getText(), idPaciente);
            limpaTexto();

        } else if (modoExcluir == true) {
            paciente.excluirPaciente(idPaciente);
            limpaTexto();

        } else if (modoCadastrar == true) {
            if (paciente.cadastrarPaciente(txtNome.getText(), txtCpf.getText(),
                    txtCelular.getText(), txtEmail.getText(), txtEndereco.getText(), txtAreaAnamnese.getText())) {
                limpaTexto();
            }
        }

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
        txtNome.setBorder(txtBordaVermelha.getBorder());
        txtNome.repaint();
    }//GEN-LAST:event_txtNomeFocusLost

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) || txtCelular.getText().length() == 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyTyped
        char c = evt.getKeyChar();

        if (txtNome.getText().length() == 40) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNomeKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        char c = evt.getKeyChar();

        if (txtEmail.getText().length() == 45) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEnderecoKeyTyped
        char c = evt.getKeyChar();

        if (txtEndereco.getText().length() == 60) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEnderecoKeyTyped

    private void txtAreaAnamneseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaAnamneseKeyTyped
        char c = evt.getKeyChar();

        if (txtAreaAnamnese.getText().length() == 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAreaAnamneseKeyTyped

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
            java.util.logging.Logger.getLogger(FormularioPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAnamnese;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCodigoPaciente;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtAreaAnamnese;
    private javax.swing.JTextField txtBordaPreta;
    private javax.swing.JTextField txtBordaVermelha;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodigoPaciente;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
