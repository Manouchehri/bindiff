/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.Sort$Comparable;
import org.ibex.nestedvm.util.Sort$CompareFunc;

class Sort$1
implements Sort$CompareFunc {
    Sort$1() {
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Sort$Comparable)object).compareTo(object2);
    }
}

