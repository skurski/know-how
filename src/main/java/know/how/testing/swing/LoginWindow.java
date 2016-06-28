package know.how.testing.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginWindow extends JFrame {
	Model model = new Model();
	
	LoginWindow() {
		String[] labels = {"Imie: ", "Nazwisko: ", "Email: "};
		final JTextField[] fields = new JTextField[3];
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Person per = new Person(fields[0].getText(),
						fields[1].getText(), fields[2].getText());
				model.writeToFile(per); 
				System.out.println(model.readFromFile());
			}
		});
		
		JPanel panel = new JPanel(new GridLayout(labels.length, 2));
		
		int i=0;
		for(String str: labels) {
			panel.add(new JLabel(str, SwingConstants.RIGHT));
			panel.add(fields[i++] = new JTextField(20));
		}
		
		add(panel, BorderLayout.CENTER);
		add(submit, BorderLayout.SOUTH);
		pack();
	}
	
	void createGUI() {
		setTitle("login window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		LoginWindow login = new LoginWindow();
		login.createGUI();
	}
}