package day22.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex01_SwingComponent {
	public static void main(String[] args) {
		/* 컴포넌트
		 * - 메인창
		 *   - JFrame
		 * - 버튼
		 *   - FButton
		 * - 텍스트
		 *   - JLabel
		 * - 텍스트 입력창
		 *   - 한줄
		 *     - JTextField
		 *   - 여러줄
		 *     - JTextArea
		 *   - 패널
		 *     - 컴포넌트를 묶어서 관리
		 * */
		JFrame frame = new JFrame("어플리케이션 예제");
		
		//frame.setLayout(new FlowLayout());
		
		frame.setSize(400, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//닫기 버튼
		
		JButton btn = new JButton("tlqkf");
		//frame.add(btn);
		
		JLabel label = new JLabel("라벨");
		//frame.add(label);
		
		JTextField textField = new JTextField(30);
		//frame.add(textField);
		
		JTextArea textArea = new JTextArea(20,30);
		textArea.append("다덤벼 \n");
		textArea.append("쫄?");
		textArea.setEditable(false);
		//frame.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(btn);
		panel.add(label);
		panel.add(textField);
		panel.add(textArea);
		
		frame.add(panel);
		frame.setVisible(true);//화면에 보여줄지 말지.. 이거 맨 마지막에 해야 보이네
	}
}
