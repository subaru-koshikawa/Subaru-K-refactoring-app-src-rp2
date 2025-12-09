package jp.co.sss.crud.util;

public class ConstantMsg {
	/** インスタンス化を禁止 */
	private ConstantMsg() {
	}

	// ***** メッセージ・プロンプト *****

	/** システム名 */
	public static final String MSG_SYSTEM_NAME = "=== 社員管理システム ===";

	/** メニュー項目の文字列配列 */
	public static final String[] MENU_ITEMS = { "1.全件表示", "2.社員名検索", "3.部署ID検索", "4.新規登録", "5.更新", "6.削除", "7.終了" };

	/** メニュー番号入力プロンプト */
	public static final String MSG_PROMPT_MENU_NO = "メニュー番号を入力してください：";

	/** 社員名検索入力プロンプト */
	public static final String MSG_PROMPT_EMP_NAME = "検索する社員名を入力してください";

	/** 部署ID検索入力プロンプト */
	public static final String MSG_PROMPT_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";


	// ***** 登録（INSERT）関連のプロンプト *****
    /** 社員名入力プロンプト */
    public static final String MSG_PROMPT_INSERT_EMP_NAME = "社員名:";

    /** 性別入力プロンプト  */
    public static final String MSG_PROMPT_INSERT_GENDER = "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";

    /** 生年月日入力プロンプト */
    public static final String MSG_PROMPT_INSERT_BIRTHDAY = "生年月日(西暦年/月/日):";

    /** 部署ID入力プロンプト  */
    public static final String MSG_PROMPT_INSERT_DEPT_ID = "部署ID(1:営業部、2:経理部、3:総務部):";


 // ***** 更新（UPDATE）関連のプロンプト *****
	/** 更新対象ID入力プロンプト */
	public static final String MSG_PROMPT_UPDATE_ID = "更新する社員の社員IDを入力してください：";

	/** 更新完了メッセージ */
	public static final String MSG_UPDATE_COMPLETE = "社員情報を更新しました";


	/** 削除対象ID入力プロンプト */
	public static final String MSG_PROMPT_DELETE_ID = "削除する社員の社員IDを入力してください：";

	/** システム終了メッセージ */
	public static final String MSG_SYSTEM_EXIT = "システムを終了します。";

	
	
	// ***** 全件検索 *****
	/** 該当者なしメッセージ */
    public static final String MSG_NO_RESULT = "該当者はいませんでした";
    
    /** 全件表示ヘッダー */
    public static final String MSG_HEADER_ALL_EMP = "社員ID\t社員名\t性別\t生年月日\t部署名";
    
    /** 性別：回答なし (0) */
    public static final String GENDER_DISPLAY_NOT_ANSWER = "回答なし";
    
    /** 性別：男性 (1) */
    public static final String GENDER_DISPLAY_MALE = "男性";
    
    /** 性別：女性 (2) */
    public static final String GENDER_DISPLAY_FEMALE = "女性";
    
    /** 性別：その他 (9) */
    public static final String GENDER_DISPLAY_OTHER = "その他";
    
    /** 空行 */
    public static final String MSG_EMPTY_LINE = "";
	
	
}
