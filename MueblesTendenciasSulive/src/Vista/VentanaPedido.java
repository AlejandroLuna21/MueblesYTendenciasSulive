/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ALEJANDRO
 */
public class VentanaPedido extends JInternalFrame {

    private JPanel jpBtn;
    private JButton btnSave;
    private JButton btnModify;
    private JButton btnDelete;
    private JButton btnSearch;
    private JButton btnUpdate;

    private JPanel jpTable;

    private JPanel jpLblyTxt;
    private JLabel lblTitulo;
    private JLabel lblMueble;
    private JLabel lblTipoM;
    private JLabel lblCant;
    private JLabel lblDesc;
    private JLabel lblEstado;
    private JLabel lblFP;
    private JLabel lblFE;
    private JLabel lblCliente;
    private JLabel lblPersonal;
    private JComboBox cbxMueble;
    private JComboBox cbxTipoM;
    private JTextField txtCant;
    private JTextField txtDesc;
    private JComboBox cbxEstado;
    private JDateChooser dateFP;
    private JDateChooser dateFE;
    private JComboBox cbxCliente;
    private JComboBox cbxPersonal;
    

    public VentanaPedido() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("P E D I D O");
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setClosable(true);
        this.setBackground(Color.darkGray);
        this.setResizable(false);
    }

    private void inicializarComponentes() {
        jpBtn = new JPanel();
        jpBtn.setBackground(Color.LIGHT_GRAY);
        jpBtn.setBounds(1390, 15, 500, 965);
        jpBtn.setLayout(null);
        btnSave = new JButton();
        btnSave.setText("G U A R D A R");
        btnSave.setBounds(10, 50, 480, 100);
        jpBtn.add(btnSave);
        btnSearch = new JButton();
        btnSearch.setText("B U S C A R");
        btnSearch.setBounds(10, 200, 480, 100);
        jpBtn.add(btnSearch);
        btnModify = new JButton();
        btnModify.setText("M O D I F I C A R");
        btnModify.setBounds(10, 350, 480, 100);
        jpBtn.add(btnModify);
        btnUpdate = new JButton();
        btnUpdate.setText("A C T U A L I Z A R");
        btnUpdate.setBounds(10, 500, 480, 100);
        jpBtn.add(btnUpdate);
        btnDelete = new JButton();
        btnDelete.setText("E L I M I N A R");
        btnDelete.setBounds(10, 650, 480, 100);
        jpBtn.add(btnDelete);
        this.add(jpBtn);

        jpTable = new JPanel();
        jpTable.setBackground(Color.LIGHT_GRAY);
        jpTable.setBounds(15, 15, 1350, 465);
        jpTable.setLayout(null);

        this.add(jpTable);

        jpLblyTxt = new JPanel();
        jpLblyTxt.setBackground(Color.LIGHT_GRAY);
        jpLblyTxt.setBounds(15, 500, 1350, 477);
        jpLblyTxt.setLayout(null);
        lblTitulo = new JLabel();
        lblTitulo.setText("Registro de Pedido:");
        lblTitulo.setBounds(50, 10, 130, 25);
        jpLblyTxt.add(lblTitulo);
        lblMueble = new JLabel();
        lblMueble.setText("Mueble:");
        lblMueble.setBounds(110, 60, 100, 25);
        jpLblyTxt.add(lblMueble);
        lblTipoM = new JLabel();
        lblTipoM.setText("Tipo De Material");
        lblTipoM.setBounds(110, 130, 100, 25);
        jpLblyTxt.add(lblTipoM);
        lblCant = new JLabel();
        lblCant.setText("Cantidad:");
        lblCant.setBounds(110, 190, 100, 25);
        jpLblyTxt.add(lblCant);
        lblDesc = new JLabel();
        lblDesc.setText("Descripcion:");
        lblDesc.setBounds(110, 250, 100, 25);
        jpLblyTxt.add(lblDesc);
        lblEstado = new JLabel();
        lblEstado.setText("Estado:");
        lblEstado.setBounds(110, 320, 100, 25);
        jpLblyTxt.add(lblEstado);
        lblFP = new JLabel();
//        lblFP.setText("Fecha de Pedido:");
//        lblFP.setBounds(110, 320, 130, 25);
//        jpLblyTxt.add(lblFP);
        lblFE = new JLabel();
        lblFE.setText("Fecha de Entrega:");
        lblFE.setBounds(700, 60, 130, 25);
        jpLblyTxt.add(lblFE);
        lblCliente = new JLabel();
        lblCliente.setText("Cliente:");
        lblCliente.setBounds(700, 130, 100, 25);
        jpLblyTxt.add(lblCliente);

        cbxMueble = new JComboBox();
        cbxMueble.setBorder(BorderFactory.createTitledBorder("Seleccione una Opcion:"));
        cbxMueble.setBounds(250, 50, 230, 50);
        jpLblyTxt.add(cbxMueble);
        cbxTipoM = new JComboBox();
        cbxTipoM.setBorder(BorderFactory.createTitledBorder("Seleccione una Opcion:"));
        cbxTipoM.setBounds(250, 120, 230, 50);
        jpLblyTxt.add(cbxTipoM);
        txtCant = new JTextField();
        txtCant.setBounds(250, 180, 230, 40);
        jpLblyTxt.add(txtCant);
        txtDesc = new JTextField();
        txtDesc.setBounds(250, 240, 230, 40);
        jpLblyTxt.add(txtDesc);
        cbxEstado = new JComboBox();
        cbxEstado.setBorder(BorderFactory.createTitledBorder("Seleccione una Opcion:"));
        cbxEstado.setBounds(250, 310, 230, 50);
        jpLblyTxt.add(cbxEstado);
//        dateFP = new JDateChooser();
//        dateFP.setBounds(250, 310, 230, 40);
//        jpLblyTxt.add(dateFP);

        this.add(jpLblyTxt);

    }
}
