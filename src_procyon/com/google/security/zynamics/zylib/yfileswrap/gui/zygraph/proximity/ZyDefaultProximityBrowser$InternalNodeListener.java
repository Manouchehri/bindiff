package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity;

import com.google.security.zynamics.zylib.gui.zygraph.nodes.*;
import java.awt.*;

class ZyDefaultProximityBrowser$InternalNodeListener implements IViewNodeListener
{
    private double m_x;
    private double m_y;
    private final ZyProximityNode m_infoNode;
    final /* synthetic */ ZyDefaultProximityBrowser this$0;
    
    public ZyDefaultProximityBrowser$InternalNodeListener(final ZyDefaultProximityBrowser this$0, final double x, final double y, final ZyProximityNode infoNode) {
        this.this$0 = this$0;
        this.m_x = x;
        this.m_y = y;
        this.m_infoNode = infoNode;
    }
    
    @Override
    public void changedBorderColor(final IViewNode viewNode, final Color color) {
    }
    
    @Override
    public void changedColor(final IViewNode viewNode, final Color color) {
    }
    
    @Override
    public void changedSelection(final IViewNode viewNode, final boolean b) {
    }
    
    @Override
    public void changedVisibility(final IViewNode viewNode, final boolean b) {
    }
    
    @Override
    public void heightChanged(final IViewNode viewNode, final double n) {
    }
    
    @Override
    public void widthChanged(final IViewNode viewNode, final double n) {
    }
    
    @Override
    public void xposChanged(final IViewNode viewNode, final double x) {
        this.m_infoNode.getRealizer().setX(this.m_infoNode.getX() + x - this.m_x);
        this.m_x = x;
    }
    
    @Override
    public void yposChanged(final IViewNode viewNode, final double y) {
        this.m_infoNode.getRealizer().setY(this.m_infoNode.getY() + y - this.m_y);
        this.m_y = y;
    }
}
