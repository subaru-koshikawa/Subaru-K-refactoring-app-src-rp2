package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			System.out.println(ConstantMsg.MSG_SYSTEM_NAME);
			for (String item : ConstantMsg.MENU_ITEMS) {
				System.out.println(item);
			}
			System.out.print(ConstantMsg.MSG_PROMPT_MENU_NO);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.MENU_NO_FIND_ALL:
				// 全件表示機能の呼出
				DBController.findAllEmployees();
				break;

			case ConstantValue.MENU_NO_FIND_NAME:
				// 社員名検索
				System.out.print(ConstantMsg.MSG_PROMPT_EMP_NAME);

				// 検索機能の呼出
				DBController.findEmployeeByName();
				break;

			case ConstantValue.MENU_NO_FIND_DEPT:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.MSG_PROMPT_DEPT_ID);
				String searchDeptId = br.readLine();

				// 検索機能の呼出
				DBController.findEmployeeById(searchDeptId);
				break;

			case ConstantValue.MENU_NO_INSERT:
				// 登録する値を入力
				System.out.print(ConstantMsg.MSG_PROMPT_INSERT_EMP_NAME);
				String empName = br.readLine();
				System.out.print(ConstantMsg.MSG_PROMPT_INSERT_GENDER);
				String gender = br.readLine();
				System.out.print(ConstantMsg.MSG_PROMPT_INSERT_BIRTHDAY);
				String birthday = br.readLine();
				System.out.print(ConstantMsg.MSG_PROMPT_INSERT_DEPT_ID);
				// ↓変える必要あり？Bを消した
				String deptId = br.readLine();

				// 登録機能の呼出
				// どこの変数に繋がるのか?
				DBController.registerEmployee(empName, gender, birthday, deptId);
				break;

			case ConstantValue.MENU_NO_UPDATE:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.MSG_PROMPT_UPDATE_ID);

				// 更新する値を入力する
				String EmpIdToUpdate = br.readLine();
				Integer.parseInt(EmpIdToUpdate);

				// 更新機能の呼出
				DBController.updateEmployee(EmpIdToUpdate);
				System.out.println(ConstantMsg.MSG_UPDATE_COMPLETE);

				break;

			case ConstantValue.MENU_NO_DELETE:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.MSG_PROMPT_DELETE_ID);

				// 削除機能の呼出
				DBController.deleteEmployee();
				break;

			}
		} while (menuNo != ConstantValue.MENU_NO_EXIT);
		System.out.println(ConstantMsg.MSG_SYSTEM_EXIT);
	}
}
