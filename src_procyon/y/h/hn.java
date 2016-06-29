package y.h;

import java.awt.*;

class hn extends Key
{
    hn() {
        super(6002);
    }
    
    public boolean isCompatibleValue(final Object o) {
        return o instanceof cV;
    }
    
    public String toString() {
        return "Graphics context key";
    }
}
