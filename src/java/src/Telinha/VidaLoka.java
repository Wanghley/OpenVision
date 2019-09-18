package Telinha;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VidaLoka extends JFrame {

	ImageIcon loko ;
	JLabel telin ;
	JButton lok ;
	JButton lok1 ;

	public VidaLoka() {

		loko = new ImageIcon(getClass().getResource("images.png"));
		setLayout(new FlowLayout());
		telin = new JLabel(loko);
		add(telin);
		lok = new JButton("Acesso Negado");
		lok.setForeground(new Color(0, 0, 0));
		lok.setBackground(Color.RED);
		add(lok);
		lok1 = new JButton("Acesso Permitido");
		lok1.setForeground(new Color(0, 0, 0));
		lok1.setBackground(Color.GREEN);
		add(lok1);
		setSize(300, 400);
		setLocationRelativeTo(this);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	public static void main(String[] args) {
		new VidaLoka();

	}

}
