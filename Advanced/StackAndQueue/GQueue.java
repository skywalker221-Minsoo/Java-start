package StackAndQueue;	//int? ?

public class GQueue<E> {
	private int max;	//? ?©?
	private int front;	//μ²«λ²Β ?? μ»€μ
	private int rear;	//λ§μ?λ§? ?? μ»€μ, ?°?΄?° λ§? ?€? ?μΉ? ?€λ₯? κ°?λ¦¬ν¨?€.
	private int num;	//??¬ ?°?΄?° ?
	private E[] que;	//? λ³Έμ²΄
	
	//?€? ? ??Έ: ?κ°? λΉμ΄ ??
	public static class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {}
	}
	
	//?€? ? ??Έ: ?κ°? κ°?? μ°?
	public static class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	//??±?
	public GQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = (E[]) new Object[max];			//? λ³Έμ²΄?© λ°°μ΄? ??±
		} catch (OutOfMemoryError e) {	//??±?  ? ??
			max = 0;
		}
	}
	
	//?? ?°?΄?°λ₯? ?Έ?
	public E enque(E x) throws OverflowIntQueueException {
		if (num >= max)
			throw new OverflowIntQueueException();	//?κ°? κ°?? μ°?
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}
	
	//??? ?°?΄?°λ₯? ??
	public E deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		E x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}
	
	//??? ?°?΄?°λ₯? ?Ό?¬(??°?Έ ?°?΄?°λ₯? ?€?¬?€λ΄?)
	public E peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();	//?κ°? λΉμ΄??.
		return que[front];
	}
	
	//??? xλ₯? κ²????¬ ?Έ?±?€(μ°Ύμ? λͺ»νλ©? -1)λ₯? λ°ν
	public int indexOf(E x) {
		for (int i = 0; i < num; i++) {
			if (que[i + front] == x)	//κ²?? ?±κ³?
				return i + front;
		}
		return -1;				//κ²?? ?€?¨
	}
	
	//?λ₯? λΉμ?
	public void clear() {
		num = front = rear = 0;
	}
	
	//?? ?©?? λ°ν
	public int capacity() {
		return max;
	}
	
	//?? ??¬ ?? ?°?΄?° ?λ₯? λ°ν
	public int size() {
		return num;
	}
	
	//?κ°? λΉμ΄ ????
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//?κ°? κ°?? μ°Όλ??
	public boolean isFull() {
		return num >= max;
	}
	
	//? ?? λͺ¨λ  ?°?΄?°λ₯? ??°?Έ > λ¦¬μ΄ ??Όλ‘? μΆλ ₯
	public void dump() {
		if (num <= 0)
			System.out.println("?κ°? λΉμ΄ ??΅??€.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max] + " ");
			System.out.println();
		}
	}
	
	//??? xλ₯? κ²????¬ λ¨Έλ¦¬λΆ??° λͺλ²μ§ΈμΈκ°?? μ°Ύμ? λͺ»νλ©? 0 λ°ν
	public int search(E x) {
		for (int i = 0; i < num; i++)
			if(que[(i + front) % max].equals(x)) //κ²?? ?±κ³?
				return i + 1;
		return 0;
	}
}