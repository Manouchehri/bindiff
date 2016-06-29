package y.g;

import java.util.Comparator;
import java.util.Iterator;
import y.g.aj;
import y.g.ak;
import y.g.ar;
import y.g.e;
import y.g.p;

public class ai {
   private final aj a;
   private final aj b;
   private aj c;
   private aj d;
   private int e;
   private Comparator f;
   private int g;
   private ar h;

   public ai(Comparator var1) {
      this.h = new ar(42L);
      this.a = this.c = new aj();
      this.b = this.d = new aj();
      this.a.a = this.b;
      this.b.b = this.a;
      this.f = var1;
      this.g = 0;
      this.e = 1;
   }

   public ai() {
      this(e.a());
   }

   public aj a(Object var1) {
      boolean var10 = p.c;
      int var2 = this.e();
      aj var3 = this.c;

      while(this.a(var1, var3.a) > 0) {
         var3 = var3.a;
         if(var10) {
            break;
         }
      }

      int var4 = this.e;
      aj var5 = null;
      aj var6 = null;

      aj var7;
      label233:
      while(true) {
         if(this.e < var2) {
            var7 = new aj();
            var7.e = var1;
            aj var8 = new aj();
            aj var9 = new aj();
            var8.d = this.c;
            this.c.c = var8;
            this.c = var8;
            var9.d = this.d;
            this.d.c = var9;
            this.d = var9;
            var8.a = var9.b = var7;
            var7.b = var8;
            var7.a = var9;
            if(var10) {
               if(var6 != null) {
                  var7.c = var5;
                  var5.d = var7;
               }

               var5 = var7;
               var3 = var3.d;
               if(var3 == null) {
                  ++this.g;
                  if(y.c.i.g) {
                     p.c = !var10;
                  }

                  return var7;
               }
               break;
            }

            label48: {
               if(var6 != null) {
                  var7.d = var6;
                  var6.c = var7;
                  if(!var10) {
                     break label48;
                  }
               }

               var5 = var7;
            }

            var6 = var7;
            ++this.e;
            if(!var10) {
               continue;
            }
         }

         label231:
         while(true) {
            aj var10000;
            if(var4 > var2) {
               var3 = var3.d;
               --var4;

               while(true) {
                  if(this.a(var1, var3.a) <= 0) {
                     continue label231;
                  }

                  var10000 = var3.a;
                  if(var10) {
                     var7 = var10000;
                     var7.e = var1;
                     var7.b = var3;
                     var7.a = var3.a;
                     var3.a.b = var7;
                     var3.a = var7;
                     if(var5 != null) {
                        var7.c = var5;
                        var5.d = var7;
                     }

                     var5 = var7;
                     var3 = var3.d;
                     if(var3 == null) {
                        ++this.g;
                        if(y.c.i.g) {
                           p.c = !var10;
                        }

                        return var7;
                     }
                     break label233;
                  }

                  var3 = var10000;
                  if(var10) {
                     var10000 = new aj();
                     break;
                  }

                  if(var10) {
                     var10000 = new aj();
                     break;
                  }
               }
            } else {
               var10000 = new aj();
            }

            var7 = var10000;
            var7.e = var1;
            var7.b = var3;
            var7.a = var3.a;
            var3.a.b = var7;
            var3.a = var7;
            if(var5 != null) {
               var7.c = var5;
               var5.d = var7;
            }

            var5 = var7;
            var3 = var3.d;
            if(var3 == null) {
               ++this.g;
               if(y.c.i.g) {
                  p.c = !var10;
               }

               return var7;
            }
            break label233;
         }
      }

      while(true) {
         while(this.a(var1, var3.a) <= 0) {
            var7 = new aj();
            var7.e = var1;
            var7.b = var3;
            var7.a = var3.a;
            var3.a.b = var7;
            var3.a = var7;
            if(var5 != null) {
               var7.c = var5;
               var5.d = var7;
            }

            var5 = var7;
            var3 = var3.d;
            if(var3 == null) {
               ++this.g;
               if(y.c.i.g) {
                  p.c = !var10;
               }

               return var7;
            }
         }

         var3 = var3.a;
         if(!var10) {
            if(var10) {
               if(var5 != null) {
                  var7.c = var5;
                  var5.d = var7;
               }

               var5 = var7;
               var3 = var3.d;
               if(var3 == null) {
                  ++this.g;
                  if(y.c.i.g) {
                     p.c = !var10;
                  }

                  return var7;
               }
            }
         } else if(var3 == null) {
            ++this.g;
            if(y.c.i.g) {
               p.c = !var10;
            }

            return var7;
         }
      }
   }

   private int e() {
      int var1 = 1;
      if(this.h.nextBoolean()) {
         ++var1;
         if(this.h.nextBoolean()) {
            ++var1;
            if(this.h.nextBoolean()) {
               ++var1;
               if(this.h.nextBoolean()) {
                  ++var1;
                  if(this.h.nextBoolean()) {
                     ++var1;
                     if(this.h.nextBoolean()) {
                        ++var1;
                        if(this.h.nextBoolean()) {
                           ++var1;
                           if(this.h.nextBoolean()) {
                              ++var1;
                              if(this.h.nextBoolean()) {
                                 ++var1;
                                 if(this.h.nextBoolean()) {
                                    ++var1;
                                    if(this.h.nextBoolean()) {
                                       ++var1;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var1;
   }

   public void a(aj var1, aj var2) {
      boolean var6 = p.c;
      if(var1 == var2) {
         this.a(var1);
         if(!var6) {
            return;
         }
      }

      aj var3 = var1.b;
      aj var4 = var2.a();
      int var5 = 0;

      label55: {
         while(var5 < this.e) {
            var3.a = var4;
            var4.b = var3;
            if(var6) {
               break label55;
            }

            label77: {
               if(var5 != this.e - 1) {
                  while(true) {
                     if(var3.c == null) {
                        var3 = var3.b;
                        if(var6) {
                           break;
                        }

                        if(!var6) {
                           continue;
                        }
                     }

                     var3 = var3.c;
                     break;
                  }

                  while(true) {
                     if(var4.c == null) {
                        var4 = var4.a;
                        if(var6) {
                           break label77;
                        }

                        if(!var6) {
                           continue;
                        }
                     }

                     var4 = var4.c;
                     break;
                  }
               }

               ++var5;
            }

            if(var6) {
               break;
            }
         }

         this.f();
      }

      while(var1 != var2) {
         var1 = var1.a;
         --this.g;
         if(var6) {
            return;
         }

         if(var6) {
            break;
         }
      }

      --this.g;
   }

   public aj a(aj var1, Object var2) {
      try {
         aj var3;
         if(var1 == null) {
            if(this.g == 0) {
               var3 = this.a(var2);
               return var3;
            } else {
               var3 = this.b(this.b(), var2);
               return var3;
            }
         } else {
            var3 = this.a(var2, var1, var1.a);
            return var3;
         }
      } finally {
         ;
      }
   }

   public aj b(aj var1, Object var2) {
      try {
         aj var3;
         if(var1 == null) {
            if(this.g == 0) {
               var3 = this.a(var2);
               return var3;
            } else {
               var3 = this.a(this.c(), var2);
               return var3;
            }
         } else {
            var3 = this.a(var2, var1.b, var1);
            return var3;
         }
      } finally {
         ;
      }
   }

   private aj a(Object var1, aj var2, aj var3) {
      boolean var9 = p.c;
      int var4 = this.e();
      aj var5 = null;

      aj var6;
      while(this.e < var4) {
         var6 = new aj();
         aj var7 = new aj();
         var6.d = this.c;
         this.c.c = var6;
         this.c = var6;
         var7.d = this.d;
         this.d.c = var7;
         this.d = var7;
         var6.a = var7;
         var7.b = var6;
         ++this.e;
         if(var9) {
            break;
         }
      }

      var6 = null;
      int var10 = 0;

      do {
         aj var8;
         label31: {
            label30: {
               var8 = new aj();
               var8.e = var1;
               var8.b = var2;
               var8.a = var3;
               var2.a = var8;
               var3.b = var8;
               if(var5 == null) {
                  var6 = var8;
                  if(var9) {
                     break label30;
                  }

                  if(!var9) {
                     break label31;
                  }
               }

               var8.d = var5;
            }

            var5.c = var8;
         }

         var5 = var8;
         ++var10;
         if(var10 >= var4) {
            break;
         }

         while(true) {
            if(var2.c == null) {
               var2 = var2.b;
               if(var9) {
                  break;
               }

               if(!var9) {
                  continue;
               }
            }

            var2 = var2.c;
            break;
         }

         while(true) {
            if(var3.c == null) {
               var3 = var3.a;
               if(var9) {
                  break;
               }

               if(!var9) {
                  continue;
               }
            }

            var3 = var3.c;
            break;
         }
      } while(!var9);

      ++this.g;
      return var6;
   }

   public int a() {
      return this.g;
   }

   public void a(aj var1) {
      boolean var5 = p.c;

      do {
         aj var2 = var1.b;
         aj var3 = var1.a;
         aj var4 = var1.c;
         var1.b = var1.a = var1.d = var1.c = null;
         var2.a = var3;
         var3.b = var2;
         if(var4 == null) {
            break;
         }

         var1 = var4;
      } while(!var5);

      this.f();
      --this.g;
   }

   private void f() {
      boolean var1 = p.c;

      while(this.e > 1 && this.c.a == this.d) {
         this.d = this.d.d;
         this.c = this.c.d;
         this.d.c = this.c.c = null;
         --this.e;
         if(var1) {
            break;
         }
      }

   }

   public aj b(aj var1) {
      aj var2 = var1.a;
      return var2.a == null?null:var2;
   }

   public aj c(aj var1) {
      aj var2 = var1.b;
      return var2.b == null?null:var2;
   }

   public aj b() {
      return this.b(this.a);
   }

   public aj c() {
      return this.c(this.b);
   }

   public Iterator d() {
      return new ak(this, this.a);
   }

   public aj b(Object var1) {
      boolean var3 = p.c;
      aj var2 = this.c;

      while(true) {
         while(this.a(var1, var2.a) > 0) {
            var2 = var2.a;
            if(!var3 && var3) {
               break;
            }
         }

         if(var2.d == null) {
            return var2.a != null && var2.b != null?var2:null;
         }

         var2 = var2.d;
      }
   }

   public aj c(Object var1) {
      boolean var3 = p.c;
      aj var2 = this.d;

      while(true) {
         while(this.a(var1, var2.b) < 0) {
            var2 = var2.b;
            if(!var3 && var3) {
               break;
            }
         }

         if(var2.d == null) {
            return var2.a != null && var2.b != null?var2:null;
         }

         var2 = var2.d;
      }
   }

   private int a(Object var1, aj var2) {
      return var2.b == null?1:(var2.a == null?-1:this.f.compare(var1, var2.e));
   }

   public String toString() {
      boolean var4 = p.c;
      StringBuffer var1 = new StringBuffer();
      var1.append("SkipList{ size: ");
      var1.append(this.a());
      var1.append("; ");
      Iterator var2 = this.d();

      while(true) {
         if(var2.hasNext()) {
            Object var3 = var2.next();
            var1.append(var3).append(", ");
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         var1.append("}");
         break;
      }

      return var1.toString();
   }
}
