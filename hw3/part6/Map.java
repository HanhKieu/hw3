public class Map extends Element {
	Map next;
	Pair data;



	public Map(){
		next = null;
		data = null;
	}
	public MapIterator begin(){
        MapIterator it = new MapIterator();
        Map s = this;
        it.s = s; //makes iterator's current seqobject , the head
        return it;
    }
    public MapIterator end(){
        MapIterator it = new MapIterator();
        Map s = this;
        while(s!=null){  
            s = s.next;
        }
        it.s = s;
        return it; //returns iterator object with s being the end variable
    }

    public void add(Pair pair){

	    Map newElement = new Map();
	   	Map s = this;
	    Pair temp;
	    newElement.data = pair;
	    if(s.data == null ){
	        s.data = pair;
	    }//if there's nothing there
	    else{
	        if(s.data.key.Get() > pair.key.Get()){
	            temp = s.data;
	            s.data = pair;
	            newElement.data = temp;
	            newElement.next = s.next;
	            s.next = newElement;
	        }//if you're trying to add to the front
	        else{

	        	while(s!= null){
	        		if(s.next == null){
	        			s.next = newElement;
	        			break;
	        		}
	        		else if(s.next.data.key.Get() > pair.key.Get()){
	        			newElement.next = s.next;
	                    s.next = newElement;
	                    break;
	        		}
	        		s = s.next;
	        	}
	        }
	    }  

    }// add element to Map where it belongs



    public void Print(){
	Map s = this;
	System.out.print("[ ");
	while (s!=null) {
		s.data.Print();
        System.out.print(" ");
        s = s.next;
	}
	System.out.print("]");
   
    }
}