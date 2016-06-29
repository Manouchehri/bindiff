package y.h;

import java.awt.event.*;

class dt implements MouseWheelListener
{
    private final ds a;
    
    dt(final ds a) {
        this.a = a;
    }
    
    public void mouseWheelMoved(final MouseWheelEvent mouseWheelEvent) {
        this.a.a(mouseWheelEvent);
    }
}
