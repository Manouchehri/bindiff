package y.f.i.a;

import y.f.*;
import y.d.*;

class ba
{
    final P[] a;
    final y[] b;
    private final aZ c;
    
    ba(final aZ c, final ax ax, final aU au) {
        this.c = c;
        final t t = ax.b() ? au.a(ax, false) : null;
        if (ax.a() == 255) {
            this.a = new P[4];
            this.b = new y[4];
            this.a[0] = this.a(1, ax.b(), t);
            this.b[0] = y.c;
            this.a[1] = this.a(2, ax.b(), t);
            this.b[1] = y.a;
            this.a[2] = this.a(4, ax.b(), t);
            this.b[2] = y.d;
            this.a[3] = this.a(8, ax.b(), t);
            this.b[3] = y.b;
            if (ab.a == 0) {
                return;
            }
        }
        this.a = new P[] { this.a(ax.a(), ax.b(), t) };
        this.b = new y[] { aZ.a(ax.e().b()) };
    }
    
    private P a(final int n, final boolean b, final t t) {
        if (b) {
            if (n == 1) {
                return new P(t.a(), t.a(), aZ.a(this.c).i(), false);
            }
            if (n == 2) {
                return new P(t.a(), t.a(), aZ.a(this.c).k(), false);
            }
            if (n == 4) {
                return new P(t.b(), t.b(), aZ.a(this.c).j(), true);
            }
            if (n == 8) {
                return new P(t.b(), t.b(), aZ.a(this.c).h(), true);
            }
        }
        else {
            if (n == 1) {
                return aZ.a(this.c).a(S.a);
            }
            if (n == 2) {
                return aZ.a(this.c).a(S.b);
            }
            if (n == 4) {
                return aZ.a(this.c).a(S.c);
            }
            if (n == 8) {
                return aZ.a(this.c).a(S.d);
            }
        }
        return null;
    }
}
