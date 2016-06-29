package org.jfree.data.xy;

import java.util.*;
import org.jfree.util.*;
import org.jfree.data.*;
import org.jfree.data.general.*;

public class DefaultTableXYDataset extends AbstractIntervalXYDataset implements DomainInfo, IntervalXYDataset, TableXYDataset
{
    private List data;
    private HashSet xPoints;
    private boolean propagateEvents;
    private boolean autoPrune;
    private IntervalXYDelegate intervalDelegate;
    
    public DefaultTableXYDataset() {
        this(false);
    }
    
    public DefaultTableXYDataset(final boolean autoPrune) {
        this.data = null;
        this.xPoints = null;
        this.propagateEvents = true;
        this.autoPrune = false;
        this.autoPrune = autoPrune;
        this.data = new ArrayList();
        this.xPoints = new HashSet();
        this.addChangeListener(this.intervalDelegate = new IntervalXYDelegate(this, false));
    }
    
    public boolean isAutoPrune() {
        return this.autoPrune;
    }
    
    public void addSeries(final XYSeries xySeries) {
        if (xySeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (xySeries.getAllowDuplicateXValues()) {
            throw new IllegalArgumentException("Cannot accept XYSeries that allow duplicate values. Use XYSeries(seriesName, <sort>, false) constructor.");
        }
        this.updateXPoints(xySeries);
        this.data.add(xySeries);
        xySeries.addChangeListener(this);
        this.fireDatasetChanged();
    }
    
    private void updateXPoints(final XYSeries xySeries) {
        if (xySeries == null) {
            throw new IllegalArgumentException("Null 'series' not permitted.");
        }
        final HashSet set = new HashSet<Number>();
        final boolean propagateEvents = this.propagateEvents;
        this.propagateEvents = false;
        for (int i = 0; i < xySeries.getItemCount(); ++i) {
            final Number x = xySeries.getX(i);
            set.add(x);
            if (!this.xPoints.contains(x)) {
                this.xPoints.add(x);
                for (int size = this.data.size(), j = 0; j < size; ++j) {
                    final XYSeries xySeries2 = this.data.get(j);
                    if (!xySeries2.equals(xySeries)) {
                        xySeries2.add(x, null);
                    }
                }
            }
        }
        for (final Number n : this.xPoints) {
            if (!set.contains(n)) {
                xySeries.add(n, null);
            }
        }
        this.propagateEvents = propagateEvents;
    }
    
    public void updateXPoints() {
        this.propagateEvents = false;
        for (int i = 0; i < this.data.size(); ++i) {
            this.updateXPoints((XYSeries)this.data.get(i));
        }
        if (this.autoPrune) {
            this.prune();
        }
        this.propagateEvents = true;
    }
    
    public int getSeriesCount() {
        return this.data.size();
    }
    
    public int getItemCount() {
        if (this.xPoints == null) {
            return 0;
        }
        return this.xPoints.size();
    }
    
    public XYSeries getSeries(final int n) {
        if (n < 0 || n >= this.getSeriesCount()) {
            throw new IllegalArgumentException("Index outside valid range.");
        }
        return this.data.get(n);
    }
    
    public Comparable getSeriesKey(final int n) {
        return this.getSeries(n).getKey();
    }
    
    public int getItemCount(final int n) {
        return this.getSeries(n).getItemCount();
    }
    
    public Number getX(final int n, final int n2) {
        return this.data.get(n).getDataItem(n2).getX();
    }
    
    public Number getStartX(final int n, final int n2) {
        return this.intervalDelegate.getStartX(n, n2);
    }
    
    public Number getEndX(final int n, final int n2) {
        return this.intervalDelegate.getEndX(n, n2);
    }
    
    public Number getY(final int n, final int n2) {
        return this.data.get(n).getDataItem(n2).getY();
    }
    
    public Number getStartY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public Number getEndY(final int n, final int n2) {
        return this.getY(n, n2);
    }
    
    public void removeAllSeries() {
        for (int i = 0; i < this.data.size(); ++i) {
            ((XYSeries)this.data.get(i)).removeChangeListener(this);
        }
        this.data.clear();
        this.xPoints.clear();
        this.fireDatasetChanged();
    }
    
    public void removeSeries(final XYSeries xySeries) {
        if (xySeries == null) {
            throw new IllegalArgumentException("Null 'series' argument.");
        }
        if (this.data.contains(xySeries)) {
            xySeries.removeChangeListener(this);
            this.data.remove(xySeries);
            if (this.data.size() == 0) {
                this.xPoints.clear();
            }
            this.fireDatasetChanged();
        }
    }
    
    public void removeSeries(final int n) {
        if (n < 0 || n > this.getSeriesCount()) {
            throw new IllegalArgumentException("Index outside valid range.");
        }
        this.data.get(n).removeChangeListener(this);
        this.data.remove(n);
        if (this.data.size() == 0) {
            this.xPoints.clear();
        }
        else if (this.autoPrune) {
            this.prune();
        }
        this.fireDatasetChanged();
    }
    
    public void removeAllValuesForX(final Number n) {
        if (n == null) {
            throw new IllegalArgumentException("Null 'x' argument.");
        }
        final boolean propagateEvents = this.propagateEvents;
        this.propagateEvents = false;
        for (int i = 0; i < this.data.size(); ++i) {
            ((XYSeries)this.data.get(i)).remove(n);
        }
        this.propagateEvents = propagateEvents;
        this.xPoints.remove(n);
        this.fireDatasetChanged();
    }
    
    protected boolean canPrune(final Number n) {
        for (int i = 0; i < this.data.size(); ++i) {
            final XYSeries xySeries = this.data.get(i);
            if (xySeries.getY(xySeries.indexOf(n)) != null) {
                return false;
            }
        }
        return true;
    }
    
    public void prune() {
        for (final Number n : (HashSet)this.xPoints.clone()) {
            if (this.canPrune(n)) {
                this.removeAllValuesForX(n);
            }
        }
    }
    
    public void seriesChanged(final SeriesChangeEvent seriesChangeEvent) {
        if (this.propagateEvents) {
            this.updateXPoints();
            this.fireDatasetChanged();
        }
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DefaultTableXYDataset)) {
            return false;
        }
        final DefaultTableXYDataset defaultTableXYDataset = (DefaultTableXYDataset)o;
        return this.autoPrune == defaultTableXYDataset.autoPrune && this.propagateEvents == defaultTableXYDataset.propagateEvents && this.intervalDelegate.equals(defaultTableXYDataset.intervalDelegate) && ObjectUtilities.equal(this.data, defaultTableXYDataset.data);
    }
    
    public int hashCode() {
        return 29 * (29 * (29 * ((this.data != null) ? this.data.hashCode() : 0) + ((this.xPoints != null) ? this.xPoints.hashCode() : 0)) + (this.propagateEvents ? 1 : 0)) + (this.autoPrune ? 1 : 0);
    }
    
    public double getDomainLowerBound(final boolean b) {
        return this.intervalDelegate.getDomainLowerBound(b);
    }
    
    public double getDomainUpperBound(final boolean b) {
        return this.intervalDelegate.getDomainUpperBound(b);
    }
    
    public Range getDomainBounds(final boolean b) {
        if (b) {
            return this.intervalDelegate.getDomainBounds(b);
        }
        return DatasetUtilities.iterateDomainBounds(this, b);
    }
    
    public double getIntervalPositionFactor() {
        return this.intervalDelegate.getIntervalPositionFactor();
    }
    
    public void setIntervalPositionFactor(final double intervalPositionFactor) {
        this.intervalDelegate.setIntervalPositionFactor(intervalPositionFactor);
        this.fireDatasetChanged();
    }
    
    public double getIntervalWidth() {
        return this.intervalDelegate.getIntervalWidth();
    }
    
    public void setIntervalWidth(final double fixedIntervalWidth) {
        this.intervalDelegate.setFixedIntervalWidth(fixedIntervalWidth);
        this.fireDatasetChanged();
    }
    
    public boolean isAutoWidth() {
        return this.intervalDelegate.isAutoWidth();
    }
    
    public void setAutoWidth(final boolean autoWidth) {
        this.intervalDelegate.setAutoWidth(autoWidth);
        this.fireDatasetChanged();
    }
}
