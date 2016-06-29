package y.f.c.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.as;
import y.f.c.a.bK;
import y.f.c.a.da;
import y.f.c.a.dg;

class dd extends dg {
   y.f.X a;
   aV b;
   y.c.A c;
   ArrayList d;
   boolean e;

   dd(E var1, y.f.X var2, aV var3) {
      boolean var18 = N.x;
      super(var1, (y.c.q)null);
      this.e = true;
      this.a = var2;
      this.b = var3;
      this.d = new ArrayList();
      y.c.c var4 = var2.c(y.f.b.f.d);
      y.c.c var5 = var2.c(y.f.b.f.b);
      y.c.c var6 = var2.c(y.f.b.f.c);
      if(var4 != null && var5 != null && var6 != null) {
         this.c = y.g.M.a();
         y.f.b.c var7 = new y.f.b.c(var2);
         HashMap var8 = new HashMap();
         this.d.add(this);
         this.c.a((Object)null, this);
         y.c.x var9 = var2.o();

         while(var9.f()) {
            label59: {
               y.c.q var10 = var9.e();
               Object var11 = var5.b(var10);
               if(var7.d(var10) && !var7.b(var10).isEmpty()) {
                  dg var12 = new dg(var1, var10);
                  var8.put(var11, var12);
                  this.d.add(var12);
                  this.c.a(var10, var12);
                  if(!var18) {
                     break label59;
                  }
               }

               var8.put(var11, var10);
            }

            var9.g();
            if(var18) {
               break;
            }
         }

         var9 = null;
         y.c.x var19 = var2.o();

         y.c.q var20;
         Object var21;
         while(var19.f()) {
            var20 = var19.e();
            var21 = var6.b(var20);
            if(!var8.containsKey(var21)) {
               break;
            }

            var19.g();
         }

         var19 = var2.o();

         while(true) {
            if(var19.f()) {
               var20 = var19.e();
               var21 = var5.b(var20);
               Object var13 = var6.b(var20);
               Object var14 = var8.get(var21);
               Object var15 = var8.get(var13);
               if(var18) {
                  break;
               }

               dg var16 = (dg)(var15 == null?this:var15);
               as var17 = (as)var3.a(var20);
               var17.a(var16.f);
               this.a(var14, var16);
               var19.g();
               if(!var18) {
                  continue;
               }
            }

            if(this.d.size() <= 1) {
               this.e = false;
            }

            var7.c();
            break;
         }

      } else {
         this.e = false;
      }
   }

   void a(aU var1, aP var2) {
      boolean var6 = N.x;
      int var3 = 0;

      while(var3 < var1.b()) {
         aQ var4 = var1.a(var3);
         y.c.y var5 = var4.d();
         this.a(var4, var5.k(), var2, this);
         ++var3;
         if(var6) {
            break;
         }
      }

   }

   void a(aU var1, y.c.A var2) {
      boolean var10 = N.x;
      Iterator var3 = this.d.iterator();

      while(var3.hasNext()) {
         dg var4 = (dg)var3.next();
         var4.g = null;
         var4.h = null;
         var4.A = null;
         var4.B = null;
         if(var10) {
            break;
         }
      }

      int var11 = 0;

      while(true) {
         if(var11 < var1.b()) {
            aQ var12 = var1.a(var11);
            y.c.y var5 = var12.d();
            if(var10) {
               break;
            }

            y.c.p var6 = var5.k();

            label60: {
               while(var6 != null) {
                  y.c.q var7 = (y.c.q)var6.c();
                  if(var10) {
                     break label60;
                  }

                  if(var2 == null || !var2.d(var7)) {
                     dg var8 = this.a((Object)var7);
                     if(var8 == null) {
                        aX var9 = this.b.a(var7);
                        var8 = this.C.f(var9.l());
                     }

                     if(var8.g == null) {
                        var8.g = var12;
                     }

                     if(var8.A == null && var12.e() != 2 && var12.e() != 3) {
                        var8.A = var12;
                     }

                     if(var12.e() != 2 && var12.e() != 3) {
                        var8.B = var12;
                     }

                     var8.h = var12;
                  }

                  var6 = var6.a();
                  if(var10) {
                     break;
                  }
               }

               ++var11;
            }

            if(!var10) {
               continue;
            }
         }

         this.d();
         break;
      }

   }

   void a(aV var1) {
      boolean var15 = N.x;
      y.c.A var2 = y.g.M.a(new boolean[this.a.e()]);
      y.c.x var3 = this.a.o();

      byte var10000;
      label121: {
         dd var21;
         label120:
         while(true) {
            if(var3.f()) {
               y.c.q var4 = var3.e();
               as var5 = (as)var1.a(var4);
               var10000 = var5.b();
               if(var15) {
                  break label121;
               }

               if(var10000 == 1) {
                  y.c.d var6 = var5.g();
                  if(!var2.d(var4) && var4.g().c() == var6.c()) {
                     var2.a(var4, true);

                     label114:
                     do {
                        int var20 = var5.b();
                        int var10001 = 1;

                        label111:
                        while(true) {
                           y.c.D var10;
                           int var12;
                           y.c.p var13;
                           dg var14;
                           label103:
                           while(true) {
                              if(var20 != var10001) {
                                 break label114;
                              }

                              y.c.q var7 = var6.c();
                              y.c.q var8 = var6.d();
                              y.c.D var9 = this.a(var7);
                              var10 = this.a(var8);
                              var21 = this;
                              if(var15) {
                                 break label120;
                              }

                              Object var11 = this;

                              label89: {
                                 while(!var9.isEmpty()) {
                                    var20 = var10.isEmpty();
                                    if(var15) {
                                       break label89;
                                    }

                                    if(var20 != 0 || var9.i() != var10.i()) {
                                       break;
                                    }

                                    var11 = (dg)var9.j();
                                    var10.j();
                                    if(var15) {
                                       break;
                                    }
                                 }

                                 var5.a(((dg)var11).f);
                                 var20 = var5.j();
                              }

                              var12 = var20;
                              var13 = var9.k();

                              while(true) {
                                 if(var13 == null) {
                                    break label103;
                                 }

                                 var14 = (dg)var13.c();
                                 var20 = var14.h.c();
                                 var10001 = var12;
                                 if(var15) {
                                    break;
                                 }

                                 if(var20 >= var12) {
                                    var5.a(var14.f);
                                    if(!var15) {
                                       break label103;
                                    }
                                 }

                                 var13 = var13.a();
                                 if(var15) {
                                    break label103;
                                 }
                              }
                           }

                           var13 = var10.k();

                           while(true) {
                              if(var13 == null) {
                                 break label111;
                              }

                              var14 = (dg)var13.c();
                              var20 = var14.g.c();
                              var10001 = var12;
                              if(var15) {
                                 break;
                              }

                              if(var20 <= var12) {
                                 var5.a(var14.f);
                                 if(!var15) {
                                    break label111;
                                 }
                              }

                              var13 = var13.a();
                              if(var15) {
                                 break label111;
                              }
                           }
                        }

                        var4 = var4.f().d();
                        var5 = (as)var1.a(var4);
                     } while(!var15);
                  }
               }

               var3.g();
               if(!var15) {
                  continue;
               }
            }

            var21 = this;
            break;
         }

         var10000 = var21.C.a();
      }

      byte var16 = var10000;
      y.c.x var17 = this.a.o();

      while(var17.f()) {
         y.c.q var18 = var17.e();
         aX var19 = var1.a(var18);
         if(var19.b() == 1) {
            this.a((Object)var18).b((Object)var18);
            if(var16 != 0) {
               this.a(var19.l(), (as)var19);
            }
         }

         var17.g();
         if(var15) {
            break;
         }
      }

   }

   void a(y.c.q var1, as var2) {
      bK var3 = var2.h();
      bK var4 = this.C.a(var1);
      bK var5 = this.C.b(var1);
      if(var3 != null) {
         int var6 = var3.j();
         if(var4 != null && var4.j() > var6) {
            var2.a(var4);
         }

         if(var5 != null && var5.j() < var6) {
            var2.a(var5);
         }
      }

   }

   y.c.D a(y.c.q var1) {
      boolean var4 = N.x;
      y.c.D var2 = new y.c.D();
      dg var3 = this.a((Object)var1);

      y.c.D var10000;
      while(true) {
         if(var3 != null) {
            var10000 = var2;
            if(var4) {
               break;
            }

            var2.add(var3);
            var3 = this.a((Object)var3);
            if(!var4) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   void a(y.c.q var1, dg var2) {
      ((as)this.b.a(var1)).a(var2.f);
   }

   dg a(Object var1) {
      if(var1 instanceof dg) {
         var1 = ((dg)var1).f;
         if(var1 == null) {
            return null;
         }
      }

      if(var1 instanceof y.c.q) {
         y.c.q var2 = this.b.a((y.c.q)var1).l();
         dg var3 = this.C.f(var2);
         if(var3 != null) {
            return (dg)var3;
         }
      }

      throw new IllegalStateException("Item has no parent");
   }

   void a(Object var1, dg var2) {
      var2.b(var1);
   }

   public boolean a() {
      return this.e;
   }

   boolean a(y.c.d var1, aV var2) {
      y.c.q var3 = var1.c();
      y.c.q var4 = var1.d();
      aX var5 = var2.a(var3);
      aX var6 = var2.a(var4);
      dg var7 = null;
      y.c.q var8;
      aX var9;
      dg var10;
      y.c.q var11;
      if(var6.b() == 9) {
         var8 = var6.f();
         var9 = var2.a(var8);
         if(var9.b() == 15) {
            var10 = this.a((Object)var8);
            var11 = var3;
            if(var5.b() == 8) {
               var11 = var5.f();
            }

            if(this.C.a(var11, var10.f)) {
               var7 = this.a((Object)var10);
            }
         }
      }

      if(var7 == null && var5.b() == 8) {
         var8 = var5.f();
         var9 = var2.a(var8);
         if(var9.b() == 15) {
            var10 = this.a((Object)var8);
            var11 = var4;
            if(var6.b() == 9) {
               var11 = var6.f();
            }

            if(this.C.a(var11, var10.f)) {
               var7 = this.a((Object)var10);
            }
         }
      }

      if(var7 != null) {
         if(var6.b() == 9) {
            this.a(var4, var7);
            var7.b((Object)var4);
            this.a(var7.f, (as)var6);
         }

         if(var5.b() == 8) {
            this.a(var3, var7);
            var7.b((Object)var3);
            this.a(var7.f, (as)var5);
         }

         return true;
      } else {
         return false;
      }
   }

   public void a(aU var1, aV var2) {
      boolean var15 = N.x;
      y.c.e var3 = this.a.p();

      while(var3.f()) {
         y.c.d var4 = var3.a();
         if(!this.a(var4, var2)) {
            label90: {
               y.c.q var5 = var4.c();
               y.c.q var6 = var4.d();
               aX var7 = var2.a(var5);
               aX var8 = var2.a(var6);
               int var10000 = var8.b();
               int var10001 = 9;

               dg var11;
               label79:
               while(true) {
                  label67:
                  while(var10000 == var10001) {
                     y.c.q var9 = var8.f();
                     aX var10 = var2.a(var9);
                     var11 = this.a((Object)this.a((Object)var9));
                     if(var10.b() == 15 && var7.b() == 8 && var7.j() >= var11.g.c() && var7.j() <= var11.h.c()) {
                        this.a(var6, var11);
                        this.a(var5, var11);
                        var11.b((Object)var6);
                        this.a(var11.f, (as)var7);
                        var11.b((Object)var5);
                        this.a(var11.f, (as)var8);
                        if(!var15) {
                           break label90;
                        }
                     }

                     dg var12 = null;
                     if(var7.b() == 8) {
                        y.c.q var13 = var7.f();
                        aX var14 = var2.a(var13);
                        if(var14.b() == 15) {
                           var12 = this.a((Object)this.a((Object)var13));
                        } else {
                           var12 = this.a((Object)var7.f());
                        }

                        this.a(var5, var12);
                        var12.b((Object)var5);
                        this.a(var12.f, (as)var7);
                     } else {
                        var12 = this.a((Object)var5);
                     }

                     int var18 = var8.j();
                     dg var19 = var12;

                     while(var19 != this) {
                        var10000 = var19.h.c();
                        var10001 = var18;
                        if(var15) {
                           continue label67;
                        }

                        if(var10000 >= var18) {
                           break;
                        }

                        var19 = this.a((Object)var19);
                        if(var15) {
                           break;
                        }
                     }

                     this.a(var6, var19);
                     var19.b((Object)var6);
                     this.a(var19.f, (as)var8);
                     if(!var15) {
                        break label90;
                     }
                     break;
                  }

                  if(var7.b() != 8) {
                     break label90;
                  }

                  dg var16 = this.a((Object)var6);
                  int var17 = var7.j();
                  var11 = var16;

                  while(true) {
                     if(var11 == this) {
                        break label79;
                     }

                     var10000 = var11.g.c();
                     var10001 = var17;
                     if(var15) {
                        break;
                     }

                     if(var10000 <= var17) {
                        break label79;
                     }

                     var11 = this.a((Object)var11);
                     if(var15) {
                        break label79;
                     }
                  }
               }

               this.a(var5, var11);
               var11.b((Object)var5);
               this.a(var11.f, (as)var7);
            }
         }

         var3.g();
         if(var15) {
            break;
         }
      }

   }

   public void b(aU var1, aV var2) {
      boolean var11 = N.x;
      y.c.x var3 = this.a.o();

      while(var3.f()) {
         y.c.q var4 = var3.e();
         aX var5 = var2.a(var4);
         if(var5.b() == 10) {
            dg var10;
            label51: {
               y.c.q var6 = var4.g().c();
               aX var7 = var2.a(var6);
               y.c.q var8 = var4.f().d();
               aX var9 = var2.a(var8);
               var10 = this.a((Object)var6);
               if(var7.b() == 15 && var9.b() == 15) {
                  if(this.C.a(var7.l(), var9.l())) {
                     var10 = this.a((Object)var9.l());
                     if(!var11) {
                        break label51;
                     }
                  }

                  if(this.C.a(var9.l(), var7.l())) {
                     var10 = this.a((Object)var7.l());
                     if(!var11) {
                        break label51;
                     }
                  }

                  if(var9.l() != var7.l()) {
                     break label51;
                  }

                  var10 = this.a((Object)var7.l());
                  if(!var11) {
                     break label51;
                  }
               }

               if(var7.b() == 15) {
                  var10 = this.a((Object)var7.l());
                  if(!var11) {
                     break label51;
                  }
               }

               if(var9.b() == 15) {
                  var10 = this.a((Object)var9.l());
               }
            }

            this.a(var4, var10);
            var10.b((Object)var4);
            this.a(var10.f, (as)var5);
         }

         var3.g();
         if(var11) {
            break;
         }
      }

   }

   public void c(aU var1, aV var2) {
      boolean var7 = N.x;
      int var3 = 0;

      do {
         int var10000 = var3;

         label29:
         while(true) {
            if(var10000 >= var1.b()) {
               return;
            }

            da var4 = this.b(var3);
            y.c.p var5 = var4.k();

            while(true) {
               if(var5 == null) {
                  break label29;
               }

               var10000 = var5.c() instanceof dg;
               if(var7) {
                  break;
               }

               if(var10000 != 0) {
                  dg var6 = (dg)var5.c();
                  var6.a(var1, var3, var2);
               }

               var5 = var5.a();
               if(var7) {
                  break label29;
               }
            }
         }

         ++var3;
      } while(!var7);

   }

   private dg a(int var1, y.c.q var2, boolean var3) {
      boolean var21 = N.x;
      int var4 = !var3?1:0;
      int var5 = var3?1:0;
      HashMap var6 = new HashMap();
      HashSet var7 = new HashSet();
      y.c.y var8 = this.a(var2, true);
      HashMap var9 = new HashMap();
      y.c.D var10 = new y.c.D();
      Object var11 = var8.a();

      int var10000;
      dg var31;
      label216:
      while(true) {
         var10000 = ((y.c.x)var11).f();

         label213:
         while(true) {
            if(var10000 != 0) {
               label243: {
                  y.c.q var12 = ((y.c.x)var11).e();
                  dg var13 = this.a((Object)var12);
                  var31 = var13;
                  if(var21) {
                     break;
                  }

                  if(var13 != null) {
                     label238: {
                        if(var9.containsKey(var13)) {
                           int var14 = ((Integer)var9.get(var13)).intValue();
                           var9.put(var13, new Integer(var14 + 1));
                           if(!var21) {
                              break label238;
                           }
                        }

                        var9.put(var13, new Integer(1));
                     }
                  }

                  y.c.D var27 = this.a(var12);
                  int var15 = var27.size();
                  y.c.p var16 = var27.k();

                  while(var16 != null) {
                     dg var17 = (dg)var16.c();
                     var10000 = var17.h.c() + var5;
                     if(var21) {
                        continue label213;
                     }

                     if(var10000 >= var1 && var17.g.c() - var4 <= var1 && !var7.contains(var17)) {
                        var10.add(var17);
                        var7.add(var17);
                        var6.put(var17, new Integer(var15));
                     }

                     --var15;
                     var16 = var16.a();
                     if(var21) {
                        ((y.c.x)var11).g();
                        if(!var21) {
                           continue label216;
                        }
                        break label243;
                     }
                  }

                  ((y.c.x)var11).g();
                  if(!var21) {
                     continue label216;
                  }
               }
            }

            if(!var3) {
               break label216;
            }

            var11 = var10.m();
            if(!((y.c.C)var11).f()) {
               break label216;
            }

            var31 = (dg)((y.c.C)var11).d();
            break;
         }

         while(true) {
            dg var23 = var31;
            if(var9.containsKey(var23)) {
               int var25 = ((Integer)var9.get(var23)).intValue();
               if(var25 == var8.size()) {
                  return var23;
               }
            }

            ((y.c.C)var11).g();
            if(var21 || !((y.c.C)var11).f()) {
               break label216;
            }

            var31 = (dg)((y.c.C)var11).d();
         }
      }

      y.c.y var22 = this.a(var2, false);
      y.c.D var24 = new y.c.D();
      y.c.y var26 = new y.c.y();
      var7.clear();
      var9.clear();
      Object var28 = var22.a();

      dg var30;
      int var33;
      boolean var38;
      label166:
      while(true) {
         var10000 = ((y.c.x)var28).f();

         label163: {
            label162:
            while(true) {
               if(var10000 != 0) {
                  label244: {
                     y.c.q var29 = ((y.c.x)var28).e();
                     dg var32 = this.a((Object)var29);
                     var31 = var32;
                     if(var21) {
                        break;
                     }

                     if(var32 != null) {
                        label239: {
                           if(var9.containsKey(var32)) {
                              int var34 = ((Integer)var9.get(var32)).intValue();
                              var9.put(var32, new Integer(var34 + 1));
                              if(!var21) {
                                 break label239;
                              }
                           }

                           var9.put(var32, new Integer(1));
                        }
                     }

                     y.c.D var35 = this.a(var29);
                     int var18 = var35.size();
                     y.c.p var19 = var35.k();

                     while(var19 != null) {
                        dg var20 = (dg)var19.c();
                        var10000 = var20.h.c() + var5;
                        if(var21) {
                           continue label162;
                        }

                        if(var10000 >= var1 && var20.g.c() - var4 <= var1) {
                           if(!var7.contains(var20)) {
                              label231: {
                                 var24.add(var20);
                                 var7.add(var20);
                                 if(var6.containsKey(var20)) {
                                    var26.add(var20);
                                    if(!var21) {
                                       --var18;
                                       break label231;
                                    }
                                 }

                                 var10.add(var20);
                                 var6.put(var20, new Integer(var18));
                                 --var18;
                              }
                           } else {
                              --var18;
                           }
                        }

                        var19 = var19.a();
                        if(var21) {
                           ((y.c.x)var28).g();
                           if(!var21) {
                              continue label166;
                           }
                           break label244;
                        }
                     }

                     ((y.c.x)var28).g();
                     if(!var21) {
                        continue label166;
                     }
                  }
               }

               if(var3) {
                  break label163;
               }

               var28 = var24.m();
               if(!((y.c.C)var28).f()) {
                  break label163;
               }

               var31 = (dg)((y.c.C)var28).d();
               break;
            }

            while(true) {
               var30 = var31;
               var38 = var9.containsKey(var30);
               if(var21) {
                  break label166;
               }

               if(var38) {
                  var33 = ((Integer)var9.get(var30)).intValue();
                  if(var33 == var22.size()) {
                     return var30;
                  }
               }

               ((y.c.C)var28).g();
               if(var21 || !((y.c.C)var28).f()) {
                  break;
               }

               var31 = (dg)((y.c.C)var28).d();
            }
         }

         var38 = var26.isEmpty();
         break;
      }

      var28 = var38?var10:var26;
      if(((y.c.D)var28).isEmpty()) {
         return null;
      } else {
         var30 = (dg)((y.c.D)var28).f();
         var33 = ((Integer)var6.get(var30)).intValue();
         y.c.C var36 = ((y.c.D)var28).m();

         while(true) {
            if(var36.f()) {
               var31 = (dg)var36.d();
               if(var21) {
                  break;
               }

               dg var37 = var31;
               int var39 = ((Integer)var6.get(var37)).intValue();
               if(var33 < var39) {
                  var30 = var37;
                  var33 = var39;
               }

               var36.g();
               if(!var21) {
                  continue;
               }
            }

            var31 = var30;
            break;
         }

         return var31;
      }
   }

   private y.c.y a(y.c.q var1, boolean var2) {
      y.c.y var3;
      y.c.y var4;
      boolean var7;
      label37: {
         var7 = N.x;
         var3 = new y.c.y();
         var4 = new y.c.y();
         if(var2) {
            var4.a(var1.n());
            if(!var7) {
               break label37;
            }
         }

         var4.a(var1.o());
      }

      y.c.y var10000;
      while(true) {
         if(!var4.isEmpty()) {
            var10000 = var4;
            if(var7) {
               break;
            }

            y.c.q var5 = var4.d();
            aX var6 = this.b.a(var5);
            if(var6.b() == 6 || var6.b() == 7) {
               if(var2) {
                  var4.a(var5.o());
                  if(!var7) {
                     continue;
                  }
               }

               var4.a(var5.o());
               if(!var7) {
                  continue;
               }
            }

            var3.add(var5);
            if(!var7) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   void a(aU var1) {
      boolean var8 = N.x;
      int var2 = 0;

      do {
         int var10000 = var2;
         int var10001 = var1.b();

         label35:
         while(true) {
            if(var10000 >= var10001) {
               return;
            }

            aQ var3 = var1.a(var2);
            y.c.p var4 = var3.d().k();

            while(true) {
               if(var4 == null) {
                  break label35;
               }

               y.c.q var5 = (y.c.q)var4.c();
               aX var6 = this.b.a(var5);
               var10000 = var6.b();
               var10001 = 6;
               if(var8) {
                  break;
               }

               label30: {
                  dg var7;
                  if(var10000 == 6) {
                     var7 = this.a(var2, var5, true);
                     ((as)var6).a(var7.f);
                     this.a((Object)var5, (dg)var7);
                     this.a(var7.f, (as)var6);
                     if(!var8) {
                        break label30;
                     }
                  }

                  if(var6.b() == 7) {
                     var7 = this.a(var2, var5, false);
                     ((as)var6).a(var7.f);
                     this.a((Object)var5, (dg)var7);
                     this.a(var7.f, (as)var6);
                  }
               }

               var4 = var4.a();
               if(var8) {
                  break label35;
               }
            }
         }

         ++var2;
      } while(!var8);

   }

   public void d(aU var1, aV var2) {
      boolean var11 = N.x;
      int var3 = 0;

      while(true) {
         if(var3 < this.d.size()) {
            dg var4 = (dg)this.d.get(var3);
            var4.e();
            ++var3;
            if(var11) {
               break;
            }

            if(!var11) {
               continue;
            }
         }

         var3 = 0;
         break;
      }

      do {
         int var10000 = var3;
         int var10001 = var1.b();

         label33:
         while(true) {
            if(var10000 >= var10001) {
               return;
            }

            aQ var12 = var1.a(var3);
            y.c.p var5 = var12.d().k();

            while(true) {
               if(var5 == null) {
                  break label33;
               }

               y.c.q var6 = (y.c.q)var5.c();
               dg var7 = this.a((Object)var6);
               da var8 = var7.b(var3);
               var8.add(var6);
               aX var9 = var2.a(var6);
               var10000 = var9.b();
               var10001 = 12;
               if(var11) {
                  break;
               }

               if(var10000 == 12) {
                  dg var10 = this.a((Object)var7);
                  var10.b(var3).add(var7);
               }

               var5 = var5.a();
               if(var11) {
                  break label33;
               }
            }
         }

         ++var3;
      } while(!var11);

   }
}
