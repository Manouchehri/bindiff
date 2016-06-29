package y.a;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import y.a.ag;
import y.a.ai;
import y.a.h;

class ak extends ai {
   int a;
   final Set b;
   int c;
   private final ag d;

   ak(ag var1, y.c.i var2) {
      super(var1, var2);
      this.d = var1;
      this.a = 0;
      this.c = (int)Math.round(Math.sqrt((double)var2.g() * ag.b(var1)));
      if((double)var2.g() / (double)this.c < 15.0D) {
         this.c = Math.round((float)var2.g() / 15.0F);
      }

      this.b = new HashSet(this.c);
   }

   void a() {
      this.b.clear();
   }

   y.c.d b() {
      ++this.a;
      return super.b();
   }

   y.c.y[] a(y.c.y var1, y.c.A var2) {
      this.b.remove(var1);
      return super.a(var1, var2);
   }

   void c(y.c.y var1) {
      boolean var3 = h.a;
      this.i.set(this.g.a(var1.b()), var1);
      if(var1.size() > Math.max(ag.c(this.d), 1)) {
         this.b.add(var1);
         if(this.a < this.c) {
            return;
         }

         Iterator var2 = this.b.iterator();

         label26: {
            while(var2.hasNext()) {
               this.a((y.c.y)var2.next());
               if(var3) {
                  break label26;
               }

               if(var3) {
                  break;
               }
            }

            this.a = 0;
            this.b.clear();
         }

         if(!var3) {
            return;
         }
      }

      this.b.remove(var1);
      this.d(var1);
   }
}
