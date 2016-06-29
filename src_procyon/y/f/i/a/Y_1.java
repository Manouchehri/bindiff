package y.f.i.a;

abstract class Y
{
    private long a;
    
    Y() {
        this.a = 0L;
    }
    
    public boolean a() {
        ++this.a;
        return this.a(this.a);
    }
    
    protected abstract boolean a(final long p0);
}
