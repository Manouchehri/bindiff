package org.ibex.nestedvm;

import org.ibex.nestedvm.util.*;

class UnixRuntime$GlobalState$MP implements Sort$Comparable
{
    public String path;
    public UnixRuntime$FS fs;
    
    public UnixRuntime$GlobalState$MP(final String path, final UnixRuntime$FS fs) {
        this.path = path;
        this.fs = fs;
    }
    
    public int compareTo(final Object o) {
        if (!(o instanceof UnixRuntime$GlobalState$MP)) {
            return 1;
        }
        return -this.path.compareTo(((UnixRuntime$GlobalState$MP)o).path);
    }
}
