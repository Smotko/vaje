#include <stdio.h>
#include <stdbool.h>
#include <math.h>

int main(){
	int m = 0;
	int n = 0;
	int stevec = 0;
	scanf("%d %d", &m, &n);
	
	for(m; m <= n; m++){
		for(int i = 1; i < m; i++){
			int j = m*m - i*i;
			int koren = sqrt(j);
			if(koren*koren == j){
				stevec++;
				break;
			}
		}
	}
	
	printf("%d\n", stevec);
	return 0;
}
