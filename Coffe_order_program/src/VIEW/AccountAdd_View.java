package VIEW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import SingleTon.Singleton;

public class AccountAdd_View extends JFrame implements ActionListener {
	
	private JTextField idTxtF;
	private JTextField pwTxtF;
	private JTextField nameTxtF;
	private JTextField ageTxtF;//age로

	private JButton accBt;
	private JButton idBt;
	
	
	public AccountAdd_View() {
		
		super("회원가입");
		setLayout(null);

		JLabel loginLabel = new JLabel("회원가입 화면");
		loginLabel.setBounds(100, 10, 120, 15);
		add(loginLabel);

		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(31, 60, 67, 15);
		add(idLabel);

		idTxtF = new JTextField();
		idTxtF.setBounds(100, 60, 150, 20);
		add(idTxtF);
		idTxtF.setColumns(10);

		idBt = new JButton("check");
		idBt.addActionListener(this);
		idBt.setBounds(260, 60, 70, 20);
		add(idBt);

		JLabel passLabel = new JLabel("PassWord:");
		passLabel.setBounds(31, 104, 67, 15);
		add(passLabel);

		pwTxtF = new JTextField();
		pwTxtF.setBounds(100, 104, 150, 20);
		add(pwTxtF);

		JLabel nameLabel = new JLabel("이름:");
		nameLabel.setBounds(31, 148, 67, 15);
		add(nameLabel);

		nameTxtF = new JTextField();
		nameTxtF.setBounds(100, 148, 150, 20);
		add(nameTxtF);

		JLabel ageLabel = new JLabel("Age:");
		ageLabel.setBounds(31, 192, 67, 15);
		add(ageLabel);

		ageTxtF = new JTextField();
		ageTxtF.setBounds(100, 192, 150, 20);
		add(ageTxtF);

		accBt = new JButton("회원가입");
		accBt.addActionListener(this);
		accBt.setBounds(31, 236, 280, 50);
		add(accBt);

		getContentPane().setBackground(Color.gray);
		setBounds(100, 100, 350, 400);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		Singleton s = Singleton.getInstance();
		
		if(btn == idBt) {
//			boolean b = s.memCtrl.idCheck( idTextF.getText() );
//			if(b) {
//				JOptionPane.showMessageDialog(null, "사용할 수 없는 id 입니다");
//				idTextF.setText("");
//			}else {
//				JOptionPane.showMessageDialog(null, idTextF.getText() + "는 사용할 수 있습니다");
//			}
		}else if(btn == accBt) {
			// 빈칸첵크
			
			s.mem_controller.accAdd(idTxtF.getText(), 
									pwTxtF.getText(), 
									nameTxtF.getText(), 
									ageTxtF.getText());
			
			this.dispose();
		}	
	}

}
