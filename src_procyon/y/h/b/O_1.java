package y.h.b;

import java.awt.*;
import y.h.*;

class O implements Y
{
    private final boolean a;
    
    O(final boolean a) {
        this.a = a;
    }
    
    public Stroke a(final fj fj) {
        return null;
    }
    
    public Color b(final fj fj) {
        return null;
    }
    
    public Color c(final fj fj) {
        return null;
    }
    
    public Stroke d(final fj fj) {
        final dr lineType = fj.getLineType();
        if (this.a) {
            return dr.a((int)Math.ceil(lineType.getLineWidth()) + 2, lineType.a());
        }
        return lineType;
    }
    
    public Color e(final fj fj) {
        return fj.getLineColor();
    }
    
    public Color f(final fj fj) {
        return fj.getFillColor2();
    }
}
