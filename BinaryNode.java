
public class BinaryNode<T> implements BinaryNodeInterface<T>, java.io.Serializable{

	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	//constructors
	public BinaryNode(){
		this(null);
	}
	
	public BinaryNode(T inData){
		this(inData, null, null);
	}
	
	public BinaryNode(T inData, BinaryNode<T> inL, BinaryNode<T> inR){
		data = inData;
		left = inL;
		right = inR;
	}
	
	//accessors
	public T getData(){
		return data;
	}
	//mutator
	public void setData(T newData){
		data = newData;
	}
	
	//accessors
	public BinaryNodeInterface<T> getLeftChild(){
		return left;
	}
	
	public BinaryNodeInterface<T> getRightChild(){
		return right;
	}
	
	//mutators
	public void setLeftChild(BinaryNodeInterface<T> leftChild){
		left = (BinaryNode <T> ) leftChild;
	}
	
	public void setRightChild(BinaryNodeInterface<T> rightChild){
		right = (BinaryNode <T> ) rightChild;
	}
	
	//checks if node has left child
	public boolean hasLeftChild(){
		return left!= null;
	}
	
	//check if node has right child
	public boolean hasRightChild(){
		return right != null;
	}
	
	//check if node is a leaf
	public boolean isLeaf(){
		return (left == null) && (right == null);
	}
	
	
	//copies node
	public BinaryNodeInterface<T> copy(){
		BinaryNode <T> newRoot = new BinaryNode <T> (data);
		if(left != null)
			newRoot.left = (BinaryNode <T> ) left.copy();
		if(right != null)
			newRoot.right = (BinaryNode <T> ) right.copy();
		return newRoot;
	}
	
	//accessors
	public int getHeight(){
		return getHeight(this);
	}
	
	public int getHeight(BinaryNode <T> node){
		int height = 0;
		if (node != null)
			height = 1+Math.max(getHeight(node.left),getHeight(node.right));
		return height;
	}
	
	public int getNumberOfNodes(){
		int leftNumber = 0;
		int rightNumber = 0;
		if(left!= null)
			leftNumber = left.getNumberOfNodes();
		if(right != null)
			rightNumber = right.getNumberOfNodes();
		return 1+ leftNumber + rightNumber;
	}

	
}
