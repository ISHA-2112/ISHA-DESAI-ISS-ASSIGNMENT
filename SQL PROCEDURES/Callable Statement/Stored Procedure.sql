create procedure CheckCustomerData @Loan_ID varchar(30)
as
select * from CustomerData where @Loan_ID = Loan_ID
go


