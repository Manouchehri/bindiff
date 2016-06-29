package y.f;

import java.io.Writer;
import y.f.X;

class ab {
   private int a;
   private Writer b;
   private StringBuffer c = new StringBuffer(100);
   private String d;

   public ab(Writer var1) {
      this.c.append("\t\t\t\t");
      this.a = 0;
      this.b = var1;
      this.d = System.getProperty("line.separator");
   }

   protected void a() {
      boolean var2 = X.j;
      int var1 = this.a;

      while(true) {
         if(this.c.length() < var1) {
            this.c.append(this.c.toString());
            if(var2) {
               break;
            }

            if(!var2) {
               continue;
            }
         }

         this.b.write(this.c.toString(), 0, var1);
         break;
      }

   }

   public void a(String var1) {
      this.a();
      this.b.write(var1);
      this.b.write(this.d);
      this.a();
      this.b.write("[" + this.d);
      ++this.a;
   }

   protected void a(String var1, String var2) {
      this.a();
      this.b.write(var1);
      this.b.write(9);
      this.b.write(var2);
      this.b.write(this.d);
   }

   public void a(String var1, double var2) {
      this.a(var1, Double.toString(var2));
   }

   public void a(String var1, int var2) {
      this.a(var1, Integer.toString(var2));
   }

   public void b(String var1, String var2) {
      this.a(var1, this.b(var2));
   }

   protected String b(String var1) {
      boolean var6 = X.j;
      byte var2 = 0;
      int var3 = 0;

      char var10000;
      while(true) {
         if(var3 < var1.length()) {
            label69: {
               char var4 = var1.charAt(var3);
               var10000 = var4;
               if(var6) {
                  break;
               }

               if(var4 > 255 || var4 == 10 || var4 == 38 || var4 == 34) {
                  var2 = 1;
                  if(!var6) {
                     break label69;
                  }
               }

               ++var3;
               if(!var6) {
                  continue;
               }
            }
         }

         var10000 = (char)var2;
         break;
      }

      if(var10000 == 0) {
         return '\"' + var1 + '\"';
      } else {
         StringBuffer var7 = new StringBuffer(var1.length() + 5);
         var7.append('\"');
         int var8 = 0;

         while(true) {
            if(var8 < var1.length()) {
               char var5 = var1.charAt(var8);
               if(var6) {
                  break;
               }

               label39: {
                  if(var5 > 255) {
                     var7.append("&#x");
                     var7.append(Integer.toHexString(var5));
                     var7.append(';');
                     if(!var6) {
                        break label39;
                     }
                  }

                  switch(var5) {
                  case '\"':
                     var7.append("&quot;");
                     if(!var6) {
                        break;
                     }
                  case '&':
                     var7.append("&amp;");
                     if(!var6) {
                        break;
                     }
                  default:
                     var7.append(var5);
                  }
               }

               ++var8;
               if(!var6) {
                  continue;
               }
            }

            var7.append('\"');
            break;
         }

         return var7.toString();
      }
   }

   public void b() {
      --this.a;
      this.a();
      this.b.write("]" + this.d);
   }
}
