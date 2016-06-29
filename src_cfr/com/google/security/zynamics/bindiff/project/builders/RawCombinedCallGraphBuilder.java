/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.builders;

import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RawCombinedCallGraphBuilder {
    private static List buildCombinedCalls(RawCallGraph rawCallGraph, RawCallGraph rawCallGraph2, Map map) {
        IAddress iAddress;
        RawFunction rawFunction;
        Object object;
        RawFunction rawFunction2;
        RawCombinedFunction rawCombinedFunction;
        RawFunction rawFunction3;
        IAddress iAddress2;
        IAddress iAddress3;
        Object object2;
        IAddress iAddress4;
        RawFunction rawFunction4;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (RawCall rawCall2 : rawCallGraph.getEdges()) {
            rawFunction3 = (RawFunction)rawCall2.getSource();
            rawFunction = (RawFunction)rawCall2.getTarget();
            rawFunction4 = rawFunction3.getMatchedFunction();
            rawFunction2 = rawFunction.getMatchedFunction();
            iAddress3 = rawFunction3.getAddress();
            iAddress4 = rawFunction.getAddress();
            iAddress = rawFunction4 == null ? null : rawFunction4.getAddress();
            iAddress2 = rawFunction2 == null ? null : rawFunction2.getAddress();
            object2 = rawCall2.getMatchedCall();
            if (object2 != null && object2.isChanged()) {
                object2 = null;
            }
            rawCombinedFunction = (RawCombinedFunction)map.get(new Pair(iAddress3, iAddress));
            object = (RawCombinedFunction)map.get(new Pair(iAddress4, iAddress2));
            RawCombinedCall rawCombinedCall = new RawCombinedCall(rawCombinedFunction, (RawCombinedFunction)object, rawCall2, (RawCall)object2);
            arrayList.add(rawCombinedCall);
        }
        Iterator iterator = rawCallGraph2.getEdges().iterator();
        while (iterator.hasNext()) {
            RawCall rawCall2;
            rawCall2 = (RawCall)iterator.next();
            if (rawCall2.getMatchedCall() != null && !rawCall2.getMatchedCall().isChanged()) continue;
            rawFunction3 = (RawFunction)rawCall2.getSource();
            rawFunction = (RawFunction)rawCall2.getTarget();
            rawFunction4 = rawFunction3.getMatchedFunction();
            rawFunction2 = rawFunction.getMatchedFunction();
            iAddress3 = rawFunction3.getAddress();
            iAddress4 = rawFunction.getAddress();
            iAddress = rawFunction4 == null ? null : rawFunction4.getAddress();
            iAddress2 = rawFunction2 == null ? null : rawFunction2.getAddress();
            object2 = (RawCombinedFunction)map.get(new Pair(iAddress, iAddress3));
            rawCombinedFunction = (RawCombinedFunction)map.get(new Pair(iAddress2, iAddress4));
            object = new RawCombinedCall((RawCombinedFunction)object2, rawCombinedFunction, null, rawCall2);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static List buildCombinedFunctions(MatchData matchData, RawCallGraph rawCallGraph, RawCallGraph rawCallGraph2, Map map) {
        IAddress iAddress2;
        IAddress iAddress;
        ArrayList<RawCombinedFunction> arrayList = new ArrayList<RawCombinedFunction>();
        for (RawFunction rawFunction222 : rawCallGraph.getNodes()) {
            void rawFunction;
            iAddress2 = rawFunction222.getAddress();
            iAddress = matchData.getSecondaryFunctionAddr(iAddress2);
            Object var9_10 = null;
            if (iAddress != null) {
                RawFunction rawFunction2 = rawCallGraph2.getFunction(iAddress);
            }
            RawCombinedFunction rawCombinedFunction = new RawCombinedFunction(rawFunction222, (RawFunction)rawFunction);
            map.put(new Pair(iAddress2, iAddress), rawCombinedFunction);
            arrayList.add(rawCombinedFunction);
        }
        Iterator iterator = rawCallGraph2.getNodes().iterator();
        while (iterator.hasNext()) {
            RawFunction rawFunction222;
            rawFunction222 = (RawFunction)iterator.next();
            iAddress2 = rawFunction222.getAddress();
            iAddress = matchData.getPrimaryFunctionAddr(iAddress2);
            if (iAddress != null) continue;
            RawCombinedFunction rawCombinedFunction = new RawCombinedFunction(null, rawFunction222);
            map.put(new Pair(null, iAddress2), rawCombinedFunction);
            arrayList.add(rawCombinedFunction);
        }
        return arrayList;
    }

    public static RawCombinedCallGraph buildCombinedCallgraph(MatchData matchData, RawCallGraph rawCallGraph, RawCallGraph rawCallGraph2) {
        Logger.logInfo(" - Building combined call graph", new Object[0]);
        try {
            HashMap hashMap = new HashMap();
            List list = RawCombinedCallGraphBuilder.buildCombinedFunctions(matchData, rawCallGraph, rawCallGraph2, hashMap);
            List list2 = RawCombinedCallGraphBuilder.buildCombinedCalls(rawCallGraph, rawCallGraph2, hashMap);
            hashMap.clear();
            return new RawCombinedCallGraph(list, list2);
        }
        catch (Exception var3_4) {
            String string;
            String string2 = String.valueOf("Combined call graph creation failed. ");
            String string3 = String.valueOf(var3_4.getMessage());
            if (string3.length() != 0) {
                string = string2.concat(string3);
                throw new GraphCreationException(string);
            }
            string = new String(string2);
            throw new GraphCreationException(string);
        }
    }
}

