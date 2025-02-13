package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Member;
import model.Porder;
import service.PorderService;
import util.Tool;

public class PorderServiceImpl implements PorderService {
	private static PorderDaoImpl porderdaoimpl = new PorderDaoImpl();
	private static Member member = (Member) Tool.read("member.txt");
	public static int grandTotal = 0;

	public static void main(String[] args) {
	}

	@Override
	public void addPorder(Porder porder) {
		if (porder.getWrench() >= 0 && porder.getPail() >= 0 && porder.getHose() >= 0) {
			porderdaoimpl.add(porder);
		}

	}

//	@Override
//	public String AllPorder() {
//		List<Porder> l = porderdaoimpl.selectAll();
//		String show = "";
//		for (Porder p : l) {
//			int sum = p.getWrench() * 200 + p.getPail() * 150 + p.getHose() * 250;
//			show = show + "訂單編號:"+p.getId()+"  "+"  客戶名稱:"+p.getName() +"\n\t板手:"+ p.getWrench() +"\t水桶:"
//					+p.getPail()+"\t水管:"+p.getHose()+"\t"+ sum +"元\n";
//			System.out.println(show);
//		}
//		System.out.println("Final show content:\n" + show);
//		return show;
//		
//	}

	public String AllPorder() {
		List<Porder> l = porderdaoimpl.selectAll();
		StringBuilder show = new StringBuilder();
		grandTotal = 0;
		for (Porder p : l) {
			int sum = p.getWrench() * 200 + p.getPail() * 150 + p.getHose() * 250;
			grandTotal += sum;
			show.append("訂單編號:").append(p.getId()).append("  客戶名稱:").append(p.getName()).append("\n\t板手:")
					.append(p.getWrench()).append("\t水桶:").append(p.getPail()).append("\t水管:").append(p.getHose())
					.append("\t").append(sum).append("元\n");
		}

		System.out.println(show.toString());

		String finalBill = "總結帳單:\n" + show.toString() + "總金額: " + grandTotal + "元";
		System.out.println(finalBill);

		return finalBill;
	}
	

	@Override
	public List<Porder> findAllPoredor() {

		return porderdaoimpl.selectAll();
	}

	@Override
	public Porder findById(int id) {
		Porder porder = null;
		if (id > 0) {
			List<Porder> l = porderdaoimpl.selectById(id);
			if (l.size() > 0) {
				porder = l.get(0);
			}
		}
		return porder;
	}

	@Override
	public void updatePorder(String name, int id) {
		Porder p = findById(id);
		p.setName(name);
		porderdaoimpl.update(p);

	}

	@Override
	public void updatePorder(int wrench, int pail, int hose, int id) {
		Porder p = findById(id);
		System.out.println(p);
		p.setWrench(wrench);
		p.setPail(pail);
		p.setHose(hose);
		porderdaoimpl.update(p);

	}

	public void updatePorder2(String name, int wrench, int pail, int hose, int id) {
		Porder p = findById(id);
		System.out.println(p);
		p.setName(name);
		p.setWrench(wrench);
		p.setPail(pail);
		p.setHose(hose);
		porderdaoimpl.update(p);

	}

	@Override
	public void updatePorder(Porder porder) {
		Porder p = findById(porder.getId());

	}

	@Override
	public void deletePorderById(int id) {
		if (id > 0) {
			porderdaoimpl.delete(id);
		}

	}

}
