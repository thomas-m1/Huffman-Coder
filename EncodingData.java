//Thomas Michalski
//computer science CS1027
//Assignment 3
//July 26th, 2019
//represents a single pair of the data used to encode a text message into its binary Huffman code

public class EncodingData {
	
	private char symbol;// binary symbol(0and1)
	private String encoding;
	
	public EncodingData(char symbol, String encoding) {
		this.symbol = symbol;
		this.encoding = encoding;
	}
	
	//gets and returns binary symbol
	public char getSymbol() {
		return this.symbol;
	}
	
	//gets and returns encoding
	public String getEncoding() {
    return this.encoding;
	}
	
	//sets encoding
	public void setEncoding(String s) {
		this.encoding = s;
	}
	
	//checks if two EncodingData objects are equal based on the symbol attribute 
	public boolean equals(Object obj) {
		EncodingData other = (EncodingData) obj;
		if (symbol != other.symbol) 
			return false;
		return true;
	}
	
	//gives string of huffman code
	public String toString() {
		return (symbol + ": " + encoding + "\n");
	}		
}