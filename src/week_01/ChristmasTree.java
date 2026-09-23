package week_01;

import java.util.Scanner;

public class ChristmasTree {
    public void makeTree(int height) {
        int i = 1;
        // 공백을 맞추기 위해서 실제 출력 줄 번호 매기기
        int print = 1;
        int[] skip = new int[height];
        int count = 0;
        if (height >= 10) {
            height = 10;
        }
        while (i <= height) {
            if (i % 3 == 0) {
                skip[count] = i;
                count++;
                i++;
                continue;
            }
            int j = 0;
            while (j < height - print) {
                System.out.print(" ");
                j++;
            }
            int k = 0;
            while (k < (i * 2) - 1) {
                System.out.print("*");
                k++;
            }
            System.out.println();
            print++;
            i++;
        }
        int index = 0;
        System.out.print("(");
        while (index < count - 1) {
            System.out.print(skip[index] + ", ");
            index++;
        }
        System.out.print(skip[index] + "번째 줄은 3의 배수이므로 건너뜀)");
    }

    public static void main(String[] args) {
        ChristmasTree xmas = new ChristmasTree();
        Scanner sc = new Scanner(System.in);
        System.out.print("트리의 최대 높이(N)을 입력하세요 : ");
        int height = sc.nextInt();
        xmas.makeTree(height);
        System.out.println();
    }
}
