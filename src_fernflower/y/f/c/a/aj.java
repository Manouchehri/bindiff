package y.f.c.a;

import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.aK;
import y.f.c.a.ao;

class aj extends ao {
   Object a;
   Object b;

   aj(B var1, Object var2, Object var3) {
      super(var1);
      this.a = var2;
      this.b = var3;
   }

   public Object g() {
      return this.a;
   }

   public Object h() {
      return this.b;
   }

   public void b(boolean var1) {
      if(this.i != var1) {
         label35: {
            Object var2;
            if(this.i) {
               var2 = this.a;
               this.a = this.b != null?((y.g.am)this.b).b:null;
               this.b = var2 != null?((y.g.am)var2).b:null;
               if(!N.x) {
                  break label35;
               }
            }

            var2 = this.a;
            this.a = this.b != null?y.g.am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", this.b):null;
            this.b = var2 != null?y.g.am.a("HierarchicLayouter.REVERSED_EDGE_GROUP_PREFIX", var2):null;
         }
      }

      super.b(var1);
   }

   public A a(boolean var1, y.f.aE var2) {
      aK var3;
      if(this.i()) {
         var3 = new aK(this.b(), this.k(), this.h(), this.g(), var1?null:var2, this.d(), var1?var2:null, this.f());
         var3.b(true);
         if(!N.x) {
            return var3;
         }
      }

      var3 = new aK(this.b(), this.k(), this.g(), this.h(), var1?var2:null, this.d(), var1?null:var2, this.f());
      return var3;
   }
}
