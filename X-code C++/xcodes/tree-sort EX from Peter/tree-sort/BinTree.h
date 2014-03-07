
//PETER NEBAUER
//DATA STRUCTURES FALL 2010
//BinaryTreeNode Class
//
//---------------------------------------
// FILE: bintree.h 
// PROVIDES: A template class for a node in a binary tree and functions for 
// manipulating binary trees. The template parameter is the type of data in
// each node.
// 
// TYPEDEF for the BinaryTreeNode<Item> template class:
//   Each node of the tree contains a piece of data and pointers to its
//   children. The type of the data (BinaryTreeNode<Item>::valueType) is
//   the Item type from the template parameter. The type may be any of the C++
//   built-in types (int, char, etc.), or a class with a default constructor,
//   and an assignment operator.
//
// CONSTRUCTOR for the BinaryTreeNode<Item> class:
//   BinaryTreeNode(
//       const item& init_data = Item( ),
//       BinaryTreeNode<Item>* init_left = NULL,
//       BinaryTreeNode<Item>* init_right = NULL
//   )
//     Postcondition: The new node has its data equal to init_data,
//     and it's child pointers equal to init_left and init_right.
//
// MEMBER FUNCTIONS for the BinaryTreeNode<Item> class:
//   const item& getData( ) const      <----- const version
//   and
//   Item& getData( )                  <----- non-const version
//     Postcondition: The return value is a reference to the data from
//     this BinaryTreeNode.
//
//   const BinaryTreeNode* getLeft( ) const  <----- const version
//   and
//   BinaryTreeNode* getLeft( )              <----- non-const version
//   and
//   const BinaryTreeNode* getRight( ) const <----- const version
//   and
//   BinaryTreeNode* getRight( )             <----- non-const version
//     Postcondition: The return value is a pointer to the left or right child
//     (which will be NULL if there is no child).
//
//   void setData(const Item& new_data)
//     Postcondition: The BinaryTreeNode now contains the specified new data.
//
//   void setLeft(BinaryTreeNode* new_link)
//   and
//   void setRight(BinaryTreeNode* new_link)
//     Postcondition: The BinaryTreeNode now contains the specified new link
//     to a child.
//
//   bool isLeaf( )
//     Postcondition: The return value is true if the node is a leaf;
//     otherwise the return value is false.
//
// NON-MEMBER FUNCTIONS to maniplulate binary tree nodes:
//   tempate <class Process, class BTNode>
//   void inorder(Process f, BTNode* node_ptr)
//     Precondition: node_ptr is a pointer to a node in a binary tree (or
//     node_ptr may be NULL to indicate the empty tree).
//     Postcondition: If node_ptr is non-NULL, then the function f has been
//     applied to the contents of *node_ptr and all of its descendants, using
//     an in-order traversal.
//     Note: BTNode may be a BinaryTreeNode or a const binary tree node.
//     Process is the type of a function f that may be called with a single
//     Item argument (using the Item type from the node).
//
//   tempate <class Process, class BTNode>
//   void postorder(Process f, BTNode* node_ptr)
//      Same as the in-order function, except with a post-order traversal.
//
//   tempate <class Process, class BTNode>
//   void preorder(Process f, BTNode* node_ptr)
//      Same as the in-order function, except with a pre-order traversal.
//
//   template <class Item, class SizeType>
//   void print(const BinaryTreeNode<Item>* node_ptr, SizeType depth)
//     Precondition: node_ptr is a pointer to a node in a binary tree (or
//     node_ptr may be NULL to indicate the empty tree). If the pointer is
//     not NULL, then depth is the depth of the node pointed to by node_ptr.
//     Postcondition: If node_ptr is non-NULL, then the contents of *node_ptr
//     and all its descendants have been written to cout with the << operator,
//     using a backward in-order traversal. Each node is indented four times
//     its depth.
//
//   template <class Item>
//   void treeClear(BinaryTreeNode<Item>*& root_ptr)
//     Precondition: root_ptr is the root pointer of a binary tree (which may
//     be NULL for the empty tree).
//     Postcondition: All nodes at the root or below have been returned to the
//     heap, and root_ptr has been set to NULL.
//
//   template <class Item>
//   BinaryTreeNode<Item>* tree_copy(const BinaryTreeNode<Item>* root_ptr)
//     Precondition: root_ptr is the root pointer of a binary tree (which may
//     be NULL for the empty tree).
//     Postcondition: A copy of the binary tree has been made, and the return
//     value is a pointer to the root of this copy.
//
//   template <class Item>
//   size_t treeSize(const BinaryTreeNode<Item>* node_ptr)
//     Precondition: node_ptr is a pointer to a node in a binary tree (or
//     node_ptr may be NULL to indicate the empty tree).
//     Postcondition: The return value is the number of nodes in the tree.
//===========================================================================
//ADDITIONAL FUNCTIONS:
//
//	=======================================================
//	Member function for inserting into any tree pointer
//	=======================================================
//
//		void insertNode(Item key, BinaryTreeNode<Item>*& rootP);
//
//	Pre-> A pointer of BinaryTreeNode<Item>* exists. 
//	The pointer can be == NULL or != NULL.  
//	Post-> This function will instaniate the first root 
//	node if the root == NULL and then inserts the key data. 
//	If root != NULL, the tree will be traversed using a
//	recursive function which inserts the key data into a
//	new node in the tree. The key data and new node will 
//	be placed in the proper location according to standard BST rules.
//
//	=======================================================
//	NON-Member function for recursive inserting into a leaf
//	=======================================================
//		template<class Item>
//		void insertN(Item key, BinaryTreeNode<Item> *leaf);
//
//	Pre-> A pointer of type BinaryTreeNode<int>* exists, and it alrady 
//	has some data in it's node. In other words, it's a leaf, and it 
//	is != NULL. Key is the int new value to insert into the tree.
//	Post-> A tree will be built using recursion, adding a new node with 
//	the key value each time.
//	Uses: Read in data from an array and feed it into the tree to build 
//	the initial tree before traversing.
//
//	===================================================================
//	In-order, Post-Order & Pre-Order traversal print functions****
//	Library used: cstdlib, iostream
//	===================================================================
	
	//inOrder-> prints a tree using inOrder Traversal.
	//process left nodes, process root, process right nodes
	//		template <class Item>
	//		void inOrderPrint(const BinaryTreeNode<Item>* node_ptr)
	//
	//preOrder->  prints a tree using preOrder Traversal.
	//process root, process left nodes, process right nodes
	//		template <class Item>
	//		void preOrderPrint(const BinaryTreeNode<Item>* node_ptr)
	//
	//postOrder-> prints a tree using postOrder Traversal.
	//process left nodes, process right nodes, process root.
	//		template <class Item>
	//		void postOrderPrint(const BinaryTreeNode<Item>* node_ptr)
	//
	//===================================================================	
	//TRAVERSAL FILE OUT FUNCTIONS -----------------------	
	//===================================================================
	//These functions write out data to an external file using 3 different traversal metods.
	//The data files are used for creating new trees in these corresponding traversal orders.
	/*
	template <class Item>
	void inOrderOut(const BinaryTreeNode<Item>* node_ptr)
	
	template <class Item>
	void preOrderOut(const BinaryTreeNode<Item>* node_ptr)

	template <class Item>
	void postOrderOut(const BinaryTreeNode<Item>* node_ptr)
	*/
//============================================================================
//**********	END ADDITIONAL FUNCTIONS INFO		**************************
//============================================================================
/*
NOTES:
These libraries are used for this class for writing external files.
The compiler says they are depricated libraries, but they are valid to be used.
I would have used more updated versions of these libraries, but these were the only
ones that worked for me, and the newer version did not!

#include <fstream.h>
#include <istream.h>
*/


#ifndef BINTREE_H
#define BINTREE_H
#include <cstdlib>  // Provides NULL and size_t
//#include <fstream>

    template <class Item>
    class BinaryTreeNode
    {
    public:
	// TYPEDEF
	typedef Item valueType;
	// CONSTRUCTOR
	BinaryTreeNode(
	    const Item& init_data = Item( ),
	    BinaryTreeNode* init_left = NULL,
	    BinaryTreeNode* init_right = NULL
	)
	{ 
		dataField = init_data; 
	    leftField = init_left; 
	    rightField = init_right;
	}
	// MODIFICATION MEMBER FUNCTIONS
	Item& getData( ) { return dataField; }
	BinaryTreeNode* getLeft( ) { return leftField; }
	BinaryTreeNode* getRight( ) { return rightField; }
	void setData(const Item& new_data) { dataField = new_data; }
	void setLeft(BinaryTreeNode* new_left) { leftField = new_left; }
	void setRight(BinaryTreeNode* new_right) { rightField = new_right; }
	void insertNode(Item key, BinaryTreeNode<Item>*& rootP);
	
	
	//navigate the tree
	void shiftLeft();	//left()
    void shiftRight();	//right()	
	void gotoRoot(); //go to main_root	

	// CONST MEMBER FUNCTIONS
	Item peek_left() const;
	Item peek_right() const;
   
	const Item& getData( ) const { return dataField; }
	const BinaryTreeNode* getLeft( ) const { return leftField; }
	const BinaryTreeNode* getRight( ) const { return rightField; }
	bool isLeaf( ) const 
	    { return (leftField == NULL) && (rightField == NULL); }
    private:
	Item dataField;
	BinaryTreeNode <Item>*rootPtr;
	BinaryTreeNode <Item>*cursor;
	BinaryTreeNode *leftField;
	BinaryTreeNode *rightField;	
	//-------------------
	BinaryTreeNode <Item>*root_ptr;
    };
		
	template <class Item>
	void inOrderOut(const BinaryTreeNode<Item>* node_ptr);
	
	template <class Item>
	void postOrderOut(const BinaryTreeNode<Item>* node_ptr);
	
	template <class Item>
	void preOrderOut(const BinaryTreeNode<Item>* node_ptr);
	
	//-----------------------
	template <class Item>
    Item inOrderGetFirstKey(const BinaryTreeNode<Item>* node_ptr);
	
	template <class Item>
    Item preOrderGetFirstKey(const BinaryTreeNode<Item>* node_ptr);
	
	template <class Item>
    Item postOrderGetFirstKey(const BinaryTreeNode<Item>* node_ptr);

	//-----------------------
	//NON MEMBER FUNCTIONS:
	//-----------------------
	
	//non member function delaraion for insert
	template<class Item>
	void insertN(Item key, BinaryTreeNode<Item> *leaf);

    template <class Process, class BTNode>
    void inorder(Process f, BTNode* node_ptr); 

    template <class Process, class BTNode>
    void preorder(Process f, BTNode* node_ptr);

    template <class Process, class BTNode>
    void postorder(Process f, BTNode* node_ptr); 

    template <class Item, class SizeType>
    void print(BinaryTreeNode<Item>* node_ptr, SizeType depth);

    template <class Item>
    void treeClear(BinaryTreeNode<Item>*& root_ptr);

    template <class Item>
    BinaryTreeNode<Item>* tree_copy(const BinaryTreeNode<Item>* root_ptr);

    template <class Item>
    std::size_t treeSize(const BinaryTreeNode<Item>* node_ptr);

	template <class Item>
	void inOrderPrint(const BinaryTreeNode<Item>* node_ptr);
	
	template <class Item>
	void postOrderPrint(const BinaryTreeNode<Item>* node_ptr);
	
	template <class Item>
	void preOrderPrint(const BinaryTreeNode<Item>* node_ptr);
	
	template <class Item>
	void inOrderCreate(const BinaryTreeNode<Item>* node_ptr, BinaryTreeNode<Item>* inOrderArray);

//=================================================================================
#include <cassert>		// Provides assert
#include <cstdlib>		// Provides NULL, std::size_t
#include <iomanip>		// Provides std::setw
#include <iostream>		// Provides std::cout
#include <fstream.h>	//depricated library, but the only one that worked for me! Needed for ifstraem/ofstream.
#include <istream.h>	//depricated library, but the only one that worked for me! Needed for ios::app.


//==================================================
//non member function for recursive insert.
//==================================================
//Pre-> A pointer of type BinaryTreeNode<Item>* exists. 
//The pointer != NULL. The pointer MUST already be instatiated
//as a node object. 
//Post-> A new instantiation of type BinaryTreeNode<Item>
//is dynaically created on the heap memory. Using a 
//recursive function, the key data and new node will be 
//placed in the proper location of the tree according 
//to standard BST rules.
//NOTE:This function works alone or in tandem with 
//the member function 'insertNode'.
//==================================================
template<class Item>
void insertN(Item key, BinaryTreeNode<Item> *leaf)
{
	
  if(key < leaf->getData())
  {
    if(leaf->getLeft()!=NULL)
     insertN(key, leaf->getLeft());
    else
    {
      leaf->setLeft(new BinaryTreeNode<Item>(key));
      leaf->getLeft()->setLeft(NULL);    //Sets the left child of the child node to null
      leaf->getLeft()->setRight(NULL);   //Sets the right child of the child node to null
    }  
  }
  else if(key >= leaf->getData())
  {
    if(leaf->getRight() !=NULL)
      insertN(key, leaf->getRight());
    else
    {
      leaf->setRight(new BinaryTreeNode<Item>(key));
      leaf->getRight()->setLeft(NULL);  //Sets the left child of the child node to null
      leaf->getRight()->setRight(NULL); //Sets the right child of the child node to null
    }
  }
}
//-------------------------------------------

    template <class Process, class BTNode>
    void inorder(Process f, BTNode* node_ptr)
    // Library facilities used: cstdlib
    {
        if (node_ptr != NULL)
        {
            inorder(f, node_ptr->getLeft( ));
            f( node_ptr->getData( ) );
            inorder(f, node_ptr->getRight( ));
        }
    }

    template <class Process, class BTNode>
    void postorder(Process f, BTNode* node_ptr)
    // Library facilities used: cstdlib
    {
        if (node_ptr != NULL)
        {
            postorder(f, node_ptr->getLeft( ));
            postorder(f, node_ptr->getRight( ));
            f(node_ptr->getData( ));
        }
    }
	//----------------------------------------------------------------
	//gets the first Key of a list using the inOrder traversal method.
	template <class Item>
    Item inOrderGetFirstKey(const BinaryTreeNode<Item>* node_ptr)
    // Library facilities used: cstdlib
	
	{
		if( node_ptr == NULL )
			return NULL;
		if( node_ptr->getLeft() == NULL )
			return node_ptr->getData();
			
		return inOrderGetFirstKey( node_ptr->getLeft());
	}
	
	//gets the first Key of a list using the postOrder traversal method.
	template <class Item>
    Item postOrderGetFirstKey(const BinaryTreeNode<Item>* node_ptr)
    // Library facilities used: cstdlib
    {
        Item temp;
		if (node_ptr != NULL)
        {
             temp = node_ptr->getLeft()->getData();
        }
		
		return temp;
    }
	
	//gets the first Key of a list using the preOrder traversal method.
	template <class Item>
    Item preOrderGetFirstKey(const BinaryTreeNode<Item>* node_ptr)
    // Library facilities used: cstdlib
    {
        Item temp;
		if (node_ptr != NULL)
        {
            temp =  node_ptr->getData();
        }
		return temp;
    }
	//----------------------------------------------------------------
    template <class Process, class BTNode>
    void preorder(Process f, BTNode* node_ptr)
    // Library facilities used: cstdlib
    {
        if (node_ptr != NULL)
        {
            f( node_ptr->getData( ) );
            preorder(f, node_ptr->getLeft( ));
            preorder(f, node_ptr->getRight( ));
        }
    }

    template <class Item, class SizeType>
    void print(BinaryTreeNode<Item>* node_ptr, SizeType depth)
    // Library facilities used: iomanip, iostream, stdlib
    {
        if (node_ptr != NULL)
        {
            print(node_ptr->getRight( ), depth+1);
            std::cout << std::setw(4*depth) << ""; // Indent 4*depth spaces.
            std::cout << node_ptr->getData( ) << std::endl;
            print(node_ptr->getLeft( ),  depth+1);
        }
    }    
	
    template <class Item>
    void treeClear(BinaryTreeNode<Item>*& root_ptr)
    // Library facilities used: cstdlib
    {
	BinaryTreeNode<Item>* child;
	if (root_ptr != NULL)
	{
	    child = root_ptr->getLeft( );
	    treeClear( child );
	    child = root_ptr->getRight( );
	    treeClear( child );
	    delete root_ptr;
	    root_ptr = NULL;
	}
    }

    template <class Item>
    BinaryTreeNode<Item>* tree_copy(const BinaryTreeNode<Item>* root_ptr)
    // Library facilities used: cstdlib
    {
	BinaryTreeNode<Item> *l_ptr;
	BinaryTreeNode<Item> *r_ptr;

	if (root_ptr == NULL)
	    return NULL;
	else
	{
	    l_ptr = tree_copy( root_ptr->getLeft( ) );
	    r_ptr = tree_copy( root_ptr->getRight( ) );
	    return
		new BinaryTreeNode<Item>( root_ptr->getData( ), l_ptr, r_ptr);
	}
    }

    template <class Item>
    size_t treeSize(const BinaryTreeNode<Item>* node_ptr)
    // Library facilities used: cstdlib
    {
        if (node_ptr == NULL)
            return 0;
        else 
            return 
	    1 + treeSize(node_ptr->getLeft( )) + treeSize(node_ptr->getRight( ));
    }    

//===================================================================
//In-order, Post-Order & Pre-Order traversal print functions****
//Library used: cstdlib, iostream
//===================================================================
	
	//inOrder-> prints a tree using inOrder Traversal.
	//process left nodes, process root, process right nodes
	template <class Item>
	void inOrderPrint(const BinaryTreeNode<Item>* node_ptr)
	{
		if(node_ptr != NULL){
			inOrderPrint(node_ptr->getLeft());
			std::cout << node_ptr->getData() << std::endl;
			inOrderPrint(node_ptr->getRight());
		}
	}
	
	//preOrder->  prints a tree using preOrder Traversal.
	//process root, process left nodes, process right nodes
	template <class Item>
	void preOrderPrint(const BinaryTreeNode<Item>* node_ptr)
	{
		if(node_ptr != NULL){
			std::cout << node_ptr->getData() << std::endl;
			preOrderPrint(node_ptr->getLeft());
			preOrderPrint(node_ptr->getRight());
		}
	}
	
	//postOrder-> prints a tree using postOrder Traversal.
	//process left nodes, process right nodes, process root.
	template <class Item>
	void postOrderPrint(const BinaryTreeNode<Item>* node_ptr)
	{
		if(node_ptr != NULL){
			postOrderPrint(node_ptr->getLeft());
			postOrderPrint(node_ptr->getRight());
			std::cout << node_ptr->getData() << std::endl;
		}
	}
//===================================================================	
//TRAVERSAL FILE OUT FUNCTIONS -----------------------	
//===================================================================
	template <class Item>
	void inOrderOut(const BinaryTreeNode<Item>* node_ptr)
	{
		ofstream inOrderData;
		if(node_ptr != NULL)
		{
			inOrderOut(node_ptr->getLeft());
			inOrderData.open("inOrder.txt", ios::app);	//write the output to a file named inOrder.txt
			inOrderData << (node_ptr->getData()) << std::endl;
			inOrderOut(node_ptr->getRight());
			inOrderData.close();
		}
		
	}
	
	template <class Item>
	void preOrderOut(const BinaryTreeNode<Item>* node_ptr)
	{
		ofstream preOrderData;
		if(node_ptr != NULL)
		{
			preOrderData.open("preOrder.txt", ios::app);
			preOrderData << node_ptr->getData() << std::endl;
			preOrderOut(node_ptr->getLeft());
			preOrderOut(node_ptr->getRight());
			preOrderData.close();
		}
	}
	
	template <class Item>
	void postOrderOut(const BinaryTreeNode<Item>* node_ptr)
	{
		ofstream postOrderData;
		if(node_ptr != NULL)
		{
			postOrderOut(node_ptr->getLeft());
			postOrderOut(node_ptr->getRight());
			postOrderData.open("postOrder.txt", ios::app);
			postOrderData << node_ptr->getData() << std::endl;
			postOrderData.close();
		}
	}
//======================================	
//END TRAVERSAL FILE OUT FUNCTIONS 
//======================================

	
//==========================================================================
//***	MEMBER FUNCTION IMPLEMENTATIONS:
// IMPLEMENTS: The BinaryTreeNode class (see BinTree.h for documentation). 
//==========================================================================
template <class Item>
void BinaryTreeNode<Item>::shiftLeft()
{
   cursor = cursor->leftField;
}

template <class Item>
void BinaryTreeNode<Item>::shiftRight()
{
   cursor = cursor->rightField;
}

template <class Item>
void BinaryTreeNode<Item>::gotoRoot()
{
   cursor = cursor->rootPtr;
}

template <class Item>
Item BinaryTreeNode<Item>::peek_left() const
{
   assert(cursor->leftField != NULL);
   return cursor->leftField->dataField;
}

template <class Item>
Item BinaryTreeNode<Item>::peek_right() const
{
   assert(cursor->rightField != NULL);
   return cursor->rightField->dataField;
}

//==================================================
//Member function for inserting into any tree pointer
//==================================================
//Pre-> A pointer of BinaryTreeNode<Item>* exists. 
//The pointer can be == NULL or != NULL.  
//Post-> This function will instaniate the first root 
//node if the root == NULL and then inserts the key data. 
//If root != NULL, the tree will be traversed using a
//recursive function which inserts the key data into a
//new node in the tree. The key data and new node will 
//be placed in the proper location according to standard BST rules.

template <class Item>
void BinaryTreeNode<Item>::insertNode(Item key, BinaryTreeNode<Item>*&rootP)
{
	if(rootP!=NULL)
	insertN(key, rootP);
	else
	{
		rootP = new BinaryTreeNode<Item>(key);
		rootP->setData(key);
		rootP->setLeft(NULL);
		rootP->setRight(NULL);
	}
}


#endif
