/**************************************************************************
 // Professor Gerson Lobos
 // Data Structures
 // FILES:		main.cpp	//my work
 bintree.h	//book
 bintree.hh	//book
 
 //compler: Xcode
 //**************************************************************************
 // Problem Statement ********************************************************** 
 
 SORTING AND SEARCHING
 Objective: Sort and search arrays and binary trees.
 
 ASSIGNMENT REQUIREMENTS
 
 Use the program and data file from previous program and do the following:
 
 Add the merge sort function to the toolkit. 
 Add the binary search function to the toolkit
 Copy the data from a binary tree to a dynamic array.
 Sort the dynamic array using the merge sort function.
 Ask the user for a number.
 Use the binary search function to search for the user number and display a result of the search.
 Copy the sorted dynamic array back into the tree using one of the tree traversal functions (pre-order, in-order, post-order).
 Display the data in the tree using the same tree traversal function.
 //**************************************************************************
 Description:
 1-random number were put in a file
 2-the number from the file were read and put into a vector
 3-we took the numbers from the vector and put them in a tree.
 4-they were displayed in the 3 different types of orders
 -preorder
 -inorder
 -postorder
 5-the numbers were put in a dynamic array 
 6-the array and the vector was sorted
 // Data Requirements **********************************************************
 --------------------------------------------------------------------------------
 |  NAME of Variable	|	Type			    |	Description
 --------------------------------------------------------------------------------
 |	root				|binary_tree_node<int>* | the root of the tree
 |	hold				|	vector<int>		    |vector container
 |	OutToFile			|	ofstream 	        | it will take data to a file
 |  InFromFile			|   ifstream			| to read frin a file
 |  array               |   int *				| array
 |  hold				|   vector<int>			| vector
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
#include <ctime>
#include <fstream>
#include <vector>

using namespace std;
using namespace GelaTree;
//*********************  MY FUNCTIONS
void insert(int , binary_tree_node<int> *);
void BubbleSort(vector <int> &num);

//*********************  FUNCTIONS FROM BOOK
//binary search
void search(const int a[ ],size_t first,size_t size,int target,bool& found,size_t& location);
void mergesort(int data[ ], size_t n);
// Precondition: data is an array with at least n components.
// Postcondition: The elements of data have been rearranged so
// that data[0] <= data[1] <= ... <= data[n-1].
// NOTE: If there is insufficient dynamic memory, then new_handler is called.

void merge(int data[ ], size_t n1, size_t n2);
// Precondition: data is an array (or subarray) with at least n1+n2 elements. 
// The first n1 elements (from data[0] to data[n1-1]) are sorted from smallest 
// to largest, and the last n2 (from data[n1] to data[n1+n2-1]) are also 
// sorted from smallest to largest.
// Postcondition: The first n1+n2 elements of data have been
// rearranged to be sorted from smallest to largest.
// NOTE: If there is insufficient dynamic memory, then new_handler is called.


int main () {
	srand(time(0));
	//***************************************    binary trees
	
	typedef int ValueType;
	ValueType data;
	data=10;
	size_t arraySize=1000;
	int *array=NULL;    //to hold the numbers
	array = new int[arraySize];
	
	vector<int> hold;		//to hold the numbers
	
	
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
			
			array[counter]=nums;       //putting the stuff in the array
			counter++;
			hold.push_back(nums);      //puting the stuff in the vector
			
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
	
	
	BubbleSort(hold);				//function to sort the vector
	mergesort(array, arraySize);	//fuctions to sort the array
	
	cout << "this are the numbers sorted:"<<endl;
	cin.ignore().get();
	
	cout<<"    vector"<<" "<<" array "<<endl;
	for (int i=0; i<hold.size(); ++i) {
		cout <<"      "<< hold[i]<<" "<<array[i]<<endl;
	}
	
	// binary search
    int target;
    bool found;
    size_t location;
	
	
		cout << "enter a number and it to be searched in our data"<<endl;
		cin>>target;
		
		search(array, 0, arraySize, target, found, location);
		
		if (found)
			cout << target << " is at possition ["
			<< location << "] in my array." << endl;
		else
			cout << target << " is not in our data." << endl;
	
	
	
	cout << "printing the tree in pre order"<<endl;
	cin.ignore().get();
	
	binary_tree_node<int>* root2 = NULL;
	
	ifstream infrom;
	infrom.open("preOrder.txt");
	
	for (int i=0; i<1000; ++i) {
		infrom >> nums;
		if(i==0)
		{
			root2 = new  binary_tree_node<int>(nums);
		}
		if(i>0)
		{
			insert(nums,root2);
		}
	}
	
	print(root, 6);  //it will print in the way it was put in the file "pre-order".
	
	
	delete[] array;
	
	
    cin.ignore().get();
    return EXIT_SUCCESS;
}
//***************************************** creating the tree
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

//*********************************** sorting in the vector
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
			if (num[j+1] < num[j])      // ascending order simply changes to <
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

//***************************************************BINARY SEARCH
void search(const int a[ ],size_t first,size_t size,int target,bool& found,size_t& location)
// Precondition: The array segment starting at a[first] and containing size
// elements is sorted from smallest to largest.
// Postcondition: The array segment starting at a[first] and containing size
// elements has been searched for the target. If the target was present, then
// found is true, and location is set so that target == a[location]; 
// Otherwise, found is set to false.
// Library facilities used: stdlib.h (provides size_t).
{
    size_t middle;
	
    if (size == 0)
        found = false;
    else
    {
        middle = first + size/2;
        if (target == a[middle])
        {
            location = middle;
            found = true;
        }
        else if (target < a[middle])
            // The target is less than a[middle], so search before the middle
            search(a, first, size/2, target, found, location);
        else 
            // The target must be greater than a[middle], so search after the middle
            search(a, middle+1, (size-1)/2, target, found, location);
    } 
}
//*************************************************** MERGE

void mergesort(int data[ ], size_t n)
// Precondition: data is an array with at least n components.
// Postcondition: The elements of data have been rearranged so
// that data[0] <= data[1] <= ... <= data[n-1].
// NOTE: If there is insufficient dynamic memory, thenbad_alloc is thrown.
// Library facilities used: cstdlib
{
    size_t n1; // Size of the first subarray
    size_t n2; // Size of the second subarray
	
    if (n > 1)
    {
        // Compute sizes of the subarrays.
        n1 = n / 2;
        n2 = n - n1;
		
        mergesort(data, n1);         // Sort from data[0] through data[n1-1]
        mergesort((data + n1), n2);  // Sort from data[n1] to the end
		
        // Merge the two sorted halves.
        merge(data, n1, n2);
    }
}

void merge(int data[ ], size_t n1, size_t n2)
// Precondition: data is an array (or subarray) with at least n1 + n2 elements.
// The first n1 elements (from data[0] to data[n1 - 1]) are sorted from
// smallest to largest, and the last n2 (from data[n1] to data[n1 + n2 - 1])
// also are sorted from smallest to largest.
// Postcondition: The first n1 + n2 elements of data have been rearranged to be
// sorted from smallest to largest.
// NOTE: If there is insufficient dynamic memory, then bad_alloc is thrown.
// Library facilities used: cstdlib
{
    int *temp;          // Points to dynamic array to hold the sorted elements
    size_t copied  = 0; // Number of elements copied from data to temp
    size_t copied1 = 0; // Number copied from the first half of data
    size_t copied2 = 0; // Number copied from the second half of data
    size_t i;           // Array index to copy from temp back into data
	
    // Allocate memory for the temporary dynamic array.
    temp = new int[n1+n2];
	
    // Merge elements, copying from two halves of data to the temporary array.
    while ((copied1 < n1) && (copied2 < n2))
    {
        if (data[copied1] < (data + n1)[copied2])
            temp[copied++] = data[copied1++];        // Copy from first half
        else
            temp[copied++] = (data + n1)[copied2++]; // Copy from second half
    }
	
    // Copy any remaining entries in the left and right subarrays.
    while (copied1 < n1)
        temp[copied++] = data[copied1++];
    while (copied2 < n2)
        temp[copied++] = (data+n1)[copied2++];
	
    // Copy from temp back to the data array, and release temp's memory.
    for (i = 0; i < n1+n2; i++)
        data[i] = temp[i];
    delete [ ] temp; 
}


