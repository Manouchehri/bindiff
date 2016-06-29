package y.f.i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.f.i.c;
import y.f.i.d;
import y.f.i.e;
import y.f.i.f;
import y.f.i.v;

public class b {
   private byte a;
   private Map b;
   private List c;
   private double d;
   private double e;
   private double f;
   private int g;
   private Map h;
   private List i;
   private Map j;
   private Set k;
   private boolean l;
   private double m;

   public b(double var1, double var3, byte var5) {
      this.h = new HashMap();
      this.i = new ArrayList();
      this.j = new HashMap();
      this.k = new HashSet();
      this.l = true;
      this.m = 0.5D;
      this.b = new HashMap(11);
      this.c = new ArrayList(62);
      this.a(var1, var3, var5);
   }

   public b(double var1, double var3) {
      this(var1, var3, (byte)1);
   }

   public void a(double var1, double var3, byte var5) {
      this.k.clear();
      this.j.clear();
      this.i.clear();
      this.h.clear();
      this.d = Math.min(var1, var3);
      this.f = Math.max(var1, var3);
      this.e = (var1 + var3) / 2.0D;
      this.a = var5;
      this.b.clear();
      this.c.clear();
      this.g = -1;
   }

   public void a(Object var1, y.d.t var2, y.d.t var3) {
      if(this.a == 0) {
         var2 = y.d.t.b(var2);
         var3 = y.d.t.b(var3);
      }

      e var4;
      label14: {
         if(var2.a > var3.a) {
            var4 = new e(var1, var3, var2);
            if(v.f == 0) {
               break label14;
            }
         }

         var4 = new e(var1, var2, var3);
      }

      this.b.put(var1, var4);
      this.c.add(var4);
      this.k.add(var1);
   }

   public void a(Object var1, Object var2, y.d.t var3, y.d.t var4) {
      if(this.a == 0) {
         var3 = y.d.t.b(var3);
         var4 = y.d.t.b(var4);
      }

      y.c.D var5 = (y.c.D)this.h.get(var2);
      if(var5 == null) {
         var5 = new y.c.D();
         this.h.put(var2, var5);
         this.i.add(var5);
      }

      label16: {
         if(var3.a > var4.a) {
            var5.add(new e(var1, var4, var3));
            if(v.f == 0) {
               break label16;
            }
         }

         var5.add(new e(var1, var3, var4));
      }

      this.j.put(var1, var5);
   }

   public Iterator a() {
      return this.k.iterator();
   }

   public boolean a(Object var1) {
      Object var2 = this.h.get(var1);
      return var2 != null && this.b.containsKey(var2);
   }

   public void b() {
      int var8 = v.f;
      if(this.h.size() > 0) {
         this.d();
      }

      e[] var1 = new e[this.c.size()];
      double var2 = Double.MAX_VALUE;
      double var4 = -1.7976931348623157E308D;
      int var6 = this.c.size() - 1;

      while(true) {
         if(var6 >= 0) {
            var1[var6] = (e)this.c.get(var6);
            var4 = Math.max(var4, var1[var6].c.a);
            var2 = Math.min(var2, var1[var6].b.a);
            --var6;
            if(var8 != 0) {
               break;
            }

            if(var8 == 0) {
               continue;
            }
         }

         y.g.e.a((Object[])var1, new f(this, (c)null));
         break;
      }

      y.c.D var9 = new y.c.D();
      var9.a((Object)(new d(var2, -1.0D)));
      var9.b((Object)(new d(var4, -1.0D)));
      int var7 = 0;

      while(var7 < var1.length) {
         this.a(var9, var1[var7]);
         ++var7;
         if(var8 != 0) {
            break;
         }
      }

   }

   private void d() {
      int var16 = v.f;
      int var1 = this.i.size() - 1;

      do {
         int var10000 = var1;

         double var2;
         double var4;
         double var6;
         double var8;
         boolean var10;
         boolean var11;
         y.c.D var12;
         label85:
         while(true) {
            if(var10000 < 0) {
               return;
            }

            var2 = Double.MAX_VALUE;
            var4 = -1.7976931348623157E308D;
            var6 = var2;
            var8 = var4;
            var10 = true;
            var11 = true;
            var12 = (y.c.D)this.i.get(var1);
            y.c.p var13 = var12.k();

            while(true) {
               if(var13 == null) {
                  break label85;
               }

               e var14 = (e)var13.c();
               double var20;
               var10000 = (var20 = var14.b.b - var6) == 0.0D?0:(var20 < 0.0D?-1:1);
               if(var16 != 0) {
                  break;
               }

               if(var10000 < 0) {
                  var6 = var14.b.b;
               }

               if(var14.c.b < var6) {
                  var6 = var14.c.b;
               }

               if(var14.b.b > var8) {
                  var8 = var14.b.b;
               }

               if(var14.c.b > var8) {
                  var8 = var14.c.b;
               }

               byte var15;
               if(var14.b.a < var2) {
                  var2 = var14.b.a;
                  var15 = var14.a(this.e);
                  var10 = var15 == 1 || var15 == 0;
               }

               if(var14.c.a > var4) {
                  var4 = var14.c.a;
                  var15 = var14.a(this.e);
                  var11 = var15 == 2 || var15 == 0;
               }

               this.k.add(var14.a);
               var13 = var13.a();
               if(var16 != 0) {
                  break label85;
               }
            }
         }

         y.d.t var17 = new y.d.t(var2, var10?var6:var8);
         y.d.t var18 = new y.d.t(var4, var11?var6:var8);
         e var19 = new e(var12, var17, var18);
         this.b.put(var12, var19);
         this.c.add(var19);
         --var1;
      } while(var16 == 0);

   }

   public double b(Object var1) {
      return this.g == 0?(this.d + this.f) * 0.5D:this.d + (double)this.c(var1) / (double)this.g * (this.f - this.d);
   }

   public int c() {
      return this.g + 1;
   }

   public int c(Object var1) {
      return this.e(var1).d;
   }

   public int d(Object var1) {
      return this.c(this.h.get(var1));
   }

   private void a(y.c.D var1, e var2) {
      int var14 = v.f;
      if(this.l && Math.abs(var2.b.a - var2.c.a) < this.m) {
         var2.d = 0;
      } else {
         byte var3 = var2.a(this.e);
         d var4 = new d(var2.b.a(), var2.b.b(), var3 == 0 || var3 == 1);
         d var5 = new d(var2.c.a(), var2.c.b(), var3 == 2 || var3 == 0);
         y.c.p var6 = var1.k();
         d var7 = (d)var6.c();
         double var8 = var7.getY();

         y.c.p var10000;
         while(true) {
            if(var4.getX() > var7.getX()) {
               var8 = var7.getY();
               var6 = var6.a();
               var10000 = var6;
               if(var14 != 0) {
                  break;
               }

               var7 = (d)var6.c();
               if(var14 == 0) {
                  continue;
               }
            }

            var10000 = var1.a((Object)var4, (y.c.p)var6);
            break;
         }

         y.c.p var10 = var10000;
         double var11 = var8;

         while(true) {
            if(var5.getX() >= var7.getX()) {
               var11 = var7.getY();
               var8 = Math.max(var11, var8);
               var1.h(var6);
               var6 = var6.a();
               var10000 = var6;
               if(var14 != 0) {
                  break;
               }

               if(var6 != null) {
                  var7 = (d)var6.c();
                  if(var14 == 0) {
                     continue;
                  }
               }
            }

            var10000 = var10.b();
            break;
         }

         d var13;
         if(var10000 != null) {
            var13 = (d)var10.b().c();
            if(var13.getX() + 5.0D > var4.getX() && var13.a != var4.a && var10.b().b() != null) {
               var13 = (d)var10.b().b().c();
               var8 = Math.max(var8, var13.getY());
            }
         }

         if(var10.a() != null) {
            var13 = (d)var10.a().c();
            if(var13.getX() - 5.0D < var5.getX() && var13.a != var5.a) {
               var8 = Math.max(var8, var13.getY());
            }
         }

         var10.a(new d(var2.b.a(), var8 + 1.0D));
         var1.b((Object)(new d(var2.c.a(), var11)), var10);
         var2.d = (int)Math.round(var8 + 1.0D);
         this.g = Math.max(this.g, var2.d);
      }
   }

   private e e(Object var1) {
      e var2 = (e)this.b.get(var1);
      if(var2 == null) {
         Object var3 = this.j.get(var1);
         if(var3 != null) {
            return (e)this.b.get(var3);
         } else {
            throw new IllegalArgumentException("No such key registered!");
         }
      } else {
         return var2;
      }
   }

   static double a(b var0) {
      return var0.e;
   }
}
