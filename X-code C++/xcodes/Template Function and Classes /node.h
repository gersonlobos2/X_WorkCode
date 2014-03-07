/*
 *  node.h
 *  Template Function and Classes 
 *
 *  Created by Gerson Lobos on 11/8/10.
 *  Copyright 2010 westchester comunity college. All rights reserved.
 *
 */
#ifndef NODE_H
#define NODE_H
//#inclute <Template>
#include <cstdlib> 			// Provides size_t and NULL

//using namespace std;
// *****************************************************************************

// *****************************************************************************
namespace gela {
	

template <class Item>
class Node
{
public:
	// TYPEDEF -- change double to data type needed
	// Check documentation above to see the requirements
	typedef Item valueType;
	
	// CONSTRUCTOR
	Node ( const Item& initData = Item(), Node * initLink = NULL )
	{dataField=initData; linkField=initLink;}
	
	// MUTATOR FUNCTIONS
	void setData( const Item& newData ){dataField=newData;}
	
	void setLink(Node* newLink){linkField=newLink;}
	
	// ASSESSOR FUNCTIONS
	
	Item& getData( ){return dataField;}
	
	// const function to return linkField
	const Node* getLink( ) const{return linkField;}
	
	// non const function to return linkField
	Node* getLink( ){return linkField;}
	
private:
	Item dataField;
	Node* linkField;
};
// *****************************************************************************

// *****************************************************************************
// LINKED LIST TOOLKIT NON-MEMBER FUNCTIONS
// *****************************************************************************
template <class Item>
std::size_t listLength(const Node<Item> * headPtr); //right

template <class Item>
void listHeadInsert(Node<Item> *& headPtr, const Item& entry);//right

template <class Item>
void listInsert(Node<Item>* previousPtr, const Item& entry); //right

template <class NodePtr,class Item>
NodePtr listSearch(NodePtr headPtr, const Item& target); //right
//the one on top takes care of both the const and non const
//const Node * listSearch (const Node<Item> * headPtr, const Item& target);

template<class NodePtr,class SizeType>
NodePtr listLocate(NodePtr headPtr,SizeType position);    //right
//dont need it cus i think the one on top takes care of both.
//const Node * listLocate(const Node * headPtr, size_t position);

template<class Item>
void listHeadRemove(Node<Item> *& headPtr);//right

template<class Item>
void listRemove(Node<Item>* previousPtr);

template<class Item>
void listClear(Node<Item> *& headPtr);  //right

template<class Item>
void listCopy(const Node<Item> * sourcePtr, Node<Item> *& headPtr, Node<Item> *& tailPtr);//right

template<class Item>
void listDisplay(const Node<Item> * headPtr);
	
	
	template<class Item>
	Node<Item>* setNodeDeck();
// *****************************************************************************
}
#include "node.hh"
#endif

