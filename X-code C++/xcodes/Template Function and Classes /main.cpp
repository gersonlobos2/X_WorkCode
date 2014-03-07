#include <iostream>
#include "node.h"

#include "card.h"
#include <cassert>    // Provides assert
#include <cstdlib>
using namespace gela;
using namespace std;
int main () {
    // insert code here...
	//int size=
	//Node<Card>* headPtr;
	//headPtr = setNodeDeck();
	//GenerateNodeCards(headPtr,SizeType size);
	
	typedef Card ValueType;//$
	//Card deck[DECKSIZE];          // for static array of cards
	//Card * cards;                 // for dynamic arrays of cards
	
	//int numCards;                 // for number of cards in array
	
	ValueType data;//$
	Node<Card> * HeadPtr;//$
	Node<Card> * TailPtr;//$
	Node<Card> * PreviousPtr;//$
	HeadPtr=NULL;//$
	TailPtr=NULL;//$
	//Card targeta;
	
	
	// createDeck(HeadPtr);
	listHeadInsert(HeadPtr, data);
	TailPtr=HeadPtr;
	PreviousPtr=HeadPtr;
	
	
	for (int i = 1; i <= 4; i++)
	{
		for (int x = 1; x <= 13; x++)
		{
			data.setCard(x,i);
			listInsert(PreviousPtr, data);
			PreviousPtr=PreviousPtr->getLink();
			TailPtr=PreviousPtr;
		}
	}
	Node<Card>* cursor;
	cursor=HeadPtr;
	size_t length=listLength(HeadPtr);
	size_t i;
	for ( i=0; i<length;++i) {
		cout << cursor->getData();
		cursor=cursor->getLink();
	}
	//Node<Card>* HeadPtr2;

	
	
	cin.ignore().get();
    return EXIT_SUCCESS;
}
