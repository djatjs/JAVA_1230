package day22.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex04_Todo {
	public static void main(String[] args) {
		/* 할 일 입력받아 엔터치거나 버튼 클릭하면 추가되도록 하셈
		 * */
		JFrame frame = new JFrame("할 일");
		frame.setSize(400, 500);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫기 버튼
		
		JTextArea textArea = new JTextArea(30,30);
		
		JTextField textField = new JTextField(20);
		textField.addActionListener(e->{
			String toDo = textField.getText();
			textArea.append(toDo+"\n");
			textField.setText("");
		});
		
		JButton btn = new JButton("누르던지");
		btn.addActionListener(e->{
			String toDo = textField.getText();
			textArea.append(toDo+"\n");
			textField.setText("");
			//JOptionPane.showMessageDialog(frame, "등록했으니 확인하던지");
		});

		frame.add(textField);
		frame.add(btn);
		frame.add(textArea);
		frame.setVisible(true);
	}

}
