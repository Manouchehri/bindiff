package y.f.c.a;

import y.c.*;

class bG
{
    private q a;
    private q b;
    
    private bG() {
    }
    
    public void a(final q a) {
        if (this.a == null) {
            this.a = a;
            if (!N.x) {
                return;
            }
        }
        throw new RuntimeException("Proxy already set!");
    }
    
    public void b(final q b) {
        if (this.b == null) {
            this.b = b;
            if (!N.x) {
                return;
            }
        }
        throw new RuntimeException("Proxy already set!");
    }
    
    public q a() {
        return this.a;
    }
    
    public q b() {
        return this.b;
    }
    
    bG(final bz bz) {
        this();
    }
}
