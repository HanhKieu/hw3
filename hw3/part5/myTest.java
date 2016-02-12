class myTest {

   public static void main(String args[]) {
	TestPart4();	
   }

  public static void TestPart4() {
  	Matrix myMatrix = new Matrix(5,10);
  	myMatrix.Set(3,9,5);
  	System.out.println(myMatrix.Get(3,9));
	}

}