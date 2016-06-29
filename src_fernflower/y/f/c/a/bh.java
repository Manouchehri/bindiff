package y.f.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import y.f.c.a.N;
import y.f.c.a.bi;
import y.f.c.a.bj;
import y.f.c.a.bt;
import y.f.c.a.l;

public class bh {
   private ArrayList a;
   private final boolean b;

   bh(bt var1, l var2) {
      this.a = new ArrayList();
      this.a.add(new bj(var1, var2, (bi)null));
      this.b = false;
   }

   bh(Collection var1, Collection var2) {
      boolean var7 = N.x;
      super();
      this.a = new ArrayList();
      Iterator var3 = var2.iterator();

      label26:
      while(true) {
         if(var3.hasNext()) {
            l var4 = (l)var3.next();
            Iterator var5 = var1.iterator();

            do {
               if(!var5.hasNext()) {
                  continue label26;
               }

               bt var6 = (bt)var5.next();
               this.a.add(new bj(var6, var4, (bi)null));
               if(var7 || var7) {
                  return;
               }
            } while(!var7);
         }

         Collections.sort(this.a);
         this.b = true;
         return;
      }
   }

   public Collection a() {
      return Collections.unmodifiableCollection(this.a);
   }

   public boolean b() {
      return this.b;
   }

   public bt c() {
      bj var1 = (bj)this.a.get(0);
      return var1.a;
   }

   public l d() {
      bj var1 = (bj)this.a.get(0);
      return var1.b;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         bh var2 = (bh)var1;
         if(this.b != var2.b) {
            return false;
         } else {
            if(this.a != null) {
               if(!this.a.equals(var2.a)) {
                  return false;
               }
            } else if(var2.a != null) {
               return false;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.a != null?this.a.hashCode():0;
      var1 = 31 * var1 + (this.b?1:0);
      return var1;
   }
}
