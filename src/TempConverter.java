
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * @author ahmad
 *
 */
public class TempConverter extends JFrame {
	private JLabel label1, label2; 
	private JTextField fahrenheitTemp; 
	private JTextField celsiusTemp; 
	private JPanel fpanel; 
	private JPanel cpanel;
	private JPanel sliderPanel;
	private JSlider slider; 
	public TempConverter() {
		// Set the title.
		setTitle("Temperatures");

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the message labels.
		label1 = new JLabel("Fahrenheit: ");
		label2 = new JLabel("Celsius: ");

		// Create the read-only text fields.
		readOnly();

		// Create the slider.
		createSlider();

		// Create panels and place the components in them.
		createPanels();

		// Create a GridLayout manager.
		setLayout(new GridLayout(3, 1));

		// Add the panels to the content pane.
		add(fpanel);
		add(cpanel);
		add(sliderPanel);

		// Pack and display the frame.
		pack();
		setVisible(true);
	}



	/**
	 * 
	 */
	private void readOnly() {
		fahrenheitTemp = new JTextField("32.0", 10);
		fahrenheitTemp.setEditable(false);
		celsiusTemp = new JTextField("0.0", 10);
		celsiusTemp.setEditable(false);
	}



	/**
	 * 
	 */
	private void createPanels() {
		fpanel = new JPanel();
		fpanel.add(label1);
		fpanel.add(fahrenheitTemp);
		cpanel = new JPanel();
		cpanel.add(label2);
		cpanel.add(celsiusTemp);
		sliderPanel = new JPanel();
		sliderPanel.add(slider);
	}



	/**
	 * 
	 */
	private void createSlider() {
		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		slider.setMajorTickSpacing(20); // Major tick every 20
		slider.setMinorTickSpacing(5); // Minor tick every 5
		slider.setPaintTicks(true); // Display tick marks
		slider.setPaintLabels(true); // Display numbers
		slider.addChangeListener(new SliderListener());
	}
	
	
	
	private class SliderListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			double fahrenheit, celsius;
			DecimalFormat fmt = new DecimalFormat("0.0");

			// Get the slider value.
			celsius = slider.getValue();

			// Convert the value to Fahernheit.
			fahrenheit = (9.0 / 5.0) * celsius + 32.0;

			// Store the celsius temp in its display field.
			celsiusTemp.setText(Double.toString(celsius));

			// Store the Fahrenheit temp in its display field.
			fahrenheitTemp.setText(fmt.format(fahrenheit));
		}
	}
	
}
