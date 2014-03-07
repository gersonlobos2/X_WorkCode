/**************************************************************************
 // Professor Gerson Lobos
 // Data Structures
 // FILES:		main.cpp	//my work
				bintree.h	//book
				bintree.hh	//book
 
 //compler: Xcode
 //**************************************************************************
 // Problem Statement ********************************************************** 

 Objective:   Build binary trees from random data stored in a file using pre-order,
 in-order and post-order traversal methods.
 
 ASSIGNMENT REQUIREMENTS
 
 Data File:   Write a program which generates a file of 1000 randomly generated numbers
 in the range of 0 - 5000. The program should include a test which displays the data in 
 the file after it is created.
 
 Classes:   Use the Binary Tree Node class with the member and non-member functions 
 from your textbook.
 
 Binary Tree Program:   Using the data in the file you created, write a program which 
 will build 3 binary trees using the three traversal methods (pre-order, in-order and post-order)
 from your textbook. Display the data from each of the trees using the same traversal methods
 used to create them.
 
 //**************************************************************************
 Description:
 1-random number were put in a file
 2-the number from the file were read and put into a vector
 3-we took the numbers from the vector and put them in a tree.
 4-they were displayed in the 3 different types of orders
	-preorder
	-inorder
	-postorder
 // Data Requirements **********************************************************
 --------------------------------------------------------------------------------
 |  NAME of Variable	|	Type			    |	Description
 --------------------------------------------------------------------------------
 |	root				|binary_tree_node<int>* | the root of the tree
 |	hold				|	vector<int>		    |vector container
 |	OutToFile			|	ofstream 	        | it will take data to a file
 |  InFromFile			|   ifstream			| to read frin a file
 --------------------------------------------------------------------------------
 //**************************************************************************
 Processing
 
 Formulas    rand()%(DECKSIZE); used in implementation
 
 -------------------------------------------------------------
 |	Libreries	|			Place used						|
 -------------------------------------------------------------
 |	ctime		| used in implementations					|
 |	iostream	| used main									|
 |	fstream 	| used in headers and implementations		|
 |	string		| used in implementations					|
 |	cstdlib		| used in node.h node.cpp and in main		|
 |	iomanip		| used in implementations					|
 |   cassert	| used in node								|
 |	vector		| used in main								|
 -------------------------------------------------------------
 
 //**************************************************************************
 // PREPROCESSOR
 //************************************************************************* */
#include <iostream>
#include <cstdlib>
#include "bintree.h"
#include "bag6.h"
#include <ctime>
#include <fstream>
#include <vector>

using namespace std;
using namespace GelaTree;

void insert(int , binary_tree_node<int> *);


void BubbleSort(vector <int> &num);

int main () {
	srand(time(0));
	//***************************************    binary trees
	
	 typedef int ValueType;
	 ValueType data;
	 data=10;
	
	vector<int> hold;

	 
	 binary_tree_node<int>* root=NULL;  

	//***************************************    in and out streams
	
	ofstream OutToFile; // takes data to the txt file
	OutToFile.open("file.txt");
	
	for (int i=0; i<1000; ++i) {
		OutToFile<< 1000 + rand()%(5000-1000) <<"\n";
	}
	
	OutToFile.close();
	
	ifstream InFromFile;
	
	InFromFile.open( "file.txt");//opens the file to read from it.
	int nums;
	
	int counter=0;
	for (int i=0; i<1000/10; ++i)
	{
		for (int x=0; x<10; ++x) {
			InFromFile>>nums;
			
			//array[counter]=nums;       //putting the stuff in the array
			counter++;
			hold.push_back(nums);      //vector
			
			cout<< nums <<" ";
		}
		cout<<endl;
	}
	InFromFile.close();
		
	// inserting numbers to the tree
	
	for (int i=0; i<counter; ++i) {
		if(i==0)
		{
		root = new  binary_tree_node<int>(hold[0]);
		}
		if(i>0)
		{
			insert(hold[i],root);
		}
	}
	
	cin.ignore().get();
	
	int treeSize=tree_size(root);
	
	cout << endl;
	cout << endl;
	cout << endl;
	cout << endl;
	cout << "the size of the tree is: "<<treeSize<<endl;
	
	cout << "this is the in order print: "<<endl;
	cin.ignore().get();
	inOrderPrint(root);
	cout << endl;
	cout << endl;
	cout << endl;
	cout << endl;
	cout<<"this is the preorder print: "<<endl;
	cin.ignore().get();
	
	preOrderPrint(root);
	cout << "this is the post orderprint: "<<endl;
	cin.ignore().get();
	postOrderPrint(root);
	
	
	BubbleSort(hold);
	cout << "this are the numbers sorted:"<<endl;
	cin.ignore().get();
	for (int i=0; i<hold.size(); ++i) {
		cout << hold[i]<<endl;
	}
	
	
    cin.ignore().get();
    return EXIT_SUCCESS;
}
//************************************************************************
void insert(int data,  binary_tree_node<int> *leaf)
{
	if(data < leaf->data())
	{
		if(leaf->left()!=NULL)
			insert(data, leaf->left());
		else
		{
			leaf->set_left(new  binary_tree_node<int>(data));
			leaf->left()->set_left(NULL);    //Sets the left child of the child node to null
			leaf->left()->set_right(NULL);   //Sets the right child of the child node to null
		}  
	}
	else if(data >= leaf->data())
	{
		if(leaf->right() !=NULL)
			insert(data, leaf->right());
		else
		{
			leaf->set_right(new  binary_tree_node<int>(data));
			leaf->right()->set_left(NULL);  //Sets the left child of the child node to null
			leaf->right()->set_right(NULL); //Sets the right child of the child node to null
		}
	}
}


void BubbleSort(vector <int> &num)
{
	int i, j, flag = 1;    // set flag to 1 to start first pass
	int temp;             // holding variable
	int numLength = num.size(); 
	
	for(i = 1; (i <= numLength) && flag; i++)
	{
		flag = 0;
		for (j=0; j < (numLength -1); j++)
		{
			if (num[j+1] > num[j])      // ascending order simply changes to <
			{ 
				temp = num[j];             // swap elements
				num[j] = num[j+1];
				num[j+1] = temp;
				flag = 1;               // indicates that a swap occurred.
			}
		}
	}
	return ;  
}


