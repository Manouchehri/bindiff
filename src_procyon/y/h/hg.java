package y.h;

import java.util.*;

final class hg
{
    final hd a;
    final String b;
    final hc c;
    final ha d;
    final hf e;
    final he f;
    
    public hg(final Map map, final Map map2, final String b) {
        final HashMap<Object, hc> hashMap = new HashMap<Object, hc>();
        hashMap.putAll(map2);
        hashMap.putAll(map);
        this.a = (hd)hashMap.get((gZ.class$y$view$YLabel$Painter == null) ? (gZ.class$y$view$YLabel$Painter = gZ.class$("y.h.hd")) : gZ.class$y$view$YLabel$Painter);
        this.c = hashMap.get((gZ.class$y$view$YLabel$Layout == null) ? (gZ.class$y$view$YLabel$Layout = gZ.class$("y.h.hc")) : gZ.class$y$view$YLabel$Layout);
        this.d = (ha)map.get((gZ.class$y$view$YLabel$BoundsProvider == null) ? (gZ.class$y$view$YLabel$BoundsProvider = gZ.class$("y.h.ha")) : gZ.class$y$view$YLabel$BoundsProvider);
        this.e = (hf)map.get((gZ.class$y$view$YLabel$UserDataHandler == null) ? (gZ.class$y$view$YLabel$UserDataHandler = gZ.class$("y.h.hf")) : gZ.class$y$view$YLabel$UserDataHandler);
        this.f = (he)map.get((gZ.class$y$view$YLabel$SelectionChangeHandler == null) ? (gZ.class$y$view$YLabel$SelectionChangeHandler = gZ.class$("y.h.he")) : gZ.class$y$view$YLabel$SelectionChangeHandler);
        this.b = b;
    }
}
