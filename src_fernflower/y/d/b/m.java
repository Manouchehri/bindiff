package y.d.b;

import java.util.Comparator;
import y.d.b.b;
import y.d.b.c;
import y.d.b.d;
import y.d.b.u;
import y.d.b.z;

public class m {
   protected u a;
   private b b;
   private b c;
   private b d;
   private b e;
   private z f;
   private z g;

   public m(b var1, b var2, d var3) {
      this.b = var1;
      this.c = var2;
      this.f = this.c.a().c(this.b.c()).b(this.b.a().c(this.c.c()));
      this.g = this.c.b().c(this.b.c()).b(this.b.b().c(this.c.c()));
      this.a = var3;
      if(this.a.c().compare(this.b, this.c) < 0) {
         this.d = this.b;
         this.e = this.c;
         if(c.a == 0) {
            return;
         }
      }

      this.d = this.c;
      this.e = this.b;
   }

   public b a() {
      return this.b;
   }

   public b b() {
      return this.c;
   }

   public z c() {
      return this.f;
   }

   public z d() {
      return this.g;
   }

   public boolean e() {
      return this.b.equals(this.c);
   }

   public boolean a(b var1) {
      if(this.e()) {
         return this.b.equals(var1);
      } else {
         b var2 = this.a();
         b var3 = this.b();
         if(this.a.c(var2, var3, var1) != 0) {
            return false;
         } else {
            Comparator var4 = this.a.c();
            return var4.compare(this.d, var1) <= 0 && var4.compare(var1, this.e) <= 0;
         }
      }
   }

   public boolean b(b var1) {
      return var1.equals(this.b)?false:(var1.equals(this.c)?false:this.a(var1));
   }

   public b a(m var1) {
      b var2 = this.b;
      b var3 = this.c;
      b var4 = var1.a();
      b var5 = var1.b();
      if(this.e()) {
         return var1.a(var2)?var2:null;
      } else if(var1.e()) {
         return this.a(var4)?var4:null;
      } else {
         int var6 = this.a.a(this, var1.a());
         int var7 = this.a.a(this, var1.b());
         int var8 = this.a.a(var1, this.a());
         int var9 = this.a.a(var1, this.b());
         return var6 == 0 && var7 == 0?(var1.a(var2)?var2:(var1.a(var3)?var3:(this.a(var4)?var4:(this.a(var5)?var5:null)))):(var6 != var7 && var8 != var9?this.b(var1):null);
      }
   }

   public b b(m var1) {
      b var2 = this.b;
      b var3 = this.c;
      b var4 = var1.a();
      b var5 = var1.b();
      z var6 = this.g.c(var1.c()).b(var1.d().c(this.f));
      if(var6.c() == 0) {
         return null;
      } else {
         z var7 = var3.a().c(var2.b()).b(var2.a().c(var3.b()));
         z var8 = var5.a().c(var4.b()).b(var4.a().c(var5.b()));
         z var9 = var8.c(this.f).b(var7.c(var1.c()));
         z var10 = var8.c(this.g).b(var7.c(var1.d()));
         return new b(var9, var10, var6);
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof m)) {
         return false;
      } else {
         m var2 = (m)var1;
         return !var2.a().equals(this.b)?false:var2.b().equals(this.c);
      }
   }

   public int hashCode() {
      int var1 = this.b.hashCode();
      var1 = 31 * var1 + this.c.hashCode();
      return var1;
   }

   public String toString() {
      return "[S: " + this.b + " - T:" + this.c + "]";
   }
}
