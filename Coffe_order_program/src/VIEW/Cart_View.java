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

import DTO.Menu_Dto;
import DTO.OrderTotal_Dto;
import SingleTon.Singleton;

public class Cart_View extends JFrame implements ActionListener {

	private JTable jtable;
	private JScrollPane jscrPane;
	private JButton requestBt,successBt;

	String menuList[] = {"음료명","시럽","크기","샷추가","크림추가","잔","총액","주문자"};
	Object rowData[][];
	DefaultTableModel model;
	
	
	
	List<OrderTotal_Dto> list = null;

	public Cart_View(List<OrderTotal_Dto> list) {
		super("주문내역");
		setLayout(null);
		
		this.list = list;
		
		rowData = new Object[list.size()][8];
		
		for (int i = 0; i < list.size(); i++) {
			OrderTotal_Dto dto = list.get(i);
			
			rowData[i][0] = dto.getDrink();
			rowData[i][1] = dto.getSyrup();
			rowData[i][2] = dto.getSize();
			rowData[i][3] = dto.getShot();
			rowData[i][4] = dto.getCream();
			rowData[i][5] = dto.getDrinkCount();
			rowData[i][6] = dto.getPayTotal();
			rowData[i][7] = dto.getId();
			
		}
		
		model = new DefaultTableModel(menuList, 0);
		model.setDataVector(rowData, menuList);
		
		jtable = new JTable(model);
		//jtable.addM
		
		jtable.getColumnModel().getColumn(0).setMaxWidth(200);
		jtable.getColumnModel().getColumn(1).setMaxWidth(70);
		jtable.getColumnModel().getColumn(2).setMaxWidth(70);
		jtable.getColumnModel().getColumn(3).setMaxWidth(70);
		jtable.getColumnModel().getColumn(4).setMaxWidth(70);
		jtable.getColumnModel().getColumn(5).setMaxWidth(70);
		jtable.getColumnModel().getColumn(6).setMaxWidth(70);
		jtable.getColumnModel().getColumn(7).setMaxWidth(70);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		jtable.getColumn("시럽").setCellRenderer(celAlignCenter);
		jtable.getColumn("크기").setCellRenderer(celAlignCenter);
		jtable.getColumn("샷추가").setCellRenderer(celAlignCenter);
		jtable.getColumn("크림추가").setCellRenderer(celAlignCenter);
		jtable.getColumn("잔").setCellRenderer(celAlignCenter);
		jtable.getColumn("총액").setCellRenderer(celAlignCenter);
		jtable.getColumn("주문자").setCellRenderer(celAlignCenter);
//		"음료명","시럽","크기","샷추가","휘핑크림","잔","총액"
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		setBounds(100, 100, 640, 480);
		getContentPane().setBackground(Color.gray);
		setVisible(true);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		requestBt,successBt
		requestBt = new JButton("주문취소");
		requestBt.setBounds(400, 370, 90, 50);
		add(requestBt);
		
		requestBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		successBt = new JButton("주문하기");
		successBt.setBounds(520, 370, 90, 50);
		add(successBt);
		
		successBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				
				
				OrderTotal_Dto dto = null;
				
				
				for (int i = 0; i < list.size(); i++) {
					dto = list.get(i);
//					coffe = dto.getDrink();
//					syrup = dto.getSyrup();
//					size = dto.getSize();
//					shot = dto.getShot();
//					cream = dto.getCream();
//					count = dto.getDrinkCount();
//					total = dto.getPayTotal();
//					orderId = dto.getId();
					
					
				}
				s.total_controller.addOrder(dto);
				JOptionPane.showMessageDialog(null, "주문완료");
//				여기서부터!!!!!!!!!!
				dispose();
				
				
			}
		});
		
		
		
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
