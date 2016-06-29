package y.h;

class fV implements Runnable
{
    private final fT a;
    
    fV(final fT a) {
        this.a = a;
    }
    
    public void run() {
        if (fT.b(this.a) && fT.c(this.a) != null && fT.c(this.a).getGlassPane() != null) {
            fT.c(this.a).getGlassPane().setVisible(fT.b(this.a));
        }
    }
}
