public class Sequence extends Element {
	Sequence next;
	Element data;


	public Sequence(){
    	next = null;
        data = null;
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
    		s.data.Print();
            System.out.print(" ");
            s = s.next;
    	}
    	System.out.print("]");
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
        if(s.data == null){
            return 0;
        }
        for(i=0; s!= null; i++){
            s = s.next;
        }
        return i;
    }// returns length of sequence

    public void add(Element elm, int pos){
        if(pos < 0 || pos > this.length()){
            System.out.println("Error!");
        }
        else{

            Sequence newElement = new Sequence(elm);
            Sequence s = this;
            Element temp;
            if(s.length() == 0 && pos == 0){
                s.data = elm;
            }//if there's nothing there
            else{
                if(pos == 0){
                    temp = s.data;
                    s.data = elm;
                    newElement.data = temp;
                    newElement.next = s.next;
                    s.next = newElement;
                }//if you're trying to add to the beginning
                else{
                    for(int i=0; s!=null; i++){
                        if(i + 1 == pos){
                            newElement.next = s.next;
                            s.next = newElement;
                            break;
                        }// link our new sequence element to the beginni
                    s = s.next;
                    }
                }
            }

        }

    }// add element to sequence at a specific position


    public void delete(int pos){
        Sequence s = this;
        Sequence temp;

        if(pos == 0){
            s.data = s.next.data;
            s.next = s.next.next;
        }

        else if(pos > 0 && pos <= (this.length() - 1)){
            for(int i=0; s!=null; i++){
                if( i + 1 == pos){
                    s.next = s.next.next;
                    break;
                }
                s = s.next;
            }
        }
    }
}