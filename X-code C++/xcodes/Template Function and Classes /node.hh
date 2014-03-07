/*
 *  node.hh
 *  Template Function and Classes 
 *
 *  Created by Gerson Lobos on 11/9/10.
 *  Copyright 2010 westchester comunity college. All rights reserved.
 *
 */

#include <cassert>
#include <cstdlib>
#include "node.h"
#include "card.h"

namespace gela{
	
	template<class Item>
	void listClear(Node<Item> *& headPtr)
	{
		while (headPtr != NULL)
			listHeadRemove(headPtr);
	}
//**********************************************************************************
	template<class Item>
	void listCopy(const Node<Item> * sourcePtr, Node<Item> *& headPtr, Node<Item> *& tailPtr)
	{
		headPtr = NULL;
		tailPtr = NULL;
		
		// Handle the case of the empty list.
		if (sourcePtr == NULL)
			return;
		
		// Make the head node for the newly created list, and put data in it.
		listHeadInsert(headPtr, sourcePtr->getData( ));
		tailPtr = headPtr;
		
		// Copy the rest of the nodes one at a time,adding at the tail of new list.
		sourcePtr = sourcePtr->getLink( );
		while (sourcePtr != NULL)
		{
			listInsert(tailPtr, sourcePtr->getData( ));
			tailPtr = tailPtr->getLink( );
			sourcePtr = sourcePtr->getLink( );
		}
	}
//**********************************************************************************
	template<class Item>
	
	void listHeadInsert(Node<Item> *& headPtr, const Item & entry)
	{
		headPtr = new Node<Item>(entry, headPtr);
	}
	
//**********************************************************************************	
	template<class Item>
	void listHeadRemove(Node<Item> *& headPtr)
	{
		Node<Item> * removePtr;
		
		removePtr = headPtr;
		headPtr = headPtr->getLink( );
		delete removePtr;
	}
//**********************************************************************************
	template<class Item>
	void listInsert(Node<Item> * previousPtr, const Item& entry)
	{
		Node<Item> * insertPtr;
		
		insertPtr = new Node<Item>(entry, previousPtr->getLink( ));
		previousPtr->setLink(insertPtr);
	}
//**********************************************************************************
	template<class Item>
	std::size_t listLength(const Node<Item> * headPtr)
	{
		const Node<Item> * cursor;
		std::size_t answer;
		
		answer = 0;
		for (cursor = headPtr; cursor != NULL; cursor = cursor->getLink( ))
			++answer;
		
		return answer;
	}
//**********************************************************************************
	template<class NodePtr,class SizeType>
	NodePtr listLocate(NodePtr headPtr, SizeType position)
	{
		NodePtr cursor;
		std::size_t i;
		
		assert (0 < position);
		cursor = headPtr;
		for (i = 1; (i < position) && (cursor != NULL); i++)
			cursor = cursor->getLink( );
		
		return cursor;
	}
//**********************************************************************************
	template<class Item>
	void listRemove(Node<Item> * previousPtr)
	{
		Node<Item> * removePtr;
		
		removePtr = previousPtr->getLink();
		previousPtr->setLink(removePtr->getLink( ));
		delete removePtr;
	}
//**********************************************************************************
	template<class NodePtr,class Item>
	NodePtr listSearch(const NodePtr * headPtr, const Item& target)
	{
		NodePtr * cursor;
		
		for (cursor = headPtr; cursor != NULL; cursor = cursor->getLink( ))
			if (target == cursor->getData( ))
				return cursor;
		return NULL;
	}
	
	
//**********************************************************************************
	template<class NodePtr,class SizeType>
	NodePtr GenerateNodeCards(NodePtr headPtr,SizeType size)
	{
		
		std::size_t deckCard; //store the random card picked.
		NodePtr HeadPtr2;
		
		HeadPtr2=NULL;
		
		NodePtr cursor;
		std::size_t i;
		
		for ( i = 0; i < size; i++)
		{
			cursor=headPtr;
			
			deckCard = rand() % DECKSIZE;
			
			//cursor = findLink(HeadPtr,deckCard);
			cursor=listLocate(headPtr, deckCard);
			
			
			while ( (cursor->getData()).getPicked() )
			{
				deckCard = rand() % DECKSIZE;
			}
			(cursor->getData()).setPicked(true);  //it is suposed to set the value of picked = true
			
			//bool check=(cursor->getData()).getPicked(); //in here i am geting the value of picked from the card
			// i wanted to see if it was set to true 
			//but for soe reason it wont work.
			
			
			listHeadInsert(HeadPtr2, cursor->getData());
			//tempGenerate[i] = cursor->getData();    //storing the picked card into an array.
		}
		return HeadPtr2;
	}
	
//**********************************************************************************
	
	
	
	template<class Item>
	
	Node<Item>* setNodeDeck()
	{
		typedef Item ValueType;//$
		//Card deck[DECKSIZE];          // for static array of cards
		//Card * cards;                 // for dynamic arrays of cards
		
		//int numCards;                 // for number of cards in array
		
		ValueType data;//$
		Node<Item> * HeadPtr;//$
		Node<Item> * TailPtr;//$
		Node<Item> * PreviousPtr;//$
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
		return HeadPtr;
		
	}
	
//**********************************************************************************//END
}