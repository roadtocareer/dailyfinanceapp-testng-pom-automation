# About this project
## Technology used:
- Language: Java
- Build System: Gradle
- Automation tool and framework: Selenium and TestNG
- Data manipulation: Simple JSON and CSV Parser
## Project Flow:
- Check if admin can login and see user data list
- Register new users
- Login by latest user
- Create daily expenditure
- See profile data
## How to run this project
- Clone the project
- Open the project from IntellIJ; File>Open>Select and expand folder>Open as project
- Hit this command: `gradle clean test -PsuiteName="regressionSuite.xml"` to run the regression suite or `gradle clean test -PsuiteName="smokeSuite.xml"`
- Generate Allure report:
- ``` allure generate allure-results --clean -output ```
   ``` allure serve allure-results ```

![image](https://github.com/user-attachments/assets/418ce0e7-82cd-465a-80dc-2147ddc152e6)

![image](https://github.com/user-attachments/assets/3aa346d1-ab2e-4a72-9244-220362ce97f7)
