import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class LocationSinker {	
	private static final int A_BIG_NUMBER = Integer.MAX_VALUE/2;

	public static  Map<String, Trip> sink(List<Trip> trips){
		Map<String, Trip> resultMap = new HashMap<>();
		List<Edge> edges = new ArrayList<>();
		List<Node> nodes = new ArrayList<>();
		Map<Location, Node> nodeMap = new HashMap<>();
		for(Trip t : trips){
			updateMap(nodeMap, t.getStart(), nodes);
			updateMap(nodeMap, t.getEnd(), nodes);
			edges.add(new Edge(
					nodeMap.get(t.getStart()),
					nodeMap.get(t.getEnd()),
					t.getDescription(),
					t.getDuration()));
		}
		for(Node n : nodes){
			sinkAndMap(n, nodes, edges, resultMap);
		}
		return resultMap;
	}
	
	private static void reset(List<Node> nodes) {
		for(Node n : nodes){
			n.weight = A_BIG_NUMBER;
			n.walkMins = 0;
			n.mode = "";
		}
	}

	private static void sinkAndMap(Node n, List<Node> nodes, List<Edge> edges, Map<String, Trip> resultMap) {
		reset(nodes);
		n.weight = 0;
		List<Node> doneNodes = new ArrayList<>();
		List<Node> notDoneNodes = new ArrayList<>(nodes);
		Node focus = n;
		while(focus != null){
			doneNodes.add(focus);
			notDoneNodes.remove(focus);

			for(Edge e : edges){
				if(e.a != focus && e.b != focus){
					continue;
				}
				if(e.b.weight + e.t.toMin() < e.a.weight){ //update a
					e.a.weight = e.b.weight + e.t.toMin() + 3;
					String prior = e.b.mode.length() == 0 ? "" : e.b.mode + ", ";
					e.a.mode = prior + e.mode;
					if(e.mode.equals("Walk")){
						e.a.walkMins += e.t.toMin();
					}
				}
				if(e.a.weight + e.t.toMin() < e.b.weight){ //update b
					e.b.weight = e.a.weight + e.t.toMin() + 3;
					String prior = e.a.mode.length() == 0 ? "" : e.a.mode + ", ";
					e.b.mode = prior + e.mode;
					if(e.mode.equals("Walk")){
						e.b.walkMins += e.t.toMin();
					}
				}
			}
			focus = findLightestNodeIn(notDoneNodes);
		}
		for(Node d : doneNodes){
			resultMap.put(n.l.name() + d.l.name(), new Trip(d.mode, d.weight, n.l, d.l, d.walkMins));
		}
	}

	private static Node findLightestNodeIn(List<Node> list) {
		int weight = Integer.MAX_VALUE;
		Node lightest = null;
		for(Node x : list){
			if(x.weight < weight){
				weight = x.weight;
				lightest = x;
			}
		}
		return lightest;
	}

	private static void updateMap(Map<Location, Node> nodeMap, Location l, List<Node> nodes) {
		if(!nodeMap.containsKey(l)){
			nodeMap.put(l, new Node(l));
			nodes.add(nodeMap.get(l));
		}
	}

	static class Node{
		Location l;
		int weight;
		int walkMins;
		String mode;
		
		Node(Location l){
			this.l = l;
		}
	}
	
	static class Edge{
		Node a;
		Node b;
		String mode;
		Time t;
		
		Edge(Node a, Node b, String mode, Time min){
			this.a = a;
			this.b = b;
			this.mode = mode;
			this.t = min;
		}
	}
}
