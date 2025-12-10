package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeFindByDeptIdService implements IEmployeeService {

    private BufferedReader br;

    public EmployeeFindByDeptIdService(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void execute() throws SystemErrorException {
        try {
            System.out.print("検索する部署IDを入力してください: ");
            String deptIdStr = br.readLine();

            int deptId = Integer.parseInt(deptIdStr);

            List<Employee> employees = EmployeeDAO.findByDeptId(deptId);

            System.out.println("社員ID\t社員名\t性別\t生年月日\t部署ID\t部署名");
            for (Employee emp : employees) {
                System.out.println(emp);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("入力エラーです。");
        } catch (SQLException | ClassNotFoundException e) {
            throw new SystemErrorException("社員情報の取得に失敗しました。", e);
        }
    }
}
