package y.h;

import java.awt.*;

class hs extends Key
{
    hs() {
        super(6001);
    }
    
    public boolean isCompatibleValue(final Object o) {
        return o instanceof Double;
    }
    
    public String toString() {
        return "Paint detail threshold key";
    }
}
