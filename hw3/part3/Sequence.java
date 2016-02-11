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
        if(pos < 0 || pos > this.length() ){ //not looking at the linked list
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
        }//deleting first element 

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
    
    public Element index(int pos){
        Sequence s = this;
        Sequence temp;
        
        if(pos < 0 || pos > this.length()){
            System.out.println("Error!");
        }//not in the Sequence
        
        else{
            for(int i=0; i < pos; i++){ //iterate to 
                s = s.next;
            }
        }
        
        return s.data;
    }//returns data at pos 
/*    
    public Sequence flatten(){
        Sequence s = this;

        
        while(s != null){
            s.data.Print();
            System.out.println();
//            int index = 0;
            System.out.println( s.length());           
            if(s.first() instanceof Sequence){
                System.out.println(((Sequence)s.data).length());
                Sequence temp = ((Sequence)s.first()).flatten();
                System.out.println();
                temp.Print();
                System.out.println();
                
                while(temp != null && temp.data != null){ //this combines the Sequences
                    System.out.println(s.length());
                    s.add(temp.data, 0);
                    temp = temp.next;
                    s = s.rest();
                }
                
//                s.add(temp.data, index++);
//                temp.next = s.rest(); //attach end to rest of Sequence
//                index++;
                System.out.println(s.length());
            
            
                while(index > 0 && s != null){
                    s = s.rest();
                    index--;
                }
            }
            
            else if( s.next == null ){ //last value in sequence 
                return this;
            }
            else //it was a char or int
                s = s.rest();
        }
        
        return this;
    } //can't get this version to work
      //trying to only make a shallow copy
*/

    public Sequence flatten(){
        Sequence s = this;
        Sequence cpy = new Sequence();
        
        for(int i=0; s !=null;){
            
            if(s.first() instanceof Sequence){
                Sequence temp = new Sequence();
                temp = ((Sequence)s.first()).flatten();
                
                while(temp != null){
                    cpy.add(temp.data, i++);
                    temp = temp.rest();
                }

            } //if its a Sequence
            
            else if(s.first() instanceof MyInteger){
                MyInteger newInt = new MyInteger();
                int val = ((MyInteger)s.first()).Get();
                newInt.Set(val);
                cpy.add(newInt, i++);

            } //if its an int
            
            else{
               MyChar newChar = new MyChar();
                char val = ((MyChar)s.first()).Get();
                newChar.Set(val);
                cpy.add(newChar, i++);

            } //must be a char
            

            s = s.rest();
        }

        s = cpy;

        return s;
    } //this version makes a deep copy
      //it doesn't work if its' copy is altered

    
    public Sequence copy(){
        Sequence s = this;
        Sequence cpy = new Sequence();
        
        for(int i=0; s !=null; i++){
            
            if(s.first() instanceof Sequence){
                Sequence newSeq = new Sequence();
                newSeq = ((Sequence)s.first()).copy();
                cpy.add(newSeq, i);
            } //if its a Sequence
            
            else if(s.first() instanceof MyInteger){
                MyInteger newInt = new MyInteger();
                int val = ((MyInteger)s.first()).Get();
                newInt.Set(val);
                cpy.add(newInt, i);
            } //if its an int
            
            else{
                MyChar newChar = new MyChar();
                char val = ((MyChar)s.first()).Get();
                newChar.Set(val);
                cpy.add(newChar, i);
            } //must be a char
            

            s = s.rest();
        }

        return cpy;
    }
}