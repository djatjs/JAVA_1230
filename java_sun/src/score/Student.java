package score;

public class Student {
	private String name;
	private int score;
	
	
	// setter 같은 경우는 수정 기능 안쓸거여서 안넣음.
	public int getScore() {
		return score;
	}

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public void print() {
		System.out.println(name + " : " + score);
	}
}
