package y.h;

import java.awt.geom.*;
import y.h.a.*;
import y.c.*;
import java.awt.*;

public class gm extends b implements bd
{
    private byte a;
    private boolean b;
    
    public gm() {
        this((byte)0);
    }
    
    public gm(final byte a) {
        this.b = true;
        this.a = a;
    }
    
    protected void a(final fj fj, final Graphics2D graphics2D, final boolean b) {
        final Shape a = this.a(fj);
        this.a(fj, graphics2D, a);
        this.b(fj, graphics2D, a);
    }
    
    private Shape a(final fj fj) {
        double x = 0.0;
        double y = 0.0;
        double width = 0.0;
        double height = 0.0;
        Label_0044: {
            if (fj != null) {
                x = fj.getX();
                y = fj.getY();
                width = fj.getWidth();
                height = fj.getHeight();
                if (!fj.z) {
                    break Label_0044;
                }
            }
            x = 0.0;
            y = 0.0;
            width = 1.0;
            height = 1.0;
        }
        switch (this.a) {
            case 2: {
                return new Ellipse2D.Double(x, y, width, height);
            }
            case 0:
            case 6: {
                return new Rectangle2D.Double(x, y, width, height);
            }
            case 1: {
                return new RoundRectangle2D.Double(x, y, width, height, 8.0, 8.0);
            }
            case 3: {
                final GeneralPath generalPath = new GeneralPath(0, 9);
                generalPath.moveTo((float)(x + width * 0.1), (float)y);
                generalPath.lineTo((float)(x + width), (float)y);
                generalPath.lineTo((float)(x + width * 0.9), (float)(y + height));
                generalPath.lineTo((float)x, (float)(y + height));
                generalPath.closePath();
                return generalPath;
            }
            case 4: {
                final GeneralPath generalPath2 = new GeneralPath(0, 9);
                generalPath2.moveTo((float)x, (float)(y + height / 2.0));
                generalPath2.lineTo((float)(x + width * 0.1), (float)y);
                generalPath2.lineTo((float)(x + width * 0.9), (float)y);
                generalPath2.lineTo((float)(x + width), (float)(y + height / 2.0));
                generalPath2.lineTo((float)(x + width * 0.9), (float)(y + height));
                generalPath2.lineTo((float)(x + width * 0.1), (float)(y + height));
                generalPath2.closePath();
                return generalPath2;
            }
            case 5: {
                final GeneralPath generalPath3 = new GeneralPath(0, 9);
                generalPath3.moveTo((float)(x + width / 2.0), (float)y);
                generalPath3.lineTo((float)(x + width), (float)(y + height));
                generalPath3.lineTo((float)x, (float)(y + height));
                generalPath3.closePath();
                return generalPath3;
            }
            case 7: {
                final double sqrt = Math.sqrt(2.0);
                final double n = width / (2.0 + sqrt);
                final double n2 = height / (2.0 + sqrt);
                final GeneralPath generalPath4 = new GeneralPath(0, 9);
                generalPath4.moveTo((float)x, (float)(y + n2));
                generalPath4.lineTo((float)(x + n), (float)y);
                generalPath4.lineTo((float)(x + width - n), (float)y);
                generalPath4.lineTo((float)(x + width), (float)(y + n2));
                generalPath4.lineTo((float)(x + width), (float)(y + height - n2));
                generalPath4.lineTo((float)(x + width - n), (float)(y + height));
                generalPath4.lineTo((float)(x + n), (float)(y + height));
                generalPath4.lineTo((float)x, (float)(y + height - n2));
                generalPath4.closePath();
                return generalPath4;
            }
            case 8: {
                final GeneralPath generalPath5 = new GeneralPath(0, 9);
                generalPath5.moveTo((float)x, (float)(y + height * 0.5));
                generalPath5.lineTo((float)(x + width * 0.5), (float)y);
                generalPath5.lineTo((float)(x + width), (float)(y + height * 0.5));
                generalPath5.lineTo((float)(x + width * 0.5), (float)(y + height));
                generalPath5.closePath();
                return generalPath5;
            }
            case 9: {
                final GeneralPath generalPath6 = new GeneralPath(0, 9);
                generalPath6.moveTo((float)x, (float)(y + height));
                generalPath6.lineTo((float)(x + width * 0.25), (float)y);
                generalPath6.lineTo((float)(x + width * 0.75), (float)y);
                generalPath6.lineTo((float)(x + width), (float)(y + height));
                generalPath6.closePath();
                return generalPath6;
            }
            case 10: {
                final GeneralPath generalPath7 = new GeneralPath(0, 9);
                generalPath7.moveTo((float)x, (float)y);
                generalPath7.lineTo((float)(x + width), (float)y);
                generalPath7.lineTo((float)(x + width * 0.75), (float)(y + height));
                generalPath7.lineTo((float)(x + width * 0.25), (float)(y + height));
                generalPath7.closePath();
                return generalPath7;
            }
            default: {
                return new Rectangle2D.Double(x, y, width, height);
            }
        }
    }
    
    protected void a(final fj fj, final Graphics2D graphics2D, final Shape shape) {
        if (!fj.isTransparent()) {
            final Paint f = this.f(fj, graphics2D);
            if (f != null) {
                graphics2D.setPaint(f);
                graphics2D.fill(shape);
            }
        }
    }
    
    protected Color b(final fj fj, final boolean b) {
        Color b2 = super.b(fj, b);
        if (this.a() && b2 != null) {
            final q node = fj.getNode();
            if (node != null) {
                final v a = v.a(node.e());
                if (a != null && a.k(node)) {
                    Color color = b2;
                    final int o = a.o(node);
                    if (o > 0) {
                        color = new Color(Math.max(b2.getRed() - 20 * o, 0), Math.max(b2.getGreen() - 20 * o, 0), Math.max(b2.getBlue() - 20 * o, 0), b2.getAlpha());
                    }
                    b2 = color;
                }
            }
        }
        return b2;
    }
    
    protected void b(final fj fj, final Graphics2D graphics2D, final Shape shape) {
        final boolean z = fj.z;
        if (this.a == 6) {
            final Color b = this.b(fj, y.h.b.g(fj, graphics2D));
            if (b == null) {
                return;
            }
            graphics2D.setColor(b);
            this.b(fj, graphics2D, true);
            if (!z) {
                return;
            }
        }
        final Color a = this.a(fj, y.h.b.g(fj, graphics2D));
        if (a != null) {
            final Stroke stroke = graphics2D.getStroke();
            graphics2D.setStroke(fj.getLineType());
            graphics2D.setColor(a);
            Label_0183: {
                if (this.a == 2) {
                    final cV cv = (cV)graphics2D.getRenderingHint(hk.z);
                    final Object renderingHint = graphics2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
                    if (!RenderingHints.VALUE_ANTIALIAS_ON.equals(renderingHint) && (cv == null || !cv.b())) {
                        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        graphics2D.draw(shape);
                        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, renderingHint);
                        if (!z) {
                            break Label_0183;
                        }
                    }
                    graphics2D.draw(shape);
                    if (!z) {
                        break Label_0183;
                    }
                }
                graphics2D.draw(shape);
            }
            graphics2D.setStroke(stroke);
        }
    }
    
    private void b(final fj fj, final Graphics2D graphics2D, final boolean b) {
        final double x = fj.getX();
        final double y = fj.getY();
        final double width = fj.getWidth();
        final double height = fj.getHeight();
        final Paint paint = graphics2D.getPaint();
        final Color color = graphics2D.getColor();
        final Color brighter = color.brighter();
        final Color darker = color.darker();
        Label_0079: {
            if (!b) {
                graphics2D.setColor(darker);
                if (!fj.z) {
                    break Label_0079;
                }
            }
            if (paint != color) {
                graphics2D.setColor(color);
            }
        }
        graphics2D.setColor(b ? brighter : darker);
        final Rectangle2D.Double k = hC.a().k;
        k.setFrame(x, y, 1.0, height);
        graphics2D.fill(k);
        k.setFrame(x + 1.0, y, width - 2.0, 1.0);
        graphics2D.fill(k);
        graphics2D.setColor(b ? darker : brighter);
        k.setFrame(x + 1.0, y + height - 1.0, width - 1.0, 1.0);
        graphics2D.fill(k);
        k.setFrame(x + width - 1.0, y, 1.0, height - 1.0);
        graphics2D.fill(k);
        graphics2D.setPaint(paint);
    }
    
    public boolean a() {
        return this.b;
    }
    
    public boolean a(final fj fj, final double n, final double n2) {
        return this.a(fj).contains(n, n2);
    }
}
