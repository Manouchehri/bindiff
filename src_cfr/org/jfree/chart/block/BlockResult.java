/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.block;

import org.jfree.chart.block.EntityBlockResult;
import org.jfree.chart.entity.EntityCollection;

public class BlockResult
implements EntityBlockResult {
    private EntityCollection entities = null;

    @Override
    public EntityCollection getEntityCollection() {
        return this.entities;
    }

    public void setEntityCollection(EntityCollection entityCollection) {
        this.entities = entityCollection;
    }
}

