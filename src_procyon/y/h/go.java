package y.h;

import java.awt.*;

final class go extends Key
{
    go() {
        super(0);
    }
    
    public boolean isCompatibleValue(final Object o) {
        return o == null || o instanceof gp;
    }
    
    public String toString() {
        return "Sloppy rect painting enable key";
    }
}
