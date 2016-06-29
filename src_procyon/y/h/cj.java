package y.h;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

class cj implements PopupMenuListener
{
    private final JPopupMenu a;
    private final boolean b;
    private final boolean c;
    private final ch d;
    
    cj(final ch d, final JPopupMenu a, final boolean b, final boolean c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void popupMenuCanceled(final PopupMenuEvent popupMenuEvent) {
    }
    
    public void popupMenuWillBecomeInvisible(final PopupMenuEvent popupMenuEvent) {
        this.a.removePopupMenuListener(this);
        if (this.b) {
            ch.access$600(this.d).removeMouseMotionListener(ch.access$500(this.d));
        }
        if (this.c) {
            ch.access$600(this.d).removeMouseListener(ch.access$500(this.d));
        }
    }
    
    public void popupMenuWillBecomeVisible(final PopupMenuEvent popupMenuEvent) {
    }
}
