package report;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UD_GUI implements ActionListener {

	Frame f;// 프레임생성
	Panel p1;// 패널생성
	Panel p2;// 패널생성
	GridLayout grid;

	Button btn_update;
	Button btn_delete;

	CR_GUI cr;
	Guitar_Database db;

	public UD_GUI() {
		// TODO Auto-generated constructor stub
		f = new Frame();
		p1 = new Panel();
		p2 = new Panel();

		btn_update = new Button("update");
		btn_delete = new Button("delete");

		p2.add(btn_update);
		p2.add(btn_delete);

		p1.setLayout(grid);
		f.add(p1, BorderLayout.NORTH);
		f.add(p2, BorderLayout.SOUTH);

		f.setSize(400, 400); // 프레임사이즈
		f.setVisible(true); // 생성
		btn_update.addActionListener(this);
		btn_delete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "update") {
			System.out.println("update버튼 클릭");
			db = new Guitar_Database();
			db.updateDatabase();
			System.out.println("자료변경");
			this.f.setVisible(false);
			cr = new CR_GUI();
		} else if (e.getActionCommand() == "delete") {
			System.out.println("delete버튼 클릭");
			db = new Guitar_Database();
			db.deleteDatabase();
			this.f.setVisible(false);
			cr = new CR_GUI();

		}
	}
}
