package y.g;

public class c
{
    private Object[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    
    public c(final int n) {
        this.a = new Object[n + 1];
        this.b = 0;
        this.c = this.b + n + 1;
        final int b = this.b;
        this.e = b;
        this.d = b;
    }
    
    public Object a() {
        final Object o = this.a[this.d++];
        if (this.d == this.c) {
            this.d = this.b;
        }
        return o;
    }
    
    public Object b() {
        final Object o = this.a[this.d++];
        if (this.d == this.c) {
            this.d = this.b;
        }
        return o;
    }
    
    public void a(final Object o) {
        this.a[this.e++] = o;
        if (this.e == this.c) {
            this.e = this.b;
        }
    }
    
    public void b(final Object o) {
        this.a[this.e++] = o;
        if (this.e == this.c) {
            this.e = this.b;
        }
    }
    
    public void c() {
        final int b = this.b;
        this.e = b;
        this.d = b;
    }
    
    public int d() {
        final int n = this.e - this.d;
        return (n < 0) ? (this.c - this.b + n) : n;
    }
    
    public boolean e() {
        return this.d == this.e;
    }
    
    public String toString() {
        final boolean c = p.c;
        String s = "size=[" + this.d() + ']';
        int i = this.d;
        while (true) {
            while (i < this.e) {
                final int n = i;
                final int c2 = this.c;
                if (c) {
                    String string = null;
                    if (n < c2) {
                        int j = this.b;
                        while (j < this.e) {
                            string = s + ' ' + this.a[j].toString();
                            if (c) {
                                break;
                            }
                            s = string;
                            ++j;
                            if (c) {
                                break;
                            }
                        }
                    }
                    return string;
                }
                if (n >= c2) {
                    break;
                }
                s = s + ' ' + this.a[i].toString();
                ++i;
                if (c) {
                    break;
                }
            }
            final int e = this.e;
            final int d = this.d;
            continue;
        }
    }
}
