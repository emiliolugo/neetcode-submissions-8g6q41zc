class TimeMap {

    private static class Pair {
        int time;
        String val;
        Pair(int t, String v) { time = t; val = v; }
    }

    private final Map<String, List<Pair>> M;

    public TimeMap() {
        M = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        M.computeIfAbsent(key, k -> new ArrayList<>())
         .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Pair> curr = M.get(key);
        if (curr == null) return "";

        int l = 0, r = curr.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            Pair p = curr.get(mid);

            if (p.time == timestamp) return p.val;
            if (p.time < timestamp &&
                (mid == curr.size() - 1 || curr.get(mid + 1).time > timestamp))
                return p.val;

            if (p.time > timestamp) r = mid - 1;
            else                    l = mid + 1;
        }
        return "";
    }
}
