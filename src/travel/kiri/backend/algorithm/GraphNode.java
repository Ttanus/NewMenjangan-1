package travel.kiri.backend.algorithm;


/**
 * Representing a graph node. Reference: worker.cc/GraphNode
 * @author PascalAlfadian
 *
 */
public class GraphNode{
	/**
	 * Location (lat/lon) of this node.
	 */
	LatLon location;
	
	/**
	 * List of out-edges from this node.
	 */
	UnrolledLinkedList<GraphEdge> edges;
	
	/**
	 * A reverse-reference to the track information.
	 */
	Track track;
	
	/**
	 * Determines whether this is a transfer node (whether a person can
	 * alight or board the public transport from this node).
	 */
	boolean isTransferNode;
	
	/**
	 * Create new instance of the graph node.
	 * @param location The latitude/longitude.
	 * @param track the reverse-reference to the track information.
	 */
	public GraphNode(LatLon location, Track track) {
		this.location = location;
		this.track = track;
		this.isTransferNode = false;
		edges = new UnrolledLinkedList<GraphEdge>();
	}
	
	public UnrolledLinkedList<GraphEdge> getEdges()
	{
		return edges;
	}
	
	public void push_back(int node, float weight)
	{
		GraphEdge edge = new GraphEdge(node, weight);
		edges.add(edge);
	}
	
	public void link(GraphNode nextNode)
	{
		this.edges.addAll(nextNode.getEdges());
	}
	
	public LatLon getLocation()
	{
		return location;
	}
	
	public Track getTrack()
	{
		return track;
	}
	
	public String toString()
	{		
		return location + " - "+ (isTransferNode?"Transfer":"Not");		
	}
	
	public void setTransferNode(boolean b)
	{
		isTransferNode = b;
	}
	
	public boolean isTransferNode()
	{
		return isTransferNode;
	}
}
