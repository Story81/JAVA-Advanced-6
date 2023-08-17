package org.example.operations;
/**
 * @author Соломенникова Н.М.
 * @see MathOperation Интерфейс, который наследуется классами наследниками Divide, Multiply, Substract, Sum
 */
public interface MathOperation {
    /**
     * @see #result(double, double) метод принимает на выход два параметра для последующих вычислений
     * @param a Значение первого числа
     * @param b Значение второго числа
     */

    double result( double a, double b);
}

