public class Sequence extends Element {
	Element[] mySeqVar;
    public Sequence(){
    	mySeqVar = new Element[0];
    }

    public Element[] Get(){
    	return mySeqVar;
    }

    public void Set(Element[] val){
    	mySeqVar = val;
    }
}