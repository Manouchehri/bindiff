package y.a;

class M
{
    public N a(final Object o) {
        return new N(o);
    }
    
    public N a(N n) {
        final boolean a = h.a;
        N a2 = n.a;
        if (a2 == null) {
            return n;
        }
        N a3 = n;
        N a4 = null;
        while (a3.a != null) {
            a3 = a3.a;
            if (a) {
                return a4;
            }
            if (a) {
                break;
            }
        }
        while (a2 != a3) {
            n.a = a3;
            n = a2;
            a4 = n.a;
            if (a) {
                break;
            }
            a2 = a4;
            if (a) {
                break;
            }
        }
        return a4;
    }
    
    public void a(N a, N a2) {
        a = this.a(a);
        a2 = this.a(a2);
        if (a == a2) {
            return;
        }
        if (a.b > a2.b) {
            a2.a = a;
            final N n = a;
            n.b += a2.b;
            if (!h.a) {
                return;
            }
        }
        a.a = a2;
        final N n2 = a2;
        n2.b += a.b;
    }
    
    public Object b(final N n) {
        return n.c;
    }
}
