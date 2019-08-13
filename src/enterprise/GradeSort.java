package enterprise;

/**
 * @Author Linton
 * @Date 2019/8/13 18:12
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 * 成绩排序
 */

import java.util.Arrays;
import java.util.Scanner;

public class GradeSort
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt())
        {
            int n = sc.nextInt();
            Student.flag = sc.nextInt();

            Student[] stu = new Student[n];
            for (int i = 0; i < n; i++)
                stu[i] = new Student(sc.next(), sc.nextInt());

            Arrays.sort(stu);
            for (Student each : stu)
                System.out.println(each);
        }
        sc.close();
    }
}

class Student implements Comparable<Student>
{
    String name;
    int score;
    public static int flag;

    public Student(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    /**
     * 比较器核心！！！！
     * @param other
     * @return
     */
    public int compareTo(Student other)
    {
        if (flag == 0)
            return other.score - score;  // 从大到小
        return score - other.score;    // 从小到大
    }

    public String toString()
    {
        return name + " " + score;
    }

}

