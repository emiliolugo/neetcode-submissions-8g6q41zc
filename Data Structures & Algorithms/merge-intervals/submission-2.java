class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> ret = new LinkedList<>();
        ret.add(intervals[0]);

        for(int i = 0; i < intervals.length; i++){
            int lastEnd = ret.getLast()[1];

            if(intervals[i][0] <= lastEnd){
                ret.getLast()[1] = Math.max(intervals[i][1],lastEnd);
            }
            else{
                ret.add(intervals[i]);
            }
        }

        int[][] retArr = new int[ret.size()][2];

        for(int i = 0; i < retArr.length; i++){
            retArr[i] = ret.removeFirst();
        }

        return retArr;
    }
}
