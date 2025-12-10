//package jp.co.sss.crud.service;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import jp.co.sss.crud.db.EmployeeDAO;
//import jp.co.sss.crud.dto.Employee;
//import jp.co.sss.crud.exception.SystemErrorException;
//
///**
// * 全件検索サービス
// */
//public class EmployeeAllFindService implements IEmployeeService {
//
//    @Override
//    public void execute() throws SystemErrorException {
//
//        try {
//            // DAO から全社員情報を取得
//            List<Employee> employees = EmployeeDAO.findAllEmployee();
//
//            // 取得したデータの表示
//            System.out.println("社員ID\t社員名\t性別\t生年月日\t部署ID\t部署名");
//
//            for (Employee emp : employees) {
//                System.out.print(emp.getEmpId() + "\t");
//                System.out.print(emp.getEmpName() + "\t");
//
//                // 性別の文字変換
//                String genderStr = (emp.getGender() == 1) ? "男性" : "女性";
//                System.out.print(genderStr + "\t");
//
//                System.out.print(emp.getBirthday() + "\t");
//
//                // 部署情報
//                System.out.print(emp.getDepartment().getDeptId() + "\t");
//                System.out.print(emp.getDepartment().getDeptName());
//
//                System.out.println();
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//            // SQL系のエラーはすべて SystemErrorException に包んで投げる
//            throw new SystemErrorException("社員情報の取得に失敗しました。", e);
//        }
//    }
//}
package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 全件検索サービス
 */
public class EmployeeAllFindService implements IEmployeeService {



	@Override
    public void execute() throws SystemErrorException {

        try {
            // DAO から全社員情報を取得
            List<Employee> employees = EmployeeDAO.findAllEmployee();

            // 取得したデータの表示（定数使用）
            System.out.println(ConstantMsg.MSG_HEADER_ALL_EMP);

            for (Employee emp : employees) {
                System.out.print(emp.getEmpId() + "\t");
                System.out.print(emp.getEmpName() + "\t");

                // 性別の文字変換（定数使用）
                String genderStr = ConstantMsg.GENDER_DISPLAY_NOT_ANSWER; // デフォルト
                if (emp.getGender() == 1) genderStr = ConstantMsg.GENDER_DISPLAY_MALE;
                else if (emp.getGender() == 2) genderStr = ConstantMsg.GENDER_DISPLAY_FEMALE;
                else if (emp.getGender() == 9) genderStr = ConstantMsg.GENDER_DISPLAY_OTHER;
                System.out.print(genderStr + "\t");

                System.out.print(emp.getBirthday() + "\t");

                // 部署情報（定数使用）
                int deptId = emp.getDepartment().getDeptId();
                String deptName = ConstantMsg.DEPT_DISPLAY_GENERAL_AFFAIRS; // デフォルト
                if (deptId == 1) deptName = ConstantMsg.DEPT_DISPLAY_SALES;
                else if (deptId == 2) deptName = ConstantMsg.DEPT_DISPLAY_ACCOUNTING;
                else if (deptId == 3) deptName = ConstantMsg.DEPT_DISPLAY_GENERAL_AFFAIRS;

                System.out.print(deptId + "\t");
                System.out.print(deptName);

                System.out.println();
            }

        } catch (ClassNotFoundException | SQLException e) {
            // SQL系のエラーはすべて SystemErrorException に包んで投げる?
            throw new SystemErrorException("社員情報の取得に失敗しました。", e);
        }
    }
}
