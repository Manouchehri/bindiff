package y.a;

import y.a.h;

public class b {
   public static y.c.y[] a(y.c.i var0, y.c.y var1) {
      y.c.A var2 = y.g.M.a(new int[var0.e()]);
      y.c.y[] var3 = a(var0, var1, var2);
      return var3;
   }

   public static y.c.y[] a(y.c.i var0, y.c.c var1, y.c.A var2) {
      return a(var0, new y.c.y(var0.o(), var1), var2);
   }

   public static y.c.y[] a(y.c.i var0, y.c.y var1, y.c.A var2) {
      return a(var0, var1, false, var2);
   }

   public static y.c.y[] a(y.c.i var0, y.c.y var1, boolean var2, y.c.A var3) {
      return a(var0, var1, var2, var3, 0);
   }

   public static y.c.y[] a(y.c.i var0, y.c.y var1, boolean var2, y.c.A var3, int var4) {
      int var5 = var2?2:3;
      return a(var0, var1, (byte)var5, var3, var4);
   }

   public static y.c.y[] a(y.c.i var0, y.c.y var1, byte var2, y.c.A var3, int var4) {
      boolean var13 = h.a;
      switch(var2) {
      case 1:
      case 2:
      case 3:
         if(!var13) {
            y.c.D var5 = new y.c.D();
            if(var0.i()) {
               return new y.c.y[0];
            } else {
               y.c.y var6 = new y.c.y();
               int var7 = 0;
               y.c.x var8 = var0.o();

               y.c.q var9;
               while(true) {
                  if(var8.f()) {
                     var9 = var8.e();
                     var3.a(var9, -1);
                     var8.g();
                     if(var13) {
                        break;
                     }

                     if(!var13) {
                        continue;
                     }
                  }

                  var8 = var1.a();
                  break;
               }

               while(true) {
                  if(var8.f()) {
                     var9 = var8.e();
                     var3.a(var9, var7);
                     var6.b(var9);
                     var8.g();
                     if(var13) {
                        return (y.c.y[])var5.toArray(new y.c.y[var5.size()]);
                     }

                     if(!var13) {
                        continue;
                     }
                  }

                  int var10000;
                  int var10001;
                  label78:
                  do {
                     do {
                        if(var6.isEmpty()) {
                           return (y.c.y[])var5.toArray(new y.c.y[var5.size()]);
                        }

                        y.c.y var14 = var6;
                        var5.b((Object)var6);
                        var6 = new y.c.y();
                        ++var7;
                        y.c.x var15 = var14.a();

                        while(true) {
                           if(var15.f()) {
                              y.c.q var10 = var15.e();
                              var10000 = var2;
                              if(var13) {
                                 break;
                              }

                              y.c.x var11;
                              switch(var2) {
                              case 1:
                                 var11 = var10.n();
                                 if(!var13) {
                                    break;
                                 }
                              case 2:
                                 var11 = var10.o();
                                 if(!var13) {
                                    break;
                                 }
                              case 3:
                                 var11 = var10.m();
                                 if(!var13) {
                                    break;
                                 }
                              default:
                                 var11 = var10.m();
                              }

                              while(var11.f()) {
                                 y.c.q var12 = var11.e();
                                 var10000 = var3.a(var12);
                                 var10001 = -1;
                                 if(var13) {
                                    continue label78;
                                 }

                                 if(var10000 == -1) {
                                    var3.a(var12, var7);
                                    var6.b(var12);
                                 }

                                 var11.g();
                                 if(var13) {
                                    break;
                                 }
                              }

                              var15.g();
                              if(!var13) {
                                 continue;
                              }
                           }

                           var10000 = var4;
                           break;
                        }
                     } while(var10000 <= 0);

                     var10000 = var4;
                     var10001 = var7;
                  } while(var10000 != var10001);

                  return (y.c.y[])var5.toArray(new y.c.y[var5.size()]);
               }
            }
         }
      default:
         throw new IllegalArgumentException("Unsupported direction: " + var2);
      }
   }
}
