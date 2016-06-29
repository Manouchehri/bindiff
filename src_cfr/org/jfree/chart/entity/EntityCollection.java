/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.util.Collection;
import java.util.Iterator;
import org.jfree.chart.entity.ChartEntity;

public interface EntityCollection {
    public void clear();

    public void add(ChartEntity var1);

    public void addAll(EntityCollection var1);

    public ChartEntity getEntity(double var1, double var3);

    public ChartEntity getEntity(int var1);

    public int getEntityCount();

    public Collection getEntities();

    public Iterator iterator();
}

