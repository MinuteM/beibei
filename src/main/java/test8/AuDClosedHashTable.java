package test8;

import java.util.NoSuchElementException;

public class AuDClosedHashTable extends AuDHashTable {
    private Contact[] contacts;
    private boolean[] deleted;
    private int counter;

    public AuDClosedHashTable(int capacity) {
        super(capacity);
        contacts = new Contact[capacity];
        deleted = new boolean[capacity];
        counter = 0;
    }

    public final void cc(){

    }

    public static void main(String[] args) throws Exception {
        double a = 2;
        double b = 1.1;
        Object o = 48;
        System.out.println(o.getClass());
        System.out.println(2%9);
//
//        AuDClosedHashTable h = new AuDClosedHashTable(6);
//        Contact contact = new Contact("123@163.com");
//        contact.setName("123");
//        contact.setNickname("Nick123");
//        contact.setTelephone("123123123");
//        Contact contact1 = new Contact("456@163.com");
//        contact.setName("456");
//        contact.setNickname("Nick456");
//        contact.setTelephone("456456456");
//        Contact contact2 = new Contact("789@163.com");
//        Contact contact3 = new Contact("987@163.com");
//        Contact contact4 = new Contact("654@163.com");
//        Contact contact5 = new Contact("321@163.com");
//
//        h.insert(contact);
//        h.insert(contact1);
//        h.insert(contact2);
//        h.insert(contact3);
//        h.insert(contact4);
//        h.insert(contact5);
//
//        System.out.println(h);
//
////        Contact contact6 = new Contact("000@163.com");
////        h.insert(contact6);
//
//        h.remove(contact4);
//        System.out.println(h);
//
//        Contact contact6 = new Contact("000@163.com");
//        h.insert(contact6);
//        System.out.println(h);
//
////        System.out.println(h.getContact("000@163.com"));
//        System.out.println(h.getContact("123@163.com"));
    }

    @Override
    public String toString() {
        String s = "";
        for (Contact contact : contacts) {
            if(contact != null){
                s += contact.getEmail() + ",";
            }
        }
        return s.substring(0, s.length() - 1);
    }

    @Override
    public void insert(Contact c) throws UnsupportedOperationException {
        if (isFull()) {
            throw new UnsupportedOperationException();
        } else {
            int i = 0;
            while (contacts[hash(c.getEmail(), i)] != null) {
                i++;
            }
            contacts[hash(c.getEmail(), i)] = c;
            counter++;
        }
    }

    @Override
    public void remove(Contact c) {
        int i = this.getIndexOf(c.getEmail());
        contacts[i] = null;
        deleted[i] = true;
        counter--;
    }

    @Override
    public Contact getContact(String email) {
        int i = this.getIndexOf(email);
        return contacts[i];
    }

    public boolean isFull() {
        if (counter == contacts.length) {
            return true;
        } else {
            return false;
        }
    }

    public int getIndexOf(String email) throws NoSuchElementException {
        int i = 0;
        while (true) {
            if (i == contacts.length) {
                throw new NoSuchElementException();
            }
            int hash = hash(email, i);
            if (contacts[hash] != null && contacts[hash].getEmail().equals(email)) {
                return hash(email, i);
            }
            if ((contacts[hash] == null && !deleted[hash])) {
                throw new NoSuchElementException();
            }
            i++;
        }
    }

    protected int hash(String s, int i) {
        if (i % 2 == 0) {
            return Math.floorMod((int) (this.hash(s) - Math.floor(i / 2) - 1), capacity);
        } else {
            return Math.floorMod((int) (this.hash(s) + Math.floor(i / 2)), capacity);
        }
    }
}
