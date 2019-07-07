package others.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author Linton
 * @Date 2019/7/7 15:23
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description   神乎其技
 */

public class Test1 {
    public static void main(String[] args) throws Exception {
        String rt = "\r\n";
        String src =
                "package others.proxy;" +rt +
                        "public class TankTimeProxy implements Moveable {"+ rt +
                        "private  Moveable t;"+rt +
                        "public TankTimeProxy(Moveable t) {"+rt +
                        "super();"+rt +
                        "this.t = t;"+rt +
                        "}"+rt +
                        "@Override"+rt +
                        " public void move() throws InterruptedException {"+rt +
                        "        long start = System.currentTimeMillis();"+rt +
                        "      t.move();"+rt +
                        "       long end = System.currentTimeMillis();"+rt +
                        " System.out.println(\"time: \" + (end - start));"+rt +
                        "    }"+rt +
                        "  @Override"+rt +
                        "  public void stop() {"+rt +
                        "      long start = System.currentTimeMillis();"+rt +
                        "      t.stop();"+rt +
                        "      long end = System.currentTimeMillis();"+rt +
                        "System.out.println(\"time: \" + (end - start));"+rt +
                        "    }"+rt +
                        "  }";

//        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir") + "/src/others/proxy/Time.java";
//        File f = new File(fileName);
//        FileWriter fw  = new FileWriter(f);
//        fw.write(src);
//        fw.flush();
//        fw.close();

        /* 动态生成类*/

        // Compiler
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.getClass().getName());
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
        Iterable units = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask  t = compiler.getTask(null, fileManager,null,null,null,units);
        t.call();
        fileManager.close();

        // load into memory and create an instance  加载类
        URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") + "/src")}; // user.dir当前工作目录
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("others.proxy.Time");
        System.out.println(c);

        // 反射
        Constructor ctr = c.getConstructor(Moveable.class);
        Moveable m = (Moveable)ctr.newInstance(new Tank());
        m.move();



    }
}


