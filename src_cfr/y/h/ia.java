/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JComponent;
import y.h.az;
import y.h.ch;
import y.h.fj;

final class ia
implements az {
    private JComponent a;
    private AffineTransform b;

    public ia(ch ch2, JComponent jComponent, AffineTransform affineTransform) {
        ch2.s().add(jComponent);
        this.a = jComponent;
        this.b = affineTransform;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(Graphics2D graphics2D) {
        boolean bl2 = this.a.isDoubleBuffered();
        if (bl2) {
            this.a.setDoubleBuffered(false);
        }
        if (this.a.getClientProperty("NodeCellRenderer.noImage") == null) {
            try {
                BufferedImage bufferedImage = graphics2D.getDeviceConfiguration().createCompatibleImage(this.a.getWidth(), this.a.getHeight(), 1);
                Graphics2D graphics2D2 = bufferedImage.createGraphics();
                if (this.a.getClientProperty("NodeCellRenderer.adoptRenderingHints") != null) {
                    graphics2D2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, graphics2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING));
                    graphics2D2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, graphics2D.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING));
                }
                this.a.paint(graphics2D2);
                graphics2D2.dispose();
                if (this.a.getClientProperty("NodeCellRender.lowQualityImage") == null) {
                    Graphics2D graphics2D3 = (Graphics2D)graphics2D.create();
                    graphics2D3.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                    graphics2D3.drawImage(bufferedImage, this.b, null);
                    graphics2D3.dispose();
                    if (!fj.z) return;
                }
                graphics2D.drawImage(bufferedImage, this.b, null);
                return;
            }
            finally {
                if (bl2) {
                    this.a.setDoubleBuffered(true);
                }
            }
        } else {
            graphics2D = (Graphics2D)graphics2D.create();
            try {
                graphics2D.transform(this.b);
                this.a.paint(graphics2D);
                Object var8_7 = null;
                graphics2D.dispose();
                if (!bl2) return;
                this.a.setDoubleBuffered(true);
                return;
            }
            catch (Throwable var7_9) {
                Object var8_8 = null;
                graphics2D.dispose();
                if (!bl2) throw var7_9;
                this.a.setDoubleBuffered(true);
                throw var7_9;
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        double[] arrd = new double[8];
        arrd[5] = 0.0;
        arrd[2] = 0.0;
        arrd[1] = 0.0;
        arrd[0] = 0.0;
        arrd[3] = arrd[7] = (double)this.a.getHeight();
        arrd[4] = arrd[6] = (double)this.a.getWidth();
        this.b.transform(arrd, 0, arrd, 0, 4);
        double d2 = Math.max(Math.max(arrd[0], arrd[2]), Math.max(arrd[4], arrd[6]));
        double d3 = Math.min(Math.min(arrd[0], arrd[2]), Math.min(arrd[4], arrd[6]));
        double d4 = Math.max(Math.max(arrd[1], arrd[3]), Math.max(arrd[5], arrd[7]));
        double d5 = Math.min(Math.min(arrd[1], arrd[3]), Math.min(arrd[5], arrd[7]));
        return new Rectangle((int)d3 - 1, (int)d5 - 1, (int)(d2 - d3) + 2, (int)(d4 - d5) + 2);
    }
}

