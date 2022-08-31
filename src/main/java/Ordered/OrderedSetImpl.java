package Ordered;

import java.util.NoSuchElementException;

public class OrderedSetImpl implements OrderedSet {

    public static void  main(String[] args) {
        //a
        OrderedSetImpl set1 = new OrderedSetImpl();
        OrderedSetImpl set2 = new OrderedSetImpl();
        //b
        System.out.println(set1);
        System.out.println(set2);
        //c
        set1.add(1);
        set1.add(6);
        set1.add(4);
        set1.add(3);
        set1.add(7);
        set1.add(5);
        set1.add(12);
        //d
        int[] set2Array = new int[]{5, 23, 22, 7, 9};
        set2.add(set2Array);
        //e
        System.out.println(set1);
        System.out.println(set2);
        //f
        try {
            set2.remove(22);
            set2.remove(77);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //g
        System.out.println(set1.getSetInBetween(2, 6));
        //h
        System.out.println(set1.intersect(set2));
        System.out.println(set1.unite(set2));
        System.out.println(set1.subtract(set2));
        //i
        OrderedSetImpl set3 = new OrderedSetImpl();
        set3.add(18);
        set3.add(19);
        set3.add(20);
        System.out.println(set1.unite(set3));
    }

    public class ListItem {
        private ListItem previous;
        private ListItem next;
        private int value;

        public ListItem(int value, ListItem previous, ListItem next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.next == null ? "[" + this.value + "]" : "[" + this.value + "]-->";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            ListItem listItem = (ListItem) o;

            if (value != listItem.value) {
                return false;
            }
            if (previous != null ? !previous.equals(listItem.previous) : listItem.previous != null) {
                return false;
            }
            return next != null ? next.equals(listItem.next) : listItem.next == null;
        }

    }

    private ListItem first;

    private ListItem last;

    private int size = 0;

    @Override
    public String toString() {
        String output = "";
        for (OrderedSetImpl.ListItem item = first; item != null; item = item.next) {
            output += item.toString();
        }
        return output;
    }

    @Override
    public void clear() {
        for (OrderedSetImpl.ListItem item = first; item != null; ) {
            OrderedSetImpl.ListItem next = item.next;
            item.value = 0;
            item.next = null;
            item.previous = null;
            item = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int value) {
        int index = 0;
        for (OrderedSetImpl.ListItem item = first; item != null; item = item.next) {
            if (value == item.value) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        int i = 0;
        for (OrderedSetImpl.ListItem item = first; item != null; item = item.next) {
            result[i++] = item.value;
        }
        return result;
    }

    @Override
    public int[] toReversedArray() {
        int[] result = new int[size];
        int i = 0;
        for (OrderedSetImpl.ListItem item = last; item != null; item = item.previous) {
            result[i++] = item.value;
        }
        return result;
    }

    @Override
    public void add(int value) {
        final OrderedSetImpl.ListItem item = last;
        final OrderedSetImpl.ListItem newNode = new OrderedSetImpl.ListItem(value, item, null);
        last = newNode;
        if (item == null) {
            first = newNode;
        } else {
            item.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int[] values) {
        for (int value : values) {
            this.add(value);
        }
    }

    @Override
    public void remove(int value) throws NoSuchElementException {
        int count = 0;
        for (OrderedSetImpl.ListItem item = first; item != null; item = item.next) {
            if (value == (item.value)) {
                final OrderedSetImpl.ListItem next = item.next;
                final OrderedSetImpl.ListItem previous = item.previous;

                if (previous == null) {
                    first = next;
                } else {
                    previous.next = next;
                    item.previous = null;
                }

                if (next == null) {
                    last = previous;
                } else {
                    next.previous = previous;
                    item.next = null;
                }
                size--;
                count++;
            }
        }
        if(count == 0){
            throw new ElementExistsException("NoSuchElementException");
        }
    }

    @Override
    public OrderedSet clone() {
        OrderedSetImpl clone = null;
        try {
            clone = (OrderedSetImpl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        clone.first = clone.last = null;
        clone.size = 0;

        for (OrderedSetImpl.ListItem item = first; item != null; item = item.next) {
            clone.add(item.value);
        }

        return clone;
    }

    @Override
    public OrderedSet getSetInBetween(int from, int to) {
        int index = 0;
        OrderedSetImpl clone = null;
        try {
            clone = (OrderedSetImpl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        clone.first = clone.last = null;
        clone.size = 0;
        for (OrderedSetImpl.ListItem item = first; item != null; item = item.next) {
            if (index >= from && index <= to) {
                clone.add(item.value);
            }
            if (index == from) {
                item.previous = null;
            }
            if (index == to) {
                item.next = null;
                break;
            }
            index++;
        }
        return clone;
    }

    @Override
    public OrderedSet intersect(OrderedSet set) {
        OrderedSetImpl clone = null;
        try {
            clone = (OrderedSetImpl) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        clone.first = clone.last = null;
        clone.size = 0;
        for (OrderedSetImpl.ListItem item = first; item != null; item = item.next) {
            if (set.contains(item.value)) {
                clone.add(item.value);
            }
        }
        return clone;
    }

    @Override
    public OrderedSet unite(OrderedSet set) {
        OrderedSetImpl clone = (OrderedSetImpl) set.clone();
        for (OrderedSetImpl.ListItem item = first; item != null; item = item.next) {
            if (!set.contains(item.value)) {
                clone.add(item.value);
            }
        }
        return clone;
    }

    @Override
    public OrderedSet subtract(OrderedSet set) {
        OrderedSetImpl clone = (OrderedSetImpl) this.clone();
        for (OrderedSetImpl.ListItem item = first; item != null; item = item.next) {
            if (set.contains(item.value)) {
                clone.remove(item.value);
            }
        }
        return clone;
    }
}

