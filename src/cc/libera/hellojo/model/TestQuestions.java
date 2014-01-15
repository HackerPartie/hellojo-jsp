package cc.libera.hellojo.model;

import java.util.LinkedList;

public class TestQuestions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		for (int i=1; i < 13; i++) {
//		System.out.println(new Question().getShortText(i));
//		}
		
		LinkedList<Question> myQuestions = new LinkedList<Question>();
		Question myFirstQuestion = new Question();
		myFirstQuestion.setQuestionNumber(1);
		myQuestions.add(myFirstQuestion);
		
		
	}

}
