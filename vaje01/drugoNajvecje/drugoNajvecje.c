#include <stdio.h>

int main(){
	int n = getchar()-'0';
	int min, max, output;
	getchar();
	for(int i = 0; i < n; i ++){
		int a = getchar()-'0';
		if(i == 0){
			min = a;
			max = a;
		}
		
		if(a <= min){
			min = a;
		}
		
		if(output < a && a < max)
			output = a;
			
		if(a >= max){
			output = max;
			max = a;
		}
			
		if(i == 1)
			output = min;
		getchar();
	}
	putchar(output+'0');
	return 0;
}
