package org.jfree.data.general;

public interface Dataset
{
    void addChangeListener(final DatasetChangeListener p0);
    
    void removeChangeListener(final DatasetChangeListener p0);
    
    DatasetGroup getGroup();
    
    void setGroup(final DatasetGroup p0);
}
