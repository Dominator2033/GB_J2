package homework_2;

public class Main {
    public static void main(String[] args) {


        String[][] arr = new String[][] {{"1", "2", "3", "4"}, {"1", "1", "1", "2"}, {"2", "2", "2", "3"}, {"3", "3", "3", "4"}};

        try {
            try {
                int result = arrayException(arr);
                System.out.println("Результат расчета " + result);
            } catch (MyArraySizeException e) {
                System.out.println("Превышен размер переданного массива");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка в ячейке " + e.i + "x" + e.j);
        }


    }

    public static int arrayException(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr.length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}



