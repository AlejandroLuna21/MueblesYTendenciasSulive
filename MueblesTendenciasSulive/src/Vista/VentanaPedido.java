/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
    private JLabel lblCant;
    private JLabel lblDesc;
    private JLabel lblEstado;
    private JLabel lblFP;
    private JLabel lblFE;
    private JLabel lblCliente;
    private JLabel lblPersonal;
    private JLabel lblTipoM;
    private JTextField txtCant;
    private JDateChooser dateFP;
    private JDateChooser dateFE;
    private JTextField txtDesc;
    private JComboBox cbxEstado;
    private JComboBox cbxCliente;
    private JComboBox cbxPersonal;
    private JComboBox cbxMueble;
    private JComboBox cbxTipoM;

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
        lblTitulo.setBounds(10, 10, 130, 25);
        jpLblyTxt.add(lblTitulo);
        lblMueble = new JLabel();
        lblMueble.setText("Mueble:");
        lblMueble.setBounds(50, 50, 100, 25);
        jpLblyTxt.add(lblMueble);
        lblCant = new JLabel();
        lblCant.setText("Cantidad:");
        lblCant.setBounds(50, 100, 100, 25);
        jpLblyTxt.add(lblCant);
        lblDesc= new JLabel();
        lblDesc.setText("Descripcion:");
        lblDesc.setBounds(50, 150, 100, 25);
        jpLblyTxt.add(lblDesc);
        lblEstado = new JLabel();
        lblEstado.setText("Estado:");
        lblEstado.setBounds(50, 200, 100, 25);
        jpLblyTxt.add(lblEstado);
        

        this.add(jpLblyTxt);

    }
}
