package y.h;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import y.h.eV;
import y.h.fe;

public final class eY {
   final Map a;
   final Set b;
   final fe c;

   private eY() {
      this.a = new HashMap();
      this.b = Collections.unmodifiableSet(this.a.keySet());
      this.c = new fe("DEFAULT");
   }

   fe a() {
      return this.c;
   }

   eY(eV var1) {
      this();
   }
}
