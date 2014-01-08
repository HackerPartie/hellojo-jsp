package cc.libera.hellojo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cc.libera.hellojo.model.Questions;
import cc.libera.hellojo.model.Score;

/**
 * Servlet implementation class Calc
 */
@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher rdp;
    private Score myScore;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myScore = new Score();
		myScore.resetScore();
		prepareQuestion(request, response, 1);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get value bof the radio button of page n
		// add the value of radio button to score
		// creates a request dispatcher to page n+1
		// if radio button name is 12 then creates request dispatcher to result page
		
		if (request.getParameter("question1") != null) {
			myScore.saveScore(request.getParameter("question1"));
			prepareQuestion(request, response, 2);					
		}
		
		else if (request.getParameter("question2") != null) {
			myScore.saveScore(request.getParameter("question2"));
			prepareQuestion(request, response, 3);
		}
		
		else if (request.getParameter("question3") != null) {
			myScore.saveScore(request.getParameter("question3"));
			prepareQuestion(request, response, 4);
		}
		
		else if (request.getParameter("question4") != null) {
			myScore.saveScore(request.getParameter("question4"));
			prepareQuestion(request, response, 5);
		}
		
		else if (request.getParameter("question5") != null) {
			myScore.saveScore(request.getParameter("question5"));
			prepareQuestion(request, response, 6);
		}
		
		else if (request.getParameter("question6") != null) {
			myScore.saveScore(request.getParameter("question6"));
			prepareQuestion(request, response, 7);
		}
		
		else if (request.getParameter("question7") != null) {
			myScore.saveScore(request.getParameter("question7"));
			prepareQuestion(request, response, 8);
		}
		
		else if (request.getParameter("question8") != null) {
			myScore.saveScore(request.getParameter("question8"));
			prepareQuestion(request, response, 9);
		}
		
		else if (request.getParameter("question9") != null) {
			myScore.saveScore(request.getParameter("question9"));
			prepareQuestion(request, response, 10);
		}
		
		else if (request.getParameter("question10") != null) {
			myScore.saveScore(request.getParameter("question10"));
			prepareQuestion(request, response, 11);
		}
		
		else if (request.getParameter("question11") != null) {
			myScore.saveScore(request.getParameter("question11"));
			prepareQuestion(request, response, 12);
		}
		
		else if (request.getParameter("question12") != null) {
			myScore.saveScore(request.getParameter("question12"));
			request.setAttribute("sumScore", myScore.sumScore());
			rdp = request.getRequestDispatcher("/result.jsp");
			rdp.forward(request, response);
			
		}
		
	}
	private void prepareQuestion(HttpServletRequest request, HttpServletResponse response, int questionNumber)
			throws ServletException, IOException {
		request.setAttribute("questionNumber", String.valueOf(questionNumber));
		request.setAttribute("shortQuestion", new Questions().getText(questionNumber, "short"));
		request.setAttribute("longQuestion", new Questions().getText(questionNumber, "long"));
		rdp = request.getRequestDispatcher("/question.jsp");
		rdp.forward(request, response);	
	}
}
		


