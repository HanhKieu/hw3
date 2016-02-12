class myTest {

   public static void main(String args[]) {
	TestPart4();	
   }

  public static void TestPart4() {
  	Matrix myMatrix = new Matrix(2,3);
  	myMatrix.Set(0,0,0);
  	myMatrix.Set(0,1,1);
  	myMatrix.Set(0,2,2);
  	Matrix mySecondMatrix = new Matrix(2,3);
  	mySecondMatrix.Set(0,0,6);
  	mySecondMatrix.Set(0,1,5);
  	mySecondMatrix.Set(0,2,4);
  	myMatrix.PrintMatrix();
  	mySecondMatrix.PrintMatrix();
  	myMatrix = myMatrix.Sum(mySecondMatrix);
  	myMatrix.PrintMatrix();
	

}
}