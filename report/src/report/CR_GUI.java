package report;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CR_GUI extends Frame implements ActionListener {

	Frame f;// 프레임생성
	Panel p;// 패널생성

	Button btn_create;// 버튼생성
	Button btn_read;
	Button btn_update;
	Button btn_delete;
	Create_GUI create;
	Read_GUI read;
//	public static CRUD_GUI crud;
	public CR_GUI() {
		f = new Frame("버튼테스트");// 프레임생성
		System.out.println("frame");
		p = new Panel();// 패널생성
		System.out.println("panel");

		btn_create = new Button("create");// 버튼생성
		btn_read = new Button("read");
//		btn_update = new Button("update");
//		btn_delete = new Button("delete");
		System.out.println("btn");
//		b1.setLabel("입력");//버튼1에 이름설정
		p.add(btn_create);// 패널에 버튼붙이기
		p.add(btn_read);
//		p.add(btn_update);
//		p.add(btn_delete);
		f.add(p);// 프레임에에 패널붙이기
		System.out.println("add");
		f.setLocation(300, 300);// 프레임위치
		f.setSize(300, 100);// 프레임크기
		f.setVisible(true);// 프레임 생성

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
			System.out.println("creat버튼 클릭");
			create = new Create_GUI();
			f.setVisible(false);
		} else if (e.getActionCommand() == "read") {
			System.out.println("read버튼 클릭");
			read = new Read_GUI();
			f.setVisible(false);
		}
	}

}
