package y.f.f;

import y.f.V;
import y.f.X;
import y.f.ad;
import y.f.e;
import y.f.f.a;
import y.f.f.c;

public class b extends y.f.c {
   public static final Object n;
   private y.f.f.a.a o;
   private boolean p;
   private boolean q;
   private a r;

   protected a a() {
      return new a();
   }

   public a n() {
      if(this.r == null) {
         this.r = this.a();
      }

      return this.r;
   }

   public boolean o() {
      ad var1 = this.b();
      if(var1 instanceof V) {
         return ((V)var1).d();
      } else if(this.q) {
         throw new IllegalStateException("No LabelLayoutTranslator registered");
      } else {
         return false;
      }
   }

   public boolean p() {
      ad var1 = this.b();
      if(!(var1 instanceof V)) {
         if(this.p) {
            throw new IllegalStateException("No LabelLayoutTranslator registered");
         } else {
            return false;
         }
      } else {
         return ((V)var1).e() && ((V)var1).c();
      }
   }

   public void d(ad var1) {
      super.d(var1);
   }

   public int q() {
      return this.o.a();
   }

   protected boolean b(X var1) {
      return this.o.b(var1);
   }

   protected void a(X var1) {
      this.o.a(this.n());
      this.o.d(this.e());
      this.o.a(var1);
   }

   public void c(X var1) {
      if(this.e() instanceof e) {
         e var2 = (e)this.e();
         var2.a((double)this.q());
         var2.b((double)this.q());
         var2.a(this.o() || this.p());
      }

      super.c(var1);
   }

   static {
      n = c.n;
   }
}
