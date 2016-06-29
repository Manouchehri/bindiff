package y.f.b;

import java.util.HashMap;
import java.util.HashSet;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.x;
import y.c.y;
import y.f.b.d;
import y.f.b.e;
import y.f.b.f;
import y.g.q;

public class c implements f {
   private y.c.i g;
   private A h;
   private e i;
   public static int a;

   public c(y.c.i var1) {
      this.g = var1;
      this.a();
   }

   protected void a() {
      int var10 = a;
      Object var1 = this.g.c(f.b);
      if(var1 == null) {
         var1 = new d(this);
      }

      y.c.c var2 = this.g.c(f.c);
      if(var2 == null) {
         var2 = q.a((Object)null);
      }

      y.c.c var3 = this.g.c(f.d);
      if(var3 == null) {
         var3 = q.a((Object)Boolean.FALSE);
      }

      this.h = this.a(this.g);
      this.i = new e((y.c.q)null, new y());
      HashMap var4 = new HashMap();
      x var5 = this.g.o();

      label62: {
         y.c.q var6;
         Object var10000;
         while(true) {
            if(var5.f()) {
               var6 = var5.e();
               Object var7 = ((y.c.c)var1).b(var6);
               var10000 = var7;
               if(var10 != 0) {
                  break;
               }

               if(var7 == null) {
                  throw new IllegalArgumentException("no id defined for node " + var6);
               }

               var4.put(var7, var6);
               var5.g();
               if(var10 == 0) {
                  continue;
               }

               var5 = this.g.o();
            } else {
               var5 = this.g.o();
            }

            if(!var5.f()) {
               break label62;
            }

            var6 = var5.e();
            var10000 = var4.get(var2.b(var6));
            break;
         }

         while(true) {
            y.c.q var11 = (y.c.q)var10000;
            e var8 = this.i(var6);
            e var9 = this.i(var11);
            this.a(var9, var6);
            var8.a = var11;
            if(var10 != 0) {
               return;
            }

            if(var3.d(var6) && var8.b == null) {
               var8.b = new y();
            }

            var5.g();
            if(var10 != 0 || !var5.f()) {
               break;
            }

            var6 = var5.e();
            var10000 = var4.get(var2.b(var6));
         }
      }

      this.a(this.b(), this.i);
   }

   private void a(y.c.q var1, e var2) {
      int var13 = a;
      if(var2.b != null) {
         HashMap var3 = new HashMap();
         HashMap var4 = new HashMap();
         y.c.f var5 = new y.c.f();
         y.c.f var6 = new y.c.f();
         y.c.p var7 = var2.b.k();

         e var16;
         label168: {
            label167: {
               y.c.q var8;
               e var14;
               Object var10000;
               while(true) {
                  if(var7 != null) {
                     var8 = (y.c.q)var7.c();
                     var10000 = var8.g();
                     if(var13 != 0) {
                        break;
                     }

                     Object var9 = var10000;

                     label150:
                     while(true) {
                        y.c.q var15;
                        y.c.q var10001;
                        if(var9 != null) {
                           var15 = this.a(((y.c.d)var9).c());
                           var10001 = var1;
                           if(var13 == 0) {
                              if(var15 != var1) {
                                 var4.put(var9, var6.b(var9));
                              }

                              var9 = ((y.c.d)var9).h();
                              if(var13 == 0) {
                                 continue;
                              }

                              var9 = var8.f();
                              if(var9 == null) {
                                 break;
                              }

                              var15 = this.a(((y.c.d)var9).d());
                              var10001 = var1;
                           }
                        } else {
                           var9 = var8.f();
                           if(var9 == null) {
                              break;
                           }

                           var15 = this.a(((y.c.d)var9).d());
                           var10001 = var1;
                        }

                        while(true) {
                           while(var13 != 0) {
                              if(var15 != var10001) {
                                 var4.put(var9, var6.b(var9));
                              }

                              var9 = ((y.c.d)var9).h();
                              if(var13 == 0) {
                                 continue label150;
                              }

                              var9 = var8.f();
                              if(var9 == null) {
                                 break label150;
                              }

                              var15 = this.a(((y.c.d)var9).d());
                              var10001 = var1;
                           }

                           if(var15 != var10001) {
                              var3.put(var9, var5.b(var9));
                           }

                           var9 = ((y.c.d)var9).g();
                           if(var13 != 0 || var9 == null) {
                              break label150;
                           }

                           var15 = this.a(((y.c.d)var9).d());
                           var10001 = var1;
                        }
                     }

                     var14 = (e)this.h.b(var8);
                     this.a(var8, var14);
                     var7 = var7.a();
                     if(var13 == 0) {
                        continue;
                     }

                     var7 = var2.b.k();
                  } else {
                     var7 = var2.b.k();
                  }

                  if(var7 == null) {
                     break label167;
                  }

                  var8 = (y.c.q)var7.c();
                  var10000 = this.h.b(var8);
                  break;
               }

               while(true) {
                  var14 = (e)var10000;
                  var16 = var14;
                  if(var13 != 0) {
                     break label168;
                  }

                  y.c.p var17;
                  label90: {
                     if(var14.d != null) {
                        y.c.p var10 = var14.d.k();

                        y.c.d var11;
                        y.c.p var12;
                        label86: {
                           while(var10 != null) {
                              var11 = (y.c.d)var10.c();
                              var12 = (y.c.p)var4.get(var11);
                              var17 = var12;
                              if(var13 != 0) {
                                 break label86;
                              }

                              label82: {
                                 if(var12 != null) {
                                    var6.h(var12);
                                    var4.remove(var11);
                                    if(var13 == 0) {
                                       break label82;
                                    }
                                 }

                                 var3.put(var11, var5.b(var11));
                              }

                              var10 = var10.a();
                              if(var13 != 0) {
                                 break;
                              }
                           }

                           var17 = var14.c.k();
                        }

                        var10 = var17;

                        while(var10 != null) {
                           var11 = (y.c.d)var10.c();
                           var12 = (y.c.p)var3.get(var11);
                           var17 = var12;
                           if(var13 != 0) {
                              break label90;
                           }

                           label68: {
                              if(var12 != null) {
                                 var5.h(var12);
                                 var3.remove(var11);
                                 if(var13 == 0) {
                                    break label68;
                                 }
                              }

                              var4.put(var11, var6.b(var11));
                           }

                           var10 = var10.a();
                           if(var13 != 0) {
                              break;
                           }
                        }
                     }

                     var17 = var7.a();
                  }

                  var7 = var17;
                  if(var13 != 0 || var7 == null) {
                     break;
                  }

                  var8 = (y.c.q)var7.c();
                  var10000 = this.h.b(var8);
               }
            }

            var2.c = var6;
            var16 = var2;
         }

         var16.d = var5;
      }
   }

   private void a(e var1, y.c.q var2) {
      if(var1.b == null) {
         var1.b = new y();
      }

      var1.b.add(var2);
   }

   private e i(y.c.q var1) {
      if(var1 == null) {
         return this.i;
      } else {
         e var2 = (e)this.h.b(var1);
         if(var2 == null) {
            var2 = new e((y.c.q)null, (y)null);
            this.h.a(var1, var2);
         }

         return var2;
      }
   }

   protected A a(y.c.i var1) {
      return var1.t();
   }

   protected void a(y.c.i var1, A var2) {
      if(var1 != null && var2 != null) {
         var1.a(var2);
      }

   }

   public y.c.q a(y.c.q var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("node is root!");
      } else {
         return ((e)this.h.b(var1)).a;
      }
   }

   public y.c.q b() {
      return null;
   }

   public y b(y.c.q var1) {
      return var1 == null?this.i.b:((e)this.h.b(var1)).b;
   }

   public y c(y.c.q var1) {
      y var2 = new y();
      this.a(var1, var2);
      return var2;
   }

   private void a(y.c.q var1, y var2) {
      int var6 = a;
      e var3 = var1 == null?this.i:(e)this.h.b(var1);
      y.c.p var4 = var3.b.k();

      while(var4 != null) {
         y.c.q var5 = (y.c.q)var4.c();
         var2.add(var5);
         if(this.d(var5)) {
            this.a(var5, var2);
         }

         var4 = var4.a();
         if(var6 != 0) {
            break;
         }
      }

   }

   public boolean d(y.c.q var1) {
      return var1 == null || ((e)this.h.b(var1)).b != null;
   }

   public boolean e(y.c.q var1) {
      return this.d(var1) && !this.b(var1).isEmpty();
   }

   public boolean a(y.c.d var1) {
      return this.a(var1.c()) == this.a(var1.d());
   }

   public y.c.f f(y.c.q var1) {
      return this.i(var1).c;
   }

   public y.c.f g(y.c.q var1) {
      return this.i(var1).d;
   }

   public y.c.q a(y.c.q var1, y.c.q var2) {
      int var4 = a;
      if(var1 == null) {
         throw new IllegalArgumentException("no representative for virtual root!");
      } else {
         y.c.q var3 = this.a(var1);

         y.c.q var10000;
         while(true) {
            if(var3 != var2) {
               var10000 = var3;
               if(var4 != 0) {
                  break;
               }

               if(var3 != null) {
                  var1 = var3;
                  var3 = this.a(var3);
                  if(var4 == 0) {
                     continue;
                  }
               }
            }

            var10000 = var3;
            break;
         }

         return var10000 == null && var2 != null?null:var1;
      }
   }

   public void c() {
      this.a(this.g, this.h);
      this.g = null;
      this.h = null;
      this.i = null;
   }

   public static boolean b(y.c.i var0) {
      return var0.c(f.d) != null && var0.c(f.b) != null && var0.c(f.c) != null;
   }

   public static boolean c(y.c.i var0) {
      int var5 = a;
      if(!b(var0)) {
         return true;
      } else {
         y.c.c var1 = var0.c(f.b);
         y.c.c var2 = var0.c(f.c);
         HashSet var3 = new HashSet();
         x var4 = var0.o();

         boolean var10000;
         while(true) {
            if(var4.f()) {
               var3.add(var2.b(var4.e()));
               var10000 = var3.contains(var1.b(var4.e()));
               if(var5 != 0) {
                  break;
               }

               if(var10000) {
                  return false;
               }

               var4.g();
               if(var5 == 0) {
                  continue;
               }
            }

            var4 = var0.o();
            var10000 = var4.f();
            break;
         }

         while(var10000) {
            var10000 = var3.contains(var1.b(var4.e()));
            if(var5 != 0) {
               return var10000;
            }

            if(var10000) {
               return false;
            }

            var4.g();
            if(var5 != 0) {
               break;
            }

            var10000 = var4.f();
         }

         var10000 = true;
         return var10000;
      }
   }

   D h(y.c.q var1) {
      int var4 = a;
      D var2 = new D();
      y.c.q var3 = this.a(var1);

      D var10000;
      while(true) {
         if(var3 != null) {
            var10000 = var2;
            if(var4 != 0) {
               break;
            }

            var2.add(var3);
            var3 = this.a(var3);
            if(var4 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   public y.c.q b(y.c.q var1, y.c.q var2) {
      int var9 = a;
      if(var1 == var2) {
         return this.a(var1);
      } else if(var1 != null && var2 != null) {
         int[] var3 = new int[var1.e().e()];
         D var4 = this.h(var1);
         D var5 = this.h(var2);
         ++var3[var1.d()];
         C var6 = var4.m();

         boolean var10000;
         Object var7;
         y.c.q var8;
         while(true) {
            if(var6.f()) {
               var7 = var6.d();
               var8 = null;
               var10000 = var7 instanceof y.c.q;
               if(var9 != 0) {
                  break;
               }

               if(var10000) {
                  var8 = (y.c.q)var7;
               }

               if(var8 != null) {
                  ++var3[var8.d()];
               }

               var6.g();
               if(var9 == 0) {
                  continue;
               }
            }

            var6 = var5.m();
            var10000 = var6.f();
            break;
         }

         while(var10000) {
            var7 = var6.d();
            var8 = null;
            if(var7 instanceof y.c.q) {
               var8 = (y.c.q)var7;
            }

            if(var8 != null && var3[var8.d()] > 0) {
               return var8;
            }

            var6.g();
            if(var9 != 0) {
               break;
            }

            var10000 = var6.f();
         }

         return this.b();
      } else {
         return null;
      }
   }
}
