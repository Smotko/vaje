#include <stdio.h>

int main(){
	int a = 0;
	int b = 0;
	scanf("%d %d", &a, &b);
	int output = (a+b) / 2;
	int input = 0;
	while(1){
		scanf("%d", &input);
		if(input == 0){
			break;
		}else if(input == 1){
			output ++;
			a = output;
		}else{
			output --;
			b = output;
		}
		output = (a+b) / 2;
	}
	if(a == b){
		printf("%d\n", output);
	}else if(a < b){
		printf("%d %d\n", a,b);
	}else{
		printf("PROTISLOVJE\n");
	}
	
	return 0;
}
