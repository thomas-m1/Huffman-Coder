//Thomas Michalski
//computer science CS1027
//Assignment 3
//July 26th, 2019
//constructs a huffman tree

import java.util.Iterator;

public class HuffmanTree extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree>{
	private BinaryTreeNode<HuffmanPair> root;
  
	//creates empty tree
	public HuffmanTree() {
		super();
	}
	
	//creates tree with huffman pair at root
	public HuffmanTree(HuffmanPair element) {
		super(element);
	}
	
	//creates a Huffman tree rooted at a node containing element
	public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree) {	
		super(element,leftSubtree,rightSubtree);
	}
  
	//builds Huffman tree from ordered list of Huffman pairs (pairslist)
	public HuffmanTree(ArrayOrderedList<HuffmanPair> pairslist) {   
    ArrayOrderedList<HuffmanTree> list = new ArrayOrderedList<HuffmanTree>(pairslist.size());
   
    //removes and adds to list
    while(!(pairslist.isEmpty())) {
    	HuffmanTree tree = new HuffmanTree(pairslist.removeLast());
    	list.add(tree);
    }
    
    //adds to left and right in the tree
    while(list.size() > 1) {
    	HuffmanTree leftsubtree = list.removeFirst();
    	HuffmanTree rightsubtree = list.removeFirst();
    	int freq1 = leftsubtree.getRoot().getElement().getFrequency();
    	int freq2 = rightsubtree.getRoot().getElement().getFrequency();
      
    	HuffmanPair pair = new HuffmanPair(freq1+freq2);
    	HuffmanTree root = new HuffmanTree(pair, leftsubtree, rightsubtree);
    	list.add(root);   
    }
    super.setRoot(list.removeFirst().getRoot());
	}
	
	//compares the frequencies in the root node of the trees
	@Override
	public int compareTo(HuffmanTree otherTree) {
		int freq1 = this.getRoot().getElement().getFrequency();
		int freq2 = otherTree.getRoot().getElement().getFrequency();
		return freq1-freq2;
	}
	
	//returns a string representation of a Huffman tree by doing a preorder traversal of the tree.
	@Override
	public String toString() {
		String s = "";
		Iterator<HuffmanPair> list ;
		list = iteratorPreOrder();
		while (list.hasNext()) {
			s += list.next().toString();
		}
		return s;
	}
}