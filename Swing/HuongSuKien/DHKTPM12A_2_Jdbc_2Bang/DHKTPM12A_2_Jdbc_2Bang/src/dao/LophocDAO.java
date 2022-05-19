package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Lophoc;

public class LophocDAO {
	private Connection con;

	public LophocDAO() {
		con = MyConnection.getInstance().getConnection();
	}

	public List<Lophoc> getLophocs() throws SQLException {
		List<Lophoc> dslh = new ArrayList<Lophoc>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from Lophoc");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Lophoc lh = new Lophoc(rs.getString("malop"), rs.getString("tenlop"), rs.getInt("siso"), rs.getString("GVCN"));
				dslh.add(lh);
			}
		}catch (Exception e) {
			throw new SQLException(e);
		}
		return dslh;
	}
}
