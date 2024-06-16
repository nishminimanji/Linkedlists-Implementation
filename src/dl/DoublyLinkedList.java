package dl;

public class DoublyLinkedList {
	
	class Node {
	    int data;
	    Node next;
	    Node prev;

	    Node(int data) {
	        this.data = data;
	        this.next = null;
	        this.prev = null;
	    }
	}
	
	private Node head;
    private Node tail;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to add a node to the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to add a node to the start of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to remove a node from the list
    public void remove(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    } else {
                        head = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    // Method to traverse the list forwards
    public void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to traverse the list backwards
    public void traverseBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 DoublyLinkedList dll = new DoublyLinkedList();

	        dll.addLast(15);
	        dll.addLast(20);
	        dll.addLast(25);
	        dll.addFirst(10);
	        System.out.println("Traverse Forward:");
	        dll.traverseForward();

	        System.out.println("Traverse Backward:");
	        dll.traverseBackward();

	        dll.remove(20);
	        System.out.println("After removing 20, Traverse Forward:");
	        dll.traverseForward();

	        System.out.println("After removing 20, Traverse Backward:");
	        dll.traverseBackward();
	    }
		
	}


