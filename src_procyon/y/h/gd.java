package y.h;

import java.util.*;
import java.awt.geom.*;
import y.c.*;
import java.awt.*;
import y.e.*;
import java.io.*;

public class gd extends gn
{
    private List a;
    private fj b;
    
    public gd() {
        this.a = new ArrayList();
        this.a = new ArrayList();
        this.b = null;
    }
    
    public gd(final fj fj) {
        final boolean z = fj.z;
        super(fj);
        this.a = new ArrayList();
        this.a = new ArrayList();
        if (fj instanceof gd) {
            final gd gd = (gd)fj;
            int i = 0;
            while (i < gd.a()) {
                final fj a = gd.a(i);
                final fj copy = a.createCopy();
                this.a.add(copy);
                if (a == gd.e()) {
                    this.b(copy);
                }
                ++i;
                if (z) {
                    break;
                }
            }
        }
    }
    
    public fj createCopy(final fj fj) {
        return new gd(fj);
    }
    
    public void a(final fj fj) {
        this.a.add(fj);
    }
    
    public int a() {
        return this.a.size();
    }
    
    public fj a(final int n) {
        return this.a.get(n);
    }
    
    public fj e() {
        return this.b;
    }
    
    public void b(final fj b) {
        final fj b2 = this.b;
        Label_0030: {
            if (b == this || b == null) {
                this.b = null;
                if (!fj.z) {
                    break Label_0030;
                }
            }
            this.b = b;
        }
        final q node = this.getNode();
        this.b(node);
        if (node != null && this.b != b2) {
            final bu d = this.d();
            if (d != null) {
                d.a(node, "realizer", this, this);
            }
        }
    }
    
    void b(final q q) {
        super.b(q);
        if (this.b != null) {
            this.b.b(q);
        }
    }
    
    public void setFillColor(final Color color) {
        if (this.b == null) {
            super.setFillColor(color);
            if (!fj.z) {
                return;
            }
        }
        this.b.setFillColor(color);
    }
    
    public Color getFillColor() {
        return (this.b == null) ? super.getFillColor() : this.b.getFillColor();
    }
    
    public void setFillColor2(final Color color) {
        if (this.b == null) {
            super.setFillColor2(color);
            if (!fj.z) {
                return;
            }
        }
        this.b.setFillColor2(color);
    }
    
    public Color getFillColor2() {
        return (this.b == null) ? super.getFillColor2() : this.b.getFillColor2();
    }
    
    public void setLineColor(final Color color) {
        if (this.b == null) {
            super.setLineColor(color);
            if (!fj.z) {
                return;
            }
        }
        this.b.setLineColor(color);
    }
    
    public Color getLineColor() {
        return (this.b == null) ? super.getLineColor() : this.b.getLineColor();
    }
    
    public void setLineType(final dr dr) {
        if (this.b == null) {
            super.setLineType(dr);
            if (!fj.z) {
                return;
            }
        }
        this.b.setLineType(dr);
    }
    
    public dr getLineType() {
        return (this.b == null) ? super.getLineType() : this.b.getLineType();
    }
    
    public void setTransparent(final boolean b) {
        if (this.b == null) {
            super.setTransparent(b);
            if (!fj.z) {
                return;
            }
        }
        this.b.setTransparent(b);
    }
    
    public boolean isTransparent() {
        return (this.b == null) ? super.isTransparent() : this.b.isTransparent();
    }
    
    public void setShapeType(final byte b) {
        if (this.b instanceof gn) {
            ((gn)this.b).setShapeType(b);
            if (!fj.z) {
                return;
            }
        }
        super.setShapeType(b);
    }
    
    public byte getShapeType() {
        if (this.b instanceof gn) {
            return ((gn)this.b).getShapeType();
        }
        return super.getShapeType();
    }
    
    public void setLabelText(final String s) {
        if (this.b == null) {
            super.setLabelText(s);
            if (!fj.z) {
                return;
            }
        }
        this.b.setLabelText(s);
    }
    
    public String getLabelText() {
        return (this.b == null) ? super.getLabelText() : this.b.getLabelText();
    }
    
    public eR createNodeLabel() {
        return (this.b == null) ? super.createNodeLabel() : this.b.createNodeLabel();
    }
    
    public void setLabel(final eR er) {
        if (this.b == null) {
            super.setLabel(er);
            if (!fj.z) {
                return;
            }
        }
        this.b.setLabel(er);
    }
    
    public void addLabel(final eR er) {
        if (this.b == null) {
            super.addLabel(er);
            if (!fj.z) {
                return;
            }
        }
        this.b.addLabel(er);
    }
    
    public void removeLabel(final eR er) {
        if (this.b == null) {
            super.removeLabel(er);
            if (!fj.z) {
                return;
            }
        }
        this.b.removeLabel(er);
    }
    
    public void removeLabel(final int n) {
        if (this.b == null) {
            super.removeLabel(n);
            if (!fj.z) {
                return;
            }
        }
        this.b.removeLabel(n);
    }
    
    public eR getLabel() {
        return (this.b == null) ? super.getLabel() : this.b.getLabel();
    }
    
    public eR getLabel(final int n) {
        return (this.b == null) ? super.getLabel(n) : this.b.getLabel(n);
    }
    
    public int labelCount() {
        return (this.b == null) ? super.labelCount() : this.b.labelCount();
    }
    
    public void addPort(final eU eu) {
        if (this.b == null) {
            super.addPort(eu);
            if (!fj.z) {
                return;
            }
        }
        this.b.addPort(eu);
    }
    
    public void removePort(final int n) {
        if (this.b == null) {
            super.removePort(n);
            if (!fj.z) {
                return;
            }
        }
        this.b.removePort(n);
    }
    
    public void removePort(final eU eu) {
        if (this.b == null) {
            super.removePort(eu);
            if (!fj.z) {
                return;
            }
        }
        this.b.removePort(eu);
    }
    
    public eU getPort(final int n) {
        if (this.b == null) {
            return super.getPort(n);
        }
        return this.b.getPort(n);
    }
    
    public int portCount() {
        if (this.b == null) {
            return super.portCount();
        }
        return this.b.portCount();
    }
    
    public Iterator ports() {
        if (this.b == null) {
            return super.ports();
        }
        return this.b.ports();
    }
    
    protected void invalidatePortPositions() {
        if (this.b == null) {
            super.invalidatePortPositions();
            if (!fj.z) {
                return;
            }
        }
        this.b.invalidatePortPositions();
    }
    
    eU b(final Object o) {
        if (this.b == null) {
            return super.b(o);
        }
        return this.b.b(o);
    }
    
    Object c(final eU eu) {
        if (this.b == null) {
            return super.c(eu);
        }
        return this.b.c(eu);
    }
    
    public double getCenterX() {
        return (this.b == null) ? super.getCenterX() : this.b.getCenterX();
    }
    
    public double getCenterY() {
        return (this.b == null) ? super.getCenterY() : this.b.getCenterY();
    }
    
    public void setCenter(final double n, final double n2) {
        if (this.b == null) {
            super.setCenter(n, n2);
            if (!fj.z) {
                return;
            }
        }
        this.b.setCenter(n, n2);
    }
    
    public void setCenterX(final double n) {
        if (this.b == null) {
            super.setCenterX(n);
            if (!fj.z) {
                return;
            }
        }
        this.b.setCenterX(n);
    }
    
    public void setCenterY(final double n) {
        if (this.b == null) {
            super.setCenterY(n);
            if (!fj.z) {
                return;
            }
        }
        this.b.setCenterY(n);
    }
    
    public double getX() {
        return (this.b == null) ? super.getX() : this.b.getX();
    }
    
    public double getY() {
        return (this.b == null) ? super.getY() : this.b.getY();
    }
    
    public void setLocation(final double n, final double n2) {
        if (this.b == null) {
            super.setLocation(n, n2);
            if (!fj.z) {
                return;
            }
        }
        this.b.setLocation(n, n2);
    }
    
    public void setX(final double n) {
        if (this.b == null) {
            super.setX(n);
            if (!fj.z) {
                return;
            }
        }
        this.b.setX(n);
    }
    
    public void setY(final double n) {
        if (this.b == null) {
            super.setY(n);
            if (!fj.z) {
                return;
            }
        }
        this.b.setY(n);
    }
    
    public void moveBy(final double n, final double n2) {
        if (this.b == null) {
            super.moveBy(n, n2);
            if (!fj.z) {
                return;
            }
        }
        this.b.moveBy(n, n2);
    }
    
    public double getWidth() {
        return (this.b == null) ? super.getWidth() : this.b.getWidth();
    }
    
    public double getHeight() {
        return (this.b == null) ? super.getHeight() : this.b.getHeight();
    }
    
    public void setFrame(final double n, final double n2, final double n3, final double n4) {
        if (this.b == null) {
            super.setFrame(n, n2, n3, n4);
            if (!fj.z) {
                return;
            }
        }
        this.b.setFrame(n, n2, n3, n4);
    }
    
    public void setFrame(final Rectangle2D rectangle2D) {
        if (this.b == null) {
            super.setFrame(rectangle2D);
            if (!fj.z) {
                return;
            }
        }
        this.b.setFrame(rectangle2D);
    }
    
    public void setSize(final double n, final double n2) {
        if (this.b == null) {
            super.setSize(n, n2);
            if (!fj.z) {
                return;
            }
        }
        this.b.setSize(n, n2);
    }
    
    public void setWidth(final double n) {
        if (this.b == null) {
            super.setWidth(n);
            if (!fj.z) {
                return;
            }
        }
        this.b.setWidth(n);
    }
    
    public void setHeight(final double n) {
        if (this.b == null) {
            super.setHeight(n);
            if (!fj.z) {
                return;
            }
        }
        this.b.setHeight(n);
    }
    
    public void setVisible(final boolean b) {
        if (this.b == null) {
            super.setVisible(b);
            if (!fj.z) {
                return;
            }
        }
        this.b.setVisible(b);
    }
    
    public boolean isVisible() {
        return (this.b == null) ? super.isVisible() : this.b.isVisible();
    }
    
    public void setLayer(final byte b) {
        if (this.b == null) {
            super.setLayer(b);
            if (!fj.z) {
                return;
            }
        }
        this.b.setLayer(b);
    }
    
    public byte getLayer() {
        return (this.b == null) ? super.getLayer() : this.b.getLayer();
    }
    
    public void setLayer(final byte b, final boolean b2) {
        if (this.b == null) {
            super.setLayer(b, b2);
            if (!fj.z) {
                return;
            }
        }
        this.b.setLayer(b, b2);
    }
    
    public void setSelected(final boolean b) {
        if (this.b == null) {
            super.setSelected(b);
            if (!fj.z) {
                return;
            }
        }
        this.b.setSelected(b);
    }
    
    public boolean isSelected() {
        return (this.b == null) ? super.isSelected() : this.b.isSelected();
    }
    
    public Rectangle2D.Double getBoundingBox() {
        return (this.b == null) ? super.getBoundingBox() : this.b.getBoundingBox();
    }
    
    public byte hotSpotHit(final double n, final double n2) {
        return (this.b == null) ? super.hotSpotHit(n, n2) : this.b.hotSpotHit(n, n2);
    }
    
    public boolean findBBIntersection(final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        return (this.b == null) ? super.findBBIntersection(n, n2, n3, n4, point2D) : this.b.findBBIntersection(n, n2, n3, n4, point2D);
    }
    
    public boolean findIntersection(final double n, final double n2, final double n3, final double n4, final Point2D point2D) {
        return (this.b == null) ? super.findIntersection(n, n2, n3, n4, point2D) : this.b.findIntersection(n, n2, n3, n4, point2D);
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D, final byte b) {
        if (this.b == null) {
            super.calcUnionRect(rectangle2D, b);
            if (!fj.z) {
                return;
            }
        }
        this.b.calcUnionRect(rectangle2D, b);
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        if (this.b == null) {
            super.calcUnionRect(rectangle2D);
            if (!fj.z) {
                return;
            }
        }
        this.b.calcUnionRect(rectangle2D);
    }
    
    public boolean intersects(final double n, final double n2, final double n3, final double n4) {
        return (this.b == null) ? super.intersects(n, n2, n3, n4) : this.b.intersects(n, n2, n3, n4);
    }
    
    public boolean contains(final double n, final double n2) {
        return (this.b == null) ? super.contains(n, n2) : this.b.contains(n, n2);
    }
    
    public boolean isInBox(final double n, final double n2, final double n3, final double n4) {
        return (this.b == null) ? super.isInBox(n, n2, n3, n4) : this.b.isInBox(n, n2, n3, n4);
    }
    
    public D getPortCandidates(final double n) {
        return (this.b == null) ? super.getPortCandidates(n) : this.b.getPortCandidates(n);
    }
    
    public dy getMouseInputEditorProvider() {
        final fj e = this.e();
        return (e != null) ? e.getMouseInputEditorProvider() : null;
    }
    
    protected void paintNode(final Graphics2D graphics2D) {
        if (this.b == null) {
            super.paintNode(graphics2D);
            if (!fj.z) {
                return;
            }
        }
        this.b.paintNode(graphics2D);
    }
    
    public void paintHotSpots(final Graphics2D graphics2D) {
        if (this.b == null) {
            super.paintHotSpots(graphics2D);
            if (!fj.z) {
                return;
            }
        }
        this.b.paintHotSpots(graphics2D);
    }
    
    public void paintLayer(final Graphics2D graphics2D, final byte b) {
        if (this.b == null) {
            super.paintLayer(graphics2D, b);
            if (!fj.z) {
                return;
            }
        }
        this.b.paintLayer(graphics2D, b);
    }
    
    public void paintLayerSloppy(final Graphics2D graphics2D, final byte b) {
        if (this.b == null) {
            super.paintLayerSloppy(graphics2D, b);
            if (!fj.z) {
                return;
            }
        }
        this.b.paintLayerSloppy(graphics2D, b);
    }
    
    public void paintSloppy(final Graphics2D graphics2D) {
        if (this.b == null) {
            super.paintSloppy(graphics2D);
            if (!fj.z) {
                return;
            }
        }
        this.b.paintSloppy(graphics2D);
    }
    
    public void paint(final Graphics2D graphics2D) {
        if (this.b == null) {
            super.paint(graphics2D);
            if (!fj.z) {
                return;
            }
        }
        this.b.paint(graphics2D);
    }
    
    public void paintText(final Graphics2D graphics2D) {
        if (this.b == null) {
            super.paintText(graphics2D);
            if (!fj.z) {
                return;
            }
        }
        this.b.paintText(graphics2D);
    }
    
    public void setEdgesDirty() {
        if (this.b == null) {
            super.setEdgesDirty();
            if (!fj.z) {
                return;
            }
        }
        this.b.setEdgesDirty();
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        final boolean z = fj.z;
        objectOutputStream.writeByte(0);
        super.write(objectOutputStream);
        objectOutputStream.writeInt(this.a.size());
        int n = 0;
        int i = 0;
        while (i < this.a.size()) {
            final fj fj = this.a.get(i);
            objectOutputStream.writeObject(h.a(fj.getClass().getName()));
            fj.write(objectOutputStream);
            if (z) {
                return;
            }
            if (fj == this.b) {
                n = i;
            }
            ++i;
            if (z) {
                break;
            }
        }
        objectOutputStream.writeInt(n);
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        final byte byte1 = objectInputStream.readByte();
        if (byte1 != 0) {
            throw new a((byte)0, byte1);
        }
        super.read(objectInputStream);
        final int int1 = objectInputStream.readInt();
        int i = 0;
        while (i < int1) {
            try {
                final fj fj = (fj)Class.forName(h.b((String)objectInputStream.readObject())).newInstance();
                fj.b(this.getNode());
                fj.read(objectInputStream);
                fj.b((q)null);
                this.a(fj);
                if (z) {
                    return;
                }
            }
            catch (InstantiationException ex) {
                throw new IOException(ex.getMessage());
            }
            catch (IllegalAccessException ex2) {
                throw new IOException(ex2.getMessage());
            }
            ++i;
            if (z) {
                break;
            }
        }
        this.b(this.a(objectInputStream.readInt()));
    }
}
