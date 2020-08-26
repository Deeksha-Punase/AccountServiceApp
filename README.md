# AccountServiceApp

This is Account Service providing cusomer specific information. It included three APIs :
1) account/customer/{id} GET Method --> takes input from user as CustomerId and return the response with the folllowing details like account number, account type, is active, balance. If user deosn't exist a msg will be return saying "User Deosn't Exist".
2) account/customer/activeCheck Get Method --> returns list of all active customers.
3) account/customerDetails/add  Post Method ->  for adding the customer information , takes input as list and return response as added or exception occurred.


Runs on port : 8080
Uses in memory H2 database (data.sql with insert scripts provided in resources section.) 
