/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.util.ObjectUtilities;
import org.jfree.util.PublicCloneable;

public class StandardEntityCollection
implements Serializable,
Cloneable,
EntityCollection,
PublicCloneable {
    private static final long serialVersionUID = 5384773031184897047L;
    private List entities = new ArrayList();

    @Override
    public int getEntityCount() {
        return this.entities.size();
    }

    @Override
    public ChartEntity getEntity(int n2) {
        return (ChartEntity)this.entities.get(n2);
    }

    @Override
    public void clear() {
        this.entities.clear();
    }

    @Override
    public void add(ChartEntity chartEntity) {
        if (chartEntity == null) {
            throw new IllegalArgumentException("Null 'entity' argument.");
        }
        this.entities.add(chartEntity);
    }

    @Override
    public void addAll(EntityCollection entityCollection) {
        this.entities.addAll(entityCollection.getEntities());
    }

    @Override
    public ChartEntity getEntity(double d2, double d3) {
        int n2 = this.entities.size();
        int n3 = n2 - 1;
        while (n3 >= 0) {
            ChartEntity chartEntity = (ChartEntity)this.entities.get(n3);
            if (chartEntity.getArea().contains(d2, d3)) {
                return chartEntity;
            }
            --n3;
        }
        return null;
    }

    @Override
    public Collection getEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public Iterator iterator() {
        return this.entities.iterator();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StandardEntityCollection)) return false;
        StandardEntityCollection standardEntityCollection = (StandardEntityCollection)object;
        return ObjectUtilities.equal(this.entities, standardEntityCollection.entities);
    }

    @Override
    public Object clone() {
        StandardEntityCollection standardEntityCollection = (StandardEntityCollection)super.clone();
        standardEntityCollection.entities = new ArrayList(this.entities.size());
        int n2 = 0;
        while (n2 < this.entities.size()) {
            ChartEntity chartEntity = (ChartEntity)this.entities.get(n2);
            standardEntityCollection.entities.add(chartEntity.clone());
            ++n2;
        }
        return standardEntityCollection;
    }
}

