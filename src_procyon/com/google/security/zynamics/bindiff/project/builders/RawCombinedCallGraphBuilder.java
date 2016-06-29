package com.google.security.zynamics.bindiff.project.builders;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.log.*;
import java.util.*;
import com.google.security.zynamics.bindiff.exceptions.*;

public class RawCombinedCallGraphBuilder
{
    private static List buildCombinedCalls(final RawCallGraph rawCallGraph, final RawCallGraph rawCallGraph2, final Map map) {
        final ArrayList<RawCombinedCall> list = new ArrayList<RawCombinedCall>();
        for (final RawCall rawCall : rawCallGraph.getEdges()) {
            final RawFunction rawFunction = (RawFunction)rawCall.getSource();
            final RawFunction rawFunction2 = (RawFunction)rawCall.getTarget();
            final RawFunction matchedFunction = rawFunction.getMatchedFunction();
            final RawFunction matchedFunction2 = rawFunction2.getMatchedFunction();
            final IAddress address = rawFunction.getAddress();
            final IAddress address2 = rawFunction2.getAddress();
            final IAddress address3 = (matchedFunction == null) ? null : matchedFunction.getAddress();
            final IAddress address4 = (matchedFunction2 == null) ? null : matchedFunction2.getAddress();
            RawCall matchedCall = rawCall.getMatchedCall();
            if (matchedCall != null && matchedCall.isChanged()) {
                matchedCall = null;
            }
            list.add(new RawCombinedCall(map.get(new Pair(address, address3)), map.get(new Pair(address2, address4)), rawCall, matchedCall));
        }
        for (final RawCall rawCall2 : rawCallGraph2.getEdges()) {
            if (rawCall2.getMatchedCall() == null || rawCall2.getMatchedCall().isChanged()) {
                final RawFunction rawFunction3 = (RawFunction)rawCall2.getSource();
                final RawFunction rawFunction4 = (RawFunction)rawCall2.getTarget();
                final RawFunction matchedFunction3 = rawFunction3.getMatchedFunction();
                final RawFunction matchedFunction4 = rawFunction4.getMatchedFunction();
                list.add(new RawCombinedCall(map.get(new Pair((matchedFunction3 == null) ? null : matchedFunction3.getAddress(), rawFunction3.getAddress())), map.get(new Pair((matchedFunction4 == null) ? null : matchedFunction4.getAddress(), rawFunction4.getAddress())), null, rawCall2));
            }
        }
        return list;
    }
    
    private static List buildCombinedFunctions(final MatchData matchData, final RawCallGraph rawCallGraph, final RawCallGraph rawCallGraph2, final Map map) {
        final ArrayList<RawCombinedFunction> list = new ArrayList<RawCombinedFunction>();
        for (final RawFunction rawFunction : rawCallGraph.getNodes()) {
            final IAddress address = rawFunction.getAddress();
            final IAddress secondaryFunctionAddr = matchData.getSecondaryFunctionAddr(address);
            RawFunction function = null;
            if (secondaryFunctionAddr != null) {
                function = rawCallGraph2.getFunction(secondaryFunctionAddr);
            }
            final RawCombinedFunction rawCombinedFunction = new RawCombinedFunction(rawFunction, function);
            map.put(new Pair(address, secondaryFunctionAddr), rawCombinedFunction);
            list.add(rawCombinedFunction);
        }
        for (final RawFunction rawFunction2 : rawCallGraph2.getNodes()) {
            final IAddress address2 = rawFunction2.getAddress();
            if (matchData.getPrimaryFunctionAddr(address2) == null) {
                final RawCombinedFunction rawCombinedFunction2 = new RawCombinedFunction(null, rawFunction2);
                map.put(new Pair(null, address2), rawCombinedFunction2);
                list.add(rawCombinedFunction2);
            }
        }
        return list;
    }
    
    public static RawCombinedCallGraph buildCombinedCallgraph(final MatchData matchData, final RawCallGraph rawCallGraph, final RawCallGraph rawCallGraph2) {
        Logger.logInfo(" - Building combined call graph", new Object[0]);
        try {
            final HashMap hashMap = new HashMap();
            final List buildCombinedFunctions = buildCombinedFunctions(matchData, rawCallGraph, rawCallGraph2, hashMap);
            final List buildCombinedCalls = buildCombinedCalls(rawCallGraph, rawCallGraph2, hashMap);
            hashMap.clear();
            return new RawCombinedCallGraph(buildCombinedFunctions, buildCombinedCalls);
        }
        catch (Exception ex) {
            final String value = String.valueOf("Combined call graph creation failed. ");
            final String value2 = String.valueOf(ex.getMessage());
            throw new GraphCreationException((value2.length() != 0) ? value.concat(value2) : new String(value));
        }
    }
}
