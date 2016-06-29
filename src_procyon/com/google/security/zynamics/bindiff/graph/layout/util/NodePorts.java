package com.google.security.zynamics.bindiff.graph.layout.util;

import y.c.*;
import y.h.*;
import y.f.*;

public class NodePorts
{
    private final D topLeftPorts;
    private final D topMiddlePorts;
    private final D topRightPorts;
    private final D bottomLeftPorts;
    private final D bottomMiddlePorts;
    private final D bottomRightPorts;
    private final ay candidateSet;
    
    public NodePorts(final q q, final bu bu) {
        this.topLeftPorts = new D();
        this.topMiddlePorts = new D();
        this.topRightPorts = new D();
        this.bottomLeftPorts = new D();
        this.bottomMiddlePorts = new D();
        this.bottomRightPorts = new D();
        this.candidateSet = new ay();
        final double n = bu.p(q) * 0.5;
        final double n2 = bu.p(q) / 3.0;
        final double n3 = bu.q(q) * 0.5;
        final double n4 = n2 / (q.b() + 1);
        double n5 = 0.0;
        for (int i = 0; i < q.b(); ++i) {
            n5 += n4;
            final ax a = ax.a(n5 - n, -n3, 1);
            this.topLeftPorts.add(a);
            this.candidateSet.a(a, 1);
        }
        double n6 = n5 + n4;
        for (int j = 0; j < q.b(); ++j) {
            n6 += n4;
            final ax a2 = ax.a(n6 - n, -n3, 1);
            this.topMiddlePorts.add(a2);
            this.candidateSet.a(a2, 1);
        }
        double n7 = n6 + n4;
        for (int k = 0; k < q.b(); ++k) {
            n7 += n4;
            final ax a3 = ax.a(n7 - n, -n3, 1);
            this.topRightPorts.add(a3);
            this.candidateSet.a(a3, 1);
        }
        final double n8 = n2 / (q.c() + 1);
        double n9 = 0.0;
        for (int l = 0; l < q.c(); ++l) {
            n9 += n8;
            final ax a4 = ax.a(n9 - n, n3, 2);
            this.bottomLeftPorts.add(a4);
            this.candidateSet.a(a4, 1);
        }
        double n10 = n9 + n8;
        for (int n11 = 0; n11 < q.c(); ++n11) {
            n10 += n8;
            final ax a5 = ax.a(n10 - n, n3, 2);
            this.bottomMiddlePorts.add(a5);
            this.candidateSet.a(a5, 1);
        }
        double n12 = n10 + n8;
        for (int n13 = 0; n13 < q.c(); ++n13) {
            n12 += n8;
            final ax a6 = ax.a(n12 - n, n3, 2);
            this.bottomRightPorts.add(a6);
            this.candidateSet.a(a6, 1);
        }
    }
    
    public D getBottomLeftPorts() {
        return this.bottomLeftPorts;
    }
    
    public D getBottomMiddlePorts() {
        return this.bottomMiddlePorts;
    }
    
    public D getBottomRightPorts() {
        return this.bottomRightPorts;
    }
    
    public ay getCandideSet() {
        return this.candidateSet;
    }
    
    public D getTopLeftPorts() {
        return this.topLeftPorts;
    }
    
    public D getTopMiddlePorts() {
        return this.topMiddlePorts;
    }
    
    public D getTopRightPorts() {
        return this.topRightPorts;
    }
}
