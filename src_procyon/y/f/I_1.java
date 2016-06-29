package y.f;

import y.d.*;

public interface I
{
    int pointCount();
    
    t getPoint(final int p0);
    
    void setPoint(final int p0, final double p1, final double p2);
    
    void addPoint(final double p0, final double p1);
    
    void clearPoints();
    
    t getSourcePoint();
    
    t getTargetPoint();
    
    void setSourcePoint(final t p0);
    
    void setTargetPoint(final t p0);
}
