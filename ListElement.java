package Z3_LinkedList;

public class ListElement {
    public int iData; //wartość
    public ListElement next; //do następnego

    public ListElement(int iData){
        this.iData = iData;
        next = null; //jesli nie ma kolejnego
    }

    @Override
    public String toString(){
        return Integer.toString(iData);
    }
}
