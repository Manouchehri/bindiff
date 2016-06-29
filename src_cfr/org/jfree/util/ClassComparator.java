/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.Serializable;
import java.util.Comparator;

public class ClassComparator
implements Serializable,
Comparator {
    private static final long serialVersionUID = -5225335361837391120L;

    public int compare(Object object, Object object2) {
        Class class_ = (Class)object;
        Class class_2 = (Class)object2;
        if (class_.equals(object2)) {
            return 0;
        }
        if (class_.isAssignableFrom(class_2)) {
            return -1;
        }
        if (class_2.isAssignableFrom(class_2)) return 1;
        throw new IllegalArgumentException("The classes share no relation");
    }

    public boolean isComparable(Class class_, Class class_2) {
        if (class_.isAssignableFrom(class_2)) return true;
        if (class_2.isAssignableFrom(class_)) return true;
        return false;
    }
}

