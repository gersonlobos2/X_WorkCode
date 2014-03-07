// *****************************************************************************
// Professor Branca
// October 7, 2010
// FILE: node.h
// Modified Main & Savage Node class
// Modifications Made:
//		Code style changed to Professor Branca's standards
//		#ifndef NODE_H
//		#define NODE_H
//		Removed mainsavitch5 namespace
//		Class name changed to Node
//		Removed underscores from identifier names
//		Modified identifier names to Branca style, e.g. linkField
//		Node class member function implementations moved to node.cpp
//		Modified documentation to align with modifications
//		Added listDisplay function
// *****************************************************************************

// *****************************************************************************
// PROVIDES: A class for a node in a linked list, and list manipulation
// functions
//
// TYPEDEF for the Node class:
//     Each node of the list contains a piece of data and a pointer to the
//     next node. The type of the data is defined as Node::valueType in a
//     typedef statement. The valueType may be any
//     of the built-in C++ classes (int, char, ...) or a class with a copy
//     constructor, an assignment operator, and a test for equality (x == y).
// *****************************************************************************

// *****************************************************************************
// CONSTRUCTOR
//    Node ( const valueType& initData = valueType(),
//       	   Node * initLink = NULL )
//    Postcondition: The node contains the specified data and link.
//    NOTE: The default value for the initData is obtained from the default
//     	constructor of the valueType. In the ANSI/ISO standard, this notation
//     	is also allowed for the built-in types, providing a default value of
//     	zero. The initLink has a default value of NULL.
// *****************************************************************************

// *****************************************************************************
// NOTE: Some of the functions have a return value which is a pointer
//		to a node. Each of these  functions comes in two versions:
//		a non-const version (where the return value is Node*) and a const
//		version (where the return value is const Node*).
// EXAMPLES:
//    	const Node *c;
//    	c->link( ) activates the const version of link
//    	listSearch(c,... calls the const version of listSearch Node *p;
//    	p->link( ) activates the non-const version of link
//    	listSearch(p,... calls the non-const version of listSearch
// *****************************************************************************

// *****************************************************************************
// MUTATOR MEMBER FUNCTIONS
//    void setData(const valueType & newData)
//    Postcondition: The Node now contains the specified new data.
//   
//    void setLink(Node * newLink)
//    Postcondition: The node now contains the specified new link.
// *****************************************************************************

// *****************************************************************************
// ACCESSOR MEMBER FUNCTIONS
//    valueType getData( ) const
//    Postcondition: The return value is the data from this node.
//
//    const Node * getLink( ) const <----- const version
//    Node * getLink( ) <----------------- non-const version
//    Postcondition: The return value is the link from this node.
//    See the note (above) about the const version and non-const versions:
// *****************************************************************************

// *****************************************************************************
// LINKED LIST TOOLKIT NON-MEMBER FUNCTIONS
//    size_t listLength(const Node * headPtr)
//    Precondition: headPtr is the head pointer of a linked list.
//    Postcondition: The value returned is the number of nodes in the linked
//    	list.
//
//    void listHeadInsert(Node *& headPtr, const Node::valueType & entry)
//    Precondition: headPtr is the head pointer of a linked list.
//    Postcondition: A new node containing the given entry has been added at
//    	the head of the linked list; headPtr now points to the head of
//		the new, longer linked list.
//
//    void listInsert(Node * previousPtr, const Node::valueType & entry)
//    Precondition: previousPtr points to a node in a linked list.
//    Postcondition: A new node containing the given entry has been added
//    	after the node that previousPtr points to.
//
//    const Node * listSearch(const Node * headPtr,
//						const Node::valueType & target)
//    Node * listSearch(Node * headPtr, const Node::valueType & target)
//    See the note (above) about the const version and non-const versions:
//    Precondition: headPtr is the head pointer of a linked list.
//    Postcondition: The pointer returned points to the first node containing
//     	the specified target in its data member. If there is no such node, the
//     	null pointer is returned.
//
//    const Node * listLocate(const Node * headPtr, size_t position)
//    Node * listLocate(Node * headPtr, size_t position)
//    See the note (above) about the const version and non-const versions:
//    Precondition: headPtr is the head pointer of a linked list, and
//     	position > 0.
//    Postcondition: The pointer returned points to the node at the specified
//     	position in the list. (The head node is position 1, the next node is
//     	position 2, and so on). If there is no such position, then the null
//     	pointer is returned.
//
//    void listHeadRemove(Node *& headPtr)
//    Precondition: headPtr is the head pointer of a linked list, with at
//    	least one node.
//    Postcondition: The head node has been removed and returned to the heap;
//    	headPtr is now the head pointer of the new, shorter linked list.
//
//    void listRemove(Node * previousPtr)
//    Precondition: previousPtr points to a node in a linked list, and this
//    	is not the tail node of the list.
//    Postcondition: The node after previousPtr has been removed from the
//    	linked list.
//
//    void listClear(Node *& headPtr)
//    Precondition: headPtr is the head pointer of a linked list.
//    Postcondition: All nodes of the list have been returned to the heap,
//    	and the headPtr is now NULL.
//
//    void listCopy(const Node * sourcePtr, Node *& headPtr, Node *& tailPtr)
//    Precondition: sourcePtr is the head pointer of a linked list.
//    Postcondition: headPtr and tailPtr are the head and tail pointers for
//    	a new list that contains the same items as the list pointed to by
//     	sourcePtr. The original list is unaltered.
//
//	 void listPiece( const Node * startPtr, const Node * endPtr,
//   			   Node*& headPtr, Node*& tailPtr )
//    Precondition: startPtr and endPtr are pointers to nodes on the same
//    	linked list, with the startPtr node at or before the endPtr node
//    Postcondition: headPtr and tailPtr are the head and tail pointers for a
//    	new list that contains the items from startPtr up to but not including
//    	endPtr.  The endPtr may also be NULL, in which case the new list
//    	contains elements from startPtr to the end of the list.
//
//	 void listDisplay(const Node * headPtr)
//	 Precondition: headPtr is not NULL and points to the head of a list
//	 Postcondsition: All the values in the list will be displayed
// *****************************************************************************

// *****************************************************************************
// DYNAMIC MEMORY usage by the toolkit: 
//   If there is insufficient dynamic memory, then the following functions throw
//   	badalloc: the constructor, listHeadInsert, listInsert, listCopy,
//   	listPiece.
// *****************************************************************************


// *****************************************************************************
#ifndef NODE_H
#define NODE_H

#include <cstdlib> 			// Provides size_t and NULL

using namespace std;
// *****************************************************************************

// *****************************************************************************
class Node
{
public:
	// TYPEDEF -- change double to data type needed
	// Check documentation above to see the requirements
	typedef double valueType;
	
	// CONSTRUCTOR
	Node ( const valueType & initData = valueType( ),
		  Node * initLink = NULL );
	
	// MUTATOR FUNCTIONS
	void setData( const valueType& newData );
	void setLink(Node* newLink);
	
	// ASSESSOR FUNCTIONS
	valueType getData( ) const;
	
	// const function to return linkField
	const Node* getLink( ) const;
	
	// non const function to return linkField
	Node* getLink( );
	
private:
	valueType dataField;
	Node* linkField;
};
// *****************************************************************************

// *****************************************************************************
// LINKED LIST TOOLKIT NON-MEMBER FUNCTIONS
// *****************************************************************************
size_t listLength(const Node * headPtr);
void listHeadInsert(Node *& headPtr, const Node::valueType & entry);
void listInsert(Node * previousPtr, const Node::valueType & entry);
Node * listSearch(Node * headPtr, const Node::valueType & target);
const Node * listSearch (const Node * headPtr, const Node::valueType & target);
Node * listLocate(Node * headPtr, size_t position);
const Node * listLocate(const Node * headPtr, size_t position);
void listHeadRemove(Node *& headPtr);

void listRemove(Node * previousPtr,Node * headPtr,int rem);

void listClear(Node *& headPtr);
void listCopy(const Node * sourcePtr, Node *& headPtr, Node *& tailPtr);
void listDisplay(const Node * headPtr);
// *****************************************************************************

#endif
