package y.h;

import java.util.*;

public final class hb
{
    private final Map c;
    Map a;
    Set b;
    
    hb(final Map c) {
        this.a = new HashMap();
        this.b = Collections.unmodifiableSet(this.a.keySet());
        this.c = c;
    }
    
    public void a(final String s, final Map map) {
        if (s == null) {
            throw new NullPointerException("description");
        }
        this.a.put(s, new hg(map, this.c, s));
    }
    
    public void a(final gZ gz, final String s) {
        final boolean z = fj.z;
        Label_0085: {
            if (s == null) {
                gz.db = gz.c();
                if (!z) {
                    break Label_0085;
                }
            }
            final hg db = this.a.get(s);
            if (db != null) {
                if (gz.db == db) {
                    break Label_0085;
                }
                gz.db = db;
                if (!z) {
                    break Label_0085;
                }
            }
            throw new IllegalArgumentException("Unregistered configuration: " + s);
        }
        gz.setOffsetDirty();
        gz.setSizeDirty();
    }
}
