package swordOffer;

/**
 * @Author Linton
 * @Date 2019/6/28 21:48
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description 一个字符占8位，因此不会超过256个，可以申请一个256大小的数组
 * 来实现一个简易的哈希表。时间复杂度为O(n)，空间复杂度O(n).
 */

public class FirstAppearingOnce {
    public static void main(String[] args) {
        FirstAppearingOnce f = new FirstAppearingOnce();

    }

    int[] hashtable = new int[256];
    StringBuffer s = new StringBuffer();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        s.append(ch);
        if(hashtable[ch]==0)
            hashtable[ch]=1;
        else hashtable[ch]+=1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] str=s.toString().toCharArray();
        for(char c:str)
        {
            if(hashtable[c]==1)
                return c;
        }
        return '#';
    }
}

