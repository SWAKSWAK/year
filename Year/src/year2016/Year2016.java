/*
 * ���α׷��ӽ� �ڵ��׽�Ʈ ���� Level 1 2016��
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 */

/*
 * ���� ���� Ǯ��
 * 
 * ��Ģ�� ã�Ҵ�
 *    		�� ���������� ���� �ϼ� -:1(����) +:����+1��
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
 * �� ����(1/2/9,11 ����) ��Ģ�� ���´� 30*����  + �ش��/2 - 1(�����̹Ƿ�) + b(��)
 * ������ ǥ���ϸ�		30 * (a-1) + (a/2) - 1 + b  >
 * 
 * 1���� ���ޱ����� ���� �ϼ��� 0 �̹Ƿ� �ٷ� b��
 * 2���� ���� ��¥ ī��Ʈ�� ���� �ȵǾ����Ƿ� -1�� ����		30*����  + �ش��/2 + b(��)
 * 
 *
 * index ���� �����ϼ��� 7�� ���� ���������� 0���� �����ϴ� �ε��� Ư���� -1 �� �ϸ� ���ϴ� ���� ���� �� ������
 * �������� 0�� �ǰ� �ű⿡ -1 �� �Ǹ� index �� -1 �� �Ǿ� ������. �������� 7�� ������ ���� ������ �ش� ������ 6���� �ʱ�ȭ �س��� �Ѵ�.
 */		

package year2016;
class Solution {
	public String solution(int a, int b) {
    	int d = 0 ; // 2016���� ���� �� ���� ���� ���� d
    	String answer = "";
    	String day[] = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"}; //16/1/1 �� �ݿ��� �̹Ƿ� index 0 �� �ݿ��Ϸ� ����
    	int index;

    	
    	switch(a) {
    		case 1 : //���� �ϼ� 0
    			d = b; //���� ������ �ϼ� count + b
    			index = d%7-1;
    			if (index < 0) {
    				index = 6;
    			}
    			answer = day[index]; //index 0���� �����ϹǷ� -1
    	    	return answer;
    		case 2 :
    			d = 30*(a-1) + (a/2) + b; //���� ������ �ϼ� count + b
    			index = d%7-1;
    			if (index < 0) {
    				index = 6;
    			}
    			answer = day[index];
    	    	return answer;
    		case 9 : case 11 :
    			d = 30*(a-1) + a - (a/2) - 1 + b; //���� ������ �ϼ� count + b
    			index = d%7-1;
    			if (index < 0) {
    				index = 6;
    			}
    			answer = day[index];
    			return answer;
    		default :
      			d = 30*(a-1) + (a/2) - 1 + b; //���� ������ �ϼ� count + b
    			index = d%7-1;
    			if (index < 0)
    				index = 6;
    			
    			answer = day[index];
    	    	return answer;
    	}
    
    	
    	
    	
//    	������ ������..
//    	if (a == 1) {
//			d = b; //���� ������ �ϼ� count + b
//			answer = day[d%7-1]; //index 0���� �����ϹǷ� -1
//	    	return answer;
//    	}
//    	else {
//			d = 30*(a-1) + (a/2) - 1 + b; //���� ������ �ϼ� count + b
//			answer = day[d%7-1];
//	    	return answer;
//    	}
//    	
//    	for (int i = 0 ; i < a ; i++) {
//    		switch (a) {
//    			case 1 :
//    				d = b; //���� ������ �ϼ� count + b
//    				answer = day[d%7-1]; //index 0���� �����ϹǷ� -1
//    				break;
//    			case 2 : case 4 : case 6 : case 8 : case 9 : case 11 :
//    				//��Ģ�� �����. 31���� �ִ� ������ ���� 30*(a-1)+(a-(a/2))-1 ��ŭ�� �ϼ� �̴�. ���⼭ (a-(a/2)) �� �߰��Ǵ� 31�� 1�ϰ�
//    				d = 30*(a-1)+(a/2)-1 + b; //���� ������ �ϼ� count + b
//    				answer = day[d%7-1];
//    				break;
//    			default ://3,5,7,10,12
//    				d = 30*(a-1) + (a/2) - 1 + b; //���� ������ �ϼ� count + b
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
		//��¥�� Ȯ���ϱ� ���� �ڵ�..
		for (int i = 1 ; i <=12 ; i++) {
			System.out.println(i + "��");
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
