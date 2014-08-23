package tdd.marsrover;

public class BigEngine implements Engine {

	public void left(int time) {
		System.out.println("Moving.......left");
	}

	public void right(int time) {
		System.out.println("Moving.......Right");
	}

	public int fordward(int time) {
		System.out.println("Moving........Forward");
		return 10;
	}

	public void backward(int time) {
		System.out.println("Moving........backward");
	}

}
