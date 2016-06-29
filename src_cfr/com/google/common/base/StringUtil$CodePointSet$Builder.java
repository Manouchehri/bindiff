/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.StringUtil$1;
import com.google.common.base.StringUtil$CodePointSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class StringUtil$CodePointSet$Builder {
    Set codePoints = new HashSet();

    StringUtil$CodePointSet$Builder() {
    }

    StringUtil$CodePointSet$Builder addCodePoint(int n2) {
        this.codePoints.add(n2);
        return this;
    }

    StringUtil$CodePointSet$Builder addRange(int n2, int n3) {
        int n4 = n2;
        while (n4 <= n3) {
            this.codePoints.add(n4);
            ++n4;
        }
        return this;
    }

    StringUtil$CodePointSet$Builder addSet(StringUtil$CodePointSet stringUtil$CodePointSet) {
        Iterator iterator = stringUtil$CodePointSet.elements.iterator();
        while (iterator.hasNext()) {
            int n2 = (Integer)iterator.next();
            this.codePoints.add(n2);
        }
        return this;
    }

    StringUtil$CodePointSet create() {
        return new StringUtil$CodePointSet(this.codePoints, null);
    }
}

