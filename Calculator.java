import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private JButton buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEq, buttonClr;
    private double num1, num2;
    private char operator;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        textField = new JTextField(20);
        textField.setEditable(false);

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonAdd = new JButton("+");
        buttonSub = new JButton("-");
        buttonMul = new JButton("*");
        buttonDiv = new JButton("/");
        buttonEq = new JButton("=");
        buttonClr = new JButton("C");

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSub.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonEq.addActionListener(this);
        buttonClr.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonDiv);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(buttonMul);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(buttonSub);
        buttonPanel.add(button0);
        buttonPanel.add(buttonEq);
        buttonPanel.add(buttonClr);
        buttonPanel.add(buttonAdd);

        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button0) {
            textField.setText(textField.getText() + "0");
        } else if (e.getSource() == button1) {
            textField.setText(textField.getText() + "1");
        } else if (e.getSource() == button2) {
            textField.setText(textField.getText() + "2");
        } else if (e.getSource() == button3) {
            textField.setText(textField.getText() + "3");
        } else if (e.getSource() == button4) {
            textField.setText(textField.getText() + "4");
        } else if (e.getSource() == button5) {
            textField.setText(textField.getText() + "5");
        } else if (e.getSource() == button6) {
            textField.setText(textField.getText() + "6");
        } else if (e.getSource() == button7) {
            textField.setText(textField.getText() + "7");
        } else if (e.getSource() == button8) {
            textField.setText(textField.getText() + "8");
		} else if (e.getSource() == button9) {
		textField.setText(textField.getText() + "9");
		} else if (e.getSource() == buttonAdd) {
		num1 = Double.parseDouble(textField.getText());
		operator = '+';
		textField.setText("");
		} else if (e.getSource() == buttonSub) {
		num1 = Double.parseDouble(textField.getText());
		operator = '-';
		textField.setText("");
		} else if (e.getSource() == buttonMul) {
		num1 = Double.parseDouble(textField.getText());
		operator = '*';
		textField.setText("");
		} else if (e.getSource() == buttonDiv) {
		num1 = Double.parseDouble(textField.getText());
		operator = '/';
		textField.setText("");
		} else if (e.getSource() == buttonEq) {
		num2 = Double.parseDouble(textField.getText());
		switch (operator) {
		case '+':
		textField.setText(String.valueOf(num1 + num2));
		break;
		case '-':
		textField.setText(String.valueOf(num1 - num2));
		break;
		case '*':
		textField.setText(String.valueOf(num1 * num2));
		break;
		case '/':
		if (num2 == 0) {
		JOptionPane.showMessageDialog(null, "Cannot divide by zero.");
		textField.setText("");
		} else {
		textField.setText(String.valueOf(num1 / num2));
		}
		break;
		}
		} else if (e.getSource() == buttonClr) {
		textField.setText("");
		}
	}
	public static void main(String args[]){
		new Calculator();
	}
}