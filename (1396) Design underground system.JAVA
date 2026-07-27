import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> checkInMap;
    private Map<String, Pair<Double, Integer>> tripMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        tripMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInData = checkInMap.get(id);
        String startStation = checkInData.getKey();
        int startTime = checkInData.getValue();

        String route = startStation + "->" + stationName;
        int travelTime = t - startTime;

        Pair<Double, Integer> tripData = tripMap.getOrDefault(route, new Pair<>(0.0, 0));
        tripMap.put(route, new Pair<>(tripData.getKey() + travelTime, tripData.getValue() + 1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        Pair<Double, Integer> tripData = tripMap.get(route);
        return tripData.getKey() / tripData.getValue();
    }

    // Simple Pair class since Java doesn't have one by default
    private static class Pair<K, V> {
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}
