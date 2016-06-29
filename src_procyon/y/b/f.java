package y.b;

class f implements Runnable
{
    private final c[] a;
    private final a b;
    private final e c;
    
    f(final e c, final c[] a, final a b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public void run() {
        final int a = e.a;
        int i = 0;
        while (i < this.a.length) {
            this.a[i].animationPerformed(this.b);
            ++i;
            if (a != 0) {
                break;
            }
        }
    }
}
