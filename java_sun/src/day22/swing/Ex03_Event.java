package day22.swing;

import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import lombok.extern.jbosslog.JBossLog;

public class Ex03_Event {
	public static void main(String[] args) {
		JFrame frame = new JFrame("어플리케이션 예제");
		
		frame.setLayout(new FlowLayout());
		
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫기 버튼
		
		JButton btn = new JButton("버튼");
		btn.addActionListener(e->{
			System.out.println("aaa");
			JOptionPane.showMessageDialog(frame, "aaa");
		});
		JTextField textField = new JTextField(20);
		textField.addActionListener(e->{
			String text = textField.getText();
			System.out.println(text);
			textField.setText("");
		});
		
		frame.add(textField);
		frame.add(btn);
		frame.setVisible(true);//화면에 보여줄지 말지.. 이거 맨 마지막에 해야 보이네
	}
}
