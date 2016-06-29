package y.b;

import java.util.ArrayList;
import java.util.List;
import y.b.d;
import y.b.l;

abstract class p implements l {
   List a = new ArrayList(2);
   boolean b = false;
   boolean c = false;

   public void a(d var1) {
      if(this.b) {
         throw new IllegalStateException();
      } else if(null != var1) {
         this.a.add(var1);
         this.c = true;
      }
   }
}
