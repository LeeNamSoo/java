package report;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Read_GUI implements ActionListener {

	Frame f; // �����ӻ���
	GridLayout grid;
	Panel p; // �гλ���

	TextField tf_builder; // �ؽ�Ʈ�ʵ����
	TextField tf_model;
	TextField tf_type;
	TextField tf_numStrings;
	TextField tf_backWood;
	TextField tf_topWood;
	Label lb_builder;
	Label lb_model;
	Label lb_type;
	Label lb_numStrings;
	Label lb_backWood;
	Label lb_topWood;
	Button btn_read;
	Button btn_back;
	CR_GUI cr;
	UD_GUI ud;
	Guitar_Database db;

	public Read_GUI() {
		// TODO Auto-generated constructor stub
		f = new Frame("�ؽ�Ʈ�ʵ� �׽�Ʈ"); // �����ӻ���
		grid = new GridLayout(7, 2);
		p = new Panel(); // �гλ���
		p.setLayout(grid);

		tf_builder = new TextField(12); // �ؽ�Ʈ�ʵ����
		tf_model = new TextField(12);
		tf_type = new TextField(12);
		tf_numStrings = new TextField(12);
		tf_backWood = new TextField(12);
		tf_topWood = new TextField(12);
		lb_builder = new Label("builder : ");
		lb_model = new Label("model : ");
		lb_type = new Label("type : ");
		lb_numStrings = new Label("numStrings : ");
		lb_backWood = new Label("backWood : ");
		lb_topWood = new Label("topWood : ");
		btn_read = new Button("read");
		btn_back = new Button("back");

		tf_builder.selectAll();
		tf_model.selectAll();
		tf_type.selectAll();
		tf_numStrings.selectAll();
		tf_backWood.selectAll();
		tf_topWood.selectAll();

//				tf2.setEchoChar('*'); //���ڰ� *�� ����
		p.add(lb_builder);
		p.add(tf_builder);

		p.add(lb_model);
		p.add(tf_model);

		p.add(lb_type);
		p.add(tf_type);

		p.add(lb_numStrings);
		p.add(tf_numStrings);

		p.add(lb_backWood);
		p.add(tf_backWood);

		p.add(lb_topWood);
		p.add(tf_topWood);

		p.add(btn_read);
		p.add(btn_back);
		// �гο� �ؽ�Ʈ�ʵ� �������

		f.add(p);// �����ӿ� �г��������

		f.setSize(400, 400); // �����ӻ�����
		f.setVisible(true); // ����

		btn_read.addActionListener(this);
		btn_back.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "read") {
			System.out.println("read��ư Ŭ��");
			db = new Guitar_Database();
			db.readDatabase();
			this.f.setVisible(false);
			ud = new UD_GUI();
			
		} else if (e.getActionCommand() == "back") {
			System.out.println("back��ư Ŭ��");
			this.f.setVisible(false);
			cr = new CR_GUI();
		}
	}
}
