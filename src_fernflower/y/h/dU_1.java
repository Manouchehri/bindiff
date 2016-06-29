package y.h;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import y.h.aB;
import y.h.az;
import y.h.bu;
import y.h.ch;
import y.h.e;
import y.h.ed;
import y.h.ee;
import y.h.ef;
import y.h.eg;
import y.h.eh;
import y.h.ei;
import y.h.ej;
import y.h.ek;
import y.h.el;
import y.h.em;
import y.h.en;
import y.h.eo;
import y.h.ep;
import y.h.eq;
import y.h.es;
import y.h.eu;
import y.h.ev;
import y.h.ew;
import y.h.ex;
import y.h.ey;
import y.h.fL;
import y.h.fj;
import y.h.gy;
import y.h.gz;
import y.h.id;
import y.h.x;
import y.h.y;

public class dU extends e {
   private Set a;
   private Set b;
   private y.c.c c;
   private List d;
   private List e;
   private boolean f;
   private boolean g;
   private double h;
   private double i;
   private double j;
   private boolean k;
   private boolean l;
   private y.g.ai m;
   private y.g.ai n;
   private boolean o;
   private boolean p;
   private Set q;
   private boolean r;
   private boolean s;
   private ArrayList t;
   private boolean u;
   private boolean v;
   private double w;
   private Collection x;
   private Collection y;
   private boolean z;
   private boolean A;
   private double B;

   public dU() {
      this((ch)null);
   }

   public dU(ch var1) {
      super(var1);
      this.g = true;
      this.i = -1.0D;
      this.l = true;
      this.r = true;
      this.s = true;
      this.w = 40.0D;
      this.z = true;
      this.B = 10.0D;
   }

   public boolean l() {
      return this.v;
   }

   public void b(boolean var1) {
      this.s = var1;
   }

   public void c(boolean var1) {
      this.u = var1;
   }

   public void d(boolean var1) {
      this.r = var1;
   }

   public void e(boolean var1) {
      this.p = var1;
   }

   public void f(boolean var1) {
      this.o = var1;
   }

   public void g(boolean var1) {
      this.k = var1;
   }

   public double m() {
      return this.j;
   }

   public void b(double var1) {
      this.j = var1;
   }

   public void c(double var1) {
      this.i = var1;
   }

   public boolean n() {
      return this.A;
   }

   public void a(y.d.t var1, Collection var2, Collection var3, Collection var4, y.c.c var5) {
      boolean var8 = fj.z;
      super.g();
      this.a((y.d.t)var1);
      this.a = new HashSet(var2);
      this.b = new HashSet(var3.size());
      this.x = var3;
      this.y = var4;
      Iterator var6 = var3.iterator();

      while(true) {
         if(var6.hasNext()) {
            ek var7 = (ek)var6.next();
            this.b.add(var7.a());
            if(var8) {
               break;
            }

            if(!var8) {
               continue;
            }
         }

         this.c = var5;
         this.q = new HashSet(Math.max(32, this.c().getGraph2D().e() - var2.size()));
         this.a((Collection)var2, (Collection)this.q);
         this.d = new ArrayList();
         this.e = new ArrayList();
         this.b(this.d, this.e);
         this.m = new y.g.ai();
         this.n = new y.g.ai();
         this.o();
         this.q();
         this.p();
         break;
      }

      if(this.A) {
         gz var9 = this.b(var1, var2, var3, var4, var5);
         if(var9 != null) {
            this.a((gz)var9);
         }
      }

      this.v = true;
   }

   public void f() {
      super.f();
      this.v = false;
      this.a = null;
      this.b = null;
      this.c = null;
      this.x = null;
      this.y = null;
      this.d = null;
      this.e = null;
      this.q = null;
      this.t = null;
      this.m = this.n = null;
   }

   protected gz b(y.d.t var1, Collection var2, Collection var3, Collection var4, y.c.c var5) {
      boolean var11 = fj.z;
      if(var2.isEmpty() && var3.isEmpty()) {
         return null;
      } else {
         ArrayList var6 = new ArrayList();
         Iterator var7 = var2.iterator();

         while(true) {
            if(var7.hasNext()) {
               y.c.q var8 = (y.c.q)var7.next();
               bu var9 = (bu)var8.e();
               y.d.t var10 = var9.l(var8);
               var6.add(new ew(var10, var9.p(var8), var9.q(var8)));
               if(var11) {
                  break;
               }

               if(!var11) {
                  continue;
               }
            }

            if(var2.isEmpty()) {
               var7 = var3.iterator();

               while(var7.hasNext()) {
                  ek var12 = (ek)var7.next();
                  var6.add(new ew(var12.b(), var12.d(), var12.c(), 1.0D, 1.0D));
                  if(var11) {
                     return new ep(1.0D, this.c(), this.B, var1, var6);
                  }
               }
            }
            break;
         }

         return new ep(1.0D, this.c(), this.B, var1, var6);
      }
   }

   private void o() {
      boolean var16 = fj.z;
      if(this.r) {
         HashSet var1 = new HashSet(Math.min(32, this.b.size()));
         HashMap var2 = new HashMap(this.b.size());
         HashMap var3 = new HashMap(this.y.size());
         this.a((Map)var2, (Map)var3, (Set)var1);
         bu var4 = this.c().getGraph2D();
         Iterator var5 = var1.iterator();

         label69:
         while(true) {
            boolean var10000 = var5.hasNext();

            label67:
            while(var10000) {
               y.c.d var6 = (y.c.d)var5.next();
               aB var7 = var4.i(var6);
               el[] var8 = this.a((aB)var7, (Map)var2, (Map)var3);
               int var9 = 1;

               el var10;
               double var12;
               double var14;
               int var18;
               label58: {
                  while(var9 < var8.length) {
                     var10 = var8[var9 - 1];
                     el var11 = var8[var9];
                     var12 = var10.b().a - var11.b().a;
                     var14 = var10.b().b - var11.b().b;
                     var18 = var11.d();
                     if(var16) {
                        break label58;
                     }

                     if(var18 == 0 && var10.d()) {
                        this.m.a((Object)(new ev(this.k().a + var12, var10, var11)));
                     }

                     if(!var11.c() && var10.c()) {
                        this.n.a((Object)(new ev(this.k().b + var14, var10, var11)));
                     }

                     ++var9;
                     if(var16) {
                        break;
                     }
                  }

                  var18 = var8.length - 2;
               }

               var9 = var18;

               do {
                  if(var9 < 1) {
                     continue label69;
                  }

                  var10 = var8[var9 + 1];
                  ek var17 = (ek)var8[var9];
                  var12 = var10.b().a - var17.b().a;
                  var14 = var10.b().b - var17.b().b;
                  var10000 = var17.d();
                  if(var16) {
                     continue label67;
                  }

                  if(!var10000 && var10.d()) {
                     this.m.a((Object)(new ev(this.k().a + var12, var10, var17)));
                  }

                  if(!var17.c() && var10.c()) {
                     this.n.a((Object)(new ev(this.k().b + var14, var10, var17)));
                  }

                  --var9;
               } while(!var16);

               return;
            }

            return;
         }
      }
   }

   private el a(fL var1, Map var2) {
      el var3;
      if(var1 == var1.d().getSourcePort()) {
         if(!this.q.contains(var1.d().getEdge().c())) {
            return new em(var1, var1.f(), (byte)3);
         } else {
            if(!var2.isEmpty()) {
               var3 = (el)var2.get(var1);
               if(var3 != null) {
                  return var3;
               }
            }

            return new em(var1, var1.f(), (byte)0);
         }
      } else if(!this.q.contains(var1.d().getEdge().d())) {
         return new em(var1, var1.f(), (byte)3);
      } else {
         if(!var2.isEmpty()) {
            var3 = (el)var2.get(var1);
            if(var3 != null) {
               return var3;
            }
         }

         return new em(var1, var1.f(), (byte)0);
      }
   }

   private void p() {
      boolean var16 = fj.z;
      this.t = new ArrayList();
      if(this.u) {
         HashMap var1 = new HashMap(this.b.size());
         HashMap var2 = new HashMap(this.y.size());
         HashSet var3 = new HashSet(Math.min(32, this.b.size()));
         this.a((Map)var1, (Map)var2, (Set)var3);
         bu var4 = this.c().getGraph2D();
         Iterator var5 = var3.iterator();

         label61:
         while(true) {
            int var10000 = var5.hasNext();

            label59:
            while(var10000 != 0) {
               y.c.d var6 = (y.c.d)var5.next();
               aB var7 = var4.i(var6);
               el[] var8 = this.a((aB)var7, (Map)var1, (Map)var2);
               int var9 = 1;

               do {
                  if(var9 >= var8.length) {
                     continue label61;
                  }

                  el var10 = var8[var9 - 1];
                  el var11 = var8[var9];
                  double var12 = var10.b().a - var11.b().a;
                  double var14 = var10.b().b - var11.b().b;
                  double var17;
                  var10000 = (var17 = var12 - 0.0D) == 0.0D?0:(var17 < 0.0D?-1:1);
                  if(var16) {
                     continue label59;
                  }

                  label67: {
                     if(var10000 == 0 && (var14 != 0.0D || var10.c() != var11.c())) {
                        if(var10.d() || var11.d()) {
                           break label67;
                        }

                        this.t.add(new en(var10, var11));
                        if(!var16) {
                           break label67;
                        }
                     }

                     if(var14 == 0.0D && (var12 != 0.0D || var10.d() != var11.d()) && !var10.c() && !var11.c()) {
                        this.t.add(new en(var10, var11));
                     }
                  }

                  ++var9;
               } while(!var16);

               return;
            }

            return;
         }
      }
   }

   private void a(Map var1, Map var2, Set var3) {
      boolean var7 = fj.z;
      Iterator var4 = this.x.iterator();

      label77: {
         label76:
         while(true) {
            if(var4.hasNext()) {
               ek var5 = (ek)var4.next();
               var1.put(var5.a(), var5);
               if(var3 == null) {
                  continue;
               }

               var3.add(var5.a().a());
               if(var7) {
                  break;
               }

               if(!var7) {
                  continue;
               }
            }

            if(var3 != null) {
               var4 = this.a.iterator();

               while(var4.hasNext()) {
                  y.c.q var8 = (y.c.q)var4.next();
                  y.c.d var6 = var8.g();

                  label60: {
                     while(var6 != null) {
                        var3.add(var6);
                        var6 = var6.h();
                        if(var7) {
                           break label60;
                        }

                        if(var7) {
                           break;
                        }
                     }

                     var6 = var8.f();
                  }

                  while(var6 != null) {
                     var3.add(var6);
                     var6 = var6.g();
                     if(var7) {
                        break label77;
                     }

                     if(var7 || var7) {
                        break label76;
                     }
                  }
               }
            }
            break;
         }

         var4 = this.y.iterator();
      }

      while(var4.hasNext()) {
         em var9 = (em)var4.next();
         if((!var9.d() || !var9.c()) && var3 != null) {
            var3.add(var9.a().d().getEdge());
         }

         var2.put(var9.a(), var9);
         if(var7) {
            break;
         }
      }

   }

   private el[] a(aB var1, Map var2, Map var3) {
      boolean var8 = fj.z;
      el[] var4 = new el[var1.bendCount() + 2];
      var4[0] = this.a(var1.getSourcePort(), var3);
      int var5 = 1;
      y var6 = var1.bends();

      while(true) {
         if(var6.f()) {
            ek var7 = (ek)var2.get(var6.a());
            if(var8) {
               break;
            }

            if(var7 == null) {
               var7 = new ek(var6.a(), new y.d.t(var6.a().b(), var6.a().c()), (byte)0);
            }

            var4[var5++] = var7;
            var6.g();
            if(!var8) {
               continue;
            }
         }

         var4[var4.length - 1] = this.a(var1.getTargetPort(), var3);
         break;
      }

      return var4;
   }

   public void a(en var1) {
      this.t.add(var1);
   }

   public en a(el var1, el var2) {
      double var3 = var2.b().a - var1.b().a;
      double var5 = var2.b().b - var1.b().b;
      en var7 = null;
      if(var3 != 0.0D || var5 == 0.0D && var1.c() == var2.c()) {
         if(var5 == 0.0D && (var3 != 0.0D || var1.d() != var2.d()) && !var1.c() && !var2.c()) {
            var7 = new en(var1, var2);
            this.t.add(var7);
         }
      } else if(!var1.d() && !var2.d()) {
         var7 = new en(var1, var2);
         this.t.add(var7);
      }

      return var7;
   }

   public void b(en var1) {
      if(var1 != null && this.t != null) {
         this.t.remove(var1);
      }

   }

   private void q() {
      boolean var9 = fj.z;
      if(this.s) {
         bu var1 = this.c().getGraph2D();
         Iterator var2 = this.a.iterator();

         label69:
         while(true) {
            int var10000 = var2.hasNext();

            label67:
            while(true) {
               y.c.q var3;
               y.c.d var4;
               aB var5;
               Object var6;
               x var7;
               em var8;
               y.d.t var10;
               label59:
               while(true) {
                  if(var10000 == 0) {
                     return;
                  }

                  var3 = (y.c.q)var2.next();
                  var4 = var3.g();

                  while(true) {
                     if(var4 == null) {
                        break label59;
                     }

                     var5 = var1.i(var4);
                     var6 = null;
                     var10000 = var5.bendCount();
                     if(var9) {
                        break;
                     }

                     if(var10000 == 0) {
                        if(this.q.contains(var4.c())) {
                           var6 = new em(var5.getSourcePort(), var1.p(var4), (byte)0);
                        }
                     } else {
                        var7 = var5.lastBend();
                        if(!this.b.contains(var7)) {
                           var6 = new ek(var7, var7.e(), (byte)0);
                        }
                     }

                     if(var6 != null) {
                        var10 = var1.q(var4);
                        var8 = new em(var5.getTargetPort(), var10, (byte)3);
                        this.m.a((Object)(new ev(this.k().a + (((el)var6).b().a - var10.a), (el)var6, var8)));
                        this.n.a((Object)(new ev(this.k().b + (((el)var6).b().b - var10.b), (el)var6, var8)));
                     }

                     var4 = var4.h();
                     if(var9) {
                        break label59;
                     }
                  }
               }

               var4 = var3.f();

               do {
                  if(var4 == null) {
                     continue label69;
                  }

                  var5 = var1.i(var4);
                  var6 = null;
                  var10000 = var5.bendCount();
                  if(var9) {
                     continue label67;
                  }

                  if(var10000 == 0) {
                     if(this.q.contains(var4.d())) {
                        var6 = new em(var5.getTargetPort(), var1.q(var4), (byte)0);
                     }
                  } else {
                     var7 = var5.firstBend();
                     if(!this.b.contains(var7)) {
                        var6 = new ek(var7, var7.e(), (byte)0);
                     }
                  }

                  if(var6 != null) {
                     var10 = var1.p(var4);
                     var8 = new em(var5.getSourcePort(), var10, (byte)3);
                     this.m.a((Object)(new ev(this.k().a + (((el)var6).b().a - var10.a), (el)var6, var8)));
                     this.n.a((Object)(new ev(this.k().b + (((el)var6).b().b - var10.b), (el)var6, var8)));
                  }

                  var4 = var4.g();
               } while(!var9);

               return;
            }
         }
      }
   }

   protected void a(y.c.q var1, fj var2, Collection var3, Collection var4) {
      if(var2 instanceof y.h.b.a) {
         this.a(var1, (y.h.b.a)var2, var3, var4);
      }

      double var5 = var2.getCenterX();
      double var7 = var2.getCenterY();
      double var9 = var2.getX();
      double var11 = var2.getWidth();
      double var13 = var2.getY();
      double var15 = var2.getHeight();
      double var17 = var9 + var11;
      double var19 = var13 + var15;
      Object var21 = y.g.am.a(var1, Boolean.TRUE);
      Object var22 = y.g.am.a(var1, Boolean.FALSE);
      double var23 = this.w;
      var3.add(new eo((byte)0, (byte)2, new y.d.t(var5, var13), var9 - var23, var17 + var23, var22, 0.9D));
      var3.add(new eo((byte)0, (byte)1, new y.d.t(var5, var19), var9 - var23, var17 + var23, var22, 0.9D));
      var3.add(new eo((byte)1, (byte)8, new y.d.t(var9, var7), var13 - var23, var19 + var23, var21, 0.9D));
      var3.add(new eo((byte)1, (byte)4, new y.d.t(var17, var7), var13 - var23, var19 + var23, var21, 0.9D));
      double var25 = this.h;
      if(var25 > 0.0D) {
         var3.add(new ex((byte)0, (byte)2, new y.d.t(var5, var13 - var25), var9 - var23, var17 + var23, var22, 0.95D, var25));
         var3.add(new ex((byte)0, (byte)1, new y.d.t(var5, var19 + var25), var9 - var23, var17 + var23, var22, 0.95D, var25));
         var3.add(new ex((byte)1, (byte)8, new y.d.t(var9 - var25, var7), var13 - var23, var19 + var23, var21, 0.95D, var25));
         var3.add(new ex((byte)1, (byte)4, new y.d.t(var17 + var25, var7), var13 - var23, var19 + var23, var21, 0.95D, var25));
      }

      double var27 = this.i;
      if(var27 >= 0.0D) {
         var4.add(new ex((byte)0, (byte)2, new y.d.t(var5, var13 - var27), var9 - var23, var17 + var23, var22, 0.95D, var27));
         var4.add(new ex((byte)0, (byte)1, new y.d.t(var5, var19 + var27), var9 - var23, var17 + var23, var22, 0.95D, var27));
         var4.add(new ex((byte)1, (byte)8, new y.d.t(var9 - var27, var7), var13 - var23, var19 + var23, var21, 0.95D, var27));
         var4.add(new ex((byte)1, (byte)4, new y.d.t(var17 + var27, var7), var13 - var23, var19 + var23, var21, 0.95D, var27));
      }

      eo var29 = new eo((byte)0, (byte)16, new y.d.t(var5, var7), var22, 1.0D);
      eo var30 = new eo((byte)1, (byte)16, new y.d.t(var5, var7), var21, 1.0D);
      var3.add(var29);
      var3.add(var30);
      var4.add(var29);
      var4.add(var30);
      var3.add(new eo((byte)0, (byte)1, new y.d.t(var5, var13), var22, 0.5D));
      var3.add(new eo((byte)0, (byte)2, new y.d.t(var5, var19), var22, 0.5D));
      var3.add(new eo((byte)1, (byte)4, new y.d.t(var9, var7), var21, 0.5D));
      var3.add(new eo((byte)1, (byte)8, new y.d.t(var17, var7), var21, 0.5D));
   }

   protected void a(y.c.q var1, y.h.b.a var2, Collection var3, Collection var4) {
      boolean var11 = fj.z;
      Object var5 = y.g.am.a(var1, Boolean.TRUE);
      Object var6 = y.g.am.a(var1, Boolean.FALSE);
      ArrayList var7 = new ArrayList();
      var7.addAll(var2.l().o());

      ArrayList var10000;
      while(true) {
         if(!var7.isEmpty()) {
            var10000 = var7;
            if(var11) {
               break;
            }

            y.h.b.f var8 = (y.h.b.f)var7.remove(0);
            if(var8.o().isEmpty()) {
               Rectangle2D var9 = var8.h();
               var3.add(new gy((byte)0, (byte)16, new y.d.t(var9.getX(), var9.getCenterY()), var9.getX(), var9.getMaxX(), var6, 0.9D));
               if(!var11) {
                  continue;
               }
            }

            var7.addAll(var8.o());
            if(!var11) {
               continue;
            }
         }

         var10000 = new ArrayList();
         break;
      }

      ArrayList var12 = var10000;
      var12.addAll(var2.l().l());

      while(!var12.isEmpty()) {
         y.h.b.c var13 = (y.h.b.c)var12.remove(0);
         if(var13.l().isEmpty()) {
            Rectangle2D var10 = var13.h();
            var3.add(new gy((byte)1, (byte)16, new y.d.t(var10.getCenterX(), var10.getY()), var10.getY(), var10.getMaxY(), var5, 0.9D));
            if(!var11) {
               continue;
            }
         }

         var12.addAll(var13.l());
         if(var11) {
            break;
         }
      }

   }

   protected void b(Collection var1, Collection var2) {
      bu var3 = this.c().getGraph2D();
      if(this.k) {
         this.e(var1, var2);
      }

      if(this.l) {
         this.c(var1, var2);
      }

      if(this.f || this.g) {
         (new ed(this, var3, var1, var2)).a(var3, this.q, this.c().getVisibleRect().getBounds2D(), true);
         (new ee(this, var3, var1, var2)).a(var3, this.q, this.c().getVisibleRect().getBounds2D(), false);
      }

      if(this.z) {
         this.d(var1, var2);
      }

   }

   private void c(Collection var1, Collection var2) {
      boolean var7 = fj.z;
      bu var3 = this.c().getGraph2D();
      Iterator var4 = this.q.iterator();

      while(var4.hasNext()) {
         y.c.q var5 = (y.c.q)var4.next();
         fj var6 = var3.t(var5);
         if(this.a((fj)var6)) {
            this.a(var5, var1, var2);
            if(var7) {
               break;
            }
         }
      }

   }

   private void d(Collection var1, Collection var2) {
      boolean var9 = fj.z;
      if((!var1.isEmpty() || !var2.isEmpty()) && !this.q.isEmpty()) {
         bu var3 = this.c().getGraph2D();
         ArrayList var4 = new ArrayList();
         ArrayList var5 = new ArrayList();
         Iterator var6 = this.q.iterator();

         while(var6.hasNext()) {
            y.c.q var7 = (y.c.q)var6.next();
            fj var8 = var3.t(var7);
            if(this.a((fj)var8)) {
               var4.add(new es(var8.getX(), var8.getY(), var8.getY() + var8.getHeight(), true));
               var4.add(new es(var8.getX() + var8.getWidth(), var8.getY(), var8.getY() + var8.getHeight(), false));
               var5.add(new es(var8.getY(), var8.getX(), var8.getX() + var8.getWidth(), true));
               var5.add(new es(var8.getY() + var8.getHeight(), var8.getX(), var8.getX() + var8.getWidth(), false));
               if(var9) {
                  break;
               }
            }
         }

         HashSet var10 = new HashSet();
         var10.addAll(var1);
         var10.addAll(var2);
         this.a((List)var4, (List)var5, (Collection)var10);
         this.a((List)var4);
         this.a((List)var5);
      }
   }

   private void a(List var1) {
      boolean var11 = fj.z;
      y.g.e.a((List)var1, (Comparator)null);
      y.g.ai var2 = new y.g.ai(new ef(this));
      Iterator var3 = var1.iterator();

      label57:
      while(var3.hasNext()) {
         ey var4 = (ey)var3.next();
         if(var4 instanceof es) {
            es var5 = (es)var4;
            eq var6 = new eq((gy)null, 0.0D, var5.a, 0.0D, (eq)null);
            eq var7 = new eq((gy)null, 0.0D, var5.c, 0.0D, (eq)null);
            if(var2.a() == 0) {
               continue;
            }

            y.g.aj var8;
            y.g.aj var9;
            label37: {
               var8 = var2.c((Object)var7);
               var9 = var2.b((Object)var6);
               if(var9 == null) {
                  var9 = var2.b();
                  if(!var11) {
                     break label37;
                  }
               }

               var9 = var9.a();
            }

            while(true) {
               eq var10;
               while(true) {
                  if(var9 == var8) {
                     continue label57;
                  }

                  var10 = (eq)var9.c();
                  var9 = var9.a();
                  if(!var5.b) {
                     break;
                  }

                  if(var5.f > var10.c) {
                     var10.a.b(var5.f);
                     var2.a(var10.e);
                     var10.e = null;
                     if(var11) {
                        break;
                     }
                  }
               }

               if(var5.f < var10.c) {
                  var10.a.a(var5.f);
                  if(var11) {
                     return;
                  }

                  if(var11) {
                     break;
                  }
               }
            }
         }

         eq var12 = (eq)var4;
         if(var12.d == null) {
            var12.e = var2.a((Object)var12);
            if(!var11) {
               continue;
            }
         }

         if(var12.d.e != null) {
            var2.a(var12.d.e);
            var12.d.e = null;
            if(var11) {
               break;
            }
         }
      }

   }

   private void a(List var1, List var2, Collection var3) {
      boolean var8 = fj.z;
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         gy var5 = (gy)var4.next();
         y.d.t var6 = var5.b();
         eq var7;
         if(var5.c() == 0) {
            var7 = new eq(var5, var5.e(), var6.b, var6.a, (eq)null);
            var1.add(var7);
            var1.add(new eq(var5, var5.f(), var6.b, var6.a, var7));
            if(!var8) {
               continue;
            }
         }

         var7 = new eq(var5, var5.e(), var6.a, var6.b, (eq)null);
         var2.add(var7);
         var2.add(new eq(var5, var5.f(), var6.a, var6.b, var7));
         if(var8) {
            break;
         }
      }

   }

   private void e(Collection var1, Collection var2) {
      boolean var13 = fj.z;
      bu var3 = this.c().getGraph2D();
      HashMap var4 = new HashMap(this.b.size());
      HashMap var5 = new HashMap(this.y.size());
      this.a((Map)var4, (Map)var5, (Set)null);
      y.c.e var6 = var3.p();

      while(var6.f()) {
         y.c.d var7 = var6.a();
         aB var8 = var3.i(var7);
         dU var10000 = this;

         label43:
         while(true) {
            el[] var9 = var10000.a((aB)var8, (Map)var4, (Map)var5);
            int var10 = 1;

            while(true) {
               if(var10 >= var9.length) {
                  break label43;
               }

               el var11 = var9[var10 - 1];
               el var12 = var9[var10];
               var10000 = this;
               if(var13) {
                  break;
               }

               this.a(var1, var2, var8, var11.b(), var12.b(), var11.d() && var12.d(), var11.c() && var12.c());
               ++var10;
               if(var13) {
                  break label43;
               }
            }
         }

         var6.g();
         if(var13) {
            break;
         }
      }

   }

   private void a(Collection var1, Collection var2, aB var3, y.d.t var4, y.d.t var5, boolean var6, boolean var7) {
      double var8 = this.i;
      double var10 = this.j;
      Object var12;
      y.d.t var13;
      double var14;
      double var16;
      if(var4.a == var5.a && var6) {
         if(!this.a((aB)var3, (y.d.t)var4, (y.d.t)var5)) {
            return;
         }

         var12 = y.g.am.a(var3.getEdge(), Boolean.TRUE);
         var13 = new y.d.t(var4.a, (var5.b + var4.b) * 0.5D);
         var14 = Math.min(var4.b, var5.b) - this.w;
         var16 = Math.max(var4.b, var5.b) + this.w;
         var2.add(new eo((byte)1, (byte)4, var13, var12, 0.2D));
         var2.add(new eo((byte)1, (byte)8, var13, var12, 0.2D));
         if(var8 > 0.0D) {
            var1.add(new ex((byte)1, (byte)4, new y.d.t(var13.a + var8, var13.b), var14, var16, var12, 0.4D, var8));
            var1.add(new ex((byte)1, (byte)8, new y.d.t(var13.a - var8, var13.b), var14, var16, var12, 0.4D, var8));
         }

         if(var10 <= 0.0D) {
            return;
         }

         var2.add(new ex((byte)1, (byte)4, new y.d.t(var13.a + var10, var13.b), var14, var16, var12, 0.4D, var10));
         var2.add(new ex((byte)1, (byte)8, new y.d.t(var13.a - var10, var13.b), var14, var16, var12, 0.4D, var10));
         if(!fj.z) {
            return;
         }
      }

      if(var4.b == var5.b && var7 && this.a((aB)var3, (y.d.t)var4, (y.d.t)var5)) {
         var12 = y.g.am.a(var3.getEdge(), Boolean.FALSE);
         var13 = new y.d.t((var4.a + var5.a) * 0.5D, var5.b);
         var14 = Math.min(var4.a, var5.a) - this.w;
         var16 = Math.max(var4.a, var5.a) + this.w;
         var2.add(new eo((byte)0, (byte)1, var13, var12, 0.2D));
         var2.add(new eo((byte)0, (byte)2, var13, var12, 0.2D));
         if(var8 > 0.0D) {
            var1.add(new ex((byte)0, (byte)1, new y.d.t(var13.a, var13.b + var8), var14, var16, var12, 0.4D, var8));
            var1.add(new ex((byte)0, (byte)2, new y.d.t(var13.a, var13.b - var8), var14, var16, var12, 0.4D, var8));
         }

         if(var10 > 0.0D) {
            var2.add(new ex((byte)0, (byte)1, new y.d.t(var13.a, var13.b + var10), var14, var16, var12, 0.4D, var10));
            var2.add(new ex((byte)0, (byte)2, new y.d.t(var13.a, var13.b - var10), var14, var16, var12, 0.4D, var10));
         }
      }

   }

   public y.d.t b(y.d.t var1) {
      boolean var24 = fj.z;
      if(!this.v) {
         return var1;
      } else {
         ArrayList var2 = new ArrayList();
         double var3 = this.e() / this.c().getZoom();
         this.a(var3, this.m, var1.a, var2, true);
         this.a(var3, this.n, var1.b, var2, false);
         double var5 = var1.a - this.k().a;
         double var7 = var1.b - this.k().b;
         Iterator var9 = this.t.iterator();

         Iterator var10000;
         label174:
         while(true) {
            if(var9.hasNext()) {
               en var10 = (en)var9.next();
               Iterator var11 = this.e.iterator();

               gy var12;
               while(var11.hasNext()) {
                  var12 = (gy)var11.next();
                  this.a(var10, var5, var7, var3, var2, var12);
                  if(var24) {
                     continue label174;
                  }

                  if(var24) {
                     break;
                  }
               }

               if(this.j().isEmpty()) {
                  continue;
               }

               var10000 = this.j().iterator();
               if(var24) {
                  break;
               }

               var11 = var10000;

               do {
                  if(!var11.hasNext()) {
                     continue label174;
                  }

                  var12 = (gy)var11.next();
                  this.a(var10, var5, var7, var3, var2, var12);
               } while(!var24 && !var24);
            }

            var10000 = this.a.iterator();
            break;
         }

         var9 = var10000;

         dU var32;
         label147: {
            label181: {
               double var16;
               label145:
               while(true) {
                  if(var9.hasNext()) {
                     y.c.q var26 = (y.c.q)var9.next();

                     Double var28;
                     label140: {
                        try {
                           var28 = (Double)this.c.b(var26);
                           if(var28 != null) {
                              break label140;
                           }
                        } catch (Exception var25) {
                           continue;
                        }

                        if(!var24) {
                           continue;
                        }
                     }

                     double var30 = var28.getX() + var5;
                     double var14 = var30 + var28.getWidth();
                     var16 = var28.getY() + var7;
                     double var18 = var16 + var28.getHeight();
                     fj var20 = this.c().getGraph2D().t(var26);
                     eu var21 = new eu(var20);
                     int var22 = 0;

                     gy var23;
                     while(var22 < this.d.size()) {
                        var23 = (gy)this.d.get(var22);
                        this.a(var23, var21, var1, var30, var16, var14, var18, var3, var2);
                        ++var22;
                        if(var24) {
                           continue label145;
                        }

                        if(var24) {
                           break;
                        }
                     }

                     if(this.j().isEmpty()) {
                        continue;
                     }

                     var10000 = this.j().iterator();
                     if(var24) {
                        break;
                     }

                     Iterator var35 = var10000;

                     do {
                        if(!var35.hasNext()) {
                           continue label145;
                        }

                        var23 = (gy)var35.next();
                        this.a(var23, var21, var1, var30, var16, var14, var18, var3, var2);
                     } while(!var24 && !var24);
                  }

                  if(!this.p) {
                     break label181;
                  }

                  var10000 = this.x.iterator();
                  break;
               }

               var9 = var10000;

               label113:
               while(true) {
                  double var13;
                  boolean var15;
                  gy var19;
                  boolean var31;
                  label106:
                  do {
                     while(true) {
                        if(!var9.hasNext()) {
                           break label113;
                        }

                        el var27 = (el)var9.next();
                        y.d.t var29 = var27.b();
                        var31 = var27.d();
                        var13 = var31?var29.a:var29.a + var5;
                        var15 = var27.c();
                        var16 = var15?var29.b:var29.b + var7;
                        int var33 = 0;

                        while(true) {
                           if(var33 >= this.e.size()) {
                              continue label106;
                           }

                           var19 = (gy)this.e.get(var33);
                           this.a(var19, var1, var31, var15, var13, var16, var2);
                           ++var33;
                           if(var24) {
                              break;
                           }

                           if(var24) {
                              continue label106;
                           }
                        }
                     }
                  } while(this.j().isEmpty());

                  var32 = this;
                  if(var24) {
                     break label147;
                  }

                  Iterator var34 = this.j().iterator();

                  while(var34.hasNext()) {
                     var19 = (gy)var34.next();
                     this.a(var19, var1, var31, var15, var13, var16, var2);
                     if(var24 || var24) {
                        break label113;
                     }
                  }
               }
            }

            var32 = this;
         }

         if(var32.o) {
            if(Math.abs(var5) < Math.abs(var7)) {
               if(Math.abs(var5) >= var3) {
                  return this.a((List)var2, (y.d.t)var1);
               }

               var2.add(new eh(this, 10.0D, new eg(this, var1)));
               if(!var24) {
                  return this.a((List)var2, (y.d.t)var1);
               }
            }

            if(Math.abs(var7) < var3) {
               var2.add(new ej(this, 10.0D, new ei(this, var1)));
            }
         }

         return this.a((List)var2, (y.d.t)var1);
      }
   }

   private void a(gy var1, y.d.t var2, boolean var3, boolean var4, double var5, double var7, List var9) {
      double var10;
      if(var1.c() == 0) {
         if(var4 || var1.e() > var5 || var1.f() < var5) {
            return;
         }

         var10 = var1.b().b - var7;
         if(Math.abs(var10) >= 5.0D) {
            return;
         }

         var9.add(gz.a(0.1D, var1, false, var2.b + var10));
         if(!fj.z) {
            return;
         }
      }

      if(!var3 && var1.e() <= var7 && var1.f() >= var7) {
         var10 = var1.b().a - var5;
         if(Math.abs(var10) < 5.0D) {
            var9.add(gz.a(0.1D, var1, true, var2.a + var10));
         }
      }

   }

   private void a(gy var1, Rectangle2D var2, y.d.t var3, double var4, double var6, double var8, double var10, double var12, List var14) {
      boolean var24 = fj.z;
      double var15;
      double var17;
      double var19;
      Object var25;
      switch(var1.d()) {
      case 16:
         double var21;
         Object var23;
         if(var1.c() == 1) {
            if(var6 >= var1.f() || var10 <= var1.e()) {
               break;
            }

            var15 = (var4 + var8) * 0.5D;
            var17 = var1.b().a - var15;
            var19 = Math.abs(var17);
            if(var19 >= var12) {
               break;
            }

            var21 = var12 - var19;
            var23 = var1 instanceof id?((id)var1).a(var2):var1;
            var14.add(gz.a(var21 * var1.a(), (az)var23, true, var3.a + var17, var1.g()));
            if(!var24) {
               break;
            }
         }

         if(var4 >= var1.f() || var8 <= var1.e()) {
            break;
         }

         var15 = (var6 + var10) * 0.5D;
         var17 = var1.b().b - var15;
         var19 = Math.abs(var17);
         if(var19 >= var12) {
            break;
         }

         var21 = var12 - var19;
         var23 = var1 instanceof id?((id)var1).a(var2):var1;
         var14.add(gz.a(var21 * var1.a(), (az)var23, false, var3.b + var17, var1.g()));
         if(!var24) {
            break;
         }
      case 1:
         if(var4 >= var1.f() || var8 <= var1.e()) {
            break;
         }

         var15 = var1.b().b - var6;
         var17 = Math.abs(var15);
         if(var17 >= var12) {
            break;
         }

         var19 = var12 - var17;
         var25 = var1 instanceof id?((id)var1).a(var2):var1;
         var14.add(gz.a(var19 * var1.a(), (az)var25, false, var3.b + var15, var1.g()));
         if(!var24) {
            break;
         }
      case 8:
         if(var6 >= var1.f() || var10 <= var1.e()) {
            break;
         }

         var15 = var1.b().a - var8;
         var17 = Math.abs(var15);
         if(var17 >= var12) {
            break;
         }

         var19 = var12 - var17;
         var25 = var1 instanceof id?((id)var1).a(var2):var1;
         var14.add(gz.a(var19 * var1.a(), (az)var25, true, var3.a + var15, var1.g()));
         if(!var24) {
            break;
         }
      case 2:
         if(var4 >= var1.f() || var8 <= var1.e()) {
            break;
         }

         var15 = var1.b().b - var10;
         var17 = Math.abs(var15);
         if(var17 >= var12) {
            break;
         }

         var19 = var12 - var17;
         var25 = var1 instanceof id?((id)var1).a(var2):var1;
         var14.add(gz.a(var19 * var1.a(), (az)var25, false, var3.b + var15, var1.g()));
         if(!var24) {
            break;
         }
      case 4:
         if(var6 < var1.f() && var10 > var1.e()) {
            var15 = var1.b().a - var4;
            var17 = Math.abs(var15);
            if(var17 < var12) {
               var19 = var12 - var17;
               var25 = var1 instanceof id?((id)var1).a(var2):var1;
               var14.add(gz.a(var19 * var1.a(), (az)var25, true, var3.a + var15, var1.g()));
            }
         }
      }

   }

   private void a(en var1, double var2, double var4, double var6, List var8, gy var9) {
      gz var10 = var1.a(var9, this.k(), var2, var4, var6);
      if(var10 != gz.b) {
         var8.add(var10);
      }

   }

   private void a(double var1, y.g.ai var3, double var4, List var6, boolean var7) {
      boolean var19 = fj.z;
      if(var3.a() != 0) {
         y.g.aj var8;
         y.g.aj var9;
         ev var18;
         label78: {
            var8 = var3.b((Object)(new ev(var4, (el)null, (el)null)));
            var9 = var8 != null?var8.a():var3.b();
            double var10 = var8 != null?((ev)var8.c()).a:java.lang.Double.POSITIVE_INFINITY;
            double var12 = var9 != null?((ev)var9.c()).a:java.lang.Double.POSITIVE_INFINITY;
            double var14 = var10 - var4;
            double var16 = var12 - var4;
            if(Math.abs(var14) < var1) {
               if(Math.abs(var16) < Math.abs(var14)) {
                  var18 = (ev)var9.c();
                  if(!var19) {
                     break label78;
                  }
               }

               var18 = (ev)var8.c();
               if(!var19) {
                  break label78;
               }
            }

            if(Math.abs(var16) < var1) {
               var18 = (ev)var9.c();
               if(!var19) {
                  break label78;
               }
            }

            var18 = null;
         }

         if(var18 != null) {
            while(true) {
               if(var9 != null) {
                  double var20;
                  int var10000 = (var20 = ((ev)var9.c()).a - var18.a) == 0.0D?0:(var20 < 0.0D?-1:1);
                  if(!var19) {
                     if(var10000 == 0) {
                        var6.add(((ev)var9.c()).a(var7));
                        var9 = var9.a();
                        if(!var19) {
                           continue;
                        }
                     }
                  } else {
                     if(var10000 != 0) {
                        break;
                     }

                     var6.add(((ev)var8.c()).a(var7));
                     var8 = var8.b();
                     if(var19) {
                        break;
                     }
                  }
               }

               do {
                  if(var8 == null || ((ev)var8.c()).a != var18.a) {
                     return;
                  }

                  var6.add(((ev)var8.c()).a(var7));
                  var8 = var8.b();
               } while(!var19);

               return;
            }
         }

      }
   }

   protected void a(y.c.q var1, Collection var2, Collection var3) {
      bu var4 = this.c().getGraph2D();
      fj var5 = var4.t(var1);
      if(this.a((fj)var5)) {
         this.a(var1, var5, var2, var3);
      }

   }

   static double a(dU var0) {
      return var0.w;
   }

   static boolean b(dU var0) {
      return var0.g;
   }

   static boolean c(dU var0) {
      return var0.f;
   }
}
