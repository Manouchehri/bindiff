package y.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import y.h.fj;
import y.h.gZ;
import y.h.hg;

public final class hb {
   private final Map c;
   Map a = new HashMap();
   Set b;

   hb(Map var1) {
      this.b = Collections.unmodifiableSet(this.a.keySet());
      this.c = var1;
   }

   public void a(String var1, Map var2) {
      if(var1 == null) {
         throw new NullPointerException("description");
      } else {
         hg var3 = new hg(var2, this.c, var1);
         this.a.put(var1, var3);
      }
   }

   public void a(gZ var1, String var2) {
      label22: {
         boolean var4 = fj.z;
         if(var2 == null) {
            var1.db = var1.c();
            if(!var4) {
               break label22;
            }
         }

         hg var3 = (hg)this.a.get(var2);
         if(var3 == null) {
            throw new IllegalArgumentException("Unregistered configuration: " + var2);
         }

         if(var1.db != var3) {
            var1.db = var3;
            if(var4) {
               throw new IllegalArgumentException("Unregistered configuration: " + var2);
            }
         }
      }

      var1.setOffsetDirty();
      var1.setSizeDirty();
   }
}
