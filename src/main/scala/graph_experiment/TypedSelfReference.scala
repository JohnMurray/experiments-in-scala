package graph_experiment

/*
 * I'm not really sure what the difference is between using normal
 * generics or type definitions. So we'll do a little experiment to
 * see if we can do it both ways.
 *
 * Update: Couldn't really duplicate (easily) using generics in this case
 * Update: Can see where it has advantages, although still not sure when
 *         I should use this vs. generics.
 */

object TypedSelfReference {

  abstract class Graph {
    type Edge
    type Node <: NodeIntf
    abstract class NodeIntf {
      def connectWith(node: Node): Edge
    }
    def nodes: List[Node]
    def edges: List[Edge]
    def addNode: Node
  }

  abstract class DirectedGraph extends Graph {
    type Edge <: EdgeImpl
    class EdgeImpl(origin: Node, dest: Node) {
      def from = origin
      def to = dest
    }
    class NodeImpl extends NodeIntf {
      self: Node =>
      def connectWith(node: Node): Edge = {
        val edge = newEdge(this, node)
        edges = edge :: edges
        edge
      }
    }
    protected def newNode: Node
    protected def newEdge(from: Node, to: Node): Edge
    var nodes: List[Node] = Nil
    var edges: List[Edge] = Nil
    def addNode: Node = {
      val node = newNode
      nodes = node :: nodes
      node
    }
  }

  class ConcreteDirectedGraph extends DirectedGraph {
    type Edge = EdgeImpl
    type Node = NodeImpl
    protected def newNode: Node = new NodeImpl
    protected def newEdge(f: Node, t: Node): Edge =
      new EdgeImpl(f, t)
  }


}

object GraphTest {
  import graph_experiment.TypedSelfReference._

  def main(args: Array[String]) : Unit = {
    val g: Graph = new ConcreteDirectedGraph
    val n1 = g.addNode
    val n2 = g.addNode
    val n3 = g.addNode
    n1.connectWith(n2)
    n2.connectWith(n3)
    n1.connectWith(n3)
  }
}
