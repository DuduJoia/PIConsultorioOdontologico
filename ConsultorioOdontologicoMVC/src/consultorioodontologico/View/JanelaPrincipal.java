/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorioodontologico.View;

import consultorioodontologico.Controller.AtendimentoController;
import consultorioodontologico.Controller.DentistaController;
import consultorioodontologico.Controller.PacienteController;
import consultorioodontologico.Controller.ProcedimentosController;
import consultorioodontologico.Dao.ModuloConexao;
import consultorioodontologico.Model.Atendimento;
import consultorioodontologico.Model.Dentista;
import consultorioodontologico.Model.Paciente;
import consultorioodontologico.Model.Procedimentos;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 182210134
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JanelaInicial
     */
    ArrayList<Dentista> ListaDentistas;
    ArrayList<Paciente> ListaPacientes;
    ArrayList<Procedimentos> ListaProcedimentos;
    ArrayList<Atendimento> ListaAtendimentos;
    
    PacienteController paciente = new PacienteController();
    DentistaController dentista = new DentistaController();
    ProcedimentosController procedimento = new ProcedimentosController();
    AtendimentoController atendimento = new AtendimentoController();
    
    FormularioPaciente FormPac = new FormularioPaciente();
    FormularioDentista FormDent = new FormularioDentista();
    FormularioProcedimentos FormPro = new FormularioProcedimentos();
    boolean secaoPaciente = true, secaoDentista, secaoProcedimento, secaoHorario;
    String usuario = "";
    
    public JanelaPrincipal() {
        initComponents();
        FormPac.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FormDent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FormPro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        atualizaTabelaPaciente();
        
    }
    
    public void transicionaTelaParaPaciente() {
        lblTitulo.setText("Pacientes");
        btnCadastrar.setVisible(true);
        btnExcluir.setVisible(true);
        btnEditar.setVisible(true);
        
        secaoPaciente = true;
        secaoDentista = false;
        secaoProcedimento = false;
        secaoHorario = false;
        atualizaTabelaPaciente();
    }
    
    public void atualizaTabelaPaciente() {
        ListaPacientes = null;
        ListaPacientes = paciente.getPacientes();
        String columnNames[] = {"Código", "Nome", "CPF", "Celular", "Email", "Endereco", "Anamnese"};
        DefaultTableModel model = (DefaultTableModel) tblDados.getModel();
        model.setRowCount(0);
        model.setColumnCount(7);
        model.setColumnIdentifiers(columnNames);
        String[] postagem = {"", "", "", "", "", "", ""};
        
        for (Paciente pac : ListaPacientes) {
            postagem[0] = String.valueOf(pac.getIdPaciente());
            postagem[1] = pac.getNome();
            postagem[2] = pac.getCpf();
            postagem[3] = pac.getCelular();
            postagem[4] = pac.getEmail();
            postagem[5] = pac.getEndereco();
            postagem[6] = pac.getAnamnese();
            
            model.addRow(postagem);
        }
    }
    
    public void transicionaTelaParaDentista() {
        lblTitulo.setText("Dentistas");
        
        if (!usuario.equals("admin")) {
            btnCadastrar.setVisible(false);
            btnExcluir.setVisible(false);
            btnEditar.setVisible(false);
        }
        
        secaoPaciente = false;
        secaoDentista = true;
        secaoProcedimento = false;
        secaoHorario = false;
        
        atualizaTabelaDentista();
    }
    
    public void atualizaTabelaDentista() {
        ListaDentistas = null;
        ListaDentistas = dentista.getDentistas();
        
        String columnNames[] = {"Código", "Nome", "Cro"};
        DefaultTableModel model = (DefaultTableModel) tblDados.getModel();
        model.setRowCount(0);
        model.setColumnCount(3);
        model.setColumnIdentifiers(columnNames);
        String[] postagem = {"", "", ""};
        for (Dentista D : ListaDentistas) {
            
            postagem[0] = String.valueOf(D.getIdDentista());
            postagem[1] = D.getNome();
            postagem[2] = D.getCro();
            
            model.addRow(postagem);
        }
    }
    
    public void transicionaTelaParaProcedimentos() {
        lblTitulo.setText("Procedimentos");
        if (!usuario.equals("admin")) {
            btnCadastrar.setVisible(false);
            btnExcluir.setVisible(false);
            btnEditar.setVisible(false);
        }
        
        secaoPaciente = false;
        secaoDentista = false;
        secaoProcedimento = true;
        secaoHorario = false;
        
        atualizaTabelaProcedimentos();
    }
    
    public void atualizaTabelaProcedimentos() {
        ListaProcedimentos = null;
        ListaProcedimentos = Procedimentos.getProcedimentos();
        
        String columnNames[] = {"Código", "Nome", "Descricao", "Valor"};
        DefaultTableModel model = (DefaultTableModel) tblDados.getModel();
        model.setRowCount(0);
        model.setColumnCount(4);
        model.setColumnIdentifiers(columnNames);
        String[] postagem = {"", "", "", ""};
        for (Procedimentos pro : ListaProcedimentos) {
            
            postagem[0] = String.valueOf(pro.getId());
            postagem[1] = pro.getNome();
            postagem[2] = pro.getDescricao();
            postagem[3] = String.valueOf(pro.getValor());
            
            model.addRow(postagem);
        }
    }
    
    public void transicionaTelaParaHorarios() {
        lblTitulo.setText("Horários");
        btnCadastrar.setVisible(true);
        btnCadastrar.setText("Agendar");
        btnExcluir.setVisible(true);
        btnEditar.setVisible(true);
        
        secaoPaciente = false;
        secaoDentista = false;
        secaoProcedimento = true;
        secaoHorario = true;
        
        atualizaTabelaHorarios();
    }
    
    public void atualizaTabelaHorarios() {
        
        String columnNames[] = {"Código", "Horário", "Data", "Paciente", "Dentista", "Procedimento", "Valor"};
        DefaultTableModel model = (DefaultTableModel) tblDados.getModel();
        model.setRowCount(0);
        model.setColumnCount(7);
        model.setColumnIdentifiers(columnNames);
        
        String tabela[] = {"", "", "", "", "", "", ""};
        String sql = "SELECT A.idAtendimento, A.horario, A.data, PP.nome AS nome_paciente, PD.nome AS nome_dentista,"
                + " PR.nome_procedimento AS procedimento, PR.valor, PAT.nome as nome_atendente, ATE.idAtendente "
                + "FROM atendimento A JOIN paciente P ON A.cod_paciente = P.idPaciente "
                + "JOIN pessoa PP ON P.cod_pessoa = PP.idPessoa JOIN dentista D ON A.cod_dentista = D.idDentista "
                + "JOIN pessoa PD ON D.cod_pessoa = PD.idPessoa JOIN procedimento PR ON A.cod_procedimento = PR.idProcedimento "
                + "JOIN Atendente ATE ON A.cod_Atendente = ATE.idAtendente JOIN Pessoa PAT ON ATE.cod_pessoa = PAT.idPessoa;";
        
        ResultSet rs = ModuloConexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    tabela[0] = rs.getString(1);
                    tabela[1] = rs.getString(2);
                    tabela[2] = rs.getString(3);
                    tabela[3] = rs.getString(4);
                    tabela[4] = rs.getString(5);
                    tabela[5] = rs.getString(6);
                    tabela[6] = rs.getString(7);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            model.addRow(tabela);
        }
    }
    
    public void CarregaUsuário(String user) {
        usuario = user;
        lblUser.setText("Usuário: " + usuario);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btnPaciente = new javax.swing.JButton();
        btnDentista = new javax.swing.JButton();
        btnHorários = new javax.swing.JButton();
        btnProcedimentos = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnPesquiar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(38, 90, 92));
        jPanel1.setForeground(new java.awt.Color(38, 90, 92));

        btnPaciente.setBackground(new java.awt.Color(38, 90, 92));
        btnPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnPaciente.setText("Paciente");
        btnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacienteActionPerformed(evt);
            }
        });

        btnDentista.setBackground(new java.awt.Color(38, 90, 92));
        btnDentista.setForeground(new java.awt.Color(255, 255, 255));
        btnDentista.setText("Dentista");
        btnDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDentistaActionPerformed(evt);
            }
        });

        btnHorários.setBackground(new java.awt.Color(38, 90, 92));
        btnHorários.setForeground(new java.awt.Color(255, 255, 255));
        btnHorários.setText("Horários");
        btnHorários.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoráriosActionPerformed(evt);
            }
        });

        btnProcedimentos.setBackground(new java.awt.Color(38, 90, 92));
        btnProcedimentos.setForeground(new java.awt.Color(255, 255, 255));
        btnProcedimentos.setText("Procedimentos");
        btnProcedimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcedimentosActionPerformed(evt);
            }
        });

        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Usuário: XXXXXX");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consultório");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnHorários, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDentista, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProcedimentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(btnPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProcedimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHorários, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUser)
                .addGap(42, 42, 42))
        );

        tblDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Celular", "Email", "Endereço", "Anamnese"
            }
        ));
        jScrollPane1.setViewportView(tblDados);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Pacientes");

        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });

        btnPesquiar.setText("Pesquisar");
        btnPesquiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquiarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar)
                        .addGap(3, 3, 3)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacienteActionPerformed
        transicionaTelaParaPaciente();
    }//GEN-LAST:event_btnPacienteActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (secaoPaciente) {
            FormPac.transicaoCadastrar();
            FormPac.setVisible(true);
        }
        if (secaoDentista) {
            FormDent.transicaoCadastrar();
            FormDent.setVisible(true);
        }
        if(secaoProcedimento){
            FormPro.transicaoCadastrar();
            FormPro.setVisible(true);
            
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDentistaActionPerformed
        transicionaTelaParaDentista();
    }//GEN-LAST:event_btnDentistaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (secaoPaciente) {
            FormPac.transicaoEditar();
            FormPac.setVisible(true);
        }
        if (secaoDentista) {
            FormDent.transicaoEditar();
            FormDent.setVisible(true);
        }
        if(secaoProcedimento){
            FormPro.transicaoEditar();
            FormPro.setVisible(true);
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(secaoPaciente){
            FormPac.transicaoExcluir();
            FormPac.setVisible(true);
        }
        if(secaoDentista){
            FormDent.transicaoExcluir();
            FormDent.setVisible(true);
        }
        if(secaoProcedimento){
            FormPro.transicaoExcluir();
            FormPro.setVisible(true);   
        }
        
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquiarActionPerformed

    private void btnProcedimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcedimentosActionPerformed
        transicionaTelaParaProcedimentos();
    }//GEN-LAST:event_btnProcedimentosActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (secaoPaciente) {
            atualizaTabelaPaciente();
        }
        if (secaoDentista) {
            atualizaTabelaDentista();
        }
        if (secaoProcedimento) {
            atualizaTabelaProcedimentos();
        }
        
        if (secaoHorario) {
            atualizaTabelaHorarios();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnHoráriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoráriosActionPerformed
        transicionaTelaParaHorarios();
    }//GEN-LAST:event_btnHoráriosActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JanelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDentista;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnHorários;
    private javax.swing.JButton btnPaciente;
    private javax.swing.JButton btnPesquiar;
    private javax.swing.JButton btnProcedimentos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTable tblDados;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
