package y.h;

import java.awt.image.*;
import java.awt.*;

final class fI extends bw
{
    private BufferedImage f;
    private BufferedImage g;
    private ConvolveOp h;
    private final fD i;
    
    private boolean F() {
        if (this.h == null) {
            final int n = 5;
            double doubleValue = 0.9;
            final Object clientProperty = this.i.getClientProperty("Overview.funkyTheta");
            if (clientProperty instanceof Number) {
                doubleValue = ((Number)clientProperty).doubleValue();
            }
            this.h = new ConvolveOp(new Kernel(n, n, fD.access$100(doubleValue, n)));
        }
        if (this.f == null || this.getWidth() != this.f.getWidth() || this.getHeight() != this.f.getHeight()) {
            if (!fD.access$200()) {
                this.f = new BufferedImage(this.getWidth(), this.getHeight(), 1);
                this.g = new BufferedImage(this.getWidth(), this.getHeight(), 1);
                if (!fj.z) {
                    return true;
                }
            }
            this.f = new BufferedImage(this.getWidth(), this.getHeight(), 2);
            this.g = new BufferedImage(this.getWidth(), this.getHeight(), 2);
            return true;
        }
        return false;
    }
    
    public fI(final fD i, final ch ch) {
        super(ch);
        this.i = i;
    }
    
    public void paintComponent(final Graphics graphics) {
        Label_0298: {
            if (this.F() || this.i.xc) {
                final BufferedImage g = this.g;
                final BufferedImage f = this.f;
                Color color = (Color)this.i.getClientProperty("Overview.FogColor");
                if (color == null) {
                    color = new Color(0.85f, 0.85f, 0.85f, 0.6f);
                }
                if (this.i.xc) {
                    this.i();
                    this.i.xc = false;
                }
                final Graphics2D graphics2 = f.createGraphics();
                try {
                    graphics2.setColor(this.getBackground());
                    graphics2.clearRect(0, 0, this.getWidth(), this.getHeight());
                    graphics2.setClip(0, 0, this.getWidth(), this.getHeight());
                    super.paintComponent(graphics2);
                }
                finally {
                    graphics2.dispose();
                }
                if ("Funky".equals(this.i.getClientProperty("Overview.PaintStyle")) && !fD.access$200()) {
                    this.h.filter(this.f, this.g);
                    final Graphics2D graphics3 = g.createGraphics();
                    try {
                        graphics3.setColor(color);
                        graphics3.fillRect(0, 0, this.getWidth(), this.getHeight());
                        break Label_0298;
                    }
                    finally {
                        graphics3.dispose();
                    }
                }
                final Graphics2D graphics4 = g.createGraphics();
                try {
                    graphics4.drawImage(this.f, 0, 0, null);
                    graphics4.setColor(color);
                    graphics4.fillRect(0, 0, this.getWidth(), this.getHeight());
                }
                finally {
                    graphics4.dispose();
                }
            }
        }
        if (this.i.xc) {
            this.i();
            this.i.xc = false;
        }
        BufferedImage bufferedImage = null;
        BufferedImage bufferedImage2 = null;
        Label_0364: {
            if (Boolean.TRUE.equals(this.i.getClientProperty("Overview.Inverse"))) {
                bufferedImage = this.f;
                bufferedImage2 = this.g;
                if (!fj.z) {
                    break Label_0364;
                }
            }
            bufferedImage = this.g;
            bufferedImage2 = this.f;
        }
        graphics.drawImage(bufferedImage2, 0, 0, null);
        final int e = this.e(fF.a(this.i.wc).x);
        final int f2 = this.f(fF.a(this.i.wc).y);
        final int max = Math.max(0, e);
        final int max2 = Math.max(0, f2);
        final int e2 = this.e(fF.a(this.i.wc).getMaxX());
        final int f3 = this.f(fF.a(this.i.wc).getMaxY());
        final int min = Math.min(this.getWidth(), e2);
        final int min2 = Math.min(this.getHeight(), f3);
        if (min >= max && min2 >= max2) {
            graphics.drawImage(bufferedImage, max, max2, min, min2, max, max2, min, min2, null);
            Color lightGray = (Color)this.i.getClientProperty("Overview.BorderColor");
            if (lightGray == null) {
                lightGray = Color.lightGray;
            }
            graphics.setColor(lightGray);
            graphics.drawRect(e, f2, e2 - e, f3 - f2);
            if (Boolean.TRUE.equals(this.i.getClientProperty("Overview.AllowZooming"))) {
                graphics.setColor(Color.darkGray);
                graphics.fillRect(e2 - 1, f3 - 1, 3, 3);
            }
        }
    }
}
