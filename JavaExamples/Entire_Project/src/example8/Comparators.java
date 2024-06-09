package example8;

import java.util.Comparator;

public class Comparators {
    public static class UserComparator implements Comparator<Transaction> {
        @Override
        public int compare(Transaction t1, Transaction t2) {
            return t1.getUser().compareTo(t2.getUser());
        }
    }

    public static class TypeComparator implements Comparator<Transaction> {
        @Override
        public int compare(Transaction t1, Transaction t2) {
            return t1.getType().compareTo(t2.getType());
        }
    }
}
