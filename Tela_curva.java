package Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_curva extends JFrame {

	private JPanel contentPane;
	private JTextField Field_X_1;
	private JTextField Field_X_2;
	private JTextField Field_X_3;
	private JTextField Field_X_4;
	private JTextField Field_Y_4;
	private JTextField Field_Y_3;
	private JTextField Field_Y_2;
	private JTextField Field_Y_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_curva frame = new Tela_curva();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_curva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		Field_X_1 = new JTextField();
		Field_X_1.setBounds(50, 54, 70, 26);
		Field_X_1.setColumns(2);
		
		JLabel lblP = new JLabel("X1:");
		lblP.setBounds(15, 57, 24, 20);
		
		Field_X_2 = new JTextField();
		Field_X_2.setBounds(50, 96, 70, 26);
		Field_X_2.setColumns(2);
		
		JLabel lblP_1 = new JLabel("X2:");
		lblP_1.setBounds(15, 98, 29, 20);
		
		Field_X_3 = new JTextField();
		Field_X_3.setBounds(49, 139, 70, 26);
		Field_X_3.setColumns(2);
		
		JLabel lblP_2 = new JLabel("X3:");
		lblP_2.setBounds(15, 142, 24, 20);
		
		Field_X_4 = new JTextField();
		Field_X_4.setBounds(49, 184, 70, 26);
		Field_X_4.setColumns(2);
		
		JLabel lblP_3 = new JLabel("X4:");
		lblP_3.setBounds(15, 187, 24, 20);
		
		JButton button = new JButton("Desenhar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		          float x1 = Integer.parseInt(Field_X_1.getText());
		          float y1 = Integer.parseInt(Field_Y_1.getText());
		          float x2 = Integer.parseInt(Field_X_2.getText());
		          float y2 = Integer.parseInt(Field_Y_2.getText());
		          float x3 = Integer.parseInt(Field_X_3.getText());
		          float y3 = Integer.parseInt(Field_Y_3.getText());
		          float x4 = Integer.parseInt(Field_X_4.getText());
		          float y4 = Integer.parseInt(Field_Y_4.getText());
		          
		          Curva curva = new Curva(x1,y1,x2,y2,x3,y3,x4,y4);
		          
		          final GLProfile profile = GLProfile.get(GLProfile.GL2);
			        GLCapabilities capabilities = new GLCapabilities(profile);
					
					// Cria o Canvas
			        final GLCanvas glcanvas = new GLCanvas(capabilities);
					
					glcanvas.addGLEventListener(curva);
			        glcanvas.setSize(400, 400);
			      
			      //Criar A tela (Swing)
			        final JFrame frame = new JFrame ("Reta");
			      
			      //Adiciona o canvas na tela
			       frame.getContentPane().add(glcanvas);
			       frame.setSize(frame.getContentPane().getPreferredSize());
			       frame.setVisible(true);
		      
		     
				
				
			}
		});
		button.setBounds(86, 267, 131, 31);
		panel.setLayout(null);
		panel.add(lblP_3);
		panel.add(lblP_2);
		panel.add(button);
		panel.add(Field_X_3);
		panel.add(Field_X_4);
		panel.add(lblP);
		panel.add(Field_X_1);
		panel.add(lblP_1);
		panel.add(Field_X_2);
		
		Field_Y_4 = new JTextField();
		Field_Y_4.setColumns(2);
		Field_Y_4.setBounds(207, 181, 70, 26);
		panel.add(Field_Y_4);
		
		JLabel lblY_3 = new JLabel("Y4:");
		lblY_3.setBounds(173, 184, 44, 20);
		panel.add(lblY_3);
		
		Field_Y_3 = new JTextField();
		Field_Y_3.setColumns(2);
		Field_Y_3.setBounds(207, 136, 70, 26);
		panel.add(Field_Y_3);
		
		JLabel lblY_2 = new JLabel("Y3:");
		lblY_2.setBounds(173, 139, 44, 20);
		panel.add(lblY_2);
		
		Field_Y_2 = new JTextField();
		Field_Y_2.setColumns(2);
		Field_Y_2.setBounds(208, 93, 70, 26);
		panel.add(Field_Y_2);
		
		JLabel lblY_1 = new JLabel("Y2:");
		lblY_1.setBounds(173, 95, 29, 20);
		panel.add(lblY_1);
		
		Field_Y_1 = new JTextField();
		Field_Y_1.setColumns(2);
		Field_Y_1.setBounds(208, 51, 70, 26);
		panel.add(Field_Y_1);
		
		JLabel lblY = new JLabel("Y1:");
		lblY.setBounds(173, 54, 44, 20);
		panel.add(lblY);
		contentPane.setLayout(gl_contentPane);
	}
}
