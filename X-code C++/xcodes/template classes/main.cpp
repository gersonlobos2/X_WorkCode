#include <iostream>
#include <cstdlib>
#include <string>
#include "bag4.h"
using namespace std;
using namespace GELA;

const int ITEMS_PER_BAG=4;
const int MANY_SENTENCES=3;

template <class Item, class SizeTipe, class MessageType>
void get_items(bag<Item>& collection, SizeTipe n, MessageType description)
{
	Item user_input;
	SizeTipe i;
	
	cout << "please type "<<n<<" "<<description;
	cout << ", separated by spaces. \n";
	cout << "press the <return> key after the final entry: \n";
	
	for (i=1; i<=n; ++i) {
		cin>>user_input;
		collection.insert(user_input);
	}
	cout << endl;
}
int main () 
{
    bag<string> adjectives;
	bag<int> ages;
	bag<string> names;
	int line_number;
	
	cout << "help me write a story. \n";
	get_items(adjectives, ITEMS_PER_BAG, "adjectives that describe a mood ");
	get_items(ages,       ITEMS_PER_BAG, "integers in the teens");
	get_items(names,      ITEMS_PER_BAG, "fist names");
	cout << "thank you for your assistance. \n \n";
	
	cout << "Life \n";
	cout << "by Gerson ;-)\n";
	for (line_number=1; line_number<=MANY_SENTENCES; ++line_number) {
		cout << names.grab()      <<" was only "
			 << ages.grab()       <<" years old, but he/she was "
			 <<adjectives.grab()  <<".\n";
		cout << "Life is "<<adjectives.grab()<<".\n";
		cout << "the ("<<adjectives.grab()<<") end\n";
	}
	
	
    cin.ignore().get();
    return EXIT_SUCCESS;
}
