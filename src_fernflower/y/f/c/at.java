package y.f.c;

import java.util.HashMap;
import java.util.Map;
import y.f.c.Q;
import y.f.c.a;
import y.f.c.au;
import y.f.c.av;
import y.f.c.h;

class at {
   private Map a = new HashMap();
   private av b;
   private Q c;
   private au d = new au();

   public at(Q var1) {
      this.c = var1;
   }

   public void a(Object var1, y.f.X var2, y.c.A var3, int var4, y.c.y var5, y.c.y var6, y.c.c var7, y.c.c var8, y.c.c var9, y.c.c var10, y.c.c var11, y.c.c var12) {
      boolean var27 = a.i;
      y.f.w var13 = new y.f.w();
      y.c.A var14 = var13.t();
      y.c.h var15 = var13.u();
      HashMap var16 = new HashMap();
      HashMap var17 = new HashMap();
      y.c.A var18 = null;
      if(var9 != null) {
         var18 = var13.t();
         var13.a((Object)y.f.aF.a, (y.c.c)var18);
      }

      y.c.A var19 = null;
      if(var10 != null) {
         var19 = var13.t();
         var13.a((Object)y.f.aF.b, (y.c.c)var19);
      }

      var13.a((Object)y.f.ah.f_, (y.c.c)var14);
      var13.a((Object)y.f.ah.k, (y.c.c)var15);
      y.c.x var20 = var2.o();

      Object var10000;
      y.c.q var22;
      while(true) {
         if(var20.f()) {
            y.c.q var21 = var20.e();
            var22 = var13.d();
            Object var23;
            var14.a(var22, var23 = var7.b(var21));
            var16.put(var23, var22);
            var10000 = var13;
            if(var27) {
               break;
            }

            var13.a(var22, var2.a((Object)var21));
            var20.g();
            if(!var27) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      y.c.e var29 = ((y.f.X)var10000).p();

      Object var26;
      while(var29.f()) {
         y.c.d var31 = var29.a();
         var22 = (y.c.q)var16.get(var7.b(var31.c()));
         y.c.q var34 = (y.c.q)var16.get(var7.b(var31.d()));
         y.c.d var24 = var13.a((y.c.q)var22, (y.c.q)var34);
         var13.a(var24, var2.b(var31));
         Object var25;
         var15.a(var24, var25 = var8.b(var31));
         var17.put(var25, var24);
         if(var9 != null) {
            var26 = var9.b(var31);
            if(var26 != null) {
               var18.a(var24, var26);
            }
         }

         if(var10 != null) {
            var26 = var10.b(var31);
            if(var26 != null) {
               var19.a(var24, var26);
            }
         }

         var29.g();
         if(var27) {
            break;
         }
      }

      y.c.q[] var30 = new y.c.q[var5.size()];
      int var32 = 0;
      y.c.p var33 = var5.k();

      y.c.q[] var28;
      while(true) {
         if(var33 != null) {
            var28 = var30;
            if(var27) {
               break;
            }

            var30[var32] = (y.c.q)var16.get(var7.b(var33.c()));
            var33 = var33.a();
            ++var32;
            if(!var27) {
               continue;
            }
         }

         var28 = new y.c.q[var6.size()];
         break;
      }

      y.c.q[] var35 = var28;
      var32 = 0;
      y.c.p var36 = var6.k();

      while(var36 != null) {
         var35[var32] = (y.c.q)var16.get(var7.b(var36.c()));
         var36 = var36.a();
         ++var32;
         if(var27) {
            break;
         }
      }

      y.c.A var37 = var13.t();
      y.c.x var38 = var2.o();

      while(var38.f()) {
         y.c.q var40 = var38.e();
         var26 = var7.b(var40);
         var37.a(var16.get(var26), var3.b(var40));
         var38.g();
         if(var27) {
            break;
         }
      }

      av var39 = new av(this.c, var1, var13, var37, var4, var30, var35, var16, var17);
      this.a.put(var1, var39);
   }

   public void a(Object var1) {
      boolean var8 = a.i;
      av var2 = (av)this.a.get(var1);
      if(this.b == null) {
         this.b = var2;
      }

      y.c.c var3 = var2.b.c(y.f.ah.f_);
      y.c.x var4 = var2.b.o();

      while(true) {
         if(var4.f()) {
            y.c.q var5 = var4.e();
            Object var6 = var3.b(var5);
            av var7 = (av)this.a.get(var6);
            if(var8) {
               break;
            }

            if(var7 != null) {
               this.b(var2, var7);
            }

            var4.g();
            if(!var8) {
               continue;
            }
         }

         this.a(this.b);
         break;
      }

   }

   private void b(av param1, av param2) {
      // $FF: Couldn't be decompiled
   }

   private void a(av var1) {
      boolean var9 = a.i;
      y.c.c var2 = var1.b.c(y.f.ah.f_);
      var1.k = new y.c.D[var1.c.d.length];
      int var3 = 0;

      while(var3 < var1.c.d.length) {
         av var10000 = var1;

         label33:
         while(true) {
            y.c.y var4 = var10000.c.d[var3];
            y.c.p var5 = var4.k();

            while(true) {
               if(var5 == null) {
                  break label33;
               }

               y.c.q var6 = (y.c.q)var5.c();
               Object var7 = var2.b(var6);
               av var8 = (av)this.a.get(var7);
               var10000 = var8;
               if(var9) {
                  break;
               }

               if(var8 != null) {
                  if(var1.k[var3] == null) {
                     var1.k[var3] = new y.c.D();
                  }

                  var1.k[var3].add(var8);
               }

               var5 = var5.a();
               if(var9) {
                  break label33;
               }
            }
         }

         ++var3;
         if(var9) {
            break;
         }
      }

   }

   public Map a() {
      boolean var5 = a.i;
      av var1 = this.b;
      int var2 = Integer.MAX_VALUE;
      int var3 = 20;

      while(var3-- > 0 && var2 > 0) {
         var2 = this.c((av)null, var1);
         if(var2 == 0) {
            break;
         }

         var2 = this.a((av)null, (av)var1);
         if(var5) {
            break;
         }
      }

      HashMap var4 = new HashMap();
      this.a(var1, (Map)var4);
      return var4;
   }

   private void a(av var1, Map var2) {
      boolean var7 = a.i;
      y.c.c var3 = var1.b.c(y.f.ah.f_);
      y.c.x var4 = var1.b.o();

      while(var4.f()) {
         Object var5 = var3.b(var4.e());
         var2.put(var5, new Integer(var1.c.a[var4.e().d()]));
         av var6 = (av)this.a.get(var5);
         if(var6 != null) {
            this.a(var6, var2);
         }

         var4.g();
         if(var7) {
            break;
         }
      }

   }

   private int c(av var1, av var2) {
      boolean var12 = a.i;
      h var3 = var1 != null?var1.c:null;
      h var4 = var2.c;
      y.c.c var5 = var2.b.c(y.f.ah.f_);
      int var6 = 0;
      int var10000;
      if(var1 != null) {
         boolean var7;
         int var8;
         y.c.p var9;
         label125: {
            var7 = var2.g != null && var2.g.length > 0;
            if(var7) {
               this.d.a = var1.c.k;
               this.d.c = var4.a;
               this.d.b = var2.e;
               var4.d[0].sort(this.d);
               var8 = 0;
               var9 = var4.d[0].k();

               while(var9 != null) {
                  var4.a[((y.c.q)var9.c()).d()] = var8;
                  var9 = var9.a();
                  ++var8;
                  if(var12) {
                     break label125;
                  }

                  if(var12) {
                     break;
                  }
               }
            }

            var8 = 0;
         }

         label147: {
            while(var8 < var4.d.length) {
               var10000 = var8;
               if(var12) {
                  break label147;
               }

               if(var8 > 0) {
                  var4.a(var8);
               }

               label143: {
                  if(var2.k[var8] != null) {
                     var9 = var2.k[var8].k();

                     while(var9 != null) {
                        var6 += this.c(var2, (av)var9.c());
                        var9 = var9.a();
                        if(var12) {
                           break label143;
                        }

                        if(var12) {
                           break;
                        }
                     }
                  }

                  ++var8;
               }

               if(var12) {
                  break;
               }
            }

            var10000 = var4.a();
         }

         if(var10000 != 0 && var4.d.length - (var7?1:0) > 0) {
            var4.a(var7?1:0, var4.d.length - 1);
         }

         label112: {
            if(var2.h != null && var2.h.length > 0) {
               var8 = 1;
               var9 = var4.d[var4.d.length - 1].k();

               while(var9 != null) {
                  y.c.q var10 = (y.c.q)var9.c();
                  y.c.d var11 = (y.c.d)var2.e.b(var10);
                  if(var12) {
                     break label112;
                  }

                  if(var11 != null) {
                     var3.g[var11.b()] = var8++;
                  }

                  var9 = var9.a();
                  if(var12) {
                     break;
                  }
               }
            }

            var6 += var4.f();
         }

         if(!var12) {
            return var6;
         }
      }

      int var13 = 0;

      label95: {
         while(var13 < var2.f) {
            var10000 = var13;
            if(var12) {
               break label95;
            }

            if(var13 > 0) {
               var4.a(var13);
            }

            label91: {
               if(var2.k[var13] != null) {
                  y.c.p var14 = var2.k[var13].k();

                  while(var14 != null) {
                     var6 += this.c(var2, (av)var14.c());
                     var14 = var14.a();
                     if(var12) {
                        break label91;
                     }

                     if(var12) {
                        break;
                     }
                  }
               }

               ++var13;
            }

            if(var12) {
               break;
            }
         }

         var10000 = var6 + var4.f();
      }

      var6 = var10000;
      return var6;
   }

   public int a(av var1, av var2) {
      boolean var12 = a.i;
      h var3 = var1 != null?var1.c:null;
      h var4 = var2.c;
      y.c.c var5 = var2.b.c(y.f.ah.f_);
      int var6 = 0;
      int var10000;
      int var10001;
      if(var1 != null) {
         boolean var7;
         int var8;
         y.c.p var9;
         label110: {
            var7 = var2.h != null && var2.h.length > 0;
            if(var7) {
               this.d.a = var1.c.j;
               this.d.c = var4.a;
               this.d.b = var2.e;
               var4.d[var4.d.length - 1].sort(this.d);
               var8 = 0;
               var9 = var4.d[var4.d.length - 1].k();

               while(var9 != null) {
                  var4.a[((y.c.q)var9.c()).d()] = var8;
                  var9 = var9.a();
                  ++var8;
                  if(var12) {
                     break label110;
                  }

                  if(var12) {
                     break;
                  }
               }
            }

            var8 = var4.d.length - 1;
         }

         label147: {
            while(true) {
               if(var8 >= 0) {
                  var10000 = var8;
                  var10001 = var4.d.length - 1;
                  if(var12) {
                     break;
                  }

                  if(var8 < var10001) {
                     var4.b(var8);
                  }

                  label141: {
                     if(var2.k[var8] != null) {
                        var9 = var2.k[var8].k();

                        while(var9 != null) {
                           var6 += this.a(var2, (av)var9.c());
                           var9 = var9.a();
                           if(var12) {
                              break label141;
                           }

                           if(var12) {
                              break;
                           }
                        }
                     }

                     --var8;
                  }

                  if(!var12) {
                     continue;
                  }
               }

               if(var4.a() && var4.d.length - (var7?1:0) > 0) {
                  var4.a(var4.d.length - (var7?2:1), 0);
               }

               if(var2.g != null && var2.g.length > 0) {
                  var8 = 1;
                  var9 = var4.d[0].k();

                  while(var9 != null) {
                     y.c.q var10 = (y.c.q)var9.c();
                     y.c.d var11 = (y.c.d)var2.e.b(var10);
                     if(var12) {
                        break label147;
                     }

                     if(var11 != null) {
                        var3.h[var11.b()] = var8++;
                     }

                     var9 = var9.a();
                     if(var12) {
                        break;
                     }
                  }
               }

               var10000 = var6;
               var10001 = var4.f();
               break;
            }

            var6 = var10000 + var10001;
         }

         if(!var12) {
            return var6;
         }
      }

      int var13 = var2.f - 1;

      label95: {
         while(var13 >= 0) {
            var10000 = var13;
            var10001 = var2.f - 1;
            if(var12) {
               break label95;
            }

            if(var13 < var10001) {
               var4.b(var13);
            }

            label91: {
               if(var2.k[var13] != null) {
                  y.c.p var14 = var2.k[var13].k();

                  while(var14 != null) {
                     var6 += this.a(var2, (av)var14.c());
                     var14 = var14.a();
                     if(var12) {
                        break label91;
                     }

                     if(var12) {
                        break;
                     }
                  }
               }

               --var13;
            }

            if(var12) {
               break;
            }
         }

         var10000 = var6;
         var10001 = var4.f();
      }

      var6 = var10000 + var10001;
      return var6;
   }
}
