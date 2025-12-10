package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeRegisterService implements IEmployeeService {

    private BufferedReader br;

    public EmployeeRegisterService(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void execute() throws SystemErrorException {
        try {
            System.out.print("社員名: ");
            String empName = br.readLine();

            System.out.print("性別(1=男性,2=女性): ");
            int gender = Integer.parseInt(br.readLine());

            System.out.print("生年月日(yyyy/MM/dd): ");
            String birthday = br.readLine();

            System.out.print("部署ID: ");
            int deptId = Integer.parseInt(br.readLine());

            // Employeeオブジェクト作成
            Employee employee = new Employee();
            employee.setEmpName(empName);
            employee.setGender(gender);
            employee.setBirthday(birthday);

            Department dept = new Department();
            dept.setDeptId(deptId);
            employee.setDepartment(dept);

            // DAO呼び出し（Employeeを渡す）
            EmployeeDAO.insert(employee);

            System.out.println("社員情報を登録しました。");

        } catch (IOException e) {
            System.out.println("入力エラーです。");

        } catch (SQLException | ClassNotFoundException e) {
            throw new SystemErrorException("社員情報の登録に失敗しました。", e);
        }
    }
}
