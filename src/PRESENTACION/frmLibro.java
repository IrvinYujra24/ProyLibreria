package PRESENTACION;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DATOS.LibroDb;
import LOGICA.Libro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class frmLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tbxLibro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLibro frame = new frmLibro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private List<Libro> listaLibros = new ArrayList<>();
    
    Libro lb=new Libro();
    private JTable jtResultado;
    
    private void vaciarTabla() {
        listaLibros.clear();
        modeloTabla.setRowCount(0);        
    }
    
    public void configurar() {
		String[] columnas = {"ID","Título", "Autor","ISBN"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        jtResultado.setModel(modeloTabla);
	}
    
    public void cargar() {
    	vaciarTabla();
    	listaLibros=lb.listar();

        for (Libro lb : listaLibros) {
            Object[] fila = {lb.getIdLibro(),lb.getTitulo(), lb.getAutor(), lb.getIsbn()};
            modeloTabla.addRow(fila);
        }
    }
    
    public void buscar(String titulo) {    	
    	vaciarTabla();
    	listaLibros=lb.buscar(titulo);

        for (Libro lb : listaLibros) {
            Object[] fila = {lb.getIdLibro(),lb.getTitulo(), lb.getAutor(), lb.getIsbn()};
            modeloTabla.addRow(fila);
        }
    }
	

	/**
	 * Create the frame.
	 */
	public frmLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mnAbrir = new JMenuItem("Abrir");
		mnArchivo.add(mnAbrir);
		
		JMenuItem mnSalir = new JMenuItem("Salir");
		mnArchivo.add(mnSalir);
		
		JMenu mnConfiguracion = new JMenu("Configurar");
		menuBar.add(mnConfiguracion);
		
		JMenuItem mnEditar = new JMenuItem("Editar");
		mnConfiguracion.add(mnEditar);
		
		JMenuItem mnEliminar = new JMenuItem("Eliminar");
		mnConfiguracion.add(mnEliminar);
		
		JMenuItem mnAgregar = new JMenuItem("Agregar");
		mnConfiguracion.add(mnAgregar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mnManual = new JMenuItem("Manual");
		mnAyuda.add(mnManual);
		
		JMenuItem mnVersion = new JMenuItem("Versión");
		mnVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Versión","Versión 1.0",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnVersion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Versión","Versión 1.0",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnAyuda.add(mnVersion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel jpCabecera = new JPanel();
		contentPane.add(jpCabecera, BorderLayout.NORTH);
		jpCabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Listar");
		jpCabecera.add(lblNewLabel);
		
		tbxLibro = new JTextField();
		jpCabecera.add(tbxLibro);
		tbxLibro.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				configurar();
				String valor=tbxLibro.getText();
				buscar(valor);
			}
		});
		jpCabecera.add(btnBuscar);
		
		JPanel jpCuerpo = new JPanel();
		contentPane.add(jpCuerpo, BorderLayout.CENTER);
		jpCuerpo.setLayout(new BoxLayout(jpCuerpo, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		jpCuerpo.add(scrollPane);
		
		jtResultado = new JTable();
		scrollPane.setViewportView(jtResultado);
		
		JPanel jpBarraEstado = new JPanel();
		contentPane.add(jpBarraEstado, BorderLayout.SOUTH);
		
		JLabel lbUsuario = new JLabel("Usuario actual:");
		jpBarraEstado.add(lbUsuario);

	}
}
