class myTest {

   public static void main(String args[]) {
	TestPart4();	
   }

  public static void TestPart4() {
  	Matrix myMatrix = new Matrix(2,3);
  	myMatrix.Set(0,0,0);
  	myMatrix.Set(0,1,1);
  	myMatrix.Set(0,2,2);
  	Matrix mySecondMatrix = new Matrix(3,2);
  	mySecondMatrix.Set(0,0,6);
  	mySecondMatrix.Set(1,0,5);
  	mySecondMatrix.Set(2,0,4);
  	myMatrix.Print();
  	mySecondMatrix.Print();
  	myMatrix = myMatrix.Product(mySecondMatrix);
  	myMatrix.Print();
	

}
}