
// Time Complexity : O(n)
// Space Complexity : O(1)

public class Solution extends Relation {
	
	public int findCelebrity(int n){

		int celeb = 0;

		// Iterate through each person 
		for (int i =1 ; i< n; i++){

            //if celeb knows i, then celeb can be ruled out as celebrity should not know anyone.
            // There can be possibility that i can be celeb, so update celeb to i.
			if (knows(celeb, i)){
				celeb = i;
			}
		}

		// Iterate through each person 
		for (int i = 0; i< n; i++){

			// Donot do anything if i and celeb are same person
			if (i== celeb){
				continue;
			}
            //if i does not know the celeb or celeb knows i, 
            // then there is no celeb at all.
            // As per rule: Celeb should not know anyone and everyone should know celeb
			if (knows(celeb, i) || !knows(i, celeb)){
				return -1;
			}
		}

		return celeb;

	}
	

}