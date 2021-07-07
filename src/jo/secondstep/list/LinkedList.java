package jo.secondstep.list;

public class LinkedList implements List {
	Node head;

	public static void main(String[] arge) {
		System.out.println("LinkedList");
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		list.add(1, 1);
		list.show();
		System.out.println(list.get(1));
		System.out.println(list.remove(2));
		System.out.println(list.get(1));
		list.add(2);
		list.add(2);
		System.out.println(list.size());
        list.clear();
        list.show();
        System.out.println(list.isEmpty());
        list.add(5);
		list.add(2);
		list.show();
		list.set(10, 1);
		list.add(2);
		list.show();
	}

	public void show() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}

	}

	@Override
	public void add(int value) {
		Node newNode = new Node();
		newNode.data = value;
		newNode.next = null;

		if (head == null)
			head = newNode;
		else {
			Node ontherNode = head;

			while (ontherNode.next != null)
				ontherNode = ontherNode.next;
			ontherNode.next = newNode;

		}

	}

	@Override
	public void add(int value, int position) {
		Node newNode = new Node();
		newNode.data = value;
		newNode.next = null;
		if (head == null)
			head = newNode;
		else {
			Node ontherNode = head;
			int i = 0;
			while (ontherNode.next != null) {
				if (++i == position) {
					newNode.next = ontherNode.next;

					ontherNode.next = newNode;
				}
				ontherNode = ontherNode.next;

			}
		}
	}

	@Override
	public int remove(int position) {
		Node ontherNode = head;
		Node node = new Node();
		int i = 0;
		if (position == 0) {
			return head.data;
		} else {
			while (ontherNode.next != null) {
				if (++i == position) {
					node.data = ontherNode.next.data;
					ontherNode.next = ontherNode.next.next;
					break;
				}
				ontherNode = ontherNode.next;
			}
		}
		return node.data;
	}

	@Override
	public int get(int position) {
		Node node = new Node();
		if (position == 0) {
			return head.data;
		} else {
			Node ontherNode = head;
			int i = 0;
			while (ontherNode.next != null) {
				if (++i == position)
					node.data = ontherNode.next.data;
				ontherNode = ontherNode.next;

			}
		}

		return node.data;
	}

	@Override
	public int size() {
		Node ontherNode = head;
		int i=0;
        while(ontherNode!=null)
        	 {i++; ontherNode=ontherNode.next; }
		return i;
	}

	@Override
	public void clear() {
		head = null;
		System.out.println("list has been cleared ");

	}

	@Override
	public void set(int value, int position) {
		Node ontherNode = head;
        if(position==0)
        {ontherNode.data=value;}
        else
        {int i = 0;
		while (ontherNode.next != null) {
			if (++i == position)
				ontherNode.next.data=value;
			ontherNode = ontherNode.next;
		}
        
        }
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head==null);
	}

}
