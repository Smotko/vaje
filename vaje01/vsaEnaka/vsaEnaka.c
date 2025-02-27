#include <stdio.h>

int main(){
	int n = getchar()-'0';
	if(n == 0){
		putchar('1');
	}
	getchar();
	int b;
	for(int i = 0; i < n; i++){
		int a = getchar()-'0';
		getchar();
		
		if(i == 0)
			b = a;
		if(b != a){
			putchar('0');
			break;
		}
		b = a;
		if(i == n - 1){
			putchar('1');
		}
	}
	
	return 0;
}
