package org.jfree.chart.block;

import org.jfree.chart.entity.*;

public class BlockResult implements EntityBlockResult
{
    private EntityCollection entities;
    
    public BlockResult() {
        this.entities = null;
    }
    
    public EntityCollection getEntityCollection() {
        return this.entities;
    }
    
    public void setEntityCollection(final EntityCollection entities) {
        this.entities = entities;
    }
}
