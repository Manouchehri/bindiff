package org.ibex.nestedvm.util;

class Sort$1 implements Sort$CompareFunc
{
    public int compare(final Object o, final Object o2) {
        return ((Sort$Comparable)o).compareTo(o2);
    }
}
