package y.f.e;

import java.awt.Rectangle;
import y.f.e.i;
import y.f.e.l;
import y.f.e.o;

class m implements y.d.g {
   private final l a;

   m(l var1) {
      this.a = var1;
   }

   public void a(Object var1, Object var2) {
      boolean var9 = i.b;
      Rectangle var3 = ((o)var1).a;
      Rectangle var4 = ((o)var2).a;
      Rectangle var5 = var3.intersection(var4);
      if(var5.width != 0 && var5.height != 0) {
         boolean var6;
         int var7;
         label83: {
            if(l.b(this.a) == 0) {
               var6 = var5.width < var5.height;
               if(!var9) {
                  break label83;
               }
            }

            if(l.b(this.a) == 1) {
               var6 = Math.abs(var3.x - var4.x + (var3.width - var4.width) / 2) > Math.abs(var3.y - var4.y + (var3.height - var4.height) / 2);
               if(!var9) {
                  break label83;
               }
            }

            int var8;
            if(l.a(var3, var4)) {
               var7 = Math.min(var4.y + var4.height - var3.y, var3.y + var3.height - var4.y);
               var8 = Math.min(var4.x + var4.width - var3.x, var3.x + var3.width - var4.x);
               var6 = var8 < var7;
               if(!var9) {
                  break label83;
               }
            }

            if(l.a(var4, var3)) {
               var7 = Math.min(var3.y + var3.height - var4.y, var4.y + var4.height - var3.y);
               var8 = Math.min(var3.x + var3.width - var4.x, var4.x + var4.width - var3.x);
               var6 = var8 < var7;
               if(!var9) {
                  break label83;
               }
            }

            var6 = var5.width < var5.height;
         }

         if(var6) {
            if(var4.x >= var3.x && var4.x < var3.x + var3.width) {
               var7 = (1 + var3.x + var3.width - var4.x) / 2;
               if(var7 >= var3.width || var7 >= var4.width) {
                  return;
               }

               var3.width -= var7;
               var4.x += var7;
               var4.width -= var7;
               if(!var9) {
                  return;
               }
            }

            if(var3.x >= var4.x && var3.x < var4.x + var4.width) {
               var7 = (1 + var4.x + var4.width - var3.x) / 2;
               if(var7 < var3.width && var7 < var4.width) {
                  var4.width -= var7;
                  var3.x += var7;
                  var3.width -= var7;
               }
            }
         }
      }

   }
}
