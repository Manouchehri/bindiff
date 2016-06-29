/*
 * Decompiled with CFR 0_115.
 */
package a.a.a;

import a.a.a.g;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.Writer;
import org.w3c.dom.Node;
import y.h.O;
import y.h.aB;
import y.h.fj;

public class f
extends O {
    private g a;

    public void a(g g2) {
        this.a = g2;
    }

    protected g a() {
        return this.a;
    }

    protected void a(Node node, Writer writer) {
        this.a().a(node, writer);
    }

    @Override
    public void paint(Graphics2D graphics2D, fj fj2) {
        Shape shape = graphics2D.getClip();
        if (shape != null && shape.contains(f.a(fj2))) {
            graphics2D.setClip(null);
        }
        fj2.paint(graphics2D);
        graphics2D.setClip(shape);
    }

    @Override
    public void paintSloppy(Graphics2D graphics2D, fj fj2) {
        Shape shape = graphics2D.getClip();
        if (shape != null && shape.contains(f.a(fj2))) {
            graphics2D.setClip(null);
        }
        fj2.paintSloppy(graphics2D);
        graphics2D.setClip(shape);
    }

    @Override
    public void paint(Graphics2D graphics2D, aB aB2) {
        Shape shape = graphics2D.getClip();
        if (shape != null && shape.contains(f.a(aB2))) {
            graphics2D.setClip(null);
        }
        aB2.paint(graphics2D);
        graphics2D.setClip(shape);
    }

    @Override
    public void paintSloppy(Graphics2D graphics2D, aB aB2) {
        Shape shape = graphics2D.getClip();
        if (shape != null && shape.contains(f.a(aB2))) {
            graphics2D.setClip(null);
        }
        aB2.paintSloppy(graphics2D);
        graphics2D.setClip(shape);
    }

    private static Rectangle2D a(fj fj2) {
        Rectangle2D.Double double_ = fj2.getBoundingBox();
        if (fj2.isSelected()) {
            double_.setFrame(double_.getX() - 10.0, double_.getY() - 10.0, double_.getWidth() + 20.0, double_.getHeight() + 20.0);
        }
        fj2.calcUnionRect(double_);
        return double_;
    }

    private static Rectangle2D a(aB aB2) {
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        aB2.calcUnionRect(double_);
        return double_;
    }
}

