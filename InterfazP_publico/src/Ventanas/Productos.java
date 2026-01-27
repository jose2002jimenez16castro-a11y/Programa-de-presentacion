/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 59399
 */
public class Productos extends javax.swing.JFrame {

   double totalGeneral = 0.0;
    DefaultTableModel modeloCarrito;
    
  public Productos() {
        initComponents();

        modeloCarrito = new DefaultTableModel(
        new Object[][]{},
        new String[]{"Codigo", "Nombre", "Precio", "Cantidad", "Subtotal", "IVA", "Descuento", "Total Final"}
    );
    tablaCarrito.setModel(modeloCarrito);

    // Cargar productos reales desde la carpeta DatosProductos
    cargarProductosDesdeArchivos();
}

   public void cargarProductosDesdeArchivos() {
    DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de llenarla

    File carpeta = new File("DatosProductos");
    if (carpeta.exists() && carpeta.isDirectory()) {
        File[] archivos = carpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (archivos != null) {
            for (File archivo : archivos) {
                try {
                    List<String> lineas = Files.readAllLines(archivo.toPath());
                    String nombre = "", precio = "";

                    for (String linea : lineas) {
                        if (linea.startsWith("Nombre:")) {
                            nombre = linea.substring(7).trim();
                        } else if (linea.startsWith("Precio:")) {
                            precio = linea.substring(7).trim();
                        }
                    }

                    if (!nombre.isEmpty() && !precio.isEmpty()) {
                        modelo.addRow(new Object[]{nombre, "$" + precio});
                    }

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "❌ Error leyendo archivo: " + archivo.getName());
                }
            }
        }
    }
}   

    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCarrito = new javax.swing.JTable();
        tnomb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("PANEL DE PRODUCTOS Y COMPRAS DE PRODUCTOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(22, 22, 22))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, -1));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 480, 153));

        jLabel1.setText("Cantidad");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 63, -1));

        lblTotal.setText("Total");
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, -1, -1));

        jButton3.setText("Agregar producto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 172, -1));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        tablaCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo Producto", "Nombre", "Precio unitario", "Subtotal"
            }
        ));
        jScrollPane2.setViewportView(tablaCarrito);

        jLabel2.setText("Nombre");

        jLabel3.setText("Cedula");

        jLabel4.setText("Direccion o ubicacion");

        jButton4.setText("Generar factura");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Carrito cliente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tnomb, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButton4)
                .addGap(58, 58, 58))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 550, 650));

        jButton1.setText("Eliminar producto de carrito cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, -1, -1));

        jLabel7.setText("1)Presiona el producto que deses de la tabla.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel8.setText("2) Agrega la cantidad y luego a agregar producto.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel9.setText("3)En caso de equivocacion presiona el producto de carrito cliente y dale a eliminar.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel10.setText("Tabla de productos del sistema");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        jLabel11.setText("5)Generar la factura con los datos del cliente.Fin");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel12.setText("4)Por la compra de 3 productos hay descuento");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  int fila = tablaProductos.getSelectedRow();
if (fila == -1) {
    JOptionPane.showMessageDialog(this, "Selecciona un producto.");
    return;
}

String nombreSeleccionado = tablaProductos.getValueAt(fila, 0).toString();
String precioTexto = tablaProductos.getValueAt(fila, 1).toString().replace("$", "").trim();
double precio = Double.parseDouble(precioTexto);

int cantidad;
try {
    cantidad = Integer.parseInt(txtCantidad.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Cantidad inválida.");
    return;
}

File carpeta = new File("DatosProductos");
File[] archivos = carpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
String codigoProducto = null;
int stockDisponible = -1;

for (File archivo : archivos) {
    try {
        java.util.List<String> lineas = java.nio.file.Files.readAllLines(archivo.toPath());
        String nombreArchivo = "";
        for (String linea : lineas) {
            if (linea.startsWith("Nombre:")) {
                nombreArchivo = linea.replace("Nombre:", "").trim();
            }
            if (linea.startsWith("Codigo:")) {
                codigoProducto = linea.replace("Codigo:", "").trim();
            }
            if (linea.startsWith("Stock:")) {
                stockDisponible = Integer.parseInt(linea.replace("Stock:", "").trim());
            }
        }

        if (nombreArchivo.equalsIgnoreCase(nombreSeleccionado)) {
            // Validar stock
            if (stockDisponible <= 0) {
                JOptionPane.showMessageDialog(this, "⚠ El producto está agotado. No hay stock disponible.");
                return;
            }

            if (cantidad > stockDisponible) {
                JOptionPane.showMessageDialog(this, "⚠ No hay el stock necesario del producto escogido.\nStock disponible: " + stockDisponible);
                return;
            }

            break;
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error leyendo archivos.");
        return;
    }
}

if (codigoProducto == null) {
    JOptionPane.showMessageDialog(this, "⚠ No se encontró el código del producto.");
    return;
}

double subtotal = precio * cantidad;
double iva = subtotal * 0.15;
double descuento = (subtotal >= 100) ? subtotal * 0.10 : 0;
double totalFinal = subtotal + iva - descuento;

modeloCarrito.addRow(new Object[]{
    codigoProducto, nombreSeleccionado, precio, cantidad, subtotal, iva, descuento, totalFinal
});

totalGeneral += totalFinal;
lblTotal.setText("Total: $" + String.format("%.2f", totalGeneral));
        
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String cliente = txtNombreCliente.getText().trim();
    String nombre=tnomb.getText().trim();
    String direccion = txtDireccion.getText().trim();

    if (cliente.isEmpty() || direccion.isEmpty() || nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese nombre y dirección.");
        return;
    }
    
        if (!cliente.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Cedula debe contener 10 digitos");
            return;
        }
        
        if (!nombre.matches("[A-Za-z ]+")) {
        JOptionPane.showMessageDialog(null, "Nombre debe contener solo letras, no caracteres especiales.");
        return;
    }
        

    StringBuilder factura = new StringBuilder();
    factura.append("FACTURA\n");
    factura.append("Cliente: ").append(cliente).append("\n");
    factura.append("Direcci0n: ").append(direccion).append("\n\n");
    factura.append(String.format("%-10s %-25s %-10s %-10s %-10s %-10s %-10s %-10s\n",
        "Codigo", "Producto", "Precio", "Cant", "Subtot", "IVA", "Desc", "Total"));

    for (int i = 0; i < modeloCarrito.getRowCount(); i++) {
        factura.append(String.format("%-10s %-25s %-10s %-10s %-10s %-10s %-10s %-10s\n",
            modeloCarrito.getValueAt(i, 0),  // Código
            modeloCarrito.getValueAt(i, 1),  // Nombre
            modeloCarrito.getValueAt(i, 2),  // Precio
            modeloCarrito.getValueAt(i, 3),  // Cantidad
            modeloCarrito.getValueAt(i, 4),  // Subtotal
            modeloCarrito.getValueAt(i, 5),  // IVA
            modeloCarrito.getValueAt(i, 6),  // Descuento
            modeloCarrito.getValueAt(i, 7)   // Total Final
        ));
    }

    factura.append("\nTOTAL GENERAL: $").append(String.format("%.2f", totalGeneral));

    try {
        File carpeta = new File("facturas");
        if (!carpeta.exists()) carpeta.mkdir();

        File archivo = new File("facturas/" + cliente + ".txt");
        FileWriter fw = new FileWriter(archivo);
        fw.write(factura.toString());
        fw.close();

        JOptionPane.showMessageDialog(this, "Factura generada correctamente.");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar la factura: " + e.getMessage());
    }

    // ✅ Actualizar el stock usando el CÓDIGO del producto
    for (int i = 0; i < modeloCarrito.getRowCount(); i++) {
    String codigoProducto = modeloCarrito.getValueAt(i, 0).toString();
    int cantidadVendida = (int) Double.parseDouble(modeloCarrito.getValueAt(i, 3).toString());

    File archivoProducto = new File("DatosProductos/" + codigoProducto + ".txt");
    if (archivoProducto.exists()) {
        try {
            List<String> lineas = Files.readAllLines(archivoProducto.toPath());
            List<String> nuevasLineas = new ArrayList<>();
            boolean encontroStock = false;
            boolean encontroVentas = false;

            for (String linea : lineas) {
                if (linea.startsWith("Stock:")) {
                    int stockActual = Integer.parseInt(linea.replace("Stock:", "").trim());
                    int nuevoStock = stockActual - cantidadVendida;
                    nuevasLineas.add("Stock: " + nuevoStock);
                    encontroStock = true;
                } else if (linea.startsWith("Ventas:")) {
                    int ventasActual = Integer.parseInt(linea.replace("Ventas:", "").trim());
                    int nuevasVentas = ventasActual + cantidadVendida;
                    nuevasLineas.add("Ventas: " + nuevasVentas);
                    encontroVentas = true;
                } else {
                    nuevasLineas.add(linea);
                }
            }

            // Si no existía la línea de ventas, agregarla
            if (!encontroVentas) {
                nuevasLineas.add("Ventas: " + cantidadVendida);
            }

            Files.write(archivoProducto.toPath(), nuevasLineas);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "❌ Error actualizando stock/ventas de " + codigoProducto + ":\n" + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "⚠ No se encontró archivo de: " + codigoProducto);
    }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int filaSeleccionada = tablaCarrito.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Selecciona un producto en el carrito para eliminar.");
        return;
    }

    double totalFila = Double.parseDouble(tablaCarrito.getValueAt(filaSeleccionada, 7).toString());
    totalGeneral -= totalFila;

    DefaultTableModel modelo = (DefaultTableModel) tablaCarrito.getModel();
    modelo.removeRow(filaSeleccionada);

    lblTotal.setText("Total: $" + String.format("%.2f", totalGeneral));
        
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaCarrito;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField tnomb;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
