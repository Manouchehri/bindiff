package org.jfree.util;

public class BooleanList extends AbstractObjectList
{
    private static final long serialVersionUID = -8543170333219422042L;
    
    public Boolean getBoolean(final int n) {
        return (Boolean)this.get(n);
    }
    
    public void setBoolean(final int n, final Boolean b) {
        this.set(n, b);
    }
    
    public boolean equals(final Object o) {
        return o instanceof BooleanList && super.equals(o);
    }
    
    public int hashCode() {
        return super.hashCode();
    }
}
