/*
 * Decompiled with CFR 0_115.
 */
package y.e;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import y.e.c;
import y.e.d;
import y.e.e;

public class f
extends e {
    private float d = 1.0f;
    static Class b;
    static Class c;

    public f() {
        super(true);
    }

    @Override
    protected BufferedImage a(int n2, int n3) {
        return new BufferedImage(n2, n3, 1);
    }

    @Override
    protected void a(BufferedImage bufferedImage, OutputStream outputStream) {
        Object object;
        ImageWriter imageWriter = d.a("jpeg");
        if (imageWriter != null) {
            object = imageWriter.getDefaultWriteParam();
            if (object.canWriteCompressed()) {
                object.setCompressionMode(2);
                object.setCompressionQuality(this.d);
            }
            d.a(imageWriter, bufferedImage, outputStream, (ImageWriteParam)object);
            if (c.a == 0) return;
        }
        try {
            object = Class.forName("com.sun.image.codec.jpeg.JPEGCodec");
            Class[] arrclass = new Class[1];
            Class class_ = b == null ? (f.b = f.a("java.io.OutputStream")) : b;
            arrclass[0] = class_;
            Class[] arrclass2 = arrclass;
            Method method = object.getMethod("createJPEGEncoder", arrclass2);
            Object[] arrobject = new Object[]{outputStream};
            Object object2 = method.invoke(null, arrobject);
            Class class_2 = Class.forName("com.sun.image.codec.jpeg.JPEGImageEncoder");
            Class class_3 = c == null ? (f.c = f.a("java.awt.image.BufferedImage")) : c;
            arrclass2[0] = class_3;
            Method method2 = class_2.getMethod("getDefaultJPEGEncodeParam", arrclass2);
            arrobject[0] = bufferedImage;
            Object object3 = method2.invoke(object2, arrobject);
            Class class_4 = Class.forName("com.sun.image.codec.jpeg.JPEGEncodeParam");
            arrclass2 = new Class[]{Float.TYPE, Boolean.TYPE};
            Method method3 = class_4.getMethod("setQuality", arrclass2);
            arrobject = new Object[]{new Float(this.d), Boolean.TRUE};
            method3.invoke(object3, arrobject);
            arrclass2[0] = c == null ? (f.c = f.a("java.awt.image.BufferedImage")) : c;
            arrclass2[1] = class_4;
            Method method4 = class_2.getMethod("encode", arrclass2);
            arrobject[0] = bufferedImage;
            arrobject[1] = object3;
            method4.invoke(object2, arrobject);
            return;
        }
        catch (ClassNotFoundException var4_5) {
            IOException iOException = new IOException(f.a());
            iOException.initCause(var4_5);
            throw iOException;
        }
        catch (NoSuchMethodException var4_6) {
            IOException iOException = new IOException(f.a());
            iOException.initCause(var4_6);
            throw iOException;
        }
        catch (InvocationTargetException var4_7) {
            Throwable throwable = var4_7.getCause();
            if (throwable instanceof IOException) {
                throw (IOException)throwable;
            }
            IOException iOException = new IOException(f.a());
            iOException.initCause(throwable);
            throw iOException;
        }
        catch (IllegalAccessException var4_8) {
            IOException iOException = new IOException(f.a());
            iOException.initCause(var4_8);
            throw iOException;
        }
    }

    private static String a() {
        return d.b("jpeg");
    }

    public void a(float f2) {
        this.d = f2;
    }

    static Class a(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

