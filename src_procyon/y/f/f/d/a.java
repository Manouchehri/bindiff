package y.f.f.d;

import y.c.*;

public class a
{
    public f a;
    public d[] b;
    public int c;
    public int d;
    
    public a(final int c) {
        this.a = new f();
        this.d = 0;
        this.c = c;
    }
    
    public a(final d d, final int c) {
        this.a = new f();
        this.d = 0;
        this.c = c;
        this.a.add(d);
        this.b = (d[])this.a.toArray(new d[1]);
    }
    
    public int a() {
        return this.c;
    }
    
    public void a(final d d) {
        this.a.add(d);
        this.b = (d[])this.a.toArray(new d[this.a.size()]);
    }
    
    public e b() {
        return this.a.a();
    }
    
    public d[] c() {
        return this.b;
    }
    
    public d b(final d d) {
        if (this.b[0] != d) {
            return this.b[0];
        }
        return this.b[1];
    }
}
