class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> M = new TreeMap<>((a,b) -> Integer.compare(b,a));

        for(int i = 0; i < position.length;i++){
            M.put(position[i],speed[i]);
        }

        int fleets = 0;
        double lastTime = -1;
        for(int car: M.keySet()){
            double currTime =(target - car *1.0) /M.get(car);
            if(currTime > lastTime){
                fleets++;
                lastTime = currTime;
            } 
        }

        return fleets;
    }
}
