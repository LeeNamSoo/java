package report;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import report.CR_GUI;

//import com.sun.java.util.jar.pack.Attribute.Layout;

public class Create_GUI implements ActionListener {

	Frame f; // 프레임생성
	GridLayout grid;
	Panel p; // 패널생성

	TextField tf_serialNumber;
	TextField tf_price;
	TextField tf_builder; // 텍스트필드생성
	TextField tf_model;
	TextField tf_type;
	TextField tf_numStrings;
	TextField tf_backWood;
	TextField tf_topWood;
	Label lb_serialNumber;
	Label lb_price;
	Label lb_builder;
	Label lb_model;
	Label lb_type;
	Label lb_numStrings;
	Label lb_backWood;
	Label lb_topWood;
	Button btn_create;
	Button btn_back;
	CR_GUI cr;
	Guitar_Database db;
	GuitarSpec spec;

	public Create_GUI() {
		// TODO Auto-generated constructor stub
		f = new Frame("텍스트필드 테스트"); // 프레임생성
		grid = new GridLayout(9, 2);
		p = new Panel(); // 패널생성
		p.setLayout(grid);

		tf_serialNumber = new TextField(12);
		tf_price = new TextField(12);
		tf_builder = new TextField(12); // 텍스트필드생성
		tf_model = new TextField(12);
		tf_type = new TextField(12);
		tf_numStrings = new TextField(12);
		tf_backWood = new TextField(12);
		tf_topWood = new TextField(12);
		lb_serialNumber = new Label("serialNumber : ");
		lb_price = new Label("price : ");
		lb_builder = new Label("builder : ");
		lb_model = new Label("model : ");
		lb_type = new Label("type : ");
		lb_numStrings = new Label("numStrings : ");
		lb_backWood = new Label("backWood : ");
		lb_topWood = new Label("topWood : ");
		btn_create = new Button("create");
		btn_back = new Button("back");

		tf_serialNumber.selectAll();
		tf_price.selectAll();
		tf_builder.selectAll();
		tf_model.selectAll();
		tf_type.selectAll();
		tf_numStrings.selectAll();
		tf_backWood.selectAll();
		tf_topWood.selectAll();

//		tf2.setEchoChar('*'); //문자가 *로 보임
		p.add(lb_serialNumber);
		p.add(tf_serialNumber);

		p.add(lb_price);
		p.add(tf_price);

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

		p.add(btn_create);
		p.add(btn_back);
		// 패널에 텍스트필드 집어넣음

		f.add(p);// 프레임에 패널집어넣음

		f.setSize(400, 400); // 프레임사이즈
		f.setVisible(true); // 생성

		btn_create.addActionListener(this);
		btn_back.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "create") {
			System.out.println("creat버튼 클릭");
			db = new Guitar_Database();
			db.creatDatabase(tf_serialNumber.getText(), Double.parseDouble(tf_price.getText()),
					new GuitarSpec(tf_builder.getText(), tf_model.getText(), tf_type.getText(),
							Integer.parseInt(tf_numStrings.getText()), tf_backWood.getText(), tf_topWood.getText()));

		} else if (e.getActionCommand() == "back") {
			System.out.println("back버튼 클릭");		
			this.f.setVisible(false);
			cr = new CR_GUI();

		}
	}
}
