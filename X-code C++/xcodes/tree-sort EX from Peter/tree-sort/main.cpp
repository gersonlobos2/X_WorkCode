/*
Peter Nebauer
Data Structures Fall 2010
Prof Branca
Binary Tree demo program using random numbers from external files.

COMPILED USING XCODE v2.5
----------------------------
----------------------------

Assignment Instructions:

BINARY TREES
SORTING AND SEARCHING

Objective: Sort and search arrays and binary trees.

ASSIGNMENT REQUIREMENTS
Use the program and data file from previous program and do
the following:
• Add the merge sort function to the toolkit.
• Add the binary search function to the toolkit
• Copy the data from a binary tree to a dynamic array.
• Sort the dynamic array using the merge sort function.
• Ask the user for a number.
• Use the binary search function to search for the user
  number and display a result of the search.
• Copy the sorted dynamic array back into the tree using
  one of the tree traversal functions (pre-order, in-order,
  post-order).
• Display the data in the tree using the same tree traversal 
  function.
*/

/*
KEY NOTES ON THIS VERSION:
1.	The recursive insert function has been improved from the last tree assignment.
	Now you can feed a NULL BinaryTreeNode<Item>* pointer into the 'insertNode' function
	and it instantiates the first node if it doesn't already exist.
2.	The dynamic arrays are always deleted after using.  This was something I forgot
	to do in the last assignment, and I submitted the assignment before realized 
	this potential bug.
3.	Merge Sort function was added to the toolkit.  It is located here in the main.cpp file.
4.	Binary Search function was added to the toolkit. It is also located here in the
	main.cpp file.
*/

#include <iostream>
#include "BinTree.h"
#include <fstream>
#include <ctime>

using namespace std;

//FUNCTION PROTOTYPES
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

void search(const int a[ ], size_t first, size_t size, 
			int target, bool& found, size_t& location);
// Precondition: The array segment starting at a[first] and containing size
// elements is sorted from smallest to largest.
// Postcondition: The array segment starting at a[first] and containing size
// elements has been searched for the target. If the target was present, then
// found is true, and location is set so that target == a[location]; 
// Otherwise, found is set to false.
// Library facilities used: stdlib.h (provides size_t).

void traversalFileReset();
void genRandNums(int min, int max);
int getListSize();
void resetAll();
int insertNum();

//Global variables:
int many = 1000;		//how many numbers to produce

int main () {
	
	//BEGIN RANDOM-NUMBER FILE-IO SECTION
	srand(time(0));
	int mini = 0;			//min number in random range
	int maxi = 5001;		//max number in random range + 1
	char choice;

	do{
		cout << "\n*****  WELCOME TO THE NEW AND IMPROVED BINTREE PROGRAM!   *****\n";
		cout << "*****  THIS PROGRAM DEMONSTRATES THE USE OF BINARY-TREES  *****\n";
		cout << "*****  AND MERGE-SORTS AND BINARY-SEARCHES.                *****\n";
		cout << "\n\nWould you like me to generate a brand new file of " << many << " random numbers?\n";
		cout << "The current file has " << getListSize() << " random numbers.\n";	//gets the length of the list being read-in.
		cout << "\n-->Please choose: (Y or N): ";
		cin >> choice;
	}
	while(choice != 'y' && choice != 'Y' && choice != 'n' && choice != 'N');
	if(choice == 'y' || choice =='Y')	{
			   resetAll();
		cout << "\n*** Generating " << many << " random numbers to file. Please wait a moment...\n";
		for(int i = 0; i< many; ++i)	{
			genRandNums(mini, maxi);	
		}
		cout << "DONE. A new file of " << getListSize() << " random numbers has been written.\n";
	}
		if(choice == 'n' || choice =='N')	{
			if(getListSize() < many)	{
				cout << "The list does not contain the required " << many << " numbers. I will generate a new list.\n";
				resetAll();
				cout << "\n*** Generating " << many << " random numbers to file. Please wait a moment...\n";
				for(int i = 0; i< many; ++i)	{
					genRandNums(mini, maxi);	
				}
				cout << "\nDONE. A new file of " << getListSize() << " random numbers has been written.\n";
			}
		}	
		cout << "\nNow I will import " << many << " numbers from the random-number file into a dynamic array.\n";
		cout << "Next I will display the dynamic array data on screen in rows of 20.\n";
		
		cout << "\n*** Please hit ENTER once or twice to continue.\n";
		cin.ignore();
		cin.get();

	//---------------------------------------------------------------
	//BEGIN TREE PROGRAM
	//---------------------------------------------------------------
		BinaryTreeNode<int>* rootP= NULL;			//root pointer for the tree of imported random numbers.
		
		int * numArrPtr = new int[many];			//dynamic array to hold random numbers from file.
		ifstream randData("randNums.txt");			//read in random number file.
		
		//This 'for' loop performs 3 functionalities.
		//1. Reads in the random numbers from external file into a dynamic array.
		//2. Displays the nubers from the array on screen, in rows of 20.
		//3. Uses a recursive function to keep adding new nodes to the tree, from the array data.
		for(int i = 1; i<= many; ++i)	{			
			int tempNum = 0;
			randData >> tempNum;					//read in a number from the external file.			
			rootP->insertNode(tempNum, rootP);		//use the recursive insert function.		
			numArrPtr[i-1] = tempNum;				//read each number into tempNum.		
			if(i == 1)
			{										//insert a line return after every 20 numbers.
				cout << "Row: 1 \t";
			}							
			cout << numArrPtr[i-1] << " ";				//display tempNum.			
			if(i % 20 == 0 && i != 1 && i != many)		//insert a line return after every 20 numbers.
			{
				cout << "\n" << "Row: " << (i/20)+1 << " \t";
			}
		}
		randData.close();		//close random file after reading.
		delete [] numArrPtr;	//release the temp dynamic array memory.
	
		cout << "\nPlease hit ENTER once or twice to continue.\n";
		cin.get();
		
		cout << endl <<"MY TREE SIZE: " << treeSize(rootP) << endl;
		
		cout << "\nPlease hit ENTER once or twice to continue.\n";
		cin.get();
		//------------
	
		cout << "\nNext, I will use the tree-PRINT function "
			 << "to display the contents of the tree in a \n"
			 << "tree-like visual format.\n\n";
		
		cout << "\nPlease hit ENTER once or twice to continue.\n";
		cin.get();
	
		print(rootP, 0);
	
		cout << "\nPlease hit ENTER once or twice to continue.\n";
		cin.get();
	
		cout << "\n\nNow I will copy the tree back into a new dynamic "
			 << "array so it can be sorted.\n";
		cout << "I will use the POST-ORDER traversal method to copy the "
			 << "tree into the dynamic array.\n\n";
	
		cout << "\nPlease hit ENTER once or twice to continue.\n";
		cin.get();
	
		int * postArrPtr = new int[many];	//new dynamic array.
		postOrderOut(rootP);				//save the postOrder traversal to a text file.
		ifstream inData("postOrder.txt");	//open file. Read in numbers from this file.
		for(int i = 1; i<= many; ++i)	{			
				int tempNum = 0;
				inData >> tempNum;
				postArrPtr[i-1] = tempNum;	//read each number into tempNum.
				if(i == 1)
				{					
					cout << "Row: 1 \t";
				}				
				cout << postArrPtr[i-1] << " ";				//display tempNum.			
				if(i % 20 == 0 && i != 1 && i != many)		//line return after every 20 numbers.
				{
					cout << "\n" << "Row: " << (i/20)+1 << " \t";
				}
		}
	
		inData.close(); //close file after reading.
	
		cout << "\n\nNow I will sort the dynamic array.\n";
		cout << "I will use a MERGE SORT to sort the data.\n";
	
		cout << "\nPlease hit ENTER once or twice to continue.\n";
		cin.get();
	
		//******	example of a merge sort.	******
		mergesort(postArrPtr, many);

		cout << "\nDONE. Array is sorted!\n";
		cout << "Next I will display the sorted dynamic array data on screen in rows of 20.\n";
		
		cout << "\nPlease hit ENTER once or twice to continue.\n";
		cin.get();

		for(int i = 1; i<= many; ++i)	{			
				if(i == 1)
				{							
					cout << "Row: 1 \t";
				}				
				cout << postArrPtr[i-1] << " ";			//display tempNum.			
				if(i % 20 == 0 && i != 1 && i != many)	//line return after every 20 numbers.
				{
					cout << "\n" << "Row: " << (i/20)+1 << " \t";
				}
		}
	
		cout << "\n\nNow I will demonstrate a binary search.";
		//============================================================
		//***	BINARY SEARCH REQUIRED-VARIABLES
		//============================================================
		int searchNum = 0;		//target search item
		bool isFound;			//bool for if match is found
		size_t foundLocation;	//array index where target is located
		//============================================================

		do{
			cout << "\n\nPlease enter a number to search for in the array: ";
			cin >> searchNum;
			cout << "Thank you. I will now search for the number " << searchNum << ".\n\n";
			
			cout << "Please hit ENTER once or twice to continue.\n";
			cin.ignore();
			cin.get();
	
			// *** This is an example the Binary search function ***
			search(postArrPtr, 0, many, searchNum, isFound ,foundLocation);

			//display the results of binary search.
			if(isFound == true)
			{
				cout << "The number you searched for was " << searchNum << ".\n";
				cout << "A MATCH WAS FOUND!! " << postArrPtr[foundLocation] 
					 << " is located at array index " << foundLocation << ".\n\n";
			}
			else{
				cout << "\nSORRY!! Number " << searchNum << " is not in the array!\n";
			}
			cout << "\nWould you like to search again? (Y or N) : ";
			cin >> choice;
		}//end do/while
		while(choice == 'y' || choice == 'Y');

		cout << "\nOKAY!\n";
		cout << "\nNow I will copy the array back into the tree, " 
			<< "this time using the PRE-ORDER traversal method.\n\n";
		 
		cout << "Please hit ENTER once or twice to continue.\n";
		cin.ignore();
		cin.get();
	
		treeClear(rootP);	//clear tree before re-populating
		cout << "\nTest: The old tree has been cleared before re-populating.\n";
		cout << "Tree size is now: " << treeSize(rootP) << "\n\n";
	
		int *preArrPtr = postArrPtr;		//rename array to reflect new use.
		postArrPtr = NULL;					//reset old pointer to NULL
		
		preOrderPrint(rootP);			
		ifstream preData("preOrder.txt");	//open file. Read in numbers from this file.
		for(int i = 1; i<= many; ++i)	{			
				int tempNum = 0;
				preData >> tempNum;
				preArrPtr[i-1] = tempNum;			//read each number into tempNum.
				rootP->insertNode(tempNum, rootP);	//use the recursive insert function
				if(i == 1)
				{							
					cout << "Row: 1 \t";
				}				
				cout << preArrPtr[i-1] << " ";				//display tempNum.			
				if(i % 20 == 0 && i != 1 && i != many)		//line return after every 20 numbers.
				{
					cout << "\n" << "Row: " << (i/20)+1 << " \t";
				}
		}
	
		preData.close(); //close file after reading.
		cout << "\n\nTree size is now: " << treeSize(rootP) << "\n";
	
		cout << "Please hit ENTER once or twice to continue.\n";
		cin.get();
	
		cout << "\nNow I will use the PRE-ORDER PRINT function "
			 << "to display the contents of the tree.\n";
		cout << "Please hit ENTER once or twice to continue.\n";
		cin.get();
	
		preOrderPrint(rootP);
	
		cout << "\nFinally, I will use the tree-PRINT function "
			 << "to display the contents of the new tree in a \n"
			 << "tree-like visual format.\n\n";
	
		cout << "Please hit ENTER once or twice to continue.\n";
		cin.get();
	
		print(rootP, 0);
		
		cout << "\nPlease hit ENTER once or twice to continue.\n";
		cin.get();
	
		delete [] preArrPtr;	//free up dynamic memory from the heap.	
		cout << "***********	END OF TREE DEMO PROGRAM!	*****************\n\n";	
		
		return EXIT_SUCCESS;
}

//FUNCTION PROTOTYPES
//generate a random number to a file
//Pre-> int values for min and max values exist.
//If a file of numbers already exists, it will read in those numbers, and then append the file with
//a newly generated random number.
//Post-> A file for keeping count of the random number list is updated, and a new random number
//is added to the random number file.
void genRandNums(int min, int max)
{	
	ofstream dataOut, countOut;	
	ifstream countIn;
	
	int count = getListSize();					//read in current list size
	dataOut.open("randNums.txt", ios::app);		//appends/creates the file.
	countOut.open("listSize.txt");				//overwrites/creates the file
	int result = 0;
	
	//use formula for range: result = min + rand() % (max - min).
	result =  min + rand() % (max - min);
	dataOut << result << "\n";
	count ++;
	
	countOut << count;		//write the updated count to listSize
	
	dataOut.close();		//close the file after writing!
	countOut.close();
	}
	
//pre -> a counter-file 'listSize.txt' contains the count of items in the list-file 'randNums.txt'.
//post -> the number of items in the file 'randNums.txt' are returned.
int getListSize()
{
	ifstream inData;
	inData.open("listSize.txt");
	
	int lSize = 0;
	inData >> lSize;
	inData.close();
	return lSize;
}

//Pre->txt files listSize.txt and randNums.txt exist in program root folder.
//Post-> The files are reset to zero items.
void resetAll()
{
	ofstream countReset;
	ofstream listReset;
	
	countReset.open("listSize.txt");	//overwrites, does not append
	listReset.open("randNums.txt");		//overwrites, does not append
	
	int lr = 0;
	listReset << lr;
	
	int cr = NULL;
	countReset << cr;
	
	listReset.close();
	countReset.close();
	
}
//Pre-> The files "preOrder.txt" and "postOrder.txt" are used for storing exported
//data from a tree using the postOrderOut and preOrderOut functions located in the 
//BinTree.h file.
//Post-> The files are cleared of all data.
void traversalFileReset()
{
	ofstream preOrder, postOrder; //omit inOrder in this version of program.
//	inOrder.open("inOrder.txt");
	preOrder.open("preOrder.txt");
	postOrder.open("postOrder.txt");
//	inOrder << "";
	preOrder << "";
	postOrder << "";
//	inOrder.close();
	preOrder.close();
	postOrder.close();
}


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


// Precondition: The array segment starting at a[first] and containing size
// elements is sorted from smallest to largest.
// Postcondition: The array segment starting at a[first] and containing size
// elements has been searched for the target. If the target was present, then
// found is true, and location is set so that target == a[location]; 
// Otherwise, found is set to false.
// Library facilities used: stdlib.h (provides size_t).
void search(const int a[ ],size_t first,size_t size,
int target,bool& found,size_t& location)

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

