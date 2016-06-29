package y.f.c;

import java.util.HashMap;
import y.f.c.D;
import y.f.c.R;
import y.f.c.a;
import y.f.c.af;
import y.f.c.s;
import y.f.c.t;
import y.f.c.u;
import y.f.c.w;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ba;

public class r implements R, aT {
   private y.c.q a;
   private y.c.q b;
   private y.c.y c;
   private R d;
   private y.c.c e;
   private HashMap f;
   private y.f.X g;
   private boolean h;
   private y.c.h i;
   private y.c.h j;
   private y.c.A k;
   private y.c.A l;
   private y.c.A m;
   private y.c.c n;
   private int o;
   private y.c.f p;
   private y.c.f q;
   private boolean r;

   public r(R var1) {
      this.d = new af();
      this.h = true;
      this.d = var1;
   }

   public r() {
      this(new af());
      ((af)this.d).a((byte)2);
   }

   public void a(boolean var1) {
      this.r = var1;
   }

   public int a(y.f.X var1, y.c.A var2, y.c.f var3) {
      boolean var9;
      label53: {
         var9 = a.i;
         this.g = new y.f.w();
         y.c.c var4 = var1.c(s.a);
         if(var4 != null) {
            this.e = (y.c.c)var4.b(s.a);
            if(!var9) {
               break label53;
            }
         }

         this.e = null;
      }

      label48: {
         label56: {
            y.c.c var5 = var1.c(y.f.ah.f_);
            this.f = new HashMap();
            this.n = var1.c("y.layout.hierarchic.ConstraintLayerer.EDGE_WEIGHTS_DPKEY");
            this.m = var1.t();
            this.k = this.g.t();
            this.o = 0;
            y.c.x var6;
            y.c.q var7;
            if(var5 != null) {
               var6 = var1.o();

               do {
                  if(!var6.f()) {
                     break label56;
                  }

                  var7 = var6.e();
                  Object var8 = var5.b(var7);
                  this.f.put(var8, var7);
                  var6.g();
                  if(var9) {
                     break label48;
                  }
               } while(!var9);
            }

            var6 = var1.o();

            while(var6.f()) {
               var7 = var6.e();
               this.f.put(var7, var7);
               var6.g();
               if(var9) {
                  break label48;
               }

               if(var9) {
                  break;
               }
            }
         }

         this.b(var1);
      }

      if(this.h && this.n == null) {
         var1.a((y.c.A)this.m);
         return this.c(var1, var2, var3);
      } else {
         this.a();
         this.b((y.c.i)var1);
         this.a(var1);
         int var10 = this.b(var1, var2);
         if(!this.r) {
            this.a(var1, var2);
            var10 = this.b(var1, var2);
         }

         this.b(var1, var2, var3);
         var1.a((y.c.A)this.m);
         this.f.clear();
         return var10;
      }
   }

   private void a(y.f.X var1, y.c.A var2) {
      boolean var15 = a.i;
      y.c.y var3 = new y.c.y();
      int var4 = 0;
      HashMap var5 = new HashMap();
      HashMap var6 = new HashMap();
      y.c.x var7 = this.c.a();

      y.c.q var8;
      y.c.q var10;
      while(true) {
         if(var7.f()) {
            var8 = var7.e();
            y.c.x var9 = var8.m();
            var10 = var9.e();
            var9.g();
            y.c.q var11 = var9.e();
            var5.put(var8, var10);
            var6.put(var8, var11);
            var7.g();
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         var7 = this.c.a();
         break;
      }

      while(true) {
         if(var7.f()) {
            var8 = var7.e();
            this.g.a((y.c.q)var8);
            var7.g();
            if(var15) {
               break;
            }

            if(!var15) {
               continue;
            }
         }

         var7 = this.c.a();
         break;
      }

      y.c.A var10000;
      y.c.q var18;
      int var19;
      while(true) {
         if(var7.f()) {
            var8 = var7.e();
            var18 = (y.c.q)var5.get(var8);
            var10 = (y.c.q)var6.get(var8);
            var19 = var2.a(((y.c.y)this.k.b(var18)).b());
            var10000 = var2;
            if(var15) {
               break;
            }

            int var12 = var2.a(((y.c.y)this.k.b(var10)).b());
            if(var18 != var10) {
               label96: {
                  if(var19 == var12) {
                     var3.add(var8);
                     if(!var15) {
                        break label96;
                     }
                  }

                  y.c.d var13;
                  if(var19 < var12) {
                     if(var18.a(var10) != null) {
                        break label96;
                     }

                     var13 = this.g.a((y.c.q)var18, (y.c.q)var10);
                     this.j.a(var13, var12 - var19);
                     this.i.a(var13, 1);
                     ++var4;
                     if(!var15) {
                        break label96;
                     }
                  }

                  if(var18.b(var10) == null) {
                     var13 = this.g.a((y.c.q)var10, (y.c.q)var18);
                     this.j.a(var13, var19 - var12);
                     this.i.a(var13, 1);
                     ++var4;
                  }
               }
            }

            var7.g();
            if(!var15) {
               continue;
            }
         }

         var10000 = this.g.t();
         break;
      }

      y.c.A var16 = var10000;
      y.a.m.a(y.a.m.a(this.g), var16);
      y.c.x var17 = var3.a();

      while(true) {
         if(var17.f()) {
            var18 = var17.e();
            var10 = (y.c.q)var5.get(var18);
            var19 = var16.a(var10);
            y.c.q var20 = (y.c.q)var6.get(var18);
            int var21 = var16.a(var20);
            if(var15) {
               break;
            }

            label47: {
               y.c.d var14;
               if(var19 <= var21) {
                  if(var10.a(var20) != null) {
                     break label47;
                  }

                  var14 = this.g.a((y.c.q)var10, (y.c.q)var20);
                  this.j.a(var14, 1);
                  this.i.a(var14, 100);
                  ++var4;
                  if(!var15) {
                     break label47;
                  }
               }

               if(var10.b(var20) == null) {
                  var14 = this.g.a((y.c.q)var20, (y.c.q)var10);
                  this.j.a(var14, 1);
                  this.i.a(var14, 100);
                  ++var4;
               }
            }

            var17.g();
            if(!var15) {
               continue;
            }
         }

         this.g.a((y.c.A)var16);
         break;
      }

   }

   private void b(y.f.X var1, y.c.A var2, y.c.f var3) {
      var3.addAll(w.a(var1, var2));
   }

   private void a(y.f.X var1) {
      boolean var6 = a.i;
      this.c = new y.c.y();
      this.o += var1.g() + 10;
      y.c.e var2 = this.q.a();

      y.c.d var3;
      y.c.q var4;
      y.c.q var5;
      while(true) {
         if(var2.f()) {
            var3 = var2.a();
            var4 = (y.c.q)this.m.b(var3.c());
            var5 = (y.c.q)this.m.b(var3.d());
            this.a(var4, var5, var3, false);
            var2.g();
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         var2 = this.p.a();
         break;
      }

      while(var2.f()) {
         var3 = var2.a();
         var4 = (y.c.q)this.m.b(var3.c());
         var5 = (y.c.q)this.m.b(var3.d());
         this.a(var4, var5, var3, true);
         var2.g();
         if(var6) {
            break;
         }
      }

   }

   private void a(y.c.q var1, y.c.q var2, y.c.d var3, boolean var4) {
      boolean var9 = a.i;
      int var5 = this.l.a(var1);
      int var6 = this.l.a(var2);
      y.c.d var7 = var1.c(var2);
      if(var7 != null) {
         int var8 = Math.max(this.n == null?1:this.n.a(var3), this.i.a(var7));
         this.i.a(var7, var8);
      } else if(var1 != var2) {
         if(var5 < var6) {
            this.a(var1, var2, var3, false, false);
            if(!var9) {
               return;
            }
         }

         if(var5 == var6) {
            this.a(var1, var2, var3, true, true);
            if(!var9) {
               return;
            }
         }

         this.a(var2, var1, var3, false, true);
      }
   }

   private void a(y.c.q var1, y.c.q var2, y.c.d var3, boolean var4, boolean var5) {
      y.c.q var6 = this.g.d();
      this.c.add(var6);
      y.c.d var7 = this.g.a((y.c.q)var6, (y.c.q)var1);
      int var8 = this.n == null?1:this.n.a(var3);
      this.i.a(var7, this.o);
      this.j.a(var7, 0);
      y.c.d var9 = this.g.a((y.c.q)var6, (y.c.q)var2);
      this.i.a(var9, var4?this.o:var8);
      this.j.a(var9, var4?0:1);
   }

   private void b(y.c.i var1) {
      boolean var13 = a.i;
      this.l = this.g.t();
      this.p = new y.c.f();
      this.q = new y.c.f();
      y.c.f var2 = new y.c.f();
      y.c.f var3 = new y.c.f();
      y.g.I var4 = new y.g.I(this.g);
      if(this.a != null) {
         var4.a(this.a.j());
      }

      if(this.b != null) {
         var4.a(this.b.j());
      }

      y.c.A var5 = this.g.t();
      y.a.h.a(this.g, (y.c.A)var5);
      y.c.e var6 = var1.p();

      while(true) {
         if(var6.f()) {
            y.c.d var7 = var6.a();
            y.c.q var8 = (y.c.q)this.m.b(var7.c());
            y.c.q var9 = (y.c.q)this.m.b(var7.d());
            if(var13) {
               break;
            }

            if(var8 != var9) {
               label75: {
                  int var10 = var5.a(var8);
                  int var11 = var5.a(var9);
                  y.c.d var12 = this.g.a((y.c.q)var8, (y.c.q)var9);
                  var3.add(var12);
                  if(var10 != var11) {
                     this.p.add(var7);
                     if(!var13) {
                        break label75;
                     }
                  }

                  this.q.add(var7);
               }
            }

            var6.g();
            if(!var13) {
               continue;
            }
         }

         var3.addAll(y.a.h.b(this.g));
         break;
      }

      int var14 = this.d.a(this.g, this.l, var2);
      y.c.e var15 = var2.a();

      y.c.d var16;
      while(true) {
         if(var15.f()) {
            var16 = var15.a();
            this.g.c(var16);
            var15.g();
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         var15 = var3.a();
         break;
      }

      while(true) {
         if(var15.f()) {
            var16 = var15.a();
            this.g.a((y.c.d)var16);
            var15.g();
            if(var13) {
               break;
            }

            if(!var13) {
               continue;
            }
         }

         var4.f();
         break;
      }

      if(this.a != null) {
         this.l.a(this.a, -1);
      }

      if(this.b != null) {
         this.l.a(this.b, var14 + 1);
      }

      this.g.a((y.c.A)var5);
   }

   private int b(y.f.X var1, y.c.A var2) {
      boolean var15 = a.i;
      y.c.A var3 = this.g.t();
      y.c.A var4 = var1.t();
      y.c.A var5 = this.g.t();
      int var6 = y.a.h.a(this.g, (y.c.A)var5);
      y.g.J var7 = new y.g.J(this.g, var5);
      int var8 = 0;

      y.f.X var10000;
      while(true) {
         if(var8 < var6) {
            var7.c(new Integer(var8));
            y.a.u.a(this.g, var3, this.i, this.j);
            var10000 = this.g;
            if(var15) {
               break;
            }

            y.c.x var9 = var10000.o();

            label45: {
               while(var9.f()) {
                  y.c.q var10 = var9.e();
                  int var11 = var3.a(var10);
                  y.c.y var12 = (y.c.y)this.k.b(var10);
                  if(var15) {
                     break label45;
                  }

                  label41: {
                     if(var12 != null) {
                        y.c.x var13 = var12.a();

                        while(var13.f()) {
                           y.c.q var14 = var13.e();
                           var4.a(var14, var11);
                           var13.g();
                           if(var15) {
                              break label41;
                           }

                           if(var15) {
                              break;
                           }
                        }
                     }

                     var9.g();
                  }

                  if(var15) {
                     break;
                  }
               }

               ++var8;
            }

            if(!var15) {
               continue;
            }
         }

         var8 = (new D()).a((y.c.i)var1, (y.c.c)var4, (y.c.a)var2);
         var1.a((y.c.A)var4);
         this.g.a((y.c.A)var3);
         var10000 = this.g;
         break;
      }

      var10000.a((y.c.A)var5);
      var7.b();
      return var8;
   }

   private int c(y.f.X var1, y.c.A var2, y.c.f var3) {
      boolean var9 = a.i;
      y.c.A var4 = var1.t();
      int var5 = y.a.h.a(var1, (y.c.A)var4);
      y.g.J var6 = new y.g.J(var1, var4);
      int var7 = 0;
      int var8 = 0;

      while(true) {
         if(var8 < var5) {
            var6.c(new Integer(var8));
            var7 = Math.max(var7, this.d.a(var1, var2, var3));
            ++var8;
            if(var9) {
               break;
            }

            if(!var9) {
               continue;
            }
         }

         var6.b();
         var1.a((y.c.A)var4);
         break;
      }

      return var7;
   }

   protected void a() {
      if(!y.a.g.a(this.g)) {
         throw new IllegalArgumentException("Circular constraints detected");
      }
   }

   private void b(y.f.X var1) {
      boolean var20 = a.i;
      y.c.h var2 = this.g.u();
      this.i = this.g.u();
      this.j = this.g.u();
      y.c.c var3 = var1.c(y.f.ah.f_);
      y.c.f var4 = new y.c.f();
      y.c.A var5 = this.g.t();
      y.c.A var6 = this.g.t();
      y.c.A var7 = this.g.t();
      this.a = null;
      this.b = null;
      y.c.x var8 = var1.o();

      y.c.q var9;
      y.c.q var10;
      boolean var10000;
      r var31;
      label227:
      while(true) {
         var10000 = var8.f();

         label224:
         while(var10000) {
            var9 = var8.e();
            var10 = this.a(var9);
            var31 = this;
            if(var20) {
               break label227;
            }

            if(this.e != null) {
               y.c.D var11 = (y.c.D)this.e.b(var3 != null?var3.b(var9):var9);
               if(var11 != null) {
                  this.h = false;
                  y.c.C var12 = var11.m();

                  while(var12.f()) {
                     Object var13 = var12.d();
                     var10000 = var13 instanceof u;
                     if(var20) {
                        continue label224;
                     }

                     if(var10000) {
                        u var14 = (u)var13;
                        y.c.q var15 = null;
                        Object var16 = var14.c();
                        y.c.q var17 = (y.c.q)this.f.get(var16);
                        var15 = this.a(var17);
                        boolean var18 = false;
                        y.c.d var19;
                        int var33;
                        switch(var14.b()) {
                        case 0:
                           if(var10 == null || var15 == null) {
                              break;
                           }

                           var19 = this.g.a((y.c.q)var10, (y.c.q)var15);
                           var4.add(var19);
                           var2.a(var19, true);
                           if(!var20) {
                              break;
                           }
                        case -1:
                           if(var10 == null || var15 == null) {
                              break;
                           }

                           var33 = var14.d();
                           var19 = this.g.a((y.c.q)var10, (y.c.q)var15);
                           this.j.a(var19, var33);
                           this.i.a(var19, 0);
                           ++this.o;
                           if(!var20) {
                              break;
                           }
                        case 1:
                           if(var10 == null || var15 == null) {
                              break;
                           }

                           var33 = var14.d();
                           var19 = this.g.a((y.c.q)var15, (y.c.q)var10);
                           this.j.a(var19, var33);
                           this.i.a(var19, var14.a());
                           ++this.o;
                           if(!var20) {
                              break;
                           }
                        case 2:
                           if(var10 == null) {
                              break;
                           }

                           label209: {
                              if(this.a == null) {
                                 this.a = var10;
                                 if(!var20) {
                                    break label209;
                                 }
                              }

                              var19 = this.g.a((y.c.q)var10, (y.c.q)this.a);
                              var4.add(var19);
                              var2.a(var19, true);
                           }

                           var6.a(var10, true);
                           if(!var20) {
                              break;
                           }
                        case -2:
                           if(var10 != null) {
                              label203: {
                                 if(this.b == null) {
                                    this.b = var10;
                                    if(!var20) {
                                       break label203;
                                    }
                                 }

                                 var19 = this.g.a((y.c.q)var10, (y.c.q)this.b);
                                 var4.add(var19);
                                 var2.a(var19, true);
                              }

                              var5.a(var10, true);
                           }
                        }
                     }

                     var12.g();
                     if(var20) {
                        break;
                     }
                  }
               }
            }

            var8.g();
            if(!var20) {
               continue label227;
            }
            break;
         }

         var31 = this;
         break;
      }

      label166: {
         y.c.d var23;
         label239: {
            if(var31.a != null) {
               var8 = this.g.o();

               while(var8.f()) {
                  var9 = var8.e();
                  var10000 = var6.d(var9);
                  if(var20) {
                     break label239;
                  }

                  if(!var10000 && !var7.d(var9)) {
                     var23 = this.g.a((y.c.q)this.a, (y.c.q)var9);
                     this.j.a(var23, 1);
                     this.i.a(var23, 0);
                  }

                  var8.g();
                  if(var20) {
                     break;
                  }
               }
            }

            if(this.b == null) {
               break label166;
            }

            var8 = this.g.o();
         }

         for(var10000 = var8.f(); var10000; var10000 = var8.f()) {
            var9 = var8.e();
            if(!var5.d(var9) && !var7.d(var9)) {
               var23 = this.g.a((y.c.q)var9, (y.c.q)this.b);
               this.j.a(var23, 1);
               this.i.a(var23, 0);
            }

            var8.g();
            if(var20) {
               break;
            }
         }
      }

      y.c.e var21 = var4.a();

      while(true) {
         if(var21.f()) {
            y.c.d var22 = var21.a();
            var10 = var22.c();
            y.c.q var24 = var22.d();
            this.g.a((y.c.d)var22);
            if(var20) {
               break;
            }

            label252: {
               if(var10 != var24 || !var2.d(var22)) {
                  y.c.f var25 = new y.c.f(var24.l());
                  y.c.e var26 = var25.a();

                  y.c.d var28;
                  label127: {
                     while(var26.f()) {
                        var28 = var26.a();
                        this.g.a(var28, var10, var28.d());
                        var26.g();
                        if(var20) {
                           break label127;
                        }

                        if(var20) {
                           break;
                        }
                     }

                     var25 = new y.c.f(var24.k());
                  }

                  var26 = var25.a();

                  while(var26.f()) {
                     var28 = var26.a();
                     this.g.a(var28, var28.c(), var10);
                     var26.g();
                     if(var20) {
                        break label252;
                     }

                     if(var20) {
                        break;
                     }
                  }

                  label109: {
                     y.c.y var27 = (y.c.y)this.k.b(var24);
                     y.c.y var29 = (y.c.y)this.k.b(var10);
                     if(var27 != null) {
                        y.c.x var30 = var27.a();

                        while(var30.f()) {
                           y.c.q var32 = var30.e();
                           var29.add(var32);
                           this.m.a(var32, var10);
                           var30.g();
                           if(var20) {
                              break label109;
                           }

                           if(var20) {
                              break;
                           }
                        }
                     }

                     if(var24 == this.b) {
                        this.b = var10;
                     }
                  }

                  if(var24 == this.a) {
                     this.a = var10;
                  }

                  this.g.a((y.c.q)var24);
               }

               var21.g();
            }

            if(!var20) {
               continue;
            }
         }

         this.g.a((y.c.h)var2);
         this.g.a((y.c.A)var5);
         this.g.a((y.c.A)var7);
         this.g.a((y.c.A)var6);
         break;
      }

   }

   private y.c.q a(y.c.q var1) {
      if(var1 == null) {
         return null;
      } else {
         y.c.q var2 = (y.c.q)this.m.b(var1);
         if(var2 == null) {
            var2 = this.g.d();
            this.m.a(var1, var2);
            y.c.y var3 = new y.c.y();
            var3.add(var1);
            this.k.a(var2, var3);
         }

         return var2;
      }
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      (new ba(this)).a(var1, var2, var3);
   }

   public static s a(y.c.i var0) {
      return new t(var0);
   }
}
