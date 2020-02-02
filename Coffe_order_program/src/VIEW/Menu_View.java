package VIEW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DTO.Menu_Dto;

public class Menu_View extends JFrame implements ActionListener {

	private JTable jtable;
	private JScrollPane jscrPane;
	String menuList[] = {"음료명","SMALL","TALL","GRANDE"};
	Object rowData[][];
	DefaultTableModel model;
	
	List<Menu_Dto> list = null;

	public Menu_View(List<Menu_Dto> list) {
		super("가격표");
		setLayout(null);
		
		this.list = list;
		
		rowData = new Object[list.size()][4];
		
		for (int i = 0; i < list.size(); i++) {
			Menu_Dto menu = list.get(i);
			
			rowData[i][0] = menu.getDrinkName();
			rowData[i][1] = menu.getSmall();
			rowData[i][2] = menu.getTall();
			rowData[i][3] = menu.getGrande();					
		}
		
		model = new DefaultTableModel(menuList, 0);
		model.setDataVector(rowData, menuList);
		
		jtable = new JTable(model);
		//jtable.addM
		
		jtable.getColumnModel().getColumn(0).setMaxWidth(200);
		jtable.getColumnModel().getColumn(1).setMaxWidth(110);
		jtable.getColumnModel().getColumn(2).setMaxWidth(110);
		jtable.getColumnModel().getColumn(3).setMaxWidth(110);
		
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		jtable.getColumn("음료명").setCellRenderer(celAlignCenter);
		jtable.getColumn("SMALL").setCellRenderer(celAlignCenter);
		jtable.getColumn("TALL").setCellRenderer(celAlignCenter);
		jtable.getColumn("GRANDE").setCellRenderer(celAlignCenter);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		setBounds(100, 100, 640, 480);
		getContentPane().setBackground(Color.gray);
		setVisible(true);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

	}

}
