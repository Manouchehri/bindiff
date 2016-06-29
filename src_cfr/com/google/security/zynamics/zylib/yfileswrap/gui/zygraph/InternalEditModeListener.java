/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph;

import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyEditModeListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.IZyGraphListener;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.proximity.ZyProximityNode;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import y.h.aA;

public class InternalEditModeListener
implements IZyEditModeListener {
    private final ListenerProvider m_graphListeners;

    public InternalEditModeListener(ListenerProvider listenerProvider) {
        this.m_graphListeners = listenerProvider;
    }

    @Override
    public void edgeClicked(Object object, MouseEvent mouseEvent, double d2, double d3) {
        Iterator iterator = this.m_graphListeners.iterator();
        while (iterator.hasNext()) {
            IZyGraphListener iZyGraphListener = (IZyGraphListener)iterator.next();
            try {
                iZyGraphListener.edgeClicked(object, mouseEvent, d2, d3);
            }
            catch (Exception var9_7) {
                var9_7.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void edgeLabelEntered(aA aA2, MouseEvent mouseEvent) {
        Iterator iterator = this.m_graphListeners.iterator();
        while (iterator.hasNext()) {
            IZyGraphListener iZyGraphListener = (IZyGraphListener)iterator.next();
            try {
                iZyGraphListener.edgeLabelEntered(aA2, mouseEvent);
            }
            catch (Exception var5_5) {
                var5_5.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void edgeLabelLeft(aA aA2) {
        Iterator iterator = this.m_graphListeners.iterator();
        while (iterator.hasNext()) {
            IZyGraphListener iZyGraphListener = (IZyGraphListener)iterator.next();
            try {
                iZyGraphListener.edgeLabelExited(aA2);
            }
            catch (Exception var4_4) {
                var4_4.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void nodeClicked(Object object, MouseEvent mouseEvent, double d2, double d3) {
        Iterator iterator = this.m_graphListeners.iterator();
        while (iterator.hasNext()) {
            IZyGraphListener iZyGraphListener = (IZyGraphListener)iterator.next();
            try {
                iZyGraphListener.nodeClicked(object, mouseEvent, d2, d3);
            }
            catch (Exception var9_7) {
                var9_7.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void nodeEntered(Object object, MouseEvent mouseEvent) {
        Iterator iterator = this.m_graphListeners.iterator();
        while (iterator.hasNext()) {
            IZyGraphListener iZyGraphListener = (IZyGraphListener)iterator.next();
            try {
                iZyGraphListener.nodeEntered(object, mouseEvent);
            }
            catch (Exception var5_5) {
                var5_5.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void nodeHovered(Object object, double d2, double d3) {
        Iterator iterator = this.m_graphListeners.iterator();
        while (iterator.hasNext()) {
            IZyGraphListener iZyGraphListener = (IZyGraphListener)iterator.next();
            try {
                iZyGraphListener.nodeHovered(object, d2, d3);
            }
            catch (Exception var8_6) {
                var8_6.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void nodeLeft(Object object) {
        Iterator iterator = this.m_graphListeners.iterator();
        while (iterator.hasNext()) {
            IZyGraphListener iZyGraphListener = (IZyGraphListener)iterator.next();
            try {
                iZyGraphListener.nodeLeft(object);
            }
            catch (Exception var4_4) {
                var4_4.printStackTrace();
                continue;
            }
        }
    }

    @Override
    public void proximityBrowserNodeClicked(ZyProximityNode zyProximityNode, MouseEvent mouseEvent, double d2, double d3) {
        Iterator iterator = this.m_graphListeners.iterator();
        while (iterator.hasNext()) {
            IZyGraphListener iZyGraphListener = (IZyGraphListener)iterator.next();
            try {
                iZyGraphListener.proximityBrowserNodeClicked(zyProximityNode, mouseEvent, d2, d3);
            }
            catch (Exception var9_7) {
                var9_7.printStackTrace();
                continue;
            }
        }
    }
}

