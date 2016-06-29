package y.g;

import y.c.*;
import java.util.*;

public class ai
{
    private final aj a;
    private final aj b;
    private aj c;
    private aj d;
    private int e;
    private Comparator f;
    private int g;
    private ar h;
    
    public ai(final Comparator f) {
        this.h = new ar(42L);
        final aj aj = new aj();
        this.c = aj;
        this.a = aj;
        final aj aj2 = new aj();
        this.d = aj2;
        this.b = aj2;
        this.a.a = this.b;
        this.b.b = this.a;
        this.f = f;
        this.g = 0;
        this.e = 1;
    }
    
    public ai() {
        this(y.g.e.a());
    }
    
    public aj a(final Object o) {
        final boolean c = p.c;
        final int e = this.e();
        aj b = this.c;
        while (this.a(o, b.a) > 0) {
            b = b.a;
            if (c) {
                break;
            }
        }
        int i = this.e;
        aj c2 = null;
        aj d = null;
        aj aj;
        aj b2;
        aj a;
        aj aj2;
        aj aj3;
        aj aj4;
        aj aj5;
        aj aj6;
        aj a2;
        aj aj7;
        Label_0263:Label_0270_Outer:
        while (true) {
        Label_0270:
            while (true) {
            Label_0310_Outer:
                while (this.e < e) {
                    aj = new aj();
                    aj.e = o;
                    b2 = new aj();
                    a = new aj();
                    b2.d = this.c;
                    this.c.c = b2;
                    this.c = b2;
                    a.d = this.d;
                    this.d.c = a;
                    this.d = a;
                    aj2 = b2;
                    aj3 = a;
                    aj4 = aj;
                    aj3.b = aj4;
                    aj2.a = aj4;
                    aj.b = b2;
                    aj.a = a;
                    aj5 = d;
                    if (c) {
                    Block_10:
                        while (true) {
                            if (aj5 != null) {
                                aj.c = c2;
                                c2.d = aj;
                            }
                            c2 = aj;
                            b = b.d;
                            Label_0308: {
                                while (b != null) {
                                    while (this.a(o, b.a) > 0) {
                                        b = b.a;
                                        if (c) {
                                            continue Label_0308;
                                        }
                                        if (!c) {
                                            continue Label_0310_Outer;
                                        }
                                        break Label_0308;
                                    }
                                    break Label_0263;
                                }
                                break Block_10;
                                aj6 = new aj();
                                aj = a2;
                                aj.e = o;
                                aj.b = b;
                                aj.a = b.a;
                                b.a.b = aj;
                                b.a = aj;
                            }
                            continue Label_0270_Outer;
                        }
                        ++this.g;
                        aj7 = aj;
                        if (y.c.i.g) {
                            p.c = !c;
                        }
                        return aj7;
                    }
                    Label_0198: {
                        if (aj5 != null) {
                            aj.d = d;
                            d.c = aj;
                            if (!c) {
                                break Label_0198;
                            }
                        }
                        c2 = aj;
                    }
                    d = aj;
                    ++this.e;
                    if (c) {
                        break;
                    }
                }
                while (i > e) {
                    b = b.d;
                    --i;
                    while (this.a(o, b.a) > 0) {
                        a2 = b.a;
                        if (c) {
                            continue Label_0270;
                        }
                        b = a2;
                        if (c || c) {
                            continue Label_0263;
                        }
                    }
                }
                break;
            }
            continue Label_0263;
        }
    }
    
    private int e() {
        int n = 1;
        if (this.h.nextBoolean()) {
            ++n;
            if (this.h.nextBoolean()) {
                ++n;
                if (this.h.nextBoolean()) {
                    ++n;
                    if (this.h.nextBoolean()) {
                        ++n;
                        if (this.h.nextBoolean()) {
                            ++n;
                            if (this.h.nextBoolean()) {
                                ++n;
                                if (this.h.nextBoolean()) {
                                    ++n;
                                    if (this.h.nextBoolean()) {
                                        ++n;
                                        if (this.h.nextBoolean()) {
                                            ++n;
                                            if (this.h.nextBoolean()) {
                                                ++n;
                                                if (this.h.nextBoolean()) {
                                                    ++n;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return n;
    }
    
    public void a(aj a, final aj aj) {
        final boolean c = p.c;
        if (a == aj) {
            this.a(a);
            if (!c) {
                return;
            }
        }
        aj b = a.b;
        aj a2 = aj.a();
        int i = 0;
        while (true) {
            while (i < this.e) {
                b.a = a2;
                a2.b = b;
                if (c) {
                    while (a != aj) {
                        a = a.a;
                        --this.g;
                        if (c) {
                            return;
                        }
                        if (c) {
                            break;
                        }
                    }
                    --this.g;
                    return;
                }
                Label_0133: {
                    Label_0130: {
                        if (i != this.e - 1) {
                            while (true) {
                                while (b.c == null) {
                                    b = b.b;
                                    if (c) {
                                        while (a2.c == null) {
                                            a2 = a2.a;
                                            if (c) {
                                                break Label_0133;
                                            }
                                            if (c) {
                                                break;
                                            }
                                        }
                                        a2 = a2.c;
                                        break Label_0130;
                                    }
                                    if (c) {
                                        break;
                                    }
                                }
                                b = b.c;
                                continue;
                            }
                        }
                    }
                    ++i;
                }
                if (c) {
                    break;
                }
            }
            this.f();
            continue;
        }
    }
    
    public aj a(final aj aj, final Object o) {
        try {
            if (aj != null) {
                return this.a(o, aj, aj.a);
            }
            if (this.g == 0) {
                return this.a(o);
            }
            return this.b(this.b(), o);
        }
        finally {}
    }
    
    public aj b(final aj aj, final Object o) {
        try {
            if (aj != null) {
                return this.a(o, aj.b, aj);
            }
            if (this.g == 0) {
                return this.a(o);
            }
            return this.a(this.c(), o);
        }
        finally {}
    }
    
    private aj a(final Object e, aj b, aj a) {
        final boolean c = p.c;
        final int e2 = this.e();
        aj d = null;
        while (this.e < e2) {
            final aj b2 = new aj();
            final aj a2 = new aj();
            b2.d = this.c;
            this.c.c = b2;
            this.c = b2;
            a2.d = this.d;
            this.d.c = a2;
            this.d = a2;
            b2.a = a2;
            a2.b = b2;
            ++this.e;
            if (c) {
                break;
            }
        }
        aj aj = null;
        int n = 0;
    Label_0264:
        do {
            final aj c2 = new aj();
            c2.e = e;
            c2.b = b;
            c2.a = a;
            b.a = c2;
            a.b = c2;
            Label_0196: {
                Label_0189: {
                    if (d == null) {
                        aj = c2;
                        if (c) {
                            break Label_0189;
                        }
                        if (!c) {
                            break Label_0196;
                        }
                    }
                    c2.d = d;
                }
                d.c = c2;
            }
            d = c2;
            if (++n < e2) {
                while (true) {
                    while (b.c == null) {
                        b = b.b;
                        if (c) {
                            while (a.c == null) {
                                a = a.a;
                                if (c) {
                                    continue Label_0264;
                                }
                                if (c) {
                                    break;
                                }
                            }
                            a = a.c;
                            continue Label_0264;
                        }
                        if (c) {
                            break;
                        }
                    }
                    b = b.c;
                    continue;
                }
            }
            break;
        } while (!c);
        ++this.g;
        return aj;
    }
    
    public int a() {
        return this.g;
    }
    
    public void a(aj aj) {
        do {
            final aj b = aj.b;
            final aj a = aj.a;
            final aj c = aj.c;
            final aj aj2 = aj;
            final aj aj3 = aj;
            final aj aj4 = aj;
            final aj aj5 = aj;
            final aj aj6 = null;
            aj5.c = aj6;
            aj4.d = aj6;
            aj3.a = aj6;
            aj2.b = aj6;
            b.a = a;
            a.b = b;
            if (c == null) {
                break;
            }
            aj = c;
        } while (!p.c);
        this.f();
        --this.g;
    }
    
    private void f() {
        final boolean c = p.c;
        while (this.e > 1 && this.c.a == this.d) {
            this.d = this.d.d;
            this.c = this.c.d;
            final aj d = this.d;
            final aj c2 = this.c;
            final aj aj = null;
            c2.c = aj;
            d.c = aj;
            --this.e;
            if (c) {
                break;
            }
        }
    }
    
    public aj b(final aj aj) {
        final aj a = aj.a;
        if (a.a == null) {
            return null;
        }
        return a;
    }
    
    public aj c(final aj aj) {
        final aj b = aj.b;
        if (b.b == null) {
            return null;
        }
        return b;
    }
    
    public aj b() {
        return this.b(this.a);
    }
    
    public aj c() {
        return this.c(this.b);
    }
    
    public Iterator d() {
        return new ak(this, this.a);
    }
    
    public aj b(final Object o) {
        final boolean c = p.c;
        aj aj = this.c;
        while (true) {
            if (this.a(o, aj.a) > 0) {
                aj = aj.a;
                if (c) {
                    continue;
                }
                if (!c) {
                    continue;
                }
            }
            if (aj.d == null) {
                break;
            }
            aj = aj.d;
        }
        return (aj.a != null && aj.b != null) ? aj : null;
    }
    
    public aj c(final Object o) {
        final boolean c = p.c;
        aj aj = this.d;
        while (true) {
            if (this.a(o, aj.b) < 0) {
                aj = aj.b;
                if (c) {
                    continue;
                }
                if (!c) {
                    continue;
                }
            }
            if (aj.d == null) {
                break;
            }
            aj = aj.d;
        }
        return (aj.a != null && aj.b != null) ? aj : null;
    }
    
    private int a(final Object o, final aj aj) {
        if (aj.b == null) {
            return 1;
        }
        if (aj.a == null) {
            return -1;
        }
        return this.f.compare(o, aj.e);
    }
    
    public String toString() {
        final boolean c = p.c;
        final StringBuffer sb = new StringBuffer();
        sb.append("SkipList{ size: ");
        sb.append(this.a());
        sb.append("; ");
        final Iterator d = this.d();
        while (d.hasNext()) {
            sb.append(d.next()).append(", ");
            if (c) {
                return sb.toString();
            }
            if (c) {
                break;
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
