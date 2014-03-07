
//  ****************************************************************************
//  Name: Gerson Lobos
//  Name: Professor Branca 
//  Date:
//  COMSC 110 Computer Programming II
//  Assignment #: 2
//  File Name: main.cpp
//  Compiler Used: Xcode
//  ****************************************************************************

// Problem Statement ********************************************************** 
/* 
 1.	Design a class named Die. The class should only be used to create and manipulate 1 die.
 The properties of the die should include its number of sides, current face value 
 (after rolling) and a color.
 
 2.	In addition to the standard constructor, mutator and accessor functions for the 
 Die class, you should have the following:
 
 a.	Member function to simulate the rolling of one die using random # generation. 
 b.	Overloaded << operator that outputs current face value of one die. 
 c.	Overloaded + operator to add the values of all dice after rolling them. 
 d.	Non-member function(s) to generate random numbers for a collection (size of
 collection can vary) of dice to simulate dice rolling.
 Non-member functions that are not specifically related to dice should be stored
 in separate header and implementation files than the Die class.
 
 3.	Create the necessary header files, implementation files and program files. 
 See templates for format.
 
 4.	Write a program which simulates the creation of 6 dice and stores them in a 
 dynamic array or a vector. Ask the user how many sides and what color all 6 dice have. 
 Roll the dice and output the current values of the dice and the sum of the values 
 on all the dice. The number of sides on each die should come from the user, 
 and be no less than 6 or more than 10. The values on each side of the dice should fall
 in the range of the number of sides (e.g., if there are 6 sides than the face values 
 should be in the range of 1-6). The color choices are limited to red, yellow and blue.
 
 
 PART II
 1.	Use the Die class from the Review Lab assignment. 
 2.	Design a class named DiceCollection which contains a dynamic array of Die objects.
 2.1. The class should have constructor, assessor and mutator methods. Include a display
 method which displays the data for all the dice in the dynamic array.
 2.2. Include member methods to increase and decrease the size of the dynamic array by adding 
 or removing Die objects.
 3.	Write a program which uses DiceCollection objects. Demonstrate use of all the member
 methods of the class.
 
 
 
 // Data Requirements ********************************************************** 
 
 Input		dsides				int			users input to the sides of the dice
 dcolor				string		users input to the color of the dice
 rolls				int			users input to the amount of times the dice was rolled
 total				int			the sum of all the dices' roll results.
 faceValue			int			random number generated from the times the user wants 
 to roll the dice.
 
 
 
 
 Processing
 
 Formulas    1+rand()%(max-min+1)
 
 Libreries	ctime	vector	iostream	fstream	cstdlib	string
 
 // Algorithm Design *********************************************************** 
 Function
 
1.ask for a color for the dice
2. ask for a number of sides for the die
 3.ask for a new color and sides for the new bag
 4. add more dice to the bag.
 5. remove one die form the bag.
 
 // Testing Specifications ***************************************************** 
 
 test the string for the color of the dice
 test for the size of the die
 test for the times you roll the dice
 
 
 // Compiler directives : libraries and namespaces *****************************
 */
#include <iostream>
#include <string>
#include "Die.h"
#include "DiceCollection.h"

#include <ctime>
#include <cstdlib>
//#include <vector>
#include <fstream>

using namespace std;
using namespace dieclass;
using namespace CollectionClass;

int main()
{
	srand(time(0));
	int dsides;
	//int dfaceValue=1+rand()%(dsides-1+1);
	string dcolor;
	
	int selc; // this is going to be used to chose the color between red, blue,yellow
	
	Die dedo;
	
	dedo.programDescription();
	do
	{
		cout << "what color do you want the Dices to be:"<<endl;
		cout << "1. red" <<endl;
		cout << "2. blue" <<endl;
		cout << "3. yellow"<<endl ;
		cout << "Enter the number of color you want:"<<endl;
		cin >> selc;
		
		switch (selc) {
			case 1: {
				dcolor="red";
				break;
			}
			case 2: {
				dcolor="blue";
				break;
			}
			case 3: {
				dcolor="yellow";
				break;
			}
			default:{
				selc= -1;
				//cout<<"*******Invalid selection, please try again.*******"<<endl;
				break;
			}
		}
	}while(selc == -1);
	
	
	//puting the number of sides in the dies 
	while (6>dsides||dsides>10) {
		cout <<"how many sides do you want in the dice between 6-10: "<<endl;
		cin >>dsides;
	}
	
	Die dado(dsides,dcolor);

	cout << "your collection starts with this dice: "<<endl;
	DiceCollection bag(dado);
	bag.displayCollection();
	
	cout << "adding more to the collection$$$$$$$$$$$$$"<<endl;
	int addMoreDice;
	string newColor;
	int newDsides;
	cout << "enter new color for the dice"<<endl;
	cin>>newColor;
	cout << "enter a new number of sides for the dice: "<<endl;
	cin>>newDsides;
	cout << "enter the number of dice from this type you want to add:"<<endl;
	cin>>addMoreDice;
	
	Die dado2(newDsides,newColor);
	
	//cout << "how many more dice would you like to add: "<<endl;
	//cin>> addMoreDice;
	bag.CollectDice( dado2, addMoreDice);
	bag.displayCollection();
	
	cout << "Removing one from collection:  "<<endl;
	
	bag.RemoveFromCollection();  //this will remove the first one from the bag 
	//cout << "good until now: "<<endl;
	bag.displayCollection();
	//creation another bag of dice************************************************** extra credit
	Die dado3(10," red ");
	DiceCollection bag2(dado3);
	bag2.CollectDice(dado3,3);
	
	bag.merge2Collections(bag2);//passing the bag # 2 to make bag 1 bigger.
	
	
	cout << "please press enter one or twitce to continue...";
	
	cin.ignore().get();
	return EXIT_SUCCESS;
}
