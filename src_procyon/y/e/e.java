package y.e;

import java.io.*;
import java.awt.image.*;
import y.h.*;
import java.awt.*;

public abstract class e extends c
{
    private boolean b;
    private boolean c;
    private double d;
    
    protected e() {
        this(false);
    }
    
    protected e(final boolean b) {
        this.d = 10.0;
        this.b = b;
        this.c = true;
    }
    
    public boolean c() {
        return this.c;
    }
    
    public void a(final bu bu, final OutputStream outputStream) {
        ch a;
        final ch ch = a = (ch)bu.S();
        if (a == null) {
            a = this.a(bu);
        }
        try {
            this.a(a, outputStream);
        }
        finally {
            if (ch == null) {
                bu.c(a);
            }
        }
    }
    
    public void a(final ch ch, final OutputStream outputStream) {
        final Dimension canvasSize = ch.getCanvasSize();
        final long n = canvasSize.width * canvasSize.height;
        if (n > 2147483647L) {
            throw new IllegalArgumentException("Image size of " + canvasSize.width + "x" + canvasSize.height + "=" + n + "px exceeds maximum size of " + Integer.MAX_VALUE + "px.");
        }
        BufferedImage a;
        try {
            a = this.a(canvasSize.width, canvasSize.height);
        }
        catch (OutOfMemoryError outOfMemoryError) {
            final int n2 = (int)Math.ceil(canvasSize.width * canvasSize.height / 1048576.0);
            throw new OutOfMemoryError("Not enough memory for temporary image of size " + canvasSize.width + 'x' + canvasSize.height + " (" + n2 + "MPixels).  Approximately " + n2 * 4 + "MByte required.");
        }
        final Graphics2D graphics2D = (Graphics2D)a.getGraphics();
        if (!this.c()) {
            graphics2D.setRenderingHint(hk.a, hk.b);
        }
        if (this.b) {
            gF.a(graphics2D);
        }
        final cV a2 = this.a(ch, graphics2D);
        if (a2 != null) {
            graphics2D.setRenderingHint(hk.z, a2);
        }
        ch.paintVisibleContent(graphics2D);
        if (this.b) {
            gF.b(graphics2D);
        }
        try {
            this.a(a, outputStream);
        }
        catch (OutOfMemoryError outOfMemoryError2) {
            final int n3 = (int)Math.ceil(canvasSize.width * canvasSize.height / 1048576.0);
            throw new OutOfMemoryError("Not enough memory to encode image of size " + a.getWidth() + 'x' + a.getHeight() + " (" + n3 + "MPixels). Approximately " + n3 * 4 + "MByte required.");
        }
    }
    
    protected cV a(final ch ch, final Graphics2D graphics2D) {
        final cV cv = new cV();
        cv.b(true);
        cv.a(ch);
        cv.a(graphics2D.getTransform());
        return cv;
    }
    
    protected abstract BufferedImage a(final int p0, final int p1);
    
    public ch a(final bu bu) {
        final ch ch = new ch(bu);
        final Rectangle a = bu.a();
        final Dimension dimension = new Dimension(a.width, a.height);
        ch.setSize(dimension);
        ch.setPreferredSize(dimension);
        ch.zoomToArea(a.x - this.d, a.y - this.d, a.width + 2.0 * this.d, a.height + 2.0 * this.d);
        ch.setPaintDetailThreshold(0.0);
        return ch;
    }
    
    protected abstract void a(final BufferedImage p0, final OutputStream p1);
    
    public void a(final boolean b) {
        this.b = b;
    }
}
