package org.ibex.nestedvm;

import java.io.*;

public class Runtime$SecurityManager
{
    public boolean allowRead(final File file) {
        return true;
    }
    
    public boolean allowWrite(final File file) {
        return true;
    }
    
    public boolean allowStat(final File file) {
        return true;
    }
    
    public boolean allowUnlink(final File file) {
        return true;
    }
}
