package year2016_best_answer;


class Solution{
	 public String solution(int a, int b) {
	    String day[] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
	    int mDay[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	   
	    for (int i = 0 ; i < a-1 ; i++) 
	    	b += mDay[i];
	    
	    b--;
	    return day[b%7];
	 }
}

public class Year2016BestCleanCode {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(12, 28));
		//날짜를 확인하기 위한 코드..
		for (int i = 1 ; i <=12 ; i++) {
			System.out.println(i + "월");
			switch (i) {
				case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
					for (int j = 1 ; j <= 31 ; j++) {
						System.out.print(j + ":" + s.solution(i, j) + "  ");
						if (j%7==0) {
							System.out.println();
						}
					}
					break;
				case 4 : case 6 : case 9 : case 11 :
					for (int j = 1 ; j <= 30 ; j++) {
						System.out.print(j + ":" + s.solution(i, j) + "  ");
						if (j%7==0) {
							System.out.println();
						}
					}
					break;
				case 2 :
					for (int j = 1 ; j <= 29 ; j++) {
						System.out.print(j + ":" + s.solution(i, j) + "  ");
						if (j%7==0) {
							System.out.println();
						}
				}
				break;
			}
			System.out.println();
		}
				
	}
}
