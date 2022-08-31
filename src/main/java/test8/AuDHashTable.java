package test8;

public abstract class AuDHashTable {

    protected int capacity;

    public AuDHashTable(int capacity) {
        this.capacity = capacity;
    }

    abstract public void insert(Contact c);

    abstract public void remove(Contact c);

    abstract public Contact getContact(String email);

    // This method still needs to be implemented
    protected int hash(String s) {
        // Replace the method body with the correct hash function
        char[] h = s.toCharArray();
        int sum = 0;
        for (char c : h) {
            sum += (int) c;
        }
        return sum % capacity;
    }
}
