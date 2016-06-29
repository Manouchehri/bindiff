package y.h;

class fX implements Runnable
{
    private final fW a;
    
    fX(final fW a) {
        this.a = a;
    }
    
    public void run() {
        fW.a(this.a).a();
        fW.b(this.a).repaint();
    }
}
