package ru.maritariny;


public class Main {

    public static void main(String[] args) {

        //Задача №1
        //Произвести преобразование "234" в число типа int и прибавить к этому числу длину строки "some_text"
        String string = "234";
        String some_text = "some_text";
        int number = Integer.valueOf(string);
        number = number + some_text.length();
        System.out.println(number);

        //Задача №2
        //Посчитать (a+b)^2 = ?, при a=3, b=5
        System.out.println(pow(sum(3, 5), 2));

        // Задание №3:
        boolean hasFuel = true;
        boolean hasElectricsProblem = false;
        boolean hasMotorProblem = false;
        boolean hasTransmissionProblem = true;
        boolean hasWheelsProblem = true;

        double check = repairAuto(hasFuel, hasElectricsProblem, hasMotorProblem, hasTransmissionProblem, hasWheelsProblem);
        System.out.println("Счет клиенту: " + check);
    }

    public static int sum(int a, int b){
        return a + b;
    }

    public static int pow(int c, int p){
        return (int) Math.pow(c, p);
    }

    public static double repairAuto(boolean hasFuel, boolean hasElectricsProblem, boolean hasMotorProblem, boolean hasTransmissionProblem, boolean hasWheelsProblem) {

        // В автосервис приехала сломанная машина. Механики находят неисправность следующим способом:
        // Если у машины нет бензина и ничего не сломано, то отдают машину владельцу и берут 1000 рублей за консультацию.
        // Если у машины проблема с двигателем, то чинят и берут 10 000.
        // Если у машины проблема с электрикой, то чинят и берут 5000.
        // Если у машины проблема с коробкой передач, то чинят и берут 4000.
        // Если у машины проблема с колесами, то чинят и берут 2000.
        // Если две детали сломаны, то на общий счет идет скидка 10%.
        // Если сломана коробка передач, и электрика или двигатель, то на общий счет скидка 20%.
        // Если нет бензина и что-то сломано, то за консультацию денег не берут.
        // Ситуации, что бензин есть и ничего не сломано - быть не может.
        // Ожидаемый результат: выведен на экран счет клиенту.

        double result = 0;
        int countOfProblem = 0;

        if (!hasFuel && !hasElectricsProblem && !hasMotorProblem && !hasTransmissionProblem && !hasWheelsProblem) {
            return 1000;
        }

        if (hasMotorProblem) {
            countOfProblem++;
            result = result + 10000;
        }
        if (hasElectricsProblem) {
            countOfProblem++;
            result = result + 5000;
        }
        if (hasTransmissionProblem) {
            countOfProblem++;
            result = result + 4000;
        }
        if (hasWheelsProblem) {
            countOfProblem++;
            result = result + 2000;
        }

        if (hasTransmissionProblem && (hasElectricsProblem || hasMotorProblem)) {
            result = result * 0.8;
        } else if (countOfProblem >= 2) {
            result = result * 0.9;
        }
        if (!hasFuel && countOfProblem != 0) {
            result = 0;
        }
        return result;
    }
}
