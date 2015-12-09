/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import Classes.Conexion_Destinos;
import Classes.Destino;
import static Windows.MainWindow.conexiones;
import static Windows.MainWindow.grafo;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author Memo
 */
public class Rutas extends javax.swing.JFrame {

    /**
     * Creates new form Rutas
     */
    public Rutas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_origin = new javax.swing.JComboBox();
        cb_destiny = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Origen: ");

        jLabel2.setText("Destino: ");

        cb_origin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Show Route");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(cb_origin, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cb_destiny, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_origin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_destiny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Destino origin = (Destino) cb_origin.getSelectedItem();
        Destino destiny =  (Destino) cb_destiny.getSelectedItem();
        DijkstraShortestPath<Destino, Conexion_Destinos> dij1;

        Transformer<Conexion_Destinos, Integer> wtTransformer1 = new Transformer<Conexion_Destinos, Integer>() {
            public Integer transform(Conexion_Destinos link) {
                return link.getDistancia();
            }
        };
        dij1 = new DijkstraShortestPath(grafo, wtTransformer1);
        List<Conexion_Destinos> l = dij1.getPath(origin, destiny);
        for (int i = 0; i < conexiones.size(); i++) {
            grafo.addEdge(conexiones.get(i), conexiones.get(i).getD1(), conexiones.get(i).getD2(), EdgeType.UNDIRECTED);
        }

        Layout<Integer, String> layout = new CircleLayout(grafo);
        layout.setSize(new Dimension(550, 550));
        BasicVisualizationServer<Integer, String> visualization = new BasicVisualizationServer<Integer, String>(layout);
        visualization.setPreferredSize(new Dimension(600, 600));
        visualization.getRenderContext().setLabelOffset(20);
        visualization.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        visualization.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        JFrame frame = new JFrame("Ciudad a ver");
        frame.getContentPane().add(visualization);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (int i = 0; i < l.size(); i++) {
            grafo.addEdge(l.get(i), l.get(i).getD1(), l.get(i).getD2(), EdgeType.UNDIRECTED);
        }

        Layout<Integer, String> layout1 = new CircleLayout(grafo);
        layout1.setSize(new Dimension(550, 550));
        BasicVisualizationServer<Integer, String> visualization1 = new BasicVisualizationServer<Integer, String>(layout1);
        visualization1.setPreferredSize(new Dimension(600, 600));
        visualization1.getRenderContext().setLabelOffset(20);
        visualization1.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        visualization1.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        JFrame frame2 = new JFrame("Shortest");
        frame2.getContentPane().add(visualization1);
        frame2.pack();
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rutas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rutas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox cb_destiny;
    public static javax.swing.JComboBox cb_origin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
