
package ru.calculator;


import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class CalculatorMain {

    private final JFrame frame;

    public CalculatorMain() {
        // Инитиализация окна
        frame = new JFrame();
        frame.setTitle("Калькулятор RUR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрыватель окна
        frame.setResizable(false); // Запрет ресайза

        CalculatorPanel panel = new CalculatorPanel();
        frame.add(panel); // добавить панель в окно

        frame.setSize(250, 300);
        frame.setLocationRelativeTo(null); // По центру экрана
        frame.setVisible(true); 
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        CalculatorMain main = new CalculatorMain();
    }
}
