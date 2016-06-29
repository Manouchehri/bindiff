package y.h;

import java.lang.ref.*;
import java.beans.*;
import y.c.*;

class cO implements PropertyChangeListener
{
    private final WeakReference a;
    private final WeakReference b;
    private final WeakReference c;
    
    cO(final cG cg, final bu bu, final gZ gz) {
        this.a = new WeakReference((T)cg);
        this.b = new WeakReference((T)bu);
        this.c = new WeakReference((T)gz);
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        a((cG)this.a.get(), (bu)this.b.get(), (gZ)this.c.get(), (String)propertyChangeEvent.getNewValue());
    }
    
    private static void a(final cG cg, final bu bu, final gZ gz, final String text) {
        final boolean z = fj.z;
        if (bu != null && gz != null) {
            bu.r();
            try {
                Label_0078: {
                    if (gz instanceof eR) {
                        bu.a(new y(((eR)gz).f()).a());
                        if (!z) {
                            break Label_0078;
                        }
                    }
                    if (gz instanceof aA) {
                        bu.a(new f(((aA)gz).getEdge()).a());
                    }
                }
                if (cg == null) {
                    gz.setText(text);
                    if (!z) {
                        return;
                    }
                }
                cg.a(gz, text);
            }
            finally {
                bu.s();
            }
        }
    }
}
