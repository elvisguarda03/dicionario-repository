package br.com.guacom.dicionario.aurelio.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

public class DicionarioView extends JFrame {

	public JTextField txtBuscar;
	public JToggleButton btnPesquisar;
	public JLabel lblWord;
	public JLabel lblSignificado;
	public JLabel lblDefinicao;
	private JPanel contentPane;
	private JLabel lblDicionrioDePortugus;
	private JMenuBar menuBar;

	/**
	 * Create the frame.
	 */
	public DicionarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 320);

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 153));
		setJMenuBar(menuBar);

		txtBuscar = new JTextField();
		menuBar.add(txtBuscar);
		txtBuscar.setBackground(Color.WHITE);
		txtBuscar.setForeground(new Color(0, 0, 0));
		txtBuscar.setToolTipText("");
		txtBuscar.setColumns(10);

		btnPesquisar = new JToggleButton("PESQUISAR");
		menuBar.add(btnPesquisar);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblDicionrioDePortugus_1 = new JLabel("Dicion\u00E1rio de Portugu\u00EAs");
		lblDicionrioDePortugus_1.setFont(
				new Font("Comic Sans MS", lblDicionrioDePortugus_1.getFont().getStyle() | Font.BOLD | Font.ITALIC, 15));

		lblWord = new JLabel("");
		lblWord.setForeground(new Color(0, 0, 128));
		lblWord.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));

		lblSignificado = new JLabel("");
		lblSignificado.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));

		lblDefinicao = new JLabel("");
		lblDefinicao.setFont(lblDefinicao.getFont().deriveFont(lblDefinicao.getFont().getStyle() | Font.ITALIC));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(168, Short.MAX_VALUE)
						.addComponent(lblDicionrioDePortugus_1).addGap(148))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblWord)
						.addContainerGap(417, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblSignificado)
						.addContainerGap(419, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblDefinicao)
						.addContainerGap(419, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblDicionrioDePortugus_1).addGap(18)
						.addComponent(lblWord).addGap(27).addComponent(lblSignificado).addGap(31)
						.addComponent(lblDefinicao).addContainerGap(85, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);

		lblDicionrioDePortugus = new JLabel("Dicion\u00E1rio de Portugu\u00EAs");
		lblDicionrioDePortugus.setBackground(Color.WHITE);
		lblDicionrioDePortugus.setForeground(Color.BLACK);
		lblDicionrioDePortugus.setFont(new Font("Verdana", Font.BOLD, 16));

		JTextArea textArea = new JTextArea();
	}
}