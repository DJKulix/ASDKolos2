package strukturyA.z5;


//Klasa definiuje wezel drzewa poszukiowan binarnych

public class TreeNode
{
    public int iData;         // Element danych
    public TreeNode parent;       // Rodzic węzła
    public TreeNode leftChild;         // Lewy potomek węzła
    public TreeNode rightChild;        // Prawy lewy potomek węzła

    public TreeNode()
    {
        iData = 0;
        parent = null;
        leftChild = null;
        rightChild = null;
    }

    public String toString()
    {
        return "{"+iData+"}";
    }
}
