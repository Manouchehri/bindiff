package y.h;

import java.awt.print.*;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

final class gb extends JPanel implements Scrollable
{
    private int a;
    private int b;
    private int c;
    private int d;
    private double e;
    private int f;
    private double g;
    private double h;
    private double i;
    private boolean j;
    private final fQ k;
    
    gb(final fQ k, final int n, final int n2, final int n3, final int n4) {
        this.k = k;
        this.b = 1;
        this.d = 10;
        this.g = 10.0;
        this.h = 5.0;
        this.a(n);
        this.c(n3);
        this.b(n2);
        this.i = Toolkit.getDefaultToolkit().getScreenResolution() / 72.0;
        this.setMinimumSize(new Dimension((int)Math.rint(n2 * 2 * this.g + 5.0), (int)Math.rint(this.c * 2 * this.g + 5.0)));
        this.e(n4);
    }
    
    public void a(final int a) {
        if (a < 0) {
            throw new IllegalArgumentException("page must be non-negative");
        }
        this.a = a;
    }
    
    public void b(final int b) {
        final boolean z = fj.z;
        if (b <= 0) {
            throw new IllegalArgumentException("columns must be greater 0");
        }
        this.b = b;
        this.c = 1;
        while (this.c * this.b < this.d) {
            ++this.c;
            if (z) {
                break;
            }
        }
    }
    
    public void c(final int d) {
        final boolean z = fj.z;
        if (d < 0) {
            throw new IllegalArgumentException("pages must be non-negative");
        }
        this.d = d;
        this.c = 1;
        while (this.c * this.b < this.d) {
            ++this.c;
            if (z) {
                break;
            }
        }
    }
    
    public int d(final int n) {
        return (int)Math.rint(Math.floor(Math.max(0.05, (n - this.b * 2 * this.g) / (this.b * fQ.access$300(this.k).getWidth() * this.i)) * 1000.0));
    }
    
    public int a(final int n, final int n2) {
        final double n3 = (n - this.b * 2 * this.g) / (this.b * fQ.access$300(this.k).getWidth() * this.i);
        this.e = Math.max(0.05, this.e);
        return (int)Math.rint(Math.floor(Math.min(n3, (n2 - this.c * 2 * this.g) / (this.c * fQ.access$300(this.k).getHeight() * this.i)) * 1000.0));
    }
    
    public synchronized void e(int f) {
        if (this.j) {
            return;
        }
        if (this.f != f) {
            if (f < 50) {
                f = 50;
            }
            final int f2 = this.f;
            this.f = f;
            this.e = f / 1000.0;
            this.setPreferredSize(new Dimension((int)Math.rint(this.b * (2.0 * this.g + fQ.access$300(this.k).getWidth() * this.e * this.i)), (int)Math.rint(this.c * (2.0 * this.g + fQ.access$300(this.k).getHeight() * this.e * this.i))));
            this.revalidate();
            this.repaint();
            try {
                this.j = true;
                this.firePropertyChange("ZOOM", f2, f);
            }
            finally {
                this.j = false;
            }
        }
    }
    
    public void a() {
        final int b = this.b();
        this.f = 0;
        this.e(b);
    }
    
    public int b() {
        return this.f;
    }
    
    protected void paintComponent(final Graphics graphics) {
        final boolean z = fj.z;
        super.paintComponent(graphics);
        final Graphics2D graphics2D = (Graphics2D)graphics;
        final Paper paper = fQ.access$300(this.k).getPaper();
        double width = paper.getWidth();
        double height = paper.getHeight();
        if (fQ.access$300(this.k).getOrientation() != 1) {
            final double n = width;
            width = height;
            height = n;
        }
        final Insets insets = super.getInsets();
        final double n2 = this.i * this.e;
        final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, 0.0, 0.0);
        final double g = this.g;
        final double g2 = this.g;
        int n3 = 0;
        do {
            Label_0109: {
                final int n4 = (int)Math.ceil(this.d / this.b);
            }
            int i = 0;
            int d = 0;
            Label_0127:
            while (i < d) {
                int j = 0;
                while (j < this.b) {
                    final double n5 = insets.left + this.g + j * (width * n2) + j * 2 * this.g;
                    final double n6 = insets.top + this.g + n3 * (height * n2) + n3 * 2 * this.g;
                    i = j + n3 * this.b;
                    d = this.d;
                    if (z) {
                        continue Label_0127;
                    }
                    if (i >= d) {
                        break;
                    }
                    double1.width = width * n2;
                    double1.height = height * n2;
                    double1.x = n5 + this.h;
                    double1.y = n6 + this.h;
                    graphics2D.setColor(this.getBackground().darker());
                    graphics2D.fill(double1);
                    double1.x = n5;
                    double1.y = n6;
                    graphics2D.setColor(Color.white);
                    graphics2D.fill(double1);
                    graphics2D.setColor(Color.black);
                    graphics2D.draw(double1);
                    final double x = double1.x;
                    final double y = double1.y;
                    double1.setFrame(fQ.access$300(this.k).getImageableX() * n2 + x, fQ.access$300(this.k).getImageableY() * n2 + y, fQ.access$300(this.k).getImageableWidth() * n2, fQ.access$300(this.k).getImageableHeight() * n2);
                    int print = 0;
                    try {
                        final AffineTransform transform = graphics2D.getTransform();
                        final Shape clip = graphics2D.getClip();
                        graphics2D.translate(x, y);
                        graphics2D.scale(n2, n2);
                        final Shape clip2 = graphics2D.getClip();
                        final Rectangle2D.Double double2 = new Rectangle2D.Double(fQ.access$300(this.k).getImageableX(), fQ.access$300(this.k).getImageableY(), fQ.access$300(this.k).getImageableWidth(), fQ.access$300(this.k).getImageableHeight());
                        Label_0585: {
                            if (clip2.intersects(new Rectangle(0, 0, (int)Math.ceil(width), (int)Math.ceil(height)))) {
                                graphics2D.clip(double2);
                                print = fQ.access$800(this.k).print(graphics2D, fQ.access$300(this.k), this.a + j + this.b * n3);
                                if (!z) {
                                    break Label_0585;
                                }
                            }
                            print = 0;
                        }
                        graphics2D.setTransform(transform);
                        graphics2D.setClip(clip);
                    }
                    catch (Exception ex) {
                        print = 1;
                        ex.printStackTrace();
                    }
                    if (print == 1) {
                        double1.width = width * n2;
                        double1.height = height * n2;
                        double1.x = n5;
                        double1.y = n6;
                        graphics2D.setColor(Color.lightGray);
                        graphics2D.fill(double1);
                        graphics2D.setColor(Color.red);
                        final Line2D.Double double3 = new Line2D.Double(double1.x, double1.y, double1.x + double1.width, double1.y + double1.height);
                        graphics2D.draw(double3);
                        double3.x1 = double3.x2;
                        double3.x2 = double1.x;
                        graphics2D.draw(double3);
                        graphics2D.setColor(Color.darkGray);
                        graphics2D.draw(double1);
                    }
                    else {
                        graphics2D.setColor(Color.lightGray);
                        graphics2D.draw(double1);
                    }
                    ++j;
                    if (z) {
                        break;
                    }
                }
                ++n3;
                continue Label_0109;
            }
            break;
        } while (!z);
    }
    
    public Action c() {
        return new fY(this, "+");
    }
    
    public Action d() {
        return new fZ(this, "-");
    }
    
    public Dimension getPreferredScrollableViewportSize() {
        return this.getPreferredSize();
    }
    
    public int getScrollableBlockIncrement(final Rectangle rectangle, final int n, final int n2) {
        return 10;
    }
    
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
    
    public boolean getScrollableTracksViewportWidth() {
        return false;
    }
    
    public int getScrollableUnitIncrement(final Rectangle rectangle, final int n, final int n2) {
        return 20;
    }
}
