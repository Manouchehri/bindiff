package y.f.d;

import y.f.R;
import y.f.aj;
import y.f.am;
import y.f.d.u;

class z implements y.d.o {
   Object a;
   Object b;
   byte c;
   int d;
   boolean e;
   private final u f;

   z(u var1, Object var2, Object var3, byte var4, boolean var5) {
      this.f = var1;
      this.d = 0;
      this.e = false;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.e = var5;
   }

   public boolean a() {
      return this.c == 2 || this.c == 3;
   }

   public y.d.y h() {
      if(this.c == 1) {
         return ((y.d.m)this.a).h();
      } else if(this.c == 3) {
         return u.a((u)this.f, (R)((y.f.C)this.a), (Object)this.b);
      } else if(this.c == 2) {
         return u.a((u)this.f, (R)((aj)this.a), (Object)this.b);
      } else {
         am var1 = u.a(this.f).a(this.a);
         return new y.d.y(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight());
      }
   }
}
