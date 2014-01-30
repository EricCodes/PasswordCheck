import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class PasswordCheck extends JFrame{
	
	public Container contents;
	public String password = "";
	public int check = 5;
	public JTextField pass = new JTextField(password, 15);
	public JTextArea instruct = new JTextArea("Please enter the\n"
			+ "password you would\n"
			+ "like to check the strength of,\n"
			+ "then hit enter.");
	public JLabel inst1 = new JLabel("Please enter the");
	public JLabel inst2 = new JLabel("password you would");
	public JLabel inst3 = new JLabel("like to check the strength of,");
	public JLabel inst4 = new JLabel("then hit enter.");
	public JLabel strength = new JLabel("Password Strength: 0");
	
	public PasswordCheck()
	{
		super("Password");
		contents = getContentPane();
		contents.setLayout(new FlowLayout());
		
		pass.addActionListener(new TextFieldHandler());

		contents.add(inst1);
		contents.add(inst2);		
		contents.add(inst3);	
		contents.add(inst4);
		contents.add(pass);
		contents.add(strength);
		
		setSize(220,200);
		setResizable(false);
		setVisible(true);
		
	}
	
	private class TextFieldHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			password = pass.getText();
			strengthCheck();
			strength.setText("Password Strength: " + check);
			
			if(check >= 4)
				strength.setForeground(new Color(57,132,57));
			else if(check >= 2)
				strength.setForeground(new Color(240,173,78));
			else if(check >= 0)
				strength.setForeground(new Color(212,63,58));
			
		}
	}

	public void strengthCheck()
	{
		check = 5;
		
		if(password.length() >= 8)
		{
			for(int j = 0; j < password.length(); j++)
			{			
				if(password.charAt(j) == ' ')
				{
					check--;
					break;
				}
			}
		}
		else
		{
			check--;
		}
		for(int x = 0; x < password.length(); x++)
		{
			if(!Character.isLetterOrDigit(password.charAt(x)) && password.charAt(x) != ' ')
				break;
			if(x == (password.length() - 1))
			{
				check--;
				break;
			}
		}
		for(int y = 0; y < password.length(); y++)
		{
			if(Character.isUpperCase(password.charAt(y)))
				break;
			if(y == (password.length() - 1))
			{
				check--;
				break;
			}
		}
		for(int u = 0; u < password.length(); u++)
		{
			if(Character.isLowerCase(password.charAt(u)))
				break;
			if(u == (password.length() - 1))
			{
				check--;
				break;
			}
		}
		for(int p = 0; p < password.length(); p++)
		{
			if(Character.isDigit(password.charAt(p)))
				break;
			if(p == (password.length() - 1))
			{
				check--;
				break;
			}
		}
	}
	
	public static void main(String args[])
	{
		PasswordCheck p = new PasswordCheck();
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}