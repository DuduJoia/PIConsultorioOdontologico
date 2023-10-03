/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package consultorioodontologico.View;

import consultorioodontologico.Controller.AtendimentoController;
import consultorioodontologico.Controller.DentistaController;
import consultorioodontologico.Controller.PacienteController;
import consultorioodontologico.Controller.ProcedimentosController;
import consultorioodontologico.Model.Atendimento;
import consultorioodontologico.Model.Dentista;
import consultorioodontologico.Model.Paciente;
import consultorioodontologico.Model.Procedimentos;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class FormularioAtendimento extends javax.swing.JFrame {

    ArrayList<Dentista> listaDentistas = new DentistaController().getDentistas();
    ArrayList<Paciente> listaPacientes = new PacienteController().getPacientes();
    ArrayList<Procedimentos> listaProcedimentos = new ProcedimentosController().getProcedimentos();
    ArrayList<Atendimento> listaAtendimentos = new AtendimentoController().getAtendimentos();

    AtendimentoController atendimentoController = new AtendimentoController();
    int idPaciente = 0, idDentista = 0, idProcedimento = 0, idAtendente = 0;

    boolean modoCadastrar, modoEditar, modoExcluir;

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public FormularioAtendimento() {
        initComponents();
        carregaDentistas();
        carregaPacientes();
        carregaProcedimentos();
    }

    public void resetaArrays() {
        listaDentistas = null;
        listaPacientes = null;
        listaProcedimentos = null;
        listaAtendimentos = null;

        listaDentistas = new DentistaController().getDentistas();
        listaPacientes = new PacienteController().getPacientes();
        listaProcedimentos = new ProcedimentosController().getProcedimentos();
        listaAtendimentos = new AtendimentoController().getAtendimentos();

    }

    public void carregaAtendente(int idDoAtendente) {
        idAtendente = idDoAtendente;

    }

    public void carregaDentistas() {
        resetaArrays();

        for (Dentista d : listaDentistas) {
            cbxDentista.addItem(d.getNome());
        }
    }

    public void carregaPacientes() {
        resetaArrays();
        for (Paciente p : listaPacientes) {
            cbxPaciente.addItem(p.getNome());
        }
    }

    public void carregaProcedimentos() {
        resetaArrays();
        for (Procedimentos p : listaProcedimentos) {
            cbxProcedimento.addItem(p.getNome());
        }
    }

    public void carregaHorarios() {
        cbxHorario.removeAllItems();
        cbxHorario.addItem("Selecione");
        resetaArrays();

        for (int i = 9; i <= 20; i++) {
            cbxHorario.addItem(i + ":00");
        }
        confereHorario();
    }

    public void confereHorario() {

        for (Atendimento a : listaAtendimentos) {
            for (int i = 0; i <= cbxHorario.getItemCount(); i++) {
                if (a.getHorario().equals(cbxHorario.getItemAt(i)) && a.getData().equals(txtData.getText())) {
                    cbxHorario.removeItemAt(i);
                }
            }
        }
    }
    
    public void limpaCampos(){
        txtData.setText("01/01/2023");
        cbxPaciente.setSelectedIndex(0);
        cbxDentista.setSelectedIndex(0);
        cbxProcedimento.setSelectedIndex(0);
        cbxHorario.removeAllItems();
        cbxHorario.addItem("Selecione");
    }

    public void marcarHorario() {
        atendimentoController.cadastraAtendimento(String.valueOf(cbxHorario.getSelectedItem()), txtData.getText(), idPaciente, idDentista, idAtendente, idProcedimento);
        limpaCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        lblTitulo = new javax.swing.JLabel();
        lblPaciente = new javax.swing.JLabel();
        lblDentista = new javax.swing.JLabel();
        lblProcedimento = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        cbxDentista = new javax.swing.JComboBox<>();
        cbxProcedimento = new javax.swing.JComboBox<>();
        cbxHorario = new javax.swing.JComboBox<>();
        lblValor = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        cbxPaciente = new javax.swing.JComboBox<>();
        txtData = new javax.swing.JFormattedTextField();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Agendar horário");

        lblPaciente.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblPaciente.setText("Paciente");

        lblDentista.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblDentista.setText("Dentista");

        lblProcedimento.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblProcedimento.setText("Procedimento");

        lblData.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblData.setText("Data");

        lblHorario.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblHorario.setText("Horário");

        labelValor.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labelValor.setText("Valor");

        cbxDentista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxDentista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDentistaItemStateChanged(evt);
            }
        });
        cbxDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDentistaActionPerformed(evt);
            }
        });

        cbxProcedimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxProcedimento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProcedimentoItemStateChanged(evt);
            }
        });
        cbxProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProcedimentoActionPerformed(evt);
            }
        });

        cbxHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxHorario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxHorarioItemStateChanged(evt);
            }
        });
        cbxHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxHorarioActionPerformed(evt);
            }
        });

        lblValor.setText("R$ 00,00");

        btnLimpar.setText("Limpar");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        cbxPaciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxPaciente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPacienteItemStateChanged(evt);
            }
        });
        cbxPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPacienteActionPerformed(evt);
            }
        });

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setText("01/01/2023");
        txtData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDataFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHorario)
                        .addGap(60, 60, 60)
                        .addComponent(cbxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbxDentista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValor))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(cbxProcedimento, 0, 200, Short.MAX_VALUE))
                        .addComponent(lblProcedimento, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(lblTitulo)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaciente)
                    .addComponent(cbxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDentista)
                    .addComponent(cbxDentista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHorario, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProcedimento)
                    .addComponent(cbxProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor)
                    .addComponent(lblValor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxHorarioActionPerformed

    private void cbxDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDentistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDentistaActionPerformed

    private void cbxPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPacienteActionPerformed

    private void cbxPacienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPacienteItemStateChanged
        resetaArrays();
        for (Paciente p : listaPacientes) {
            if (p.getNome().equals(cbxPaciente.getSelectedItem())) {
                idPaciente = p.getIdPaciente();
                System.out.println(idPaciente);
            }
        }
    }//GEN-LAST:event_cbxPacienteItemStateChanged

    private void cbxHorarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxHorarioItemStateChanged
        System.out.println(cbxHorario.getSelectedItem());
    }//GEN-LAST:event_cbxHorarioItemStateChanged

    private void cbxProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProcedimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProcedimentoActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        marcarHorario();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void cbxProcedimentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProcedimentoItemStateChanged
        resetaArrays();
        for (Procedimentos p : listaProcedimentos) {
            if (p.getNome().equals(cbxProcedimento.getSelectedItem())) {
                idProcedimento = p.getId();
                lblValor.setText("R$" + p.getValor());
                System.out.println(idProcedimento);

            }
        }
    }//GEN-LAST:event_cbxProcedimentoItemStateChanged

    private void cbxDentistaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDentistaItemStateChanged
        resetaArrays();
        for (Dentista d : listaDentistas) {
            if (d.getNome().equals(cbxDentista.getSelectedItem())) {
                idDentista = d.getIdDentista();
                System.out.println(idDentista);
            }
        }
    }//GEN-LAST:event_cbxDentistaItemStateChanged

    private void txtDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFocusLost
        carregaHorarios();
    }//GEN-LAST:event_txtDataFocusLost

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
            java.util.logging.Logger.getLogger(FormularioAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioAtendimento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cbxDentista;
    private javax.swing.JComboBox<String> cbxHorario;
    private javax.swing.JComboBox<String> cbxPaciente;
    private javax.swing.JComboBox<String> cbxProcedimento;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDentista;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblProcedimento;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JFormattedTextField txtData;
    // End of variables declaration//GEN-END:variables
}
