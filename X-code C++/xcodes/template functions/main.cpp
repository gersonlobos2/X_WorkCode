#include <iostream>
#include <algorithm>
#include <string>
#include <cassert>
#include <cstdlib>

//using namespace std;
template <class Item>
void swap(Item& x,Item& y)
{
	Item temp=x;
	x=y;
	y=temp;
}
template<class Item,class SizeType>
std::size_t index_of_maximal(const Item data[],SizeType n)
{
	std::size_t answer;
	std::size_t i;
	
	assert(n>0);
	answer=0;
	
	for (i=1; i<n; ++i) {
		if (data[answer]<data[i]) {
			answer=i;
		}
	}
	return answer;
}

int main () {
	//swap template funciont*********
	int a=1;
	int b=2;
	std::cout <<"the value of a is: " <<a<<"\n";
	std::cout <<"the value of b is: " <<b<<"\n";
	
	swap(a, b);
	std::cout << "a= "<<a<<"\n";
	std::cout << "b= "<<b<<"\n";
	
	//max in an array ******************
	 int array[]={5,7,3,8,3,9};
	size_t length=6;
	

int max = (int)index_of_maximal(array,length);

std::cout<<"the max in the array is: "<<array[max]<<"\n";
	std::cout<<"yo yo";
	
	

	std:: cin.ignore().get();    		// hold console window open
	return EXIT_SUCCESS;
}
