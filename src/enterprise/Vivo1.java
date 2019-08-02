package enterprise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author Linton
 * @Date 2019/7/18 11:26
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description   18岁的生日
 */

public class Vivo1 {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();                    					     //数T,T行每行有一个日期
        input.nextLine();
        for (int i = 0; i < n; i++)
        {
            String time = input.nextLine();        							 //读入日期保存在字符串time变量里
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if (n == 0)
                break;
            try
            {
                Date date1 = sdf.parse(time);								 //time转换为Date类型
                Date date2 = new Date();                                     //初始化date2用来保存18年后日期
                Calendar cal1 = Calendar.getInstance();                      //初始化cal1用来保存初始日期
                Calendar cal2 = Calendar.getInstance();                      //初始化cal2用来保存18年后日期
                cal1.setTime(date1);
                cal2.setTime(date1);
                cal2.add(Calendar.YEAR, 18);                                 //加上18年后的cal2
                date2 = cal2.getTime();
                long day1 = (long) date1.getTime() / (1000 * 60 * 60 * 24);  //算初始日期的总天数
                long day2 = (long) date2.getTime() / (1000 * 60 * 60 * 24);  //算18年后的总天数
                if (cal1.get(Calendar.MONTH) + 1 == 2                        //Calendar.MONTH 月份是从0开始的，所以要加1
                        && cal1.get(Calendar.DATE) == 29)					 //Calendar.DATE 即是日
                {
                    System.out.println("-1");
                }
                else
                {
                    System.out.println(day2 - day1);						//相减便是过去的天数！
                }
            } catch (ParseException e)
            {
                System.out.println("输入失败！");
                e.printStackTrace();
            }
        }
    }


/*    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int t;
        t = scan.nextInt();
        String str = scan.nextLine(); ;
        while(t > 0){
            int sum = 0;
            str = scan.nextLine();
            String [] s = str.split("-");
            int byear = Integer.valueOf(s[0]);
            int bmonth = Integer.valueOf(s[1]);
            int bday = Integer.valueOf(s[2]);
            if(bmonth ==2 && bday == 29 && leapyear (byear+18) != 1){
                System.out.println("-1");
            }else{
                sum = 365 * 18;
                for(int i = 1;i < 18; i++){
                    sum += leapyear(byear + i);
                }
                if(bmonth > 2)
                    sum += leapyear(byear + 18); // 18岁那年的闰年天数
                else if(bmonth < 2 || bday != 29)
                    sum += leapyear(byear);     // 出生年的闰年天数
                System.out.println(sum);
            }
            t--;
        }
    }

    private static int leapyear(int year) {
        // TODO   能被4整除但不能被100整除的数或者可以被400整除的数是闰年
        if((year%4 == 0 && year%100 != 0) || year%400 == 0)
            return 1;
        return 0;
    }
    */

}

