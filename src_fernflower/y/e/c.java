package y.e;

import java.io.FileOutputStream;
import java.io.OutputStream;
import y.h.bu;

public abstract class c {
   public static int a;

   public abstract void a(bu var1, OutputStream var2);

   public void a(bu var1, String var2) {
      FileOutputStream var3 = new FileOutputStream(var2);

      try {
         this.a(var1, (OutputStream)var3);
      } finally {
         if(var3 != null) {
            var3.flush();
            var3.close();
         }

      }

   }
}
