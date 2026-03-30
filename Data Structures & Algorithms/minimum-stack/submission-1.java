class MinStack {
    class Node{
        private int val;
        private Node next;
        public Node(int n){
            val = n;
            next = null;
        }
        int getValue(){
            return val;
        }

        void setNext(Node n){
            next = n;
        }

        Node getNext(){
            return next;
        }
    }
    private int min;
    private Node head;
    private Node minHead;
    public MinStack() {
        head = null;
        minHead = null;
    }
    
    public void push(int val) {
        if(head==null){
            minHead = new Node(val);
            head = new Node(val);
        }
        else{
        Node tmp = new Node(val);
        if(tmp.getValue()<=minHead.getValue()){
            Node tmpMin = new Node(val);
            tmpMin.setNext(minHead);
            minHead = tmpMin;
        }
        tmp.setNext(head);
        head = tmp;
        }
    }
    
    public void pop() {
        if(head.getValue() == minHead.getValue()){
            minHead = minHead.getNext();
        }
        head = head.getNext();
    }
    
    public int top() {
        return head.getValue();
    }
    
    public int getMin() {
        return minHead.getValue();
    }
}
