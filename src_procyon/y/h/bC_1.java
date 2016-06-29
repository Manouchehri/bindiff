package y.h;

import java.awt.event.*;

final class bC implements ContainerListener
{
    private final bB a;
    
    bC(final bB a) {
        this.a = a;
    }
    
    public void componentRemoved(final ContainerEvent containerEvent) {
        this.a.b(containerEvent.getChild());
    }
    
    public void componentAdded(final ContainerEvent containerEvent) {
        this.a.a(containerEvent.getChild());
    }
}
