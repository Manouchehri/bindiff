package y.g;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import y.g.at;
import y.g.p;

public class o {
   private static String b = null;
   public static final int a;

   public static void a(int var0, String var1) {
      if(a >= var0) {
         System.out.println(var1);
      }

   }

   public static void a(Object var0) {
      System.err.println(var0);
      if(var0 instanceof Exception) {
         ((Exception)var0).printStackTrace(System.err);
      }

   }

   public static void a(Object var0, Object var1) {
      if(b(var0)) {
         System.err.println(var0.getClass().getName() + " : " + var1);
      }

   }

   public static void a(Object var0, int var1, Object var2) {
      if(a >= var1 && b(var0)) {
         System.err.println(var0.getClass().getName() + " : " + var2);
      }

   }

   public static boolean b(Object var0) {
      String var1 = var0.getClass().getName();
      return a(var1);
   }

   public static boolean a(String var0) {
      boolean var5 = p.c;
      String var1 = b;
      if(var1 == null) {
         return false;
      } else {
         int var2 = -1;
         int var3 = var1.indexOf(58, var2 + 1);

         int var10000;
         String var4;
         while(true) {
            if(var3 > var2) {
               var4 = var1.substring(var2 + 1, var3);
               var10000 = var4.length();
               if(var5) {
                  break;
               }

               if(var10000 > 0 && var0.startsWith(var4)) {
                  return true;
               }

               var2 = var3;
               var3 = var1.indexOf(58, var3 + 1);
               if(!var5) {
                  continue;
               }
            }

            var3 = var1.length();
            var10000 = var3;
            break;
         }

         if(var10000 > var2 + 1) {
            var4 = var1.substring(var2 + 1, var3);
            if(var4.length() > 0 && var0.startsWith(var4)) {
               return true;
            }
         }

         return false;
      }
   }

   static {
      while(true) {
         try {
            if(at.a() == 0L) {
               break;
            }

            if(at.a() < 0L) {
               System.err.println("yFiles for Java Evaluation Version");
               break;
            }

            long var0 = System.currentTimeMillis() / 1000L;
            if(at.a() - var0 < 0L) {
               System.err.println("The evaluation time of yFiles for Java has expired\n");
               System.exit(1);
            } else {
               if(at.b() - var0 <= 0L) {
                  System.err.println("yFiles for Java: Remaining Evaluation Period: " + (at.a() - var0) / 86400L + " days");
                  break;
               }

               System.err.println("The evaluation time of yFiles for Java has expired\n");
               System.exit(1);
            }
         } catch (RuntimeException var11) {
            System.exit(1);
         }
      }

      int var12 = 0;

      try {
         if(System.getProperty("y.debug.level") != null) {
            var12 = Integer.parseInt(System.getProperty("y.debug.level"));
         }

         b = System.getProperty("y.debug");
         String var1 = System.getProperty("y.debug.file");
         if(var1 != null) {
            FileInputStream var2 = new FileInputStream(new File(var1));
            BufferedReader var3 = new BufferedReader(new InputStreamReader(var2));

            String var4;
            while((var4 = var3.readLine()) != null) {
               if(b == null) {
                  b = var4;
               } else {
                  b = b + ":" + var4;
               }
            }

            var3.close();
            var2.close();
         }
      } catch (Exception var9) {
         ;
      } finally {
         a = var12;
      }

   }
}
