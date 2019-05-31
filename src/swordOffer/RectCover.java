package swordOffer;

public class RectCover {
    public static void main(String[] args) {
        System.out.println(rectCo(7));

    }
    /**
     * 递归耗时550ms
     * 占用内存9100K
     * @param target
     * @return
     */
    public static int rectCover(int target) {
        if (target == 1) {
            return 1;
        }
        if (target <= 0) {
            return 0;
        }
        if (target == 2) {
            return 2;
         }
        int a = rectCover(target -1) + rectCover(target -2);
        return a;
    }
    /**
     * 循环耗时15ms
     * 占用内存9108K
     * @param target
     * @return
     */
    public static int rectCo(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            int prePreNum = 1;
            int preNum = 2;
            int result = 0;
            for (int cout = 3; cout <= target; cout++){
                result = preNum + prePreNum;
                prePreNum = preNum;
                preNum = result;
            }
            return result;
        }
    }
}
