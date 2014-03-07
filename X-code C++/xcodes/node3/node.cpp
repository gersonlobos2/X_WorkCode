/*
 *  node.cpp
 *  node3
 *
 *  Created by Gerson Lobos on 10/12/10.
 *  Copyright 2010 westchester comunity college. All rights reserved.
 *
 */

// *****************************************************************************
// Paul Velasco
// October 13, 2010
// FILE: node.cpp
// Modified Main & Savage Node class
// Modifications Made: See modification list in node.h
// *****************************************************************************

// *****************************************************************************
// IMPLEMENTS: The functions of the Node class and the
// 	linked list toolkit (see node.h for documentation).
// INVARIANT for the Node class:
//   The data of a node is stored in dataField, and the link in linkField.
// *****************************************************************************

// *****************************************************************************
#include "node.h"
#include <cassert>    // Provides assert
#include <cstdlib>    // Provides NULL and size_t
#include <iostream>
#include <ctime>

using namespace std;
// *****************************************************************************

// *****************************************************************************
// NODE CLASS MEMBER FUNCTIONS
// *****************************************************************************
// CONSTRUCTOR
Node::Node ( const valueType & initData ,
			Node * initLink )
{
	
	dataField = initData;
	linkField = initLink;
}

// *****************************************************************************
// MUTATOR FUNCTIONS
void Node::setData( const valueType & newData )
{
	dataField = newData;
}

void Node::setLink(Node * newLink)
{
	
    linkField = newLink;
}

// *****************************************************************************
// ASSESSOR FUNCTIONS
Node::valueType Node::getData( ) const
{
    return dataField;
}

// const function to return linkField
const Node * Node::getLink( ) const
{
    return linkField;
}

// non const function to return linkField
Node * Node::getLink( )
{
    return linkField;
}
// *****************************************************************************

// *****************************************************************************
// LINKED LIST TOOLKIT NON-MEMBER FUNCTIONS
// *****************************************************************************
size_t listLength(const Node * headPtr)
{
    const Node * cursor;
    size_t answer;
	
    answer = 0;
    for (cursor = headPtr; cursor != NULL; cursor = cursor->getLink( ))
	    ++answer;
	
    return answer;
}

// *****************************************************************************
void listHeadInsert(Node *& headPtr, const Node::valueType & entry)
{
    headPtr = new Node(entry, headPtr);
}

// *****************************************************************************
void listInsert(Node * previousPtr, const Node::valueType & entry)
{
    Node * insertPtr;
	
    insertPtr = new Node(entry, previousPtr->getLink( ));
    previousPtr->setLink(insertPtr);
}

// *****************************************************************************
Node * listSearch(Node * headPtr, const Node::valueType & target)
{
    Node * cursor;
	
    for (cursor = headPtr; cursor != NULL; cursor = cursor->getLink( ))
	    if (target == cursor->getLink()->getData())
			return cursor;
    return NULL;
}

// *****************************************************************************
const Node * listSearch(const Node * headPtr, const Node::valueType & target)
{
    const Node * cursor;
	
    for (cursor = headPtr; cursor != NULL; cursor = cursor->getLink( ))
	    if (target == cursor->getLink()->getData( ))
		    return cursor;
    return NULL;
}

// *****************************************************************************
Node * listLocate(Node * headPtr, size_t position)
{
    Node * cursor;
    size_t i;
	
    assert (0 < position);
    cursor = headPtr;
    for (i = 1; (i < position) && (cursor != NULL); i++)
	    cursor = cursor->getLink( );
    return cursor;
}

// *****************************************************************************
const Node * listLocate(const Node * headPtr, size_t position)
{
	const Node * cursor;
	size_t i;
    
	assert (0 < position);
	cursor = headPtr;
	for (i = 1; (i < position) && (cursor != NULL); i++)
	    cursor = cursor->getLink( );
	return cursor;
}

// *****************************************************************************
void listHeadRemove(Node *& headPtr)
{
	Node * removePtr;
	
	removePtr = headPtr;
	headPtr = headPtr->getLink( );
	delete removePtr;
}

// *****************************************************************************
void listRemove(Node * previousPtr)
{
	Node * removePtr;
	
	removePtr = previousPtr->getLink();
	previousPtr->setLink(removePtr->getLink( ));
	delete  removePtr;
}


// *****************************************************************************
void listClear(Node *& headPtr)
{
    while (headPtr != NULL)
	    listHeadRemove(headPtr);
}

// *****************************************************************************
void listCopy(const Node * sourcePtr, Node *& headPtr, Node *& tailPtr)
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

// *****************************************************************************
void listDisplay( const Node * headPtr)
{
	size_t length = listLength(headPtr);
	const Node * cursor = headPtr;
	
	cout << endl;
	
	// display data and memory addresses in the list
	for (size_t i = 0; i < length; i++)
	{
		cout << "Node #: " << i << "\t" << "Data Value: "
		<< cursor->getData() << "\t\tat\t" << cursor << endl;
		cursor = cursor->getLink();
	}
}



