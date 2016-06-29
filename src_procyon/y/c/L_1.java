package y.c;

class L
{
    private I a;
    private I b;
    private int c;
    
    public int a() {
        return this.c;
    }
    
    boolean b() {
        return this.c == 0;
    }
    
    I c() {
        return this.a;
    }
    
    I a(final I i) {
        return i.q();
    }
    
    public void b(final I b) {
        ++this.c;
        b.b(this.b);
        b.a(null);
        if (this.b != null) {
            this.b.a(b);
            this.b = b;
            if (!D.e) {
                return;
            }
        }
        this.a = b;
        this.b = b;
    }
    
    void a(final I i, final I j, final int n) {
        final boolean e = D.e;
        if (j == null) {
            this.b(i);
            return;
        }
        Label_0111: {
            if (n == 1) {
                final I r = j.r();
                Label_0047: {
                    if (r != null) {
                        r.a(i);
                        if (!e) {
                            break Label_0047;
                        }
                    }
                    this.a = i;
                }
                i.b(r);
                i.a(j);
                j.b(i);
                if (!e) {
                    break Label_0111;
                }
            }
            final I q = j.q();
            Label_0095: {
                if (q != null) {
                    q.b(i);
                    if (!e) {
                        break Label_0095;
                    }
                }
                this.b = i;
            }
            i.a(q);
            i.b(j);
            j.a(i);
        }
        ++this.c;
    }
    
    void c(final I i) {
        final boolean e = D.e;
        final I q = i.q();
        final I r = i.r();
        --this.c;
        Label_0044: {
            if (q != null) {
                q.b(r);
                if (!e) {
                    break Label_0044;
                }
            }
            this.b = r;
        }
        if (r != null) {
            r.a(q);
            if (!e) {
                return;
            }
        }
        this.a = q;
    }
    
    I d() {
        return this.a;
    }
    
    void e() {
        this.a = null;
        this.b = null;
        this.c = 0;
    }
    
    H f() {
        return new M(this);
    }
    
    static I a(final L l) {
        return l.a;
    }
    
    static I b(final L l) {
        return l.b;
    }
    
    static int c(final L l) {
        return l.c;
    }
}
