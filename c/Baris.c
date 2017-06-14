/* Baris Gilir (Queue) */

#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

struct nod {

	char data;
	struct nod *next;
};

typedef struct nod NOD;
typedef enum { FALSE = 0, TRUE = 1} BOOL;

struct qnode{
	NOD *depan;
	NOD *belakang;
};

typedef struct qnode QNOD;

void CiptaGiliran (QNOD **q)
{
	(*q)->depan = NULL;
	(*q)->belakang= NULL;
}

NOD *NodBaru (char item)
{
	NOD *n;
		
		n = (NOD*) malloc(sizeof(NOD));
	
		if(n != NULL) {
		n->data = item;
		n->next = NULL;
		}
	return n;
 
}

BOOL GiliranKosong(QNOD *q)
{
	return((BOOL)(q->depan == NULL));
}

void Enqueue(QNOD **q, char item)
{
	NOD *n;
	n = NodBaru(item);
	if (GiliranKosong(*q)) {
		(*q)->depan = (*q)->belakang = n;
	}
	else
	{
		(*q)->belakang->next = n;
		(*q)->belakang = (*q)->belakang->next;
	}
}

char Dequeue(QNOD **q)
{

	char item;
	if (!GiliranKosong(*q)) {
	NOD *t;
	t = (*q)->depan;
	(*q)->depan = t->next;
	item = t->data;
	free(t);
}
	if((*q)->depan == NULL)
		(*q)->belakang = NULL;
	return item;
}

void CetakGiliran(QNOD *q)
{
	NOD *p;
	printf("Q --> ");
	for(p = q->depan; p != NULL; p=p->next)
		printf("[%c] --> ", p->data);
		printf("NULL\n");
}

int main()
{
	char item;
	QNOD *Q;

	CiptaGiliran(&Q);

	Enqueue(&Q, 'A');
	CetakGiliran(Q);

	Enqueue(&Q, 'B');
	CetakGiliran(Q);
	
	Enqueue(&Q, 'C');
	CetakGiliran(Q);
	
	item = Dequeue(&Q);

	getch();
 return 0;
}
