package day22.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex05_Todo2 {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("할 일");
		frame.setSize(400, 500);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫기 버튼
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JButton btn = new JButton("누르던지");
		
		JTextField textField = new JTextField(20);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> list = new JList<String>(listModel);
		JScrollPane scrollPane = new JScrollPane();
		
		// JList를 JScrollPane에 추가
		scrollPane.setViewportView(list);
		
		btn.addActionListener(e->{
			String text = textField.getText().trim();
			
			if(!text.isEmpty()) {
				listModel.addElement(text);
			}
			textField.setText("");
		});
		
		textField.addActionListener(e->{
			String text = textField.getText().trim();
			
			if(!text.isEmpty()) {
				listModel.addElement(text);
			}
			textField.setText("");
		});

		panel.add(textField);
		panel.add(btn);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
