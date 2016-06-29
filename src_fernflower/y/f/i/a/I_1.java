package y.f.i.a;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.J;
import y.f.i.a.N;
import y.f.i.a.O;
import y.f.i.a.Q;
import y.f.i.a.R;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.bc;
import y.f.i.a.l;
import y.f.i.a.m;
import y.f.i.a.y;

public class I implements Q, l, m {
   private final O a;
   private final List b;
   private final HashMap c;
   private final y.c.D d;
   private Z e;
   private double f;

   public I(O var1) {
      this.a = var1;
      this.d = new y.c.D();
      this.b = new ArrayList();
      this.c = new HashMap();
   }

   public void a(m var1) {
      this.b.add(var1);
   }

   public void b(m var1) {
      this.b.remove(var1);
   }

   public void a(Z var1) {
      int var3 = ab.a;
      this.e = var1;
      this.f = this.c();
      if(this.a instanceof l) {
         ((l)this.a).a(this);
      }

      int var2 = 0;

      I var10000;
      while(true) {
         if(var2 < this.b.size()) {
            var10000 = this;
            if(var3 != 0) {
               break;
            }

            if(this.b.get(var2) instanceof J) {
               ((J)this.b.get(var2)).a(var1, this);
            }

            ++var2;
            if(var3 == 0) {
               continue;
            }
         }

         var10000 = this;
         break;
      }

      y.d.y var4 = var10000.a((y.f.X)var1.a(), (List)this.d);
      this.a.a(this.d, var4);
   }

   y.d.y a(y.f.X var1, List var2) {
      int var8 = ab.a;
      Rectangle2D var3 = y.f.ae.a(var1, var1.o());
      Iterator var4 = var2.iterator();

      y.d.y var10000;
      while(true) {
         if(var4.hasNext()) {
            N var5 = (N)var4.next();
            var10000 = var5.a();
            if(var8 != 0) {
               break;
            }

            y.d.y var6 = var10000;
            Double var7 = new Double(var6.c(), var6.d(), var6.a(), var6.b());
            Rectangle2D.union(var3, var7, var3);
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = new y.d.y(var3.getX() - 100.0D, var3.getY() - 100.0D, var3.getWidth() + 200.0D, var3.getHeight() + 200.0D);
         break;
      }

      return var10000;
   }

   public List c(R var1) {
      return this.a.c(var1);
   }

   public List d(R var1) {
      int var6 = ab.a;
      List var2 = this.a.d(var1);
      if(var2 == null) {
         return Collections.EMPTY_LIST;
      } else {
         ArrayList var3 = new ArrayList();
         Iterator var4 = var2.iterator();

         ArrayList var10000;
         while(true) {
            if(var4.hasNext()) {
               N var5 = (N)var4.next();
               if(!(var5.b() instanceof y.c.q)) {
                  continue;
               }

               var10000 = var3;
               if(var6 != 0) {
                  break;
               }

               var3.add(var5.b());
               if(var6 == 0) {
                  continue;
               }
            }

            var10000 = var3;
            break;
         }

         return var10000;
      }
   }

   public List e(R var1) {
      return this.a.d(var1);
   }

   public List a(y.c.q var1) {
      N var2 = (N)this.c.get(var1);
      if(var2 != null) {
         return this.a.a(var2);
      } else {
         throw new IllegalArgumentException("Unknown node");
      }
   }

   public List a(y.d.y var1) {
      return this.a.a(var1);
   }

   public y.d.y b() {
      return this.a.b();
   }

   public void a() {
      int var2 = ab.a;
      int var1 = 0;

      boolean var10000;
      while(true) {
         if(var1 < this.b.size()) {
            var10000 = this.b.get(var1) instanceof J;
            if(var2 != 0) {
               break;
            }

            if(var10000) {
               ((J)this.b.get(var1)).a();
            }

            ++var1;
            if(var2 == 0) {
               continue;
            }
         }

         var10000 = this.a instanceof l;
         break;
      }

      if(var10000) {
         ((l)this.a).b(this);
      }

      this.e = null;
      this.c.clear();
      this.d.clear();
      this.a.a();
   }

   public void a(R var1, List var2) {
      int var4 = ab.a;
      int var3 = this.b.size() - 1;

      while(var3 >= 0) {
         ((m)this.b.get(var3)).a(var1, var2);
         --var3;
         if(var4 != 0) {
            break;
         }
      }

   }

   public void b(R var1) {
      int var3 = ab.a;
      int var2 = this.b.size() - 1;

      while(var2 >= 0) {
         ((m)this.b.get(var2)).b(var1);
         --var2;
         if(var3 != 0) {
            break;
         }
      }

   }

   public void a(R var1) {
      int var3 = ab.a;
      var1.a(new bc(var1, this.f, this.e.c().k()));
      int var2 = this.b.size() - 1;

      while(var2 >= 0) {
         ((m)this.b.get(var2)).a(var1);
         --var2;
         if(var3 != 0) {
            break;
         }
      }

   }

   private double c() {
      int var6 = ab.a;
      double var1 = 0.0D;
      y var3 = this.e.c();
      y.c.e var4 = this.e.a().E().a();

      double var10000;
      while(true) {
         if(var4.f()) {
            y.c.d var5 = var4.a();
            var10000 = Math.max(var1, var3.a(var5).c());
            if(var6 != 0) {
               break;
            }

            var1 = var10000;
            var4.g();
            if(var6 == 0) {
               continue;
            }
         }

         var10000 = var1;
         break;
      }

      return var10000;
   }

   public N a(y.d.y var1, Object var2) {
      N var3 = new N(var1, var2);
      this.c.put(var2, var3);
      this.d.add(var3);
      return var3;
   }
}
