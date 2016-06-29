package y.h.b;

import java.awt.*;
import y.h.*;
import y.d.*;

class N implements Y
{
    private final boolean a;
    
    N(final boolean a) {
        this.a = a;
    }
    
    public Stroke a(final fj fj) {
        if (this.h(fj)) {
            return this.g(fj);
        }
        return null;
    }
    
    public Color b(final fj fj) {
        if (this.h(fj)) {
            return fj.getLineColor();
        }
        return null;
    }
    
    public Color c(final fj fj) {
        return fj.getFillColor();
    }
    
    public Stroke d(final fj fj) {
        if (this.h(fj)) {
            return null;
        }
        return this.g(fj);
    }
    
    public Color e(final fj fj) {
        if (this.h(fj)) {
            return null;
        }
        return fj.getLineColor();
    }
    
    public Color f(final fj fj) {
        return fj.getFillColor();
    }
    
    private Stroke g(final fj fj) {
        final dr lineType = fj.getLineType();
        if (this.a) {
            return dr.a((int)Math.ceil(lineType.getLineWidth()) + 2, lineType.a());
        }
        return lineType;
    }
    
    private boolean h(final fj fj) {
        final r i = this.i(fj);
        return i.a > 0.0 || i.b > 0.0 || i.c > 0.0 || i.d > 0.0;
    }
    
    private r i(final fj fj) {
        if (fj instanceof a) {
            return ((a)fj).l().d();
        }
        return null;
    }
}
