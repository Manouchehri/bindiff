package y.f.c.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.V;
import y.f.c.a.aQ;
import y.f.c.a.aS;
import y.f.c.a.aT;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.ah;
import y.f.c.a.cd;
import y.f.c.a.x;

class al implements aT {
   private aT a;
   private aS b;
   private aT c;
   private y.c.c d;
   private y.c.A e;
   private Map f;
   private Map g;
   private boolean h;
   private final N i;

   public al(N var1, aT var2, aT var3, y.c.c var4, y.c.A var5, boolean var6) {
      this.i = var1;
      this.a = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.h = var6;
   }

   public void a(y.f.X var1, aU var2, aV var3) {
      boolean var22 = N.x;
      y.c.c var4 = var1.c(N.w);
      if(var4 == null) {
         N.a(this.i, (y.f.X)var1, (y.c.c)this.d, (aT)this.a, (aU)var2, (aV)var3, (aT)this.c, (y.c.A)this.e, (E)null);
      } else {
         E var5 = (E)var4.b(var1);
         var5.c();
         if(var5.k() && !y.f.b.c.c((y.c.i)var1)) {
            y.f.b.c var6 = new y.f.b.c(var1);
            this.b = new x(N.a(this.i));
            V var7 = new V(this, var6);
            y.g.J var8 = new y.g.J(var1, var7);
            y.c.f var9 = new y.c.f();
            if(this.h) {
               y.f.b.c var10 = new y.f.b.c(var1);
               boolean var24 = false;

               y.f.b.c var10000;
               label236: {
                  try {
                     var24 = true;
                     ArrayList var11 = new ArrayList();
                     ArrayList var12 = new ArrayList();
                     y.c.e var13 = (new y.c.f(var1.p())).a();

                     while(true) {
                        if(!var13.f()) {
                           var24 = false;
                           break;
                        }

                        y.c.d var14 = var13.a();
                        var10000 = var10;
                        if(var22) {
                           var24 = false;
                           break label236;
                        }

                        label228: {
                           if(!var10.a(var14)) {
                              var11.clear();
                              var12.clear();
                              y.c.q var15 = var14.c();
                              y.c.q var16 = var14.d();
                              y.c.q var17 = var10.a(var15);

                              label217: {
                                 while(var17 != var10.b()) {
                                    var11.add(var17);
                                    var17 = var10.a(var17);
                                    if(var22) {
                                       break label217;
                                    }

                                    if(var22) {
                                       break;
                                    }
                                 }

                                 var17 = var10.a(var16);
                              }

                              while(var17 != var10.b()) {
                                 var12.add(var17);
                                 var17 = var10.a(var17);
                                 if(var22) {
                                    break label228;
                                 }

                                 if(var22) {
                                    break;
                                 }
                              }

                              int var28 = 0;

                              label206:
                              do {
                                 int var27 = var28;
                                 int var10001 = var11.size();

                                 do {
                                    if(var27 >= var10001) {
                                       break label206;
                                    }

                                    var27 = var28;
                                    var10001 = var12.size();
                                 } while(var22);

                                 if(var28 >= var10001 || var11.get(var28) != var12.get(var28)) {
                                    break;
                                 }

                                 ++var28;
                              } while(!var22);

                              y.c.q var18 = var28 > 0?(y.c.q)var11.get(var28 - 1):var10.b();
                              y.c.q var19 = var10.a(var15, var18);
                              y.c.q var20 = var10.a(var16, var18);
                              var9.add(var1.a((y.c.q)var19, (y.c.q)var20));
                           }

                           var13.g();
                        }

                        if(var22) {
                           var24 = false;
                           break;
                        }
                     }
                  } finally {
                     if(var24) {
                        var10.c();
                     }
                  }

                  var10000 = var10;
               }

               var10000.c();
            }

            this.a(var1, (y.c.q)null, var2, var6, var8, var3);
            y.c.e var26 = var9.a();

            while(true) {
               if(var26.f()) {
                  var1.a((y.c.d)var26.a());
                  var26.g();
                  if(var22) {
                     break;
                  }

                  if(!var22) {
                     continue;
                  }
               }

               var6.c();
               var5.b();
               break;
            }

         } else {
            var5.b();
            N.a(this.i, var1, this.d, this.a, var2, var3, this.c, this.e, var5);
         }
      }
   }

   private void a(y.f.X var1, y.c.q var2, aU var3, y.f.b.c var4, y.g.J var5, aV var6) {
      cd var7;
      boolean var22;
      label110: {
         var22 = N.x;
         this.a(var1, var4, var4.b(var2));
         var5.c(var2);
         var7 = new cd();
         var7.a(var1);
         ah var8 = N.a(this.i, var1, this.d);
         this.a.a(var1, var3, var6);
         N.a(this.i, var1, var3);
         if(var4.d(var2)) {
            N.a(this.i, (aT)this.c, (y.f.X)var1, (aU)var3, (aV)var6, (ah)var8, (y.c.a)this.e, (y.f.b.c)var4, (y.c.q)var2);
            if(!var22) {
               break label110;
            }
         }

         N.a((N)this.i, (aT)this.c, (y.f.X)var1, (aU)var3, (aV)var6, (ah)var8, (y.c.a)this.e, (y.c.A)null);
      }

      var7.b(var1);
      var5.b();
      this.a(var1);
      int var9 = 0;

      label104:
      while(var9 < var3.b()) {
         aQ var10 = var3.a(var9);
         y.c.y var11 = var10.d();
         aU var12 = var3.a();
         y.c.y var13 = new y.c.y();
         y.c.y var14 = new y.c.y();
         y.c.x var10000 = var11.a();

         int var23;
         label101:
         while(true) {
            y.c.x var15 = var10000;

            int var24;
            label63: {
               while(var15.f()) {
                  y.c.q var16 = var15.e();
                  var24 = var4.d(var16);
                  if(var22) {
                     break label63;
                  }

                  label59: {
                     if(var24 != 0) {
                        var14.add(var16);
                        aU var17 = var3.a();
                        this.a(var1, var16, var17, var4, var5, var6);
                        if(var17.b() > 0) {
                           this.b.a(var1, var6, var17, var12);
                           var14.add(var16);
                           if(!var22) {
                              break label59;
                           }
                        }

                        var13.add(var16);
                        if(!var22) {
                           break label59;
                        }
                     }

                     var13.add(var16);
                  }

                  var15.g();
                  if(var22) {
                     break;
                  }
               }

               var24 = var14.size();
            }

            if(var24 <= 0) {
               ++var9;
               if(var22) {
                  return;
               }
               continue label104;
            }

            var23 = var12.b();
            int var25 = 0;
            switch(N.a(this.i)) {
            case 18:
               var25 = 0;
               if(!var22) {
                  break;
               }
            case 66:
               var25 = var23 / 2;
               if(!var22) {
                  break;
               }
            case 34:
               var25 = var23 - 1;
            }

            y.c.x var26 = var13.a();

            while(var26.f()) {
               y.c.q var18 = var26.e();
               var12.a(var25).a(var18);
               var26.g();
               if(var22) {
                  continue label104;
               }

               if(var22) {
                  break;
               }
            }

            int var27 = 0;

            while(true) {
               if(var27 >= var23) {
                  break label101;
               }

               aQ var28 = var12.a(var27);
               aQ var19 = var3.a(var28.e(), var9 + var27);
               var10000 = var28.d().a();
               if(var22) {
                  break;
               }

               y.c.x var20 = var10000;

               label96: {
                  while(var20.f()) {
                     y.c.q var21 = var20.e();
                     var19.a(var21);
                     var20.g();
                     if(var22) {
                        break label96;
                     }

                     if(var22) {
                        break;
                     }
                  }

                  ++var27;
               }

               if(var22) {
                  break label101;
               }
            }
         }

         var9 += var23;
         var3.b(var9);
      }

   }

   private void a(y.f.X var1, y.f.b.c var2, y.c.y var3) {
      boolean var11 = N.x;
      this.f = new HashMap();
      this.g = new HashMap();
      y.c.x var4 = var3.a();

      while(var4.f()) {
         label99: {
            y.c.q var5 = var4.e();
            if(var2.d(var5)) {
               y.c.y var6 = new y.c.y();
               this.a(var2, var5, var6);
               y.c.f var7 = new y.c.f();
               y.c.f var8 = new y.c.f();
               y.c.x var9 = var6.a();

               while(var9.f()) {
                  y.c.q var10 = var9.e();
                  var8.a(var10.k());
                  var7.a(var10.l());
                  var9.g();
                  if(var11) {
                     break label99;
                  }

                  if(var11) {
                     break;
                  }
               }

               y.c.e var12 = var8.a();

               label88:
               while(true) {
                  y.c.d var13;
                  y.c.q var10000;
                  y.c.q var10001;
                  if(var12.f()) {
                     var13 = var12.a();
                     var10000 = var13.c();
                     var10001 = var5;
                     if(!var11) {
                        if(var10000 != var5) {
                           this.f.put(var13, var13.d());
                           var1.a(var13, var13.c(), var5);
                        }

                        var12.g();
                        if(!var11) {
                           continue;
                        }

                        var12 = var7.a();
                        if(!var12.f()) {
                           break;
                        }

                        var13 = var12.a();
                        var10000 = var13.d();
                        var10001 = var5;
                     }
                  } else {
                     var12 = var7.a();
                     if(!var12.f()) {
                        break;
                     }

                     var13 = var12.a();
                     var10000 = var13.d();
                     var10001 = var5;
                  }

                  while(true) {
                     while(var11) {
                        if(var10000 != var10001) {
                           this.f.put(var13, var13.d());
                           var1.a(var13, var13.c(), var5);
                        }

                        var12.g();
                        if(!var11) {
                           continue label88;
                        }

                        var12 = var7.a();
                        if(!var12.f()) {
                           break label88;
                        }

                        var13 = var12.a();
                        var10000 = var13.d();
                        var10001 = var5;
                     }

                     if(var10000 != var10001) {
                        this.g.put(var13, var13.c());
                        var1.a(var13, var5, var13.d());
                     }

                     var12.g();
                     if(var11 || !var12.f()) {
                        break label88;
                     }

                     var13 = var12.a();
                     var10000 = var13.d();
                     var10001 = var5;
                  }
               }
            }

            var4.g();
         }

         if(var11) {
            break;
         }
      }

   }

   private void a(y.f.b.c var1, y.c.q var2, y.c.y var3) {
      boolean var7 = N.x;
      y.c.y var4 = var1.b(var2);
      y.c.x var5 = var4.a();

      while(var5.f()) {
         y.c.q var6 = var5.e();
         var3.add(var6);
         if(var1.d(var6)) {
            this.a(var1, var6, var3);
         }

         var5.g();
         if(var7) {
            break;
         }
      }

   }

   private void a(y.f.X var1) {
      boolean var6 = N.x;
      y.c.f var2 = new y.c.f(var1.p());
      y.c.e var3 = var2.a();

      while(true) {
         y.c.d var4;
         y.c.q var5;
         if(var3.f()) {
            var4 = var3.a();
            var5 = (y.c.q)this.g.get(var4);
            if(!var6) {
               if(var5 != null) {
                  var1.a(var4, var5, var4.d());
               }

               var3.g();
               if(!var6) {
                  continue;
               }

               var3 = var2.a();
            } else {
               if(var5 != null) {
                  var1.a(var4, var4.c(), var5);
               }

               var3.g();
               if(var6) {
                  return;
               }
            }
         } else {
            var3 = var2.a();
         }

         do {
            if(!var3.f()) {
               return;
            }

            var4 = var3.a();
            var5 = (y.c.q)this.f.get(var4);
            if(var5 != null) {
               var1.a(var4, var4.c(), var5);
            }

            var3.g();
         } while(!var6);

         return;
      }
   }
}
