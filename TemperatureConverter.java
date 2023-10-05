import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton convertButton;
    private JButton clearButton;
    private JComboBox<String> scaleComboBox;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLayout(new GridLayout(4, 1));

        inputField = new JTextField();
        resultLabel = new JLabel("Result:");
        convertButton = new JButton("Convert");
        clearButton = new JButton("Clear");
        scaleComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});

        add(inputField);
        add(scaleComboBox);
        add(resultLabel);
        add(convertButton);
        add(clearButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                resultLabel.setText("Result:");
            }
        });
    }

    private void convertTemperature() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String selectedScale = (String) scaleComboBox.getSelectedItem();
            double result = 0;

            if (selectedScale.equals("Celsius")) {
                // Convert to Fahrenheit
                result = (inputValue * 9/5) + 32;
                resultLabel.setText("Result: " + result + " °F");
            } else if (selectedScale.equals("Fahrenheit")) {
                // Convert to Celsius
                result = (inputValue - 32) * 5/9;
                resultLabel.setText("Result: " + result + " °C");
            } else if (selectedScale.equals("Kelvin")) {
                // Convert to Celsius, then to Kelvin
                double celsius = (inputValue - 32) * 5/9;
                result = celsius + 273.15;
                resultLabel.setText("Result: " + result + " K");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TemperatureConverter converter = new TemperatureConverter();
                converter.setVisible(true);
            }
        });
    }
}
