package a.a.a;

import org.w3c.dom.*;
import java.io.*;
import java.awt.*;
import y.h.*;
import java.awt.geom.*;

public class f extends O
{
    private g a;
    
    public void a(final g a) {
        this.a = a;
    }
    
    protected g a() {
        return this.a;
    }
    
    protected void a(final Node node, final Writer writer) {
        this.a().a(node, writer);
    }
    
    public void paint(final Graphics2D graphics2D, final fj fj) {
        final Shape clip = graphics2D.getClip();
        if (clip != null && clip.contains(a(fj))) {
            graphics2D.setClip(null);
        }
        fj.paint(graphics2D);
        graphics2D.setClip(clip);
    }
    
    public void paintSloppy(final Graphics2D graphics2D, final fj fj) {
        final Shape clip = graphics2D.getClip();
        if (clip != null && clip.contains(a(fj))) {
            graphics2D.setClip(null);
        }
        fj.paintSloppy(graphics2D);
        graphics2D.setClip(clip);
    }
    
    public void paint(final Graphics2D graphics2D, final aB ab) {
        final Shape clip = graphics2D.getClip();
        if (clip != null && clip.contains(a(ab))) {
            graphics2D.setClip(null);
        }
        ab.paint(graphics2D);
        graphics2D.setClip(clip);
    }
    
    public void paintSloppy(final Graphics2D graphics2D, final aB ab) {
        final Shape clip = graphics2D.getClip();
        if (clip != null && clip.contains(a(ab))) {
            graphics2D.setClip(null);
        }
        ab.paintSloppy(graphics2D);
        graphics2D.setClip(clip);
    }
    
    private static Rectangle2D a(final fj fj) {
        final Rectangle2D.Double boundingBox = fj.getBoundingBox();
        if (fj.isSelected()) {
            boundingBox.setFrame(boundingBox.getX() - 10.0, boundingBox.getY() - 10.0, boundingBox.getWidth() + 20.0, boundingBox.getHeight() + 20.0);
        }
        fj.calcUnionRect(boundingBox);
        return boundingBox;
    }
    
    private static Rectangle2D a(final aB ab) {
        final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        ab.calcUnionRect(double1);
        return double1;
    }
}
