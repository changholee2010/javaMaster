package co.yedam.mybatis3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import co.yedam.mybatis3.common.SearchDTO;
import co.yedam.mybatis3.common.Utils;
import co.yedam.mybatis3.service.TxnService;
import co.yedam.mybatis3.service.TxnServiceMybatis;
import co.yedam.mybatis3.vo.ProductVO;

// 입출고 처리.
// 1.입고 2.출고 3.재고 9.상위
public class TxnExe {

	// 싱글톤 방식으로 생성.
	private static TxnExe instance = new TxnExe();

	private TxnExe() {
	}

	public static TxnExe getInstance() {
		return instance;
	}

	// 필요한 변수 선언.
	Scanner scn = new Scanner(System.in);
	TxnService svc = new TxnServiceMybatis();
	SearchDTO search = new SearchDTO();

	void start() {
		boolean run = true;

		while (run) {
			System.out.println("-------------------------------");
			System.out.println("1.입고 2.출고 3.재고 9.상위메뉴로 이동");
			System.out.println("-------------------------------");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				AppMain.scr("입고를 선택했습니다.");
				receipt();
				break;
			case 2:
				AppMain.scr("출고를 선택했습니다.");
				issue();
				break;
			case 3:
				AppMain.scr("재고를 선택했습니다.");
				onHand();
				break;
			case 9:
				AppMain.scr("상위메뉴로 이동합니다.");
				return;
			default:
				System.out.println("메뉴를 다시 선택하세요!");
			}

		} // end of while
	} // end of exe()

	void receipt() {
		int rowCnt = 1;
		System.out.print("입고할 상품코드>> ");
		String prodCode = scn.nextLine();
		search.setProdCode(prodCode);

		// 목록을 보여주고 선택하도록 한다.
		List<ProductVO> list = svc.searchProduct(search);
		if (list.size() == 0) {
			System.out.println("목록이 없습니다.");
			return;
		}
		System.out.println("순번  상품코드   상품명        가격");
		System.out.println("--------------------------------");
		for (ProductVO pvo : list) {
			System.out.print(String.format("%3d ", rowCnt++));
			Utils.printWidth(5, " " + pvo.getProdCode());
			Utils.printWidth(15, "   " + pvo.getProdName());
			System.out.print(String.format(" %5d\n", pvo.getSellingPrice()));
		}

		System.out.print("입고할 상품코드>> ");
		prodCode = scn.nextLine();
		System.out.print("입고할 상품수량>> ");
		int prodQty = Integer.parseInt(scn.nextLine());

		Map<String, Object> map = new HashMap<>();
		map.put("code", prodCode);
		map.put("qty", prodQty);
		if (svc.inOutTransactions(map)) {
			System.out.println("정상 입고 완료.");
		}

	}

	void issue() {

	}

	void onHand() {
		search.setAllProduct("Y");
		System.out.println("---------------------------------------------------");
		System.out.println("상품코드    상품명          상품설명                  재고");
		System.out.println("---------------------------------------------------");
		svc.onhandList(search).forEach(product -> {
			System.out.print(String.format("%5s", product.getProdCode()));
			Utils.printWidth(15, "  " + product.getProdName());
			Utils.printWidth(26, "  " + product.getProdDesc());
			System.out.print(String.format(" %3d\n", product.getQty()));
		});
		System.out.println("---------------------------------------------------");
	}
}
