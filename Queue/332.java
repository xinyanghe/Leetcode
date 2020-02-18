class Solution {
    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList();

    void visit(String airport) {
        while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
            visit(targets.get(airport).poll());
        route.add(0, airport);
    }
    
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null || tickets.size() == 0 || tickets.get(0).size() == 0)
            return new LinkedList<>();
        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).add(ticket.get(1));
        visit("JFK");
        return route;
    }
}
