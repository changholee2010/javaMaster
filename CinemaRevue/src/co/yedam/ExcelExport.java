package co.yedam;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import co.yedam.dao.BoardDAO;
import co.yedam.vo.BoardVO;

public class ExcelExport {
	BoardDAO bdao = new BoardDAO();

	void createExcel() {
		System.out.println("start.");

		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("게시글목록");

		int rowNo = 0;
		Row headerRow = sheet.createRow(rowNo++);
		headerRow.createCell(0).setCellValue("글번호");
		headerRow.createCell(1).setCellValue("작성자");
		headerRow.createCell(2).setCellValue("제목");
		headerRow.createCell(3).setCellValue("조회수");

		List<BoardVO> list = bdao.boardAll(null);
		for (BoardVO bvo : list) {
			Row row = sheet.createRow(rowNo++);
			row.createCell(0).setCellValue(bvo.getBoardNo());
			row.createCell(1).setCellValue(bvo.getWriter());
			row.createCell(2).setCellValue(bvo.getTitle());
			row.createCell(3).setCellValue(bvo.getViewCnt());

		}
		FileOutputStream fos;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String fileName = sdf.format(new Date());
		File file = new File("c:/temp/" + fileName + ".xls");

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end of prog.");

	} // end of excel.

}
