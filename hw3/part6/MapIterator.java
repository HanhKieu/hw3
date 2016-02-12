public class MapIterator {
	Map s;

	public boolean equal(MapIterator other){
		if(s == other.s){
			return true;
		}
		return false;
	}

	public MapIterator advance(){
		MapIterator it = this;
		it.s = it.s.next;
		return it;
	}

	public Pair get(){
		return s.data;
	}

}