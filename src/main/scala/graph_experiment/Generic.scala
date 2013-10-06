package graph_experiment

/*
 * Reasons why the other approach might be better/preferred
 *
 *   1. Generic type constraints aren't inherited. Where as type definitions
 *      can be inherited when extending an abstract class with another abstract
 *      class.
 *   2. Using type definitions, you can define the bouding classes within the
 *      containing class which is _cute_.
 *   3. The level of nesting and coupling of nodes and edges makes it very hard
 *      to write in a generic way.
 */

class Generic {

  // the following code really doesn't compile and I had a hard time mimicking the
  // _exact_ same functionality from the previous example using type definitions, so
  // I think I get the point now.

//  abstract class Node[E] {
//    def connectWith(node: Node[E]): E
//  }
//  abstract class Edge
//
//  abstract class Graph[E <: Edge, N <: Node[E]] {
//    def nodes: List[N]
//    def edges: List[E]
//    def addNode: N
//  }
//
//
//
//  abstract class DirectedGraph[E <: Edge, N <: Node[E]] extends Graph[E, N] {
//    class EdgeImpl(origin: Node[this.type], dest: Node[this.type]) extends Edge {
//      def from = origin
//      def to = dest
//    }
//    class NodeImpl[E] extends Node[E] {
//      def connectWith(node: Node[E]) : Edge = {
//        val edge = newEdge(this, node)
//      }
//    }
//
//    protected def newNode[E]: Node[E]
//    protected def newEdge[E](from: Node[E], to: Node[E]): Edge
//  }

}
