package y.h.b;

import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import y.h.b.a;
import y.h.b.c;
import y.h.b.d;
import y.h.b.j;
import y.h.b.q;
import y.h.b.s;

final class t extends q implements c {
   private d d;
   private final a e;

   t(a var1, double var2, double var4, y.d.r var6) {
      this(var1, (d)null, var2, var4, var6);
   }

   t(a var1, d var2, double var3, double var5, y.d.r var7) {
      super(var3, var5, var7);
      this.e = var1;
      this.d = var2;
   }

   t(a var1, t var2) {
      int var5 = a.H;
      super(var2);
      this.e = var1;
      Iterator var3 = var2.b.iterator();

      while(true) {
         if(var3.hasNext()) {
            t var4 = new t(var1, (t)var3.next());
            var4.d = this;
            this.b.add(var4);
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         this.d = null;
         break;
      }

   }

   a r() {
      return this.e;
   }

   public void a(double var1) {
      this.c(var1);
   }

   public double f() {
      return this.p();
   }

   public void b(double var1) {
      this.d(var1);
   }

   public double g() {
      return this.q();
   }

   double b(y.d.r var1) {
      return var1.b + var1.d;
   }

   public Rectangle2D h() {
      return a.a((a)this.e, (c)this);
   }

   public c j() {
      return this.c(this.b.size());
   }

   public c c(int var1) {
      int var15 = a.H;
      boolean var2 = a.c(this.e);
      if(var2) {
         a.a(this.e, false);
      }

      t var19;
      try {
         t var3 = new t(this.e, this.e.m(), this.e.n(), this.e.o());
         s var4 = new s();
         a.b(this.e, var4);
         double var5 = a.a(this.e);
         double var7 = this.q();
         y.d.r var9 = this.i();
         if(var9 != null) {
            var7 -= var9.b + var9.d;
         }

         double var10;
         label130: {
            if(!this.b.isEmpty() || var3.g() > var7) {
               var10 = this.b.isEmpty()?var3.g() - var7:var3.g();
               Object var12 = this;

               label108: {
                  while(var12 instanceof c) {
                     c var13 = (c)var12;
                     var13.b(var13.g() + var10);
                     var12 = var13.a();
                     if(var15 != 0) {
                        break label108;
                     }

                     if(var15 != 0) {
                        break;
                     }
                  }

                  this.b.add(var1, var3);
                  var3.d = this;
               }

               if(var15 == 0) {
                  break label130;
               }
            }

            var10 = 0.0D;
            var3.b(var7);
            this.b.add(var1, var3);
            var3.d = this;
         }

         s var18 = new s();
         a.b(this.e, var18);
         a.c(this.e, var5 + var10, this.r().getHeight() + var18.a - var4.a + var18.c - var4.c);
         var19 = var3;
      } finally {
         if(var2) {
            a.a(this.e, var2);
         }

      }

      return var19;
   }

   public void c() {
      if(this.d == null) {
         throw new IllegalStateException("Parent container is null.");
      } else {
         j var1 = this.m();
         if(var1 == this.d) {
            if(j.b(var1).size() <= 1 && this.k() <= 0) {
               throw new IllegalStateException("Sole column in table.");
            }

            a.a((a)this.e, (j)var1, (List)j.b(var1), (c)this);
            if(a.H != 0) {
               throw new IllegalStateException("Sole column in table.");
            }
         } else {
            a.a((a)this.e, (j)var1, (List)((t)this.d).b, (c)this);
         }

      }
   }

   public c b(int var1) {
      return (c)this.b.get(var1);
   }

   public int k() {
      return this.b.size();
   }

   private j m() {
      return a.e(this.r());
   }

   public List l() {
      return this.c;
   }

   public d a() {
      return this.d;
   }

   public void a(d var1) {
      this.c(var1);
      boolean var2 = a.c(this.e);
      if(var2) {
         a.a(this.e, false);
      }

      try {
         this.b(var1);
      } finally {
         if(var2) {
            a.a(this.e, var2);
         }

      }

   }

   private void b(d var1) {
      s var2;
      double var3;
      double var5;
      t var7;
      double var13;
      int var17;
      label161: {
         label160: {
            var17 = a.H;
            var2 = new s();
            a.b(this.e, var2);
            var3 = 0.0D;
            var5 = 0.0D;
            if(this.d instanceof j) {
               j.b((j)this.d).remove(this);
               if(var17 == 0) {
                  break label160;
               }
            }

            if(this.d instanceof t) {
               label164: {
                  var7 = (t)this.d;
                  int var8 = this.b();
                  var7.b.remove(var8);
                  if(var7.b.isEmpty()) {
                     var3 += this.q();
                     if(var17 == 0) {
                        break label164;
                     }
                  }

                  double var9 = this.q();
                  d var11 = this.d;

                  c var12;
                  int var10000;
                  label149: {
                     while(var11 instanceof c) {
                        var12 = (c)var11;
                        var13 = var12.g() - var12.f();
                        double var26;
                        var10000 = (var26 = var9 - var13) == 0.0D?0:(var26 < 0.0D?-1:1);
                        if(var17 != 0) {
                           break label149;
                        }

                        if(var10000 > 0) {
                           var9 = var13;
                        }

                        var11 = var12.a();
                        if(var17 != 0) {
                           break;
                        }
                     }

                     double var27;
                     var10000 = (var27 = var9 - this.q()) == 0.0D?0:(var27 < 0.0D?-1:1);
                  }

                  label138: {
                     if(var10000 < 0) {
                        double var23 = this.q() - var9;
                        var3 += var23;
                        boolean var14 = var7.b.size() == var8;
                        c var15 = (c)var7.b.get(var14?var8 - 1:var8);

                        while(var15 != null) {
                           var15.b(var15.g() + var23);
                           List var16 = var15.l();
                           var10000 = var16.isEmpty();
                           if(var17 != 0) {
                              break label138;
                           }

                           if(var10000 != 0) {
                              var15 = null;
                           } else {
                              var15 = (c)var16.get(var14?var16.size() - 1:0);
                              if(var17 != 0) {
                                 break;
                              }
                           }
                        }
                     }

                     double var28;
                     var10000 = (var28 = var9 - 0.0D) == 0.0D?0:(var28 < 0.0D?-1:1);
                  }

                  if(var10000 > 0) {
                     var11 = this.d;

                     while(var11 instanceof c) {
                        var12 = (c)var11;
                        var12.b(var12.g() - var9);
                        var11 = var12.a();
                        if(var17 != 0) {
                           break label161;
                        }

                        if(var17 != 0) {
                           break;
                        }
                     }
                  }
               }
            }
         }

         this.d = var1;
      }

      label114: {
         if(this.d instanceof j) {
            j.b((j)this.d).add(this);
            if(var17 == 0) {
               break label114;
            }
         }

         if(this.d instanceof t) {
            label169: {
               var7 = (t)this.d;
               var7.b.add(this);
               if(var7.b.size() == 1) {
                  double var19 = var7.g();
                  y.d.r var10 = var7.i();
                  var19 -= var10.b + var10.d;
                  double var22 = this.q();
                  if(var22 < var19) {
                     this.d(var19);
                     var3 -= var22;
                     if(var17 == 0) {
                        break label169;
                     }
                  }

                  if(var22 > var19) {
                     var13 = var22 - var19;
                     Object var24 = var7;

                     while(true) {
                        if(var24 instanceof c) {
                           c var25 = (c)var24;
                           var25.b(var25.g() + var13);
                           var24 = var25.a();
                           if(var17 != 0) {
                              break;
                           }

                           if(var17 == 0) {
                              continue;
                           }
                        }

                        var3 -= var22;
                        var3 += var13;
                        break;
                     }

                     if(var17 == 0) {
                        break label169;
                     }
                  }

                  var3 -= var22;
                  if(var17 == 0) {
                     break label169;
                  }
               }

               Object var20 = var7;

               while(var20 instanceof c) {
                  c var21 = (c)var20;
                  var21.b(var21.g() + this.q());
                  var20 = var21.a();
                  if(var17 != 0) {
                     break;
                  }
               }
            }
         }
      }

      s var18 = new s();
      a.b(this.e, var18);
      if(var18.a != var2.a || var18.c != var2.c) {
         var5 += var18.a - var2.a + (var18.c - var2.c);
      }

      if(var5 != 0.0D || var3 != 0.0D) {
         a.a(this.e, this.r().getX(), this.r().getY(), this.r().getWidth() + var3, this.r().getHeight() + var5);
         if(var17 == 0) {
            return;
         }
      }

      a.d(this.e);
   }

   private void c(d var1) {
      int var3 = a.H;
      if(this.d == null) {
         throw new IllegalStateException("Old parent is null.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("New parent is null.");
      } else {
         d var2 = var1;

         d var10000;
         t var10001;
         while(true) {
            if(var2 instanceof c) {
               var10000 = var2;
               var10001 = this;
               if(var3 != 0) {
                  break;
               }

               if(var2 == this) {
                  throw new IllegalArgumentException("New parent is descendant of column.");
               }

               var2 = ((c)var2).a();
               if(var3 == 0) {
                  continue;
               }
            }

            var10000 = var2;
            var10001 = this;
            break;
         }

         if(var10000 != var10001.m()) {
            throw new IllegalArgumentException("Parent does not belong to table.");
         }
      }
   }

   public int b() {
      if(this.d == null) {
         return -1;
      } else {
         j var1 = this.m();
         List var2 = var1 == this.d?j.b(var1):((t)this.d).b;
         return var2.indexOf(this);
      }
   }

   public void a(int var1) {
      if(this.d == null) {
         throw new IllegalStateException("Parent container is null.");
      } else {
         int var2 = this.b();
         if(var2 != var1) {
            j var3 = this.m();
            List var4 = var3 == this.d?j.b(var3):((t)this.d).b;
            var4.remove(var2);
            var4.add(var1, this);
            a.d(this.e);
         }

      }
   }

   public y.c.y d() {
      y.c.y var1 = new y.c.y();
      if(this.b.isEmpty()) {
         a.a((a)this.e, (Rectangle2D)this.h(), (Collection)var1);
      }

      return var1;
   }

   static d a(t var0, d var1) {
      return var0.d = var1;
   }
}
