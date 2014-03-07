/*
 *  bintree.hh
 *  searching and sorting
 *
 *  Created by Gerson Lobos on 12/12/10.
 *  Copyright 2010 westchester comunity college. All rights reserved.
 *
 */

#include <cassert>    // Provides assert
#include <cstdlib>   // Provides NULL, std::size_t
#include <iomanip>    // Provides std::setw
#include <iostream>   // Provides std::cout
#include "fstream.h"

namespace GelaTree
{
    template <class Process, class BTNode>
    void inorder(Process f, BTNode* node_ptr)
    // Library facilities used: cstdlib
    {
        if (node_ptr != NULL)
        {
            inorder(f, node_ptr->left( ));
            f( node_ptr->data( ) );
            inorder(f, node_ptr->right( ));
        }
    }
	
    template <class Process, class BTNode>
    void postorder(Process f, BTNode* node_ptr)
    // Library facilities used: cstdlib
    {
        if (node_ptr != NULL)
        {
            postorder(f, node_ptr->left( ));
            postorder(f, node_ptr->right( ));
            f(node_ptr->data( ));
        }
    }
	
    template <class Process, class BTNode>
    void preorder(Process f, BTNode* node_ptr)
    // Library facilities used: cstdlib
    {
        if (node_ptr != NULL)
        {
            f( node_ptr->data( ) );
            preorder(f, node_ptr->left( ));
            preorder(f, node_ptr->right( ));
        }
    }
	
    template <class Item, class SizeType>
    void print(binary_tree_node<Item>* node_ptr, SizeType depth)
    // Library facilities used: iomanip, iostream, stdlib
    {
        if (node_ptr != NULL)
        {
            print(node_ptr->right( ), depth+1);
            std::cout << std::setw(4*depth) << ""; // Indent 4*depth spaces.
            std::cout << node_ptr->data( ) << std::endl;
            print(node_ptr->left( ),  depth+1);
        }
    }    
	
    template <class Item>
    void tree_clear(binary_tree_node<Item>*& root_ptr)
    // Library facilities used: cstdlib
    {
		binary_tree_node<Item>* child;
		if (root_ptr != NULL)
		{
			child = root_ptr->left( );
			tree_clear( child );
			child = root_ptr->right( );
			tree_clear( child );
			delete root_ptr;
			root_ptr = NULL;
		}
    }
	
    template <class Item>
    binary_tree_node<Item>* tree_copy(const binary_tree_node<Item>* root_ptr)
    // Library facilities used: cstdlib
    {
		binary_tree_node<Item> *l_ptr;
		binary_tree_node<Item> *r_ptr;
		
		if (root_ptr == NULL)
			return NULL;
		else
		{
			l_ptr = tree_copy( root_ptr->left( ) );
			r_ptr = tree_copy( root_ptr->right( ) );
			return
			new binary_tree_node<Item>( root_ptr->data( ), l_ptr, r_ptr);
		}
    }
	
    template <class Item>
    size_t tree_size(const binary_tree_node<Item>* node_ptr)
    // Library facilities used: cstdlib
    {
        if (node_ptr == NULL)
            return 0;
        else 
            return 
			1 + tree_size(node_ptr->left( )) + tree_size(node_ptr->right( ));
    }    
	
	// i was creting this.**************************
	/*	template <class Item >
	 void treeinsert(Item key,  binary_tree_node<Item>* leaf)
	 {
	 if(key < leaf->data())
	 {
	 if(leaf->left()!=NULL)
	 insert(key, leaf->left());
	 else
	 {
	 leaf->set_left(new  binary_tree_node<Item>(key));
	 leaf->left()->set_left(NULL);    //Sets the left child of the child node to null
	 leaf->left()->set_right(NULL);   //Sets the right child of the child node to null
	 }  
	 }
	 else if(key >= leaf->data())
	 {
	 if(leaf->right() !=NULL)
	 insert(key, leaf->right());
	 else
	 {
	 leaf->set_right(new  binary_tree_node<Item>(key));
	 leaf->right()->set_left(NULL);  //Sets the left child of the child node to null
	 leaf->right()->set_right(NULL); //Sets the right child of the child node to null
	 }
	 }
	 }*/
	
	//inOrder-> process left nodes, process root, process right nodes
	template <class Item>
	void inOrderPrint(const binary_tree_node<Item>* node_ptr)
	{
		if(node_ptr != NULL){
			inOrderPrint(node_ptr->left());
			std::cout << node_ptr->data() << std::endl;
			inOrderPrint(node_ptr->right());
		}
	}
	
	//preOrder-> process root, process left nodes, process right nodes
	template <class Item>
	void preOrderPrint(const binary_tree_node<Item>* node_ptr)
	{
		if(node_ptr != NULL){
			std::cout << node_ptr->data() << std::endl;
			preOrderPrint(node_ptr->left());
			preOrderPrint(node_ptr->right());
		}
	}
	
	//porstOrder-> process left nodes, process right nodes, process root.
	template <class Item>
	void postOrderPrint(const binary_tree_node<Item>* node_ptr)
	{
		if(node_ptr != NULL){
			preOrderPrint(node_ptr->left());
			preOrderPrint(node_ptr->right());
			std::cout << node_ptr->data() << std::endl;
		}
	}
	// my fuction to put pre order in a file.
	
	template <class Item>
	void preOrderOutFile(const binary_tree_node<Item>* node_ptr)
	{
		ofstream outFile;
		outFile.open( "preOrder.txt");
		
		if(node_ptr != NULL){
			outFile << node_ptr->data() << std::endl;
			preOrderPrint(node_ptr->left());
			preOrderPrint(node_ptr->right());
		}
		outFile.close();
	}
	
}

