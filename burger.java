import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Scrollbar;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class burger extends JFrame {
	private static JTextField inputtxtday;   //txtfield for users day input
	private static JTextField inputtxtmonth; //txtfield for users day input
	private static JTextField inputtxtyear;  //txtfield for users day input
	private static JLabel lblOutput;
	static int year, month, day, K, M, D, C, sum, weekint;
	
	public static void enter() //method to check the user's guess
	{
		//get the users datas
		String uday = inputtxtday.getText();
		String umonth = inputtxtmonth.getText();
		String uyear = inputtxtyear.getText();
		
		//just a check if we can print to our output label
		int day = Integer.parseInt(uday);
		int month = Integer.parseInt(umonth);
		int year = Integer.parseInt(uyear);
		
		int[] monthValues = {11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		C = year / 100;
		M = monthValues[month - 1];
		
		if (month > 2) 
		{
			D = year % 100;
		}
		if (month <= 2) 
		{
			D = year % 100 - 1;
		}

		int sum = day + ((13 * M - 1)/5) + D + (D/4) + (C/4) - (2*C);
		int weekint = sum % 7;
		
		switch (weekint) {
		
		case 0:
			lblOutput.setText("Sunday");
			break;
		case 1:
			lblOutput.setText("Monday");
			break;
		case 2:
			lblOutput.setText("Tuesday");
			break;
		case 3:
			lblOutput.setText("Wednesday");
			break;
		case 4:
			lblOutput.setText("Thursday");
			break;
		case 5:
			lblOutput.setText("Friday");
			break;
		case 6:
			lblOutput.setText("Saturday");
			break;
		case 7:
			lblOutput.setText("Sunday");
			break;
		}	
		
	}
	
	
	public burger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Weekday calculator");
		getContentPane().setLayout(null);
		
		JLabel lbl = new JLabel("What day of the week were you born?");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl.setBounds(0, 11, 344, 25);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lbl);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(103, 64, 46, 14);
		getContentPane().add(lblDay);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(103, 89, 46, 14);
		getContentPane().add(lblMonth);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(103, 114, 46, 14);
		getContentPane().add(lblYear);
		
		inputtxtday = new JTextField();
		inputtxtday.setBounds(176, 61, 86, 20);
		getContentPane().add(inputtxtday);
		inputtxtday.setColumns(10);
		
		inputtxtmonth = new JTextField();
		inputtxtmonth.setColumns(10);
		inputtxtmonth.setBounds(176, 86, 86, 20);
		getContentPane().add(inputtxtmonth);
		
		inputtxtyear = new JTextField();
		inputtxtyear.setColumns(10);
		inputtxtyear.setBounds(176, 111, 86, 20);
		getContentPane().add(inputtxtyear);
		
		JLabel lbltxt = new JLabel("You were born on a: ");
		lbltxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbltxt.setBounds(38, 174, 128, 25);
		getContentPane().add(lbltxt);
		
		JButton btn = new JButton("Click");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enter();
			}
		});
		btn.setBounds(176, 142, 86, 20);
		getContentPane().add(btn);
		
		lblOutput = new JLabel("...");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOutput.setBounds(176, 176, 135, 20);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args)
	{
		burger theGame = new burger();
		theGame.setSize(new Dimension(345, 270));
		theGame.setVisible(true);
	}
}
