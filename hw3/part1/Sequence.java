public class Sequence extends Element {
	Sequence next;
	Element data;


	public Sequence(){
    	next = null;
    }//no argument in constructor

    public Sequence(Element val){
    	next = null;
    	data = val;
    }//create a sequence with a data value

    public Sequence(Element val, Sequence nextValue){
    	next = nextValue;
    	data = val;
    }//create a sequence with a data value, and define what it points to next in the Sequence

    public void Print(){
    	while(next!=null){
    		print()
    	}
    }

}