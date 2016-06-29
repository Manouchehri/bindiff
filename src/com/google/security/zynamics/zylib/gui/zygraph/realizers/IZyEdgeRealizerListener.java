/*
Copyright 2011-2016 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.zylib.gui.zygraph.realizers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.ZyEdgeRealizer;

/**
 * Listener interface for classes that want to be notified about changes in realizers.
 * 
 * @param <EdgeType>
 */
public interface IZyEdgeRealizerListener<EdgeType> {
  void addedBend(double x, double y);

  void bendChanged(int index, double x, double y);

  void changedLocation(ZyEdgeRealizer<EdgeType> realizer);

  void changedVisibility(ZyEdgeRealizer<EdgeType> realizer);

  void clearedBends();

  void insertedBend(int index, double x, double y);

  /**
   * Invoked when the content of the realizer changed.
   * 
   * @param realizer The realizer whose content changed.
   */
  void regenerated(ZyEdgeRealizer<EdgeType> realizer);

  void removedBend(ZyEdgeRealizer<EdgeType> realizer, int position);
}
