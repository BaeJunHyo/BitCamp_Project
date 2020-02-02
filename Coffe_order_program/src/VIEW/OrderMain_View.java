package VIEW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.xml.transform.Source;

import DTO.OrderTotal_Dto;
import SingleTon.Singleton;

public class OrderMain_View extends JFrame implements ActionListener {
	private JButton menuBt, allBt, oneBt;
	private JRadioButton small_Rbt, tall_Rbt, grande_Rbt;
	private JRadioButton vanila_Rbt, caramel_Rbt, heizle_Rbt;
	private ButtonGroup size_Bg, syrup_Bg;
	private JCheckBox shot_Cb, cream_Cb;
	private JTextField drinkCount_Txtf;
	private JComboBox<String> drink_Combo;

	String drink[] = { "헤이즐넛 카라멜 모카", "카라멜 마끼아또", "화이트 초콜릿 모카", "카라멜 모카", "카페 모카", "카라멜 라떼", "카페 라떼", "카푸치노", "아메리카노",
			"오늘의 커피" };

	public OrderMain_View() {
		super("주문");
		setLayout(null);

		JLabel choiceLabel = new JLabel("Menu Choice");
		choiceLabel.setBounds(50, 10, 80, 40);
		add(choiceLabel);

		drink_Combo = new JComboBox<String>(drink);
		drink_Combo.setBounds(150, 10, 250, 40);
		add(drink_Combo);

		menuBt = new JButton("Menu");
		menuBt.setBounds(420, 10, 70, 40);
		add(menuBt);
		
		menuBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.menu_controller.MenuList();

			}
		});

		JLabel sizeLabel = new JLabel("Size");
		sizeLabel.setBounds(50, 120, 70, 50);
		add(sizeLabel);

		small_Rbt = new JRadioButton("small");
		tall_Rbt = new JRadioButton("tall");
		grande_Rbt = new JRadioButton("grande");

		size_Bg = new ButtonGroup();
		size_Bg.add(small_Rbt);
		size_Bg.add(tall_Rbt);
		size_Bg.add(grande_Rbt);

		small_Rbt.setBounds(50, 170, 100, 50);
		tall_Rbt.setBounds(50, 200, 100, 50);
		grande_Rbt.setBounds(50, 230, 100, 50);

		add(small_Rbt);
		add(tall_Rbt);
		add(grande_Rbt);

		JLabel syrupLabel = new JLabel("시럽");
		syrupLabel.setBounds(230, 120, 70, 50);
		add(syrupLabel);

		vanila_Rbt = new JRadioButton("바닐라");
		caramel_Rbt = new JRadioButton("카라멜");
		heizle_Rbt = new JRadioButton("헤이즐럿");

		syrup_Bg = new ButtonGroup();
		syrup_Bg.add(vanila_Rbt);
		syrup_Bg.add(caramel_Rbt);
		syrup_Bg.add(heizle_Rbt);

		vanila_Rbt.setBounds(230, 170, 100, 50);
		caramel_Rbt.setBounds(230, 200, 100, 50);
		heizle_Rbt.setBounds(230, 230, 100, 50);

		add(vanila_Rbt);
		add(caramel_Rbt);
		add(heizle_Rbt);

		JLabel etcLabel = new JLabel("기타");
		etcLabel.setBounds(410, 120, 70, 50);
		add(etcLabel);

		shot_Cb = new JCheckBox("샷추가");
		cream_Cb = new JCheckBox("휘핑크림");

		shot_Cb.setBounds(410, 170, 100, 50);
		cream_Cb.setBounds(410, 200, 100, 50);
		add(shot_Cb);
		add(cream_Cb);

		drinkCount_Txtf = new JTextField();
		drinkCount_Txtf.setBounds(180, 330, 50, 50);
		add(drinkCount_Txtf);

		JLabel count = new JLabel("잔");
		count.setBounds(250, 330, 50, 50);
		add(count);

		allBt = new JButton("이전주문");
		allBt.setBounds(50, 330, 100, 50);
		add(allBt);

		allBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.dto = s.total_controller.listShow(s.getLoginID());
//				s.total_controller.cartView(s.dto);
				s.total_controller.allView(s.dto);

			}
		});

		oneBt = new JButton("주문하기");
		oneBt.setBounds(300, 330, 100, 50);
		add(oneBt);

		oneBt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "주문완료");
				Singleton s = Singleton.getInstance();
				String coffe = null;
				String size = null;
				String syrup = null;
				String shot = null;
				String cream = null;
				int drinkCount = 0;

				// 커피종류
				if (drink_Combo.isShowing()) {
					System.out.println("선택한 커피 =" + drink_Combo.getSelectedItem());
					coffe = (String) drink_Combo.getSelectedItem();
				}

				// 사이즈
				if (small_Rbt.isSelected()) {
					System.out.println("선택한 사이즈 = " + small_Rbt.getLabel());
					size = small_Rbt.getLabel();
				} else if (tall_Rbt.isSelected()) {
					System.out.println("선택한 사이즈 = " + tall_Rbt.getLabel());
					size = tall_Rbt.getLabel();
				} else if (grande_Rbt.isSelected()) {
					System.out.println("선택한 사이즈 = " + grande_Rbt.getLabel());
					size = grande_Rbt.getLabel();
				}

				// 시럽
				if (caramel_Rbt.isSelected()) {
					System.out.println("선택한 시럽 = " + caramel_Rbt.getLabel());
					syrup = caramel_Rbt.getLabel();
				} else if (heizle_Rbt.isSelected()) {
					System.out.println("선택한 시럽 = " + heizle_Rbt.getLabel());
					syrup = heizle_Rbt.getLabel();
				} else if (vanila_Rbt.isSelected()) {
					System.out.println("선택한 시럽 = " + vanila_Rbt.getLabel());
					syrup = vanila_Rbt.getLabel();
				}

				// 기타

				if (shot_Cb.isSelected() && cream_Cb.isSelected()) {
					System.out.println("기타 = " + shot_Cb.getLabel() + " + " + cream_Cb.getLabel());
					shot = "O";
					cream = "O";
				} else if (cream_Cb.isSelected()) {
					System.out.println("기타 = " + cream_Cb.getLabel());
					cream = "O";
				} else if (shot_Cb.isSelected()) {
					System.out.println("기타 = " + shot_Cb.getLabel());
					shot = "O";
				}
				// 몇잔
				System.out.println(drinkCount_Txtf.getText() + "잔 ");

				drinkCount = Integer.parseInt(drinkCount_Txtf.getText().trim());

				s.dto.clear();
				OrderTotal_Dto dto = s.total_controller.cartList(coffe, size, syrup, shot, cream, drinkCount);
				s.dto.add(dto);
				s.total_controller.cartView(s.dto);

			}
		});

		setBounds(100, 100, 550, 480);
		getContentPane().setBackground(Color.gray);
		setVisible(true);

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
