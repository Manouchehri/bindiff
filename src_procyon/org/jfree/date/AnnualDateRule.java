package org.jfree.date;

public abstract class AnnualDateRule implements Cloneable
{
    public abstract SerialDate getDate(final int p0);
    
    public Object clone() {
        return super.clone();
    }
}
