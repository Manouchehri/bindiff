package y.e;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.lang.reflect.*;

public class f extends e
{
    private float d;
    static Class b;
    static Class c;
    
    public f() {
        super(true);
        this.d = 1.0f;
    }
    
    protected BufferedImage a(final int n, final int n2) {
        return new BufferedImage(n, n2, 1);
    }
    
    protected void a(final BufferedImage bufferedImage, final OutputStream outputStream) {
        final ImageWriter a = y.e.d.a("jpeg");
        if (a != null) {
            final ImageWriteParam defaultWriteParam = a.getDefaultWriteParam();
            if (defaultWriteParam.canWriteCompressed()) {
                defaultWriteParam.setCompressionMode(2);
                defaultWriteParam.setCompressionQuality(this.d);
            }
            y.e.d.a(a, bufferedImage, outputStream, defaultWriteParam);
            if (y.e.c.a == 0) {
                return;
            }
        }
        try {
            final Class<?> forName = Class.forName("com.sun.image.codec.jpeg.JPEGCodec");
            final Class[] array = { (f.b == null) ? (f.b = a("java.io.OutputStream")) : f.b };
            final Method method = forName.getMethod("createJPEGEncoder", (Class[])array);
            final Object[] array2 = { outputStream };
            final Object invoke = method.invoke(null, array2);
            final Class<?> forName2 = Class.forName("com.sun.image.codec.jpeg.JPEGImageEncoder");
            array[0] = ((f.c == null) ? (f.c = a("java.awt.image.BufferedImage")) : f.c);
            final Method method2 = forName2.getMethod("getDefaultJPEGEncodeParam", (Class[])array);
            array2[0] = bufferedImage;
            final Object invoke2 = method2.invoke(invoke, array2);
            final Class<?> forName3 = Class.forName("com.sun.image.codec.jpeg.JPEGEncodeParam");
            final Class[] array3 = { Float.TYPE, Boolean.TYPE };
            final Method method3 = forName3.getMethod("setQuality", (Class<?>[])array3);
            final Object[] array4 = { new Float(this.d), Boolean.TRUE };
            method3.invoke(invoke2, array4);
            array3[0] = ((f.c == null) ? (f.c = a("java.awt.image.BufferedImage")) : f.c);
            array3[1] = forName3;
            final Method method4 = forName2.getMethod("encode", (Class[])array3);
            array4[0] = bufferedImage;
            array4[1] = invoke2;
            method4.invoke(invoke, array4);
        }
        catch (ClassNotFoundException ex2) {
            final IOException ex = new IOException(a());
            ex.initCause(ex2);
            throw ex;
        }
        catch (NoSuchMethodException ex4) {
            final IOException ex3 = new IOException(a());
            ex3.initCause(ex4);
            throw ex3;
        }
        catch (InvocationTargetException ex5) {
            final Throwable cause = ex5.getCause();
            if (cause instanceof IOException) {
                throw (IOException)cause;
            }
            final IOException ex6 = new IOException(a());
            ex6.initCause(cause);
            throw ex6;
        }
        catch (IllegalAccessException ex8) {
            final IOException ex7 = new IOException(a());
            ex7.initCause(ex8);
            throw ex7;
        }
    }
    
    private static String a() {
        return d.b("jpeg");
    }
    
    public void a(final float d) {
        this.d = d;
    }
    
    static Class a(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
