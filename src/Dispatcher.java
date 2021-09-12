package src;

public class Dispatcher extends DispatcherBase {

    LinkedP system = new LinkedP();

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
        return system.getNode(planeNumber) != null;
    }

    /* Implement all the necessary methods of Dispatcher here */
}

/* Add any additional helper classes here */
class LinkedP {
    private Node head;
    private int size;

    public LinkedP() {
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

    public void add(Plane t) {
        if (this.size == 0 || t.compareTo(this.head.t) < 0) {
            this.addFirst(t);
            return;
        }
        if(t.compareTo(this.head.t)==0){
            return;
        }
        Node preNode = this.head;
        Node node = new Node(t);
        while (preNode.next != null) {
            if (t.compareTo(preNode.next.t) > 0) {
                preNode = preNode.next;
            } else if(t.compareTo(preNode.next.t) == 0){
                return;
            } else {
                node.next = preNode.next;
                preNode.next = node;
                size++;
                return;
            }
        }
        preNode.next = node;
        size++;
        return;
    }

    public String remove(String planeNumber) {
        Node cur = this.head;
        if (cur == null) {
            return null;
        }
        if (cur.t.getPlaneNumber().equals(planeNumber)) {
            if (this.size == 1) {
                this.head = null;
                this.size--;
                return planeNumber;
            } else {
                this.removeFirst();
            }
        }
        while (cur.next != null) {
            if (cur.next.t.getPlaneNumber().equals(planeNumber)) {
                cur.next = cur.next.next;
                this.size--;
                return planeNumber;
            } else cur = cur.next;
        }
        return null;
    }

    public String removeFirst() {
        if (this.head == null) {
            return null;
        }
        Node delNode = this.head;
        if (this.head.next == null) {
            this.head = null;
            size--;
            return delNode.t.getPlaneNumber();
        }
        this.head = this.head.next;
        delNode.next = null;
        this.size--;
        return delNode.t.getPlaneNumber();
    }

    public String allocate(String currentTime) {

        if (this.head == null || Integer.parseInt(this.head.t.getTime().replace(":", "")) > Integer.parseInt(currentTime.replace(":", "")) + 5)
            return null;
        else return this.removeFirst();
    }

    public Node getNode(String planeNumber) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.t.getPlaneNumber().equals(planeNumber)) {
                return cur;
            } else cur = cur.next;
        }
        return null;
    }

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


}