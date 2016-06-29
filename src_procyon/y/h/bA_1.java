package y.h;

import java.awt.event.*;

class bA extends gX
{
    private final bw a;
    
    bA(final bw a, final gU gu) {
        super(gu);
        this.a = a;
    }
    
    public void mouseReleased(final MouseEvent mouseEvent) {
        this.a.d(true);
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
    }
}
