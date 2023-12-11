import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;

public class TextField {
	public static JTextField makeText(String text) {
		JTextField field = new JTextField(text , 100);
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setFont(new Font("Arial" , Font.PLAIN , 20));
		field.setEditable(false);
		return field;
	}
	public static JTextField makeText(String text , Color color) {
		JTextField field = new JTextField(text , 100);
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setFont(new Font("Arial" , Font.PLAIN , 20));
		field.setBackground(Color.ORANGE);
		field.setEditable(false);
		return field;
	}
}

