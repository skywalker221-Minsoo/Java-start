package Chap4;	//int형 큐

public class GQueue<E> {
	private int max;	//큐 용량
	private int front;	//첫번쨰 요소 커서
	private int rear;	//마지막 요소 커서, 데이터 맨 뒤의 한칸 뒤를 가리킨다.
	private int num;	//현재 데이터 수
	private E[] que;	//큐 본체
	
	//실행 시 예외: 큐가 비어 있음
	public static class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {}
	}
	
	//실행 시 예외: 큐가 가득 참
	public static class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {}
	}
	
	//생성자
	public GQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = (E[]) new Object[max];			//큐 본체용 배열을 생성
		} catch (OutOfMemoryError e) {	//생성할 수 없음
			max = 0;
		}
	}
	
	//큐에 데이터를 인큐
	public E enque(E x) throws OverflowIntQueueException {
		if (num >= max)
			throw new OverflowIntQueueException();	//큐가 가득 참
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}
	
	//큐에서 데이터를 디큐
	public E deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		E x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}
	
	//큐에서 데이터를 피크(프런트 데이터를 들여다봄)
	public E peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();	//큐가 비어있음.
		return que[front];
	}
	
	//큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
	public int indexOf(E x) {
		for (int i = 0; i < num; i++) {
			if (que[i + front] == x)	//검색 성공
				return i + front;
		}
		return -1;				//검색 실패
	}
	
	//큐를 비움
	public void clear() {
		num = front = rear = 0;
	}
	
	//큐의 용량을 반환
	public int capacity() {
		return max;
	}
	
	//큐에 쌓여 있는 데이터 수를 반환
	public int size() {
		return num;
	}
	
	//큐가 비어 있나요?
	public boolean isEmpty() {
		return num <= 0;
	}
	
	//큐가 가득 찼나요?
	public boolean isFull() {
		return num >= max;
	}
	
	//큐 안의 모든 데이터를 프런트 > 리어 순으로 출력
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max] + " ");
			System.out.println();
		}
	}
	
	//큐에서 x를 검색하여 머리부터 몇번째인가? 찾지 못하면 0 반환
	public int search(E x) {
		for (int i = 0; i < num; i++)
			if(que[(i + front) % max].equals(x)) //검색 성공
				return i + 1;
		return 0;
	}
}
