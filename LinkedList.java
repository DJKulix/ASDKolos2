package Z3_LinkedList;

import java.util.List;

public class LinkedList {
    public ListElement first;

    public LinkedList() {
        this.first = null; //jeszcze nie ma
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(10);
        list.insertFirst(9);
        list.insertFirst(3);

        list.print();

        boolean result = list.find(32);
        if (result)
            System.out.println("Znaleziono");
        else
            System.out.println("Nie znaleziono");

        ListElement delete = list.delete(3);
        if (delete != null) {
            System.out.println("Usunięto element" + delete.iData);
        } else
            System.out.println("Nie usunięto");

        list.print();
    }

    public void insertFirst(int newIData) {
        ListElement newElement = new ListElement(newIData);
        if (!this.isEmpty()) {
            newElement.next = this.first;
        }
        this.first = newElement;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void print() {
        ListElement current = this.first;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
        System.out.println("Koniec.");
    }

    public ListElement delete(int element) {
        if (this.isEmpty()) {
            return null;
        }

        ListElement current = first;
        ListElement previous = null;

        while (current.iData != element) {
            if (current.next == null)
                return null;
            else
                previous = current;
            current = current.next;
        }
        if (previous == null) {
            this.first = first.next;
        } else
            previous.next = current.next;

        return current;
    }

    public boolean find(int searchedElement) {
        if (isEmpty())
            return false;
        ListElement current = first;
        while (current.iData != searchedElement) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true; //lista zostala przeleciana, i jest cos
    }
}
