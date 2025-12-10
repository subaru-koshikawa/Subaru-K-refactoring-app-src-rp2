package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;

/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class EmployeeDAO {

	/** インスタンス化を禁止 */
	private EmployeeDAO() {
	}

	/**
	 * 全ての商品情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static void findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement("SELECT * FROM employee");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				System.out.println("該当商品はありませんでした");
				return;
			}

			// レコードを出力
			System.out.println("商品ID\t商品名\t価格");
			while (resultSet.next()) {
				System.out.print(resultSet.getString("id") + "\t");
				System.out.print(resultSet.getString("item_name") + "\t");
				System.out.print(resultSet.getString("price") + "\t");
				System.out.println();
			}
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 全ての商品情報を検索（DTO併用）
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	// SystemErrorException エラー出る

	public static List<Employee> findAllEmployee() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement("SELECT * FROM employee");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// レコードを出力
			while (resultSet.next()) {
				Department department = new Department();
				department.setDeptId(resultSet.getInt("dept_id"));
				department.setDeptName(resultSet.getString("dept_name"));

				Employee employee = new Employee();

				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));

				employee.setDepartment(department);
				employees.add(employee);
			}

			return employees;

		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

	}

	/** 社員名検索 */
	public static List<Employee> findByEmpName(String searchName)
			throws SQLException, ClassNotFoundException, SystemErrorException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();

		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement("SELECT * FROM employee WHERE emp_name LIKE ?");
			ps.setString(1, "%" + searchName + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				Department dept = new Department();
				dept.setDeptId(rs.getInt("dept_id"));
				dept.setDeptName(rs.getString("dept_name"));

				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setGender(rs.getInt("gender"));
				emp.setBirthday(rs.getString("birthday"));
				emp.setDepartment(dept);

				list.add(emp);
			}
			return list;
		} finally {
			DBManager.close(rs);
			DBManager.close(ps);
			DBManager.close(connection);
		}
	}

	/** 部署ID検索 */
	public static List<Employee> findByDeptId(int deptId)
			throws ClassNotFoundException, SQLException, SystemErrorException {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<>();

		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement("SELECT * FROM employee WHERE dept_id = ?");
			ps.setInt(1, deptId);
			rs = ps.executeQuery();

			while (rs.next()) {
				Department dept = new Department();
				dept.setDeptId(rs.getInt("dept_id"));
				dept.setDeptName(rs.getString("dept_name"));

				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setGender(rs.getInt("gender"));
				emp.setBirthday(rs.getString("birthday"));
				emp.setDepartment(dept);

				list.add(emp);
			}
			return list;
		} finally {
			DBManager.close(rs);
			DBManager.close(ps);
			DBManager.close(connection);
		}
	}

	/** 新規登録 */
	public static void insert(Employee employee) throws ClassNotFoundException, SQLException, SystemErrorException {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = DBManager.getConnection();
			ps = connection
					.prepareStatement("INSERT INTO employee(emp_name, gender, birthday, dept_id) VALUES (?, ?, ?, ?)");
			ps.setString(1, employee.getEmpName());
			ps.setInt(2, employee.getGender());
			ps.setString(3, employee.getBirthday());
			ps.setInt(4, employee.getDepartment().getDeptId());

			//return ps.executeUpdate() > 0;
		} finally {
			DBManager.close(ps);
			DBManager.close(connection);
		}
	}

	/** 更新 */
	public static boolean update(Employee employee) throws ClassNotFoundException, SQLException, SystemErrorException {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = DBManager.getConnection();
			ps = connection
					.prepareStatement("UPDATE employee SET emp_name=?, gender=?, birthday=?, dept_id=? WHERE emp_id=?");
			ps.setString(1, employee.getEmpName());
			ps.setInt(2, employee.getGender());
			ps.setString(3, employee.getBirthday());
			ps.setInt(4, employee.getDepartment().getDeptId());
			ps.setInt(5, employee.getEmpId());

			return ps.executeUpdate() > 0;
		} finally {
			DBManager.close(ps);
			DBManager.close(connection);
		}
	}

	/** 削除 */
	public static boolean delete(int empId) throws ClassNotFoundException, SQLException, SystemErrorException {
		Connection connection = null;
		PreparedStatement ps = null;

		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement("DELETE FROM employee WHERE emp_id = ?");
			ps.setInt(1, empId);

			return ps.executeUpdate() > 0;
		} finally {
			DBManager.close(ps);
			DBManager.close(connection);
		}
	}
}
