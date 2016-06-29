/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import y.a.ag;
import y.a.ai;
import y.a.h;
import y.c.A;
import y.c.d;
import y.c.i;
import y.c.q;
import y.c.y;

class ak
extends ai {
    int a;
    final Set b;
    int c;
    private final ag d;

    ak(ag ag2, i i2) {
        super(ag2, i2);
        this.d = ag2;
        this.a = 0;
        this.c = (int)Math.round(Math.sqrt((double)i2.g() * ag.b(ag2)));
        if ((double)i2.g() / (double)this.c < 15.0) {
            this.c = Math.round((float)i2.g() / 15.0f);
        }
        this.b = new HashSet(this.c);
    }

    @Override
    void a() {
        this.b.clear();
    }

    @Override
    d b() {
        ++this.a;
        return super.b();
    }

    @Override
    y[] a(y y2, A a2) {
        this.b.remove(y2);
        return super.a(y2, a2);
    }

    @Override
    void c(y y2) {
        boolean bl2 = h.a;
        this.i.set(this.g.a(y2.b()), y2);
        if (y2.size() > Math.max(ag.c(this.d), 1)) {
            block3 : {
                this.b.add(y2);
                if (this.a < this.c) return;
                Iterator iterator = this.b.iterator();
                while (iterator.hasNext()) {
                    this.a((y)iterator.next());
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block3;
                }
                this.a = 0;
                this.b.clear();
            }
            if (!bl2) return;
        }
        this.b.remove(y2);
        this.d(y2);
    }
}

