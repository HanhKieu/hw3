public class MyChar extends Element {
    char myCharVar; 

    public MyChar(){
        myCharVar = '0';
    }

    public char Get(){
        return myCharVar;
    }

    public void Set(char val){
        myCharVar = val;
    }

    public void Print(){
        System.out.print("'" + myCharVar + "'");
    }    
}
