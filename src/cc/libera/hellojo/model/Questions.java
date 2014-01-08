package cc.libera.hellojo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import antlr.Version;

public class Questions {
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	String textQuestion;

	/**
	 * display a question from the question list
	 * 
	 * @param questionNumber
	 *            , from 1 to 12
	 * @param textType
	 *            , short or long
	 */
	public String getText(int questionNumber, String textType) {

		try {
			con = DB.openConnection();

			switch (textType) {
			case "short":
				pst = con
						.prepareStatement("SELECT shorttext FROM questions WHERE id=(?)");
				break;
			case "long":
				pst = con
						.prepareStatement("SELECT longtext FROM questions WHERE id=(?)");
				break;
			default:
				pst = con
						.prepareStatement("SELECT shorttext FROM questions WHERE id=(?)");
			}

			pst.setInt(1, questionNumber);
			rs = pst.executeQuery();
			if (rs.next()) {
				textQuestion = rs.getString(1);

			}

		} catch (SQLException e) {
			Logger lgr = Logger.getLogger(Version.class.getName());
			lgr.log(Level.WARNING, e.getMessage(), e);

		} finally {

			DB.closeConnection(rs, pst, con);

		}
		return textQuestion;
	}

}