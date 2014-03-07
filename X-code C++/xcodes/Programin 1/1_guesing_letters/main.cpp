#include<iostream>
#include<string>
#include <ctime>


using namespace std;
string check(string, char[]);

int main()
{
    srand(time(0));
    char letters[]={"RGPYBW"};
    string Guess;
    char GuessLetters[4];
    
	cout << "enter for letters to guess they can be R, G, Y, B, W you have only 12 tryes."<<endl;
	cout<<" it has to be done with capital letters: "<<endl;
	
    for(int i=0;i<4;++i)
    {
		GuessLetters[i]=  letters[rand()%(5)] ;    
		//cout<<"letters to guess: "<<GuessLetters[i]<<endl; //just if you wanna see the letters at the begining.(to test)
    }
    
	string testRight;
	
    for(int i=0; i<12;++i)
    {
		cout<<" enter the letters: "<<endl;
		cin>>Guess;
		cout<<endl;
		testRight=check(Guess, GuessLetters);
		
		cout<<"Guess "<<i+1<<": "<<Guess<<" :"<<testRight<<endl;
		
		if (testRight=="BBBB") {
			cout << "you won"<<endl;
			break;
		}
		else {
			cout<<"wrong try again "<<endl;
		}

		
    }
	
    for(int i=0;i<4;++i)
    {
		cout<<"letters to guess were: "<<GuessLetters[i]<<endl;
    }
    
    
	system ("pause");
	return 0 ;  
}
string check(string Guess, char Letters[])
{
	string BorW;
	
	for(int i=0; i<4;++i)
	{
		if(Guess[i]==Letters[i])
			BorW +="B";
		
		else if(Guess[i]!=Letters[i])
			BorW +="W";
	}
	
	return BorW;
}
