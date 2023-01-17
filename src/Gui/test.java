package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DA0.LIVRE;
import Extract.Scraper;
import Load.Loader;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JLabel;

public class test extends JFrame {

	private JPanel contentPane;
	private JTextField url_field;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		url_field = new JTextField();
		url_field.setBounds(35, 23, 663, 20);
		contentPane.add(url_field);
		url_field.setColumns(10);
		
		JButton btn_scrap = new JButton("Scrapper");
		btn_scrap.setBounds(695, 22, 122, 23);
		btn_scrap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//recuperation de lURL
				String url =url_field.getText();
				ArrayList <LIVRE> livres = Scraper.text(url);
				//insertion en base de donnees 
				Loader.connecter();
				Loader.inserer_livres(livres);
				Loader.deconnecter();
				//rafraichir la base de donness : cad afficher
				Loader.connecter();
	        	ResultSet selection = Loader.sel();
	        	//resultat stocker dans table par bias de r2XML.jar
	        	table.setModel(DbUtils.resultSetToTableModel(selection));
	        	Loader.deconnecter();
			}
		});
		contentPane.add(btn_scrap);
		lblNewLabel = new JLabel("URL:");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 124, 380, 181);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
