


import java.io.BufferedReader;
import java.io.IOException;

public class TreeElement {
	char value;
	TreeElement leftChild;
	TreeElement rightChild;

	public TreeElement(char value, TreeElement leftChild, TreeElement rightChild){
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public static TreeElement readTreeElement(BufferedReader in) throws IOException {
		char ch = (char) in.read();
		if ((ch != '*') && (ch != '/') && (ch != '-') && (ch != '+')) {
			return new TreeElement(ch, null, null);
		} else {
			return new TreeElement(ch, readTreeElement(in), readTreeElement(in));
		}
	}
	
	public StringBuilder toInfix(){
		StringBuilder str = new StringBuilder();
		if(this.priority() == 0){
			str.append(this.value);
		}
		else{
			String lStr = leftChild.toInfix().toString();
			String rStr = rightChild.toInfix().toString();
			
			if ((this.priority() > leftChild.priority()) && (leftChild.priority() != 0)){
					str.append("(" + lStr + ")");
			}
			else {
				str.append(lStr);
			}
			str.append(this.value);
			
			if ((this.priority() > rightChild.priority() ||
                    (this.priority() == rightChild.priority() && this.nonCommutative())) &&
                    (rightChild.priority() != 0)){
            str.append("(" + rStr + ")");
			}
			else{
				str.append(rStr);
			}
		}
		return str;
	}
	
	private int priority(){
		int p = 0;
		if(this.value == '+'){
			p = 1;
		}
		else if(this.value == '-'){
				p = 1;
			}
		else if(this.value == '*'){
				p = 2;
			}
		else if(this.value == '/'){
				p = 2;
		}
		
		return p;
	}
	
	private boolean nonCommutative(){
		return this.value == '/' || this.value == '-';
	}
	
	
	
	
	
	
}
