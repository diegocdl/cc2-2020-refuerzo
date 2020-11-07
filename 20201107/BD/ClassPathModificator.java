import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


public class ClassPathModificator {
   private static final Class[] urlParams =
       new Class[]{URL.class};
   public static void appendPath(String jarPath) throws IOException {
       System.out.println(ClassLoader.getSystemClassLoader());
    //    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    //    URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    //    try {
    //        Method meth = URLClassLoader.class.
    //            getDeclaredMethod("addURL", urlParams);
    //        meth.setAccessible(true);
    //        meth.invoke(classLoader, new Object []
    //        {newURL});
    //    } catch (Throwable err) {
    //        throw new IOException();
    // //    }
    // ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    // try {
    //     appendPath(jarPath, classLoader);
    // } catch (Exception e) {
    //         e.printStackTrace();
    //         System.exit(1);
    //     }
    try {
        File file = new File(jarPath);
        URL url = file.toURI().toURL();
        URLClassLoader sysLoader = new URLClassLoader(new URL[0]);

        Method sysMethod = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
        sysMethod.setAccessible(true);
        sysMethod.invoke(sysLoader, new Object[]{url});
    } catch(Exception e) {
        e.printStackTrace();
    }
    
   }

   public static void appendPath(String jarPath, ClassLoader classLoader) throws Exception {
       try {
            Method method = classLoader.getClass().getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);
            method.invoke(classLoader, new File(jarPath).toURI().toURL());
        } catch (NoSuchMethodException e) {
            Method method = classLoader.getClass()
                    .getDeclaredMethod("appendToClassPathForInstrumentation", String.class);
            // method.setAccessible(true);
            method.invoke(classLoader, jarPath);
        } 
   }

//    public static void appendPath(String newPath) throws IOException {
//        appendPath(new File(newPath));
//    }

//    public static void appendPath(File fileObj) throws IOException {
//        appendPath(fileObj.toURI().toURL());
//    }
}