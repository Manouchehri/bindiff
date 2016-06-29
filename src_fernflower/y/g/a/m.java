package y.g.a;

import java.util.Comparator;
import y.g.a.d;
import y.g.a.l;
import y.g.a.r;

class m extends r {
   public m(Comparator var1) {
      super(var1);
   }

   public void a(Object var1) {
      boolean var4 = d.a;
      l var2 = null;
      l var3 = this.a;
      if(var3 == null) {
         this.a = new l(var1);
      } else {
         while(true) {
            int var10000;
            if(var3 != null) {
               var2 = var3;
               var10000 = this.a(var1, var3.d);
               if(!var4) {
                  if(var10000 < 0) {
                     var3 = var3.b;
                     if(!var4) {
                        continue;
                     }
                  }

                  if(this.a(var1, var3.d) > 0) {
                     var3 = var3.c;
                     if(!var4) {
                        continue;
                     }
                  }

                  var3.d = var1;
                  return;
               }
            } else {
               var3 = new l(var1);
               var10000 = this.a(var1, var2.d);
            }

            if(var10000 < 0) {
               var2.a(var3);
               if(var2.e == 1) {
                  var2.e = 0;
                  if(!var4) {
                     break;
                  }
               }

               var2.e = -1;
               this.a(var2);
               if(!var4) {
                  break;
               }
            }

            var2.b(var3);
            if(var2.e == -1) {
               var2.e = 0;
               if(!var4) {
                  break;
               }
            }

            var2.e = 1;
            this.a(var2);
            break;
         }
      }

      ++this.b;
   }

   void a(l var1) {
      boolean var4 = d.a;
      if(var1.a != null) {
         l var2 = var1.a;
         byte var3;
         if(var2.b == var1) {
            switch(var2.e) {
            case 1:
               var2.e = 0;
               if(!var4) {
                  break;
               }
            case 0:
               var2.e = -1;
               this.a(var2);
               if(!var4) {
                  break;
               }
            case -1:
               switch(var1.e) {
               case -1:
                  this.e(var2);
                  var2.e = 0;
                  var2.c.e = 0;
                  if(!var4) {
                     break;
                  }
               case 1:
                  var3 = var2.b.c.e;
                  this.g(var2);
                  var2.e = 0;
                  switch(var3) {
                  case 0:
                     var2.b.e = 0;
                     var2.c.e = 0;
                     if(!var4) {
                        break;
                     }
                  case 1:
                     var2.b.e = -1;
                     var2.c.e = 0;
                     if(!var4) {
                        break;
                     }
                  case -1:
                     var2.b.e = 0;
                     var2.c.e = 1;
                  }
               }
            }

            if(!var4) {
               return;
            }
         }

         if(var2.c == var1) {
            switch(var2.e) {
            case -1:
               var2.e = 0;
               if(!var4) {
                  break;
               }
            case 0:
               var2.e = 1;
               this.a(var2);
               if(!var4) {
                  break;
               }
            case 1:
               switch(var1.e) {
               case 1:
                  this.d(var2);
                  var2.e = 0;
                  var2.b.e = 0;
                  if(!var4) {
                     break;
                  }
               case -1:
                  var3 = var2.c.b.e;
                  this.f(var2);
                  var2.e = 0;
                  switch(var3) {
                  case 0:
                     var2.c.e = 0;
                     var2.b.e = 0;
                     if(!var4) {
                        break;
                     }
                  case -1:
                     var2.c.e = 1;
                     var2.b.e = 0;
                     if(!var4) {
                        break;
                     }
                  case 1:
                     var2.c.e = 0;
                     var2.b.e = -1;
                  }
               }
            }
         }

      }
   }

   public void b(Object var1) {
      l var2 = this.d(var1);
      if(var2 != null) {
         this.b(var2);
      }

      --this.b;
   }

   void b(l var1) {
      boolean var4 = d.a;
      l var2 = var1.a;
      if(var1.b == null && var1.c == null) {
         if(var2 == null) {
            this.a = null;
            if(!var4) {
               return;
            }
         }

         this.c(var1);
         if(var1.a.b == var1) {
            var1.a.b = null;
            if(!var4) {
               return;
            }
         }

         var1.a.c = null;
         if(!var4) {
            return;
         }
      }

      if(var1.b == null || var1.c == null) {
         label24: {
            if(var1.b != null) {
               var1.d = var1.b.d;
               if(!var4) {
                  break label24;
               }
            }

            var1.d = var1.c.d;
         }

         var1.b = var1.c = null;
         var1.e = 0;
         this.c(var1);
         if(!var4) {
            return;
         }
      }

      l var3 = this.h(var1.c);
      a(var1, var3);
      this.b(var3);
   }

   void c(l var1) {
      boolean var4 = d.a;
      if(var1.a != null) {
         l var2 = var1.a;
         byte var3;
         if(var2.b == var1) {
            label75: {
               switch(var2.e) {
               case -1:
                  var2.e = 0;
                  this.c(var2);
                  if(!var4) {
                     break label75;
                  }
               case 0:
                  var2.e = 1;
                  if(!var4) {
                     break label75;
                  }
               case 1:
                  break;
               default:
                  break label75;
               }

               switch(var2.c.e) {
               case 0:
                  this.d(var2);
                  var2.e = -1;
                  var2.b.e = 1;
                  if(!var4) {
                     break;
                  }
               case -1:
                  var3 = var2.c.b.e;
                  this.f(var2);
                  var2.e = 0;
                  switch(var3) {
                  case -1:
                     var2.b.e = 0;
                     var2.c.e = 1;
                     if(!var4) {
                        break;
                     }
                  case 0:
                     var2.c.e = 0;
                     if(!var4) {
                        break;
                     }
                  case 1:
                     var2.b.e = -1;
                     var2.c.e = 0;
                  }

                  this.c(var2);
                  if(!var4) {
                     break;
                  }
               case 1:
                  this.d(var2);
                  var2.e = 0;
                  var2.b.e = 0;
                  this.c(var2);
               }
            }

            if(!var4) {
               return;
            }
         }

         if(var2.c == var1) {
            switch(var2.e) {
            case 1:
               var2.e = 0;
               this.c(var2);
               if(!var4) {
                  break;
               }
            case 0:
               var2.e = -1;
               if(!var4) {
                  break;
               }
            case -1:
               switch(var2.b.e) {
               case 0:
                  this.e(var2);
                  var2.e = 1;
                  var2.c.e = -1;
                  if(!var4) {
                     break;
                  }
               case 1:
                  var3 = var2.b.c.e;
                  this.g(var2);
                  var2.e = 0;
                  switch(var3) {
                  case 1:
                     var2.c.e = 0;
                     var2.b.e = -1;
                     if(!var4) {
                        break;
                     }
                  case 0:
                     var2.b.e = 0;
                     if(!var4) {
                        break;
                     }
                  case -1:
                     var2.c.e = 1;
                     var2.b.e = 0;
                  }

                  this.c(var2);
                  if(!var4) {
                     break;
                  }
               case -1:
                  this.e(var2);
                  var2.e = 0;
                  var2.c.e = 0;
                  this.c(var2);
               }
            }
         }

      }
   }

   void d(l var1) {
      l var2 = var1.c;
      var1.b(var2.c);
      var2.b(var2.b);
      var2.a(var1.b);
      var1.a(var2);
      a(var1, var2);
   }

   void e(l var1) {
      l var2 = var1.b;
      var1.a(var2.b);
      var2.a(var2.c);
      var2.b(var1.c);
      var1.b(var2);
      a(var1, var2);
   }

   void f(l var1) {
      l var2 = var1.c;
      l var3 = var2.b;
      var2.a(var3.c);
      var3.b(var3.b);
      var3.a(var1.b);
      var1.a(var3);
      a(var1, var3);
   }

   void g(l var1) {
      l var2 = var1.b;
      l var3 = var2.c;
      var2.b(var3.b);
      var3.a(var3.c);
      var3.b(var1.c);
      var1.b(var3);
      a(var1, var3);
   }
}
