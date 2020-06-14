package gUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class MainFrame  extends JFrame{
	//���������ӱ���
	GuitarPanel guitarPanel = new GuitarPanel();
	MandolinPanel mandolinPanel = new MandolinPanel();
	
	MainFrame() {
		
		setVisible(true);
		setSize(500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//�ǻ����Ͽ� ���� �ǿ� ���� �ٸ��г� �־��־� �Ǹ��� �ٸ� ȭ�� ����.
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 300, 700);
		getContentPane().add(tabbedPane);
		//��Ÿ�г���
		tabbedPane.add("��Ÿ", guitarPanel);
		guitarPanel.setLayout(null);
		//�������г���
		tabbedPane.add("������", mandolinPanel);
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}
}
