package y.f.f.d;

import y.f.X;
import y.f.f.d.g;
import y.f.f.d.y;
import y.g.al;

public class t implements y.f.f.b.p {
   public static final Object a = "y.layout.orthogonal.kandinsky.KanCompactor.BORDER_DPKEY";
   protected y.f.f.b.h b;
   protected X c;
   private y.f.f.c.f g = new g();
   private short h = 0;
   protected short d = 0;
   protected int e = 3;
   protected int f = 50;
   private boolean i = false;
   private y.f.f.b.m j;
   private boolean k = false;

   public void a(y.f.f.b.h var1) {
      this.c = (X)var1.a();
      this.b = var1;
   }

   public boolean b() {
      return this.k;
   }

   public void a(int var1) {
      this.f = var1;
   }

   public void a(y.f.f.b.m var1) {
      this.j = var1;
   }

   public short c() {
      return this.h;
   }

   public void a(short var1) {
      this.h = var1;
   }

   public void b(short var1) {
      this.d = var1;
   }

   public void b(int var1) {
      this.e = var1;
   }

   public void a(boolean var1) {
      this.i = var1;
   }

   public void a(y.f.f.c.f var1) {
      this.g = var1;
   }

   public void a() {
      y.g.o.a(this, 1, "------->>> Entering Compaction Phase");
      al var1 = new al();
      y.g.o.a(this, 2, "-----> Introduce dummy nodes for labels");
      y.g.o.a(this, 2, "-----> Split nodes");
      y var2 = new y(this.b, this.h, this.f);
      y.a(this.i);
      var2.b(this.b());
      var2.c();
      this.j.h = (int)var1.d();
      var1.e();
      y.g.o.a(this, 2, "-----> Do compaction");
      y.f.f.c.r var3 = new y.f.f.c.r();
      var3.a(this.d());
      var3.a((y.f.f.b.h)var2.a());
      y.c.A var4 = var2.a().a().t();
      y.c.D var5 = var2.b();
      if(this.g instanceof g) {
         ((g)this.g).a(var5);
      }

      var3.a(this.g);
      var3.a(this.e);
      var3.a(var4);
      this.j.i = (int)var1.d();
      var1.e();
      var2.a(var4, this.c);
      var2.a().a().a(var4);
      this.j.n = (int)var1.d();
      this.j.q = var2.g();
      this.j.s = var2.f();
      this.j.r = var2.e();
      this.j.j = var3.a();
      this.j.k = var3.b();
      this.j.l = var3.c();
      this.j.m = var3.d();
      y.g.o.a(this, 3, "-> Total running time of compaction Phase: " + var1);
      y.g.o.a(this, 1, "<<<------- Leaving Compaction Phase");
   }

   protected y.f.f.c.l d() {
      switch(this.d) {
      case 0:
         return new y.f.f.c.k();
      case 1:
         return new y.f.f.c.h();
      case 2:
         return new y.f.f.c.n();
      default:
         y.g.o.a((Object)"Unknown Compactor !");
         return null;
      }
   }
}
