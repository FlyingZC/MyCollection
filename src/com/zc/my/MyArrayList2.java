package com.zc.my;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MyArrayList2/* implements List*/{
	private Object[] elementData;
	private int size;
	//构造方法
	public MyArrayList2(){
		elementData=new Object[10];
	}
	
	public MyArrayList2(int initialCapacity){
		if(initialCapacity<0){
			throw new IllegalArgumentException("容量不对");
		}
		elementData=new Object[10];
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public boolean contains(Object o) {
		for(int i=0;i<size;i++){
			if(elementData[i].equals(o)){
				return true;
			}
		}
		return false;
	}

	public Iterator iterator() {
		return null;
	}

	public Object[] toArray() {
		Object[] dest=null;
		System.arraycopy(elementData, 0, dest, 0, size);
		return dest;
	}

	public Object[] toArray(Object[] a) {
		return toArray();
	}

	public boolean add(Object e) {
		if(size==elementData.length){
			//Arrays.copyOf()一定要将结果赋值
			elementData=Arrays.copyOf(elementData,size*2+1);
		}
		elementData[size++]=e;
		return true;//何时return false
	}

	
	public boolean remove(Object o) {
		for(int i=0;i<size;i++){
			if(get(i).equals(o)){
				remove(o);
				return true;
			}
		}
		return false;
	}

	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		elementData=null;
	}

	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	public Object set(int index, Object element) {
		rangeCheck(index);
		Object oldValue=elementData[index];
		elementData[index]=element;
		return oldValue;
	}

	public void add(int index, Object element) {
		rangeCheck(index);//范围检测
		ensureCapacity();//容量检测
	}

	private void ensureCapacity() {
		if(size==elementData.length){
			/*Object[] newArr=new Object[size*2+1];
			System.arraycopy(elementData,0,newArr,0,size);
			elementData=newArr;*/
			elementData=Arrays.copyOf(elementData,size*2+1);
		}
	}

	public Object remove(int index) {
		rangeCheck(index);
		Object oldValue=elementData[index];
		int moveCount=size-1-index;
		if(moveCount>0)
			System.arraycopy(elementData,index+1,elementData,index,moveCount);
		elementData[--size]=null;
		return oldValue;
	}

	private void rangeCheck(int index) {
		if(index<0||index>=size-1){
			throw new IllegalArgumentException("下标越界");
		}
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
