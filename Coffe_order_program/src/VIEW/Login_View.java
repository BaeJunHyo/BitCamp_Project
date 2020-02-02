package VIEW;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import SingleTon.Singleton;

public class Login_View extends JFrame implements ActionListener {

	private JTextField idTxtF;
	private JPasswordField pwdTxtF;
	private JButton accAddBt,loginBt;
	

	
	//기본생성자
	public Login_View() {
		super("커피 주문 프로그램");
		setLayout(null);
		
		JLabel idLabel = new JLabel("ID:");
		idLabel.setBounds(31, 60, 67, 15);
		add(idLabel);
		
		idTxtF = new JTextField(10);
		idTxtF.setBounds(100, 60, 150, 20);
		add(idTxtF);
		
		JLabel passLabel = new JLabel("PW:");
		passLabel.setBounds(31, 104, 67, 15);
		add(passLabel);
		
		pwdTxtF = new JPasswordField();
		pwdTxtF.setBounds(100, 104, 150, 20);
		add(pwdTxtF);
				
		loginBt = new JButton("log-in");
		loginBt.setBounds(280, 60, 100, 65);
		loginBt.addActionListener(this);
		add(loginBt);
		
		accAddBt = new JButton("회원가입");
		accAddBt.setBounds(100, 150, 280, 40);
		accAddBt.addActionListener(this);
		add(accAddBt);
		
		setBounds(100, 100, 420, 280);
		getContentPane().setBackground(Color.gray);
		setVisible(true);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		Singleton s = Singleton.getInstance();
		if(btn == accAddBt) {
			s.mem_controller.account_Add_View();
			this.dispose();
		}else if(btn == loginBt) {
			s.mem_controller.login(idTxtF.getText(),pwdTxtF.getText());
			this.dispose();
		}
	}

	
}
