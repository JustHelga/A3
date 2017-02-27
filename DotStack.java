import java.lang.Object;
public class DotStack implements Stack<DotInfo>{
	
	public DotInfo[] dots;
	public int counter;
	private int size;
	private DotInfo temp;


	public DotStack (int size){

		this.size = size*size;
		dots = new DotInfo[this.size];
		counter = -1;



	}

	public boolean isEmpty(){
		return counter == -1;
	}

	public DotInfo peek(){
		return dots[counter];
	}

	public DotInfo pop(){
		temp = new DotInfo(dots[counter].getX(), dots[counter].getY(), dots[counter].getColor());
		temp.setCaptured(true);
		System.out.println(temp);
		dots[counter] = null;
		counter--;
		return temp;
	}

	public void push(DotInfo element){
		counter++;
		dots[counter] = element;

	}

}