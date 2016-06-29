/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.chart.title;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.EventListener;
import javax.swing.event.EventListenerList;
import org.jfree.chart.block.AbstractBlock;
import org.jfree.chart.block.Block;
import org.jfree.chart.event.TitleChangeEvent;
import org.jfree.chart.event.TitleChangeListener;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.VerticalAlignment;
import org.jfree.util.ObjectUtilities;

public abstract class Title
extends AbstractBlock
implements Serializable,
Cloneable,
Block {
    private static final long serialVersionUID = -6675162505277817221L;
    public static final RectangleEdge DEFAULT_POSITION = RectangleEdge.TOP;
    public static final HorizontalAlignment DEFAULT_HORIZONTAL_ALIGNMENT = HorizontalAlignment.CENTER;
    public static final VerticalAlignment DEFAULT_VERTICAL_ALIGNMENT = VerticalAlignment.CENTER;
    public static final RectangleInsets DEFAULT_PADDING = new RectangleInsets(1.0, 1.0, 1.0, 1.0);
    private RectangleEdge position;
    private HorizontalAlignment horizontalAlignment;
    private VerticalAlignment verticalAlignment;
    private transient EventListenerList listenerList;
    private boolean notify;
    static Class class$org$jfree$chart$event$TitleChangeListener;

    protected Title() {
        this(DEFAULT_POSITION, DEFAULT_HORIZONTAL_ALIGNMENT, DEFAULT_VERTICAL_ALIGNMENT, DEFAULT_PADDING);
    }

    protected Title(RectangleEdge rectangleEdge, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) {
        this(rectangleEdge, horizontalAlignment, verticalAlignment, DEFAULT_PADDING);
    }

    protected Title(RectangleEdge rectangleEdge, HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment, RectangleInsets rectangleInsets) {
        if (rectangleEdge == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        if (horizontalAlignment == null) {
            throw new IllegalArgumentException("Null 'horizontalAlignment' argument.");
        }
        if (verticalAlignment == null) {
            throw new IllegalArgumentException("Null 'verticalAlignment' argument.");
        }
        if (rectangleInsets == null) {
            throw new IllegalArgumentException("Null 'spacer' argument.");
        }
        this.position = rectangleEdge;
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.setPadding(rectangleInsets);
        this.listenerList = new EventListenerList();
        this.notify = true;
    }

    public RectangleEdge getPosition() {
        return this.position;
    }

    public void setPosition(RectangleEdge rectangleEdge) {
        if (rectangleEdge == null) {
            throw new IllegalArgumentException("Null 'position' argument.");
        }
        if (this.position == rectangleEdge) return;
        this.position = rectangleEdge;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public HorizontalAlignment getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment == null) {
            throw new IllegalArgumentException("Null 'alignment' argument.");
        }
        if (this.horizontalAlignment == horizontalAlignment) return;
        this.horizontalAlignment = horizontalAlignment;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public VerticalAlignment getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
        if (verticalAlignment == null) {
            throw new IllegalArgumentException("Null 'alignment' argument.");
        }
        if (this.verticalAlignment == verticalAlignment) return;
        this.verticalAlignment = verticalAlignment;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    public boolean getNotify() {
        return this.notify;
    }

    public void setNotify(boolean bl2) {
        this.notify = bl2;
        if (!bl2) return;
        this.notifyListeners(new TitleChangeEvent(this));
    }

    @Override
    public abstract void draw(Graphics2D var1, Rectangle2D var2);

    @Override
    public Object clone() {
        Title title = (Title)super.clone();
        title.listenerList = new EventListenerList();
        return title;
    }

    public void addChangeListener(TitleChangeListener titleChangeListener) {
        Class class_ = class$org$jfree$chart$event$TitleChangeListener == null ? (Title.class$org$jfree$chart$event$TitleChangeListener = Title.class$("org.jfree.chart.event.TitleChangeListener")) : class$org$jfree$chart$event$TitleChangeListener;
        this.listenerList.add(class_, titleChangeListener);
    }

    public void removeChangeListener(TitleChangeListener titleChangeListener) {
        Class class_ = class$org$jfree$chart$event$TitleChangeListener == null ? (Title.class$org$jfree$chart$event$TitleChangeListener = Title.class$("org.jfree.chart.event.TitleChangeListener")) : class$org$jfree$chart$event$TitleChangeListener;
        this.listenerList.remove(class_, titleChangeListener);
    }

    protected void notifyListeners(TitleChangeEvent titleChangeEvent) {
        if (!this.notify) return;
        Object[] arrobject = this.listenerList.getListenerList();
        int n2 = arrobject.length - 2;
        while (n2 >= 0) {
            if (arrobject[n2] == (class$org$jfree$chart$event$TitleChangeListener == null ? Title.class$("org.jfree.chart.event.TitleChangeListener") : class$org$jfree$chart$event$TitleChangeListener)) {
                ((TitleChangeListener)arrobject[n2 + 1]).titleChanged(titleChangeEvent);
            }
            n2 -= 2;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Title)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Title title = (Title)object;
        if (this.position != title.position) {
            return false;
        }
        if (this.horizontalAlignment != title.horizontalAlignment) {
            return false;
        }
        if (this.verticalAlignment != title.verticalAlignment) {
            return false;
        }
        if (this.notify == title.notify) return true;
        return false;
    }

    public int hashCode() {
        int n2 = 193;
        n2 = 37 * n2 + ObjectUtilities.hashCode(this.position);
        n2 = 37 * n2 + ObjectUtilities.hashCode(this.horizontalAlignment);
        return 37 * n2 + ObjectUtilities.hashCode(this.verticalAlignment);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.listenerList = new EventListenerList();
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

