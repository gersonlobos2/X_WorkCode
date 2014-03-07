#include <iostream>
#include <cctype> //Provides is digit
#include <cstdlib>//provides EXIT_SUCCESS
#include <cstring>//provides strchr
#include <stack> //provides the stack member class

using namespace std;
double read_and_evaluate(istream& ins);
void evaluate_stack_tops(stack<double>& numbers, stack<char>& operations);

int main () {
  
	double answer;
	cout << "Type a fully parenthesize arithmetic expression:"<<endl;
	answer = read_and_evaluate(cin);
	cout << "That evaluates to " <<answer<<endl;
	
	cin.ignore().get();
    return EXIT_SUCCESS;
}

double read_and_evaluate(istream& ins)
{
	const char DECIMAL = '.';
	const char RIGHT_PARENTHESIS =')';
	
	stack<double> numbers;
	stack<char> operations;
	double number;
	char symbol;
	
	while(ins && ins.peek()!='\n')
	{
		if (isdigit(ins.peek())|| (ins.peek()==DECIMAL)) 
		{
			ins>>number;
			numbers.push(number);
		}
		else if(strchr("+-*/", ins.peek()) !=NULL)
		{
			ins>>symbol;
			operations.push(symbol);
		}
		else if(ins.peek()==RIGHT_PARENTHESIS)
		{
			ins.ignore();
			evaluate_stack_tops(numbers,operations);
		}	
		else 
		{
			ins.ignore();
		}
		
	}
	return numbers.top();
}

void evaluate_stack_tops(stack<double>& numbers,stack<char>& operations)
{
	double operand1, operand2;
	
	operand2 = numbers.top();
	numbers.pop();
	operand1 = numbers.top();
	numbers.pop();
	switch (operations.top()) {
		case '+':
			numbers.push(operand1 + operand2);
			break;
		case '-':
			numbers.push(operand1 - operand2);
			break;
		case '/':
			numbers.push(operand1 / operand2);
			break;
		case '*':
			numbers.push(operand1 * operand2);
			break;
	}
	operations.pop();

}