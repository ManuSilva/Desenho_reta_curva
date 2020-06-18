package Package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
		);
		
		JButton btnNewButton = new JButton("Reta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Tela_principal frame = new Tela_principal();
			     frame.setVisible(true);
			}
		});
		
		JButton btnCurva = new JButton("Curva");
		btnCurva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_curva frame = new Tela_curva();
			    frame.setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
					.addComponent(btnCurva, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCurva, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
