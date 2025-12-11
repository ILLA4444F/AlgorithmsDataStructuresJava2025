import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GNGUI {
private int secret;
private int low = 1;
private int high = 100;
private int attempts = 0;
private JFrame frame;
private JTextField inputField;
private JButton guessButton;
private JLabel messageLabel;
private JLabel rangeLabel;
private JLabel attemptsLabel;
// HINT
private JLabel hintLabel;
public GNGUI() {
secret = (int)(Math.random() * 100) + 1;
frame = new JFrame("Вгадай число! 🎯");
frame.setSize(400, 300);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.setLayout(new GridLayout(6, 1));

JLabel titleLabel = new JLabel("Я загадав число від 1 до 100. Спробуй вгадати!",

SwingConstants.CENTER);

titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

frame.add(titleLabel);

rangeLabel = new JLabel("Діапазон чисел: [" + low + " — " + high + "]",

SwingConstants.CENTER);

frame.add(rangeLabel);

inputField = new JTextField();

frame.add(inputField);

guessButton = new JButton("Ввести");

frame.add(guessButton);

JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

messageLabel = new JLabel(" ", SwingConstants.CENTER);

messageLabel.setForeground(Color.BLUE);

attemptsLabel = new JLabel("Спроб: 0", SwingConstants.CENTER);

bottomPanel.add(messageLabel);

bottomPanel.add(attemptsLabel);

frame.add(bottomPanel);

hintLabel = new JLabel(" ", SwingConstants.CENTER);

hintLabel.setForeground(new Color(120, 0, 200));

frame.add(hintLabel);

guessButton.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

checkGuess();

}

});

inputField.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

checkGuess();

}

});

frame.setLocationRelativeTo(null);

frame.setVisible(true);

}

private void checkGuess() {
String text = inputField.getText();

int guess;

try {

guess = Integer.parseInt(text);

} catch (NumberFormatException e) {

messageLabel.setText("Введи правильне число!");

messageLabel.setForeground(Color.RED);

return;

}

if (guess < low || guess > high) {

messageLabel.setText("Число поза діапазоном!");

messageLabel.setForeground(Color.RED);

return;

}

attempts++;

attemptsLabel.setText("Спроб: " + attempts);

if (guess == secret) {

messageLabel.setText("🎉 Вітаю! Ти вгадав число!");

messageLabel.setForeground(Color.GREEN);

guessButton.setEnabled(false);

inputField.setEnabled(false);

hintLabel.setText(" ");

} else if (guess < secret) {

messageLabel.setText("Моє число більше.");

messageLabel.setForeground(Color.ORANGE);

low = Math.max(low, guess + 1);

} else {

messageLabel.setText("Моє число менше.");

messageLabel.setForeground(Color.ORANGE);

high = Math.min(high, guess - 1);

}

rangeLabel.setText("Діапазон чисел: [" + low + " — " + high + "]");

// HINT SYSTEM

giveHint();

inputField.setText("");

inputField.requestFocus();

}

// HINT

private void giveHint() {

int range = high - low;
if (range <= 3) {

hintLabel.setText("Ти дуже близько! 🔥");

} else if (range <= 10) {

hintLabel.setText("Діапазон вузький — спробуй уважніше!");

} else {

int mid = (low + high) / 2;

hintLabel.setText("Порада: спробуй число близьке до " + mid);

}

}

public static void main(String[] args) {

SwingUtilities.invokeLater(() -> new GNGUI());

}

}
