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

public class f extends e {
   private float d = 1.0F;
   static Class b;
   static Class c;

   public f() {
      super(true);
   }

   protected BufferedImage a(int var1, int var2) {
      return new BufferedImage(var1, var2, 1);
   }

   protected void a(BufferedImage var1, OutputStream var2) {
      ImageWriter var3 = d.a("jpeg");
      if(var3 != null) {
         ImageWriteParam var4 = var3.getDefaultWriteParam();
         if(var4.canWriteCompressed()) {
            var4.setCompressionMode(2);
            var4.setCompressionQuality(this.d);
         }

         d.a(var3, var1, var2, var4);
         if(c.a == 0) {
            return;
         }
      }

      IOException var5;
      try {
         Class var19 = Class.forName("com.sun.image.codec.jpeg.JPEGCodec");
         Class[] var21 = new Class[]{b == null?(b = a("java.io.OutputStream")):b};
         Method var22 = var19.getMethod("createJPEGEncoder", var21);
         Object[] var7 = new Object[]{var2};
         Object var8 = var22.invoke((Object)null, var7);
         Class var9 = Class.forName("com.sun.image.codec.jpeg.JPEGImageEncoder");
         var21[0] = c == null?(c = a("java.awt.image.BufferedImage")):c;
         Method var10 = var9.getMethod("getDefaultJPEGEncodeParam", var21);
         var7[0] = var1;
         Object var11 = var10.invoke(var8, var7);
         Class var12 = Class.forName("com.sun.image.codec.jpeg.JPEGEncodeParam");
         var21 = new Class[]{Float.TYPE, Boolean.TYPE};
         Method var13 = var12.getMethod("setQuality", var21);
         var7 = new Object[]{new Float(this.d), Boolean.TRUE};
         var13.invoke(var11, var7);
         var21[0] = c == null?(c = a("java.awt.image.BufferedImage")):c;
         var21[1] = var12;
         Method var14 = var9.getMethod("encode", var21);
         var7[0] = var1;
         var7[1] = var11;
         var14.invoke(var8, var7);
      } catch (ClassNotFoundException var15) {
         var5 = new IOException(a());
         var5.initCause(var15);
         throw var5;
      } catch (NoSuchMethodException var16) {
         var5 = new IOException(a());
         var5.initCause(var16);
         throw var5;
      } catch (InvocationTargetException var17) {
         Throwable var20 = var17.getCause();
         if(var20 instanceof IOException) {
            throw (IOException)var20;
         }

         IOException var6 = new IOException(a());
         var6.initCause(var20);
         throw var6;
      } catch (IllegalAccessException var18) {
         var5 = new IOException(a());
         var5.initCause(var18);
         throw var5;
      }

   }

   private static String a() {
      return d.b("jpeg");
   }

   public void a(float var1) {
      this.d = var1;
   }

   static Class a(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
