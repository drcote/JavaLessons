package arrays;

public class Arrays {
    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arrayIO = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arrayIO.length; i++) {
            arrayIO[i] = (arrayIO[i] == 1) ? 0 : 1;
        }
        System.out.println(java.util.Arrays.toString(arrayIO));

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] arrayMultip = new int[8];
        for (int i = 0; i < arrayMultip.length; i++) {
            arrayMultip[i] = 3 * i;
        }
        System.out.println(java.util.Arrays.toString(arrayMultip));

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arrayRnd = {7, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrayRnd.length; i++) {
            if (arrayRnd[i] < 6) {
                arrayRnd[i] = arrayRnd[i] * 2;
            }
        }
        System.out.println(java.util.Arrays.toString(arrayRnd));

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int lengthArray = 8;
        int[][] twoDArray = new int[lengthArray][lengthArray];

        for (int i = 0; i < lengthArray; i++) {
            for (int j = 0; j < lengthArray; j++) {
                // диагональ слева на право и справа на лево
                twoDArray[i][j] = (i == j || j == lengthArray - 1 - i) ? 1 : 0;
            }
        }
        for (int[] i : twoDArray) {
            System.out.println(java.util.Arrays.toString(i));
        }


        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int indexMax = arrayRnd[0];
        int indexMin = arrayRnd[0];
        for (int i = 1; i < arrayRnd.length; i++) {
            if (arrayRnd[i] > arrayRnd[indexMax]) {
                indexMax = i;
            }
            if (arrayRnd[i] < arrayRnd[indexMin]) {
                indexMin = i;
            }
        }
        System.out.println("В массивае: " + java.util.Arrays.toString(arrayRnd));
        System.out.println("Максимальное число: " + arrayRnd[indexMax]);
        System.out.println("Минимальное число: " + arrayRnd[indexMin]);
        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
        System.out.println(checkArray(new int[]{1, 1, 1, 2, 1}));
        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
        System.out.println(java.util.Arrays.toString(shiftArray(new int[]{3, 5, 6, 1}, 3)));
    }

    private static boolean checkArray(int[] array) {
        int indexRight = array.length - 1;
        int rightSide = array[indexRight];
        int leftSide = 0;
        for (int i = 0; i < array.length - 1; i++) {
            leftSide += array[i];
        }
        if (leftSide != rightSide) {
            for (int i = indexRight; i >= 0; i--) {
                if (indexRight == 0) {
                    return false;
                }
                indexRight--;
                rightSide += array[indexRight];
                leftSide -= array[indexRight];
                if (leftSide == rightSide) {
                    return true;
                }
            }
        }
        return true;
    }

    private static int[] shiftArray(int[] array, int shift) {
        int indexLastEl = array.length - 1;
        int cycle = Math.abs(shift);

        while (cycle > 0) {
            if (shift > 0) {
                int lastEl = array[indexLastEl];
                for (int i = indexLastEl - 1; i >= 0; i--) {
                    array[i + 1] = array[i];
                }
                array[0] = lastEl;
            }
            if (shift < 0) {
                int firstEl = array[0];
                for (int i = 1; i <= indexLastEl; i++) {
                    array[i - 1] = array[i];
                }
                array[indexLastEl] = firstEl;
            }
            cycle--;
        }
        return array;
    }
}