// print all paths of a 2D matrix from first element(top element) to the last element(bottom right)
// all paths must be either one right or one down to current element.


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
		for(int i =0; i< mat.length; ++i) { // calculate total elements in the array
			nElements += mat[i].length;
		}			
		totalCols = nElements / mat.length; // total cols
		return (nElements);
	}

	public void printAllPaths() {
		
		int[] pathArray = new int[size];//store the path, maximum size = size of input array		
		addPath(0,0,pathArray,0);//passing the index number of first element, i = j =0 and 
								// the pathArray and its initial index
	}
	
	// the logic in this method can be improved
	private void addPath(int i,int j,int[] path,int len) {		
		if( i>=totalRows || j >= totalCols )  //check if row or col exceeds boundary
			return;			
		path[len++] = mat[i][j];
		addPath(i+1,j,path,len); // go down
		addPath(i,j+1,path,len); //go right		
		
		if( i+1>=totalRows && j+1 >= totalCols ) // will reach here only once
			printPath(path,len);
	}
	
	//print path- TODO save path in another array
	private void printPath(int[] path, int len) {
		for(int  i =0 ; i < len; ++i)
			System.out.print(path[i] + " ");
		
		System.out.println();
	}
}