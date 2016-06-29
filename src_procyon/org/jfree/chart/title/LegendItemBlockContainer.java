package org.jfree.chart.title;

import java.awt.geom.*;
import org.jfree.chart.block.*;
import java.awt.*;
import org.jfree.chart.entity.*;

public class LegendItemBlockContainer extends BlockContainer
{
    private int dataset;
    private int series;
    private String toolTipText;
    private String urlText;
    
    public LegendItemBlockContainer(final Arrangement arrangement, final int dataset, final int series) {
        super(arrangement);
        this.dataset = dataset;
        this.series = series;
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
    
    public void setToolTipText(final String toolTipText) {
        this.toolTipText = toolTipText;
    }
    
    public String getURLText() {
        return this.urlText;
    }
    
    public void setURLText(final String urlText) {
        this.urlText = urlText;
    }
    
    public Object draw(final Graphics2D graphics2D, final Rectangle2D rectangle2D, final Object o) {
        super.draw(graphics2D, rectangle2D, null);
        final BlockResult blockResult = new BlockResult();
        if (o instanceof EntityBlockParams && ((EntityBlockParams)o).getGenerateEntities()) {
            final StandardEntityCollection entityCollection = new StandardEntityCollection();
            final LegendItemEntity legendItemEntity = new LegendItemEntity((Shape)rectangle2D.clone());
            legendItemEntity.setSeriesIndex(this.series);
            legendItemEntity.setToolTipText(this.getToolTipText());
            legendItemEntity.setURLText(this.getURLText());
            entityCollection.add(legendItemEntity);
            blockResult.setEntityCollection(entityCollection);
        }
        return blockResult;
    }
}
