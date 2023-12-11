import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class Button {
	public static JButton ArialButton(String name , int width , int height) {
		JButton btn = new JButton(name);
		btn.setFont(new Font("Arial" , Font.PLAIN , 20));
		btn.setPreferredSize(new Dimension(width , height));
		return btn;
	}
	
	
	public static JButton MSButton(String name , int width , int height , int size) {
		JButton btn = new JButton(name);
		btn.setFont(new Font("MSゴシック" ,Font.BOLD , size));
		btn.setPreferredSize(new Dimension(width , height));
		return btn;
		
	}
}

