import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class Label {
	public static JLabel MSLabel(String text , int size , int width , int height) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("MSゴシック" , Font.BOLD , size));
		label.setPreferredSize(new Dimension(width , height));
		label.setHorizontalAlignment(JLabel.CENTER);
		return label;
		
	}
	public static JLabel ArialLabel(String text , Color color) {
		JLabel label = new JLabel(text);
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setForeground(color);
		return label;
	}
}