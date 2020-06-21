/*
 * 프로그래머스 코딩테스트 연습 Level 1 2016년
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 */

/*
 * 나의 문제 풀이
 * 
 * 규칙을 찾았다
 *    		각 전월까지의 누적 일수 -:1(윤년) +:누적+1일
 *   		1	:	0
 *   		2	:	30    +1(a/2)
 *   		3	:	60 -1 +1(a/2)
 *  		4	:	90 -1 +2(a/2)
 *   		5	:	120 -1 +2(a/2)
 *   		6	:	150 -1 +3(a/2)
 *   		7	:	180 -1 +3(a/2)
 *   		8	:	210 -1 +4(a/2)
 *   		9	:	240 -1 +5(a-a/2)
 *   		10	:	270 -1 +5(a/2)
 *   		11	:	300 -1 +6(a-a/2)
 *   		12	:	330 -1 +6(a/2)
 * 각 월은(1/2/9,11 제외) 규칙을 갖는다 30*전월  + 해당월/2 - 1(윤년이므로) + b(일)
 * 식으로 표현하면		30 * (a-1) + (a/2) - 1 + b  >
 * 
 * 1월은 전달까지의 누적 일수가 0 이므로 바로 b값
 * 2월은 윤달 날짜 카운트가 아직 안되었으므로 -1을 없앤		30*전월  + 해당월/2 + b(일)
 * 
 *
 * index 값은 누적일수를 7로 나눈 나머지값에 0부터 시작하는 인덱스 특성상 -1 을 하면 원하는 값을 얻을 수 있지만
 * 나머지가 0이 되고 거기에 -1 이 되면 index 는 -1 이 되어 버린다. 일주일은 7일 단위로 돌기 때문에 해당 조건은 6으로 초기화 해놔야 한다.
 */		

package year2016;
class Solution {
	public String solution(int a, int b) {
    	int d = 0 ; // 2016년의 누적 일 수를 담을 변수 d
    	String answer = "";
    	String day[] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}; //16/1/1 은 금요일 이므로 index 0 을 금요일로 설정
    	int index;

    	
    	switch(a) {
    		case 1 : //누적 일수 0
    			d = b; //전달 까지의 일수 count + b
    			index = d%7-1;
    			if (index < 0) {
    				index = 6;
    			}
    			answer = day[index]; //index 0부터 시작하므로 -1
    	    	return answer;
    		case 2 :
    			d = 30*(a-1) + (a/2) + b; //전달 까지의 일수 count + b
    			index = d%7-1;
    			if (index < 0) {
    				index = 6;
    			}
    			answer = day[index];
    	    	return answer;
    		case 9 : case 11 :
    			d = 30*(a-1) + a - (a/2) - 1 + b; //전달 까지의 일수 count + b
    			index = d%7-1;
    			if (index < 0) {
    				index = 6;
    			}
    			answer = day[index];
    			return answer;
    		default :
      			d = 30*(a-1) + (a/2) - 1 + b; //전달 까지의 일수 count + b
    			index = d%7-1;
    			if (index < 0)
    				index = 6;
    			
    			answer = day[index];
    	    	return answer;
    	}
    
    	
    	
    	
//    	삽질의 흔적들..
//    	if (a == 1) {
//			d = b; //전달 까지의 일수 count + b
//			answer = day[d%7-1]; //index 0부터 시작하므로 -1
//	    	return answer;
//    	}
//    	else {
//			d = 30*(a-1) + (a/2) - 1 + b; //전달 까지의 일수 count + b
//			answer = day[d%7-1];
//	    	return answer;
//    	}
//    	
//    	for (int i = 0 ; i < a ; i++) {
//    		switch (a) {
//    			case 1 :
//    				d = b; //전달 까지의 일수 count + b
//    				answer = day[d%7-1]; //index 0부터 시작하므로 -1
//    				break;
//    			case 2 : case 4 : case 6 : case 8 : case 9 : case 11 :
//    				//규칙이 생긴다. 31일이 있는 다음달 월은 30*(a-1)+(a-(a/2))-1 만큼의 일수 이다. 여기서 (a-(a/2)) 는 추가되는 31중 1일값
//    				d = 30*(a-1)+(a/2)-1 + b; //전달 까지의 일수 count + b
//    				answer = day[d%7-1];
//    				break;
//    			default ://3,5,7,10,12
//    				d = 30*(a-1) + (a/2) - 1 + b; //전달 까지의 일수 count + b
//    				answer = day[d%7-1];
//    				break;
//    		}
//    	}
//    	return answer;
    	
    	
    	
    	
    }
}
public class Year2016 {
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
