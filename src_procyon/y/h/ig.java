package y.h;

import javax.swing.*;
import java.awt.*;

class ig implements LayoutManager
{
    static final Object a;
    static final Object b;
    static final Object c;
    
    public void addLayoutComponent(final String s, final Component component) {
    }
    
    public void removeLayoutComponent(final Component component) {
    }
    
    public Dimension preferredLayoutSize(final Container container) {
        return new Dimension(1, 1);
    }
    
    public Dimension minimumLayoutSize(final Container container) {
        return new Dimension(1, 1);
    }
    
    public void layoutContainer(final Container container) {
        final boolean z = fj.z;
        synchronized (container.getTreeLock()) {
            int i = 0;
            while (i < container.getComponentCount()) {
                final Component component2;
                final Component component = component2 = container.getComponent(i);
                if (z) {
                    return;
                }
                Label_0270: {
                    if (component2 instanceof JComponent) {
                        final JComponent component3 = (JComponent)component;
                        final Object clientProperty = component3.getClientProperty(ig.b);
                        if (clientProperty instanceof Point) {
                            final Point point = (Point)clientProperty;
                            final Dimension dimension = (Dimension)component3.getClientProperty(ig.c);
                            final Dimension preferredSize = component.getPreferredSize();
                            Label_0166: {
                                if (dimension != null) {
                                    final Dimension dimension2 = preferredSize;
                                    final Dimension dimension3 = dimension;
                                    final int max = Math.max(preferredSize.width, dimension.width);
                                    dimension3.width = max;
                                    dimension2.width = max;
                                    final Dimension dimension4 = preferredSize;
                                    final Dimension dimension5 = dimension;
                                    final int max2 = Math.max(preferredSize.height, dimension.height);
                                    dimension5.height = max2;
                                    dimension4.height = max2;
                                    if (!z) {
                                        break Label_0166;
                                    }
                                }
                                component3.putClientProperty(ig.c, preferredSize);
                            }
                            if (component.isVisible()) {
                                if (Boolean.TRUE.equals(component3.getClientProperty(ig.a))) {
                                    component.setBounds(point.x - preferredSize.width / 2, point.y - preferredSize.height / 2, preferredSize.width, preferredSize.height);
                                    if (!z) {
                                        break Label_0270;
                                    }
                                }
                                component.setBounds(point.x, point.y, preferredSize.width, preferredSize.height);
                            }
                        }
                    }
                }
                ++i;
                if (z) {
                    break;
                }
            }
        }
    }
    
    static {
        a = "LayoutManager.CENTER_KEY";
        b = "LayoutManager.LOCATION_KEY";
        c = "LayoutManager.DIMENSION_KEY";
    }
}
