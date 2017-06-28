import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;

public class InterfacePDFViewer {

	private JFrame frame;
	private PDFManager archpdf;
	private JTextArea textArea;
	private Button bttCrearpdf;
	private Button bttExtraerTextopdf;
	private Button bttMostrarpdf;
	private File archivo;
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePDFViewer window = new InterfacePDFViewer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfacePDFViewer() {
		initialize();
		this.archpdf = new PDFManager(); 
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		bttCrearpdf = new Button("Crear PDF");
		bttCrearpdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				archpdf.createPDFEmpty();
			}
		});
		bttCrearpdf.setBounds(32, 23, 97, 22);
		frame.getContentPane().add(bttCrearpdf);
		
		bttMostrarpdf = new Button("Mostrar PDF");
		bttMostrarpdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				     File path = new File ("D:\\test.pdf");
				     Desktop.getDesktop().open(path);
				}catch (IOException ex) {
				     ex.printStackTrace();
				}
			}
		});
		bttMostrarpdf.setBounds(166, 23, 97, 22);
		frame.getContentPane().add(bttMostrarpdf);
		
		bttExtraerTextopdf = new Button("Extraer Texto PDF");
		//evento boton extraer texto
		bttExtraerTextopdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser explorador = new JFileChooser();
				//explorador.setDialogTitle("Abrir documento");
				int seleccion = explorador.showDialog(null, "Abrir!");
				  
				//analizamos la respuesta
				switch(seleccion) {
				case JFileChooser.APPROVE_OPTION:
						archivo = explorador.getSelectedFile();
					//seleccionó abrir
				 break;

				case JFileChooser.CANCEL_OPTION:
				 //dio click en cancelar o cerro la ventana
				 break;

				case JFileChooser.ERROR_OPTION:
				 //llega aqui si sucede un error
				 break;
				}
				String ruta = archivo.getPath();
				archpdf.setFilePath(ruta);
				try {
					textArea.setText(archpdf.ToText());//muestra el texto en jtextarea
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println(" Error no se pudo extraer texto");
				}
			}
		});
		bttExtraerTextopdf.setBounds(292, 23, 97, 22);
		frame.getContentPane().add(bttExtraerTextopdf);
		
		textArea = new JTextArea();
		textArea.setBounds(31, 90, 365, 160);
		frame.getContentPane().add(textArea);
		
	}
}
