
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableProcedure{
	public static void main(String args[]) {
		try {
			String url = "jdbc:sqlserver://LAPTOP-IVO2FEIG;databaseName=Exam;integratedSecurity=true;encrypt=false";
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connection Successful");
			String sql = "{call CheckCustomerData(?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                // Set input parameter
                stmt.setString(1, "LP001011"); 

                // Execute the stored procedure
                ResultSet rs = stmt.executeQuery();

                // Process the result set
                while (rs.next()) {
                    String Loan_Id = rs.getString("Loan_ID");
                    String Gender = rs.getString("Gender");
                    String Marriage_Status = rs.getString("Married");
                    String Dependents = rs.getString("Dependents");
                    String Education = rs.getString("Education");
                    String Self_Employed = rs.getString("Self_Employed");
                    int Income = rs.getInt("ApplicantIncome");
                    String Property_Area_Type = rs.getString("Property_Area");
                    int Credit_History = rs.getInt("Credit_History");
                    // Retrieve other columns as needed

                    System.out.println("Loan ID: " + Loan_Id);
                    System.out.println("Income: " + Income);
                    System.out.println("Credit History: " + Credit_History);
                    System.out.println("Gender: " + Gender);
                    System.out.println("Marriage Status: " + Marriage_Status);
                    System.out.println("Dependents: " + Dependents);
                    System.out.println("Education: " + Education);
                    System.out.println("Self Employed: " + Self_Employed);
                    System.out.println("Property Area Type: " + Property_Area_Type);
           
                }
            
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
