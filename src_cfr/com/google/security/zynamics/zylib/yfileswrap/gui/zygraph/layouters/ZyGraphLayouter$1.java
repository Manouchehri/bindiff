/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.layouters;

import com.google.security.zynamics.zylib.gui.zygraph.layouters.CircularStyle;
import com.google.security.zynamics.zylib.gui.zygraph.layouters.HierarchicStyle;

class ZyGraphLayouter$1 {
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$CircularStyle;
    static final /* synthetic */ int[] $SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle;

    static {
        $SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle = new int[HierarchicStyle.values().length];
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.OCTLINEAR_OPTIMAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.ORTHOGONAL_OPTIMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.POLYLINE_OPTIMAL.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.OCTLINEAR_TOPMOST.ordinal()] = 4;
        }
        catch (NoSuchFieldError var0_3) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.ORTHOGONAL_TOPMOST.ordinal()] = 5;
        }
        catch (NoSuchFieldError var0_4) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.POLYLINE_TOPMOST.ordinal()] = 6;
        }
        catch (NoSuchFieldError var0_5) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.OCTLINEAR_TIGHT_TREE.ordinal()] = 7;
        }
        catch (NoSuchFieldError var0_6) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.ORTHOGONAL_TIGHT_TREE.ordinal()] = 8;
        }
        catch (NoSuchFieldError var0_7) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.POLYLINE_TIGHT_TREE.ordinal()] = 9;
        }
        catch (NoSuchFieldError var0_8) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.OCTLINEAR_BFS.ordinal()] = 10;
        }
        catch (NoSuchFieldError var0_9) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.ORTHOGONAL_BFS.ordinal()] = 11;
        }
        catch (NoSuchFieldError var0_10) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$HierarchicStyle[HierarchicStyle.POLYLINE_BFS.ordinal()] = 12;
        }
        catch (NoSuchFieldError var0_11) {
            // empty catch block
        }
        $SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$CircularStyle = new int[CircularStyle.values().length];
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$CircularStyle[CircularStyle.COMPACT.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0_12) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$CircularStyle[CircularStyle.ISOLATED.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_13) {
            // empty catch block
        }
        try {
            ZyGraphLayouter$1.$SwitchMap$com$google$security$zynamics$zylib$gui$zygraph$layouters$CircularStyle[CircularStyle.SINGLE_CIRCLE.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError var0_14) {
            // empty catch block
        }
    }
}

