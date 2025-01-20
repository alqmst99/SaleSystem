/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.ClienteDAO;
import DAO.ProductoDAO;
import DAO.ProveedorDAO;
import DAO.VentasDAO;
import Model.Cliente;
import Model.Config;
import Model.Detalle;
import Model.Eventos;
import Model.Producto;
import Model.Proveedor;
import Model.Ventas;
import Report.Excel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;


import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Nahuel Pierini
 */
public class System extends javax.swing.JFrame {

    //Inicialize Client and ClientDAO
    Cliente cl = new Cliente();
    ClienteDAO client = new ClienteDAO();
    Proveedor pr = new Proveedor();
    ProveedorDAO prov = new ProveedorDAO();
    Producto prod = new Producto();
    ProductoDAO pro = new ProductoDAO();
    Ventas ven = new Ventas();
    VentasDAO v = new VentasDAO();
    Detalle dv = new Detalle();
    Config conf = new Config();
    Eventos event= new Eventos();
    
    
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel tmp = new DefaultTableModel();

    int item;
    double totalPagar = 0.0;

    //get Lista clientes
    public void ListarCliente() {
        //list clients 
        List<Cliente> ListarCl = client.ListaCliente();
        //create model for table
        modelo = (DefaultTableModel) tableClients.getModel();
        Object[] ob = new Object[6];
        //Charge list int the table, using for
        for (int i = 0; i < ListarCl.size(); i++) {
            ob[0] = ListarCl.get(i).getId();
            ob[1] = ListarCl.get(i).getDni();
            ob[2] = ListarCl.get(i).getNombre();
            ob[3] = ListarCl.get(i).getTelefono();
            ob[4] = ListarCl.get(i).getDireccion();
            ob[5] = ListarCl.get(i).getRazon();
            modelo.addRow(ob);
        }
        tableClients.setModel(modelo);
    }

    public void ListarProveedor() {
        //list provider
        List<Proveedor> ListarPr = prov.ListaProveedor();
        //create model for table
        modelo = (DefaultTableModel) tableProviders.getModel();
        Object[] ob = new Object[6];
        //Charge list int the table, using for
        for (int i = 0; i < ListarPr.size(); i++) {
            ob[0] = ListarPr.get(i).getId();
            ob[1] = ListarPr.get(i).getCuit();
            ob[2] = ListarPr.get(i).getNombre();
            ob[3] = ListarPr.get(i).getTelefono();
            ob[4] = ListarPr.get(i).getDireccion();
            ob[5] = ListarPr.get(i).getRazon();
            modelo.addRow(ob);
        }
        tableProviders.setModel(modelo);
    }

    public void ListarProductos() {
        //list provider
        List<Producto> ListarProd = pro.ListaProducto();
        //create model for table
        modelo = (DefaultTableModel) tableProducts.getModel();
        Object[] ob = new Object[6];
        //Charge list int the table, using for
        for (int i = 0; i < ListarProd.size(); i++) {
            ob[0] = ListarProd.get(i).getId();
            ob[1] = ListarProd.get(i).getCodigo();
            ob[2] = ListarProd.get(i).getNombre();
            ob[3] = ListarProd.get(i).getProveedor();
            ob[4] = ListarProd.get(i).getStock();
            ob[5] = ListarProd.get(i).getPrecio();
            modelo.addRow(ob);
        }
        tableProducts.setModel(modelo);
    }
    
    
    public void ListarVentas() {
        //list provider
        List<Ventas> ListarVent = v.ListaVentas();
        //create model for table
        modelo = (DefaultTableModel) tableResumeSolds.getModel();
        Object[] ob = new Object[6];
        //Charge list int the table, using for
        for (int i = 0; i < ListarVent.size(); i++) {
            ob[0] = ListarVent.get(i).getId();
            ob[1] = ListarVent.get(i).getCliente();
            ob[2] = ListarVent.get(i).getVendedor();
            ob[3] = ListarVent.get(i).getTotal();
            modelo.addRow(ob);
        }
        tableResumeSolds.setModel(modelo);
    }

    //Limpiar tabla
    public void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;

        }
    }

    /**
     * Creates new form System
     */
    public System() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdClient.setVisible(false);
        txtIdSolds.setVisible(false);
        txtIdProd.setVisible(false);
        txtIdProv.setVisible(false);
        txtIdPROD.setVisible(false);
        txtIdConf.setVisible(false);
        AutoCompleteDecorator.decorate(cbxProd);
        pro.CosultaProveedor(cbxProd);
        ListarConfig();

        
 
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        LabelVendedor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtCodeSold = new javax.swing.JTextField();
        txtDescSold = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAmountSold = new javax.swing.JTextField();
        txtPriceSold = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStockAvail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnDeleteSold = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSolds = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNameClientSold = new javax.swing.JTextField();
        txtCUITClientSold = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnGenerateSold = new javax.swing.JButton();
        txtPhoneCV = new javax.swing.JLabel();
        txtAddressCV = new javax.swing.JLabel();
        txtRazonCV = new javax.swing.JLabel();
        txtIdPROD = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDNIClient = new javax.swing.JTextField();
        txtNameClient = new javax.swing.JTextField();
        txtPhoneClient = new javax.swing.JTextField();
        txtAddressClient = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableClients = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtRazonClient = new javax.swing.JTextField();
        btnSaveClient = new javax.swing.JButton();
        btnUpdateClient = new javax.swing.JButton();
        btnDeleteClient = new javax.swing.JButton();
        btnNewClient = new javax.swing.JButton();
        txtIdClient = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtExcelProv = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btnSaveProv = new javax.swing.JButton();
        btnUpdateProv = new javax.swing.JButton();
        btnDeleteProv = new javax.swing.JButton();
        btnNewProv = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProviders = new javax.swing.JTable();
        txtCUITProv = new javax.swing.JTextField();
        txtNameProv = new javax.swing.JTextField();
        txtPhoneProv = new javax.swing.JTextField();
        txtAddressProv = new javax.swing.JTextField();
        txtRazonProv = new javax.swing.JTextField();
        txtIdProv = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtCodeProd = new javax.swing.JTextField();
        txtDescProd = new javax.swing.JTextField();
        txtStockProd = new javax.swing.JTextField();
        txtPriceProd = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnSaveProd = new javax.swing.JButton();
        btnUpdateProd = new javax.swing.JButton();
        btnDeleteProd = new javax.swing.JButton();
        btnNewProd = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        cbxProd = new javax.swing.JComboBox<>();
        btnExcelProd = new javax.swing.JButton();
        txtIdProd = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableResumeSolds = new javax.swing.JTable();
        btnPDFSolds = new javax.swing.JButton();
        txtIdSolds = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtCuitConf = new javax.swing.JTextField();
        txtNameConf = new javax.swing.JTextField();
        txtPhoneConf = new javax.swing.JTextField();
        txtAdressConf = new javax.swing.JTextField();
        txtRazonConfig = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btnUpdateConf = new javax.swing.JButton();
        txtIdConf = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1231, 640));
        setPreferredSize(new java.awt.Dimension(1240, 650));
        setSize(new java.awt.Dimension(1231, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nventa.png"))); // NOI18N
        jButton1.setText("New Sale");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        jButton2.setText("Client");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/proveedor.png"))); // NOI18N
        jButton3.setText("Provider");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        jButton4.setText("Products");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/compras.png"))); // NOI18N
        jButton5.setText("Sales");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config.png"))); // NOI18N
        jButton6.setText("Settings");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo-fst.png"))); // NOI18N

        LabelVendedor.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        LabelVendedor.setText("FSTailSolutions");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelVendedor)
                .addGap(14, 14, 14)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 600));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/encabezado.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1000, 180));

        txtCodeSold.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeSoldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeSoldKeyTyped(evt);
            }
        });

        txtDescSold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescSoldActionPerformed(evt);
            }
        });
        txtDescSold.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescSoldKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Description");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Code");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Amount");

        txtAmountSold.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAmountSoldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmountSoldKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel6.setText("Price");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setText("Stock Available");

        btnDeleteSold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnDeleteSold.setBorder(null);
        btnDeleteSold.setBorderPainted(false);
        btnDeleteSold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSoldActionPerformed(evt);
            }
        });

        tableSolds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "DESCRIPTION", "AMOUNT", "PRICE", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tableSolds);
        if (tableSolds.getColumnModel().getColumnCount() > 0) {
            tableSolds.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableSolds.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableSolds.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableSolds.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableSolds.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("DNI/CUIT");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel9.setText("NAME");

        txtCUITClientSold.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCUITClientSoldKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("-----");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N
        jLabel11.setText("Total to Pay");

        btnGenerateSold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print.png"))); // NOI18N
        btnGenerateSold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateSoldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodeSold, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescSold, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(txtAmountSold))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPriceSold, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(txtStockAvail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdPROD, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnDeleteSold, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCUITClientSold, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNameClientSold, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(txtPhoneCV, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAddressCV, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRazonCV, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addComponent(btnGenerateSold)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel10)
                        .addGap(162, 162, 162)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdPROD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCodeSold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDescSold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAmountSold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPriceSold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStockAvail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7)
                    .addComponent(btnDeleteSold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnGenerateSold)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCUITClientSold, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(txtNameClientSold)
                            .addComponent(txtPhoneCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddressCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRazonCV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("New Sale", jPanel2);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("DNI/CUIT");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Name");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Phone");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Address");

        txtDNIClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIClientActionPerformed(evt);
            }
        });

        tableClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI/CUIT", "NAME", "PHONE", "ADDRESS", "RAZON"
            }
        ));
        tableClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableClients);
        if (tableClients.getColumnModel().getColumnCount() > 0) {
            tableClients.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableClients.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableClients.getColumnModel().getColumn(3).setPreferredWidth(40);
            tableClients.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableClients.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("Company Name");

        txtRazonClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonClientActionPerformed(evt);
            }
        });

        btnSaveClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnSaveClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveClientActionPerformed(evt);
            }
        });

        btnUpdateClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnUpdateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateClientActionPerformed(evt);
            }
        });

        btnDeleteClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnDeleteClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClientActionPerformed(evt);
            }
        });

        btnNewClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        btnNewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSaveClient)
                        .addGap(22, 22, 22)
                        .addComponent(btnUpdateClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteClient)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNewClient))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtDNIClient, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addComponent(txtNameClient, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(txtPhoneClient)
                            .addComponent(txtAddressClient)
                            .addComponent(txtRazonClient))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIdClient, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtIdClient, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(txtDNIClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(txtNameClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel14))
                                    .addComponent(txtPhoneClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(jLabel15))
                            .addComponent(txtAddressClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtRazonClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdateClient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteClient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveClient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewClient, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(44, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Client", jPanel3);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("CUIT");

        txtExcelProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel.png"))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("Name");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel19.setText("Phone");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel20.setText("Address");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setText("Company Name");

        btnSaveProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnSaveProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProvActionPerformed(evt);
            }
        });

        btnUpdateProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnUpdateProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProvActionPerformed(evt);
            }
        });

        btnDeleteProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnDeleteProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProvActionPerformed(evt);
            }
        });

        btnNewProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N

        tableProviders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CUIT", "NAME", "PHONE", "ADDRESS", "COMPANY NAME"
            }
        ));
        tableProviders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProvidersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableProviders);
        if (tableProviders.getColumnModel().getColumnCount() > 0) {
            tableProviders.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableProviders.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableProviders.getColumnModel().getColumn(3).setPreferredWidth(40);
            tableProviders.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableProviders.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        txtCUITProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCUITProvActionPerformed(evt);
            }
        });

        txtRazonProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonProvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSaveProv)
                        .addGap(22, 22, 22)
                        .addComponent(btnUpdateProv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteProv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNewProv)
                        .addGap(18, 18, 18)
                        .addComponent(txtExcelProv, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCUITProv, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameProv)
                            .addComponent(txtPhoneProv)
                            .addComponent(txtAddressProv)
                            .addComponent(txtRazonProv, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(txtIdProv, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel16)
                                            .addComponent(txtCUITProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel18)
                                            .addComponent(txtNameProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel19))
                                    .addComponent(txtPhoneProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(jLabel20))
                            .addComponent(txtAddressProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtRazonProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdateProv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteProv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveProv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNewProv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExcelProv, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(52, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Provider", jPanel4);

        txtCodeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeProdActionPerformed(evt);
            }
        });

        txtPriceProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceProdKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setText("Provider");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel23.setText("Price");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel24.setText("Stock");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel25.setText("Description");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel26.setText("Code");

        btnSaveProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnSaveProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProdActionPerformed(evt);
            }
        });

        btnUpdateProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnUpdateProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProdActionPerformed(evt);
            }
        });

        btnDeleteProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnDeleteProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProdActionPerformed(evt);
            }
        });

        btnNewProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODE", "DESCRIPTION", "PROVIDER", "STOCK", "PRICE"
            }
        ));
        tableProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableProducts);
        if (tableProducts.getColumnModel().getColumnCount() > 0) {
            tableProducts.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableProducts.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableProducts.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableProducts.getColumnModel().getColumn(4).setPreferredWidth(40);
            tableProducts.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        cbxProd.setEditable(true);

        btnExcelProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel.png"))); // NOI18N
        btnExcelProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSaveProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateProd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCodeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescProd, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addComponent(txtStockProd)
                        .addComponent(txtPriceProd)
                        .addComponent(cbxProd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnDeleteProd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcelProd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26)
                                    .addComponent(txtCodeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(txtDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jLabel24))
                            .addComponent(txtStockProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel23))
                    .addComponent(txtPriceProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cbxProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcelProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIdProd, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Products", jPanel5);

        tableResumeSolds.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENT", "VENDOR", "TOTAL"
            }
        ));
        tableResumeSolds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableResumeSoldsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableResumeSolds);
        if (tableResumeSolds.getColumnModel().getColumnCount() > 0) {
            tableResumeSolds.getColumnModel().getColumn(1).setPreferredWidth(60);
            tableResumeSolds.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableResumeSolds.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        btnPDFSolds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnPDFSolds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFSoldsActionPerformed(evt);
            }
        });

        txtIdSolds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdSoldsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 103, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnPDFSolds)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdSolds, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPDFSolds, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdSolds, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Sales", jPanel6);

        txtCuitConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuitConfActionPerformed(evt);
            }
        });

        txtRazonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonConfigActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setText("Company Name");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel28.setText("Address");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel29.setText("Phone");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel30.setText("Name");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel31.setText("DNI/CUIT");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel33.setText("Company Information");

        btnUpdateConf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnUpdateConf.setText("UPDATE");
        btnUpdateConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateConfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAdressConf, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(124, 124, 124)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtRazonConfig)
                                    .addComponent(txtNameConf)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUpdateConf, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtCuitConf, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPhoneConf)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(196, 196, 196))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(jLabel33))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtIdConf, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 470, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(txtIdConf, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCuitConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRazonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdressConf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(btnUpdateConf)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Settings", jPanel7);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 1000, 420));

        jPanel8.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1230, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1230, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        jTabbedPane1.setSelectedIndex(4);
        
        LimpiarTabla();
         ListarVentas();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtDescSoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescSoldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescSoldActionPerformed

    private void txtDNIClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIClientActionPerformed

    private void txtRazonClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonClientActionPerformed

    private void txtCUITProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCUITProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCUITProvActionPerformed

    private void txtRazonProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonProvActionPerformed

    private void txtCodeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeProdActionPerformed

    private void txtCuitConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuitConfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuitConfActionPerformed

    private void txtRazonConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonConfigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonConfigActionPerformed

    private void btnUpdateConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateConfActionPerformed
        // Update Setting Company
        if (!"".equals(txtCuitConf.getText()) || !"".equals(txtNameConf.getText()) || !"".equals(txtPhoneConf.getText()) || !"".equals(txtAdressConf.getText())) {
                //Save data client

                conf.setCuit(Integer.parseInt(txtCuitConf.getText()));
                conf.setNombre(txtNameConf.getText());
                conf.setTelefono(Integer.parseInt(txtPhoneConf.getText()));
                conf.setDireccion(txtAdressConf.getText());
                conf.setRazon(txtRazonConfig.getText());
                conf.setId(Integer.parseInt(txtIdConf.getText()));

                pro.actualizarDatos(conf);
              ListarConfig();
               
                JOptionPane.showMessageDialog(null, "La compania a sido Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        
    }//GEN-LAST:event_btnUpdateConfActionPerformed

    private void btnSaveClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveClientActionPerformed
        //
        if (!"".equals(txtDNIClient.getText()) || !"".equals(txtNameClient.getText()) || !"".equals(txtAddressClient.getText())) {
            //Save data client
            cl.setDni(Integer.parseInt(txtDNIClient.getText()));
            cl.setNombre(txtNameClient.getText());
            cl.setTelefono(Integer.parseInt(txtPhoneClient.getText()));
            cl.setDireccion(txtAddressClient.getText());
            cl.setRazon(txtRazonClient.getText());
            client.RegistroCliente(cl);
            LimpiarTabla();
            ListarCliente();
            JOptionPane.showMessageDialog(null, "El cliente a sido Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnSaveClientActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Call ListarCliente
        LimpiarTabla();
        ListarCliente();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientsMouseClicked
        //Select content table and charge in the fields 
        int fila = tableClients.rowAtPoint(evt.getPoint());
        txtIdClient.setText(tableClients.getValueAt(fila, 0).toString());
        txtDNIClient.setText(tableClients.getValueAt(fila, 1).toString());
        txtNameClient.setText(tableClients.getValueAt(fila, 2).toString());
        txtPhoneClient.setText(tableClients.getValueAt(fila, 3).toString());
        txtAddressClient.setText(tableClients.getValueAt(fila, 4).toString());
        txtRazonClient.setText(tableClients.getValueAt(fila, 5).toString());

    }//GEN-LAST:event_tableClientsMouseClicked

    private void btnDeleteClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClientActionPerformed
        //Delete event
        if (!"".equals(txtDNIClient.getText()) || !"".equals(txtNameClient.getText()) || !"".equals(txtAddressClient.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el clinete?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdClient.getText());
                client.EliminarCliente(id);

                JOptionPane.showMessageDialog(null, "El cliente a sido Eliminado");
                LimpiarTabla();
                LimpiarCliente();
                ListarCliente();
            }
        }
    }//GEN-LAST:event_btnDeleteClientActionPerformed

    private void btnUpdateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateClientActionPerformed
        //Update clients
        if ("".equals(txtIdClient.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtDNIClient.getText()) || !"".equals(txtNameClient.getText()) || !"".equals(txtAddressClient.getText())) {
                //Save data client

                cl.setDni(Integer.parseInt(txtDNIClient.getText()));
                cl.setNombre(txtNameClient.getText());
                cl.setTelefono(Integer.parseInt(txtPhoneClient.getText()));
                cl.setDireccion(txtAddressClient.getText());
                cl.setRazon(txtRazonClient.getText());
                cl.setId(Integer.parseInt(txtIdClient.getText()));

                client.actualizarCliente(cl);
                LimpiarTabla();
                LimpiarCliente();
                ListarCliente();
                JOptionPane.showMessageDialog(null, "El cliente a sido Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnUpdateClientActionPerformed

    private void btnNewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewClientActionPerformed
        LimpiarCliente();
    }//GEN-LAST:event_btnNewClientActionPerformed

    private void btnSaveProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProvActionPerformed
        // Create provider 
        if (!"".equals(txtCUITProv.getText()) || !"".equals(txtNameProv.getText()) || !"".equals(txtAddressProv.getText())) {
            //Save data provider
            pr.setCuit(Integer.parseInt(txtCUITProv.getText()));
            pr.setNombre(txtNameProv.getText());
            pr.setTelefono(Integer.parseInt(txtPhoneProv.getText()));
            pr.setDireccion(txtAddressProv.getText());
            pr.setRazon(txtRazonProv.getText());
            prov.RegistroProv(pr);
            ListarProveedor();
            LimpiarTabla();

            JOptionPane.showMessageDialog(null, "El cliente a sido Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnSaveProvActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //List Provider
        LimpiarTabla();
        ListarProveedor();

        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnUpdateProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProvActionPerformed
        //Update providers
        if ("".equals(txtIdProv.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtCUITProv.getText()) || !"".equals(txtNameProv.getText()) || !"".equals(txtAddressProv.getText())) {
                //Save data providers

                pr.setCuit(Integer.parseInt(txtCUITProv.getText()));
                pr.setNombre(txtNameProv.getText());
                pr.setTelefono(Integer.parseInt(txtPhoneProv.getText()));
                pr.setDireccion(txtAddressProv.getText());
                pr.setRazon(txtRazonProv.getText());
                pr.setId(Integer.parseInt(txtIdProv.getText()));

                prov.actualizarProveedo(pr);
                LimpiarTabla();
                LimpiarProveedor();
                ListarProveedor();
                JOptionPane.showMessageDialog(null, "El cliente a sido Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnUpdateProvActionPerformed

    private void tableProvidersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProvidersMouseClicked
        //Select content table and charge in the fields 
        int fila = tableProviders.rowAtPoint(evt.getPoint());
        txtIdProv.setText(tableProviders.getValueAt(fila, 0).toString());
        txtCUITProv.setText(tableProviders.getValueAt(fila, 1).toString());
        txtNameProv.setText(tableProviders.getValueAt(fila, 2).toString());
        txtPhoneProv.setText(tableProviders.getValueAt(fila, 3).toString());
        txtAddressProv.setText(tableProviders.getValueAt(fila, 4).toString());
        txtRazonProv.setText(tableProviders.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_tableProvidersMouseClicked

    private void btnDeleteProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProvActionPerformed
        //Delete event
        if (!"".equals(txtCUITProv.getText()) || !"".equals(txtNameProv.getText()) || !"".equals(txtAddressProv.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el clinete?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdProv.getText());
                prov.EliminarProveedor(id);

                JOptionPane.showMessageDialog(null, "El proveedor a sido Eliminado");
                LimpiarTabla();
                LimpiarProveedor();
                ListarProveedor();
            }
        }
    }//GEN-LAST:event_btnDeleteProvActionPerformed

    private void btnSaveProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProdActionPerformed
        //Save fields in Producto
        if (!"".equals(txtCodeProd.getText()) || !"".equals(txtDescProd.getText()) || !"".equals(cbxProd.getSelectedItem()) || !"".equals(txtStockProd.getText()) || !"".equals(txtPriceProd.getText())) {
            prod.setCodigo(txtCodeProd.getText());
            prod.setNombre(txtDescProd.getText());
            prod.setProveedor(cbxProd.getSelectedItem().toString());
            prod.setStock(Integer.parseInt(txtStockProd.getText()));
            prod.setPrecio(Double.parseDouble(txtPriceProd.getText()));

            //Send to ProductoDAO
            pro.CreateProducto(prod);
            LimpiarTabla();
            LimpiarProducto();
            ListarProductos();

            JOptionPane.showMessageDialog(null, "Produto Registrado");
        } else {
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnSaveProdActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        LimpiarProducto();
        ListarProductos();

        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tableProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductsMouseClicked
        //Select content table and charge in the fields 
        int fila = tableProducts.rowAtPoint(evt.getPoint());
        txtIdPROD.setText(tableProducts.getValueAt(fila, 0).toString());
        txtCodeProd.setText(tableProducts.getValueAt(fila, 1).toString());
        txtDescProd.setText(tableProducts.getValueAt(fila, 2).toString());
        cbxProd.setSelectedItem(tableProducts.getValueAt(fila, 3).toString());
        txtStockProd.setText(tableProducts.getValueAt(fila, 4).toString());
        txtPriceProd.setText(tableProducts.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_tableProductsMouseClicked

    private void btnDeleteProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProdActionPerformed
        //Delete event
        if (!"".equals(txtCodeProd.getText()) || !"".equals(txtDescProd.getText()) || !"".equals(cbxProd.getSelectedItem())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el clinete?");
            if (pregunta == 0) {
                int id = Integer.parseInt(txtIdPROD.getText());
                pro.EliminarProducto(id);

                JOptionPane.showMessageDialog(null, "El proveedor a sido Eliminado");
                LimpiarTabla();
                LimpiarProducto();
                ListarProductos();
            }
        }

    }//GEN-LAST:event_btnDeleteProdActionPerformed

    private void btnUpdateProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProdActionPerformed
        //Update productos
        if ("".equals(txtIdPROD.getText())) {
            JOptionPane.showMessageDialog(null, "seleccione una fila");
        } else {

            if (!"".equals(txtCodeProd.getText()) || !"".equals(txtDescProd.getText()) || !"".equals(cbxProd.getSelectedItem())) {
                //Save data productos

                prod.setCodigo(txtCodeProd.getText());
                prod.setNombre(txtDescProd.getText());
                prod.setProveedor(cbxProd.getSelectedItem().toString());
                prod.setStock(Integer.parseInt(txtStockProd.getText()));
                prod.setPrecio(Double.parseDouble(txtPriceProd.getText()));
                prod.setId(Integer.parseInt(txtIdPROD.getText()));

                pro.actualizarProducto(prod);
                LimpiarTabla();
                LimpiarProducto();
                ListarProductos();
                JOptionPane.showMessageDialog(null, "El cliente a sido Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnUpdateProdActionPerformed

    private void btnExcelProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelProdActionPerformed
        // Call Execel Report
        Excel.reporte();
    }//GEN-LAST:event_btnExcelProdActionPerformed

    private void txtCodeSoldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeSoldKeyPressed
        //Search producto with code number
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCodeSold.getText())) {
                String cod = txtCodeSold.getText();
                prod = pro.searchPro(cod);
                if (prod.getNombre() != null) {
                    txtDescSold.setText("" + prod.getNombre());
                    txtPriceSold.setText("" + prod.getPrecio());
                    txtStockAvail.setText("" + prod.getStock());
                    txtAmountSold.requestFocus();
                } else {
                    LimpiarVentana();
                    txtAmountSold.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el codigo del produto");
                txtCodeSold.requestFocus();
            }
        }
    }//GEN-LAST:event_txtCodeSoldKeyPressed

    private void txtAmountSoldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountSoldKeyPressed
        //Send Cantidad
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtAmountSold.getText())) {
                String cod = txtCodeSold.getText();
                String desc = txtDescSold.getText();
                int cant = Integer.parseInt(txtAmountSold.getText());
                double precio = Double.parseDouble(txtPriceSold.getText());
//calculate total
                double total = cant * precio;
                int stock = Integer.parseInt(txtStockAvail.getText());
                if (stock >= cant) {
                    item = item + 1;
                    tmp = (DefaultTableModel) tableSolds.getModel();
                    //Bucle raid list
                    for (int i = 0; i < tableSolds.getRowCount(); i++) {
                        if (tableSolds.getValueAt(i, 1).equals(txtDescSold.getText())) {
                            JOptionPane.showMessageDialog(null, "El produto ya esta registrado");
                            return;
                        }

                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(cod);
                    lista.add(desc);
                    lista.add(cant);
                    lista.add(precio);
                    lista.add(total);
                    Object[] ob = new Object[5];
                    ob[0] = lista.get(1);
                    ob[1] = lista.get(2);
                    ob[2] = lista.get(3);
                    ob[3] = lista.get(4);
                    ob[4] = lista.get(5);
                    tmp.addRow(ob);
                    tableSolds.setModel(tmp);
                    totalPagar();
                    LimpiarVentana();
                    txtCodeSold.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese cantidad");
            }
        }
    }//GEN-LAST:event_txtAmountSoldKeyPressed

    private void btnDeleteSoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSoldActionPerformed
        // Delete product in the solds list
        modelo = (DefaultTableModel) tableSolds.getModel();
        modelo.removeRow(tableSolds.getSelectedRow());
        totalPagar();
        txtCodeSold.requestFocus();
    }//GEN-LAST:event_btnDeleteSoldActionPerformed

    private void txtCUITClientSoldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCUITClientSoldKeyPressed
        //Search Cliente
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (!"".equals(txtCUITClientSold.getText())) {
                int dni = Integer.parseInt(txtCUITClientSold.getText());
                cl = client.BuscarCliente(dni);
                if (cl.getNombre() != null) {
                    txtNameClientSold.setText("" + cl.getNombre());
                    txtPhoneCV.setText("" + cl.getTelefono());
                    txtAddressCV.setText("" + cl.getDireccion());
                    txtRazonCV.setText("" + cl.getRazon());
                } else {
                    txtCUITClientSold.setText("");
                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                }

            }
        }
    }//GEN-LAST:event_txtCUITClientSoldKeyPressed

    private void btnGenerateSoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateSoldActionPerformed
        // Event button Register venta
       if(tableSolds.getRowCount() > 0){
           if(!"".equals(txtNameClientSold.getText())){
                RegisterVenta();
        RegistrarDetalle();
        ActualizarStock();
        pdf();

        LimpiarTVentas();
        limpiarClienteVenta();
           }else{
               JOptionPane.showMessageDialog(null, "Debes buscar cliente");
           }
       } else {
           JOptionPane.showMessageDialog(null, "No hay Productos en la lista de compra ");
       }
    }//GEN-LAST:event_btnGenerateSoldActionPerformed

    private void txtCodeSoldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeSoldKeyTyped
       event.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodeSoldKeyTyped

    private void txtDescSoldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescSoldKeyTyped
       event.textKeyPress(evt);
    }//GEN-LAST:event_txtDescSoldKeyTyped

    private void txtAmountSoldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmountSoldKeyTyped
       event.numberKeyPress(evt);
    }//GEN-LAST:event_txtAmountSoldKeyTyped

    private void txtPriceProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceProdKeyTyped
       event.numberDecimalKeyPress(evt, txtPriceSold);
    }//GEN-LAST:event_txtPriceProdKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtIdSoldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdSoldsMouseClicked
    

    }//GEN-LAST:event_txtIdSoldsMouseClicked

    private void btnPDFSoldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFSoldsActionPerformed
        // call pdf venta 
        try {
            int id= Integer.parseInt(txtIdSolds.getText());
            File file= new File("src/pdf/vent"+ id +".pdf");
        JOptionPane.showMessageDialog(null, id);
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            java.lang.System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnPDFSoldsActionPerformed

    private void tableResumeSoldsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableResumeSoldsMouseClicked
              int fila= tableResumeSolds.rowAtPoint(evt.getPoint());
    
        txtIdSolds.setText(tableResumeSolds.getValueAt(fila, 0).toString());
        
    }//GEN-LAST:event_tableResumeSoldsMouseClicked

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
            java.util.logging.Logger.getLogger(System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(System.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new System().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelVendedor;
    private javax.swing.JButton btnDeleteClient;
    private javax.swing.JButton btnDeleteProd;
    private javax.swing.JButton btnDeleteProv;
    private javax.swing.JButton btnDeleteSold;
    private javax.swing.JButton btnExcelProd;
    private javax.swing.JButton btnGenerateSold;
    private javax.swing.JButton btnNewClient;
    private javax.swing.JButton btnNewProd;
    private javax.swing.JButton btnNewProv;
    private javax.swing.JButton btnPDFSolds;
    private javax.swing.JButton btnSaveClient;
    private javax.swing.JButton btnSaveProd;
    private javax.swing.JButton btnSaveProv;
    private javax.swing.JButton btnUpdateClient;
    private javax.swing.JButton btnUpdateConf;
    private javax.swing.JButton btnUpdateProd;
    private javax.swing.JButton btnUpdateProv;
    private javax.swing.JComboBox<String> cbxProd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableClients;
    private javax.swing.JTable tableProducts;
    private javax.swing.JTable tableProviders;
    private javax.swing.JTable tableResumeSolds;
    private javax.swing.JTable tableSolds;
    private javax.swing.JLabel txtAddressCV;
    private javax.swing.JTextField txtAddressClient;
    private javax.swing.JTextField txtAddressProv;
    private javax.swing.JTextField txtAdressConf;
    private javax.swing.JTextField txtAmountSold;
    private javax.swing.JTextField txtCUITClientSold;
    private javax.swing.JTextField txtCUITProv;
    private javax.swing.JTextField txtCodeProd;
    private javax.swing.JTextField txtCodeSold;
    private javax.swing.JTextField txtCuitConf;
    private javax.swing.JTextField txtDNIClient;
    private javax.swing.JTextField txtDescProd;
    private javax.swing.JTextField txtDescSold;
    private javax.swing.JButton txtExcelProv;
    private javax.swing.JLabel txtIdClient;
    private javax.swing.JLabel txtIdConf;
    private javax.swing.JLabel txtIdPROD;
    private javax.swing.JLabel txtIdProd;
    private javax.swing.JLabel txtIdProv;
    private javax.swing.JLabel txtIdSolds;
    private javax.swing.JTextField txtNameClient;
    private javax.swing.JTextField txtNameClientSold;
    private javax.swing.JTextField txtNameConf;
    private javax.swing.JTextField txtNameProv;
    private javax.swing.JLabel txtPhoneCV;
    private javax.swing.JTextField txtPhoneClient;
    private javax.swing.JTextField txtPhoneConf;
    private javax.swing.JTextField txtPhoneProv;
    private javax.swing.JTextField txtPriceProd;
    private javax.swing.JTextField txtPriceSold;
    private javax.swing.JLabel txtRazonCV;
    private javax.swing.JTextField txtRazonClient;
    private javax.swing.JTextField txtRazonConfig;
    private javax.swing.JTextField txtRazonProv;
    private javax.swing.JTextField txtStockAvail;
    private javax.swing.JTextField txtStockProd;
    // End of variables declaration//GEN-END:variables

    //Clear fields Cliente
    private void LimpiarCliente() {
        txtIdClient.setText("");
        txtDNIClient.setText("");
        txtNameClient.setText("");
        txtPhoneClient.setText("");
        txtAddressClient.setText("");
        txtRazonClient.setText("");
    }
//Clear Fields proveedor

    private void LimpiarProveedor() {
        txtIdProv.setText("");
        txtCUITProv.setText("");
        txtNameProv.setText("");
        txtPhoneProv.setText("");
        txtAddressProv.setText("");
        txtRazonProv.setText("");
    }
//Clear fields Producto

    private void LimpiarProducto() {
        txtIdPROD.setText("");
        txtCodeProd.setText("");
        txtDescProd.setText("");
        cbxProd.setSelectedItem(null);
        txtStockProd.setText("");
        txtPriceProd.setText("");
    }

    //Method sum total
    private void totalPagar() {
        totalPagar = 0.0;
        int numFila = tableSolds.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(tableSolds.getModel().getValueAt(i, 4)));
            totalPagar = totalPagar + cal;
        }
        jLabel10.setText(String.format("%.2f", totalPagar));

    }

    //Clear window Ventas
    private void LimpiarVentana() {
        txtCodeSold.setText("");
        txtDescSold.setText("");
        txtAmountSold.setText("");
        txtStockAvail.setText("");
        txtPriceSold.setText("");
        txtIdSolds.setText("");

    }

    //Register Venta function Method
    private void RegisterVenta() {
        String Cliente = txtNameClientSold.getText();
        String vendedor = LabelVendedor.getText();
        double monto = totalPagar;
        ven.setCliente(Cliente);
        ven.setVendedor(vendedor);
        ven.setTotal(monto);
        v.RegistroCliente(ven);
    }

    //register Detalle Venta
    public void RegistrarDetalle() {

        //Max id ventas
        int id = v.MaxVenta();

        //Scroll through the list to register 
        for (int i = 0; i < tableSolds.getRowCount(); i++) {
            String cod = tableSolds.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(tableSolds.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(tableSolds.getValueAt(i, 3).toString());

            dv.setCod_pro(cod);
            dv.setCantidad(cant);
            dv.setPrecio(precio);
            dv.setId(id);
            v.RegistrarDetalleVenta(dv);
        }
    }

    //Update Stock
    private void ActualizarStock() {
        for (int i = 0; i < tableSolds.getRowCount(); i++) {
            String cod = tableSolds.getValueAt(i, 0).toString();
            int cant = Integer.parseInt(tableSolds.getValueAt(i, 2).toString());
            prod = pro.searchPro(cod);
            int StockActual = prod.getStock() - cant;
            v.ActualizarStock(cant, cod);
        }

    }

    //Clean table Ventas
    private void LimpiarTVentas() {
        tmp = (DefaultTableModel) tableSolds.getModel();
        int fila = tableSolds.getRowCount();
        for (int i = 0; i < fila; i++) {
            tmp.removeRow(0);
        }
    }

    private void limpiarClienteVenta() {
        txtCUITClientSold.setText("");
        txtNameClientSold.setText("");
        txtPhoneCV.setText("");
        txtAddressCV.setText("");
        txtRazonCV.setText("");
    }

    //Charge and convert in PDF docuement the solds
    private void pdf() {
        try {

            int id = v.MaxVenta();

            //inicialize instances 
            FileOutputStream archivo;
            File file = new File("src/PDF/vent" + id + ".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            //init create document pdf
            doc.open();
            //insert img in the archive pdf
            Image img = Image.getInstance("src/img/logo-fst.png");

            //create paragraph in the document
            Paragraph fetch = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fetch.add(Chunk.NEWLINE);
            //create data in the document
            Date date = new Date();
            fetch.add("Factura:" + id + "\n " + "Fecha: " + new SimpleDateFormat("dd-mm-yyyy").format(date) + "\n\n");

            //create encabezado thr table in the document
            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEnacabezado = new float[]{20f, 30f, 70f, 40f};
            encabezado.setWidths(ColumnaEnacabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            encabezado.addCell(img);

            String cuilt = txtCuitConf.getText();
            String nom = txtNameConf.getText();
            String tel = txtPhoneConf.getText();
            String dir = txtAdressConf.getText();
            String ra = txtRazonConfig.getText();

            encabezado.addCell("");
            encabezado.addCell("Cuit/Dni: " + cuilt + "\nNombre: " + nom + "\nTelefono: " + tel + "\nDireccion: " + dir + "\nRazon: " + ra);
            encabezado.addCell(fetch);
            //add in the document
            doc.add(encabezado);

            //create Client information
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("Datos de los clientes" + "\n\n");
            doc.add(cli);

            PdfPTable tablaCli = new PdfPTable(4);

            //formatt table produtos
            tablaCli.setWidthPercentage(100);
            tablaCli.getDefaultCell().setBorder(0);
            float[] ColumnaCliente = new float[]{40f, 40f, 40f, 40f};
            tablaCli.setWidths(ColumnaCliente);
            tablaCli.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cl1 = new PdfPCell(new Phrase("Dni/Cuilt", negrita));
            PdfPCell cl2 = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell cl3 = new PdfPCell(new Phrase("Telefono", negrita));
            PdfPCell cl4 = new PdfPCell(new Phrase("Direccion", negrita));

            //Border size
            cl1.setBorder(0);
            cl2.setBorder(0);
            cl3.setBorder(0);
            cl4.setBorder(0);

            //add header cell
            tablaCli.addCell(cl1);
            tablaCli.addCell(cl2);
            tablaCli.addCell(cl3);
            tablaCli.addCell(cl4);

            //add to cells
            tablaCli.addCell(txtCUITClientSold.getText());
            tablaCli.addCell(txtNameClientSold.getText());
            tablaCli.addCell(txtPhoneCV.getText());
            tablaCli.addCell(txtAddressCV.getText());

            //Add to doc Cliente  
            doc.add(tablaCli);

            //create Productos information
            Paragraph pro = new Paragraph();
            pro.add(Chunk.NEWLINE);
            pro.add("Datos de los productos" + "\n\n");
            doc.add(pro);

            PdfPTable tablaPro = new PdfPTable(4);
            //formatt table produtos
            tablaPro.setWidthPercentage(100);
            tablaPro.getDefaultCell().setBorder(0);
            float[] ColumnaProducto = new float[]{20f, 40f, 15f, 20f};
            tablaPro.setWidths(ColumnaProducto);
            tablaPro.setHorizontalAlignment(Element.ALIGN_LEFT);

            //create header cell
            PdfPCell pr1 = new PdfPCell(new Phrase("Cant.", negrita));
            PdfPCell pr2 = new PdfPCell(new Phrase("Desc.", negrita));
            PdfPCell pr3 = new PdfPCell(new Phrase("Precio U.", negrita));
            PdfPCell pr4 = new PdfPCell(new Phrase("Precio T.", negrita));

            //Border size
            pr1.setBorder(1);
            pr2.setBorder(1);
            pr3.setBorder(1);
            pr4.setBorder(1);

            //backgrund color cell
            pr1.setBackgroundColor(BaseColor.GRAY);
            pr2.setBackgroundColor(BaseColor.GRAY);
            pr3.setBackgroundColor(BaseColor.GRAY);
            pr4.setBackgroundColor(BaseColor.GRAY);

            //add header cell
            tablaPro.addCell(pr1);
            tablaPro.addCell(pr2);
            tablaPro.addCell(pr3);
            tablaPro.addCell(pr4);

            //save content table ventas 
            for (int i = 0; i < tableSolds.getRowCount(); i++) {
                String cantidad = tableSolds.getValueAt(i, 1).toString();
                String descripcion = tableSolds.getValueAt(i, 2).toString();
                String precioU = tableSolds.getValueAt(i, 3).toString();
                String precioT = tableSolds.getValueAt(i, 4).toString();

                //add to cells
                tablaPro.addCell(cantidad);
                tablaPro.addCell(descripcion);
                tablaPro.addCell(precioU);
                tablaPro.addCell(precioT);
            }
            //Add to doc Producto   
            doc.add(tablaPro);

            //create Total information
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + totalPagar);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            //create Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelación y firma\n\n");
            firma.add("----------------------------");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            //create Firma
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("Gracias por su compra");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            //close craete document pdf
            doc.close();
            archivo.close();

            //open documen in desktop
            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            java.lang.System.out.println(e.toString());
        }
    }

    //List Configuration Company
    private void ListarConfig() {

        conf = pro.searchDatos();
        txtIdConf.setText("" + conf.getId());
        txtCuitConf.setText("" + conf.getCuit());
        txtNameConf.setText("" + conf.getNombre());
        txtPhoneConf.setText("" + conf.getTelefono());
        txtAdressConf.setText("" + conf.getDireccion());
        txtRazonConfig.setText("" + conf.getRazon());
    }

}
