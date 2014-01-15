package cc.libera.hellojo.model;

public class TestScore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Score myScore = new Score();
		myScore.resetScore();
		myScore.setScore("1");
		myScore.setScore("1");
		myScore.setScore("1");
		System.out.println(myScore.getScore());		

	}

}
