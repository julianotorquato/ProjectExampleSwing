/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.energia.si.poo2.swing.view;

import br.com.energia.si.poo2.swing.controller.CursoController;
import br.com.energia.si.poo2.swing.controller.ModalidadeController;
import br.com.energia.si.poo2.swing.model.Curso;
import br.com.energia.si.poo2.swing.model.Modalidade;
import br.com.energia.si.poo2.swing.service.CursoService;
import br.com.energia.si.poo2.swing.service.ModalidadeService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juliano Torquato
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private ModalidadeController modalidadeController = new ModalidadeController();
    private CursoController cursoController = new CursoController();
    /**
     * Creates new form TelaRelatorioModalidade2
     */
    public TelaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        init();
    }
    
    private void init(){
        cursoController.carregarCurso();
        modalidadeController.carregarModalidade();
        atualizarTabelaModalidade();
        atualizarTabelaCurso();
    }
    
    
     public void atualizarTabelaModalidade(){ 
        modalidadeController.carregarModalidade();
        List<Modalidade> listModalidade = modalidadeController.getListModalidade();
        //pega o modelo da Tabela e coloca na variavel "tabela"
        DefaultTableModel tabela =
                (DefaultTableModel) this.tblModalidade.getModel();
        //insere na tabela o número de linhas que a lista tem
        tabela.setRowCount(listModalidade.size());

        //laço para inserir os dados dos objetos na Tabela
        for (int i = 0; i < listModalidade.size(); i++) {
            tabela.setValueAt(listModalidade.get(i).getId(), i, 0);
            tabela.setValueAt(listModalidade.get(i).getDescricao(), i, 1);
        }
        tblModalidade.setModel(tabela);  
    }
     
     public void atualizarTabelaCurso(){        
        cursoController.carregarCurso();
        List<Curso> listCurso = cursoController.getListCurso();
        //pega o modelo da Tabela e coloca na variavel "tabela"
        DefaultTableModel tabela =
                (DefaultTableModel) this.tblCurso.getModel();
        //insere na tabela o número de linhas que a lista tem
        tabela.setRowCount(listCurso.size());

        //laço para inserir os dados dos objetos na Tabela
        for (int i = 0; i < listCurso.size(); i++) {
            tabela.setValueAt(listCurso.get(i).getId(), i, 0);
            tabela.setValueAt(listCurso.get(i).getDescricao(), i, 1);
            tabela.setValueAt(listCurso.get(i).getModalidade().getDescricao(), i, 2);            
        }
        tblCurso.setModel(tabela);  
    }
     
     private void chamarTelaCurso(Curso curso){
        TelaCadastrarCurso tela = new TelaCadastrarCurso(null, true);           
        tela.carregarEdicao(true, curso);            
        tela.setLocationRelativeTo(this);
        tela.setVisible(true);
        atualizarTabelaCurso();
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModalidade = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Modalidade"));

        tblModalidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Descrição"
            }
        ));
        jScrollPane1.setViewportView(tblModalidade);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jButton3.setText("Novo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnExcluir)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Curso"));

        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Curso", "Modalidade"
            }
        ));
        jScrollPane2.setViewportView(tblCurso);

        jButton5.setText("Novo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("Alterar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Excluir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int linha = tblModalidade.getSelectedRow();        
        if (linha != -1) {
            int id = Integer.parseInt(tblModalidade.getValueAt(linha, 0).toString());            
            Modalidade modalidade = new ModalidadeService().getById(id);
                    
            TelaCadastrarModalidade tela = new TelaCadastrarModalidade(null, true);           
            tela.carregarEdicao(true, modalidade);            
            tela.setLocationRelativeTo(this);
            tela.setVisible(true);
            atualizarTabelaModalidade();
            
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linha = tblModalidade.getSelectedRow();      
      
        if (linha != -1) {
            int id = Integer.parseInt(tblModalidade.getValueAt(linha, 0).toString());            
            Modalidade moodalidade = new ModalidadeService().getById(id);
            
            if (moodalidade != null) {
                int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja Excluir?");
                if (confirmacao == 0) {
                    
                    new ModalidadeService().deletar(moodalidade);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!");
        }
        this.atualizarTabelaModalidade();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TelaCadastrarModalidade tela = new TelaCadastrarModalidade(this, true);
        tela.setLocationRelativeTo(this);
        tela.setVisible(true);        
        atualizarTabelaModalidade();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       int linha = tblCurso.getSelectedRow();        
        if (linha != -1) {
            int id = Integer.parseInt(tblCurso.getValueAt(linha, 0).toString());            
            Curso curso = new CursoService().getById(id);
                    
           chamarTelaCurso(curso);
            
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        TelaCadastrarCurso tela = new TelaCadastrarCurso(this, true);
        tela.setLocationRelativeTo(this);
        tela.setVisible(true);
        atualizarTabelaCurso();
        
                

        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int linha = tblCurso.getSelectedRow();      
      
        if (linha != -1) {
            int id = Integer.parseInt(tblCurso.getValueAt(linha, 0).toString());            
            Curso curso = new CursoService().getById(id);
            
            if (curso != null) {
                int confirmacao = JOptionPane.showConfirmDialog(this, "Deseja Excluir?");
                if (confirmacao == 0) {
                    
                    new CursoService().deletar(curso);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha!");
        }
        this.atualizarTabelaCurso();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCurso;
    private javax.swing.JTable tblModalidade;
    // End of variables declaration//GEN-END:variables
}
