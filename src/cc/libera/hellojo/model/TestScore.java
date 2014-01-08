package cc.libera.hellojo.model;

public class TestScore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Score myScore = new Score();
		myScore.resetScore();
		myScore.saveScore("1");
		myScore.saveScore("1");
		myScore.saveScore("1");
		System.out.println(myScore.sumScore());

	}

}
