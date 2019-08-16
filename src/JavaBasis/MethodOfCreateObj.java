package JavaBasis;


import java.io.*;

/**
 * 四种生成对象的方式
 * 1. new一个对象
 * 2. 利用反射生成对象
 * 3. 调用clone方法
 * 4. 利用序列化和反序列化
 */

class MyClass implements Cloneable, Serializable {
  public void say() {
    System.out.println("hello world");
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}

public class MethodOfCreateObj {
  public static void main(String[] args) {
    MyClass myClass1 = new MyClass();
    myClass1.say();
    System.out.println("利用new关键字生成一个对象");

    //方法2：Instance（）调用类的无参构造函数，如果没有，会报错
    System.out.println("==========");
    try {
      MyClass myClass2 = myClass1.getClass().newInstance();
      myClass2.say();
      System.out.println("利用反射生成一个对象");
      System.out.println();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    //方法3: 调用clone方法，资源类实现Cloneable接口，重写clone方法
    try {
      MyClass myClass3 = (MyClass) myClass1.clone();
      myClass3.say();
      System.out.println("利用clone方法生成一个对象");
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    //方法4：先将对象序列化到本地磁盘，再利用反序列化生成对象
    //实现serializable接口

    File f = new File("MyClass.obj"); //用户存储类信息
    try {
      FileOutputStream fos = new FileOutputStream(f);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      FileInputStream fis = new FileInputStream(f);
      ObjectInputStream ois = new ObjectInputStream(fis);

      oos.writeObject(myClass1);
      MyClass myClass4 = (MyClass)ois.readObject();
      myClass4.say();
      System.out.println("利用序列化生成对象");
    } catch(Exception e) {
        e.printStackTrace();
    } finally {

    }

  }
}
