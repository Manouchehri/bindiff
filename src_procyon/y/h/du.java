package y.h;

import java.awt.image.*;
import java.awt.*;

final class du extends M
{
    private final ch a;
    
    du(final ch ch, final ch a) {
        super(ch);
        this.a = a;
    }
    
    public void paint(final Graphics2D graphics2D, final int n, final int n2, final int n3, final int n4) {
        this.a(this.a);
        try {
            super.paint(graphics2D, n, n2, n3, n4);
        }
        finally {
            this.a();
        }
    }
    
    protected void undoWorldTransform(final Graphics2D graphics2D) {
    }
    
    protected void redoWorldTransform(final Graphics2D graphics2D) {
    }
    
    void c(final Graphics2D graphics2D) {
        this.undoWorldTransform(graphics2D);
        final Image image = this.getImage();
        graphics2D.drawImage(image, (this.a.getWidth() - image.getWidth(null)) / 2, (this.a.getHeight() - image.getHeight(null)) / 2, null);
    }
    
    private void a(final ch ch) {
        final w backgroundRenderer = ch.getBackgroundRenderer();
        if (backgroundRenderer instanceof M) {
            this.a((M)backgroundRenderer);
        }
    }
    
    private void a(final M m) {
        this.setColor(m.getColor());
        this.setImage(m.getImage());
        final Point imageOrigin = m.getImageOrigin();
        this.setImageOrigin(imageOrigin.getX(), imageOrigin.getY());
        this.setMode(m.getMode());
    }
    
    private void a() {
        this.setColor(Color.WHITE);
        this.setImage(null);
        this.setImageOrigin(0.0, 0.0);
        this.setMode((byte)4);
    }
}
