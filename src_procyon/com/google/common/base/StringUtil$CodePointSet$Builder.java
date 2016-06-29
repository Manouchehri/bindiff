package com.google.common.base;

import java.util.*;

class StringUtil$CodePointSet$Builder
{
    Set codePoints;
    
    StringUtil$CodePointSet$Builder() {
        this.codePoints = new HashSet();
    }
    
    StringUtil$CodePointSet$Builder addCodePoint(final int n) {
        this.codePoints.add(n);
        return this;
    }
    
    StringUtil$CodePointSet$Builder addRange(final int n, final int n2) {
        for (int i = n; i <= n2; ++i) {
            this.codePoints.add(i);
        }
        return this;
    }
    
    StringUtil$CodePointSet$Builder addSet(final StringUtil$CodePointSet set) {
        final Iterator<Integer> iterator = set.elements.iterator();
        while (iterator.hasNext()) {
            this.codePoints.add((int)iterator.next());
        }
        return this;
    }
    
    StringUtil$CodePointSet create() {
        return new StringUtil$CodePointSet(this.codePoints, null);
    }
}
