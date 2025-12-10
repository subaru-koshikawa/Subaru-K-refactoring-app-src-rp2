package jp.co.sss.crud.util;

public class ConstantValue {
	/** インスタンス化を禁止 */
	private ConstantValue() {
	}

	// ***** メニュー番号 *****

	/** メニュー番号：全件表示 (1) */
	public static final int MENU_NO_FIND_ALL = 1;
	/** メニュー番号：社員名検索 (2) */
	public static final int MENU_NO_FIND_NAME = 2;
	/** メニュー番号：部署ID検索 (3) */
	public static final int MENU_NO_FIND_DEPT = 3;
	/** メニュー番号：新規登録 (4) */
	public static final int MENU_NO_INSERT = 4;
	/** メニュー番号：更新 (5) */
	public static final int MENU_NO_UPDATE = 5;
	/** メニュー番号：削除 (6) */
	public static final int MENU_NO_DELETE = 6;
	/** メニュー番号：終了 (7) */
	public static final int MENU_NO_EXIT = 7;

// *****全件検索のgenderの定数化******
	public static final int GENDER_CODE_NOT_ANSWER = 0;

	/** 性別コード：男性 (1) */
	public static final int GENDER_CODE_MALE = 1;

	/** 性別コード：女性 (2) */
	public static final int GENDER_CODE_FEMALE = 2;

	/** 性別コード：その他 (9) */
	public static final int GENDER_CODE_OTHER = 9;

	/** 部署IDコード：営業部 (1) */
	public static final int DEPT_CODE_SALES = 1;
	/** 部署IDコード：経理部 (2) */
	public static final int DEPT_CODE_ACCOUNTING = 2;
	/** 部署IDコード：総務部 (3) */
	public static final int DEPT_CODE_GENERAL_AFFAIRS = 3;

	public static final String DATE_FORMAT_PATTERN = "yyyy/MM/dd";

	public static final int MENU_SELECT_ALL = 1;
	public static final int MENU_SEARCH_EMP_NAME = 2;
	public static final int MENU_SEARCH_DEPT_ID = 3;
	public static final int MENU_INSERT = 4;
	public static final int MENU_UPDATE = 5;
	public static final int MENU_DELETE = 6;

}
