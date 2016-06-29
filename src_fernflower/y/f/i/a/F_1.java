package y.f.i.a;

import java.util.HashMap;
import java.util.Iterator;
import y.f.i.a.ab;
import y.f.i.a.y;

class F implements Iterator {
   private final y.c.C a;
   private final y.c.D b;

   F(y.f.X var1) {
      int var9 = ab.a;
      super();
      this.b = new y.c.D();
      y.c.c var2 = var1.c(y.a);
      HashMap var3 = new HashMap();
      y.c.e var4 = var1.p();

      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            if(var9 != 0) {
               break;
            }

            label39: {
               Object var6 = var2 == null?null:var2.b(var5);
               if(var6 == null) {
                  this.b.add(new y.c.f(var5));
                  if(var9 == 0) {
                     break label39;
                  }
               }

               y.c.f var7 = (y.c.f)var3.get(var6);
               if(var7 == null) {
                  y.c.f var8 = new y.c.f(var5);
                  var3.put(var6, var8);
                  this.b.add(var8);
                  if(var9 == 0) {
                     break label39;
                  }
               }

               var7.add(var5);
            }

            var4.g();
            if(var9 == 0) {
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
