
package ru.calculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.commons.lang3.StringUtils;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

public class CalculatorPanel extends JPanel {

    private final JButton buttonZero = new JButton();
    private final JButton buttonOne = new JButton();
    private final JButton buttonTwo = new JButton();
    private final JButton buttonThree = new JButton();
    private final JButton buttonFour = new JButton();
    private final JButton buttonFive = new JButton();
    private final JButton buttonSix = new JButton();
    private final JButton buttonSeven = new JButton();
    private final JButton buttonEight = new JButton();
    private final JButton buttonNine = new JButton();

    // кнопки операций
    private final JButton buttonOperationClear = new JButton();
    private final JButton buttonOperationComma = new JButton();
    private final JButton buttonOperationDiv = new JButton();
    private final JButton buttonOperationMinus = new JButton();
    private final JButton buttonOperationMul = new JButton();
    private final JButton buttonOperationPercent = new JButton();
    private final JButton buttonOperationPlus = new JButton();
    private final JButton buttonOperationRemove = new JButton();
    private final JButton buttonOperationResult = new JButton();
    private final JButton buttonOperationSqrt = new JButton();

    // текстовое поле
    private final JTextField textField = new JTextField();

    public CalculatorPanel() {
        // задаём параметры для текста
        textField.setFont(new Font("Default", 0, 18));
        textField.setHorizontalAlignment(JTextField.TRAILING); // центрирование текста по правому краю

        textField.setText("");
        // задаём параметры для: кнопка 0
        buttonZero.setText("0");
        buttonOne.setText("1");
        buttonTwo.setText("2");
        buttonThree.setText("3");
        buttonFour.setText("4");
        buttonFive.setText("5");
        buttonSix.setText("6");
        buttonSeven.setText("7");
        buttonEight.setText("8");
        buttonNine.setText("9");

        buttonOperationComma.setText(".");  // задаём параметры для: кнопка ,
        buttonOperationPlus.setText("+");   // задаём параметры для: кнопка +
        buttonOperationResult.setText("="); // задаём параметры для: кнопка =
        buttonOperationMul.setText("*"); // задаём параметры для: кнопка *
        buttonOperationMinus.setText("-"); // задаём параметры для: кнопка -
        buttonOperationDiv.setText("/"); // задаём параметры для: кнопка /
        buttonOperationClear.setText("CE"); // задаём параметры для: кнопка CE
        buttonOperationSqrt.setText("√"); // задаём параметры для: кнопка √
        buttonOperationPercent.setText("%"); // задаём параметры для: кнопка %"

        // задаём параметры для: кнопка удалить последний символ
        buttonOperationRemove.setFont(new Font("Default", 1, 24));
        buttonOperationRemove.setText("←");

        this.initEvents(); // инициализируем события
        this.initLayout();  // инициализируем слой
    }

    private void initEvents() {

        //Действия с кнопками
        buttonZero.addActionListener((e) -> textField.setText(textField.getText() + "0"));
        buttonOne.addActionListener((e) -> textField.setText(textField.getText() + "1"));
        buttonTwo.addActionListener((e) -> textField.setText(textField.getText() + "2"));
        buttonThree.addActionListener((e) -> textField.setText(textField.getText() + "3"));
        buttonFour.addActionListener((e) -> textField.setText(textField.getText() + "4"));
        buttonFive.addActionListener((e) -> textField.setText(textField.getText() + "5"));
        buttonSix.addActionListener((e) -> textField.setText(textField.getText() + "6"));
        buttonSeven.addActionListener((e) -> textField.setText(textField.getText() + "7"));
        buttonEight.addActionListener((e) -> textField.setText(textField.getText() + "8"));
        buttonNine.addActionListener((e) -> textField.setText(textField.getText() + "9"));

        buttonNine.addActionListener((e) -> textField.setText(textField.getText() + "9"));
        buttonOperationPlus.addActionListener((e) -> textField.setText(textField.getText() + "+"));
        buttonOperationMul.addActionListener((e) -> textField.setText(textField.getText() + "*"));
        buttonOperationMinus.addActionListener((e) -> textField.setText(textField.getText() + "-"));
        buttonOperationDiv.addActionListener((e) -> textField.setText(textField.getText() + "/"));
        buttonOperationComma.addActionListener((e) -> textField.setText(textField.getText() + "."));
        buttonOperationPercent.addActionListener((e) -> getPrecentFromValue());
        buttonOperationSqrt.addActionListener((e) -> getSqrtFromValue());

        buttonOperationClear.addActionListener((e) -> textField.setText(" "));
        buttonOperationRemove.addActionListener((e) -> textField.setText(StringUtils.chop(textField.getText())));
        buttonOperationResult.addActionListener((e) -> calculate());
    }

    //Метод калькуляции
    private void calculate(){
        Expression expr = new ExpressionBuilder(textField.getText()).build();
        double result = expr.evaluate();

        textField.setText(String.valueOf(result));
    }

    //Вычисление процента
    private void getPrecentFromValue(){
        Expression expr = new ExpressionBuilder("%" + textField.getText()).build();
        double result = expr.evaluate();

        textField.setText(String.valueOf(result));
    }

    //Вычисление корня
    private void getSqrtFromValue(){
        Expression expr = new ExpressionBuilder("sqrt" + textField.getText()).build();
        double result = expr.evaluate();

        textField.setText(String.valueOf(result));
    }

    private void initLayout() {
        // настройка слоя расположения компонентов
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textField)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(buttonZero, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(buttonOperationComma, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(buttonOperationPlus, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(buttonFour, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(buttonFive, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(buttonOne, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(buttonTwo, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(buttonThree, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(buttonOperationMinus, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addComponent(buttonSix, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(buttonOperationMul, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(buttonSeven, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(buttonEight, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(buttonOperationRemove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(buttonNine, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(buttonOperationDiv, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(buttonOperationClear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(buttonOperationSqrt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(buttonOperationPercent, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(7, 7, 7)
                                                                .addComponent(buttonOperationResult, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textField, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(buttonOperationClear, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(buttonOperationSqrt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(buttonOperationRemove, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonSeven, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonEight, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonNine, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonOperationDiv, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonOperationPercent, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(buttonFive, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(buttonSix, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(buttonOperationMul, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(buttonFour, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(buttonThree, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buttonTwo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buttonOne, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buttonOperationMinus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(buttonZero, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buttonOperationComma, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buttonOperationPlus, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(buttonOperationResult, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

}
