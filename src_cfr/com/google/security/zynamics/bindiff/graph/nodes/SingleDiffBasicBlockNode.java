/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.nodes;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.CStyleRunData;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import y.c.q;

public class SingleDiffBasicBlockNode
extends SingleDiffNode {
    public SingleDiffBasicBlockNode(q q2, IZyNodeRealizer iZyNodeRealizer, SingleViewNode singleViewNode, ESide eSide) {
        super(q2, iZyNodeRealizer, singleViewNode, eSide);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    protected void onSelectionChanged() {
        v0 = var1_1 = this.getSide() == ESide.PRIMARY ? Colors.PRIMARY_BASE : Colors.SECONDARY_BASE;
        if (this.isSelected()) {
            var1_1 = var1_1.darker();
        }
        var2_2 = this.getRealizer().getNodeContent().getContent().iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            if (var2_2.hasNext() == false) return;
            var3_3 = (ZyLineContent)var2_2.next();
            var4_4 = var3_3.getText().length();
            if (var4_4 <= 0) ** GOTO lbl-1000
            var5_5 = var3_3.getBackgroundStyleRunData(0, var4_4 - 1);
            var6_6 = var5_5.iterator();
            do {
                if (!var6_6.hasNext()) continue block0;
                var7_7 = (CStyleRunData)var6_6.next();
                var8_8 = var7_7.getColor();
                if (var8_8 == Colors.SEARCH_HIGHLIGHT_COLOR || var8_8 == null) continue;
                if (var4_4 == var7_7.getEnd()) {
                    var3_3.setBackgroundColor(var7_7.getStart(), var7_7.getLength(), var1_1);
                    continue;
                }
                var3_3.setBackgroundColor(var7_7.getStart(), var7_7.getLength() - 1, var1_1);
            } while (true);
            break;
        } while (true);
    }
}

