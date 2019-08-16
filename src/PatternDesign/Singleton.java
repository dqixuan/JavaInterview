package PatternDesign;

//第一种，饿汉模式，线程安全
class Singleton1 {
  private static Singleton1 singleton1 = new Singleton1();
  private Singleton1() {}
  public static Singleton1 getInstance() {
    return singleton1;
  }
}
//第二种，懒汉模式，线程不安全，延迟加载
class Singleton2 {
  private static Singleton2 singleton2 = null;
  private Singleton2(){}
  public static Singleton2 getInstance() {
    if (singleton2 == null) {
      singleton2 = new Singleton2();
    }
    return singleton2;
  }
}

//懒汉模式 +　同步方法,线程安全，但性能低
class Singleton3 {
  private static Singleton3 singleton3 = null;
  private Singleton3(){}
  public static synchronized Singleton3 getInstance() {
    if (singleton3 == null) {
      singleton3 = new Singleton3();
    }
    return singleton3;
  }
}
//Double-check, 有可能出现空指针的情况
class Singleton4 {
  private static Singleton4 singleton4 = null;
  private Singleton4() {}
  public static Singleton4 getInstance() {
    if (singleton4 == null) {
      synchronized (Singleton4.class) {
        if (singleton4 == null) {
          singleton4 = new Singleton4();
        }
      }
    }
    return singleton4;
  }
}
//volatile + Double-check
class Singleton5 {
  private static Singleton5 singleton5 = null;
  private Singleton5() {}
  public static Singleton5 getInstance() {
    if (singleton5 == null) {
      synchronized (Singleton5.class) {
        if (singleton5 == null) {
          singleton5 = new Singleton5();
        }
      }
    }
    return singleton5;
  }
}
//静态内部类，单例模式常用的方法之一
class Singleton6 {
  private Singleton6() {}
  static class Holder {
    private static Singleton6 singleton6 = new Singleton6();
  }
  public static Singleton6 getInstance() {
    return Holder.singleton6;
  }
}

//枚举类

class Singleton7 {
  private Singleton7() {}
  private enum EnumHolder {
    INSTANCE;
    private Singleton7 singleton7;
    EnumHolder() {
      singleton7 = new Singleton7();
    }
    private Singleton7 getInstance() {
      return singleton7;
    }
  }
  public static Singleton7 getInstance() {
    return EnumHolder.INSTANCE.getInstance();
  }
}

public class Singleton {
  //共有7种


}
