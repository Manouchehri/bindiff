package y.f;

import java.util.*;
import y.d.*;

public class u implements I
{
    private ArrayList a;
    private t b;
    private t c;
    
    public u() {
        this.b = t.c;
        this.c = t.c;
        this.a = new ArrayList(5);
    }
    
    public u(final I i) {
        final boolean j = X.j;
        this();
        int k = 0;
        while (k < i.pointCount()) {
            this.a.add(i.getPoint(k));
            ++k;
            if (j) {
                return;
            }
            if (j) {
                break;
            }
        }
        this.b = i.getSourcePoint();
        this.c = i.getTargetPoint();
    }
    
    public int pointCount() {
        return this.a.size();
    }
    
    public t getPoint(final int n) {
        return this.a.get(n);
    }
    
    public void setPoint(final int n, final double n2, final double n3) {
        this.a.set(n, new t(n2, n3));
    }
    
    public void addPoint(final double n, final double n2) {
        this.a.add(new t(n, n2));
    }
    
    public void clearPoints() {
        this.a.clear();
    }
    
    public t getSourcePoint() {
        return this.b;
    }
    
    public t getTargetPoint() {
        return this.c;
    }
    
    public void setSourcePoint(final t b) {
        this.b = b;
    }
    
    public void setTargetPoint(final t c) {
        this.c = c;
    }
}
