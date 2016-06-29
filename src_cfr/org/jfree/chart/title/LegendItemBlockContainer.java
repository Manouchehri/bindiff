/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.title;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import org.jfree.chart.block.Arrangement;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BlockResult;
import org.jfree.chart.block.EntityBlockParams;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.chart.entity.StandardEntityCollection;

public class LegendItemBlockContainer
extends BlockContainer {
    private int dataset;
    private int series;
    private String toolTipText;
    private String urlText;

    public LegendItemBlockContainer(Arrangement arrangement, int n2, int n3) {
        super(arrangement);
        this.dataset = n2;
        this.series = n3;
    }

    public int getDatasetIndex() {
        return this.dataset;
    }

    public int getSeriesIndex() {
        return this.series;
    }

    public String getToolTipText() {
        return this.toolTipText;
    }

    public void setToolTipText(String string) {
        this.toolTipText = string;
    }

    public String getURLText() {
        return this.urlText;
    }

    public void setURLText(String string) {
        this.urlText = string;
    }

    @Override
    public Object draw(Graphics2D graphics2D, Rectangle2D rectangle2D, Object object) {
        super.draw(graphics2D, rectangle2D, null);
        EntityBlockParams entityBlockParams = null;
        BlockResult blockResult = new BlockResult();
        if (!(object instanceof EntityBlockParams)) return blockResult;
        entityBlockParams = (EntityBlockParams)object;
        if (!entityBlockParams.getGenerateEntities()) return blockResult;
        StandardEntityCollection standardEntityCollection = new StandardEntityCollection();
        LegendItemEntity legendItemEntity = new LegendItemEntity((Shape)rectangle2D.clone());
        legendItemEntity.setSeriesIndex(this.series);
        legendItemEntity.setToolTipText(this.getToolTipText());
        legendItemEntity.setURLText(this.getURLText());
        standardEntityCollection.add(legendItemEntity);
        blockResult.setEntityCollection(standardEntityCollection);
        return blockResult;
    }
}

