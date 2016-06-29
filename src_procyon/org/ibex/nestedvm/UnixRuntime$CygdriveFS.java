package org.ibex.nestedvm;

import java.io.*;

public class UnixRuntime$CygdriveFS extends UnixRuntime$HostFS
{
    protected File hostFile(String string) {
        final char char1 = string.charAt(0);
        if (char1 < 'a' || char1 > 'z' || string.charAt(1) != '/') {
            return null;
        }
        string = char1 + ":" + string.substring(1).replace('/', '\\');
        return new File(string);
    }
    
    public UnixRuntime$CygdriveFS() {
        super("/");
    }
}
