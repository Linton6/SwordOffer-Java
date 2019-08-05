package others.proxy;
import java.lang.reflect.Method;
public class Time implements others.proxy.test.UserMange {
   private  Moveable t;
   public Time(InvocationHandler handler) {
       super();
       this.handler = handler;
    }
   others.proxy.InvocationHandler handler;
@Override
public void addUser()    {
       try{
      Method md =  others.proxy.test.UserMange.class.getMethod("addUser");
  handler.invoke(this, md);
       }catch (Exception e) {e.printStackTrace();} 
}  }