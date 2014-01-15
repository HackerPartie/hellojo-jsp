package cc.libera.hellojo.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Score implements Serializable{
	/** 
	 * a java bean for score saving
	 */
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	private int score;
	
	/**
	 * save the answer of a question as a String
	 * @param questionScore should be "0" or "1"
	 */
	public void setScore(String questionScore) {
		try {
			con = DB.openConnection();
			pst = con
					.prepareStatement("INSERT INTO score VALUES(default, (?))");
			pst.setInt(1,  Integer.parseInt(questionScore));
			pst.executeUpdate();
			
		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(Score.class.getName());
			lgr.log(Level.WARNING, e.getMessage(), e);
			
		} finally {
			DB.closeConnection(rs, pst, con);
		}
	}
	
	/**
	 * calculate a score based on questions 
	 * @return the score as a String
	 */
	public int getScore() {
		try {			
			con = DB.openConnection();
			pst = con.prepareStatement("SELECT answer FROM score");
			rs = pst.executeQuery();
			while (rs.next()) {
				score += rs.getInt(1);
			}			
			return score;
		
		
		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(Score.class.getName());
			lgr.log(Level.WARNING, e.getMessage(), e);
			return -1 ;
			
		} finally {
			DB.closeConnection(rs, pst, con);
		}
		
	}
	/**
	 * erase all saved scores in the database by means of "TRUNCATE table"
	 */
	public void resetScore() {
		try {
			con = DB.openConnection();
			pst = con.prepareStatement("TRUNCATE score");
			pst.executeUpdate();
		} catch (Exception e) {
			Logger lgr = Logger.getLogger(Question.class.getName());
			lgr.log(Level.WARNING, e.getMessage(), e);
		} finally {
			DB.closeConnection(rs, pst, con);
		}

	}
}
