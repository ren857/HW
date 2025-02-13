package dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Member;
import model.Porder;
import util.DbConnection;
import util.Tool;

public class PorderDaoImpl implements PorderDao {
	private static Connection conn = DbConnection.getDb();
	List<String> memberNames = Tool.readNames("member.txt");

	@Override
	public void add(Porder porder) {

		String Sql = "insert into porder(name,wrench,pail,hose)values(?,?,?,?)";
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(Sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getWrench());
			preparedstatement.setInt(3, porder.getPail());
			preparedstatement.setInt(4, porder.getHose());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	
	@Override
	public List<Porder> selectAll() {
		List<Porder> l = new ArrayList();
		
		System.out.println("Read member names: " + memberNames);
		for (String name : memberNames) {
			String sql = "select * from porder where name = ?";
			try {
				PreparedStatement preparedstatement = conn.prepareStatement(sql);
				preparedstatement.setString(1, name);
				// 調試信息：打印準備執行的查詢
				System.out.println("Executing query for name: " + name);
				ResultSet resultset = preparedstatement.executeQuery();
				while (resultset.next()) {
					Porder porder = new Porder();
					porder.setName(resultset.getString("name"));
					porder.setId(resultset.getInt("id"));
					porder.setWrench(resultset.getInt("wrench"));
					porder.setPail(resultset.getInt("pail"));
					porder.setHose(resultset.getInt("hose"));
					l.add(porder);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 調試信息：打印返回的訂單數量
	    System.out.println("Total orders found: " + l.size());
		return l;
	}

	/*private List<String> readMemberNames() {
		List<String> names = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("member.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				names.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return names;
	}*/

	@Override
	public List<Porder> selectById(int id) {
		String aql = "select*from porder where id=?";
		List<Porder> l = new ArrayList();
		PreparedStatement preparedstatement;
		try {
			preparedstatement = conn.prepareStatement(aql);
			preparedstatement.setInt(1, id);
			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				Porder porder = new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setWrench(resultset.getInt("wrench"));
				porder.setPail(resultset.getInt("pail"));
				porder.setHose(resultset.getInt("hose"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public void update(Porder porder) {
		String sql = "update porder set name=?,wrench=?,pail=?,hose=? where id=?";

		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getWrench());
			preparedstatement.setInt(3, porder.getPail());
			preparedstatement.setInt(4, porder.getHose());
			preparedstatement.setInt(5, porder.getId());

			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Override
	public void update2(Porder porder) {
		String sql = "INSERT INTO porder (name, wrench, pail, hose) VALUES (?, ?, ?, ?) ";

		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getWrench());
			preparedstatement.setInt(3, porder.getPail());
			preparedstatement.setInt(4, porder.getHose());
			preparedstatement.setInt(5, porder.getId());

			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void delete(int id) {
		String sql = "delete from porder where id=?";
		System.out.println(id);
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setInt(1,id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
