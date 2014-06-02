//a solution to LeetCode Jump Game II 
//https://oj.leetcode.com/problems/jump-game-ii/

/*Given an array of non-negative integers, you are initially positioned at the first index of the array.
* Each element in the array represents your maximum jump length at that position.
* Your goal is to reach the last index in the minimum number of jumps.
* For example:
* Given array A = [2,3,1,1,4]
* The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/

package tm.InterviewProblems;

public class JumpGameII {
	public int jump(int[] A) {
		int length = A.length;
		
		if(length == 0)return 0;
		if(length == 1)return 0;
		
		
		int finalIndex = length -1;
		int i =0;
		int nJumps = 0;
		int maxIndexReached = 0;
		int maxJump= 0; // update this value and select the max value for the next step
		while(i < finalIndex) {
			maxIndexReached = A[i] + i; // max index reached from current position
			
			//if maxIndexReached is beyond the array, then return nJumps+1;
			if(maxIndexReached >= finalIndex)	return (nJumps+1);
			nJumps++;
			
			/* if maxIndexReached is less than the array length, 
			 * determine if this is the best new position, for all other index values 
			 * between current and maxIndexReached,find the max Jump the algorithm 
			 * will make. This will return the max distance moved from current position 
			 * for two jumps- this is the greedy algorithm. */
			
			int tI = i;
			for(int j = i + 1; j <= maxIndexReached; ++j){
				if(maxJump < A[j]+j) {
					tI = j;					
				}					
				maxJump = Math.max(maxJump,A[j] + j); //compare maximum jump between the previous maxjump and from new position				
			}			
			i = tI; // go to the new position and continue
		}
		
		return nJumps;
	}
}