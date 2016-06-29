package y.f.c.a;

import java.util.Collection;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.ak;

class aK extends ak {
   Object k;
   Object l;

   aK(y.c.d var1, B var2, Object var3, Object var4, y.f.aE var5, Collection var6, y.f.aE var7, Collection var8) {
      super(var1, var2, var5, var6, var7, var8);
      this.k = var3;
      this.l = var4;
   }

   public Object g() {
      return this.k;
   }

   public Object h() {
      return this.l;
   }

   public void b(boolean var1) {
      if(this.i != var1) {
         label35: {
            Object var2;
            if(this.i) {
               var2 = this.k;
               this.k = this.l != null?((y.g.am)this.l).b:null;
               this.l = var2 != null?((y.g.am)var2).b:null;
               if(!N.x) {
                  break label35;
               }
            }

            var2 = this.k;
            this.k = this.l != null?y.g.am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", this.l):null;
            this.l = var2 != null?y.g.am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", var2):null;
         }
      }

      super.b(var1);
   }

   public A a(boolean var1, y.f.aE var2) {
      boolean var3 = N.x;
      if(var1) {
         if(this.i) {
            this.b = var2;
            if(!var3) {
               return this;
            }
         }

         this.a = var2;
         if(!var3) {
            return this;
         }
      }

      if(this.i) {
         this.a = var2;
         if(!var3) {
            return this;
         }
      }

      this.b = var2;
      return this;
   }
}
