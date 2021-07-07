package jo.secondstep.list;

public class ArrayList implements List {
	private static int CAPACITY = 10;
	int[] elements = new int[CAPACITY];
	int size;

	public static void main(String[] arge) {
		System.out.println("ArrayList");
		ArrayList array = new ArrayList();
		// array.add(2, 0);
		// array.add(2, 1);
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		array.add(6);
		array.add(7);
		array.add(8);
		array.add(9);
		array.add(1);
		array.add(2);
		array.add(3434, 2);
		array.add(3434, 2);
		array.remove(1);
		array.set(10, 2);
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
		System.out.println(array.size());
		// System.out.println(array.remove(2));
		// array.clear();
	}

	@Override
	public void add(int value) {

		if (size < CAPACITY) {
			elements[size++] = value;
		} else {
			int CurrantCapacity = size + (size / 2);
			int[] NewElements = new int[CurrantCapacity];
			int NewSize = 0;
			for (int i = 0; i < size; i++) {
				NewElements[i] = elements[i];
				NewSize++;
			}
			NewElements[NewSize++] = value;
			size = NewSize;
			CAPACITY = CurrantCapacity;
			elements = NewElements;

		}
	}

	@Override
	public void add(int value, int position) {
		if (size < CAPACITY && position < size) {

			int[] NewElements = new int[CAPACITY];
			int j = 0;
			for (int i = 0; i <= size; i++) {
				j++;
				if (i < position) {
					NewElements[i] = elements[i];

				}

				if (i == position) {
					NewElements[i] = value;

				}
				if (i > position) {
					NewElements[i] = elements[i - 1];

				}

			}
			size = j;
			elements = NewElements;
		} else {

			add(value);
		}

	}

	@Override
	public int remove(int position) {
		int item = 0;
		int CurrantCapacity = CAPACITY;
		if (!isEmpty()) {

			if (size < CAPACITY && position < size) {
				if (size < (CAPACITY / 4)) {
					CurrantCapacity = CAPACITY / 2;
				}
				int[] NewElements = new int[CurrantCapacity];
				int j = 0;
				for (int i = 0; i < size; i++) {
					if (i != position) {
						NewElements[j++] = elements[i];
					} else {
						item = elements[i];
					}
				}
				size = j;
				elements = NewElements;
			} else
				System.out.println("Can't remove , position is not in Array");

		} else {
			System.out.println("Can't remove Array is Empty");
		}

		return item;
	}

	@Override
	public int get(int position) {
		if (position < size) {

			return elements[position];

		}
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void clear() {
		elements = new int[CAPACITY];
		size = 0;
		System.out.println("Array has been cleared ");
	}

	@Override
	public void set(int value, int position) {
		if (position < size) {
			elements[position] = value;

		} else {
			System.out.println("Position is not in Array");
		}

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

}
