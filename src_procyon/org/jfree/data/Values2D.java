package org.jfree.data;

public interface Values2D
{
    int getRowCount();
    
    int getColumnCount();
    
    Number getValue(final int p0, final int p1);
}
