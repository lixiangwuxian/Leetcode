#include<stdio.h>

class beatMonster{
public:
	int n;
	int m;
	int* skills;
	int* doubleKill;
	void init(){
		scanf("%d%d",&n,&m);
		skills=new int[n];
		doubleKill=new int[n];
		for(int i=0;i<n;i++){
			scanf("%d%d",skills+i,doubleKill+i);
		}
	}
	
};
