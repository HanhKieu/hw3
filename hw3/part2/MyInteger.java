public class MyInteger extends Element {

	int myIntVar;

    public MyInteger(){
    	myIntVar = 0;
    }

    public int Get(){
    	return myIntVar;
    }

    public void Set(int val){
        myIntVar = val;
    }

    public void Print(){
    	System.out.print(myIntVar);
    }    

}