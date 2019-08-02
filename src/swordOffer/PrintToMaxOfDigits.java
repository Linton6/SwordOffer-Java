package swordOffer;

/**
 * @Author Linton
 * @Date 2019/7/23 14:22
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  输入数字n ，按顺序打印从1到最大的n位十进制数，比叡输入3，则打印1,2,3，直到999
 */

public class PrintToMaxOfDigits {
    public static void main(String[] args) {
        PrintToMaxOfDigits p = new PrintToMaxOfDigits();
        p.printToMaxofDigits(3);
        System.out.println(n);

    }
    static int n = 0;
    public void printToMaxofDigits( int n ) {
        if (n <= 0) return;
        char[] number = new char[n];
        printToMaxofDigits(number, 0);
    }

    private  void printToMaxofDigits(char[] number, int digit) {
        if(digit == number.length) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[digit] = (char) ( i + '0');
            printToMaxofDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number){ // 规范化输出数字，设计巧妙
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length) {
            System.out.print(number[index++]);

        }
        n++;// 总共输出多少数
        System.out.println();
    }
}

