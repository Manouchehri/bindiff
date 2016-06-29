/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.File;
import org.ibex.nestedvm.UnixRuntime$HostFS;

public class UnixRuntime$CygdriveFS
extends UnixRuntime$HostFS {
    @Override
    protected File hostFile(String string) {
        char c2 = string.charAt(0);
        if (c2 < 'a') return null;
        if (c2 > 'z') return null;
        if (string.charAt(1) != '/') {
            return null;
        }
        string = new StringBuffer().append(c2).append(":").append(string.substring(1).replace('/', '\\')).toString();
        return new File(string);
    }

    public UnixRuntime$CygdriveFS() {
        super("/");
    }
}

