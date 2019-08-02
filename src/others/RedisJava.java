package others;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.*;

/**
 * @Author Linton
 * @Date 2019/7/21 16:42
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class RedisJava {

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());

      /*
       * Redis Java String(字符串) 实例
       * */
        // 设置redis字符串数据
        jedis.set("runoobkey", "www.runoobkey.com");
        // 获取数据并输出
        System.out.println("redis存储的字符串为" + jedis.get("runoobkey"));


        /*
         * Redis Java List(列表) 实例
         */
        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }

        /*
         *Redis Java Keys 实例
         */
        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }


    }

}

