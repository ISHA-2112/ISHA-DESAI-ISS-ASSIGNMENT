import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PreparedStatement {
	public static void main(String args[]) {
		try {
			String url = "jdbc:sqlserver://LAPTOP-IVO2FEIG;databaseName=Exam;integratedSecurity=true;encrypt=false";
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connection Successful");
			String sql = "insert into CustomerData (Loan_ID, Married,	Dependents, Education, Self_Employed,	ApplicantIncome, Gender, Property_Area, Credit_History) values(?,?,?,?,?,?,?,?,?);";
            
			String Loan_ID = "LP002995";
			String Marriage_Status = "Yes";
			String Dependents = "0";
			String Education = "Graduate";
			String Self_Employed = "Yes";
			int Income = 22345;
			String Gender = "Female";
			String Property_Area = "Urban";
			int Credit_History = 0; 
			try (CallableStatement stmt = conn.prepareCall(sql)) {
                // Set input parameter
                stmt.setString(1, Loan_ID); 
                stmt.setString(2, Marriage_Status); 
                stmt.setString(3, Dependents); 
                stmt.setString(4, Education); 
                stmt.setString(5, Self_Employed); 
                stmt.setInt(6, Income); 
                stmt.setString(7, Gender); 
                stmt.setString(8, Property_Area); 
                stmt.setInt(9, Credit_History); 
        
                
                // Execute the stored procedure
                stmt.execute();
                System.out.println("Record Inserted Successfully");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		}
		catch(SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
			
		}

	}
}
