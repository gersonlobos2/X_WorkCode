#include <iostream>
using namespace std;
string backword(string word,string newWord);
int main ()
{
	string word="";
	string newWord="";
	cout << "enter the word you want to reverse: "<<endl;
	cin>>word;
	newWord =backword(word,newWord);
    cout << "the backword word is:"<<newWord;
	
	
	cin.ignore().get();
    return EXIT_SUCCESS;
}
string backword(string word,string newWord)
{
	if (word.length()==0) 
	{
		return newWord;
	}
	else {
		newWord += word.at(word.length()-1);//at possition - 1
		word.erase(word.length()-1);
		newWord = backword(word,newWord);
	}

	return newWord;
}