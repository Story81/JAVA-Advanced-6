package org.example;

/**
 * author Соломенникова Н.М.
  */

import org.example.operations.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод чисел и математического знака
        System.out.print("Введите первое число: ");
        double number1 = scanner.nextDouble();

        System.out.print("Введите второе число: ");
        double number2 = scanner.nextDouble();

        System.out.print("Введите математический знак (+, -, *, /): ");
        String operator = scanner.next();

        double result = 0;
        MathOperation someOper;

        try {
            switch (operator) {
                case "+":
                    someOper = new Sum();
                    break;
                case "-":
                    someOper = new Subtract();
                    break;
                case "*":
                    someOper = new Multiply();
                    break;
                case "/":
//                    Если введен математический знак "/" - проверяем, что второе число не равно нулю,
//                    чтобы избежать деления на ноль. Если второе число равно нулю, выбрасываем исключение IllegalArgumentException
//                    с сообщением "Делить на ноль нельзя".
                    if (number2 == 0) {
                        throw new IllegalArgumentException("Делить на ноль нельзя");
                    }
                    someOper = new Divide();
                    break;
                default:
                    // Если введен знак, отличный от (+, -, *, /), выбрасываем исключение IllegalArgumentException
                    // с сообщением "Некорректный математический знак. Используйте знаки + - * /"
                    throw new IllegalArgumentException("Некорректный математический знак. Используйте знаки + - * /");
            }
            // Вычисление результата и запись его в переменную result для вывода на консоль
            result = someOper.result(number1, number2);
// Вывод результата
            System.out.printf("Результат: " +  " %.4f%n", result);
//Если во время выполнения программы возникает исключение IllegalArgumentException,
// оно обрабатывается и выводится сообщение об ошибке.
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
//закрываем Scanner в блоке finally
        } finally {
            scanner.close();
        }
    }
}
