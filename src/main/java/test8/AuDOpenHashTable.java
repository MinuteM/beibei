package test8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AuDOpenHashTable extends AuDHashTable {
    private LinkedList<Contact>[] lists;

    public AuDOpenHashTable(int capacity) {
        super(capacity);
        lists = new LinkedList[capacity];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) throws Exception {
        AuDOpenHashTable h = new AuDOpenHashTable(6);
        Contact contact = new Contact("123@163.com");
        contact.setName("123");
        contact.setNickname("Nick123");
        contact.setTelephone("123123123");
        Contact contact1 = new Contact("456@163.com");
        contact.setName("456");
        contact.setNickname("Nick456");
        contact.setTelephone("456456456");
        Contact contact2 = new Contact("789@163.com");
        Contact contact3 = new Contact("987@163.com");
        Contact contact4 = new Contact("654@163.com");
        Contact contact5 = new Contact("321@163.com");

        h.insert(contact);
        h.insert(contact1);
        h.insert(contact2);
        h.insert(contact3);
        h.insert(contact4);
        h.insert(contact5);

        System.out.println(h);

//        Contact contact6 = new Contact("000@163.com");
//        h.insert(contact6);

        h.remove(contact4);
        System.out.println(h);

//        Contact contact6 = new Contact("000@163.com");
//        h.insert(contact6);
//        System.out.println(h);

//        System.out.println(h.getContact("000@163.com"));
        System.out.println(h.getContact("123@163.com"));
    }

    @Override
    public String toString() {
        String s = "";
        for (LinkedList<Contact> list : lists) {
            for (Contact contact : list) {
                if(contact != null){
                    s += contact.getEmail() + ",";
                }
            }
        }
        return s.substring(0, s.length() - 1);
    }

    @Override
    public void insert(Contact c) {
        LinkedList<Contact> list = lists[this.hash(c.getEmail())];
        list.add(c);
    }

    @Override
    public void remove(Contact c) throws NoSuchElementException {
        LinkedList<Contact> list = lists[this.hash(c.getEmail())];
        boolean flag = list.remove(c);
        if (!flag) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Contact getContact(String email) throws NoSuchElementException {
        LinkedList<Contact> list = lists[this.hash(email)];
        for (Contact contact : list) {
            if (email.equals(contact.getEmail())) {
                return contact;
            }
        }
        throw new NoSuchElementException();
    }
}
