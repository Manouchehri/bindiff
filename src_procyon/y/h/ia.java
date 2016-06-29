package y.h;

import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.*;

final class ia implements az
{
    private JComponent a;
    private AffineTransform b;
    
    public ia(final ch ch, final JComponent a, final AffineTransform b) {
        ch.s().add(a);
        this.a = a;
        this.b = b;
    }
    
    public void a(Graphics2D graphics2D) {
        final boolean doubleBuffered = this.a.isDoubleBuffered();
        if (doubleBuffered) {
            this.a.setDoubleBuffered(false);
        }
        if (this.a.getClientProperty("NodeCellRenderer.noImage") == null) {
            try {
                final BufferedImage compatibleImage = graphics2D.getDeviceConfiguration().createCompatibleImage(this.a.getWidth(), this.a.getHeight(), 1);
                final Graphics2D graphics = compatibleImage.createGraphics();
                if (this.a.getClientProperty("NodeCellRenderer.adoptRenderingHints") != null) {
                    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, graphics2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING));
                    graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, graphics2D.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING));
                }
                this.a.paint(graphics);
                graphics.dispose();
                if (this.a.getClientProperty("NodeCellRender.lowQualityImage") == null) {
                    final Graphics2D graphics2D2 = (Graphics2D)graphics2D.create();
                    graphics2D2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                    graphics2D2.drawImage(compatibleImage, this.b, null);
                    graphics2D2.dispose();
                    if (!fj.z) {
                        return;
                    }
                }
                graphics2D.drawImage(compatibleImage, this.b, null);
                return;
            }
            finally {
                if (doubleBuffered) {
                    this.a.setDoubleBuffered(true);
                }
            }
        }
        graphics2D = (Graphics2D)graphics2D.create();
        try {
            graphics2D.transform(this.b);
            this.a.paint(graphics2D);
        }
        finally {
            graphics2D.dispose();
            if (doubleBuffered) {
                this.a.setDoubleBuffered(true);
            }
        }
    }
    
    public Rectangle getBounds() {
        final double[] array2;
        final double[] array = array2 = new double[8];
        final int n = 0;
        final double[] array3 = array;
        final int n2 = 1;
        final double[] array4 = array;
        final int n3 = 2;
        final double[] array5 = array;
        final int n4 = 5;
        final double n5 = 0.0;
        array4[n3] = (array5[n4] = n5);
        array2[n] = (array3[n2] = n5);
        array[3] = (array[7] = this.a.getHeight());
        array[4] = (array[6] = this.a.getWidth());
        this.b.transform(array, 0, array, 0, 4);
        final double max = Math.max(Math.max(array[0], array[2]), Math.max(array[4], array[6]));
        final double min = Math.min(Math.min(array[0], array[2]), Math.min(array[4], array[6]));
        final double max2 = Math.max(Math.max(array[1], array[3]), Math.max(array[5], array[7]));
        final double min2 = Math.min(Math.min(array[1], array[3]), Math.min(array[5], array[7]));
        return new Rectangle((int)min - 1, (int)min2 - 1, (int)(max - min) + 2, (int)(max2 - min2) + 2);
    }
}
