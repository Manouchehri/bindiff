package y.h;

import javax.swing.*;
import java.awt.*;

class if implements LayoutManager, ScrollPaneConstants
{
    protected bw a;
    protected JScrollBar b;
    protected JScrollBar c;
    protected JComponent d;
    Dimension e;
    private JPanel f;
    
    if() {
        this.e = new Dimension(-1, -1);
    }
    
    protected Component a(final Component component, final Component component2) {
        if (component != null && component != component2) {
            component.getParent().remove(component);
        }
        return component2;
    }
    
    public void addLayoutComponent(final String s, final Component component) {
        final boolean z = fj.z;
        if (s.equals("CANVAS")) {
            this.a = (bw)this.a(this.a, component);
            if (!z) {
                return;
            }
        }
        if (s.equals("VERTICAL_SCROLLBAR")) {
            this.b = (JScrollBar)this.a(this.b, component);
            if (!z) {
                return;
            }
        }
        if (s.equals("HORIZONTAL_SCROLLBAR")) {
            this.c = (JScrollBar)this.a(this.c, component);
            if (!z) {
                return;
            }
        }
        if (s.equals("CORNER_COMPONENT")) {
            this.d = (JComponent)this.a(this.d, component);
            if (!z) {
                return;
            }
        }
        if ("GLASS_PANE".equals(s)) {
            this.f = (JPanel)component;
        }
    }
    
    public void removeLayoutComponent(final Component component) {
        final boolean z = fj.z;
        if (component == this.a) {
            this.a = null;
            if (!z) {
                return;
            }
        }
        if (component == this.b) {
            this.b = null;
            if (!z) {
                return;
            }
        }
        if (component == this.c) {
            this.c = null;
            if (!z) {
                return;
            }
        }
        if (component == this.d) {
            this.d = null;
            if (!z) {
                return;
            }
        }
        if (component == this.f) {
            this.f = null;
        }
    }
    
    public Dimension preferredLayoutSize(final Container container) {
        final boolean z = fj.z;
        final ch ch = (ch)container;
        final int verticalScrollBarPolicy = ch.getVerticalScrollBarPolicy();
        final int horizontalScrollBarPolicy = ch.getHorizontalScrollBarPolicy();
        final Insets insets = ch.getInsets();
        int n = insets.left + insets.right;
        int n2 = insets.top + insets.bottom;
        Rectangle worldRect = null;
        Dimension dimension = null;
        if (this.a != null) {
            worldRect = ch.getWorldRect();
            dimension = this.a.getPreferredSize();
        }
        Label_0148: {
            if (this.f != null) {
                if (dimension != null) {
                    dimension.setSize(Math.max(dimension.getWidth(), this.f.getPreferredSize().getWidth()), Math.max(dimension.getHeight(), this.f.getPreferredSize().getHeight()));
                    if (!z) {
                        break Label_0148;
                    }
                }
                dimension = this.f.getPreferredSize();
            }
        }
        if (dimension != null) {
            n += dimension.width;
            n2 += dimension.height;
        }
        Label_0258: {
            if (this.b != null && verticalScrollBarPolicy != 21) {
                if (verticalScrollBarPolicy == 22) {
                    n += this.b.getPreferredSize().width;
                    if (!z) {
                        break Label_0258;
                    }
                }
                if (dimension != null && worldRect != null && worldRect.height > dimension.height / ch.getZoom()) {
                    n += this.b.getPreferredSize().width;
                }
            }
        }
        if (this.c != null && horizontalScrollBarPolicy != 31) {
            if (horizontalScrollBarPolicy == 32) {
                n2 += this.c.getPreferredSize().height;
                if (!z) {
                    return new Dimension(n, n2);
                }
            }
            if (dimension != null && worldRect != null && worldRect.width > dimension.width / ch.getZoom()) {
                n2 += this.c.getPreferredSize().height;
            }
        }
        return new Dimension(n, n2);
    }
    
    public Dimension minimumLayoutSize(final Container container) {
        final ch ch = (ch)container;
        final int verticalScrollBarPolicy = ch.getVerticalScrollBarPolicy();
        final int horizontalScrollBarPolicy = ch.getHorizontalScrollBarPolicy();
        final Insets insets = ch.getInsets();
        int n = insets.left + insets.right;
        int n2 = insets.top + insets.bottom;
        if (this.a != null) {
            final Dimension minimumSize = this.a.getMinimumSize();
            n += minimumSize.width;
            n2 += minimumSize.height;
        }
        if (this.b != null && verticalScrollBarPolicy != 21) {
            final Dimension minimumSize2 = this.b.getMinimumSize();
            n += minimumSize2.width;
            n2 = Math.max(n2, minimumSize2.height);
        }
        if (this.c != null && horizontalScrollBarPolicy != 21) {
            final Dimension minimumSize3 = this.c.getMinimumSize();
            n = Math.max(n, minimumSize3.width);
            n2 += minimumSize3.height;
        }
        if (this.f != null) {
            n = Math.max(n, this.f.getMinimumSize().width);
            n2 = Math.max(n2, this.f.getMinimumSize().height);
        }
        return new Dimension(n, n2);
    }
    
    public void layoutContainer(final Container container) {
        final boolean z = fj.z;
        final ch ch = (ch)container;
        final Rectangle rectangle = new Rectangle(ch.getSize());
        boolean b = false;
        if (this.e.width != rectangle.width || this.e.height != rectangle.height) {
            b = true;
            this.e.setSize(rectangle.width, rectangle.height);
        }
        final int verticalScrollBarPolicy = ch.getVerticalScrollBarPolicy();
        final int horizontalScrollBarPolicy = ch.getHorizontalScrollBarPolicy();
        final Insets insets = ch.getInsets();
        rectangle.x = insets.left;
        rectangle.y = insets.top;
        final Rectangle rectangle2 = rectangle;
        rectangle2.width -= insets.left + insets.right;
        final Rectangle rectangle3 = rectangle;
        rectangle3.height -= insets.top + insets.bottom;
        if (b && ch.getFitContentOnResize()) {
            final Rectangle bounds = new Rectangle(rectangle);
            if (horizontalScrollBarPolicy == 32) {
                final Rectangle rectangle4 = bounds;
                rectangle4.height -= this.c.getPreferredSize().height;
            }
            if (verticalScrollBarPolicy == 22) {
                final Rectangle rectangle5 = bounds;
                rectangle5.width -= this.b.getPreferredSize().width;
            }
            this.a.setBounds(bounds);
            this.a.i();
        }
        final Rectangle worldRect = ch.getWorldRect();
        final Dimension size = ch.getSize();
        final double zoom = ch.getZoom();
        final double n = 1.0;
        final Rectangle bounds2 = new Rectangle(0, rectangle.y, 0, 0);
        final Point viewPoint = ch.getViewPoint();
        boolean b2 = false;
        Label_0371: {
            if (verticalScrollBarPolicy == 22) {
                b2 = true;
                if (!z) {
                    break Label_0371;
                }
            }
            if (verticalScrollBarPolicy == 21) {
                b2 = false;
                if (!z) {
                    break Label_0371;
                }
            }
            b2 = (worldRect.y + n < viewPoint.getY() || worldRect.y + worldRect.height - n > viewPoint.getY() + size.height / zoom);
        }
        if (this.b != null && b2) {
            final int width = this.b.getPreferredSize().width;
            final Rectangle rectangle6 = rectangle;
            rectangle6.width -= width;
            bounds2.x = rectangle.x + rectangle.width;
            bounds2.width = width;
        }
        final Rectangle bounds3 = new Rectangle(rectangle.x, 0, 0, 0);
        boolean b3 = false;
        Label_0607: {
            if (horizontalScrollBarPolicy == 32) {
                b3 = true;
                if (!z) {
                    break Label_0607;
                }
            }
            if (horizontalScrollBarPolicy == 31) {
                b3 = false;
                if (!z) {
                    break Label_0607;
                }
            }
            if (b2) {
                b3 = (worldRect.x + n < viewPoint.getX() || worldRect.x + worldRect.width - n > viewPoint.getX() + (size.width - bounds2.width) / zoom);
                if (!z) {
                    break Label_0607;
                }
            }
            b3 = (worldRect.x + n < viewPoint.getX() || worldRect.x + worldRect.width - n > viewPoint.getX() + size.width / zoom);
        }
        if (this.c != null && b3) {
            final int height = this.c.getPreferredSize().height;
            final Rectangle rectangle7 = rectangle;
            rectangle7.height -= height;
            bounds3.y = rectangle.y + rectangle.height;
            bounds3.height = height;
            if (this.b != null && !b2 && verticalScrollBarPolicy != 21) {
                b2 = (worldRect.y + n < viewPoint.getY() || worldRect.y + worldRect.height - n > viewPoint.getY() + rectangle.height / zoom);
                if (b2) {
                    final int width2 = this.b.getPreferredSize().width;
                    final Rectangle rectangle8 = rectangle;
                    rectangle8.width -= width2;
                    bounds2.x = rectangle.x + rectangle.width;
                    bounds2.width = width2;
                }
            }
        }
        bounds2.height = rectangle.height;
        bounds3.width = rectangle.width;
        if (this.a != null) {
            this.a.setBounds(rectangle);
        }
        if (this.d != null && this.b != null && b2 && this.c != null && b3) {
            this.d.setBounds(rectangle.width, rectangle.height, bounds2.width, bounds3.height);
        }
        if (this.f != null) {
            this.f.setBounds(rectangle);
        }
        ch.q();
        Label_0939: {
            if (this.b != null) {
                if (b2) {
                    this.b.setBounds(bounds2);
                    this.b.setVisible(true);
                    if (!z) {
                        break Label_0939;
                    }
                }
                this.b.setVisible(false);
            }
        }
        if (this.c != null) {
            if (b3) {
                this.c.setBounds(bounds3);
                this.c.setVisible(true);
                if (!z) {
                    return;
                }
            }
            this.c.setVisible(false);
        }
    }
    
    public boolean a(final Container container) {
        final boolean z = fj.z;
        final ch ch = (ch)container;
        final int verticalScrollBarPolicy = ch.getVerticalScrollBarPolicy();
        final int horizontalScrollBarPolicy = ch.getHorizontalScrollBarPolicy();
        final Rectangle rectangle = new Rectangle(ch.getSize());
        final Insets insets = ch.getInsets();
        rectangle.x = insets.left;
        rectangle.y = insets.top;
        final Rectangle rectangle2 = rectangle;
        rectangle2.width -= insets.left + insets.right;
        final Rectangle rectangle3 = rectangle;
        rectangle3.height -= insets.top + insets.bottom;
        final Rectangle worldRect = ch.getWorldRect();
        final Dimension size = ch.getSize();
        final double zoom = ch.getZoom();
        final Rectangle rectangle4 = new Rectangle(0, rectangle.y, 0, 0);
        boolean b = false;
        Label_0191: {
            if (verticalScrollBarPolicy == 22) {
                b = true;
                if (!z) {
                    break Label_0191;
                }
            }
            if (verticalScrollBarPolicy == 21) {
                b = false;
                if (!z) {
                    break Label_0191;
                }
            }
            b = (worldRect.height > size.height / zoom);
        }
        if (this.b != null && b) {
            final int width = this.b.getPreferredSize().width;
            final Rectangle rectangle5 = rectangle;
            rectangle5.width -= width;
            rectangle4.x = rectangle.x + rectangle.width;
            rectangle4.width = width;
        }
        final Rectangle rectangle6 = new Rectangle(rectangle.x, 0, 0, 0);
        boolean b2 = false;
        Label_0368: {
            if (horizontalScrollBarPolicy == 32) {
                b2 = true;
                if (!z) {
                    break Label_0368;
                }
            }
            if (horizontalScrollBarPolicy == 31) {
                b2 = false;
                if (!z) {
                    break Label_0368;
                }
            }
            if (b) {
                b2 = (worldRect.width > (size.width - rectangle4.width) / zoom);
                if (!z) {
                    break Label_0368;
                }
            }
            b2 = (worldRect.width > size.width / zoom);
        }
        if (this.c != null && b2) {
            final int height = this.c.getPreferredSize().height;
            final Rectangle rectangle7 = rectangle;
            rectangle7.height -= height;
            rectangle6.y = rectangle.y + rectangle.height;
            rectangle6.height = height;
            if (this.b != null && !b && verticalScrollBarPolicy != 21) {
                b = (worldRect.height > rectangle.height / ch.getZoom());
            }
        }
        return b != this.b.isVisible() || b2 != this.c.isVisible();
    }
}
