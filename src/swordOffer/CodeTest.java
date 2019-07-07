package swordOffer;

import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

import java.net.URL;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @Author Linton
 * @Date 2019/6/21 15:26
 * @Email 649557938@qq.com
 * @Version 1.0
 * @Description
 */

public class CodeTest {
    public static void main(String[] args) throws  Exception {

        //
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        List<Integer> op = new ArrayList<>();
        op.add(51);
        op.add(12);
        op.add(21);
        int[] hj = {2,3,4};
        String json = "{\"ttt\"}";
        Pattern pattern = Pattern.compile("[a-z]*ab");
        Matcher matcher = pattern.matcher("cab");
        boolean m = matcher.matches();
        String das = "dsadsadas";
        String r = das.replace('r','r').replace("sd","dsd");
















    }



}

