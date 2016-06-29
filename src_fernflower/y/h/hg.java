package y.h;

import java.util.HashMap;
import java.util.Map;
import y.h.gZ;
import y.h.ha;
import y.h.hc;
import y.h.hd;
import y.h.he;
import y.h.hf;

final class hg {
   final hd a;
   final String b;
   final hc c;
   final ha d;
   final hf e;
   final he f;

   public hg(Map var1, Map var2, String var3) {
      HashMap var4 = new HashMap();
      var4.putAll(var2);
      var4.putAll(var1);
      this.a = (hd)var4.get(gZ.class$y$view$YLabel$Painter == null?(gZ.class$y$view$YLabel$Painter = gZ.class$("y.h.hd")):gZ.class$y$view$YLabel$Painter);
      this.c = (hc)var4.get(gZ.class$y$view$YLabel$Layout == null?(gZ.class$y$view$YLabel$Layout = gZ.class$("y.h.hc")):gZ.class$y$view$YLabel$Layout);
      this.d = (ha)var1.get(gZ.class$y$view$YLabel$BoundsProvider == null?(gZ.class$y$view$YLabel$BoundsProvider = gZ.class$("y.h.ha")):gZ.class$y$view$YLabel$BoundsProvider);
      this.e = (hf)var1.get(gZ.class$y$view$YLabel$UserDataHandler == null?(gZ.class$y$view$YLabel$UserDataHandler = gZ.class$("y.h.hf")):gZ.class$y$view$YLabel$UserDataHandler);
      this.f = (he)var1.get(gZ.class$y$view$YLabel$SelectionChangeHandler == null?(gZ.class$y$view$YLabel$SelectionChangeHandler = gZ.class$("y.h.he")):gZ.class$y$view$YLabel$SelectionChangeHandler);
      this.b = var3;
   }
}
