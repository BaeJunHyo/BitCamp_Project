package VIEW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DTO.OrderTotal_Dto;
import SingleTon.Singleton;

public class All_View extends JFrame implements ActionListener{
	
	private JTable jtable;
	private JScrollPane jscrPane;
	private JLabel totalpay;

	String menuList[] = {"음료명","주문일시","사이즈","수량","금액","주문자"};
	Object rowData[][];
	DefaultTableModel model;
	
	List<OrderTotal_Dto> list = null;

	public All_View(List<OrderTotal_Dto> list) {
		// TODO Auto-generated constructor stub
		super("이전주문내역");
		int total =0;
		setLayout(null);
		
		this.list = list;
		
		rowData = new Object[list.size()][6];
		
		for (int i = 0; i < list.size(); i++) {
			OrderTotal_Dto dto = list.get(i);
			
			rowData[i][0] = dto.getDrink();
			rowData[i][1] = dto.getOrderDate();
			rowData[i][2] = dto.getSize();
			rowData[i][3] = dto.getDrinkCount();
			rowData[i][4] = dto.getPayTotal();
			rowData[i][5] = dto.getId();
			total = total + dto.getPayTotal();
		}
		
		model = new DefaultTableModel(menuList, 0);
		model.setDataVector(rowData, menuList);
		
		jtable = new JTable(model);
		//jtable.addM
		
		jtable.getColumnModel().getColumn(0).setMaxWidth(200);
		jtable.getColumnModel().getColumn(1).setMaxWidth(150);
		jtable.getColumnModel().getColumn(2).setMaxWidth(70);
		jtable.getColumnModel().getColumn(3).setMaxWidth(70);
		jtable.getColumnModel().getColumn(4).setMaxWidth(100);
		jtable.getColumnModel().getColumn(5).setMaxWidth(70);
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		jtable.getColumn("음료명").setCellRenderer(celAlignCenter);
		jtable.getColumn("주문일시").setCellRenderer(celAlignCenter);
		jtable.getColumn("사이즈").setCellRenderer(celAlignCenter);
		jtable.getColumn("수량").setCellRenderer(celAlignCenter);
		jtable.getColumn("금액").setCellRenderer(celAlignCenter);
		jtable.getColumn("주문자").setCellRenderer(celAlignCenter);
//		"음료명","시럽","크기","샷추가","휘핑크림","잔","총액"
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		
		totalpay = new JLabel();
		totalpay.setText("총금액 : "+total);
		
		totalpay.setBounds(520, 370, 90, 50);
		add(totalpay);
		
		
		setBounds(100, 100, 640, 480);
		getContentPane().setBackground(Color.gray);
		setVisible(true);
		
		Singleton s = Singleton.getInstance();
		JOptionPane.showMessageDialog(null,s.getLoginID()+ "님 누적 구매금액 : "+total + "원");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
