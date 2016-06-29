package org.jfree.data;

public final class KeyedValueComparatorType
{
    public static final KeyedValueComparatorType BY_KEY;
    public static final KeyedValueComparatorType BY_VALUE;
    private String name;
    
    private KeyedValueComparatorType(final String name) {
        this.name = name;
    }
    
    public String toString() {
        return this.name;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof KeyedValueComparatorType && this.name.equals(((KeyedValueComparatorType)o).name));
    }
    
    public int hashCode() {
        return this.name.hashCode();
    }
    
    static {
        BY_KEY = new KeyedValueComparatorType("KeyedValueComparatorType.BY_KEY");
        BY_VALUE = new KeyedValueComparatorType("KeyedValueComparatorType.BY_VALUE");
    }
}
