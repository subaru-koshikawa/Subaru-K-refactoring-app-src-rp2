package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;

public class EmployeeUpdateService implements IEmployeeService {

    private BufferedReader br;

    public EmployeeUpdateService(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void execute() throws SystemErrorException {
        try {
            // 入力
            System.out.print("更新する社員ID: ");
            String empIdStr = br.readLine();
            int empId = Integer.parseInt(empIdStr);

            System.out.print("社員名: ");
            String empName = br.readLine();

            System.out.print("性別(1=男性,2=女性): ");
            String genderStr = br.readLine();
            int gender = Integer.parseInt(genderStr);

            System.out.print("生年月日(yyyy/MM/dd): ");
            String birthday = br.readLine();

            System.out.print("部署ID: ");
            String deptIdStr = br.readLine();
            int deptId = Integer.parseInt(deptIdStr);

            // Employeeオブジェクトに詰める
            Employee employee = new Employee();
            employee.setEmpId(empId);
            employee.setEmpName(empName);
            employee.setGender(gender);
            employee.setBirthday(birthday);

            Department dept = new Department();
            dept.setDeptId(deptId);
            employee.setDepartment(dept);

            // DAOを呼び出す
            EmployeeDAO.update(employee);

            System.out.println("社員情報を更新しました。");

        } catch (IOException  e) {
            System.out.println("入力エラーです。");
        } catch (SQLException | ClassNotFoundException e) {
            throw new SystemErrorException("社員情報の更新に失敗しました。", e);
        }
    }
}
