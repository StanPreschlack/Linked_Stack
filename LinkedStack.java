public class LinkedStack<E> {
    class node {
        private E data;
        node next;
        node prev;
        public node(E someData) {
            this.data = someData;
        }
        public E getData() {
            return this.data;
        }
        public void setData(E someData) {
            this.data = someData;
        }
    }
    node head, tail = null;
    public void push(E data) {
        node newNode = new node(data);
        if (head == null) {
            head = tail = newNode;
            head.prev = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        tail.next = null;
    }
    public void printNodes() {
        node cur = head;
        if (head == null) {
            System.out.println("list is null");
        } else {
            while (cur != null) {
                System.out.println(cur.data + " ");
                cur = cur.next;
            }
         }
    }
    void revList() {
        node temp = null;
        node cur = head;
        while (cur != null) {
            temp = cur.prev;
            cur.prev = cur.next;
            cur.next = temp;
            cur = cur.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }
    public static void main(String[] args) {
        LinkedStack<Integer> ls = new LinkedStack<>();
        ls.push(10);
        ls.push(12);
        ls.push(13);
        ls.push(104);
        ls.push(120);
        ls.push(1300);
        ls.printNodes();
        System.out.println("after reversal: ");
        ls.revList();
        ls.printNodes();
    }
}
