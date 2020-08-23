package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class PrescriptionView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void view(String html) {
		EventQueue.invokeLater(new Runnable() {
			PrescriptionView frame = new PrescriptionView();

			public void run() {
				try {
					frame.viewPrescription(html);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frame.getParent(), "Error while displaying prescription.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void viewPrescription(String html) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 2480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane.setViewportView(editorPane);

		try {
			editorPane.setContentType("text/html");
			editorPane.setText(html);
		} catch (Exception e) {
			editorPane.setContentType("text/html");
			editorPane.setText("<html>Page not found.</html>");
		}
		setVisible(true);
	}
}