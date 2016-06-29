package y.a;

import y.c.*;

class ac implements R
{
    private int a;
    private int b;
    private y[] c;
    
    public ac(final int a) {
        final boolean a2 = h.a;
        this.a = a;
        this.b = -1;
        this.c = new y[a + 1];
        int i = 0;
        while (i < a + 1) {
            this.c[i] = new y();
            ++i;
            if (a2) {
                break;
            }
        }
    }
    
    public q a() {
        final boolean a = h.a;
        while (true) {
            while (this.b >= 0) {
                final int empty = this.c[this.b].isEmpty() ? 1 : 0;
                if (!a) {
                    if (empty == 0) {
                        break;
                    }
                    --this.b;
                    if (a) {
                        break;
                    }
                    continue;
                }
                else {
                    if (empty >= 0) {
                        return this.c[this.b].d();
                    }
                    return null;
                }
            }
            final int b = this.b;
            continue;
        }
    }
    
    public void a(final q q, final int b) {
        this.c[b].c(q);
        if (b > this.b) {
            this.b = b;
        }
    }
    
    public void b(final q q, final int n) {
        this.c[n].add(q);
    }
    
    public boolean b() {
        final boolean a = h.a;
        int empty = 0;
        while (this.b >= 0) {
            empty = (this.c[this.b].isEmpty() ? 1 : 0);
            if (a) {
                return empty < 0;
            }
            if (empty == 0) {
                break;
            }
            --this.b;
            if (a) {
                break;
            }
        }
        final int b = this.b;
        return empty < 0;
    }
    
    public void c() {
        final boolean a = h.a;
        int i = 0;
        while (i <= this.a) {
            this.c[i].clear();
            ++i;
            if (a) {
                return;
            }
            if (a) {
                break;
            }
        }
        this.b = -1;
    }
}
