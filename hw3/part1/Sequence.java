public class Sequence extends Element {
	Sequence next;
	Element data;


	public Sequence(){
    	next = null;
    }// no argument in constructor

    public Sequence(Element val){
    	next = null;
    	data = val;
    }// create a sequence with a data value

    public Sequence(Element val, Sequence nextValue){
    	next = nextValue;
    	data = val;
    }// create a sequence with a data value, and define what it points to next in the Sequence

    public void Print(){
    	Sequence s = this;
    	System.out.print("[ ");
    	while (s!=null) {
    		s = s.next;
    		data.Print();
    	}
    	System.out.print(" ]");
    }

    public Element first(){
        return this.data;
    }// returns first element of sequence

    public Sequence rest(){
        return this.next;
    }// returns rest of sequence

    public int length(){
        Sequence s = this;
        int i;
        for(i=0; s != null; i++, s = s.next);
        return i;
    }// returns length of sequence

    public void add(Element elm, int pos){
        if(pos < 0 || pos > this.length()){
            System.out.println("Error!");
        }
        else{

            Sequence newElement = new Sequence(elm);
            Sequence s = this;

            for(int i=0; s!=null; i++){
                if(i + 1 == pos){
                    newElement.next = s.next;
                    s.next = newElement;
                    break;
                }// link our new sequence element to the beginni
            s = s.next;
            }
        }


    }// add element to sequence at a specific position

}