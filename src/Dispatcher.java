package src;

public class Dispatcher extends DispatcherBase {

    Linked system = new Linked();
    
    @Override
    public int size() {
        return system.getSize();
    }

    @Override
    public void addPlane(String planeNumber, String time) {
        Plane plane = new Plane(planeNumber, time);
        system.add(plane);
    }

    @Override
    public String allocateLandingSlot(String currentTime) {
        return system.allocate(currentTime);
    }

    @Override
    public String emergencyLanding(String planeNumber) {

        return system.remove(planeNumber);
    }

    @Override
    public boolean isPresent(String planeNumber) {
        if(system.getNode(planeNumber) != null){
            return true;
        }else return  false;
    }

    /* Implement all the necessary methods of Dispatcher here */
}

/* Add any additional helper classes here */
class Linked  {
    private static class Node {
        public Plane t;
        public Node next;

        public Node(Plane t, Node next) {
            this.t = t;
            this.next = next;
        }
        public Node(Plane t) {
            this(t, null);
        }

    }
    private Node head;
    private int size;
    public Linked() {
        this.head = null;
        this.size = 0;
    }
    public int getSize() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public void addFirst(Plane t) {
        this.head = new Node(t, head);
        this.size++;
    }
//    public void addLast(Plane t) {
//        this.add(t);
//    }

    public void add(Plane t) {
        if (this.size == 0) {
            this.addFirst(t);
            return;
        }

        Node postNode = this.head;
//        for(int i = 0; i < this.size && preNode.t.getTime().compareTo(); i++) {
//            preNode = preNode.next;
//        }
        while(t.compareTo(postNode.t) > 0) {
            Node node = new Node(t);
            node.next = postNode.next;
            postNode.next = node;
            this.size++;
        }
    }
     public String remove(String planeNumber) {
         if(head == null || this.getNode(planeNumber) == null) {
             return null;
         }
         Node cur = this.head;
         while(!cur.next.equals(this.getNode(planeNumber))){
             cur = cur.next;
         }
         cur.next = this.getNode(planeNumber).next;
         this.size--;
         return planeNumber;
     }

    public String removeFirst() {
        if(this.head == null) {
            return null;
        }
        Node delNode = this.head;
        this.head = this.head.next;
        delNode.next = null;
        this.size--;
        return delNode.t.getPlaneNumber();
    }
    public String allocate(String currentTime) {
        if(this.head == null || Integer.parseInt(this.head.t.getTime().replace(":", "")) > Integer.parseInt(currentTime.replace(":", "")) + 5)
            return null;
        else return this.removeFirst();
    }
    public Node getNode(String planeNumber) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.t.getPlaneNumber().equals(planeNumber)) {
                return cur;
            }
            else cur = cur.next;
        }
        return null;
    }


}