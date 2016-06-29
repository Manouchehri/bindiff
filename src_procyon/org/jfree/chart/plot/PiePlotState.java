package org.jfree.chart.plot;

import org.jfree.chart.renderer.*;
import java.awt.geom.*;

public class PiePlotState extends RendererState
{
    private int passesRequired;
    private double total;
    private double latestAngle;
    private Rectangle2D explodedPieArea;
    private Rectangle2D pieArea;
    private double pieCenterX;
    private double pieCenterY;
    private double pieHRadius;
    private double pieWRadius;
    private Rectangle2D linkArea;
    
    public PiePlotState(final PlotRenderingInfo plotRenderingInfo) {
        super(plotRenderingInfo);
        this.passesRequired = 1;
        this.total = 0.0;
    }
    
    public int getPassesRequired() {
        return this.passesRequired;
    }
    
    public void setPassesRequired(final int passesRequired) {
        this.passesRequired = passesRequired;
    }
    
    public double getTotal() {
        return this.total;
    }
    
    public void setTotal(final double total) {
        this.total = total;
    }
    
    public double getLatestAngle() {
        return this.latestAngle;
    }
    
    public void setLatestAngle(final double latestAngle) {
        this.latestAngle = latestAngle;
    }
    
    public Rectangle2D getPieArea() {
        return this.pieArea;
    }
    
    public void setPieArea(final Rectangle2D pieArea) {
        this.pieArea = pieArea;
    }
    
    public Rectangle2D getExplodedPieArea() {
        return this.explodedPieArea;
    }
    
    public void setExplodedPieArea(final Rectangle2D explodedPieArea) {
        this.explodedPieArea = explodedPieArea;
    }
    
    public double getPieCenterX() {
        return this.pieCenterX;
    }
    
    public void setPieCenterX(final double pieCenterX) {
        this.pieCenterX = pieCenterX;
    }
    
    public double getPieCenterY() {
        return this.pieCenterY;
    }
    
    public void setPieCenterY(final double pieCenterY) {
        this.pieCenterY = pieCenterY;
    }
    
    public Rectangle2D getLinkArea() {
        return this.linkArea;
    }
    
    public void setLinkArea(final Rectangle2D linkArea) {
        this.linkArea = linkArea;
    }
    
    public double getPieHRadius() {
        return this.pieHRadius;
    }
    
    public void setPieHRadius(final double pieHRadius) {
        this.pieHRadius = pieHRadius;
    }
    
    public double getPieWRadius() {
        return this.pieWRadius;
    }
    
    public void setPieWRadius(final double pieWRadius) {
        this.pieWRadius = pieWRadius;
    }
}
