package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeDeleteService implements IEmployeeService {

    private BufferedReader br;

    // コンストラクタで BufferedReader を受け取る
    public EmployeeDeleteService(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void execute() throws SystemErrorException {
        try {
            System.out.print("削除する社員IDを入力してください: ");
            String empIdStr = br.readLine();

            int empId = Integer.parseInt(empIdStr);

            EmployeeDAO.delete(empId);
            System.out.println("社員情報を削除しました。");

        } catch (IOException | NumberFormatException e) {
            System.out.println("入力エラーです。");
        } catch (SQLException | ClassNotFoundException e) {
            throw new SystemErrorException("社員情報の削除に失敗しました。", e);
        }
    }
}
