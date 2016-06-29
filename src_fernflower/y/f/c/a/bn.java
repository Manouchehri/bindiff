package y.f.c.a;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.f.c.a.N;
import y.f.c.a.bK;
import y.f.c.a.bh;
import y.f.c.a.bj;
import y.f.c.a.bk;
import y.f.c.a.bo;
import y.f.c.a.bp;
import y.f.c.a.bt;
import y.f.c.a.l;

public class bn extends y.f.a {
   private static final Object a;
   private HashMap b;
   private y.c.c c;
   private HashMap d;
   private y.c.D e;
   private l f;
   private y.c.c g;
   private y.c.c h;
   private byte i = 0;
   private boolean n = false;
   private HashMap o;
   private HashMap p;

   public void c(y.f.X var1) {
      boolean var22 = N.x;
      bk var2 = bk.c(var1);
      if(var2 == null) {
         this.a().c(var1);
         if(!var22) {
            return;
         }
      }

      this.g = var1.c(bk.a);
      this.h = var1.c(bk.b);
      if(!var1.i()) {
         if(var2.a()) {
            var2.f(var1);
         }

         if(var2.b()) {
            var2.e(var1);
         }

         if(this.b(var1)) {
            bh var3 = var2.a(0, 0);
            y.c.c var4 = var1.c(y.f.b.f.d);
            bo var5 = new bo(this, var4, var3);
            var1.a((Object)bk.b, (y.c.c)var5);
         }
      }

      y.c.c var23;
      y.c.y var24;
      y.g.I var25;
      label85: {
         var2 = this.a(var1, var2);
         var23 = var1.c(y.f.b.f.c);
         var24 = this.f(var1);
         var25 = new y.g.I(var1);
         var25.a(var24);
         if(var1.f() > 0) {
            this.a(var2, var1);
            this.a().c(var1);
            this.e(var1);
            if(!var22) {
               break label85;
            }
         }

         this.a(var2);
      }

      var25.f();
      y.c.c var6 = var1.c(bk.b);
      y.c.x var7 = var24.a();

      label62: {
         while(var7.f()) {
            y.c.q var8 = var7.e();
            bh var9 = (bh)var6.b(var8);
            double var10 = Double.MAX_VALUE;
            double var12 = Double.MAX_VALUE;
            double var14 = -1.7976931348623157E308D;
            double var16 = -1.7976931348623157E308D;
            if(var22) {
               break label62;
            }

            Iterator var18 = var9.a().iterator();

            while(true) {
               if(var18.hasNext()) {
                  bj var19 = (bj)var18.next();
                  l var20 = var19.b;
                  var10 = Math.min(var10, var20.h());
                  var14 = Math.max(var14, var20.h() + var20.e());
                  bt var21 = var19.a;
                  var12 = Math.min(var12, var21.h());
                  var16 = Math.max(var16, var21.h() + var21.e());
                  if(var22) {
                     break;
                  }

                  if(!var22) {
                     continue;
                  }
               }

               var1.b(var8, var14 - var10, var16 - var12);
               var1.c(var8, var10, var12);
               var7.g();
               break;
            }

            if(var22) {
               break;
            }
         }

         var7 = var24.a();
      }

      while(var7.f()) {
         y.c.e var26 = var7.e().j();

         label76: {
            while(var26.f()) {
               y.f.ae.a(var1, var26.a());
               var26.g();
               if(var22) {
                  break label76;
               }

               if(var22) {
                  break;
               }
            }

            var7.g();
         }

         if(var22) {
            break;
         }
      }

      this.d(var1);
      if(var23 != null) {
         var1.a((Object)y.f.b.f.c, (y.c.c)var23);
      }

      var1.a((Object)bk.b, (y.c.c)this.h);
      var1.a((Object)bk.a, (y.c.c)this.g);
   }

   private boolean b(y.f.X var1) {
      boolean var6 = N.x;
      y.c.c var2 = var1.c(bk.b);
      if(var2 == null) {
         return true;
      } else {
         y.c.x var3 = var1.o();

         while(var3.f()) {
            y.c.q var4 = var3.e();
            bh var5 = (bh)var2.b(var4);
            if(var5 != null && !var5.b()) {
               return false;
            }

            var3.g();
            if(var6) {
               break;
            }
         }

         return true;
      }
   }

   private void d(y.f.X var1) {
      boolean var6 = N.x;
      bk var2 = (bk)this.g.b(var1);
      boolean var10000;
      y.c.C var3;
      l var4;
      l var5;
      bt var7;
      bt var8;
      if(this.i != 0) {
         if(this.i == 1) {
            var3 = var2.f().m();

            label136: {
               while(var3.f()) {
                  var4 = (l)var3.d();
                  var8 = (bt)this.p.get(var4);
                  var4.g(var8.h());
                  var4.d(var8.e());
                  var3.g();
                  if(var6) {
                     break label136;
                  }

                  if(var6) {
                     break;
                  }
               }

               var3 = var2.e().m();
            }

            do {
               if(!var3.f()) {
                  return;
               }

               label155: {
                  var7 = (bt)var3.d();
                  var5 = (l)this.o.get(var7);
                  if(this.n) {
                     var7.g(var5.h());
                     if(!var6) {
                        break label155;
                     }
                  }

                  var7.g(var5.h() + var5.e());
               }

               var7.d(var5.e());
               var3.g();
            } while(!var6);
         }

         if(this.i == 3) {
            var3 = var2.f().m();

            label177: {
               while(var3.f()) {
                  var4 = (l)var3.d();
                  var8 = (bt)this.p.get(var4);
                  var4.g(var8.h() + var8.e());
                  var4.d(var8.e());
                  var3.g();
                  if(var6) {
                     break label177;
                  }

                  if(var6) {
                     break;
                  }
               }

               var3 = var2.e().m();
            }

            do {
               if(!var3.f()) {
                  return;
               }

               label196: {
                  var7 = (bt)var3.d();
                  var5 = (l)this.o.get(var7);
                  if(this.n) {
                     var7.g(var5.h() + var5.e());
                     if(!var6) {
                        break label196;
                     }
                  }

                  var7.g(var5.h());
               }

               var7.d(var5.e());
               var3.g();
            } while(!var6);
         }

         if(this.i == 2) {
            var3 = var2.f().m();

            while(true) {
               if(var3.f()) {
                  var4 = (l)var3.d();
                  var5 = (l)this.p.get(var4);
                  var10000 = this.n;
                  if(var6) {
                     break;
                  }

                  label227: {
                     if(var10000) {
                        var4.g(var5.h());
                        if(!var6) {
                           break label227;
                        }
                     }

                     var4.g(var5.h() + var5.e());
                  }

                  var4.d(var5.e());
                  var3.g();
                  if(!var6) {
                     continue;
                  }
               }

               var3 = var2.e().m();
               var10000 = var3.f();
               break;
            }

            while(var10000) {
               var7 = (bt)var3.d();
               var8 = (bt)this.o.get(var7);
               var7.g(var8.h() + var8.e());
               var7.d(var8.e());
               var3.g();
               if(var6) {
                  break;
               }

               var10000 = var3.f();
            }
         }
      } else {
         var3 = var2.f().m();

         while(true) {
            if(var3.f()) {
               var4 = (l)var3.d();
               var5 = (l)this.p.get(var4);
               var10000 = this.n;
               if(var6) {
                  break;
               }

               label269: {
                  if(var10000) {
                     var4.g(var5.h() + var5.e());
                     if(!var6) {
                        break label269;
                     }
                  }

                  var4.g(var5.h());
               }

               var4.d(var5.e());
               var3.g();
               if(!var6) {
                  continue;
               }
            }

            var3 = var2.e().m();
            var10000 = var3.f();
            break;
         }

         while(var10000) {
            var7 = (bt)var3.d();
            var8 = (bt)this.o.get(var7);
            var7.g(var8.h());
            var7.d(var8.e());
            var3.g();
            if(var6) {
               if(this.i == 1) {
                  var3 = var2.f().m();

                  label110: {
                     while(var3.f()) {
                        var4 = (l)var3.d();
                        var8 = (bt)this.p.get(var4);
                        var4.g(var8.h());
                        var4.d(var8.e());
                        var3.g();
                        if(var6) {
                           break label110;
                        }

                        if(var6) {
                           break;
                        }
                     }

                     var3 = var2.e().m();
                  }

                  do {
                     if(!var3.f()) {
                        return;
                     }

                     label117: {
                        var7 = (bt)var3.d();
                        var5 = (l)this.o.get(var7);
                        if(this.n) {
                           var7.g(var5.h());
                           if(!var6) {
                              break label117;
                           }
                        }

                        var7.g(var5.h() + var5.e());
                     }

                     var7.d(var5.e());
                     var3.g();
                  } while(!var6);
               }

               if(this.i == 3) {
                  var3 = var2.f().m();

                  label86: {
                     while(var3.f()) {
                        var4 = (l)var3.d();
                        var8 = (bt)this.p.get(var4);
                        var4.g(var8.h() + var8.e());
                        var4.d(var8.e());
                        var3.g();
                        if(var6) {
                           break label86;
                        }

                        if(var6) {
                           break;
                        }
                     }

                     var3 = var2.e().m();
                  }

                  do {
                     if(!var3.f()) {
                        return;
                     }

                     label93: {
                        var7 = (bt)var3.d();
                        var5 = (l)this.o.get(var7);
                        if(this.n) {
                           var7.g(var5.h() + var5.e());
                           if(!var6) {
                              break label93;
                           }
                        }

                        var7.g(var5.h());
                     }

                     var7.d(var5.e());
                     var3.g();
                  } while(!var6);
               }

               if(this.i == 2) {
                  var3 = var2.f().m();

                  while(true) {
                     if(var3.f()) {
                        var4 = (l)var3.d();
                        var5 = (l)this.p.get(var4);
                        var10000 = this.n;
                        if(var6) {
                           break;
                        }

                        label67: {
                           if(var10000) {
                              var4.g(var5.h());
                              if(!var6) {
                                 break label67;
                              }
                           }

                           var4.g(var5.h() + var5.e());
                        }

                        var4.d(var5.e());
                        var3.g();
                        if(!var6) {
                           continue;
                        }
                     }

                     var3 = var2.e().m();
                     var10000 = var3.f();
                     break;
                  }

                  while(var10000) {
                     var7 = (bt)var3.d();
                     var8 = (bt)this.o.get(var7);
                     var7.g(var8.h() + var8.e());
                     var7.d(var8.e());
                     var3.g();
                     if(var6) {
                        return;
                     }

                     var10000 = var3.f();
                  }
               }
               break;
            }

            var10000 = var3.f();
         }
      }

   }

   private void e(y.f.X var1) {
      boolean var14 = N.x;
      bk var2 = bk.c(var1);
      if(var2 != null) {
         var1.d_(a);
         if(this.c != null) {
            var1.a((Object)a, (y.c.c)this.c);
         }

         y.c.D var3 = var2.f();
         if(var3 != null) {
            Iterator var4 = var3.iterator();

            y.c.D var10000;
            label62: {
               while(var4.hasNext()) {
                  l var5 = (l)var4.next();
                  bK var6 = (bK)this.b.get(var5);
                  if(var6 != null) {
                     double var7 = var6.h();
                     double var9 = 0.0D;
                     y.c.D var11 = (y.c.D)this.d.get(var6);
                     var10000 = var11;
                     if(var14) {
                        break label62;
                     }

                     label58: {
                        if(var11 != null) {
                           y.c.C var12 = var11.m();

                           while(var12.f()) {
                              l var13 = (l)var12.d();
                              var13.g(var7);
                              var13.d(var13.b());
                              var9 += var13.e();
                              var7 += var13.e();
                              var12.g();
                              if(var14) {
                                 break label58;
                              }

                              if(var14) {
                                 break;
                              }
                           }
                        }

                        var5.g(var7);
                        var5.d(var6.i() - var9);
                     }

                     if(var14) {
                        break;
                     }
                  }
               }

               var10000 = this.e;
            }

            if(var10000 != null) {
               double var15 = this.f.h() + this.f.e();
               this.e.n();
               y.c.C var16 = this.e.m();

               while(var16.f()) {
                  l var17 = (l)var16.d();
                  var15 -= var17.b();
                  var17.g(var15);
                  var17.d(var17.b());
                  var16.g();
                  if(var14) {
                     return;
                  }

                  if(var14) {
                     break;
                  }
               }

               this.f.d(var15 - this.f.h());
            }
         }

      }
   }

   private void a(bk var1) {
      boolean var8 = N.x;
      double var2 = 0.0D;
      int var4 = 0;

      double var10000;
      while(true) {
         if(var4 < var1.f().size()) {
            l var5 = var1.b(var4);
            var5.g(var2);
            var5.d(var5.b());
            var10000 = var2 + var5.e();
            if(var8) {
               break;
            }

            var2 = var10000;
            ++var4;
            if(!var8) {
               continue;
            }
         }

         var10000 = 0.0D;
         break;
      }

      double var9 = var10000;
      int var6 = 0;

      while(var6 < var1.e().size()) {
         bt var7 = var1.a(var6);
         var7.g(var9);
         var7.d(var7.b());
         var9 += var7.e();
         ++var6;
         if(var8) {
            break;
         }
      }

   }

   private y.c.y f(y.f.X var1) {
      boolean var13 = N.x;
      y.c.y var2 = new y.c.y();
      if(y.f.b.c.b((y.c.i)var1)) {
         y.c.c var3 = var1.c(y.f.b.f.b);
         y.f.b.c var4 = new y.f.b.c(var1);
         y.c.c var5 = var1.c(bk.b);
         if(var5 != null) {
            y.c.A var6 = y.g.M.a();
            y.c.x var7 = var1.o();

            label59:
            do {
               boolean var10000 = var7.f();

               label56:
               while(true) {
                  if(!var10000) {
                     break label59;
                  }

                  y.c.q var8 = var7.e();
                  bh var9 = (bh)var5.b(var8);
                  if(var13) {
                     return var2;
                  }

                  if(var9 == null || !var9.b()) {
                     y.c.q var10 = var4.a(var8);
                     bh var11 = (bh)var5.b(var10);

                     while(var11 != null) {
                        var10000 = var11.b();
                        if(var13) {
                           continue label56;
                        }

                        if(!var10000) {
                           break;
                        }

                        var10 = var4.a(var10);
                        var11 = (bh)var5.b(var10);
                        if(var13) {
                           break;
                        }
                     }

                     Object var12 = var3 != null && var3.b(var10) != null?var3.b(var10):var10;
                     var6.a(var8, var12);
                     if(!var13) {
                        break;
                     }
                  }

                  var2.add(var8);
                  break;
               }

               var7.g();
            } while(!var13);

            var1.a((Object)y.f.b.f.c, (y.c.c)var6);
         }
      }

      return var2;
   }

   private void a(bk var1, y.f.X var2) {
      boolean var13 = N.x;
      this.b = new HashMap();
      this.d = new HashMap();
      bp var3 = new bp();
      this.e = null;
      HashSet var4 = new HashSet();
      var4.add((Object)null);
      y.c.c var5 = var2.c(bk.b);
      y.c.x var6 = var2.o();

      while(var6.f()) {
         y.c.q var7 = var6.e();
         bh var8 = (bh)var5.b(var7);
         if(var8 != null && !var8.b()) {
            var4.add(var8.d());
         }

         var6.g();
         if(var13) {
            break;
         }
      }

      y.c.D var14 = var1.f();
      if(var14 != null && !var14.isEmpty()) {
         y.g.e.a((List)var14, (Comparator)null);
         Iterator var15 = var14.iterator();

         while(var15.hasNext()) {
            y.c.D var17 = new y.c.D();
            double var9 = 0.0D;
            if(var13) {
               return;
            }

            l var11 = (l)var15.next();

            boolean var10000;
            while(true) {
               if(!var4.contains(var11)) {
                  var9 += var11.b();
                  var17.add(var11);
                  var10000 = var15.hasNext();
                  if(var13) {
                     break;
                  }

                  if(var10000) {
                     var11 = (l)var15.next();
                     if(!var13) {
                        continue;
                     }
                  }
               }

               var10000 = var4.contains(var11);
               break;
            }

            bK var12;
            if(var10000) {
               var12 = var3.a(var11);
               var12.c(var12.f() + var9);
               var12.b(var12.e() + var9);
               this.d.put(var12, var17);
               this.b.put(var11, var12);
               this.f = var11;
               if(!var13) {
                  continue;
               }
            }

            this.e = var17;
            var12 = (bK)this.b.get(this.f);
            var12.d(var12.g() + var9);
            var12.b(var12.e() + var9);
            if(var13) {
               break;
            }
         }

         y.c.A var16 = y.g.M.a();
         y.c.x var18 = var2.o();

         label47: {
            while(var18.f()) {
               y.c.q var19 = var18.e();
               bh var10 = (bh)var5.b(var19);
               if(var13) {
                  break label47;
               }

               if(var10 != null && !var10.b()) {
                  bK var20 = (bK)this.b.get(var10.d());
                  var16.a(var19, var20);
               }

               var18.g();
               if(var13) {
                  break;
               }
            }

            this.c = var2.c(a);
         }

         var2.a((Object)a, (y.c.c)var16);
      }

   }

   private bk a(y.f.X var1, bk var2) {
      boolean var17 = N.x;
      this.i = var2.a(var1);
      this.n = var2.b(var1);
      this.o = new HashMap();
      this.p = new HashMap();
      y.c.c var3 = var1.c(bk.b);
      bk var4 = null;
      y.c.A var5 = y.g.M.a();
      bt var8;
      l var9;
      y.c.D var10;
      y.c.D var11;
      Iterator var12;
      bj var13;
      bt var14;
      l var15;
      int var18;
      y.c.C var19;
      y.c.x var20;
      y.c.q var22;
      l var23;
      bh var26;
      bt var27;
      bt var28;
      l var31;
      bh var34;
      if(this.i == 0) {
         var18 = var2.f().size() - 1;
         var4 = new bk(var2.e().size(), var2.f().size());
         var19 = var2.f().m();

         boolean var41;
         while(true) {
            if(var19.f()) {
               var23 = (l)var19.d();
               var41 = this.n;
               if(var17) {
                  break;
               }

               label162: {
                  if(var41) {
                     var9 = var4.b(var18 - var23.a());
                     var9.c(var23.c());
                     var9.b(var23.d());
                     if(!var17) {
                        break label162;
                     }
                  }

                  var9 = var4.b(var23.a());
                  var9.c(var23.d());
                  var9.b(var23.c());
               }

               var9.a(var23.j());
               var9.a(var23.b());
               var9.h(var23.i());
               this.p.put(var23, var9);
               var19.g();
               if(!var17) {
                  continue;
               }
            }

            var19 = var2.e().m();
            var41 = var19.f();
            break;
         }

         while(var41) {
            var8 = (bt)var19.d();
            var28 = var4.a(var8.a());
            var28.a(var8.j());
            var28.a(var8.b());
            var28.b(var8.c());
            var28.c(var8.d());
            var28.h(var8.i());
            this.o.put(var8, var28);
            var19.g();
            if(var17) {
               return var4;
            }

            if(var17) {
               break;
            }

            var41 = var19.f();
         }

         var20 = var1.o();

         label143:
         while(var20.f()) {
            var22 = var20.e();
            var26 = (bh)var3.b(var22);
            if(var17) {
               return var4;
            }

            if(var26 != null) {
               label139: {
                  if(var26.b()) {
                     var10 = new y.c.D();
                     var11 = new y.c.D();
                     var12 = var26.a().iterator();

                     while(var12.hasNext()) {
                        var13 = (bj)var12.next();
                        var14 = (bt)this.o.get(var13.a);
                        var11.add(var14);
                        var15 = (l)this.p.get(var13.b);
                        var10.add(var15);
                        if(var17) {
                           continue label143;
                        }

                        if(var17) {
                           break;
                        }
                     }

                     var34 = var4.a((Collection)var11, (Collection)var10);
                     var5.a(var22, var34);
                     if(!var17) {
                        break label139;
                     }
                  }

                  var27 = (bt)this.o.get(var26.c());
                  var31 = (l)this.p.get(var26.d());
                  var34 = var4.a(var27, var31);
                  var5.a(var22, var34);
               }
            }

            var20.g();
         }

         var1.a((Object)bk.b, (y.c.c)var5);
         var1.a((Object)bk.a, (y.c.c)y.g.q.a((Object)var4));
      } else {
         if(this.i == 1) {
            var4 = new bk(var2.f().size(), var2.e().size());
            y.c.C var6 = var2.f().m();

            while(var6.f()) {
               l var7 = (l)var6.d();
               var8 = var4.a(var7.a());
               var8.a(var7.j());
               var8.a(var7.b());
               var8.b(var7.c());
               var8.c(var7.d());
               var8.h(var7.i());
               this.p.put(var7, var8);
               var6.g();
               if(var17) {
                  return var4;
               }

               if(var17) {
                  break;
               }
            }

            var18 = var2.e().size() - 1;
            var19 = var2.e().m();

            while(var19.f()) {
               var8 = (bt)var19.d();
               var9 = null;
               if(var17) {
                  return var4;
               }

               if(this.n) {
                  var9 = var4.b(var8.a());
                  var9.c(var8.d());
                  var9.b(var8.c());
               } else {
                  var9 = var4.b(var18 - var8.a());
                  var9.c(var8.c());
                  var9.b(var8.d());
               }

               var9.a(var8.j());
               var9.a(var8.b());
               var9.h(var8.i());
               this.o.put(var8, var9);
               var19.g();
               if(var17) {
                  break;
               }
            }

            var20 = var1.o();

            label283:
            while(true) {
               label281:
               while(true) {
                  if(!var20.f()) {
                     break label283;
                  }

                  var22 = var20.e();
                  var26 = (bh)var3.b(var22);
                  if(var17) {
                     return var4;
                  }

                  if(var26 == null) {
                     break;
                  }

                  if(var26.b()) {
                     var10 = new y.c.D();
                     var11 = new y.c.D();
                     var12 = var26.a().iterator();

                     while(var12.hasNext()) {
                        var13 = (bj)var12.next();
                        var14 = (bt)this.p.get(var13.b);
                        var11.add(var14);
                        var15 = (l)this.o.get(var13.a);
                        var10.add(var15);
                        if(var17) {
                           continue label281;
                        }

                        if(var17) {
                           break;
                        }
                     }

                     var34 = var4.a((Collection)var11, (Collection)var10);
                     var5.a(var22, var34);
                     if(!var17) {
                        break;
                     }
                  }

                  var27 = (bt)this.p.get(var26.d());
                  var31 = (l)this.o.get(var26.c());
                  var34 = var4.a(var27, var31);
                  var5.a(var22, var34);
                  break;
               }

               var20.g();
            }
         } else {
            l var16;
            int var21;
            y.c.C var24;
            y.c.x var25;
            y.c.q var30;
            bh var32;
            bt var33;
            y.c.D var35;
            Iterator var36;
            l var37;
            bh var38;
            bj var39;
            bt var40;
            if(this.i == 3) {
               var4 = new bk(var2.f().size(), var2.e().size());
               var18 = var2.f().size() - 1;
               var19 = var2.f().m();

               while(var19.f()) {
                  var23 = (l)var19.d();
                  var28 = var4.a(var18 - var23.a());
                  var28.a(var23.j());
                  var28.a(var23.b());
                  var28.b(var23.d());
                  var28.c(var23.c());
                  var28.h(var23.i());
                  this.p.put(var23, var28);
                  var19.g();
                  if(var17) {
                     return var4;
                  }

                  if(var17) {
                     break;
                  }
               }

               var21 = var2.e().size() - 1;
               var24 = var2.e().m();

               while(var24.f()) {
                  var28 = (bt)var24.d();
                  if(var17) {
                     return var4;
                  }

                  l var29;
                  label247: {
                     if(this.n) {
                        var29 = var4.b(var21 - var28.a());
                        var29.c(var28.c());
                        var29.b(var28.d());
                        if(!var17) {
                           break label247;
                        }
                     }

                     var29 = var4.b(var28.a());
                     var29.c(var28.d());
                     var29.b(var28.c());
                  }

                  var29.a(var28.j());
                  var29.a(var28.b());
                  var29.h(var28.i());
                  this.o.put(var28, var29);
                  var24.g();
                  if(var17) {
                     break;
                  }
               }

               var25 = var1.o();

               label238:
               while(true) {
                  label236:
                  while(true) {
                     if(!var25.f()) {
                        break label238;
                     }

                     var30 = var25.e();
                     var32 = (bh)var3.b(var30);
                     if(var17) {
                        return var4;
                     }

                     if(var32 == null) {
                        break;
                     }

                     if(var32.b()) {
                        var11 = new y.c.D();
                        var35 = new y.c.D();
                        var36 = var32.a().iterator();

                        while(var36.hasNext()) {
                           var39 = (bj)var36.next();
                           var40 = (bt)this.p.get(var39.b);
                           var35.add(var40);
                           var16 = (l)this.o.get(var39.a);
                           var11.add(var16);
                           if(var17) {
                              continue label236;
                           }

                           if(var17) {
                              break;
                           }
                        }

                        var38 = var4.a((Collection)var35, (Collection)var11);
                        var5.a(var30, var38);
                        if(!var17) {
                           break;
                        }
                     }

                     var33 = (bt)this.p.get(var32.d());
                     var37 = (l)this.o.get(var32.c());
                     var38 = var4.a(var33, var37);
                     var5.a(var30, var38);
                     break;
                  }

                  var25.g();
               }
            } else if(this.i == 2) {
               var4 = new bk(var2.e().size(), var2.f().size());
               var18 = var2.f().size() - 1;
               var19 = var2.f().m();

               int var10000;
               label213: {
                  while(var19.f()) {
                     var23 = (l)var19.d();
                     var9 = null;
                     var10000 = this.n;
                     if(var17) {
                        break label213;
                     }

                     if(var10000 != 0) {
                        var9 = var4.b(var23.a());
                        var9.c(var23.d());
                        var9.b(var23.c());
                     } else {
                        var9 = var4.b(var18 - var23.a());
                        var9.c(var23.c());
                        var9.b(var23.d());
                     }

                     var9.a(var23.j());
                     var9.a(var23.b());
                     var9.h(var23.i());
                     this.p.put(var23, var9);
                     var19.g();
                     if(var17) {
                        break;
                     }
                  }

                  var10000 = var2.e().size() - 1;
               }

               var21 = var10000;
               var24 = var2.e().m();

               while(var24.f()) {
                  var28 = (bt)var24.d();
                  var27 = var4.a(var21 - var28.a());
                  var27.a(var28.j());
                  var27.a(var28.b());
                  var27.b(var28.d());
                  var27.c(var28.c());
                  var27.h(var28.i());
                  this.o.put(var28, var27);
                  var24.g();
                  if(var17) {
                     return var4;
                  }

                  if(var17) {
                     break;
                  }
               }

               var25 = var1.o();

               while(var25.f()) {
                  var30 = var25.e();
                  var32 = (bh)var3.b(var30);
                  if(var17) {
                     return var4;
                  }

                  label191: {
                     if(var32 != null) {
                        label189: {
                           if(var32.b()) {
                              var11 = new y.c.D();
                              var35 = new y.c.D();
                              var36 = var32.a().iterator();

                              while(var36.hasNext()) {
                                 var39 = (bj)var36.next();
                                 var40 = (bt)this.o.get(var39.a);
                                 var35.add(var40);
                                 var16 = (l)this.p.get(var39.b);
                                 var11.add(var16);
                                 if(var17) {
                                    break label191;
                                 }

                                 if(var17) {
                                    break;
                                 }
                              }

                              var38 = var4.a((Collection)var35, (Collection)var11);
                              var5.a(var30, var38);
                              if(!var17) {
                                 break label189;
                              }
                           }

                           var33 = (bt)this.o.get(var32.c());
                           var37 = (l)this.p.get(var32.d());
                           var38 = var4.a(var33, var37);
                           var5.a(var30, var38);
                        }
                     }

                     var25.g();
                  }

                  if(var17) {
                     break;
                  }
               }
            }
         }

         var1.a((Object)bk.b, (y.c.c)var5);
         var1.a((Object)bk.a, (y.c.c)y.g.q.a((Object)var4));
      }

      return var4;
   }

   static y.c.c a(bn var0) {
      return var0.h;
   }

   static {
      a = y.f.c.M.r;
   }
}
