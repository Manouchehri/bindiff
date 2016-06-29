package y.h;

import y.g.*;
import y.c.*;

public class gY implements z
{
    final bu a;
    int b;
    int c;
    int d;
    int e;
    
    public gY(final bu a, final int b, final int c, final int d, final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public boolean a(final Object o) {
        if (o instanceof d) {
            if (this.a.i((d)o).isVisible()) {
                return (this.d & 0x1) != 0x0;
            }
            return (this.d & 0x2) != 0x0;
        }
        else if (o instanceof q) {
            if (this.a.t((q)o).isVisible()) {
                return (this.b & 0x1) != 0x0;
            }
            return (this.b & 0x2) != 0x0;
        }
        else if (o instanceof aA) {
            final aA aa = (aA)o;
            if (aa.isVisible() && (aa.getOwner() == null || aa.getOwner().hasVisiblePath())) {
                return (this.e & 0x1) != 0x0;
            }
            return (this.e & 0x2) != 0x0;
        }
        else if (o instanceof x) {
            if (this.a.i(((x)o).a()).isVisible()) {
                return (this.d & 0x1) != 0x0;
            }
            return (this.d & 0x2) != 0x0;
        }
        else if (o instanceof fL) {
            if (((fL)o).d().isVisible()) {
                return (this.d & 0x1) != 0x0;
            }
            return (this.d & 0x2) != 0x0;
        }
        else if (o instanceof eR) {
            if (((eR)o).isVisible()) {
                return (this.c & 0x1) != 0x0;
            }
            return (this.c & 0x2) != 0x0;
        }
        else {
            if (!(o instanceof eU)) {
                return false;
            }
            if (((eU)o).b().isVisible()) {
                return (this.b & 0x1) != 0x0;
            }
            return (this.b & 0x2) != 0x0;
        }
    }
}
