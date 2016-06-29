package y.c;

class I
{
    I i;
    I j;
    Object[] k;
    
    void a(final int n) {
        this.k = new Object[n];
    }
    
    I q() {
        return this.i;
    }
    
    I r() {
        return this.j;
    }
    
    void a(final I i) {
        this.i = i;
    }
    
    void b(final I j) {
        this.j = j;
    }
}
