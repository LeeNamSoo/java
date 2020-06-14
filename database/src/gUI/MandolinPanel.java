package gUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dataBase.DataBase;
import enumType.Builder;
import enumType.Type;
import enumType.Wood;
import uTill.AnalysisHashMapUtil;

public class MandolinPanel extends JPanel implements ActionListener {
	private JTextField priceText;
	private JTextField serialNumText;
	private JTextField modelStringText;
	private JLabel serialnumLabel = new JLabel("시리얼 넘버");
	private JLabel priceLabel = new JLabel("가 격");
	private JLabel modelNameLabel = new JLabel("모델 명");
	private JLabel styleLabel = new JLabel("스타일");
	private JLabel BuilderLabel = new JLabel("제 조 사");
	private JLabel topWoodLabel = new JLabel("앞판 나무");
	private JLabel backWoodLabel = new JLabel("뒷판 나무");
	private JComboBox styleCombo = new JComboBox(enumType.Style.values());
	private JComboBox BuilderCombo = new JComboBox(Builder.values());
	private JComboBox backWoodCombo = new JComboBox(Wood.values());
	private JComboBox topWoodCombo = new JComboBox(Wood.values());
	private JButton searchButton = new JButton("검 색");
	private JButton addButton = new JButton("추 가");
	private JButton deleteButton = new JButton("판 매");
	private JList mandolinList = new JList();
	private JScrollPane scrollPane = new JScrollPane();
	private List showmandolinList;
	private DataBase db;
	private DefaultListModel dlm;

	public MandolinPanel() {
		setLayout(null);
		Color[] color = {new Color(255,128,0), new Color(251,33,13),new Color(15,223,0),new Color(72,22,243),new Color(236,12,253)};
		
		serialnumLabel.setBounds(37, 31, 70, 15);
		add(serialnumLabel);

		priceText = new JTextField();
		priceText.setBounds(119, 53, 116, 21);
		add(priceText);
		priceText.setColumns(10);

		priceLabel.setBounds(37, 56, 34, 15);
		add(priceLabel);

		serialNumText = new JTextField();
		serialNumText.setColumns(10);
		serialNumText.setBounds(119, 28, 116, 21);
		add(serialNumText);

		modelNameLabel.setBounds(37, 81, 70, 15);
		add(modelNameLabel);

		styleLabel.setBounds(37, 106, 70, 15);
		add(styleLabel);

		styleCombo.setBounds(119, 103, 116, 21);
		styleCombo.setBackground(new Color(236,12,253));
		add(styleCombo);

		BuilderLabel.setBounds(37, 131, 70, 15);
		add(BuilderLabel);

		BuilderCombo.setBounds(119, 128, 116, 21);
		BuilderCombo.setBackground(new Color(15,223,0));
		add(BuilderCombo);

		backWoodLabel.setBounds(37, 156, 70, 15);
		add(backWoodLabel);

		topWoodLabel.setBounds(37, 181, 70, 15);
		add(topWoodLabel);

		backWoodCombo.setBounds(119, 153, 116, 21);
		backWoodCombo.setBackground(new Color(255,128,0));
		add(backWoodCombo);

		topWoodCombo.setBounds(119, 178, 116, 21);
		topWoodCombo.setBackground(new Color(255,128,0));
		add(topWoodCombo);

		searchButton.setBounds(20, 250, 80, 40);
		searchButton.setBackground(new Color(15,223,0));
		add(searchButton);
		searchButton.addActionListener(this);

		addButton.setBounds(100, 250, 80, 40);
		addButton.setBackground(new Color(255,128,0));
		add(addButton);
		addButton.addActionListener(this);

		deleteButton.setBounds(180, 250, 80, 40);
		deleteButton.setBackground(new Color(251,33,13));
		add(deleteButton);
		deleteButton.addActionListener(this);

		modelStringText = new JTextField();
		modelStringText.setColumns(10);
		modelStringText.setBounds(119, 78, 116, 21);
		add(modelStringText);

		scrollPane.setBounds(0, 350, 500, 400);
		add(scrollPane);
		scrollPane.setViewportView(mandolinList);
		db = db.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == deleteButton) {
			Map<String, String> property = new HashMap<String, String>();
			property.put("serialnum", serialNumText.getText().toLowerCase());

			db.mandolinDeleteRecord(property);
		} else if (e.getSource() == addButton) {
			Map<String, String> property = new HashMap<String, String>();
			property.put("model", modelStringText.getText().toLowerCase());
			property.put("style", enumType.Style.toString(styleCombo.getSelectedIndex()));
			property.put("backwood", Wood.toString(backWoodCombo.getSelectedIndex()));
			property.put("topwood", Wood.toString(topWoodCombo.getSelectedIndex()));
			property.put("builder", Builder.toString(BuilderCombo.getSelectedIndex()));
			property.put("serialnum", serialNumText.getText().toLowerCase());
			property.put("price", priceText.getText());

			db.mandolinInsertRecord(property);

		} else if (e.getSource() == searchButton) {
			Map<String, String> property = new HashMap<String, String>();
			property.put("model", modelStringText.getText().toLowerCase());
			property.put("style", enumType.Style.toString(styleCombo.getSelectedIndex()));
			property.put("backwood", Wood.toString(backWoodCombo.getSelectedIndex()));
			property.put("topwood", Wood.toString(topWoodCombo.getSelectedIndex()));
			property.put("builder", Builder.toString(BuilderCombo.getSelectedIndex()));

			showmandolinList = AnalysisHashMapUtil.analysisHashMap(db.mandolinSelectRecord(property));
			updateList();
		}
	}

	private void updateList() {
		dlm = new DefaultListModel();
		for (int i = 0; i < showmandolinList.size(); i++) {
			dlm.addElement(showmandolinList.get(i));
		}
		mandolinList.setModel(dlm);
		mandolinList.setSelectedIndex(0);
	}
}

