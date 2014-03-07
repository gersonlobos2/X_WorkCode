#ifndef GERSON_H
#define GERSON_H
#include <cstdlib>
#include <cassert>

namespace GELA
{
	template <class Item>
	class bag
	{
	public:
		typedef Item value_type;
		typedef std::size_t size_type;
		static const size_type DEFAULT_CAPACITY=30;
		
		bag(size_type initial_capacity =DEFAULT_CAPACITY);
		bag(const bag& source);
		~bag();
		
		size_type erase(const Item& target);
		bool erase_one(const Item& target);
		
		void insert(const Item& entry);
		void operator =(const bag& source);
		void operator +=(const bag& addend);
		void reserve(size_type capacity);
		
		size_type count(const Item& target)const;
		Item grab()const;
		size_type size()const{return used;}
		
	private:
		Item *data;
		size_type used;
		size_type capacity;
		
	};
	
	template <class Item>
	bag<Item> operator+(const bag<Item>& b1,const bag<Item>& b2);
	

template <class Item>
const typename bag<Item>::size_type bag<Item>::DEFAULT_CAPACITY;

template<class Item>
bag<Item>::bag(size_type initial_capacity)
{
	data=new Item[initial_capacity];
	capacity=initial_capacity;
	used=0;
}

template<class Item>
	bag<Item>::bag(const bag<Item>& source)
{
	data= new Item[source.capacity];
	capacity=source.capacity;
	used=source.used;
	std::copy(source.data,source.data + used, data);
	
}

template<class Item>
bag<Item>::~bag()
{
	delete [] data;
	
}

template<class Item>
typename bag<Item>::size_type bag<Item>::erase(const Item& target)
{
	size_type index=0;
	size_type many_removed=0;
	
	while(index<used)
	{
		if(data[index]==target)
				{
					--used;
					data[index]=data[used];
					++many_removed;
				}
				else
				++index;
				}
				return many_removed;
				
				}
				
template<class Item>
bool bag<Item>::erase_one(const Item& target)
		{
			size_type index;
			index=0;
			
			while((index<used)&&(data[index]!=target))
				++index;
			
			if(index==used)
				return false;
			
			--used;
			data[index]=data[used];
			return true;
		}
				
template <class Item>
void bag<Item>::insert(const Item& entry)
		{
			if(used==capacity)
				reserve(used + 1);
			data[used] = entry;
			++used;
			
		}
				
				template <class Item>
				void bag<Item>::operator=(const bag<Item>& source)
		{
			//value_type *new_data;
			Item *new_data;
			
			if(this==&source)
				return;
			
			if(capacity != source.capacity)
			{
				//new_data= new value_type[source.capacity];
				new_data= new Item[source.capacity];
				delete [] data;
				data=new_data;
				capacity=source.capacity;
				
			}
			
			used =source.used;
			copy(source.data,source.data + used,data);
			
		}
				
				template <class Item>
				void bag<Item>::operator+=(const bag<Item>& addend)//. 
		{
			if(used + addend.used>capacity)
				reserved(used +addend.used);
			
			std::copy(addend.data,addend.data +addend.used, data+used);
			used+=addend.used;
			
		}
				
				template <class Item>
				void bag<Item>::reserve(size_type new_capacity)
		{
			value_type *larger_array;
			
			if(new_capacity==capacity)
				return;
			
			if(new_capacity<used)
				new_capacity=used;
			
			larger_array = new value_type[new_capacity];
			std::copy(data,data+used,larger_array);
			delete [] data;
			data=larger_array;
			capacity= new_capacity;
			
		}
				
template <class Item>
typename bag<Item>::size_type bag<Item>::count(const Item& target)const
		{
			size_type answer;
			size_type i;
			
			answer=0;
			
			for(i=0;i<used;++i)
				if(target==data[i])
					++answer;
			
			return answer;
		}
				
				template <class Item>
				Item bag<Item>::grab()const
		{
			size_type i;
			
			assert(size()>0);
			i=(std::rand()%size());
			return data[i];
			
		}
				
				template<class Item>
				bag<Item> operator+(const bag<Item>& b1, const bag<Item>& b2)
		{
			bag<Item> answer(b1.size(),b2.size());
			
			answer +=b1;
			answer+= b2;
			return answer;
		}
				
				}
				
#endif



