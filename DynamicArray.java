package Z1_Dynamic_Array;

public class DynamicArray {
    static public int[] array;
    public int numberOfElements;

    public DynamicArray(int maxSize){
        array = new int[maxSize];
        numberOfElements = 0;
    }

    public void insert(int newElement){

        if(numberOfElements >= array.length){
            int[] tempArray = new int[array.length * 2];
            for(int i = 0; i < array.length; i++){
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        array[numberOfElements] = newElement;
        numberOfElements++;
    }

    public boolean find(int searchedElement){
        for(int i = 0; i < numberOfElements; i++){
            if(array[i] == searchedElement)
                return true;
        }
        return false;
    }

    public boolean delete(int index){
        if(numberOfElements == 0 || index >= numberOfElements || index < 0)
            return false;
        for(int j = index; j < numberOfElements; j++){
            array[j] = array[j+1];
        }
        numberOfElements--;
        return true;
    }

    public int getIndex(int index){
        return array[index];
    }

    public int getNumberOfElements(){
        return numberOfElements;
    }

    public void print(){
        for(int i = 0; i < numberOfElements; i++)
            System.out.print("[" + array[i] + "]");
    }

    public static void main(String[] args) {
        int maxSize = 2;
        DynamicArray dynamicArray = new DynamicArray(maxSize);

        dynamicArray.insert(5);
        dynamicArray.insert(9);

        dynamicArray.print();
        System.out.println();

        dynamicArray.insert(7);
        dynamicArray.print();
    }
}
