package cc.libera.hellojo.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import antlr.Version;

public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private int questionNumber;
	private String shortText;
	private String longText; 	

	public int getQuestionNumber() {
		return questionNumber;
	}
	
	public String getShortText() {
		return shortText;
	}
	
	public String getLongText() {
		return longText;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
		this.setShortText(questionNumber);
		this.setLongText(questionNumber);
	}

	/**
	 * display a the short text of a question
	 * 
	 * @param questionNumber
	 *            , from 1 to 12
	 */
	
	public void setShortText(int questionNumber) {

		try {
			con = DB.openConnection();
			pst = con.prepareStatement("SELECT shorttext FROM questions WHERE id=(?)");			
			pst.setInt(1, questionNumber);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				this.shortText = rs.getString(1);
			}

		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.WARNING, e.getMessage(), e);

		} finally {
			DB.closeConnection(rs, pst, con);

		}		
	}
	
	/**
	 * display a the short text of a question
	 * 
	 * @param questionNumber
	 *            , from 1 to 12
	 */
	public void setLongText(int questionNumber) {

		try {
			con = DB.openConnection();
			pst = con.prepareStatement("SELECT longtext FROM questions WHERE id=(?)");			
			pst.setInt(1, questionNumber);
			rs = pst.executeQuery();

			if (rs.next()) {
				longText = rs.getString(1);
			}

		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.WARNING, e.getMessage(), e);

		} finally {
			DB.closeConnection(rs, pst, con);
		}
		
	}


}