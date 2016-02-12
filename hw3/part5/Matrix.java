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
	}


	void Set(int rowPos, int colPos, int value){
		MyInteger myValue = new MyInteger();
		myValue.Set(value);

		if((rowSize - 1) < rowPos || (colSize - 1) < colPos || rowPos < 0 || colSize < 0)
			System.err.println("Matrix positions are out of bound");
		else{

			((Sequence)myMatrix.index(rowPos)).delete(colPos);
			((Sequence)myMatrix.index(rowPos)).add(myValue, colPos);
		}

		
	}

	int Get(int rowPos, int colPos){
		return ((MyInteger)((Sequence)myMatrix.index(rowPos)).index(colPos)).Get();
	}

	Matrix Sum(Matrix mat){
		int currentSum;
		Matrix sumMatrix = new Matrix(rowSize,colSize);

		if((rowSize != mat.rowSize)|| (colSize != mat.colSize) ){
			System.err.println("Matrix Positions must be equal in order to add");
		}
		else{
			for(int i = 0; i < rowSize; i++){
				for(int j = 0; j < colSize; j++){
					currentSum = this.Get(i, j) + mat.Get(i, j);
					sumMatrix.Set(i, j, currentSum);
				}
			}
		}

		return sumMatrix;
	}

	Matrix Product(Matrix mat){

		Matrix prodMatrix = new Matrix(rowSize,mat.colSize);
		int currentProduct = 0;
		int currentSum = 0;

		if(colSize != mat.rowSize){
			System.err.println("Column Size does not match row size");
		}

		else{
			for(int i = 0; i < rowSize; i++){
				for(int k = 0; k < mat.colSize; k++){
					currentSum = 0;
					for(int j = 0; j < colSize; j++){
						currentProduct = this.Get(i,j) * mat.Get(j,k);
						currentSum = currentSum + currentProduct;
					}

				prodMatrix.Set(i, k, currentSum);
				}
			}
		}

		return prodMatrix;
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