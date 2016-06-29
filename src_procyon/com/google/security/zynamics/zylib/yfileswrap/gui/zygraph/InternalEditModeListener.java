package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.general.*;
import java.awt.event.*;
import java.util.*;
import y.h.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.*;

public class InternalEditModeListener implements IZyEditModeListener
{
    private final ListenerProvider m_graphListeners;
    
    public InternalEditModeListener(final ListenerProvider graphListeners) {
        this.m_graphListeners = graphListeners;
    }
    
    @Override
    public void edgeClicked(final Object o, final MouseEvent mouseEvent, final double n, final double n2) {
        for (final IZyGraphListener zyGraphListener : this.m_graphListeners) {
            try {
                zyGraphListener.edgeClicked(o, mouseEvent, n, n2);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void edgeLabelEntered(final aA aa, final MouseEvent mouseEvent) {
        for (final IZyGraphListener zyGraphListener : this.m_graphListeners) {
            try {
                zyGraphListener.edgeLabelEntered(aa, mouseEvent);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void edgeLabelLeft(final aA aa) {
        for (final IZyGraphListener zyGraphListener : this.m_graphListeners) {
            try {
                zyGraphListener.edgeLabelExited(aa);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void nodeClicked(final Object o, final MouseEvent mouseEvent, final double n, final double n2) {
        for (final IZyGraphListener zyGraphListener : this.m_graphListeners) {
            try {
                zyGraphListener.nodeClicked(o, mouseEvent, n, n2);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void nodeEntered(final Object o, final MouseEvent mouseEvent) {
        for (final IZyGraphListener zyGraphListener : this.m_graphListeners) {
            try {
                zyGraphListener.nodeEntered(o, mouseEvent);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void nodeHovered(final Object o, final double n, final double n2) {
        for (final IZyGraphListener zyGraphListener : this.m_graphListeners) {
            try {
                zyGraphListener.nodeHovered(o, n, n2);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void nodeLeft(final Object o) {
        for (final IZyGraphListener zyGraphListener : this.m_graphListeners) {
            try {
                zyGraphListener.nodeLeft(o);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void proximityBrowserNodeClicked(final ZyProximityNode zyProximityNode, final MouseEvent mouseEvent, final double n, final double n2) {
        for (final IZyGraphListener zyGraphListener : this.m_graphListeners) {
            try {
                zyGraphListener.proximityBrowserNodeClicked(zyProximityNode, mouseEvent, n, n2);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
