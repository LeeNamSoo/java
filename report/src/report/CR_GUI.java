package report;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CR_GUI extends Frame implements ActionListener {

	Frame f;// �����ӻ���
	Panel p;// �гλ���

	Button btn_create;// ��ư����
	Button btn_read;
	Button btn_update;
	Button btn_delete;
	Create_GUI create;
	Read_GUI read;
//	public static CRUD_GUI crud;
	public CR_GUI() {
		f = new Frame("��ư�׽�Ʈ");// �����ӻ���
		System.out.println("frame");
		p = new Panel();// �гλ���
		System.out.println("panel");

		btn_create = new Button("create");// ��ư����
		btn_read = new Button("read");
//		btn_update = new Button("update");
//		btn_delete = new Button("delete");
		System.out.println("btn");
//		b1.setLabel("�Է�");//��ư1�� �̸�����
		p.add(btn_create);// �гο� ��ư���̱�
		p.add(btn_read);
//		p.add(btn_update);
//		p.add(btn_delete);
		f.add(p);// �����ӿ��� �гκ��̱�
		System.out.println("add");
		f.setLocation(300, 300);// ��������ġ
		f.setSize(300, 100);// ������ũ��
		f.setVisible(true);// ������ ����

		btn_create.addActionListener(this);
		btn_read.addActionListener(this);

		System.out.println("listenar");

	}

	public static void main(String[] args) {
		CR_GUI crud = new CR_GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "create") {
			System.out.println("creat��ư Ŭ��");
			create = new Create_GUI();
			f.setVisible(false);
		} else if (e.getActionCommand() == "read") {
			System.out.println("read��ư Ŭ��");
			read = new Read_GUI();
			f.setVisible(false);
		}
	}

}
