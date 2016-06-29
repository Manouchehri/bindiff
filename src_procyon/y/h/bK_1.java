package y.h;

class bK implements Runnable
{
    private final bS a;
    
    bK(final bS a) {
        this.a = a;
    }
    
    public void run() {
        this.a.c();
    }
}
