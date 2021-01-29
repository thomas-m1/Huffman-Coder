//Thomas Michalski
//computer science CS1027
//Assignment 3
//July 26th, 2019
//encodes a character and decodes a code string


public class HuffmanCoder {
	private HuffmanTree huffTree;
	private ArrayUnorderedList<EncodingData>encodingList;
	
	//creates the huffTree, using the 4th huffman tree constructor
	public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairslist) {
		huffTree = new HuffmanTree(pairslist); 
	}
	
	//builds list of symbols and their encodings from huffTree
	private void buildEncodingList(BinaryTreeNode<HuffmanPair>node, String encoding){
		if(node.isLeaf()) {
			EncodingData data = new EncodingData(node.getElement().getCharacter(), encoding);
			encodingList.addToFront(data);
		}
		else {
			buildEncodingList(node.getLeft(), encoding + "0");
			buildEncodingList(node.getRight(), encoding + "1");
		}
		
	}
	
	//takes specified string of binary digits that is a Huffman encoding, and returns the original character
	public char decode(String code) {
		BinaryTreeNode<HuffmanPair> node = huffTree.getRoot();
		
		for(int i = 0; i < code.length(); i++) {
			if(node.getLeft() != null && Character.getNumericValue(code.charAt(i)) == 0) {
				node = node.getLeft();
			}
			else if(node.getRight() != null && Character.getNumericValue(code.charAt(i)) == 1) {
				node = node.getRight();
			}
			else {
				return (char) 0;
			}
		}
		if(node.isLeaf()) {
			return node.getElement().getCharacter();
		}
		else {
			return (char) 0;
		}
	}
	
	//finds the char an returns
	private BinaryTreeNode<HuffmanPair> find(char targetchar, BinaryTreeNode<HuffmanPair> next) {
		if (next == null)
			return null;
		if (next.getElement().getCharacter() == targetchar)
			return next;

		BinaryTreeNode<HuffmanPair> temp = find(targetchar, next.getLeft());
		if (temp == null)
			temp = find(targetchar, next.getRight());
		return temp;
	}
	
	//takes the specified character and return the string representation of binary Huffman encoding of character
	public String encode(char c) throws ElementNotFoundException {
		BinaryTreeNode<HuffmanPair> node = huffTree.getRoot();
		String code = "";
		if(find(c,node) == null) {
			throw new ElementNotFoundException("huffman code");
		}
 
		while (find(c, node) != null) {
			if(find(c,node.getLeft()) != null) {
				node = node.getLeft();
				code = code + "0";
			}
			else if(find(c, node.getRight()) != null) {
				node = node.getRight();
				code = code + "1";
			}
			else {
				break;
			}
		}
		return code;
	}
	
	//returns string representation of the encoding list
	public String toString() {
		String s = "" ;
		for (int i = 0; i < encodingList.rear; i++) {
			s += encodingList.getElement(i).toString();
		}
		return s;
	}
}