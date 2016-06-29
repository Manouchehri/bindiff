package org.jfree.chart.entity;

import java.io.*;
import java.util.*;
import org.jfree.util.*;

public class StandardEntityCollection implements Serializable, Cloneable, EntityCollection, PublicCloneable
{
    private static final long serialVersionUID = 5384773031184897047L;
    private List entities;
    
    public StandardEntityCollection() {
        this.entities = new ArrayList();
    }
    
    public int getEntityCount() {
        return this.entities.size();
    }
    
    public ChartEntity getEntity(final int n) {
        return this.entities.get(n);
    }
    
    public void clear() {
        this.entities.clear();
    }
    
    public void add(final ChartEntity chartEntity) {
        if (chartEntity == null) {
            throw new IllegalArgumentException("Null 'entity' argument.");
        }
        this.entities.add(chartEntity);
    }
    
    public void addAll(final EntityCollection collection) {
        this.entities.addAll(collection.getEntities());
    }
    
    public ChartEntity getEntity(final double n, final double n2) {
        for (int i = this.entities.size() - 1; i >= 0; --i) {
            final ChartEntity chartEntity = this.entities.get(i);
            if (chartEntity.getArea().contains(n, n2)) {
                return chartEntity;
            }
        }
        return null;
    }
    
    public Collection getEntities() {
        return Collections.unmodifiableCollection((Collection<?>)this.entities);
    }
    
    public Iterator iterator() {
        return this.entities.iterator();
    }
    
    public boolean equals(final Object o) {
        return o == this || (o instanceof StandardEntityCollection && ObjectUtilities.equal(this.entities, ((StandardEntityCollection)o).entities));
    }
    
    public Object clone() {
        final StandardEntityCollection collection = (StandardEntityCollection)super.clone();
        collection.entities = new ArrayList(this.entities.size());
        for (int i = 0; i < this.entities.size(); ++i) {
            collection.entities.add(((ChartEntity)this.entities.get(i)).clone());
        }
        return collection;
    }
}
