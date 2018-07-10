package exercise4_18;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;

//Exercise 4.18
public class ClockIcon extends JPanel implements Icon {

	private final int hourHandLength = 30;
	private final int minHandLength = 40;
	private final int secondHandLength = 45;

	private GregorianCalendar cal;
	private final int clockCenterX = 60;
	private final int clockCenterY = 60;

	public ClockIcon(GregorianCalendar cal) {
		this.cal = cal;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * @return the current time hour
	 */
	public int getHour() {
		int hr = cal.get(Calendar.HOUR);
		if (hr == 0) {
			return 12;
		}
		return hr % 12;
	}

	/**
	 * 
	 * @return the current time minute 
	 */
	public int getMin() {
		int min = cal.get(Calendar.MINUTE);
		return min;
	}

	/**
	 * 
	 * @return the current time secconds
	 */
	public int getSec() {
		int sec = cal.get(Calendar.SECOND);
		return sec;
	}


	public int getX(double angle, int handLength) {
		double v = Math.cos(angle);
		int x = (int) (handLength * v) + clockCenterX;
		return x;
	}

	public int getY(double ang, int handLength) {
		double v = Math.sin(ang);
		int y = (int) (handLength * v) + clockCenterY;
		return y;
	}

	/**
	 * 
	 * @param num is the hour,min, or sec
	 * @param type the type hour, min, or sec
	 * @return the angle of the type
	 */
	public double getAngle(int num, int type) {
		double angleInDegrees = 0.0;
		if (type == Calendar.HOUR) {
			int v = num - 3;
			angleInDegrees = v * 30;
		} else if (type == Calendar.MINUTE || type == Calendar.SECOND) {
			int v = num - 15;
			angleInDegrees = v * 6;
		}

		double angleInRadians = (Math.PI / 180) * angleInDegrees;
		return angleInRadians;
	}

	@Override
	public void paintIcon(Component arg0, Graphics g, int arg2, int arg3) {
		// TODO Auto-generated method stub

		g.setColor(Color.BLACK);
		g.drawOval(10, 10, 100, 100);

		// Hours hand
		double angle = getAngle(getHour(), Calendar.HOUR);
		int x = getX(angle, hourHandLength);
		int y = getY(angle, hourHandLength);
		g.drawLine(clockCenterX, clockCenterY, x, y);

		// Minutes hand
		angle = getAngle(getMin(), Calendar.MINUTE);
		int minX = getX(angle, minHandLength);
		int minY = getY(angle, minHandLength);
		g.drawLine(clockCenterX, clockCenterY, minX, minY);

		// Second hand
		angle = getAngle(getSec(), Calendar.SECOND);
		int secX = getX(angle, secondHandLength);
		int secY = getY(angle, secondHandLength);
		g.setColor(Color.RED);
		g.drawLine(clockCenterX, clockCenterY, secX, secY);

	}

}
