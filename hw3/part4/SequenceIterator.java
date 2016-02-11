public class SequenceIterator {
	Sequence s;

	public boolean equal(SequenceIterator other){
		if(s == other.s){
			return true;
		}
		return false;
	}

	public SequenceIterator advance(){
		SequenceIterator it = this;
		it.s = it.s.next;
		return it;
	}

	public Element get(){
		return s.data;
	}

}