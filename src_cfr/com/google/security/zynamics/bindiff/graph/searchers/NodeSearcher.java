/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLabelContent;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.ZyLineContent;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import y.h.fj;

public class NodeSearcher {
    public static ArrayList search(ZyGraphNode zyGraphNode, String string, boolean bl2, boolean bl3) {
        ArrayList<SearchResult> arrayList = new ArrayList<SearchResult>();
        if (string.isEmpty()) {
            return arrayList;
        }
        IZyNodeRealizer iZyNodeRealizer = zyGraphNode.getRealizer();
        ZyLabelContent zyLabelContent = iZyNodeRealizer.getNodeContent();
        int n2 = 0;
        Iterator iterator = zyLabelContent.iterator();
        while (iterator.hasNext()) {
            ZyLineContent zyLineContent = (ZyLineContent)iterator.next();
            String string2 = zyLineContent.getText();
            if (!bl3) {
                string2 = string2.toLowerCase();
            }
            int n3 = 0;
            do {
                Object object;
                int n4;
                if (bl2) {
                    int n5;
                    Pattern pattern = bl3 ? Pattern.compile(string) : Pattern.compile(string, 2);
                    object = pattern.matcher(string2);
                    boolean bl4 = object.find(n3);
                    if (!bl4) break;
                    int n6 = object.start();
                    if (n6 != (n5 = object.end())) {
                        List list = zyLineContent.getBackgroundStyleRunData(n6, n5);
                        Color color = iZyNodeRealizer.getRealizer().getLineColor();
                        arrayList.add(new SearchResult(zyGraphNode, n2, n6, n5 - n6, string2, list, color));
                    }
                    n3 = n5;
                    if (n6 == n5) {
                        ++n3;
                    }
                    if (object.end() != string2.length()) continue;
                    break;
                }
                if (!bl3) {
                    string = string.toLowerCase();
                }
                if ((n4 = string2.indexOf(string, n3)) == -1) break;
                object = zyLineContent.getBackgroundStyleRunData(n4, n4 + string.length() - 1);
                Color color = iZyNodeRealizer.getRealizer().getLineColor();
                arrayList.add(new SearchResult(zyGraphNode, n2, n4, string.length(), string2, (List)object, color));
                n3 = n4 + string.length();
            } while (true);
            ++n2;
        }
        return arrayList;
    }
}

