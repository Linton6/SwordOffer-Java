package Zuo.基础;

/**
 * @Author Linton
 * @Date 2019/8/6 10:41
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  安排最多的宣讲会  贪心策略：不能是开始最早或是宣讲时间最短，@@得是结束最早的策略
 */

import java.util.*;
public class ProjectPresentation {

    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public static int bestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (cur <= programs[i].start) {
                result++;
                cur = programs[i].end;
            }
        }
        return result;
    }
}

