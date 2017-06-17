import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;

public class InterfacePDFViewer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Button bttCrearpdf = new Button("Crear PDF");
		bttCrearpdf.setBounds(32, 23, 97, 22);
		frame.getContentPane().add(bttCrearpdf);
		
		Button bttMostrarpdf = new Button("Mostrar PDF");
		bttMostrarpdf.setBounds(166, 23, 97, 22);
		frame.getContentPane().add(bttMostrarpdf);
		
		Button bttExtraerTextopdf = new Button("Extraer Texto PDF");
		bttExtraerTextopdf.setBounds(299, 23, 97, 22);
		frame.getContentPane().add(bttExtraerTextopdf);
	}
}
