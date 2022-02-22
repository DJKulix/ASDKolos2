package strukturyA.z5;


//Klasa definujaca drzewo poszukiwan binarnych

import java.util.ArrayList;


public class BSTree {
    private TreeNode root;    // pierwszy węzeł drzewa

    public BSTree()   // konstruktor
    {
        root = null;
    }

    public static void main(String[] args) //test drzewa BST
    {
        BSTree tree = new BSTree();

        //Wstawianie elementow
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(43);
        tree.insert(30);
        tree.insert(33);
        tree.insert(87);
        tree.insert(63);
        tree.insert(97);

        tree.view(tree.getRoot(), 0);

        boolean result1 = tree.find(33);
        System.out.println("Wynik wyszukania 33:" + result1);

        boolean result2 = tree.find(40);
        System.out.println("Wynik wyszukania 40:" + result2);

        System.out.println("\n\t<< del(37) >>");

        tree.view(tree.getRoot(), 0);
        System.out.println("\n");

        System.out.println("\n\t<< del(43) >>");

        tree.view(tree.getRoot(), 0);
        System.out.println("\n");

        System.out.println("\n\t<< del(25) >>");

        tree.view(tree.getRoot(), 0);
        System.out.println("\n");

        tree.print();
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int elem) {
        TreeNode newNode = new TreeNode();    // tworzymy nowy węzeł
        newNode.iData = elem;        // zapisujemy w nim dane

        if (root == null)
            root = newNode; //Jesli drzewo jest puste
        else //Drzewo ma jednak korzen
        {
            TreeNode current = root;       // zaczynamy poszukiwania od korzenia
            while (true)                // (zakończenie pętli wewnątrz za pomoca return)
            {
                TreeNode parent = current;
                // czy idziemy w lewo?
                if (elem < current.iData) {
                    current = current.leftChild;
                    // jeśli nie ma lewego,
                    if (current == null) {
                        // wstawiamy po lewej stronie
                        parent.leftChild = newNode;
                        newNode.parent = parent;
                        return;
                    }
                }
                // idziemy na prawo
                else {
                    current = current.rightChild;
                    //jesli nie ma prawego
                    if (current == null) {
                        // wstawiamy po prawej stronie
                        parent.rightChild = newNode;
                        newNode.parent = parent;
                        return;
                    }
                }
            }
        }
    }

    public boolean find(int elem)     //sprawdzenie czy w drzewie jest element: elem
    {
        if (root == null) return false;       //puste drzewo

        TreeNode current = root;               // zaczynamy od korzenia drzewa
        while (current.iData != elem)        // dopóki nie odnaleziono,
        {
            if (elem < current.iData)         // czy przechodzimy na lewo?
                current = current.leftChild;
            else                            // na prawo
                current = current.rightChild;
            if (current == null)             // jeśli brak potomka,
                return false;                 // nie odnaleziono elementu
        }
        return true; // odnaleziono element
    }

    private TreeNode getSuccessor(TreeNode node) //Wyliczenie nastepnika wezla
    {
        TreeNode current = node.rightChild;
        while (current.leftChild != null) //Idziemy w lewy dolny lisc podrzewa
        {
            current = current.leftChild;
        }
        return current;
    }

    private void deleteWithoutChilds(TreeNode current) //Usuniecie wezla bez potomkow
    {
        if (current == root)             // jeśli to korzeń,
        {
            root = null;                 // opróżniamy drzewo
        } else {
            if (current.parent.leftChild == current) //usuwany byl lewym synem ojca
            {
                current.parent.leftChild = null;    // odłączamy usuwany węzeł
            }
            else //byl prawym synem ojca
            {
                current.parent.rightChild = null;  // odłączamy usuwany węzeł
            }
            current.parent = null; /////////////////////////////////////////////
        }
    }

    private void deleteWithOneLeftChild(TreeNode current) //Usuniecie wezla z jednym lewym potomkiem
    {
        if (current == root) {
            root = current.leftChild;
        } else {
            if (current.parent.leftChild == current) //usuwany byl lewym synem ojca
            {
                current.parent.leftChild = current.leftChild;
            } else //byl prawym synem ojca
            {
                current.parent.rightChild = current.leftChild;
            }
            current.leftChild.parent = current.parent;  //////////////////////////////////
        }
    }

    public void view(TreeNode node, int level) //wizualizacja tekstowa drzewa
    {
        if (node == null)
            return;
        for (int i = 0; i < level; i++)
            System.out.print("- ");
        System.out.println(node.iData);
        view(node.leftChild, level + 1);
        view(node.rightChild, level + 1);
    }

    //Kopiowanie BST do tablicy dynamicznej
    private void copyBSTreeToArrayList(TreeNode node, ArrayList<TreeNode> nodeList) {
        if (node.leftChild != null) copyBSTreeToArrayList(node.leftChild, nodeList);
        nodeList.add(node);
        if (node.rightChild != null) copyBSTreeToArrayList(node.rightChild, nodeList);
    }

    public BSTreeIterator iterator() //Pobranie iteratora drzewa
    {
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        if (root != null) {
            copyBSTreeToArrayList(root, nodeList);
        }
        return new BSTreeIterator(nodeList);
    }

    public void print() //Przegladanie drzewa wraz z wypisywaniem elementow
    {
        System.out.print("BST:");
        BSTreeIterator iterator = this.iterator();

        while (iterator.hasNext())      // Dopóki nie koniec elementow
        {
            TreeNode node = iterator.next();
            System.out.print(node.toString()); // ...wypisujemy dane i...
            System.out.print(" ");
        }
        System.out.println();
    }
}
