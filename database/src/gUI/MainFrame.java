package gUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class MainFrame  extends JFrame{
	//메인프레임구현
	GuitarPanel guitarPanel = new GuitarPanel();
	MandolinPanel mandolinPanel = new MandolinPanel();
	
	MainFrame() {
		
		setVisible(true);
		setSize(500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//탭생성하여 각각 탭에 대해 다른패널 넣어주어 탭마다 다른 화면 구성.
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 300, 700);
		getContentPane().add(tabbedPane);
		//기타패널탭
		tabbedPane.add("기타", guitarPanel);
		guitarPanel.setLayout(null);
		//만돌린패널탭
		tabbedPane.add("만돌린", mandolinPanel);
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
