package StackAndQueue;	//int? ?

public class IntQueue {
	private int max;	//? ?©?
	private int front;	//μ²«λ²Β ?? μ»€μ
	private int rear;	//λ§μ?λ§? ?? μ»€μ, ?°?΄?° λ§? ?€? ?μΉ? ?€λ₯? κ°?λ¦¬ν¨?€.
	private int num;	//??¬ ?°?΄?° ?
	private int[] que;	//? λ³Έμ²΄
	
	//?€? ? ??Έ: ?κ°? λΉμ΄ ??
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {}
	}
	
	//?€? ? ??Έ: ?κ°? κ°?? μ°?
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	//??±?
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];			//? λ³Έμ²΄?© λ°°μ΄? ??±
		} catch (OutOfMemoryError e) {	//??±?  ? ??
			max = 0;
		}
	}
	
	//?? ?°?΄?°λ₯? ?Έ?
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= max)
			throw new OverflowIntQueueException();	//?κ°? κ°?? μ°?
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}
	
	//??? ?°?΄?°λ₯? ??
	public int deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}
	
	//??? ?°?΄?°λ₯? ?Ό?¬(??°?Έ ?°?΄?°λ₯? ?€?¬?€λ΄?)
	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();	//?κ°? λΉμ΄??.
		return que[front];
	}
	
	//??? xλ₯? κ²????¬ ?Έ?±?€(μ°Ύμ? λͺ»νλ©? -1)λ₯? λ°ν
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)	//κ²?? ?±κ³?
				return idx;
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
	public int search(int x) {
		for (int i = 0; i < num; i++)
			if(que[(i + front) % max] == x) //κ²?? ?±κ³?
				return i + 1;
		return 0;
	}
}