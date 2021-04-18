import java.util.Scanner;

public class CalculatorRun {
    public static void main(String[]args){
        Factory factory = new Factory();

        Calculator calc = new Calculator(factory);
        calc.exec();
    }
}
/*
  Никак не мог вынуть операции из метода пуска,решил так,через интерфейс
 */
interface Actions {
    double exec( double valueOne, double valueTwo ) throws DivException;
}
class Plus implements Actions {
    @Override
    public double exec(double valueOne, double valueTwo)  {
        return valueOne+valueTwo;
    }
}
class Minus
         implements Actions {
    @Override
    public double exec(double valueOne, double valueTwo ) {
        return (valueOne - valueTwo );
    }
}
class Multiply implements Actions {

    @Override
    public double exec(double valueOne, double valueTwo ) {
        return (valueOne * valueTwo );
    }
}
class Division implements Actions {

    @Override
    public double exec (double valueOne, double valueTwo )   throws DivException {
        int a=0;
        if(a==valueTwo) throw new DivException("нельзя на ноль");
        return (valueOne / valueTwo );
    }
}

interface Logic
{
    Actions getOpInstance(int op );
}

 class Factory implements Logic {

    int operationCode;
    private Actions operation;

    @Override
    //  Получает код операции, по которому
    //  создает соответствующий объект операции
    public Actions  getOpInstance(int op) {
        this.operationCode = op;
        switch (operationCode){
            case 0:{
                operation = new Plus();
                break;
            }
            case 1:{
                operation = new Minus();
                break;
            }
            case 2:{
                operation = new Multiply();
                break;
            }
            case 3:{
                operation = new Division();
                break;
            }
            default:{
                operation = null;
            }
        }
        return operation;
    }
}

 class Calculator  {

    Factory factory;

    public Calculator(Factory factory1){
        this.factory = factory1;
    }

    public void exec(){

        boolean nextStep = true;                //  Условие выхода из цикла
        Scanner in = new Scanner(System.in);    //  Объявление потока ввода
        do {
            //  Ввод превого аргумента
            System.out.println("Введите первый аргумент");
            double arg1 = in.nextDouble();        //  Ввод числа с клавиатуры

            //  Ввод операции
            System.out.println("Выберите операцию:");
            System.out.println("0 - сумма");
            System.out.println("1 - разность");
            System.out.println("2 - уменожени");
            System.out.println("3 - деление");
            System.out.println();
            int operation = in.nextInt();

            //  Ввод второго агрумента
            System.out.println("Введите второй аргумент");
            double arg2 = in.nextDouble();

            //  Обработка операций над аргемунтами
            System.out.println("Результат равен:");
            Actions op = factory.getOpInstance(operation);

            if (op != null) {
                try {
                    System.out.println(op.exec(arg1, arg2));
                } catch (DivException e) {
                    e.printStackTrace();
                }
            }
            else System.out.println("Недопустимая операция!!!");

            // Проверка на выход из цикла
            System.out.println("Хотите продолжить?");
            System.out.print("1 - Продолжить\t");
            System.out.println("2 - Выйти");
            int whatDo = in.nextInt();
            if (whatDo == 2) nextStep = false;
        } while (nextStep);
    }
}
