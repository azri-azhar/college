/* Tindanan (Stack). Uji tindanan kosong, Cipta tindanan, push, pop dan cetak
tindanan */

#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

typedef enum { FALSE = 0, TRUE = 1} BOOL;

// Takrifan Nod
struct nod {

	char data;
	struct nod *next;
};

typedef struct nod NOD;

// Uji Tindanan Kosong
BOOL TindananKosong(NOD *T)
{
	return ((BOOL)(T == NULL));
}

//Cipta Nod Baru
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

void CiptaTindanan (NOD **T)
{
	*T = NULL; // Sedia Tindanan Kosong
}

// Push
void Push(NOD **T, char item)
{
	NOD *n;

	n = NodBaru(item);
	n->next = *T;
	*T = n;
}

// Pop
char Pop(NOD **T)
{
	NOD *P; char item;

	if ( ! TindananKosong(*T)) {
		P = *T;
		*T = (*T)->next;
		item = P->data;
		free(P);
	}
	return item;
}

void CetakTindanan (NOD *T)
{
	NOD *p;

	printf("T --> ");
	
	for (p = T; p != NULL; p = p->next) {
		printf("[%c] --> ", p->data); }

		printf("NULL\n");

}

int main()
{
	NOD *T;
	CiptaTindanan(&T);
	Push(&T, 'I');
	Push(&T, 'D');
	Push(&T, 'E');
	CetakTindanan(T);

	return 0;
}
