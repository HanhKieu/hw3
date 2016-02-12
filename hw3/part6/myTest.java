class myTest {

   public static void main(String args[]) {
	TestPart4();	
   }

  public static void TestPart4() {
    MyChar key = new MyChar();
    key.Set( (char) ('c'));
    MyInteger val = new MyInteger();
    val.Set(65);
    Pair newPair = new Pair(key, val);
    Map m = new Map();

    m.add(newPair);
    key = new MyChar();
    key.Set( (char) ('b'));
    val = new MyInteger();
    val.Set(65);
    newPair = new Pair(key, val);

    m.add(newPair);


      key = new MyChar();
    key.Set( (char) ('b'));
    val = new MyInteger();
    val.Set(66);
    newPair = new Pair(key, val);

    m.add(newPair);
    key = new MyChar();
    key.Set( (char) ('a'));
    val = new MyInteger();
    val.Set(65);
    newPair = new Pair(key, val);

    m.add(newPair);




    //m.Print();



}
}