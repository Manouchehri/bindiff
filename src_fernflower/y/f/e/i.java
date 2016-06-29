package y.f.e;

import java.util.Iterator;
import y.f.X;
import y.f.e.j;
import y.f.e.a.aa;
import y.f.e.a.ax;
import y.f.e.a.ay;

public abstract class i {
   public static final i a = new j();
   public static boolean b;

   abstract void a(ay var1);

   void a(ay var1, X var2) {
   }

   void b(ay var1, X var2) {
   }

   aa b(ay var1) {
      boolean var4 = b;
      Iterator var2 = var1.y().iterator();

      aa var10000;
      while(true) {
         if(var2.hasNext()) {
            ax var3 = (ax)var2.next();
            if(!(var3 instanceof aa)) {
               continue;
            }

            var10000 = (aa)var3;
            if(!var4) {
               return var10000;
            }
            break;
         }

         var10000 = new aa();
         break;
      }

      aa var5 = var10000;
      var1.a((ax)var5);
      return var5;
   }

   private i() {
   }

   i(j var1) {
      this();
   }
}
