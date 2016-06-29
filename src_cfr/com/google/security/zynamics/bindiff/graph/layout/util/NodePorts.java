/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.layout.util;

import y.c.D;
import y.c.q;
import y.f.ax;
import y.f.ay;
import y.h.bu;

public class NodePorts {
    private final D topLeftPorts = new D();
    private final D topMiddlePorts = new D();
    private final D topRightPorts = new D();
    private final D bottomLeftPorts = new D();
    private final D bottomMiddlePorts = new D();
    private final D bottomRightPorts = new D();
    private final ay candidateSet = new ay();

    public NodePorts(q q2, bu bu2) {
        ax ax2;
        int n2;
        double d2 = bu2.p(q2);
        double d3 = d2 * 0.5;
        double d4 = bu2.p(q2) / 3.0;
        double d5 = bu2.q(q2) * 0.5;
        double d6 = d4 / (double)(q2.b() + 1);
        double d7 = 0.0;
        for (n2 = 0; n2 < q2.b(); ++n2) {
            ax2 = ax.a((d7 += d6) - d3, - d5, 1);
            this.topLeftPorts.add(ax2);
            this.candidateSet.a(ax2, 1);
        }
        d7 += d6;
        for (n2 = 0; n2 < q2.b(); ++n2) {
            ax2 = ax.a((d7 += d6) - d3, - d5, 1);
            this.topMiddlePorts.add(ax2);
            this.candidateSet.a(ax2, 1);
        }
        d7 += d6;
        for (n2 = 0; n2 < q2.b(); ++n2) {
            ax2 = ax.a((d7 += d6) - d3, - d5, 1);
            this.topRightPorts.add(ax2);
            this.candidateSet.a(ax2, 1);
        }
        d6 = d4 / (double)(q2.c() + 1);
        d7 = 0.0;
        for (n2 = 0; n2 < q2.c(); ++n2) {
            ax2 = ax.a((d7 += d6) - d3, d5, 2);
            this.bottomLeftPorts.add(ax2);
            this.candidateSet.a(ax2, 1);
        }
        d7 += d6;
        for (n2 = 0; n2 < q2.c(); ++n2) {
            ax2 = ax.a((d7 += d6) - d3, d5, 2);
            this.bottomMiddlePorts.add(ax2);
            this.candidateSet.a(ax2, 1);
        }
        d7 += d6;
        n2 = 0;
        while (n2 < q2.c()) {
            ax2 = ax.a((d7 += d6) - d3, d5, 2);
            this.bottomRightPorts.add(ax2);
            this.candidateSet.a(ax2, 1);
            ++n2;
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

