class Matrix extends Sequence {
	Sequence myMatrix;
	int rowSize;
	int colSize;

	Matrix(int rowsize, int colsize){
		rowSize = rowsize;
		colSize = colsize;
		myMatrix = new Sequence();
		MyInteger zero = new MyInteger();
		for(int i = 0; i < rowsize; i++){
			Sequence newRow = new Sequence();
			myMatrix.add(newRow, i); //adds a whole new row to our matrix
			for(int j = 0; j < colsize; j++){
				newRow.add(zero, j);
			}
		}

		PrintMatrix();
	}


	void Set(int rowPos, int colPos, int value){
		MyInteger myValue = new MyInteger();
		myValue.Set(value);

		if((rowSize - 1) < rowPos || (colSize - 1) < colPos || rowPos < 0 || colSize < 0)
			System.err.println("Matrix positions are out of bound");
		else{

			((Sequence)myMatrix.index(rowPos)).delete(colPos);
			((Sequence)myMatrix.index(rowPos)).add(myValue, colPos);
			PrintMatrix();
		}

		
	}


	public void PrintMatrix(){
		System.out.println("----------------");
		Element elm;
		int i = 0;
		SequenceIterator it1, it2;
		for (it1 = myMatrix.begin(); !it1.equal(myMatrix.end()); it1.advance()) {
			System.out.print(i + "");
			elm = it1.get();
			elm.Print();
			System.out.println();
			i++;
		} 
	}

}