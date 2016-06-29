package y.f.i.a;

import java.util.HashMap;
import java.util.Iterator;
import y.f.i.a.ab;
import y.f.i.a.y;

class G implements Iterator {
   private final y.c.C a;
   private final y.c.D b;

   G(y.c.f var1, y.f.X var2) {
      int var10 = ab.a;
      super();
      this.b = new y.c.D();
      y.c.c var3 = var2.c(y.a);
      HashMap var4 = new HashMap();
      y.c.e var5 = var1.a();

      while(true) {
         if(var5.f()) {
            y.c.d var6 = var5.a();
            if(var10 != 0) {
               break;
            }

            label39: {
               Object var7 = var3 == null?null:var3.b(var6);
               if(var7 == null) {
                  this.b.add(new y.c.f(var6));
                  if(var10 == 0) {
                     break label39;
                  }
               }

               y.c.f var8 = (y.c.f)var4.get(var7);
               if(var8 == null) {
                  y.c.f var9 = new y.c.f(var6);
                  var4.put(var7, var9);
                  this.b.add(var9);
                  if(var10 == 0) {
                     break label39;
                  }
               }

               var8.add(var6);
            }

            var5.g();
            if(var10 == 0) {
               continue;
            }
         }

         this.a = this.b.m();
         break;
      }

   }

   public boolean hasNext() {
      return this.a.f();
   }

   public Object next() {
      if(!this.a.f()) {
         return null;
      } else {
         Object var1 = this.a.d();
         this.a.g();
         return var1;
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
