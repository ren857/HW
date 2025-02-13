package service.impl;

import java.util.List;
import java.util.regex.Pattern;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	private static MemberDaoImpl memberdaoimpl = new MemberDaoImpl();

	public static void main(String[] args) {
	}

	@Override
	public void addMember(Member member) {
		
		if (isValidUsername(member.getUsername()) && isValidPassword(member.getPassword())) {
			memberdaoimpl.add(member);
		} else {
			System.out.println("Username or password format is invalid.");
		}
	}

	@Override
	public Member Login(String username, String password) {
		if (isValidUsername(username) && isValidPassword(password)) {
			Member member = null;

			List<Member> l = memberdaoimpl.selectUsernameAndPassword(username, password);

			if (l.size() != 0) {
				member = l.get(0);
			}
			return member;
		} else {
			System.out.println("Login failed due to invalid username or password.");
			return null;
		}
	}

	public boolean isUsernameBeenUse(String username) {
		return !memberdaoimpl.selectByUsername(username).isEmpty();
	}

	public boolean isValidUsername(String username) {
		// 檢查帳號是否包含英文字母和數字
		String regex = "^[A-Za-z][0-9A-Za-z]{0,11}$";
		return Pattern.matches(regex, username);
	}

	public boolean isValidPassword(String password) {
		// 檢查密碼是否僅包含數字
		String regex = "^\\d+$";
		return Pattern.matches(regex, password);
	}
	public boolean isValidPhone(String phone) {
		String regex = "^\\d+$";
		return Pattern.matches(regex, phone);
	}
	public boolean containsWhitespace(String str) {
		// 檢查是否包含空格
		return !str.contains(" ");
	}

}
