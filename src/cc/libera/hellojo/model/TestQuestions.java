package cc.libera.hellojo.model;

public class TestQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=1; i < 13; i++) {
		System.out.println(new Questions().getText(i, "bla"));
		}
	}

}
