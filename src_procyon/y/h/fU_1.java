package y.h;

import java.awt.print.*;

class fU implements Runnable
{
    private final PageFormat a;
    private final fT b;
    
    fU(final fT b, final PageFormat a) {
        this.b = b;
        this.a = a;
    }
    
    public void run() {
        fT.a(this.b).setPageFormat(this.a);
    }
}
