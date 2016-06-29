package y.g.a;

import java.util.*;
import y.c.*;

public class j implements g
{
    private A a;
    private boolean b;
    private i c;
    private m d;
    
    public j(final i c) {
        this.a = null;
        this.b = false;
        this.d = null;
        this.c = c;
        this.a(this.a = this.c.t());
        this.b = true;
    }
    
    private void a(final A a) {
        this.a = a;
        this.d = new m(new k(this, a));
    }
    
    public boolean a() {
        return this.d.b();
    }
    
    public boolean a(final q q) {
        return this.d.c(q);
    }
    
    public void a(final q q, final int n) {
        this.a.a(q, n);
        this.d.a(q);
    }
    
    public void c(final q q) {
        this.d.b(q);
    }
    
    public q b() {
        return (q)this.d.c();
    }
    
    public q c() {
        final q b = this.b();
        this.c(b);
        return b;
    }
    
    public void b(final q q, final int n) {
        this.d.b(q);
        this.a.a(q, n);
        this.d.a(q);
    }
    
    public void d() {
        this.d.a();
    }
    
    public int b(final q q) {
        return this.a.a(q);
    }
}
