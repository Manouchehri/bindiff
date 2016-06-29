package org.jfree.chart.entity;

import java.io.*;
import org.jfree.data.general.*;
import java.awt.*;

public class PieSectionEntity extends ChartEntity implements Serializable
{
    private static final long serialVersionUID = 9199892576531984162L;
    private PieDataset dataset;
    private int pieIndex;
    private int sectionIndex;
    private Comparable sectionKey;
    
    public PieSectionEntity(final Shape shape, final PieDataset dataset, final int pieIndex, final int sectionIndex, final Comparable sectionKey, final String s, final String s2) {
        super(shape, s, s2);
        this.dataset = dataset;
        this.pieIndex = pieIndex;
        this.sectionIndex = sectionIndex;
        this.sectionKey = sectionKey;
    }
    
    public PieDataset getDataset() {
        return this.dataset;
    }
    
    public void setDataset(final PieDataset dataset) {
        this.dataset = dataset;
    }
    
    public int getPieIndex() {
        return this.pieIndex;
    }
    
    public void setPieIndex(final int pieIndex) {
        this.pieIndex = pieIndex;
    }
    
    public int getSectionIndex() {
        return this.sectionIndex;
    }
    
    public void setSectionIndex(final int sectionIndex) {
        this.sectionIndex = sectionIndex;
    }
    
    public Comparable getSectionKey() {
        return this.sectionKey;
    }
    
    public void setSectionKey(final Comparable sectionKey) {
        this.sectionKey = sectionKey;
    }
    
    public String toString() {
        return "PieSection: " + this.pieIndex + ", " + this.sectionIndex + "(" + this.sectionKey.toString() + ")";
    }
}
