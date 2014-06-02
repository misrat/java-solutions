// print all paths of a 2D matrix from first element(top element) to the last element(bottom right)
// all paths must be either one right or one down to current element


package tm.InterviewProblems;

class ArrayPath{
	private int[][] mat; //2D array for input array
	private int size;
	private int totalRows;
	private int totalCols;
	
	public ArrayPath(int[][] inputArray) {
		mat = inputArray;
		totalRows = mat.length; totalCols = 0;
		size = totalElements();
	}
	
	private int totalElements() {
		int nElements = 0;
//		for(int i =0; i < mat.length;++i) {			
//			for(int j =0; j < mat[i].length;++j)
//				++totalElements;
//		}
		
		for(int i =0; i< mat.length; ++i) {
			nElements += mat[i].length;
		}	
		
		totalCols = nElements / mat.length;
		return (nElements);
	}

	public void printAllPaths() {
		
		int[] pathArray = new int[size];//store the path, maximum size = size of input array
		//int index =0; //not necessary
		addPath(0,0,pathArray,0);//passing the index number of first element, i = j =0 and 
								// the pathArray and its initial index
	}
	
	private void addPath(int i,int j,int[] path,int len) {
		
		if( i>=totalRows || j >= totalCols )  //check if row or col exceeds boundary
			return;
			
		path[len++] = mat[i][j];
		addPath(i+1,j,path,len); // go down
		addPath(i,j+1,path,len); //go right		
		
		if( i+1>=totalRows && j+1 >= totalCols ) // will reach here only once
			printPath(path,len);
	}
	
	private void printPath(int[] path, int len) {
		for(int  i =0 ; i < len; ++i)
			System.out.print(path[i] + " ");
		
		System.out.println();
	}
}