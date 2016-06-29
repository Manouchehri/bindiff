package y.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import y.h.aF;
import y.h.aG;
import y.h.aY;
import y.h.fK;
import y.h.fj;
import y.h.gr;

public final class aM {
   private final aY c;
   Map a;
   Set b;

   private aM() {
      this.c = new aY("DEFAULT");
      this.c.k = new gr();
      this.c.i = new fK();
      this.a = new HashMap();
      this.b = Collections.unmodifiableSet(this.a.keySet());
   }

   aY a() {
      return this.c;
   }

   public void a(aF var1, String var2) {
      aY var3 = (aY)this.a.get(var2);
      if(var3 != null) {
         if(aF.a(var1) != var3) {
            aF.a(var1, var3);
            if(aF.a(var1).o != null) {
               aF.a(var1).o.a(var1);
            }

            var1.setDirty();
            if(fj.z) {
               throw new IllegalArgumentException();
            }
         }

      } else {
         throw new IllegalArgumentException();
      }
   }

   aM(aG var1) {
      this();
   }
}
