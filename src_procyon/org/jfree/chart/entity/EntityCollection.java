package org.jfree.chart.entity;

import java.util.*;

public interface EntityCollection
{
    void clear();
    
    void add(final ChartEntity p0);
    
    void addAll(final EntityCollection p0);
    
    ChartEntity getEntity(final double p0, final double p1);
    
    ChartEntity getEntity(final int p0);
    
    int getEntityCount();
    
    Collection getEntities();
    
    Iterator iterator();
}
