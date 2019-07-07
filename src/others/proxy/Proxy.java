package others.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author Linton
 * @Date 2019/7/7 14:35
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description  动态代理不需要知道代理对象的名字   可以实现任意接口的代理
 *
 * 动态代理实现方式 1. JDK Complier  2. CGLib用的是继承，二进制编译
 *
 * 可以对任意的对象、任意的接口方法、实现任意的代理
 */

public class Proxy {
    public static Object newProxyInstance(Class interfaces, InvocationHandler handler) throws Exception{

        String rt = "\r\n";

        String methodString = "";
        Method[] methods =interfaces.getMethods();

/*        for (Method m : methods) {
            methodString += "@Override" + rt +
                    "public void " + m.getName() + "() throws InterruptedException   {" + rt +
                    "        long start = System.currentTimeMillis();"+ rt +
                    "      t." + m.getName() +"();" + rt +
                    "       long end = System.currentTimeMillis();"+ rt +
                    " System.out.println(\"time: \" + (end - start));"+ rt +
         "}";
        }*/
        for (Method m : methods) {
            methodString += "@Override" + rt +
                    "public void " + m.getName() + "()    {" + rt +
                    "       try{" + rt +
                    "      Method md =  " + interfaces.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
                    "  handler.invoke(this, md);" + rt +
                    "       }catch (Exception e) {e.printStackTrace();} " + rt+

                    "}";
        }

        String src =
                "package others.proxy;" +rt +
                        "import java.lang.reflect.Method;" + rt +
                        "public class Time implements "+ interfaces.getName()+" {"+ rt +

                        "   private  Moveable t;"+rt +

                        "   public Time(InvocationHandler handler) {"+rt +
                        "       super();"+rt +
                        "       this.handler = handler;"+rt +
                        "    }"+rt +
                        "   others.proxy.InvocationHandler handler;" + rt +

                        methodString  +
                        "  }";

//        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir") + "/src/others/proxy/Time.java";
        File f = new File(fileName);
        FileWriter fw  = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

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
        URL[] urls = new URL[] {new URL("file:/" + System.getProperty("user.dir") + "/src/")}; // user.dir当前工作目录
        URLClassLoader ul = new URLClassLoader(urls);
        Class c = ul.loadClass("others.proxy.Time");
        System.out.println(c);

        // 反射
        Constructor ctr = c.getConstructor(InvocationHandler.class);
        Object m = ctr.newInstance(handler);




        return m;
    }
}

