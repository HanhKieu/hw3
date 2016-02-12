public class Pair extends Element {
	MyChar key;
	Element value;

	public Pair(MyChar myKey, Element elm){
		key = myKey;
		value = elm;
	}



	public void Print(){
		System.out.print("(");
		key.Print();
		System.out.print(" ");
		value.Print();
		System.out.print(")");
	}
}