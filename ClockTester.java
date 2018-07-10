package exercise4_18;

import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
//Exercise 4.18 OF OOD 151
public class ClockTester {

	public static void main(String[] args)
	{
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(cal.getTime());
		JFrame frame = new JFrame();
		frame.setSize(200, 250);
		JLabel label = new JLabel(new ClockIcon(cal));
		label.setLayout(new GridLayout(2, 2));
		frame.setContentPane(label);
		
		label.add(new JLabel(new ClockIcon(cal)));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
		frame.setVisible(true);
	}
}

